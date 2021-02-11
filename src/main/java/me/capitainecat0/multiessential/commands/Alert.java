package me.capitainecat0.multiessential.commands;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Alert implements CommandExecutor {
    public Alert(MultiEssential instance){}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("alert")) {
            Player player = (Player)sender;
            if (!player.hasPermission("multiessential.alert") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                        MultiEssential.getInstance().langConfig.getString("permissions.alert")));
                if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                }
            } else {
                if (args.length == 0) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("alert.error")));
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                    }
                }

                if (args.length >= 1) {
                    StringBuilder bc = new StringBuilder();
                    for(String part : args) {
                        bc.append(part + " ");
                    }

                    Bukkit.broadcastMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getData("alert.anounce") + "&r "
                            + bc.toString()));
                }
            }
        } else if (cmd.getName().equalsIgnoreCase("bc") || cmd.getName().equalsIgnoreCase("broadcast")) {
            Player player = (Player)sender;
            if (!player.hasPermission("multiessential.bc") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                        MultiEssential.getInstance().langConfig.getString("permissions.bc")));
                if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                }
            } else {
                if (args.length == 0) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("bc.error")));
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                    }
                }

                if (args.length >= 1) {
                    StringBuilder bc = new StringBuilder();
                    for(String part : args) {
                        bc.append(part + " ");
                    }

                    Bukkit.broadcastMessage(MultiEssential.getInstance().formatText(bc.toString()));
                }
            }
        }

        return false;
    }
}