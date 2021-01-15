package me.endlesspvp.origins.listeners;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Crops;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import me.endlesspvp.origins.Main;
import me.endlesspvp.origins.api.Origins;
import me.endlesspvp.origins.api.Perks;
import me.endlesspvp.origins.objects.Origin;
import me.endlesspvp.origins.objects.Perk;
import me.endlesspvp.origins.util.Util;

public class PerksListener implements Listener {
  Main main = Main.getMain();
  
  HashMap<String, Integer> durabilitycount = new HashMap<>();
  
  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
    if (!event.isCancelled())
      if (!(event.getEntity() instanceof Player)) {
        if (event.getDamager() instanceof Player) {
          Player player = (Player)event.getDamager();
          Origin origin = 
            Origins.getOrigin(this.main.getData().getString(String.valueOf(player.getUniqueId().toString()) + ".origin"));
          if (origin != null) {
            List<String> ps = origin.getPerks();
            for (String p : ps) {
              Util.debug("Found perk: " + p);
              Perk perk = Perks.getPerk(p);
              double percent = perk.getPVEDamageOutIncreased();
              if (percent > 0.0D) {
                double damage = event.getDamage();
                double newdamage = damage * percent / 100.0D;
                Util.debug("Base damage: " + damage);
                Util.debug("Extra Damage: " + newdamage);
                event.setDamage(damage + newdamage);
              } 
              percent = perk.getPVEDamageOutDecreased();
              if (percent > 0.0D) {
                double damage = event.getDamage();
                double decrease = damage * percent / 100.0D;
                Util.debug("Base damage: " + damage);
                Util.debug("Decreased Damage: " + decrease);
                event.setDamage(damage - decrease);
              } 
              percent = perk.getDoubleDamage();
              if (percent > 0.0D) {
                Random random = new Random();
                int r = random.nextInt(101) + 0;
                if (r <= percent) {
                  Util.debug("Double Damage procced. New Damage: " + (event.getDamage() * 2.0D));
                  event.setDamage(event.getDamage() * 2.0D);
                } 
              } 
            } 
          } 
        } 
      } else if (event.getDamager() instanceof Player) {
        Player attacked = (Player)event.getEntity();
        Player damager = (Player)event.getDamager();
        Origin origin = 
          Origins.getOrigin(this.main.getData().getString(String.valueOf(damager.getUniqueId().toString()) + ".origin"));
        if (origin != null) {
          List<String> ps = origin.getPerks();
          for (String p : ps) {
            Util.debug("Found perk: " + p);
            Perk perk = Perks.getPerk(p);
            double percent = perk.getPVPDamageOutIncreased();
            if (percent > 0.0D) {
              double damage = event.getDamage();
              double newdamage = damage * percent / 100.0D;
              Util.debug("Base damage: " + damage);
              Util.debug("Extra Damage: " + newdamage);
              event.setDamage(damage + newdamage);
            } 
            percent = perk.getPVPDamageOutDecreased();
            if (percent > 0.0D) {
              double damage = event.getDamage();
              double decrease = damage * percent / 100.0D;
              Util.debug("Base damage: " + damage);
              Util.debug("Decreased Damage: " + decrease);
              event.setDamage(damage - decrease);
            } 
            percent = perk.getDoubleDamage();
            if (percent > 0.0D) {
              Random random = new Random();
              int r = random.nextInt(101) + 0;
              if (r <= percent) {
                Util.debug("Double Damage procced. New Damage: " + (event.getDamage() * 2.0D));
                event.setDamage(event.getDamage() * 2.0D);
              } 
            } 
          } 
        } else {
          Util.debug("Damager does not have an origin class");
        } 
        origin = Origins.getOrigin(this.main.getData().getString(String.valueOf(attacked.getUniqueId().toString()) + ".origin"));
        if (origin != null) {
          List<String> ps = origin.getPerks();
          for (String p : ps) {
            Util.debug("Found perk: " + p);
            Perk perk = Perks.getPerk(p);
            double percent = perk.getPVPDamageInIncreased();
            if (percent > 0.0D) {
              double damage = event.getDamage();
              double newdamage = damage * percent / 100.0D;
              Util.debug("Base damage: " + damage);
              Util.debug("Extra Damage: " + newdamage);
              event.setDamage(damage + newdamage);
            } 
            percent = perk.getPVPDamageInDecreased();
            if (percent > 0.0D) {
              double damage = event.getDamage();
              double decrease = damage * percent / 100.0D;
              Util.debug("Base damage: " + damage);
              Util.debug("Decreased Damage: " + decrease);
              event.setDamage(damage - decrease);
            } 
          } 
        } else {
          Util.debug(String.valueOf(damager.getName()) + " does not have an origin class");
        } 
      } else {
        Player attacked = (Player)event.getEntity();
        Origin origin = 
          Origins.getOrigin(this.main.getData().getString(String.valueOf(attacked.getUniqueId().toString()) + ".origin"));
        if (origin != null) {
          List<String> ps = origin.getPerks();
          for (String p : ps) {
            Util.debug("Found perk: " + p);
            Perk perk = Perks.getPerk(p);
            double percent = perk.getPVEDamageInIncreased();
            if (percent > 0.0D) {
              double damage = event.getDamage();
              double newdamage = damage * percent / 100.0D;
              Util.debug("Base damage: " + damage);
              Util.debug("Extra Damage: " + newdamage);
              event.setDamage(damage + newdamage);
            } 
            percent = perk.getPVEDamageInDecreased();
            if (percent > 0.0D) {
              double damage = event.getDamage();
              double decrease = damage * percent / 100.0D;
              Util.debug("Base damage: " + damage);
              Util.debug("Decreased Damage: " + decrease);
              event.setDamage(damage - decrease);
            } 
          } 
        } else {
          Util.debug(String.valueOf(attacked.getName()) + " does not have an origin class");
        } 
      }  
  }
  
  @EventHandler(priority = EventPriority.MONITOR)
  public void onEntityDeath(EntityDeathEvent event) {
    Player player = event.getEntity().getKiller();
    if (player != null) {
      Origin origin = Origins.getOrigin(this.main.getData().getString(String.valueOf(player.getUniqueId().toString()) + ".origin"));
      if (origin != null)
        for (String s : origin.getPerks()) {
          Perk perk = Perks.getPerk(s);
          double percent = perk.getExpBoostIncreased();
          if (percent > 0.0D) {
            int exp = event.getDroppedExp();
            int newexp = (int)(exp * percent / 100.0D);
            Util.debug("Base Exp: " + exp);
            Util.debug("New Exp: " + newexp);
            event.setDroppedExp(exp + newexp);
          } 
          percent = perk.getExpBoostDecreased();
          if (percent > 0.0D) {
            int exp = event.getDroppedExp();
            int decreased = (int)(exp * percent / 100.0D);
            Util.debug("Base Exp: " + exp);
            Util.debug("Decreased Exp: " + decreased);
            event.setDroppedExp(exp - decreased);
          } 
        }  
    } 
  }
  
  @EventHandler(priority = EventPriority.MONITOR)
  public void onBlockBreak(BlockBreakEvent event) {
    if (!event.isCancelled()) {
      Player player = event.getPlayer();
      Block block = event.getBlock();
      String type = block.getType().toString().toLowerCase();
      Util.debug("Broke Type: " + type);
      if (!block.hasMetadata("origins.placed")) {
        if (block.getType().toString().toLowerCase().contains("_ore")) {
          Origin origin = Origins.getPlayerOrigin(player.getUniqueId().toString());
          for (String s : origin.getPerks()) {
            Perk perk = Perks.getPerk(s);
            double percent = perk.getDoubleDropChance();
            if (percent > 0.0D) {
              Util.debug("Has double drop chance perk");
              Random random = new Random();
              int r = random.nextInt(101) + 0;
              if (r <= percent) {
                Util.debug("Dropping extra drops.");
                for (ItemStack drop : block.getDrops())
                  block.getWorld().dropItemNaturally(block.getLocation(), drop); 
              } 
            } 
            percent = perk.getAutoSmelt();
            if (percent > 0.0D && 
              isMetal(block.getType())) {
              Util.debug("Has auto smelt perk");
              Random random = new Random();
              int r = random.nextInt(101) + 0;
              if (r <= percent) {
                Material mat = null;
                if (block.getType() == Material.IRON_ORE) {
                  mat = Material.IRON_INGOT;
                } else if (block.getType() == Material.GOLD_ORE) {
                  mat = Material.GOLD_INGOT;
                } 
                if (mat != null) {
                  Util.debug("Dropping smelted metal");
                  ItemStack is = new ItemStack(mat);
                  event.setCancelled(true);
                  event.getBlock().setType(Material.AIR);
                  event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), 
                      is);
                  continue;
                } 
                Util.debug("Can't melt Ore: " + block.getType().toString());
              } 
            } 
          } 
        } else if (isCrop(block.getType())) {
          Origin origin = Origins.getPlayerOrigin(player.getUniqueId().toString());
          for (String s : origin.getPerks()) {
            Perk perk = Perks.getPerk(s);
            double percent = perk.getCropDropChance();
            Util.debug("Percentage: " + percent);
            if (percent > 0.0D) {
              Util.debug("Has double drop chance perk");
              Random random = new Random();
              int r = random.nextInt(101) + 0;
              if (r <= percent) {
                Util.debug("Dropping extra drops.");
                for (ItemStack drop : block.getDrops())
                  block.getWorld().dropItemNaturally(block.getLocation(), drop); 
              } 
            } 
          } 
        } 
      } else {
        if (isCrop(block.getType())) {
          Origin origin = Origins.getPlayerOrigin(player.getUniqueId().toString());
          for (String s : origin.getPerks()) {
            Perk perk = Perks.getPerk(s);
            double percent = perk.getCropDropChance();
            Util.debug("Percentage: " + percent);
            if (percent > 0.0D) {
              Util.debug("Has double drop chance perk");
              Random random = new Random();
              int r = random.nextInt(101) + 0;
              Util.debug("Random: " + r);
              if (r <= percent) {
                Util.debug("Dropping extra drops.");
                for (ItemStack drop : block.getDrops())
                  block.getWorld().dropItemNaturally(block.getLocation(), drop); 
              } 
            } 
          } 
        } 
        block.removeMetadata("origins.increasedgrowth", (Plugin)this.main);
        block.removeMetadata("origins.decreasedgrowth", (Plugin)this.main);
        block.removeMetadata("origins.placed", (Plugin)this.main);
        Util.debug("Cleared block data");
      } 
    } 
  }
  
  @EventHandler
  public void onCropGrowth(BlockGrowEvent event) {
    if (event.getBlock().hasMetadata("origins.placed")) {
      Util.debug("Player placed crop that is growing");
      Util.debug("From Data: " + event.getBlock().getState().getData().getData());
      Util.debug("To Data: " + event.getNewState().getData().getData());
      Util.debug("TYPE: " + event.getBlock().getType().toString());
      String uuid = ((MetadataValue)event.getBlock().getMetadata("origins.placed").get(0)).asString();
      Origin origin = Origins.getPlayerOrigin(uuid);
      for (String s : origin.getPerks()) {
        Util.debug("Found perk: " + s);
        Perk perk = Perks.getPerk(s);
        double percent = perk.getCropGrowthRateIncreased();
        Util.debug("Percent: " + percent);
        if (percent > 0.0D && 
          event.getBlock().getData() != 7) {
          Util.debug("Not fully grown INC");
          if (!event.getBlock().hasMetadata("origins.increasedgrowth")) {
            Util.debug("Not received boost before");
            int k = (int)(percent * 7.0D / 100.0D);
            Util.debug("Old Data: " + event.getBlock().getState().getData().getData());
            byte data = (byte)(event.getNewState().getData().getData() + k);
            Util.debug("New data: " + data);
            event.getBlock().setData(data);
            Crops crop = (Crops)event.getBlock().getState().getData();
            crop.setData(data);
            event.getNewState().setData((MaterialData)crop);
            event.getBlock().setMetadata("origins.increasedgrowth", (MetadataValue)new FixedMetadataValue((Plugin)this.main, "b"));
            Util.debug("Set block data: " + k);
          } else {
            Util.debug("Found origins.increasedgrowth - " + (
                (MetadataValue)event.getBlock().getMetadata("origins.increasedgrowth").get(0)).asString());
          } 
        } 
        percent = perk.getCropGrowthRateDecreased();
        if (percent > 0.0D && 
          event.getBlock().getData() != 1) {
          Util.debug("Not fully grown DEC");
          if (!event.getBlock().hasMetadata("origins.decreasedgrowth")) {
            int k = (int)(percent * 7.0D / 100.0D);
            event.getBlock().setData((byte)(event.getBlock().getData() + 2 - k));
            event.getBlock().setMetadata("origins.decreasedgrowth", (MetadataValue)new FixedMetadataValue((Plugin)this.main, "a"));
            Util.debug("Set block data: " + k);
          } 
        } 
      } 
    } 
  }
  
  @EventHandler
  public void onItemDamage(PlayerItemDamageEvent event) {
    Player player = event.getPlayer();
    String uuid = player.getUniqueId().toString();
    Origin origin = Origins.getPlayerOrigin(uuid);
    if (origin != null) {
      for (String s : origin.getPerks()) {
        Util.debug("Found perk: " + s);
        Perk perk = Perks.getPerk(s);
        double percent = perk.getIncreasedDurability();
        Util.debug("Percent: " + percent);
        if (percent > 0.0D) {
          int dbc = 0;
          if (this.durabilitycount.containsKey(uuid))
            dbc = ((Integer)this.durabilitycount.get(uuid)).intValue(); 
          if (dbc <= percent) {
            event.setDamage(0);
            dbc++;
            Util.debug("Not taking damage");
          } else if (dbc >= 100) {
            dbc = 0;
          } else {
            dbc++;
          } 
          this.durabilitycount.put(uuid, Integer.valueOf(dbc));
        } 
      } 
    } else {
      Util.debug(String.valueOf(player.getName()) + " does not have an origin class.");
    } 
  }
  
  public boolean isCrop(Material mat) {
    if (mat == Material.CARROT || mat == Material.POTATO || mat == Material.CROPS || mat == Material.PUMPKIN || 
      mat == Material.SUGAR_CANE_BLOCK || mat == Material.SUGAR_CANE || mat == Material.CACTUS || 
      mat == Material.NETHER_WARTS || mat == Material.PUMPKIN_STEM)
      return true; 
    return false;
  }
  
  public boolean isMetal(Material mat) {
    if (mat == Material.IRON_ORE || mat == Material.GOLD_ORE)
      return true; 
    return false;
  }
}
