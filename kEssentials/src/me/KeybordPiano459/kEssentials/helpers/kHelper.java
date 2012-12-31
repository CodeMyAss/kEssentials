package me.KeybordPiano459.kEssentials.helpers;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class kHelper {
    static kEssentials plugin;
    public kHelper(kEssentials plugin) {
        kHelper.plugin = plugin;
    }
    
    public void getHelpers() {
        getHelper(new Back(plugin));
        getHelper(new Backpack(plugin));
        getHelper(new EnderChest(plugin));
        getHelper(new MOTD(plugin));
        getHelper(new Mute(plugin));
    }
    
    public void getHelper(Listener listener) {
        Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
    }
}
