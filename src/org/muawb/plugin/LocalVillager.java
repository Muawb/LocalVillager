package org.muawb.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class LocalVillager extends JavaPlugin {


    @Override
    public void onEnable(){
        getLogger().info("start");
        Bukkit.getPluginManager().registerEvents(new Events(this), this);
        saveDefaultConfig();
        getLogger().info("Create configuration");
        getCommand("local").setExecutor(new Commands(this));
        getCommand("reloading").setExecutor(new Commands(this));

    }

    @Override
    public void onDisable(){

    }
}
