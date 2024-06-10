package com.ponchannn.nightnotify;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class NightCome extends BukkitRunnable {

    @Override
    public void run() {
        for (World world : Bukkit.getWorlds()) {
            if (!world.isNatural()) return;
            long time = world.getTime();
            if (time >= 12541 && time <= 12541 + 194) {
                for (Player player : world.getPlayers())
                player.sendTitle("", ChatColor.AQUA + "夜だよ！寝よう！！！", 10, 60, 20);
            }
        }
    }
}
