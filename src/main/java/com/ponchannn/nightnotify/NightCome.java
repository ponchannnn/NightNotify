package com.ponchannn.nightnotify;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.Duration;

import static org.bukkit.Sound.ENTITY_WOLF_HOWL;

public class NightCome extends BukkitRunnable {

    @Override
    public void run() {
        for (World world : Bukkit.getWorlds()) {
            if (!world.isNatural()) return;
            long time = world.getTime();
            if ((time >= 12541 && time <= 12541 + 194 && world.isClearWeather()) || (time >= 12010 && time <= 12541 + 194 && !world.isClearWeather())) {
                for (Player player : world.getPlayers()) {
                    player.showTitle(Title.title(Component.empty(), Component.text("夜だよ！早く寝よう！！！", TextColor.color(255, 192, 203)), Title.Times.times(Duration.ZERO, Duration.ofSeconds(2), Duration.ofSeconds(1))));
                    player.playSound(player.getLocation(), ENTITY_WOLF_HOWL, 0.3f, 1.0f);
                }


            }
        }
    }
}
