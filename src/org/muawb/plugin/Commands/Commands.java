package org.muawb.plugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.muawb.plugin.Entity.VillagerEntity;
import org.muawb.plugin.LocalVillager;


public class Commands implements CommandExecutor{


    private final LocalVillager plugin;

    public Commands(LocalVillager plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if(!sender.hasPermission("local.commands")){
            p.sendMessage(ChatColor.RED + "У вас нету прав");
            return true;
        }
        if(args.length == 0) {
            p.sendMessage(ChatColor.GOLD   +      "    LocalVillager");
            p.sendMessage(ChatColor.GREEN  +      "Commands:");
            p.sendMessage(ChatColor.YELLOW +      "/local - " + ChatColor.GRAY + "Available commands");
            p.sendMessage(ChatColor.YELLOW +      "/local spawn - " + ChatColor.GRAY + "spawning for custom villager");
            p.sendMessage(ChatColor.YELLOW +      "/local reload - " + ChatColor.GRAY + "reloading plugin");
            return true;
        }

        if(args[0].equalsIgnoreCase("reload")){
            plugin.reloadConfig();
            p.sendMessage(ChatColor.YELLOW + "Reload complete!");
            return true;
        }

        if(args[0].equalsIgnoreCase("spawn")){
            VillagerEntity v = new VillagerEntity(this.plugin);
            v.onSpawn(p);
            return true;
        }



        return false;
    }
}
