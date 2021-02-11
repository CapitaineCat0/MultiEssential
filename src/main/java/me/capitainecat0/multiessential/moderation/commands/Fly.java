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

public class Fly implements CommandExecutor {
    public Fly(MultiEssential instance) {}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("fly")) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                if (!player.hasPermission("multiessential.fly") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.fly")));
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                    }
                } else if (args.length == 0) {
                    if (player.getAllowFlight()) {
                        player.setAllowFlight(false);
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("fly.inactive")));
                        if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                        }
                    } else {
                        player.setAllowFlight(true);
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("fly.active")));
                        if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                        }
                    }
                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target instanceof Player) {
                        if (player.isOp() || player.hasPermission("multiessential.admin") || player.hasPermission("multiessential.*")){
                        if (target.getAllowFlight()) {
                            target.setAllowFlight(false);
                            target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("fly.other.inactive").replace("{SENDER}", player.getDisplayName())));
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("fly.sender.inactive").replace("{PLAYER}", target.getDisplayName())));
                            if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                            }
                            if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                target.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                            }
                        } else {
                            target.setAllowFlight(true);
                            target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("fly.other.active").replace("{SENDER}", player.getDisplayName())));
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("fly.sender.active").replace("{PLAYER}", target.getDisplayName())));
                            if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                            }
                            if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                target.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                            }
                        }
                    } else {
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("fly.error")));
                        }
                }else {
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("messages.not_a_player").replace("{PLAYER}", args[0])));
                        if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                        }
                    }
                }
            } else {
                ConsoleCommandSender console = Bukkit.getConsoleSender();
                console.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("messages.console")));
            }
        }
        return false;
    }
}
