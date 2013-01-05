package me.KeybordPiano459.kProtection;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlacklistedIDs implements Listener {
    
    List<Integer> breakids;
    List<Integer> placeids;
    
    kProtection plugin;
    public BlacklistedIDs(kProtection plugin) {
        this.plugin = plugin;
        breakids = plugin.getConfigClass().breakids;
        placeids = plugin.getConfigClass().placeids;
    }
    
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("kprotection.bypass.place")) {
            int id = event.getBlock().getTypeId();
            if (placeids.contains(id)) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't place that block!");
            }
        }
    }
    
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("kprotection.bypass.break")) {
            int id = event.getBlock().getTypeId();
            if (breakids.contains(id)) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't break that block!");
            }
        }
    }
}
