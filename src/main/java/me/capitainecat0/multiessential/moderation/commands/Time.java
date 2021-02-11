package me.capitainecat0.multiessential.moderation.commands;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Time implements CommandExecutor {
    public Time(MultiEssential instance) {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player)sender;
        Player players = (Player)Bukkit.getOnlinePlayers();
        World world = Bukkit.getWorld(players.getWorld().getName());
        if(!sender.hasPermission("multiessential.time") && !sender.hasPermission("multiessential.admin") && !sender.hasPermission("multiessential.*")) {
            sender.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                    MultiEssential.getInstance().langConfig.getString("permissions.time")));
            if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                if (sender instanceof Player) {
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                } else {
                    return true;
                }
            }
        }else {
            if (cmd.getName().equalsIgnoreCase("day")) {
                assert world != null;
                Bukkit.getWorld(world.getName()).setFullTime(0);
                sender.sendMessage(MultiEssential.getInstance().getConfig().getString("prefix").replace("&", "§") + "§r "
                        + MultiEssential.getInstance().langConfig.getString("time.day").replace("{WORLDNAME}", world.getName()));
                if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                    if (sender instanceof Player) {
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                    } else {
                        return true;
                    }
                }
            } else if (cmd.getName().equalsIgnoreCase("midday")) {
                Bukkit.getWorld(world.getName()).setFullTime(6000);
                sender.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                        MultiEssential.getInstance().langConfig.getString("time.midday").replace("{WORLDNAME}", world.getName())));
                if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                    if (sender instanceof Player) {
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                    } else {
                        return true;
                    }
                }
            } else if (cmd.getName().equalsIgnoreCase("night")) {
                Bukkit.getWorld(world.getName()).setFullTime(12000);
                sender.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                        MultiEssential.getInstance().langConfig.getString("time.night").replace("{WORLDNAME}", world.getName())));
                if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                    if (sender instanceof Player) {
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                    } else {
                        return true;
                    }
                }
            } else if (cmd.getName().equalsIgnoreCase("midnight")) {
                Bukkit.getWorld(world.getName()).setFullTime(18000);
                sender.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                        MultiEssential.getInstance().langConfig.getString("time.midnight").replace("{WORLDNAME}", world.getName())));
                if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                    if (sender instanceof Player) {
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                    } else {
                        return true;
                    }
                }
            }else if(cmd.getName().equalsIgnoreCase("time")){
                if(args.length <= 1){
                    sender.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("time.error").replace("{WORLDNAME}", world.getName())));
                    if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                        if (sender instanceof Player) {
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                        } else {
                            return true;
                        }
                    }
                }else{
                    if(args[0].equalsIgnoreCase("set")){
                        if(args.length == 2) {
                            Objects.requireNonNull(Bukkit.getWorld(world.getName())).setTime(Long.parseLong(String.valueOf(args[1])));
                            sender.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("time.set").replace("{WORLDNAME}", world.getName()).replace("{TICKS}", args[1])));
                            if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                                if (sender instanceof Player) {
                                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                                } else {
                                    return true;
                                }
                            }
                        }else{
                            sender.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("time.error")));
                            if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                                if (sender instanceof Player) {
                                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                                } else {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
