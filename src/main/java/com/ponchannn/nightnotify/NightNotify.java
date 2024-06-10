package com.ponchannn.nightnotify;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class NightNotify extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
//        Bukkit.getLogger().info(Bukkit.getPlayer("ponCHANNN").toString());
        new NightCome().runTaskTimer(this, 0, 20 * 10);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}