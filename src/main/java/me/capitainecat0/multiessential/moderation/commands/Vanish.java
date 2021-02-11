package me.capitainecat0.multiessential.moderation.commands;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Iterator;
import java.util.Set;

public class Vanish implements CommandExecutor {
    public Vanish(MultiEssential instance) {}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("vanish") || cmd.getName().equalsIgnoreCase("v")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (!player.hasPermission("multiessential.vanish") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.vanish")));
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                    }
                } else {
                    if (MultiEssential.getInstance().Vanish_List.contains(player)) {
                        Iterator i = Bukkit.getOnlinePlayers().iterator();

                        while (i.hasNext()) {
                            Player server = (Player) i.next();
                            server.showPlayer(MultiEssential.getInstance(), player);
                            player.setDisplayName(player.getDisplayName());
                        }
                        MultiEssential.getInstance().Vanish_List.remove(player);
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("vanish.disabled")));
                        if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                        }
                        MultiEssential.getInstance().getServer().broadcastMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("join.server")
                                .replace("{PLAYER}", player.getDisplayName())));
                    } else if (!MultiEssential.getInstance().Vanish_List.contains(player)) {
                        Iterator i = Bukkit.getOnlinePlayers().iterator();
                        Iterator iop = Bukkit.getOperators().iterator();

                        while (iop.hasNext()) {
                            Player operators = (Player) iop.next();
                            operators.showPlayer(MultiEssential.getInstance(), player);
                            player.setDisplayName(player.getDisplayName() + "§7vanished");
                        }
                        while (i.hasNext()) {
                            Player server = (Player) i.next();
                            server.hidePlayer(MultiEssential.getInstance(), player);
                        }
                        MultiEssential.getInstance().Vanish_List.add(player);
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("vanish.enabled")));
                        if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                        }
                        MultiEssential.getInstance().getServer().broadcastMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("leave.server")
                                .replace("{PLAYER}", player.getDisplayName())));
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

