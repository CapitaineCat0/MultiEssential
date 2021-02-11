package me.capitainecat0.multiessential.fun.events;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class FunListeners {
    public void init(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new SticksEvent(MultiEssential.getInstance()), MultiEssential.getInstance());
    }
}
