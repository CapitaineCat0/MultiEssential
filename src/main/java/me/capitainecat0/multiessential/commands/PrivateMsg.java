package me.capitainecat0.multiessential.commands;

import me.capitainecat0.multiessential.MultiEssential;
import me.capitainecat0.multiessential.utils.PrivateMessages;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrivateMsg implements CommandExecutor {
    public PrivateMsg(MultiEssential instance){}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player && args.length > 0) {
            if (cmd.getName().equalsIgnoreCase("msg") || cmd.getName().equalsIgnoreCase("w")) {
                if (Bukkit.getOfflinePlayer(args[0]).getPlayer() != null) {
                    Player msender = (Player) sender;
                    Player reciever = Bukkit.getOfflinePlayer(args[0]).getPlayer();
                    PrivateMessages.setReplyTarget(msender, reciever);
                    args[0] = "";
                    String msg = "";
                    for (int i = 0; i < args.length; i++) {
                        msg += " " + args[i];
                    }
                    msender.sendMessage(String.valueOf(MultiEssential.getInstance().langConfig.getString("messages.private.sender").replace("{SENDER}", msender.getDisplayName()).replace("{PLAYER}", reciever.getDisplayName()).replace("{MESSAGE}", msg)));
                    reciever.sendMessage(String.valueOf(MultiEssential.getInstance().langConfig.getString("messages.private.reciever").replace("{SENDER}", msender.getDisplayName()).replace("{PLAYER}", reciever.getDisplayName()).replace("{MESSAGE}", msg)));
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                        reciever.playSound(reciever.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                    }
                } else {
                    Player msender = (Player) sender;
                    msender.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("messages.not_a_player").replace("{PLAYER}", args[0])));
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                        msender.playSound(msender.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                    }
                }

            }else if(cmd.getName().equalsIgnoreCase("r")){
                Player msender = (Player) sender;
                if(PrivateMessages.getReplyTarget(msender) == null){
                    msender.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("messages.private.error").replace("{PLAYER}", args[0])));
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                        msender.playSound(msender.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                    }
                    return true;
                }
                Player reciever = PrivateMessages.getReplyTarget(msender);
                String msg = "";
                for (int i = 0; i < args.length; i++) {
                    msg += " " + args[i];
                }
                msender.sendMessage(String.valueOf(MultiEssential.getInstance().langConfig.getString("messages.private.sender").replace("{SENDER}", msender.getDisplayName()).replace("{PLAYER}", reciever.getDisplayName()).replace("{MESSAGE}", msg)));
                reciever.sendMessage(String.valueOf(MultiEssential.getInstance().langConfig.getString("messages.private.reciever").replace("{SENDER}", msender.getDisplayName()).replace("{PLAYER}", reciever.getDisplayName()).replace("{MESSAGE}", msg)));
                if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                    reciever.playSound(reciever.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                }

                return true;
            }
        }
        return false;
    }
}
