package me.capitainecat0.multiessential.moderation.events;

import me.capitainecat0.multiessential.MultiEssential;
import me.capitainecat0.multiessential.utils.TradeListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventsListeners {
    public void init(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new FreezeEvents(MultiEssential.getInstance()), MultiEssential.getInstance());
        pm.registerEvents(new MultiEvents(MultiEssential.getInstance()), MultiEssential.getInstance());
        pm.registerEvents(new TradeListener(MultiEssential.trade), MultiEssential.getInstance());
    }
}
