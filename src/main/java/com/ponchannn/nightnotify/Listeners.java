package com.ponchannn.nightnotify;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.time.Duration;

import static org.bukkit.Sound.ENTITY_EGG_THROW;
import static org.bukkit.Sound.ITEM_GOAT_HORN_SOUND_0;

public class Listeners implements org.bukkit.event.Listener {
    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e) {
        notifyEveryone();
        notifyOnNight(e.getPlayer());
    }

    private void notifyOnNight(Player player) {
        World playerWorld = player.getWorld();
        if (!playerWorld.isNatural()) return;
        long time = playerWorld.getTime();
        if ((time >= 12541 && time <= 23459 && playerWorld.isClearWeather()) || (time >= 12010 && time <= 23991 && !playerWorld.isClearWeather())) {
            player.showTitle(Title.title(Component.empty(), Component.text("夜だよ！早く寝よう！！！", TextColor.color(255, 192, 203)), Title.Times.times(Duration.ZERO, Duration.ofSeconds(2), Duration.ofSeconds(1))));
        }
    }

    private void notifyEveryone() {
        for (World world : Bukkit.getWorlds()) {
            for(Player player : world.getPlayers()) {
                player.playSound(player.getLocation(), ITEM_GOAT_HORN_SOUND_0, 0.5f, 1.0f);
            }
        }
    }

    @EventHandler
    public void onSay (AsyncChatEvent e) {
        for (World world : Bukkit.getWorlds()) {
            for(Player player : world.getPlayers()) {
                player.playSound(player.getLocation(), ENTITY_EGG_THROW, 0.5f, 1.0f);
            }
        }
    }
}
