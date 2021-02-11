package me.capitainecat0.multiessential.commands;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Craft implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("craft") || cmd.getName().equalsIgnoreCase("workbench")){
            if(sender instanceof Player){
                Player player = (Player)sender;
                player.openWorkbench(player.getLocation(), true);
            }else {
                ConsoleCommandSender console = Bukkit.getConsoleSender();
                console.sendMessage(MultiEssential.getInstance().formatText((String) MultiEssential.getInstance().langConfig.getString("messages.console")));
            }
        }
        return false;
    }
}
