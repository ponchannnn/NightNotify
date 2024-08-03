package com.ponchannn.nightnotify;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static org.bukkit.Sound.ENTITY_HORSE_BREATHE;

public class onEvent implements Listener {
    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e) {


        notifyOnNight(e.getPlayer());
    }

    private void notifyOnNight(Player p) {
        long time = p.getWorld().getTime();
        if (time >= 12541 && time < 23460) {
            p.sendTitle("", ChatColor.AQUA + "夜だよ！寝よう！！！", 10, 60, 20);
        }
    }

    private void notifyEveryone() {
        for (World world : Bukkit.getWorlds()) {
            for(Player player : world.getPlayers()) {
                player.playSound(player.getLocation(), ENTITY_HORSE_BREATHE, 1.0f, 1.0f);
            }
        }
    }

    @EventHandler
    public void onSay (AsyncChatEvent e) {
        for (World world : Bukkit.getWorlds()) {
            for(Player player : world.getPlayers()) {
                player.playNote(player.getLocation(), Instrument.CHIME, Note.flat(0, Note.Tone.G));
            }
        }
    }
}
