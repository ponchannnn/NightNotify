package com.ponchannn.nightnotify;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Sound.ENTITY_ENDER_DRAGON_GROWL;

public final class NightNotify extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new onJoin(), this);
        Player player = Bukkit.getPlayer("ponCHANNN");
        player.playSound(player.getLocation(), ENTITY_ENDER_DRAGON_GROWL, 0.5f, 1.0f);
        player.sendTitle("", ChatColor.AQUA + "夜だよ！寝よう！！！", 10, 60, 20);
        new NightCome().runTaskTimer(this, 0, 20 * 10);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}