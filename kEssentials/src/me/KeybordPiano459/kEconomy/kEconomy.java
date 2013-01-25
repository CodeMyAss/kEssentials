package me.KeybordPiano459.kEconomy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class kEconomy extends JavaPlugin {
    
    private static Plugin kEssentials = Bukkit.getServer().getPluginManager().getPlugin("kEssentials");
    public double startingBalance = kEssentials.getConfig().getDouble("starting-balance");
    public String currencySymbol = kEssentials.getConfig().getString("currency-symbol");
    public boolean logging = kEssentials.getConfig().getBoolean("log-economy-data");
    
    @Override
    public void onEnable() {
        if (kEssentials()) {
            getLogger().info("kEconomy v1.0 has been enabled!");
        } else {
            getLogger().warning("|----------------------------------------------|");
            getLogger().warning("|       Could not load kEconomy v1.0!!!        |");
            getLogger().warning("|    kEconomy is an add-on for kEssentials.    |");
            getLogger().warning("|      It can't load without it. Download      |");
            getLogger().warning("|     the newest version of kEssentials at     |");
            getLogger().warning(" http://dev.bukkit.org/server-mods/kEssentials/ ");
            getLogger().warning("|----------------------------------------------|");
            this.setEnabled(false);
        }
        
        getServer().getPluginCommand("money").setExecutor(new CommandMoney(this));
    }
    
    @Override
    public void onDisable() {
        getLogger().info("kEconomy v1.0 has been disabled.");
    }
    
    public boolean kEssentials() {
        if (getServer().getPluginManager().getPlugin("kEssentials") != null) {
            return true;
        } else {
            return false;
        }
    }
}