package me.capitainecat0.multiessential.commands;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Heal implements CommandExecutor {
    public Heal(MultiEssential instance) {}
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                if (!player.hasPermission("multiessential.heal") && !player.hasPermission("multiessential.*")) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.heal")));
                    if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100.0F, 1.0F);
                    }
                } else if (args.length == 0) {
                    if (player.getHealth() == 20.0D) {
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("heal.already")));
                        if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100.0F, 1.0F);
                        }
                    } else {
                        player.setHealth(20.0D);
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("heal.done")));
                    }
                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target instanceof Player) {
                        if (!player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("permissions.admin")));
                            if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100.0F, 1.0F);
                            }
                        } else if (target.getHealth() == 20.0D) {
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("heal.other.already").replace("{PLAYER}", target.getDisplayName())));
                            if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100.0F, 1.0F);
                            }
                        } else {
                            target.setHealth(20.0D);
                            target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("heal.other.done").replace("{SENDER}", player.getDisplayName())));
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("heal.sender").replace("{PLAYER}", target.getDisplayName())));
                            if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100.0F, 1.0F);
                            }

                            if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                                target.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100.0F, 100.0F);
                            }
                        }
                    } else {
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("messages.not_a_player").replace("{PLAYER}", args[0])));
                        if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100.0F, 1.0F);
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
