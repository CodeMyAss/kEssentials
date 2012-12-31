package me.KeybordPiano459.kChat;

import me.KeybordPiano459.kEssentials.config.kConfig;
import org.bukkit.plugin.java.JavaPlugin;

public class kChat extends JavaPlugin {
    
    private kConfig kconfig;
    public String opcolor = kconfig.getConfig().getString("op-name-color");
    public boolean colorallowed = kconfig.getConfig().getBoolean("colors-allowed-chat");
    public int chatradius = kconfig.getConfig().getInt("chat-radius");
    
    @Override
    public void onEnable() {
        if (kEssentials()) {
            getLogger().info("kChat v1.0 has been enabled!");
        } else {
            getLogger().warning("|----------------------------------------------|");
            getLogger().warning("|         Could not load kChat v1.0!!!         |");
            getLogger().warning("|      kChat is an add-on for kEssentials.     |");
            getLogger().warning("|      It can't load without it. Download      |");
            getLogger().warning("|     the newest version of kEssentials at     |");
            getLogger().warning(" http://dev.bukkit.org/server-mods/kEssentials/ ");
            getLogger().warning("|----------------------------------------------|");
            this.setEnabled(false);
        }
    }
    
    @Override
    public void onDisable() {
        getLogger().info("kChat v1.0 has been disabled.");
    }
    
    public boolean kEssentials() {
        if (getServer().getPluginManager().getPlugin("kEssentials") != null) {
            return true;
        } else {
            return false;
        }
    }
}