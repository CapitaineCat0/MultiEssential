package me.capitainecat0.multiessential.moderation.commands;

import me.capitainecat0.multiessential.MultiEssential;
import net.capitainecat0.multiessential.api.InventoryAPI;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AdminInv implements CommandExecutor {
    public AdminInv(MultiEssential instance) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("admin")){
            if(sender instanceof Player){
                Player player = (Player)sender;
                InventoryAPI inv = InventoryAPI.create(MultiEssential.getInstance());
                inv.setTitle("§c§lAdmin §a- §e§lInventory");
                inv.setSize(9 * 6);
                inv.setBorder(new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1));
                inv.addItem(0, new ItemStack(Material.BARREL, 1), true, InventoryClickEvent -> {
                    player.sendMessage("§bTest");
                    player.closeInventory();
                });
            }
        }
        return false;
    }
}
