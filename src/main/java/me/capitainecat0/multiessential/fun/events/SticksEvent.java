package me.capitainecat0.multiessential.fun.events;

import me.capitainecat0.multiessential.MultiEssential;
import me.capitainecat0.multiessential.fun.ItemManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;
import java.util.Set;

public class SticksEvent implements Listener {
    public SticksEvent(MultiEssential instance) {}

    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.lightning.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.getWorld().strikeLightning(player.getTargetBlock(null, MultiEssential.getInstance().itemsConfig.getInt("lightning.distance")).getLocation());
                }else if(event.getItem().getItemMeta().equals(ItemManager.tnt.getItemMeta())){
                    Player player = event.getPlayer();
                    player.getWorld().spawnEntity(player.getTargetBlock(null, MultiEssential.getInstance().itemsConfig.getInt("tnt.distance")).getLocation(), EntityType.PRIMED_TNT);
                }
            }
        }
    }

    @EventHandler
    public static void onDrop(PlayerDropItemEvent event) {
        if (event.getItemDrop().equals(ItemManager.lightning.getItemMeta())) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                    MultiEssential.getInstance().langConfig.getString("messages.drop_item")));
        }else if(event.getItemDrop().equals(ItemManager.kb.getItemMeta())) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                    MultiEssential.getInstance().langConfig.getString("messages.drop_item")));
        }else if(event.getItemDrop().equals(ItemManager.tnt.getItemMeta())) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                    MultiEssential.getInstance().langConfig.getString("messages.drop_item")));
        }
    }
    @EventHandler
    public static void onTNTExplode(EntityExplodeEvent event){
        if(event.getEntityType().equals(EntityType.PRIMED_TNT)){
            event.setCancelled(true);
            Location loc = event.getEntity().getLocation();
            Player players = (Player) Bukkit.getOnlinePlayers();
            Bukkit.getWorld(players.getWorld().getName()).createExplosion(loc, (float) 0.0D);
        }
    }
}