package me.KeybordPiano459.kChat;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ChatSpam implements Listener {
    static kChat plugin;
    public ChatSpam(kChat plugin) {
        ChatSpam.plugin = plugin;
    }
    
    HashMap<String, Boolean> haschat = new HashMap<String, Boolean>();
    HashMap<String, Integer> warnings = new HashMap<String, Integer>();
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        stopSpamChat(event.getPlayer());
    }
    
    @EventHandler
    public void onCmd(PlayerCommandPreprocessEvent event) {
        stopSpamChat(event.getPlayer());
    }
    
    private void stopSpamChat(final Player player) {
        if (haschat.get(player.getName())) {
            haschat.put(player.getName(), true);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    haschat.put(player.getName(), false);
                }
            }, 10);
        } else {
            int warn = warnings.get(player.getName());
            warnings.put(player.getName(), warn-1);
            if (warn-1 == 0) {
                player.kickPlayer("Too many spam warnings.");
            }
            player.sendMessage(ChatColor.RED + "You can only send a message once every 500ms!");
            player.sendMessage(ChatColor.RED + "You have " + warnings.get(player.getName()) + " warnings left.");
        }
    }
}
