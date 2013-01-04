package me.KeybordPiano459.kProtection;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherBlocker implements Listener {
    
    boolean storm;
    boolean lightning;
    
    static kProtection plugin;
    public WeatherBlocker(kProtection plugin) {
        WeatherBlocker.plugin = plugin;
    }
    
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        if (storm && event.toWeatherState()) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onLightningStrike(LightningStrikeEvent event) {
        if (lightning) {
            event.setCancelled(true);
        }
    }
}
