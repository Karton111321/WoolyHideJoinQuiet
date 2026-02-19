package com.server.hide;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HideMessages extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        String version = Bukkit.getServer().getVersion();
        if (!version.startsWith("1.21")) {
            getLogger().severe("Ошибка! Этот плагин предназначен только для 1.21x.");
            getLogger().severe("Твоя версия сервера: " + version);
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Плагин WoolyHideJoinQuit успешно запущен!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }
}