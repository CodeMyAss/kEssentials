package me.KeybordPiano459.kEssentials.helpers;

public class RAM {
    public double getFreeRAM() {
        return Math.floor(Runtime.getRuntime().freeMemory() / 1024L / 1024L);
    }
    
    public double getMaxRAM() {
        return Math.floor(Runtime.getRuntime().maxMemory() / 1024L / 1024L);
    }
    
    public double getUsedRAM() {
        return getMaxRAM() - getFreeRAM();
    }
}