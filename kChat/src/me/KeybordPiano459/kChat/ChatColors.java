package me.KeybordPiano459.kChat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatColors implements Listener {
    kChat plugin;
    public ChatColors(kChat plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String msg = event.getMessage();
        if (plugin.coloursAreAllowed()) {
            event.setMessage(ChatColor.translateAlternateColorCodes('&', msg));
        }
        String opcolour = plugin.getOpColour();
        if (player.isOp() && opcolour.equals("none")) {
            event.setFormat(ChatColor.translateAlternateColorCodes('&', "<" + opcolour + player.getName() + ChatColor.RESET + "> " + msg));
        }
    }
}
