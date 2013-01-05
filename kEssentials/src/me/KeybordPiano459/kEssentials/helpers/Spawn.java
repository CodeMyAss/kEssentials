package me.KeybordPiano459.kEssentials.helpers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Spawn extends kHelper {
    public Spawn(kEssentials plugin) {
        super(plugin);
    }
    
    private FileConfiguration spawnConfig = null;
    private File spawnConfigFile = null;
    
    public void generateSpawnConfig() {
        if (spawnConfigFile != null) {
            spawnConfigFile.delete();
        }
        
        reloadSpawnConfig();
    }
    
    public void reloadSpawnConfig() {
        if (spawnConfigFile == null) {
            spawnConfigFile = new File(plugin.getDataFolder(), "spawn.yml");
        }
        spawnConfig = YamlConfiguration.loadConfiguration(spawnConfigFile);
        
        InputStream defConfigStream = plugin.getResource("spawn.yml");
        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            spawnConfig.setDefaults(defConfig);
        }
    }
    
    public FileConfiguration getSpawnConfig() {
        if (spawnConfig == null) {
            reloadSpawnConfig();
        }
        return spawnConfig;
    }
    
    public void saveSpawnConfig() {
        if (spawnConfig == null || spawnConfigFile == null) {
            return;
        }
        
        try {
            spawnConfig.save(spawnConfigFile);
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Could not save the warps config to the disk!");
        }
    }
}