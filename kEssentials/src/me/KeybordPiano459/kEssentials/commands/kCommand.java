package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class kCommand {
    kEssentials plugin;
    public kCommand(kEssentials plugin) {
        this.plugin = plugin;
    }
    
    public ChatColor AQUA = ChatColor.AQUA;
    public ChatColor DARK_GRAY = ChatColor.DARK_GRAY;
    public ChatColor DARK_GREEN = ChatColor.DARK_GREEN;
    public ChatColor GREEN = ChatColor.GREEN;
    public ChatColor RED = ChatColor.RED;
    public ChatColor RESET = ChatColor.RESET;
    public ChatColor YELLOW = ChatColor.YELLOW;
    
    public void consoleError() {
        log(Level.WARNING, "This command can't be executed from the console!");
    }
    
    public void incorrectUsage(Player player, String usage) {
        player.sendMessage(RED + "Incorrect usage! Type " + usage);
    }
    
    public void incorrectUsageC(String usage) {
        log(Level.INFO, "Incorrect usage! Type " + usage);
    }
    
    public void noPermissionsMessage(Player player) {
        player.sendMessage(RED + "You don't have permission to do that!");
    }
    
    public void log(Level level, String message) {
        plugin.getLogger().log(level, message);
    }
    
    public String[] commandlist = {
        "back",
        "backpack",
        "butcher",
        "clearenderchest",
        "clearinventory",
        "day",
        "delwarp",
        "disappear",
        "disappear",
        "enderchest",
        "fly",
        "garbagecollector",
        "getid",
        "god",
        "hat",
        "heal",
        "home",
        "ignite",
        "ip",
        "itemname",
        "kick",
        "kickall",
        "kill",
        "killall",
        "me",
        "motd",
        "mute",
        "nick",
        "night",
        "online",
        "ping",
        "platform",
        "rain",
        "ram",
        "reappear",
        "remove",
        "repair",
        "rules",
        "seed",
        "sethome",
        "setspawn",
        "setwarp",
        "spawn",
        "spawner",
        "suicide",
        "sun",
        "tps",
        "unmute",
        "warp",
        "warplist",
        "whois",
        "workbench",
        "worldinfo"
    };
}