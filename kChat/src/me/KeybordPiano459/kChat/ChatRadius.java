package me.KeybordPiano459.kChat;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatRadius implements Listener {
    static kChat plugin;
    public ChatRadius(kChat plugin) {
        ChatRadius.plugin = plugin;
    }
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        int nearbyn = plugin.chatradius;
        if (nearbyn != 0) {
            event.setCancelled(true);
            int pheard = 0;
            List<Entity> nearby = player.getNearbyEntities(nearbyn, nearbyn, nearbyn);
            for (Entity e : nearby) {
                if (e instanceof Player) {
                    pheard++;
                    Player p = (Player) e;
                    p.sendMessage("<" + player.getName() + "> " + event.getMessage());
                }
            }
            
            if (pheard == 0) {
                player.sendMessage(ChatColor.YELLOW + "Nobody heard you speak.");
            }
        } else {
            
        }
    }
}