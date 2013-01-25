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
    private kConfig kconfig;
    private MOTD motd;
    private Warps warps;
    private Spawn spawn;
    private God god;
    private TPS tps;
    private RAM ram;
    private Rules rules;
    private Nickname nick;
    public Mute mute;
    
    private String s = File.separator;
    private File folder = new File("plugins" + s + "kEssentials");
    
    @Override
    public void onEnable() {
        getLogger().info("kEssentials v0.1a has been enabled!");
        
        //Register events
        registerInstances();
        khelper.getHelpers();
        getCommands();
        
        //Create files
        folder.mkdirs();
        motd.createMOTD();
        rules.createRules();
        warps.generateWarpsConfig();
        spawn.generateSpawnConfig();
        kconfig.createConfig();
        
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
        getLogger().info("kEssentials v0.1a has been disabled.");
    }
    
    private void registerInstances() {
        god = new God(this);
        kconfig = new kConfig(this);
        mute = new Mute(this);
        playerManager = new kPlayerManager(this);
        tps = new TPS(this);
        ram = new RAM();
        rules = new Rules(this);
        warps = new Warps(this);
        motd = new MOTD(this);
        spawn = new Spawn(this);
        nick = new Nickname(this);
    }
    
    private void getCommands() {
        String[] commands = kcommand.commandlist;
        for (String command : commands) {
            getServer().getPluginCommand(command).setExecutor(new kCommandHandler(this));
        }
    }
    
    public kConfig getkConfig() {
        return this.kconfig;
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
    
    public RAM getRAM() {
        return this.ram;
    }
    
    public Warps getWarps() {
        return this.warps;
    }
    
    public Nickname getNick() {
        return this.nick;
    }
}