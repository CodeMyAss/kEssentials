package me.KeybordPiano459.kEssentials.util;

import org.bukkit.ChatColor;

public class ChatManager {
    public String colorCompatible(String string) {
        return string
                .replaceAll("&4", ChatColor.DARK_RED + "")
                .replaceAll("&c", ChatColor.RED + "")
                .replaceAll("&C", ChatColor.RED + "")
                .replaceAll("&6", ChatColor.GOLD + "")
                .replaceAll("&e", ChatColor.YELLOW + "")
                .replaceAll("&E", ChatColor.YELLOW + "")
                .replaceAll("&2", ChatColor.DARK_GREEN + "")
                .replaceAll("&a", ChatColor.GREEN + "")
                .replaceAll("&A", ChatColor.GREEN + "")
                .replaceAll("&b", ChatColor.AQUA + "")
                .replaceAll("&B", ChatColor.AQUA + "")
                .replaceAll("&3", ChatColor.DARK_AQUA + "")
                .replaceAll("&1", ChatColor.DARK_BLUE + "")
                .replaceAll("&9", ChatColor.BLUE + "")
                .replaceAll("&d", ChatColor.LIGHT_PURPLE + "")
                .replaceAll("&D", ChatColor.LIGHT_PURPLE + "")
                .replaceAll("&5", ChatColor.DARK_PURPLE + "")
                .replaceAll("&f", ChatColor.WHITE + "")
                .replaceAll("&F", ChatColor.WHITE + "")
                .replaceAll("&7", ChatColor.GRAY + "")
                .replaceAll("&8", ChatColor.DARK_GRAY + "")
                .replaceAll("&0", ChatColor.BLACK + "")
                
                .replaceAll("&l", ChatColor.BOLD + "")
                .replaceAll("&L", ChatColor.BOLD + "")
                .replaceAll("&n", ChatColor.UNDERLINE + "")
                .replaceAll("&N", ChatColor.UNDERLINE + "")
                .replaceAll("&o", ChatColor.ITALIC + "")
                .replaceAll("&O", ChatColor.ITALIC + "")
                .replaceAll("&k", ChatColor.MAGIC + "")
                .replaceAll("&K", ChatColor.MAGIC + "")
                .replaceAll("&m", ChatColor.STRIKETHROUGH + "")
                .replaceAll("&M", ChatColor.STRIKETHROUGH + "")
                .replaceAll("&r", ChatColor.RESET + "")
                .replaceAll("&R", ChatColor.RESET + "");
    }
}