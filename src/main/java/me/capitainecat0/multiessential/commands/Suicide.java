package me.capitainecat0.multiessential.commands;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Suicide implements CommandExecutor {
    public Suicide(MultiEssential instance) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("suicide")) {
            if (!sender.hasPermission("multiessential.suicide") && !sender.hasPermission("multiessential.admin") && !sender.hasPermission("multiessential.*")) {
                sender.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                        MultiEssential.getInstance().langConfig.getString("permissions.suicide")));
                if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                    } else {
                        return true;
                    }
                }
            } else {
                if (args.length <= 0) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        player.setHealth(0.0D);
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("suicide")));
                        if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                        }
                    }
                }
            }
        }
        return false;
    }
}
