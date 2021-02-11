package me.capitainecat0.multiessential.moderation.commands;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
    public Gamemode(MultiEssential instance) {}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (!player.hasPermission("multiessential.gamemode") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.gamemode")));
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                    }
                } else {
                    if (args.length == 0) {
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("gamemode.error")));
                        if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                        }
                    } else {
                        if (args.length == 1) {
                            if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s") || args[0].equals("0")) {
                                player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                        MultiEssential.getInstance().langConfig.getString("gamemode.general").replace("{GAMEMODE}",
                                        MultiEssential.getInstance().langConfig.getString("gamemode.survival"))));
                                player.setGameMode(GameMode.SURVIVAL);
                                if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                                }
                            } else if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c") || args[0].equals("1")) {
                                player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                        MultiEssential.getInstance().langConfig.getString("gamemode.general").replace("{GAMEMODE}",
                                        MultiEssential.getInstance().langConfig.getString("gamemode.creative"))));
                                player.setGameMode(GameMode.CREATIVE);
                                if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                                }
                            } else if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a") || args[0].equals("2")) {
                                player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                        MultiEssential.getInstance().langConfig.getString("gamemode.general").replace("{GAMEMODE}",
                                        MultiEssential.getInstance().langConfig.getString("gamemode.adventure"))));
                                player.setGameMode(GameMode.ADVENTURE);
                                if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                                }
                            } else if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("spec") || args[0].equals("3")) {
                                player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                        MultiEssential.getInstance().langConfig.getString("gamemode.general").replace("{GAMEMODE}",
                                        MultiEssential.getInstance().langConfig.getString("gamemode.spectator"))));
                                player.setGameMode(GameMode.SPECTATOR);
                                if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                                }
                            }
                        } else {
                            Player target = Bukkit.getPlayerExact(args[1]);
                            if (target instanceof Player) {
                                if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")) {
                                    target.setGameMode(GameMode.SURVIVAL);
                                    target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                            MultiEssential.getInstance().langConfig.getString("gamemode.other.done").replace("{SENDER}", player.getDisplayName()).replace("{GAMEMODE}",
                                            MultiEssential.getInstance().langConfig.getString("gamemode.survival"))));
                                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                            MultiEssential.getInstance().langConfig.getString("gamemode.other.sender").replace("{PLAYER}", target.getDisplayName()).replace("{GAMEMODE}",
                                            MultiEssential.getInstance().langConfig.getString("gamemode.survival"))));
                                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                                    }
                                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                        target.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                                    }
                                } else if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")) {
                                    target.setGameMode(GameMode.CREATIVE);
                                    target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                            MultiEssential.getInstance().langConfig.getString("gamemode.other.done").replace("{SENDER}", player.getDisplayName()).replace("{GAMEMODE}",
                                            MultiEssential.getInstance().langConfig.getString("gamemode.creative"))));
                                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                            MultiEssential.getInstance().langConfig.getString("gamemode.other.sender").replace("{PLAYER}", target.getDisplayName()).replace("{GAMEMODE}",
                                            MultiEssential.getInstance().langConfig.getString("gamemode.creative"))));
                                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                                    }
                                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                        target.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                                    }
                                } else if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")) {
                                    target.setGameMode(GameMode.ADVENTURE);
                                    target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                            MultiEssential.getInstance().langConfig.getString("gamemode.other.done").replace("{SENDER}", player.getDisplayName()).replace("{GAMEMODE}",
                                            MultiEssential.getInstance().langConfig.getString("gamemode.adventure"))));
                                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                            MultiEssential.getInstance().langConfig.getString("gamemode.other.sender").replace("{PLAYER}", target.getDisplayName()).replace("{GAMEMODE}",
                                            MultiEssential.getInstance().langConfig.getString("gamemode.adventure"))));
                                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                                    }
                                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                        target.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                                    }
                                } else if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spec")) {
                                    target.setGameMode(GameMode.SPECTATOR);
                                    target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                            MultiEssential.getInstance().langConfig.getString("gamemode.other.done").replace("{SENDER}", player.getDisplayName()).replace("&", "§").replace("{GAMEMODE}",
                                            MultiEssential.getInstance().langConfig.getString("gamemode.spectator"))));
                                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                            MultiEssential.getInstance().langConfig.getString("gamemode.other.sender").replace("{PLAYER}", target.getDisplayName()).replace("{GAMEMODE}",
                                            MultiEssential.getInstance().langConfig.getString("gamemode.spectator"))));
                                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                                    }
                                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                        target.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                                    }
                                }
                            } else {
                                player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("messages.not_a_player").replace("{PLAYER}", args[1])));
                                if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                                }
                            }
                        }
                    }
                }
            } else{
                ConsoleCommandSender console = Bukkit.getConsoleSender();
                console.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("messages.console")));
            }
        }return false;
    }
}
