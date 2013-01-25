package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class kCommandHandler implements CommandExecutor {
    kEssentials plugin;
    public kCommandHandler(kEssentials plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("back")) {
            CommandBack cmdback = new CommandBack(plugin);
            return cmdback.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("backpack")) {
            CommandBackpack cmdbackpack = new CommandBackpack(plugin);
            return cmdbackpack.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("butcher")) {
            CommandButcher cmdbutcher = new CommandButcher(plugin);
            return cmdbutcher.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("clearenderchest")) {
            CommandClearenderchest cmdce = new CommandClearenderchest(plugin);
            return cmdce.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("clearinventory")) {
            CommandClearinventory cmdci = new CommandClearinventory(plugin);
            return cmdci.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("day")) {
            CommandDay cmdday = new CommandDay(plugin);
            return cmdday.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("delwarp")) {
            CommandDelwarp cmddelwarp = new CommandDelwarp(plugin);
            return cmddelwarp.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("disappear")) {
            CommandDisappear cmddisappear = new CommandDisappear(plugin);
            return cmddisappear.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("enderchest")) {
            CommandEnderchest cmdenderchest = new CommandEnderchest(plugin);
            return cmdenderchest.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("fly")) {
            CommandFly cmdfly = new CommandFly(plugin);
            return cmdfly.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("garbagecollector")) {
            CommandGarbagecollector cmdgc = new CommandGarbagecollector(plugin);
            return cmdgc.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("getid")) {
            CommandGetid cmdgetid = new CommandGetid(plugin);
            return cmdgetid.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("god")) {
            CommandGod cmdgod = new CommandGod(plugin);
            return cmdgod.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("hat")) {
            CommandHat cmdhat = new CommandHat(plugin);
            return cmdhat.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("heal")) {
            CommandHeal cmdheal = new CommandHeal(plugin);
            return cmdheal.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("home")) {
            CommandHome cmdhome = new CommandHome(plugin);
            return cmdhome.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("ignite")) {
            CommandIgnite cmdignite = new CommandIgnite(plugin);
            return cmdignite.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("ip")) {
            CommandIp cmdip = new CommandIp(plugin);
            return cmdip.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("itemname")) {
            CommandItemname cmditemname = new CommandItemname(plugin);
            return cmditemname.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("kick")) {
            CommandKick cmdkick = new CommandKick(plugin);
            return cmdkick.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("kickall")) {
            CommandKickall cmdkickall = new CommandKickall(plugin);
            return cmdkickall.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("kill")) {
            CommandKill cmdkill = new CommandKill(plugin);
            return cmdkill.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("killall")) {
            CommandKillall cmdkillall = new CommandKillall(plugin);
            return cmdkillall.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("list")) {
            CommandList cmdlist = new CommandList(plugin);
            return cmdlist.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("me")) {
            CommandMe cmdme = new CommandMe(plugin);
            return cmdme.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("motd")) {
            CommandMotd cmdmotd = new CommandMotd(plugin);
            return cmdmotd.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("mute")) {
            CommandMute cmdmute = new CommandMute(plugin);
            return cmdmute.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("nick")) {
            CommandNick cmdnick = new CommandNick(plugin);
            return cmdnick.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("night")) {
            CommandNight cmdnight = new CommandNight(plugin);
            return cmdnight.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("online")) {
            CommandOnline cmdonline = new CommandOnline(plugin);
            return cmdonline.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("ping")) {
            CommandPing cmdping = new CommandPing(plugin);
            return cmdping.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("platform")) {
            CommandPlatform cmdplatform = new CommandPlatform(plugin);
            return cmdplatform.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("rain")) {
            CommandRain cmdrain = new CommandRain(plugin);
            return cmdrain.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("ram")) {
            CommandRam cmdram = new CommandRam(plugin);
            return cmdram.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("reappear")) {
            CommandReappear cmdreappear = new CommandReappear(plugin);
            return cmdreappear.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("remove")) {
            CommandRemove cmdremove = new CommandRemove(plugin);
            return cmdremove.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("repair")) {
            CommandRepair cmdrepair = new CommandRepair(plugin);
            return cmdrepair.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("rules")) {
            CommandRules cmdrules = new CommandRules(plugin);
            return cmdrules.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("sethome")) {
            CommandSethome cmdsethome = new CommandSethome(plugin);
            return cmdsethome.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("setspawn")) {
            CommandSetspawn cmdsetspawn = new CommandSetspawn(plugin);
            return cmdsetspawn.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("setwarp")) {
            CommandSetwarp cmdsetwarp = new CommandSetwarp(plugin);
            return cmdsetwarp.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("spawn")) {
            CommandSpawn cmdspawn = new CommandSpawn(plugin);
            return cmdspawn.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("spawner")) {
            CommandSpawner cmdspawner = new CommandSpawner(plugin);
            return cmdspawner.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("suicide")) {
            CommandSuicide cmdsuicide = new CommandSuicide(plugin);
            return cmdsuicide.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("sun")) {
            CommandSun cmdsun = new CommandSun(plugin);
            return cmdsun.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("tps")) {
            CommandTPS cmdtps = new CommandTPS(plugin);
            return cmdtps.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("unmute")) {
            CommandUnmute cmdunmute = new CommandUnmute(plugin);
            return cmdunmute.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("warp")) {
            CommandWarp cmdwarp = new CommandWarp(plugin);
            return cmdwarp.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("warplist")) {
            CommandWarplist cmdwarplist = new CommandWarplist(plugin);
            return cmdwarplist.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("whois")) {
            CommandWhois cmdwhois = new CommandWhois(plugin);
            return cmdwhois.execute(sender, args);
        } else if (cmd.getName().equalsIgnoreCase("workbench")) {
            CommandWorkbench cmdworkbench = new CommandWorkbench(plugin);
            return cmdworkbench.execute(sender, args);
        }
        return false;
    }
}