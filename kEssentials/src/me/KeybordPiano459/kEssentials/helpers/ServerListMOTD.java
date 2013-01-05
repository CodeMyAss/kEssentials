package me.KeybordPiano459.kEssentials.helpers;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListMOTD extends kHelper implements Listener {
    public ServerListMOTD(kEssentials plugin) {
        super(plugin);
    }
    
    @EventHandler
    public void onPingList(ServerListPingEvent event) {
        String rawmotd = plugin.getkConfig().getConfig().getString("server-motd");
        if (!rawmotd.equalsIgnoreCase("none")) {
            String motd = ChatColor.translateAlternateColorCodes('&', rawmotd);
            event.setMotd(motd);
        }
    }
}
