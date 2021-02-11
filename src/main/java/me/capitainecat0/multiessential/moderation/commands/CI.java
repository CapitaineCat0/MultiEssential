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

public class CI implements CommandExecutor {
    public CI(MultiEssential instance) {}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ci") || cmd.getName().equalsIgnoreCase("clear") || cmd.getName().equalsIgnoreCase("clearinv") || cmd.getName().equalsIgnoreCase("clearinventory")) {
            Player player = (Player) sender;
            if (!player.hasPermission("multiessential.clear") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                        MultiEssential.getInstance().langConfig.getString("permissions.clear")));
                if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                }
            } else if (args.length == 0) {
                player.getInventory().clear();
                player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                        MultiEssential.getInstance().langConfig.getString("clear.player")));
                if (MultiEssential.getInstance().langConfig.getBoolean("sounds.request")) {
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                }
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target instanceof Player) {
                    target.getInventory().clear();
                    target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("clear.other.done").replace("{SENDER}", player.getDisplayName())));
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("clear.other.sender").replace("{PLAYER}", target.getDisplayName())));
                    if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                    }
                    if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                        target.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
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
        return false;
    }
}
