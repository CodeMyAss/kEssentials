package me.KeybordPiano459.kProtection;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class MobSpawns implements Listener {
    
    private kProtection prot;
    
    public MobSpawns(kProtection prot){
        this.prot = prot;
    }
    
    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason() != SpawnReason.SPAWNER_EGG) {
            EntityType e = event.getEntityType();
            if (e == EntityType.BAT && prot.configclass.bat) {
                event.setCancelled(true);
            } else if (e == EntityType.BLAZE && prot.configclass.blaze) {
                event.setCancelled(true);
            } else if (e == EntityType.CAVE_SPIDER && prot.configclass.cavespider) {
                event.setCancelled(true);
            } else if (e == EntityType.CHICKEN && prot.configclass.chicken) {
                event.setCancelled(true);
            } else if (e == EntityType.COW && prot.configclass.cow) {
                event.setCancelled(true);
            } else if (e == EntityType.CREEPER && prot.configclass.creeper) {
                event.setCancelled(true);
            } else if (e == EntityType.ENDERMAN && prot.configclass.enderman) {
                event.setCancelled(true);
            } else if (e == EntityType.ENDER_DRAGON && prot.configclass.enderdragon) {
                event.setCancelled(true);
            } else if (e == EntityType.GHAST && prot.configclass.ghast) {
                event.setCancelled(true);
            } else if (e == EntityType.IRON_GOLEM && prot.configclass.irongolem) {
                event.setCancelled(true);
            } else if (e == EntityType.MAGMA_CUBE && prot.configclass.magmacube) {
                event.setCancelled(true);
            } else if (e == EntityType.MUSHROOM_COW && prot.configclass.mooshroom) {
                event.setCancelled(true);
            } else if (e == EntityType.OCELOT && prot.configclass.ocelot) {
                event.setCancelled(true);
            } else if (e == EntityType.PIG && prot.configclass.pig) {
                event.setCancelled(true);
            } else if (e == EntityType.PIG_ZOMBIE && prot.configclass.pigzombie) {
                event.setCancelled(true);
            } else if (e == EntityType.SHEEP && prot.configclass.sheep) {
                event.setCancelled(true);
            } else if (e == EntityType.SILVERFISH && prot.configclass.silverfish) {
                event.setCancelled(true);
            } else if (e == EntityType.SKELETON && prot.configclass.skeleton) {
                event.setCancelled(true);
            } else if (e == EntityType.SLIME && prot.configclass.slime) {
                event.setCancelled(true);
            } else if (e == EntityType.SQUID && prot.configclass.squid) {
                event.setCancelled(true);
            } else if (e == EntityType.VILLAGER && prot.configclass.villager) {
                event.setCancelled(true);
            } else if (e == EntityType.WITCH && prot.configclass.witch) {
                event.setCancelled(true);
            } else if (e == EntityType.WITHER && prot.configclass.wither) {
                event.setCancelled(true);
            } else if (e == EntityType.WOLF && prot.configclass.wolf) {
                event.setCancelled(true);
            } else if (e == EntityType.ZOMBIE && prot.configclass.zombie) {
                event.setCancelled(true);
            }
        }
    }
}
