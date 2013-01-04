package me.KeybordPiano459.kEssentials.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class kConfig {
    static kEssentials plugin;
    public kConfig(kEssentials plugin) {
        kConfig.plugin = plugin;
        kConfigFile = new File(plugin.getDataFolder(), "config.yml");
        kConfigConfiguration = YamlConfiguration.loadConfiguration(kConfigFile);
    }
    
    public FileConfiguration kConfigConfiguration;
    public File kConfigFile;
    
    public void createConfig() {
        kConfigFile = new File(plugin.getDataFolder(), "config.yml");
        if (!kConfigFile.exists()) {
            try {
                kConfigFile.createNewFile();
                generateConfig();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void generateConfig() {
        try {
            File configFile = new File(plugin.getDataFolder(), "config.yml");
            FileWriter w = new FileWriter(configFile);
            w(w, "##################################################");
            w(w, "# +--------------------------------------------+ #");
            w(w, "# |                kEssentials                 | #");
            w(w, "# +--------------------------------------------+ #");
            w(w, "##################################################");
            w(w, "");
            w(w, "# Should players see the MOTD when they log in?");
            w(w, "motd-on-login: true\n");
            w(w, "# What should the cooldown be on /heal (in seconds)");
            w(w, "heal-cooldown: 60\n");
            w(w, "\n\n");
            w(w, "##################################################");
            w(w, "# +--------------------------------------------+ #");
            w(w, "# |                   kChat                    | #");
            w(w, "# +--------------------------------------------+ #");
            w(w, "##################################################");
            w(w, "");
            w(w, "# What color should an op's name be? Set to 'none' for no change");
            w(w, "op-name-color: '&c'\n");
            w(w, "# Should color symbols be allowed in the chat?");
            w(w, "colors-allowed-chat: true\n");
            w(w, "# How far away from the player should messages be \"heard\" from?");
            w(w, "# Set to 0 for infinite (vanilla minecraft)");
            w(w, "chat-radius: 100\n");
            w(w, "\n\n");
            w(w, "##################################################");
            w(w, "# +--------------------------------------------+ #");
            w(w, "# |                  kEconomy                  | #");
            w(w, "# +--------------------------------------------+ #");
            w(w, "##################################################");
            w(w, "");
            w(w, "# This is the amount of money that players start with");
            w(w, "starting-balance: 30\n");
            w(w, "# This is what will be displayed with money ($10)");
            w(w, "currency-symbol: '$'\n");
            w(w, "\n\n");
            w(w, "##################################################");
            w(w, "# +--------------------------------------------+ #");
            w(w, "# |                 kProtection                | #");
            w(w, "# +--------------------------------------------+ #");
            w(w, "##################################################");
            w(w, "");
            w(w, "# With this, you can prevent certain mobs from spawning");
            w(w, "# Note that you will still be able to spawn these mobs with spawn eggs");
            w(w, "mob-spawn:");
            w(w, "  bat: false");
            w(w, "  blaze: false");
            w(w, "  cavespider: false");
            w(w, "  chicken: false");
            w(w, "  cow: false");
            w(w, "  creeper: false");
            w(w, "  enderdragon: false");
            w(w, "  enderman: false");
            w(w, "  ghast: false");
            w(w, "  irongolem: false");
            w(w, "  magmacube: false");
            w(w, "  mooshroom: false");
            w(w, "  ocelot: false");
            w(w, "  pig: false");
            w(w, "  pigzombie: false");
            w(w, "  sheep: false");
            w(w, "  silverfish: false");
            w(w, "  skeleton: false");
            w(w, "  slime: false");
            w(w, "  snowgolem: false");
            w(w, "  spider: false");
            w(w, "  squid: false");
            w(w, "  villager: false");
            w(w, "  witch: false");
            w(w, "  wither: false");
            w(w, "  wolf: false");
            w(w, "  zombie: false\n");
            w(w, "# What block IDs should not be able to be placed?");
            w(w, "# You can still place these blocks with the kprotection.bypass.place permission");
            w(w, "blacklist:");
            w(w, "  place:");
            w(w, "  - 7");
            w(w, "  - 10");
            w(w, "  - 11");
            w(w, "  - 51\n");
            w(w, "# You can still break these blocks with the kprotection.bypass.break permission");
            w(w, "  break:");
            w(w, "  - 7\n");
            w(w, "# With this, you can disable certain types of weather from occuring");
            w(w, "weather:");
            w(w, "  lightning: false");
            w(w, "  storm: false");
            w.close();
            reloadConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void w(FileWriter writer, String string) throws IOException {
        writer.write(string + "\n");
    }
    
    public void reloadConfig() {
        if (!kConfigFile.exists()) {
            kConfigFile = new File(plugin.getDataFolder(), "config.yml");
        }
        kConfigConfiguration = YamlConfiguration.loadConfiguration(kConfigFile);
        
        InputStream defConfigStream = plugin.getResource("config.yml");
        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            kConfigConfiguration.setDefaults(defConfig);
        }
    }
    
    public FileConfiguration getConfig() {
        if (kConfigConfiguration == null) {
            reloadConfig();
        }
        return kConfigConfiguration;
    }
    
    public void saveConfig() {
        if (kConfigConfiguration == null || kConfigFile == null) {
            return;
        }
        
        try {
            kConfigConfiguration.save(kConfigFile);
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save the config file to the disk!");
        }
    }
}