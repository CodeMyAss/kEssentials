package me.KeybordPiano459.kProtection;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {
    
    Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("kEssentials");
    FileConfiguration config = plugin.getConfig();
    public boolean bat = config.getBoolean("mob-spawn.bat");
    public boolean blaze = config.getBoolean("mob-spawn.blaze");
    public boolean cavespider = config.getBoolean("mob-spawn.cavespider");
    public boolean chicken = config.getBoolean("mob-spawn.chicken");
    public boolean cow = config.getBoolean("mob-spawn.cow");
    public boolean creeper = config.getBoolean("mob-spawn.creeper");
    public boolean enderdragon = config.getBoolean("mob-spawn.enderdragon");
    public boolean enderman = config.getBoolean("mob-spawn.enderman");
    public boolean ghast = config.getBoolean("mob-spawn.ghast");
    public boolean irongolem = config.getBoolean("mob-spawn.irongolem");
    public boolean magmacube = config.getBoolean("mob-spawn.magmacube");
    public boolean mooshroom = config.getBoolean("mob-spawn.mooshroom");
    public boolean ocelot = config.getBoolean("mob-spawn.ocelot");
    public boolean pig = config.getBoolean("mob-spawn.pig");
    public boolean pigzombie = config.getBoolean("mob-spawn.pigzombie");
    public boolean sheep = config.getBoolean("mob-spawn.sheep");
    public boolean silverfish = config.getBoolean("mob-spawn.silverfish");
    public boolean skeleton = config.getBoolean("mob-spawn.skeleton");
    public boolean slime = config.getBoolean("mob-spawn.slime");
    public boolean snowgolem = config.getBoolean("mob-spawn.snowgolem");
    public boolean spider = config.getBoolean("mob-spawn.spider");
    public boolean squid = config.getBoolean("mob-spawn.squid");
    public boolean villager = config.getBoolean("mob-spawn.villager");
    public boolean witch = config.getBoolean("mob-spawn.witch");
    public boolean wither = config.getBoolean("mob-spawn.wither");
    public boolean wolf = config.getBoolean("mob-spawn.wolf");
    public boolean zombie = config.getBoolean("mob-spawn.zombie");
    
    public List<Integer> breakids = config.getIntegerList("blacklist.break");
    public List<Integer> placeids = config.getIntegerList("blacklist.place");
    
    public boolean lightning = config.getBoolean("weather.lightning");
    public boolean storm = config.getBoolean("weather.storm");
}