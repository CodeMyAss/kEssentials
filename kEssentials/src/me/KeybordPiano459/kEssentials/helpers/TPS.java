package me.KeybordPiano459.kEssentials.helpers;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

/*
 * 
 * @author KeybordPiano459
 */
public class TPS implements Listener {
    kEssentials plugin;
    public TPS(kEssentials plugin) {
        this.plugin = plugin;
    }
    
    public int tps = 0;
    public long second = 0;
    
    public float getServerTPS() {
        return tps;
    }
    
    @EventHandler
    public void onPluginEnable(PluginEnableEvent event) {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            long sec;
            int ticks;
            
            @Override
            public void run() {
                sec = System.currentTimeMillis() / 1000;
                if (second == sec) {
                    ticks++;
                } else {
                    second = sec;
                    tps = tps == 0 ? ticks : (tps + ticks) / 2;
                    ticks = 0;
                }
            }
        }, 20, 1);
    }
}