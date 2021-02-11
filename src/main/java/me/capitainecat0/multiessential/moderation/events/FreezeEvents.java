package me.capitainecat0.multiessential.moderation.events;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class FreezeEvents implements Listener {
    public FreezeEvents(MultiEssential instance){}

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(MultiEssential.getInstance().frozenPlayers.containsKey(player)){
            event.setCancelled(true);
            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                    MultiEssential.getInstance().langConfig.getString("freeze.target.break_block").replace("{PLAYER}", player.getDisplayName())));
        }
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        Player player = event.getPlayer();
        if(MultiEssential.getInstance().frozenPlayers.containsKey(player)){
            event.setCancelled(true);
            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                    MultiEssential.getInstance().langConfig.getString("freeze.target.item_drop").replace("{PLAYER}", player.getDisplayName())));
        }
    }
    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if (MultiEssential.getInstance().frozenPlayers.containsKey(player)){
            int x = (int)player.getLocation().getX();
            int y = (int)player.getLocation().getY();
            int z = (int)player.getLocation().getZ();
            int pitch = (int)player.getLocation().getPitch();
            int yaw = (int)player.getLocation().getYaw();
            Location loc = new Location(player.getWorld(), (double)x, (double)y, (double)z, pitch, yaw);
            event.setFrom((Location) loc);
            event.setTo((Location) loc);
            player.teleport((Location) loc);
            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                    MultiEssential.getInstance().langConfig.getString("freeze.target.move")));
        }
    }
    @EventHandler
    public void onPickup(PlayerPickupItemEvent event){
        Player player = event.getPlayer();
        if(MultiEssential.getInstance().frozenPlayers.containsKey(player)){
            event.setCancelled(true);
            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                    MultiEssential.getInstance().langConfig.getString("freeze.target.item_pickup").replace("{PLAYER}", player.getDisplayName())));
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if (MultiEssential.getInstance().frozenPlayers.containsKey(player)) {
            event.setCancelled(true);
            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                    MultiEssential.getInstance().langConfig.getString("freeze.target.place_block").replace("{PLAYER}", player.getDisplayName())));
        }
    }
}
