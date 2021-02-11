package me.capitainecat0.multiessential.utils;

import com.sun.org.apache.xerces.internal.xs.StringList;
import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;

public class MELoader {

    private HashMap<String, Object> configData = new HashMap<>();
    private FileConfiguration configConfig;
    private File fileData;

    public MELoader(String file) {
        File fileData = new File(MultiEssential.getInstance().getDataFolder(), file);
        if (!fileData.exists()) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&cCan't load the configuration file &4" + file + " &c, since it doesn't exist!"
            ));
            return;
        }
        this.fileData = fileData;
        this.configConfig = YamlConfiguration.loadConfiguration(fileData);

        for (String list : configConfig.getConfigurationSection("").getKeys(true)){
            configData.put(list, configConfig.getStringList(list));
        }

        for (String args : configConfig.getConfigurationSection("").getKeys(true)){
            configData.put(args, configConfig.getString(args));
        }
        for (String node : configConfig.getConfigurationSection("").getKeys(true)) {
            configData.put(node, configConfig.get(node));
        }
        for (String bool : configConfig.getConfigurationSection("").getKeys(true)){
                configData.put(bool, configConfig.getBoolean(bool));
        }
        for (String number : configConfig.getConfigurationSection("").getKeys(true)){
            configData.put(number, configConfig.getInt(number));
        }
    }

    public StringList getStringList(String list){
        return (StringList) configData.get(list);
    }
    public String getString(String args){
        return (String) configData.get(args);
    }
    public Object getData(String node) {
        return configData.get(node);
    }
    public boolean getBoolean(String bool) {
        return (boolean) configData.get(bool);
    }
    public int getInt(String number) {
        return (int) configData.get(number);
    }
}