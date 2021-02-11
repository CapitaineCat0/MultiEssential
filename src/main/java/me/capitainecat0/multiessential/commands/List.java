package me.capitainecat0.multiessential.commands;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.Set;

public class List implements CommandExecutor {
    public List(MultiEssential instance) {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("list")){
            if (sender instanceof Player){
                Player player = (Player)sender;
                for (Player p : Bukkit.getOnlinePlayers()) {
                    player.sendMessage("§6Connected player's §c(" + Bukkit.getOnlinePlayers().size() + "§c) §6:");
                    player.sendMessage("  §c- " + p.getDisplayName());
                }
            }
        }
        return false;
    }
}