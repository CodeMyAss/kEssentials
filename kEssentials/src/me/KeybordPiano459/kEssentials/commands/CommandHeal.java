package me.KeybordPiano459.kEssentials.commands;

import java.util.HashMap;
import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.config.kConfig;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHeal extends kCommand implements CommandExecutor {
    public CommandHeal(kEssentials plugin) {
        super(plugin);
    }
    
    private HashMap<String, Integer> healcooldown = new HashMap<String, Integer>();
    private kConfig kconfig;
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.heal.self")) {
                        if (healcooldown.get(player.getName()) == 0) {
                            player.setHealth(20);
                            player.sendMessage(GREEN + "You have healed yourself.");
                            healcooldown.put(player.getName(), kconfig.getConfig().getInt("heal-cooldown"));
                            resetCooldownHeal(player);
                        } else {
                            if (player.hasPermission("kessentials.heal.bypass")) {
                                player.setHealth(20);
                                player.sendMessage(GREEN + "You have healed yourself.");
                            } else {
                                player.sendMessage(RED + "You still need to wait " + healcooldown.get(player.getName()) + " seconds before you can use /heal again.");
                            }
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else if (args.length == 1) {
                    if (player.hasPermission("kessentials.heal.others")) {
                        Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                        if (tplayer != null) {
                            if (healcooldown.get(player.getName()) == 0) {
                                tplayer.setHealth(20);
                                tplayer.sendMessage(DARK_GRAY + "You have been healed.");
                                player.sendMessage(GREEN + "You have healed " + tplayer.getName());
                            } else {
                                player.sendMessage(RED + "You still need to wait " + healcooldown.get(player.getName()) + " seconds before you can use /heal again.");
                            }
                        } else {
                            player.sendMessage(RED + args[0] + " isn't currently online.");
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    String usage = player.hasPermission("kessentials.heal.others") ? "/heal [player]" : "/heal";
                    incorrectUsage(player, usage);
                }
            } else {
                if (args.length == 1) {
                    Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                    if (tplayer != null) {
                        tplayer.setHealth(20);
                        tplayer.sendMessage(DARK_GRAY + "You have been healed.");
                        log(Level.INFO, "You have healed " + tplayer.getName());
                    } else {
                        log(Level.INFO, args[0] + " isn't currently online.");
                    }
                } else {
                    incorrectUsageC("/heal <player>");
                }
            }
        }
        return false;
    }
    
    public void resetCooldownHeal(final Player player) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                int cd = healcooldown.get(player.getName());
                if (cd == 1) {
                    healcooldown.put(player.getName(), 0);
                } else {
                    healcooldown.put(player.getName(), cd-1);
                    resetCooldownHeal(player);
                }
            }
        }, 20);
    }
}