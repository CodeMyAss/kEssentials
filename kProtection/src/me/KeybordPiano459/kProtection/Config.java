package me.KeybordPiano459.kProtection;

import java.util.List;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {
    
    public Config(kEssentials plugin)
    {
        config = plugin.getConfig();
        bat = config.getBoolean("mob-spawn.bat");
        blaze = config.getBoolean("mob-spawn.blaze");
        cavespider = config.getBoolean("mob-spawn.cavespider");
        chicken = config.getBoolean("mob-spawn.chicken");
        cow = config.getBoolean("mob-spawn.cow");
        creeper = config.getBoolean("mob-spawn.creeper");
        enderdragon = config.getBoolean("mob-spawn.enderdragon");
        enderman = config.getBoolean("mob-spawn.enderman");
        ghast = config.getBoolean("mob-spawn.ghast");
        irongolem = config.getBoolean("mob-spawn.irongolem");
        magmacube = config.getBoolean("mob-spawn.magmacube");
        mooshroom = config.getBoolean("mob-spawn.mooshroom");
        ocelot = config.getBoolean("mob-spawn.ocelot");
        pig = config.getBoolean("mob-spawn.pig");
        pigzombie = config.getBoolean("mob-spawn.pigzombie");
        sheep = config.getBoolean("mob-spawn.sheep");
        silverfish = config.getBoolean("mob-spawn.silverfish");
        skeleton = config.getBoolean("mob-spawn.skeleton");
        slime = config.getBoolean("mob-spawn.slime");
        snowgolem = config.getBoolean("mob-spawn.snowgolem");
        spider = config.getBoolean("mob-spawn.spider");
        squid = config.getBoolean("mob-spawn.squid");
        villager = config.getBoolean("mob-spawn.villager");
        witch = config.getBoolean("mob-spawn.witch");
        wither = config.getBoolean("mob-spawn.wither");
        wolf = config.getBoolean("mob-spawn.wolf");
        zombie = config.getBoolean("mob-spawn.zombie");
        
        breakids = config.getIntegerList("blacklist.break");
        placeids = config.getIntegerList("blacklist.place");
        
        lightning = config.getBoolean("weather.lightning");
        storm = config.getBoolean("weather.storm");
    }
    
    
    FileConfiguration config;
    public boolean bat;
    public boolean blaze;
    public boolean cavespider;
    public boolean chicken;
    public boolean cow;
    public boolean creeper;
    public boolean enderdragon;
    public boolean enderman;
    public boolean ghast;
    public boolean irongolem;
    public boolean magmacube;
    public boolean mooshroom;
    public boolean ocelot;
    public boolean pig;
    public boolean pigzombie;
    public boolean sheep;
    public boolean silverfish;
    public boolean skeleton;
    public boolean slime;
    public boolean snowgolem;
    public boolean spider;
    public boolean squid;
    public boolean villager;
    public boolean witch;
    public boolean wither;
    public boolean wolf;
    public boolean zombie;
    
    public List<Integer> breakids;
    public List<Integer> placeids;
    
    public boolean lightning;
    public boolean storm;
}