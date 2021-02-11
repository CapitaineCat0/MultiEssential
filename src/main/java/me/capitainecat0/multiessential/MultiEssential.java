package me.capitainecat0.multiessential;

import java.util.ArrayList;
import java.util.HashMap;
import me.capitainecat0.multiessential.commands.MultiCommands;
import me.capitainecat0.multiessential.fun.commands.FunCommands;
import me.capitainecat0.multiessential.fun.events.FunListeners;
import me.capitainecat0.multiessential.fun.items.ItemsListeners;
import me.capitainecat0.multiessential.moderation.commands.ModCommands;
import me.capitainecat0.multiessential.moderation.events.EventsListeners;
import me.capitainecat0.multiessential.utils.MELoader;
import me.capitainecat0.multiessential.utils.TradeListener;
import net.capitainecat0.multiessential.api.API;
import net.capitainecat0.multiessential.api.ConsoleMessagesListener;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MultiEssential extends JavaPlugin implements Listener {
    public static API api;
    public static ConsoleMessagesListener MessagesListener;
    public HashMap<Player, Location> frozenPlayers = new HashMap();
    public ArrayList<Player> Vanish_List = new ArrayList();
    public static TradeListener trade;
    public MELoader langConfig = new MELoader("language.yml");
    public MELoader itemsConfig = new MELoader("items.yml");

    private static MultiEssential instance;
    public MultiEssential() {
    }

    public void onEnable() {
        trade = new TradeListener();
        instance = this;
        api = new API(this);
        MessagesListener = new ConsoleMessagesListener(this);
        MessagesListener.onPluginEnabled();
        MessagesListener.UpdatePlugin();
        (new MultiCommands()).init();
        (new ModCommands()).init();
        (new FunListeners()).init();
        (new ItemsListeners()).init();
        (new EventsListeners()).init();
        (new FunCommands()).init();
        //(new PrefixManager()).init();
        this.saveDefaultConfig();
    }

    public static MultiEssential getInstance() {
        return instance;
    }
    public String formatText(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
    public void onDisable() {
        MessagesListener.onPluginDisabled();
    }
}
