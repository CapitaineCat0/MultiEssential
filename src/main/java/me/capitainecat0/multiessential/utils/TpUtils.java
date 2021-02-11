package me.capitainecat0.multiessential.utils;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Random;

public class TpUtils {
    public static HashSet<Material> bad_blocks = new HashSet();
    public TpUtils(MultiEssential instance){}

    public static Location generateLocation(Player player) {
        Random random = new Random();
        int x = (int)player.getLocation().getX();
        int y = (int)player.getLocation().getY();
        int z = (int)player.getLocation().getZ();
        if (MultiEssential.getInstance().getConfig().getBoolean("randomtp.enable")) {
            x = random.nextInt(MultiEssential.getInstance().getConfig().getInt("randomtp.x"));
            y = random.nextInt(10);
            z = random.nextInt(MultiEssential.getInstance().getConfig().getInt("randomtp.z"));
        }

        Location randomLocation = new Location(player.getWorld(), (double)x, (double)y, (double)z);
        y = randomLocation.getWorld().getHighestBlockYAt(randomLocation);
        randomLocation.setY((double)y);

        while(!isLocationSafe(randomLocation)) {
            randomLocation = generateLocation(player);
        }

        return randomLocation;
    }

    public static boolean isLocationSafe(Location location) {
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        Block block = location.getWorld().getBlockAt(x, y, z);
        location.getWorld().getBlockAt(x, y - 1, z);
        Block above = location.getWorld().getBlockAt(x, y + 1, z);
        return !bad_blocks.contains(block.getType()) && !block.getType().isSolid() && !above.getType().isSolid();
    }

    static {
        bad_blocks.add(Material.LAVA);
        bad_blocks.add(Material.FIRE);
        bad_blocks.add(Material.CAMPFIRE);
        bad_blocks.add(Material.MAGMA_BLOCK);
        bad_blocks.add(Material.WATER);
    }
}