package me.endlesspvp.origins.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.endlesspvp.origins.Main;
import me.endlesspvp.origins.objects.Perk;
import me.endlesspvp.origins.util.Util;

public class Perks {
  public static HashMap<String, Perk> perks = new HashMap<>();
  
  public static void loadPerks() {
    Main main = Main.getMain();
    for (String s : main.getPerks().getConfigurationSection("").getKeys(false))
      Util.debug("Found Perk: " + s); 
  }
  
  public static Perk getPerk(String id) {
    return perks.get(id);
  }
  
  public static List<Perk> getAllPerks() {
    List<Perk> list = new ArrayList<>();
    for (Perk perk : perks.values())
      list.add(perk); 
    return list;
  }
  
  public static void storePerks() {
    for (Perk perk : perks.values())
      perk.store(); 
  }
  
  public static boolean perkExists(String id) {
    if (perks.containsKey(id))
      return true; 
    return false;
  }
}
