package me.KeybordPiano459.kEssentials.helpers;

import me.KeybordPiano459.kEssentials.commands.CommandHeal;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Heal implements Listener {
    kEssentials plugin;
    public Heal(kEssentials plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        CommandHeal chl = new CommandHeal(plugin);
        chl.healcooldown.put(event.getPlayer().getName(), (long) 0);
    }
}
