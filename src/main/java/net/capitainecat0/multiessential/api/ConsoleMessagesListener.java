package net.capitainecat0.multiessential.api;

import jdk.jfr.internal.Logger;
import me.capitainecat0.multiessential.MultiEssential;
import me.capitainecat0.multiessential.utils.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;


public class ConsoleMessagesListener {
    public ConsoleMessagesListener(MultiEssential instance){}
    public void onPluginEnabled() {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(this.formatText("&a=============================="));
        console.sendMessage(this.formatText("[&6" + MultiEssential.getInstance().getDescription().getName() + "&r]"));
        console.sendMessage(this.formatText("&2Version: &a" + MultiEssential.getInstance().getDescription().getVersion()));
        console.sendMessage(this.formatText("&5By: &b" + MultiEssential.getInstance().getDescription().getAuthors()));
        console.sendMessage(this.formatText("&e" + MultiEssential.getInstance().getDescription().getDescription()));
        console.sendMessage(this.formatText("&aActive"));
        console.sendMessage(this.formatText("&2Server version: §8" + MultiEssential.getInstance().getServer().getBukkitVersion()));
        console.sendMessage(this.formatText("&2Server jar version: §8" + MultiEssential.getInstance().getServer().getVersion()));
        console.sendMessage(this.formatText("&3Discord: &b" + MultiEssential.getInstance().getDescription().getWebsite()));
        //console.sendMessage(this.formatText("&5Modules: &d" + MultiEssential.getInstance().getDescription().getSoftDepend()));
        console.sendMessage(this.formatText("&a=============================="));
    }
    public void onPluginDisabled() {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(this.formatText("&a=============================="));
        console.sendMessage(this.formatText("[&6" + MultiEssential.getInstance().getDescription().getName() + "&f]"));
        console.sendMessage(this.formatText("&2Version: &a" + MultiEssential.getInstance().getDescription().getVersion()));
        console.sendMessage(this.formatText("&cInactive"));
        console.sendMessage(this.formatText("&a=============================="));
    }
    public void UpdatePlugin() {
        new UpdateChecker(MultiEssential.getInstance(), 84178).getLatestVersion(version -> {
            ConsoleCommandSender console = Bukkit.getConsoleSender();
            if (MultiEssential.getInstance().getDescription().getVersion().equalsIgnoreCase(version)) {
                console.sendMessage(this.formatText("&aYou have the latest version of &6" + MultiEssential.getInstance().getDescription().getName()));
            } else {
                console.sendMessage(this.formatText("&a=============================="));
                console.sendMessage(this.formatText("&6" + MultiEssential.getInstance().getDescription().getName() + " are outdated!"));
                console.sendMessage(this.formatText("&eVersion &a" + version + "&e are found on &cSpigotMC"));
                console.sendMessage(this.formatText("&bhttps://www.spigotmc.org/resources/multiessential.84178/"));
                console.sendMessage(this.formatText("&a=============================="));
            }
        });
    }
    private String formatText(String string) { return ChatColor.translateAlternateColorCodes('&', string); }
}
