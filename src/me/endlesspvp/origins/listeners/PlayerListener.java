package me.endlesspvp.origins.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import me.endlesspvp.origins.Main;
import me.endlesspvp.origins.api.Origins;

public class PlayerListener implements Listener {
  Main main = Main.getMain();
  
  @EventHandler
  public void onPlayerJoin(final PlayerJoinEvent event) {
    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this.main, new Runnable() {
          public void run() {
            if (!Origins.hasOrigin(event.getPlayer().getUniqueId().toString()))
              Origins.openOriginsGUI(event.getPlayer()); 
          }
        },  20L);
  }
}
