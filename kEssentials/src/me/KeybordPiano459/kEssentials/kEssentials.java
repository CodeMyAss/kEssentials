package me.KeybordPiano459.kEssentials;

import java.io.File;
import java.io.IOException;
import me.KeybordPiano459.kEssentials.commands.*;
import me.KeybordPiano459.kEssentials.config.*;
import me.KeybordPiano459.kEssentials.helpers.*;
import me.KeybordPiano459.kEssentials.metrics.*;
import me.KeybordPiano459.kEssentials.players.*;
import org.bukkit.plugin.java.JavaPlugin;

public class kEssentials extends JavaPlugin {
    
    private kCommand kcommand = new kCommand(this);
    private kHelper khelper = new kHelper(this);
    private kPlayerManager playerManager;
    private kConfig kconfig = new kConfig(this);
    private MOTD motd = new MOTD(this);
    private Warps warps = new Warps(this);
    private Spawn spawn = new Spawn(this);
    private God god;
    private TPS tps;
    public Mute mute;
    
    private String s = File.separator;
    private File folder = new File("plugins" + s + "kEssentials");
    
    @Override
    public void onEnable() {
        getLogger().info("kEssentials v1.0 has been enabled!");
        
        //Create files
        folder.mkdirs();
        motd.createMOTD();
        warps.generateWarpsConfig();
        spawn.generateSpawnConfig();
        kconfig.createConfig();
        
        //Register events
        registerInstances();
        khelper.getHelpers();
        kcommand.getCommands();
        
        //Metrics
        try {
            BukkitMetrics metrics = new BukkitMetrics(this);
            MetricsGraph graph = new MetricsGraph();
            graph.addAddonsGraph(metrics);
            metrics.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void onDisable() {
        getLogger().info("kEssentials v1.0 has been disabled.");
    }
    
    private void registerInstances() {
        god = new God(this);
        mute = new Mute(this);
        playerManager = new kPlayerManager(this);
        tps = new TPS(this);
    }
    
    public kPlayerManager getPlayerManager() {
        return this.playerManager;
    }
    
    public God getGod() {
        return this.god;
    }
    
    public TPS getTPS() {
        return this.tps;
    }
}