package me.capitainecat0.multiessential.moderation.commands;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Nick implements CommandExecutor {
    public Nick(MultiEssential instance) {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("multiessential.nick") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                        MultiEssential.getInstance().langConfig.getString("permissions.nick")));
                if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                }
            } else {
                if (cmd.getName().equalsIgnoreCase("nick")) {
                    if (args.length == 0) {
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("nick.error")));
                        if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                        }
                    } else {
                        String nick = "";
                        for (String arg : args) {
                            nick += args[0];
                        }
                        player.setDisplayName(nick);
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("nick.set").replace("{NICKNAME}", nick)));
                        if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                        }
                    }
                }
            }
        }return false;
    }
}
