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

public class God implements CommandExecutor {
    public God(MultiEssential instance) { }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("god")) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                if (!player.hasPermission("multiessential.god") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.god")));
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                    }
                } else if (args.length == 0) {
                    if (player.isInvulnerable()) {
                        player.setInvulnerable(false);
                        player.setGlowing(false);
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("god.inactive")));
                        if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                        }
                    } else {
                        player.setInvulnerable(true);
                        player.setFoodLevel(20);
                        player.setHealth(20);
                        player.setGlowing(true);
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("god.active")));
                        if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                        }
                    }
                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target instanceof Player) {
                        if (target.isInvulnerable()) {
                            target.setInvulnerable(false);
                            target.setGlowing(false);
                            target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("god.other.inactive").replace("{SENDER}", player.getDisplayName())));
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("god.sender.inactive").replace("{PLAYER}", target.getDisplayName())));
                            if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                            }
                            if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                target.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                            }
                        } else {
                            target.setInvulnerable(true);;
                            target.setHealth(20);
                            target.setFoodLevel(20);
                            target.setGlowing(true);
                            target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("god.other.active").replace("{SENDER}", player.getDisplayName())));
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("god.sender.active").replace("{PLAYER}", target.getDisplayName())));
                            if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                            }
                            if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                target.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                            }
                        }
                    } else {
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
