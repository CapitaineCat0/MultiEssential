package me.capitainecat0.multiessential.fun.items;

import me.capitainecat0.multiessential.MultiEssential;
import me.capitainecat0.multiessential.fun.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class LePorte implements CommandExecutor {
    public LePorte() {
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            if(cmd.getName().equalsIgnoreCase("leporte")){
                if(!sender.hasPermission("multiessential.leporte")){
                }else{
                    player.getInventory().addItem(ItemManager.porte);
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                    }
                }
            }
        }
        return true;
    }
}