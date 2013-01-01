package me.KeybordPiano459.kEssentials.helpers;

import java.util.HashSet;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class God implements Listener {
    static kEssentials plugin;
    public God(kEssentials plugin) {
        God.plugin = plugin;
    }
    
    public HashSet<String> godmode = new HashSet<String>();
    
    @EventHandler
    public void onDmg(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (godmode.contains(player.getName())) {
                event.setCancelled(true);
            }
        }
    }
}
