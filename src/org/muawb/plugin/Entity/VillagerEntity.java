package org.muawb.plugin.Entity;

import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.muawb.plugin.LocalVillager;

public class VillagerEntity {

    private LocalVillager plugin;

    public VillagerEntity(LocalVillager plugin){
        this.plugin = plugin;
    }

    public void onSpawn(Player player) {
        String spawn = plugin.getConfig().getString("Spawn.message");
        spawn = spawn.replace("&", "\u00a7");
        player.sendMessage(spawn);
        Villager v = player.getLocation().getWorld().spawn(player.getLocation(), Villager.class);

        String name = plugin.getConfig().getString("Customname.name");
        name = name.replace("&", "\u00A7");
        v.setCustomName(name);
        v.setCustomNameVisible(true);
        v.setAgeLock(true);


    }
}
