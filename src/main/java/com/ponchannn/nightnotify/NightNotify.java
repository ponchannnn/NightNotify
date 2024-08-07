package com.ponchannn.nightnotify;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;


public final class NightNotify extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        new NightCome().runTaskTimer(this, 0, 20 * 10);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        HandlerList.unregisterAll();
    }
}