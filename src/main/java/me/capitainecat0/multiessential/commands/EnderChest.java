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

public class EnderChest implements CommandExecutor {
    public EnderChest(MultiEssential instance) {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("enderchest") || cmd.getName().equalsIgnoreCase("ec")) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                if (args.length == 0) {
                    player.openInventory(player.getEnderChest());
                    if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100.0F, 1.0F);
                    }
                } else if (!player.hasPermission("multiessential.ec") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.enderchest")));
                    if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100.0F, 1.0F);
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
                        } else {
                            player.openInventory(target.getEnderChest());
                            player.getOpenInventory().getPlayer().getName();
                            if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100.0F, 1.0F);
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
                console.sendMessage(MultiEssential.getInstance().langConfig.getString("messages.console"));
            }
        }

        return true;
    }
}
