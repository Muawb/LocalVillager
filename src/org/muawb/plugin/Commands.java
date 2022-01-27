package org.muawb.plugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Commands implements CommandExecutor{


    private final LocalVillager plugin;

    public Commands(LocalVillager plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if(!sender.hasPermission("local.spawn")){
            p.sendMessage(ChatColor.RED + "You dont have permission");
            return true;
        }
        if(command.getName().equalsIgnoreCase("local")) {
            Events Event = new Events(plugin);
            Event.onSpawn(p);
        }
        if(command.getName().equalsIgnoreCase("reloading")){
            plugin.reloadConfig();
            p.sendMessage(ChatColor.YELLOW + "Configuration reload");
            return true;
        }



        return false;
    }
}
