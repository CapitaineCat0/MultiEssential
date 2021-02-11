package me.capitainecat0.multiessential.moderation.events;

import me.capitainecat0.multiessential.MultiEssential;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PrefixManager {
    public void init() {
        Bukkit.getServer().getScheduler().runTaskTimer(MultiEssential.getInstance(), new java.lang.Runnable() {
            @Override
            public void run() {
                    Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
                    Team tab = scoreboard.getTeam("team");
                    if (tab == null) {
                        tab = scoreboard.registerNewTeam("team");
                    }
                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                        String prefix = PlaceholderAPI.setPlaceholders(player, MultiEssential.getInstance().langConfig.getString("messages.chat_formats.prefix").replace("&", "§"));
                        String suffix = PlaceholderAPI.setPlaceholders(player, MultiEssential.getInstance().langConfig.getString("messages.chat_formats.suffix").replace("&", "§"));
                        tab.setPrefix(prefix + " ");
                        tab.addEntry(player.getDisplayName());
                        tab.setSuffix(" " + suffix);
                        if(MultiEssential.getInstance().getConfig().getBoolean("tablist.enable")){
                            String header = PlaceholderAPI.setPlaceholders(player, MultiEssential.getInstance().langConfig.getString("tablist.header").replace("&", "§"));
                            String footer = PlaceholderAPI.setPlaceholders(player, MultiEssential.getInstance().langConfig.getString("tablist.footer").replace("&", "§"));
                            player.setPlayerListHeaderFooter(header, footer);
                        }
                    }
                }
        }, 0, 20);
    }
}
