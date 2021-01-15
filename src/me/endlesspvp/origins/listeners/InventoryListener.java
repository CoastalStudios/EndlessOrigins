package me.endlesspvp.origins.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.endlesspvp.origins.Main;
import me.endlesspvp.origins.api.Origins;
import me.endlesspvp.origins.util.Util;

public class InventoryListener implements Listener {
  Main main = Main.getMain();
  
  @EventHandler(priority = EventPriority.HIGHEST)
  public void onInventoryClick(InventoryClickEvent event) {
    if (!event.isCancelled()) {
      ItemStack is = event.getCurrentItem();
      Player player = (Player)event.getWhoClicked();
      Util.debug("Clicked in inventory");
      if (is != null) {
        Util.debug("Item clicked is not null");
        if (is.hasItemMeta()) {
          Util.debug("Item clicked has item meta");
          ItemMeta im = is.getItemMeta();
          if (im.hasDisplayName()) {
            Util.debug("Item clicked has displayname");
            String name = im.getDisplayName();
            name = name.replaceAll(String.valueOf(""), "");
            Util.debug("Clicked Item Name: " + name);
            if (name.contains("originsgui.filler")) {
              event.setCancelled(true);
            } else if (name.contains("[originsgui.origin]")) {
              event.setCancelled(true);
              String originId = name.split(" ")[0].split("]-")[1];
              Origins.selectedOrigin(player, originId);
            } 
          } 
        } 
      } 
    } 
  }
  
  @EventHandler
  public void onInventoryClose(final InventoryCloseEvent event) {
    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this.main, new Runnable() {
          public void run() {
            Player player = (Player)event.getPlayer();
            if (!Origins.hasOrigin(player.getUniqueId().toString()))
              Origins.openOriginsGUI(player); 
          }
        },  10L);
  }
}
