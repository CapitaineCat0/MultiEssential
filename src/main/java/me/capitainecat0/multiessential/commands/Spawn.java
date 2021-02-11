package me.capitainecat0.multiessential.commands;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Objects;

public class Spawn implements CommandExecutor {
    public Spawn(MultiEssential instance){}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("spawn")) {
                Player player = (Player) sender;
                player.teleport(player.getWorld().getSpawnLocation());
                player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                        MultiEssential.getInstance().langConfig.getString("teleportation.spawn.done")));
                if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                }
            } else if (cmd.getName().equalsIgnoreCase("setspawn")) {
                Player player = (Player) sender;
                if (!player.hasPermission("multiessential.setspawn") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.setspawn")));
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                    }

                } else {
                    Location loc = player.getLocation();
                    Player players = (Player) Bukkit.getOnlinePlayers();
                    Bukkit.getServer().getWorld(players.getWorld().getName()).setSpawnLocation(loc);
                    Bukkit.getServer().setSpawnRadius(0);
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("teleportation.spawn.set").replace("{LOCATION}", " X "
                                    + player.getLocation().getX() + " Y "
                                    + player.getLocation().getY() + " Z "
                                    + player.getLocation().getZ()).replace("{WORLDNAME}", (CharSequence) Bukkit.getWorld(players.getWorld().getName()))));
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                    }
                    }
            }
        }
        return false;
    }
}