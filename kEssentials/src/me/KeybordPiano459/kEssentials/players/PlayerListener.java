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
    static kEssentials plugin;
    public PlayerListener(kEssentials plugin) {
        PlayerListener.plugin = plugin;
    }
    
    @EventHandler(priority=EventPriority.LOW)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        kPlayer kplayer = plugin.getPlayerManager().getPlayer(player.getName());
        kplayer.getPlayerConfig().reloadPlayerConfig();
        kplayer.getPlayerConfig().savePlayerConfig();
    }
}