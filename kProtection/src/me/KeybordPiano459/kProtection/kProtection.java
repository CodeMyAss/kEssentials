package me.KeybordPiano459.kProtection;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class kProtection extends JavaPlugin {
    
    Config configclass;
    
    @Override
    public void onEnable() {
        if (kEssentials()) {
            getLogger().info("kProtection v1.0 has been enabled!");
            configclass = new Config();
            registerEvents();
        } else {
            getLogger().warning("+----------------------------------------------+");
            getLogger().warning("|      Could not load kProtection v1.0!!!      |");
            getLogger().warning("|   kProtection is an add-on for kEssentials.  |");
            getLogger().warning("|      It can't load without it. Download      |");
            getLogger().warning("|     the newest version of kEssentials at     |");
            getLogger().warning(" http://dev.bukkit.org/server-mods/kEssentials/ ");
            getLogger().warning("+----------------------------------------------+");
            this.setEnabled(false);
        }
    }
    
    @Override
    public void onDisable() {
        getLogger().info("kProtection v1.0 has been disabled.");
    }
    
    private void registerEvents() {
        registerEvent(new BlacklistedIDs(this));
        registerEvent(new MobSpawns());
        registerEvent(new WeatherBlocker(this));
    }
    
    private void registerEvent(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }
    
    public Config getConfigClass() {
        return this.configclass;
    }
    
    public boolean kEssentials() {
        if (getServer().getPluginManager().getPlugin("kEssentials") != null) {
            return true;
        } else {
            return false;
        }
    }
}
