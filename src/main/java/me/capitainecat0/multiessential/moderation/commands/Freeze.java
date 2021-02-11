package me.capitainecat0.multiessential.moderation.commands;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Freeze implements CommandExecutor {
    public Freeze(MultiEssential instance) {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("freeze")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (!player.hasPermission("multiessential.freeze") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.freeze")));
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                    }
                } else if (args.length == 1) {
                    String targetName = args[0];
                    if (Bukkit.getOfflinePlayer(targetName).getPlayer() != null) {
                        Player target = Bukkit.getPlayer(targetName);
                        if (MultiEssential.getInstance().frozenPlayers.containsKey(target)) {
                            MultiEssential.getInstance().frozenPlayers.remove(target);
                            target.setInvulnerable(false);
                            target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("freeze.target.unfrozen").replace("{SENDER}", player.getDisplayName())));
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("freeze.sender.unfrozen").replace("{PLAYER}", target.getDisplayName())));
                            if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                            }
                            if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                target.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 100, 1);
                            }
                        } else {
                            MultiEssential.getInstance().frozenPlayers.put(target, target.getLocation().clone());
                            target.setInvulnerable(true);
                            target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("freeze.target.frozen").replace("{SENDER}", player.getDisplayName())));
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("freeze.sender.frozen").replace("{PLAYER}", target.getDisplayName())));
                            if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                            }
                            if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                target.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                            }
                        }
                    }else {
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("messages.not_a_player").replace("{PLAYER}", args[0])));
                        if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                        }
                    }
                }
            }else{
                ConsoleCommandSender console = Bukkit.getConsoleSender();
                console.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("messages.console")));
            }
        }
        return false;
    }
}
