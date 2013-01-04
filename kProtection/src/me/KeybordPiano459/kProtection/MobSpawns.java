package me.KeybordPiano459.kProtection;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class MobSpawns extends Config implements Listener {
    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason() != SpawnReason.SPAWNER_EGG) {
            EntityType e = event.getEntityType();
            if (e == EntityType.BAT && bat) {
                event.setCancelled(true);
            } else if (e == EntityType.BLAZE && blaze) {
                event.setCancelled(true);
            } else if (e == EntityType.CAVE_SPIDER && cavespider) {
                event.setCancelled(true);
            } else if (e == EntityType.CHICKEN && chicken) {
                event.setCancelled(true);
            } else if (e == EntityType.COW && cow) {
                event.setCancelled(true);
            } else if (e == EntityType.CREEPER && creeper) {
                event.setCancelled(true);
            } else if (e == EntityType.ENDERMAN && enderman) {
                event.setCancelled(true);
            } else if (e == EntityType.ENDER_DRAGON && enderdragon) {
                event.setCancelled(true);
            } else if (e == EntityType.GHAST && ghast) {
                event.setCancelled(true);
            } else if (e == EntityType.IRON_GOLEM && irongolem) {
                event.setCancelled(true);
            } else if (e == EntityType.MAGMA_CUBE && magmacube) {
                event.setCancelled(true);
            } else if (e == EntityType.MUSHROOM_COW && mooshroom) {
                event.setCancelled(true);
            } else if (e == EntityType.OCELOT && ocelot) {
                event.setCancelled(true);
            } else if (e == EntityType.PIG && pig) {
                event.setCancelled(true);
            } else if (e == EntityType.PIG_ZOMBIE && pigzombie) {
                event.setCancelled(true);
            } else if (e == EntityType.SHEEP && sheep) {
                event.setCancelled(true);
            } else if (e == EntityType.SILVERFISH && silverfish) {
                event.setCancelled(true);
            } else if (e == EntityType.SKELETON && skeleton) {
                event.setCancelled(true);
            } else if (e == EntityType.SLIME && slime) {
                event.setCancelled(true);
            } else if (e == EntityType.SQUID && squid) {
                event.setCancelled(true);
            } else if (e == EntityType.VILLAGER && villager) {
                event.setCancelled(true);
            } else if (e == EntityType.WITCH && witch) {
                event.setCancelled(true);
            } else if (e == EntityType.WITHER && wither) {
                event.setCancelled(true);
            } else if (e == EntityType.WOLF && wolf) {
                event.setCancelled(true);
            } else if (e == EntityType.ZOMBIE && zombie) {
                event.setCancelled(true);
            }
        }
    }
}
