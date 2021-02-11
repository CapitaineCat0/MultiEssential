package me.capitainecat0.multiessential.moderation.events;

import me.capitainecat0.multiessential.MultiEssential;
import me.capitainecat0.multiessential.utils.UpdateChecker;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.Plugin;

public class MultiEvents implements Listener {
    public MultiEvents(MultiEssential instance) {
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        Player killer = event.getEntity().getKiller();
        if (killer != null) {
            killer.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("death.killer.player").replace("{PLAYER}", player.getDisplayName())));
            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("death.death_by_player").replace("{KILLER}", killer.getDisplayName())));
            event.setDeathMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("death.killer.server").replace("{PLAYER}", player.getDisplayName()).replace("{KILLER}", killer.getDisplayName())));
            player.teleport(player.getWorld().getSpawnLocation());
            if (MultiEssential.getInstance().getConfig().getBoolean("death.toggle_lightning")) {
                player.getWorld().strikeLightning(player.getLocation()).getLocation();
            }
        } else {
            assert player != null;
            player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("death.player").replace("{PLAYER}", player.getDisplayName())));
            event.setDeathMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("death.server").replace("{PLAYER}", player.getDisplayName())));
            player.teleport(player.getWorld().getSpawnLocation());
            if (MultiEssential.getInstance().getConfig().getBoolean("death.toggle_lightning")) {
                player.getWorld().strikeLightning(player.getLocation()).getLocation();
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("join.player").replace("{PLAYER}", player.getDisplayName())));
        event.setJoinMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("join.server").replace("{PLAYER}", player.getDisplayName())));
        player.setGlowing(false);
        player.setInvulnerable(false);
        new UpdateChecker(MultiEssential.getInstance(), 84178).getLatestVersion(version -> {
            if(player.isOp() && !MultiEssential.getInstance().getDescription().getVersion().equalsIgnoreCase(version)){
                player.sendMessage(MultiEssential.getInstance().formatText("&aThe version &e&l" + version +
                        "&a is out! Check out &bhttps://www.spigotmc.org/resources/multiessential.84178/&a ! &7(You are using the&e&l " +
                        MultiEssential.getInstance().getDescription().getVersion() +
                        "&7 version)"));
            }
            });

        if (MultiEssential.getInstance().getConfig().getBoolean("join.change_gamemode")) {
            player.setGameMode(GameMode.SURVIVAL);
        }
        if (MultiEssential.getInstance().getConfig().getBoolean("join.deop")) {
            player.setOp(false);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().langConfig.getString("leave.server").replace("{PLAYER}", player.getDisplayName())));
        player.setGlowing(false);
        player.setInvulnerable(false);
    }

    @EventHandler
    public void onChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("multiessential.chatcolor") && !player.hasPermission("multiessential.*") && event.getMessage().contains("&")) {
            event.setCancelled(true);
            String p = event.getPlayer().getDisplayName();
            String prefix = PlaceholderAPI.setPlaceholders(event.getPlayer(), MultiEssential.getInstance().langConfig.getString("messages.chat_formats.prefix"));
            String suffix = PlaceholderAPI.setPlaceholders(event.getPlayer(), MultiEssential.getInstance().langConfig.getString("messages.chat_formats.suffix"));
            String msg = event.getMessage();
            Bukkit.broadcastMessage(MultiEssential.getInstance().formatText(prefix + "&r " + MultiEssential.getInstance().langConfig.getString("messages.chat_formats.chat_format")
                    .replace("{PLAYER}", p).replace("{MESSAGE}", msg) + "&r " + suffix));
        } else {
            event.setCancelled(true);
            String p = event.getPlayer().getDisplayName();
            String prefix = PlaceholderAPI.setPlaceholders(event.getPlayer(), MultiEssential.getInstance().langConfig.getString("messages.chat_formats.prefix"));
            String suffix = PlaceholderAPI.setPlaceholders(event.getPlayer(), MultiEssential.getInstance().langConfig.getString("messages.chat_formats.suffix"));
            String msg = MultiEssential.getInstance().formatText(event.getMessage());
            Bukkit.broadcastMessage(MultiEssential.getInstance().formatText(prefix + "&r " + MultiEssential.getInstance().langConfig.getString("messages.chat_formats.chat_format")
                    .replace("{PLAYER}", p).replace("{MESSAGE}", msg) + "&r " + suffix));
        }
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(!MultiEssential.getInstance().getConfig().getBoolean("enable_weather"));
    }

    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        if (MultiEssential.getInstance().getConfig().getBoolean("serverMOTD.enable")) {
            event.setMotd(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("serverMOTD.set")));
        } else {
            event.setMotd(Bukkit.getServer().getMotd());
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommandEvent(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().equalsIgnoreCase("/plugins") ||
                        e.getMessage().equalsIgnoreCase("/pl") ||
                        e.getMessage().equalsIgnoreCase("/bukkit:pl") ||
                        e.getMessage().equalsIgnoreCase("/bukkit:plugins")) {
            e.setCancelled(true);
            if (!e.getPlayer().isOp()) {
                e.getPlayer().sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                        MultiEssential.getInstance().langConfig.getString("plugins")));
                return;
            }e.getPlayer().sendMessage("§6Loaded plugins (§c" + Bukkit.getPluginManager().getPlugins().length + "§6):");
            for (Plugin p : Bukkit.getPluginManager().getPlugins()) {
                e.getPlayer().sendMessage("  §3- §b" + p.getName() + " §8[" + p.getDescription().getVersion() + "§8]");
            }
        }
    }
}