package me.capitainecat0.multiessential.moderation.commands;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Whois_old implements CommandExecutor {
    public Whois_old(MultiEssential instance) {}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("whois")) {
                Player player = (Player)sender;
                Player target = Bukkit.getPlayerExact(args[0]);
                OfflinePlayer offline = Bukkit.getOfflinePlayer(args[0]);
                //UUID uuid = new UUID(Bukkit.getOfflinePlayer(args[0]).getUniqueId(),);
                if (!player.hasPermission("multiessential.whois") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                    player.sendMessage(MultiEssential.getInstance().getConfig().getString("prefix").replace("&", "§") + "§r "
                            + MultiEssential.getInstance().getConfig().getString("permissions.whois").replace("&", "§"));
                    if (target instanceof Player) {
                        player.sendMessage("§6Pseudo§8: §c" + target.getDisplayName());
                        player.sendMessage("§6Pseudo serveur§8: §a" + target.getCustomName());
                        player.sendMessage("§6Liste de pseudo§8: §f" + target.getPlayerListName());
                        player.sendMessage("§6UUID§8: §e" + target.getUniqueId());
                        player.sendMessage("§6Adresse§8: §c" + target.getAddress());
                        player.sendMessage("§6Coordonées§8: §eX §c" + target.getLocation().getX() + " §eY§c "
                                + target.getLocation().getY() + " §eZ§c "
                                + target.getLocation().getZ());
                        player.sendMessage("§6Monde§8: §5" + target.getWorld());
                        player.sendMessage("§6Fly-mode§8: §a" + target.getAllowFlight());
                        player.sendMessage("§6Mode de jeu§8: §d" + target.getGameMode());
                        player.sendMessage("§6Invulnérable§8: §e" + target.isInvulnerable());
                        player.sendMessage("§6Opérateur§8: §b" + target.isOp());
                        player.sendMessage("§6Whitelisté§8: §f" + target.isWhitelisted());
                        } else {
                        player.sendMessage(MultiEssential.getInstance().getConfig().getString("prefix").replace("&", "§") + "§r "
                                + MultiEssential.getInstance().getConfig().getString("messages.not_a_player").replace("&", "§"));
                    }if (Bukkit.getOfflinePlayer(String.valueOf(offline)) != null) {
                        player.sendMessage("§6Pseudo§8: §c" + ((Player) offline).getDisplayName());
                        player.sendMessage("§6Pseudo serveur§8: §a" + ((Player) offline).getCustomName());
                        player.sendMessage("§6Liste de pseudo§8: §f" + ((Player) offline).getPlayerListName());
                        player.sendMessage("§6UUID§8: §e" + ((Player) offline).getUniqueId());
                        player.sendMessage("§6Adresse§8: §c" + ((Player) offline).getAddress());
                        player.sendMessage("§6Fly-mode§8: §a" + ((Player) offline).getAllowFlight());
                        player.sendMessage("§6Mode de jeu§8: §d" + ((Player) offline).getGameMode());
                        player.sendMessage("§6Invulnérable§8: §e" + ((Player) offline).isInvulnerable());
                        player.sendMessage("§6Opérateur§8: §b" + ((Player) offline).isOp());
                        player.sendMessage("§6En ligne§8: §a" + ((Player) offline).isOnline());
                        player.sendMessage("§6Bannis§8: §3" + ((Player) offline).isBanned());
                        player.sendMessage("§6Whitelisté§8: §f" + ((Player) offline).isWhitelisted());
                    } else {
                        player.sendMessage(MultiEssential.getInstance().getConfig().getString("prefix").replace("&", "§") + "§r "
                                + MultiEssential.getInstance().getConfig().getString("messages.not_a_player").replace("&", "§"));
                    }
                }
            } return false;
        }
}
