package me.capitainecat0.multiessential.utils;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class TradeListener implements Listener {
    public TradeListener() {}
    public TradeListener(TradeListener trade) {}
    public HashMap<Player, Player> PlayerTrade = new HashMap<>();

    public void addPlayerToList(Player player, Player target) {
        PlayerTrade.put(player, target);
    }
    public void onPlayerClick(InventoryClickEvent event){
        if(Objects.requireNonNull(event.getClickedInventory()).getType().name().equals(MultiEssential.getInstance().langConfig.getString("trade.inventory_name").replace("&", "§"))){
            Player player = (Player) event.getWhoClicked();
            if(PlayerTrade.containsKey(player)){
                if(event.getSlot() <= 8 || event.getSlot() == 17 || event.getSlot() >= 27){
                    if(event.getSlot() == 17){
                        accept(player, event.getCurrentItem());
                        event.setCancelled(true);
                    }
                }else{
                    event.setCancelled(true);
                }
            }else{
                if(event.getSlot() >= 17){
                    if (event.getSlot() == 17){
                        accept(player, event.getCurrentItem());
                        event.setCancelled(true);
                    }
                }else{
                    event.setCancelled(true);
                }
            }
        }
    }
    public void accept(Player player, ItemStack item){
        if(item.getType().equals(Material.RED_STAINED_GLASS_PANE)){
            item.setType(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(player.getDisplayName());
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            item.setItemMeta(meta);
        }else if(item.getType().equals(Material.GREEN_STAINED_GLASS_PANE)){
                if(item.getItemMeta().getDisplayName().equals(player.getDisplayName())){
                    item.setType(Material.RED_STAINED_GLASS_PANE);
                    ItemMeta meta = item.getItemMeta();
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.setDisplayName(null);
                    item.setItemMeta(meta);
                }else{
                    finishTrade(player.getOpenInventory().getTopInventory());
                }
        }
    }
    public void finishTrade(Inventory inv){
        List<HumanEntity> viewers = inv.getViewers();
        Player player;
        Player target;
        if(PlayerTrade.containsKey((Player) viewers.get(0))){
            player = (Player) viewers.get(0);
            target = (Player) viewers.get(1);
        }else{
            player = (Player) viewers.get(1);
            target = (Player) viewers.get(0);
        }
        player.closeInventory();
        target.closeInventory();
        for(int i = 0; i<9; i++){
            if(!inv.getItem(i).equals(null)){
                target.getInventory().addItem(inv.getItem(i));
            }
            if(!inv.getItem(i + 18).equals(null)){
                player.getInventory().addItem(inv.getItem(i + 18));
            }
        }
        PlayerTrade.remove(player);
    }
}
