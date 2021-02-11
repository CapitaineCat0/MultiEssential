package me.capitainecat0.multiessential.moderation.commands;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TP implements CommandExecutor {
    public TP(MultiEssential instance) {}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("tp")) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                if (!player.hasPermission("multiessential.tp") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.tp")));
                    if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100.0F, 1.0F);
                    }
                }
                if(args.length == 0) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("teleportation.tp.error.error")));
                    if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100.0F, 1.0F);
                    }
                }else if(args.length >=3) {
                    if (args.length == 3) {
                        int x;
                        int y;
                        int z;
                        try {
                            x = Integer.parseInt(args[0]);
                            y = Integer.parseInt(args[1]);
                            z = Integer.parseInt(args[2]);
                        } catch (NumberFormatException e) {
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("teleportation.tp.error.coordinates")));
                            return true;
                        }
                        player.teleport(new Location(player.getWorld(), x, y, z));
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("teleportation.tp.done.coordinates").replace("{LOCATION}", " X "
                                + x + " Y "
                                + y + " Z "
                                + z)));
                        return true;
                    }
                    if (args.length == 4) {
                        int x;
                        int y;
                        int z;
                        try {
                            x = Integer.parseInt(args[0]);
                            y = Integer.parseInt(args[1]);
                            z = Integer.parseInt(args[2]);
                        } catch (NumberFormatException e) {
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("teleportation.tp.error.coordinates")));
                            if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100.0F, 1.0F);
                            }
                            return true;
                        }
                        Player target = Bukkit.getPlayer(args[3]);
                        if (target == null || !target.isOnline()) {
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("messages.not_a_player").replace("{PLAYER}", args[0])));
                            if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100.0F, 1.0F);
                            }
                            return true;
                        }
                        target.teleport(new Location(player.getWorld(), x, y, z));
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("teleportation.tp.other.sender").replace("{PLAYER}", target.getDisplayName())
                                .replace("{LOCATION}", " X "
                                + x + " Y "
                                + y + " Z "
                                + z)));
                        target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("teleportation.tp.other.done").replace("{SENDER}", player.getDisplayName())
                                .replace("{LOCATION}", " X "
                                        + x + " Y "
                                        + y + " Z "
                                        + z)));
                        if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                            target.playSound(target.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                        }
                        if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                        }
                        return true;
                    }
                } else if (args.length >=1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target == null || !target.isOnline()) {
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("messages.not_a_player").replace("{PLAYER}", args[0])));
                        if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100.0F, 1.0F);
                        }
                        return true;
                    }
                    if (args.length == 2) {
                        Player target2 = Bukkit.getPlayer(args[1]);
                        if (target2 == null || !target2.isOnline()) {
                            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                    MultiEssential.getInstance().langConfig.getString("messages.not_a_player").replace("{PLAYER}", args[0])));
                            if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100.0F, 1.0F);
                            }
                            return true;
                        }
                        target.teleport(target2);
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("teleportation.tp.other.sender.player_to_other_done").replace("{PLAYER1}", target.getDisplayName())
                                        .replace("{PLAYER2}", target2.getDisplayName())));
                        target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("teleportation.tp.other.sender.player_to_other").replace("{PLAYER}", target.getDisplayName())
                                        .replace("{SENDER}", player.getDisplayName())));
                        return true;
                    }
                    player.teleport(target);
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("teleportation.tp.self").replace("{PLAYER}", target.getDisplayName())));
                    return true;
                } else {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("teleportation.tp.error.error")));
                    if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100.0F, 1.0F);
                    }
                }
            }
        }
        return true;
    }
}
