package com.ponchannn.nightnotify;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static org.bukkit.Sound.ENTITY_ENDER_DRAGON_GROWL;

public class onJoin implements Listener {
    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e) {
        long time = e.getPlayer().getWorld().getTime();
        if (time >= 12541 && time < 23460) {
            e.getPlayer().sendTitle("", ChatColor.AQUA + "夜だよ！寝よう！！！", 10, 60, 20);
        }
    }
}
