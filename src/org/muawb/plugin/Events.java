package org.muawb.plugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.Random;

public class Events implements Listener {

    private LocalVillager plugin;

    public Events(LocalVillager plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onSpawn(Player player) {
        player.sendMessage(ChatColor.AQUA + "Villager spawning... ");
        Villager v = (Villager) player.getLocation().getWorld().spawn(player.getLocation(), Villager.class);

        String s = plugin.getConfig().getString("customname.name");
        s = s.replace("&", "\u00A7");
        v.setCustomName(s);
        v.setCustomNameVisible(true);
        v.setAgeLock(true);


    }
    @EventHandler
    public void chatEntity(PlayerInteractEntityEvent e){
        Player p = e.getPlayer();
        if(e.getRightClicked().getType().equals(EntityType.VILLAGER)) {
            Random r = new Random();
            String s[][] = new String[][] {{plugin.getConfig().getString("messages.message1")},{plugin.getConfig().getString("messages.message2")},{plugin.getConfig().getString("messages.message3")},{plugin.getConfig().getString("messages.message4")}};
            int x = r.nextInt(s.length);
           p.sendMessage(s[x]);
        }
    }


}
