package org.muawb.plugin.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.muawb.plugin.LocalVillager;

import java.util.Random;

public class Events implements Listener {

    private LocalVillager plugin;

    public Events(LocalVillager plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void chatEntity(PlayerInteractEntityEvent e){
        Player p = e.getPlayer();
        if(e.getRightClicked().getType().equals(EntityType.VILLAGER)) {
            Random r = new Random();
            String s[][] = new String[][] {{plugin.getConfig().getString("Messages.msg1")},
                    {plugin.getConfig().getString("Messages.msg2")},
                    {plugin.getConfig().getString("Messages.msg3")},
                    {plugin.getConfig().getString("Messages.msg4")}};
            int x = r.nextInt(s.length);
           p.sendMessage(s[x]);
        }
    }


}
