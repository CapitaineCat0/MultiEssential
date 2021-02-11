package me.capitainecat0.multiessential.fun.commands;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class Hat implements CommandExecutor {
    public Hat(MultiEssential instance) {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("hat")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (!player.hasPermission("multiessential.hat") && !player.hasPermission("multiessential.*")) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.hat")));
                }else {
                    ItemStack helmet = Objects.requireNonNull(player.getEquipment()).getHelmet();
                    ItemStack block = player.getEquipment().getItemInMainHand();
                    player.getEquipment().setHelmet(block);
                    player.getEquipment().setItemInMainHand(helmet);
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("hat.done")));
                    if (MultiEssential.getInstance().getConfig().getBoolean("sounds.request")) {
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                    }
                }
            }else {
                ConsoleCommandSender console = Bukkit.getConsoleSender();
                console.sendMessage(String.valueOf(MultiEssential.getInstance().langConfig.getString("messages.console")));
            }
        }return false;
    }
}
