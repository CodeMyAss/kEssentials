package me.KeybordPiano459.kEssentials;

import java.io.File;
import java.io.IOException;
import me.KeybordPiano459.kEssentials.commands.kCommand;
import me.KeybordPiano459.kEssentials.config.kConfig;
import me.KeybordPiano459.kEssentials.helpers.God;
import me.KeybordPiano459.kEssentials.helpers.MOTD;
import me.KeybordPiano459.kEssentials.helpers.Mute;
import me.KeybordPiano459.kEssentials.helpers.Spawn;
import me.KeybordPiano459.kEssentials.helpers.Warps;
import me.KeybordPiano459.kEssentials.helpers.kHelper;
import me.KeybordPiano459.kEssentials.metrics.BukkitMetrics;
import me.KeybordPiano459.kEssentials.metrics.MetricsGraph;
import me.KeybordPiano459.kEssentials.players.kPlayerManager;
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
    public Mute mute;
    
    private String s = File.separator;
    private File folder = new File("plugins" + s + "kEssentials");
    
    @Override
    public void onEnable() {
        getLogger().info("kEssentials v1.0 has been enabled!");
        folder.mkdirs();
        motd.createMOTD();
        warps.generateWarpsConfig();
        spawn.generateSpawnConfig();
        playerManager = new kPlayerManager(this);
        god = new God(this);
        mute = new Mute(this);
        kconfig.createConfig();
        khelper.getHelpers();
        kcommand.getCommands();
        
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
    
    public kPlayerManager getPlayerManager() {
        return this.playerManager;
    }
    
    public God getGod() {
        return this.god;
    }
}