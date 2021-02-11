package net.capitainecat0.multiessential.api;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class API {
    public API(MultiEssential instance){}
    public void spawnLocation(World world) { MultiEssential.getInstance().getServer().getWorld(world.getName()).getSpawnLocation(); }
    public void worldName(World world){
        MultiEssential.getInstance().getServer().getWorld(world.getName());
    }
    public void frozenPlayer(Player player){MultiEssential.getInstance().frozenPlayers.containsKey(player.getDisplayName()); }
}
