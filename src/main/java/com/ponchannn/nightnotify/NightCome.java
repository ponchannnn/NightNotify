package com.ponchannn.nightnotify;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.TitlePart;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Sound.ENTITY_WOLF_HOWL;

public class NightCome extends BukkitRunnable {

    @Override
    public void run() {
        for (World world : Bukkit.getWorlds()) {
            if (!world.isNatural()) return;
            long time = world.getTime();
            if ((time >= 12541 && time <= 12541 + 194 && world.isClearWeather()) || (time >= 12010 && time <= 12541 + 194 && !world.isClearWeather())) {
                for (Player player : world.getPlayers()) {
                    ((Audience) player).sendTitlePart(TitlePart.SUBTITLE, Component.text("夜だよ！早く寝よう！！！", TextColor.color(255f, 192f, 203f)));
                    player.playSound(player.getLocation(), ENTITY_WOLF_HOWL, 0.3f, 1.0f);
                }


            }
        }
    }
}
