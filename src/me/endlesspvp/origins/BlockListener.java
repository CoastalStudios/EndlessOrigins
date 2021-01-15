package me.endlesspvp.origins;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class BlockListener implements Listener {
  Main main = Main.getMain();
  
  @EventHandler(priority = EventPriority.HIGHEST)
  public void onBlockPlace(BlockPlaceEvent event) {
    if (!event.isCancelled()) {
      Block block = event.getBlock();
      block.setMetadata("origins.placed", 
          (MetadataValue)new FixedMetadataValue((Plugin)this.main, event.getPlayer().getUniqueId().toString()));
    } 
  }
}