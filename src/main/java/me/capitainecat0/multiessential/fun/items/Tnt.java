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

public class Tnt implements CommandExecutor {
    public Tnt(MultiEssential instance) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if(sender instanceof Player){
                Player player = (Player)sender;
                if(cmd.getName().equalsIgnoreCase("tnt")){
                if(!player.hasPermission("multiessential.tnt") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")){
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.tnt")));
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                    }
                }else{
                    player.getInventory().addItem(ItemManager.tnt);
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                    }
                }
                }
            }else {
                ConsoleCommandSender console = Bukkit.getConsoleSender();
                console.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("messages.console")));
            }return true;
    }
}