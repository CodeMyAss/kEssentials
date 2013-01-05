package me.KeybordPiano459.kEssentials.players;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author DarkSeraphim
 */
public class PlayerListener implements Listener {
    kEssentials plugin;
    public PlayerListener(kEssentials plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler(priority=EventPriority.LOW)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        kPlayerManager man = plugin.getPlayerManager();
        kPlayer kplayer = man.getPlayer(player.getName());
        kplayer.getPlayerConfig().getConfig().options().copyDefaults(true);
        kplayer.getPlayerConfig().reloadPlayerConfig();
        kplayer.getPlayerConfig().savePlayerConfig();
    }
}