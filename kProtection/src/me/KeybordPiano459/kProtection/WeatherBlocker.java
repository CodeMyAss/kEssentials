package me.KeybordPiano459.kProtection;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherBlocker implements Listener {
    
    kProtection prot;
    public WeatherBlocker(kProtection plugin) {
        this.prot = plugin;
    }
    
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        if (prot.getConfigClass().storm && event.toWeatherState()) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onLightningStrike(LightningStrikeEvent event) {
        if (prot.getConfigClass().lightning) {
            event.setCancelled(true);
        }
    }
}
