package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class kCommand {
    static kEssentials plugin;
    public kCommand(kEssentials plugin) {
        kCommand.plugin = plugin;
    }
    
    public static ChatColor DARK_GRAY = ChatColor.DARK_GRAY;
    public static ChatColor GREEN = ChatColor.GREEN;
    public static ChatColor RED = ChatColor.RED;
    public static ChatColor RESET = ChatColor.RESET;
    public static ChatColor YELLOW = ChatColor.YELLOW;
    
    public void getCommands() {
        getCommand("back", new CommandBack(plugin));
        getCommand("backpack", new CommandBackpack(plugin));
        getCommand("butcher", new CommandButcher(plugin));
        getCommand("clearenderchest", new CommandClearenderchest(plugin));
        getCommand("clearinventory", new CommandClearinventory(plugin));
        getCommand("day", new CommandDay(plugin));
        getCommand("delwarp", new CommandDelwarp(plugin));
        getCommand("enderchest", new CommandEnderchest(plugin));
        getCommand("garbagecollector", new CommandGarbagecollector(plugin));
        getCommand("getid", new CommandGetid(plugin));
        getCommand("god", new CommandGod(plugin));
        getCommand("hat", new CommandHat(plugin));
        getCommand("heal", new CommandHeal(plugin));
        getCommand("home", new CommandHome(plugin));
        getCommand("ignite", new CommandIgnite(plugin));
        getCommand("ip", new CommandIp(plugin));
        getCommand("itemname", new CommandItemname(plugin));
        getCommand("kick", new CommandKick(plugin));
        getCommand("kickall", new CommandKickall(plugin));
        getCommand("kill", new CommandKill(plugin));
        getCommand("killall", new CommandKillall(plugin));
        getCommand("me", new CommandMe(plugin));
        getCommand("motd", new CommandMotd(plugin));
        getCommand("mute", new CommandMute(plugin));
        getCommand("night", new CommandNight(plugin));
        getCommand("online", new CommandOnline(plugin));
        getCommand("ping", new CommandPing(plugin));
        getCommand("rain", new CommandRain(plugin));
        getCommand("ram", new CommandRam(plugin));
        getCommand("remove", new CommandRemove(plugin));
        getCommand("repair", new CommandRepair(plugin));
        getCommand("rules", new CommandRules(plugin));
        getCommand("sethome", new CommandSethome(plugin));
        getCommand("setspawn", new CommandSetspawn(plugin));
        getCommand("setwarp", new CommandSetwarp(plugin));
        getCommand("spawn", new CommandSpawn(plugin));
        getCommand("spawner", new CommandSpawner(plugin));
        getCommand("suicide", new CommandSuicide(plugin));
        getCommand("sun", new CommandSun(plugin));
        getCommand("tps", new CommandTPS(plugin));
        getCommand("unmute", new CommandUnmute(plugin));
        getCommand("warp", new CommandWarp(plugin));
        getCommand("warplist", new CommandWarplist(plugin));
        getCommand("workbench", new CommandWorkbench(plugin));
    }
    
    public void getCommand(String command, CommandExecutor executor) {
        Bukkit.getServer().getPluginCommand(command).setExecutor(executor);
    }
    
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
        Logger.getLogger("Minecraft").log(level, message);
    }
}