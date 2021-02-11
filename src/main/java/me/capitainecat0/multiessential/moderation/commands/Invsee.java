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

public class Invsee implements CommandExecutor {
    public Invsee(MultiEssential instance) {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("invsee")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (!player.hasPermission("multiessential.invsee") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.invsee")));
                    if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                    }
                } else {
                    if (args.length <= 0) {
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("invsee.error")));
                        if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                        }
                    } else {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if (target instanceof Player) {
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("invsee.done").replace("{PLAYER}", target.getDisplayName())));
                            player.openInventory(target.getInventory());
                            if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                            }
                        } else {
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("messages.not_a_player").replace("{PLAYER}", args[0])));
                            if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                            }
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