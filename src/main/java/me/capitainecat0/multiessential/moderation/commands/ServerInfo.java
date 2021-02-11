package me.capitainecat0.multiessential.moderation.commands;

import me.capitainecat0.multiessential.MultiEssential;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerInfo implements CommandExecutor {
    public ServerInfo(MultiEssential instance) {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("serverinfo")) {
                if (!sender.hasPermission("multiessential.serverinfo") && !sender.hasPermission("multiessential.admin") && !sender.hasPermission("multiessential.*")) {
                    sender.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.serverinfo")));
                }else{
                    sender.sendMessage("§6Name: §c" + Bukkit.getServer().getName());
                    sender.sendMessage("§6IP &c/&6 Port: §c" + Bukkit.getServer().getIp() + Bukkit.getServer().getPort());
                    sender.sendMessage("§6Banned player's: §c" + Bukkit.getServer().getBannedPlayers().size());
                    sender.sendMessage("§6Jar: §c" + Bukkit.getServer().getVersion());
                    sender.sendMessage("§6Version: §c" + Bukkit.getServer().getBukkitVersion());
                    sender.sendMessage("§6Operators: §7(§c" + Bukkit.getServer().getOperators().size() + "§7) " + Bukkit.getServer().getOperators().toString());
                    sender.sendMessage("§6Whitelisted: §7(§c" + Bukkit.getServer().getWhitelistedPlayers().size() + "§7) " + Bukkit.getServer().getWhitelistedPlayers().toString());
                    sender.sendMessage("§6Connected player's: §c" + Bukkit.getServer().getOnlinePlayers().size() + "§e/ §c" + Bukkit.getServer().getMaxPlayers());
            }
        } return false;
    }
}
