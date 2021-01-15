package me.endlesspvp.origins.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.endlesspvp.origins.Main;
import me.endlesspvp.origins.objects.Origin;
import me.endlesspvp.origins.util.Util;

public class Origins {
  public static HashMap<String, Origin> origins = new HashMap<>();
  
  public static HashMap<String, String> selectedorigin = new HashMap<>();
  
  static Inventory originsInv;
  
  public static void loadOrigins() {
    Main main = Main.getMain();
    if (main.getOrigins().getConfigurationSection("") != null)
      for (String s : main.getOrigins().getConfigurationSection("").getKeys(false))
        Util.debug("Found Origin: " + s);  
  }
  
  public static Origin getOrigin(String id) {
    return origins.get(id);
  }
  
  public static Origin getPlayerOrigin(String uuid) {
    return getOrigin(Main.getMain().getData().getString(String.valueOf(uuid) + ".origin"));
  }
  
  public static List<Origin> getAllOrigins() {
    List<Origin> list = new ArrayList<>();
    for (Origin origin : origins.values())
      list.add(origin); 
    return list;
  }
  
  public static void storeOrigins() {
    for (Origin origin : origins.values())
      origin.store(); 
  }
  
  public static boolean originExists(String id) {
    if (origins.containsKey(id))
      return true; 
    return false;
  }
  
  public static void setupOriginsGUI() {
    Main main = Main.getMain();
    originsInv = Bukkit.createInventory(null, main.getConfig().getInt("gui.size"), 
        ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("gui.title")));
    for (String s : origins.keySet()) {
      String type = main.getOrigins().getString(String.valueOf(s) + ".gui.type");
      Util.debug("Type: " + type);
      byte data = (byte)main.getOrigins().getInt(String.valueOf(s) + ".gui.data");
      int slot = main.getOrigins().getInt(String.valueOf(s) + ".gui.slot");
      String name = main.getOrigins().getString(String.valueOf(s) + ".name");
      String displayname = main.getOrigins().getString(String.valueOf(s) + ".gui.displayname");
      displayname = displayname.replaceAll("%name%", name);
      List<String> lore = new ArrayList<>();
      for (String str : main.getOrigins().getStringList(String.valueOf(s) + ".gui.lore"))
        lore.add(ChatColor.translateAlternateColorCodes('&', str.replaceAll("%name%", name))); 
      ItemStack is = new ItemStack(Material.getMaterial(type), 1, data);
      ItemMeta im = is.getItemMeta();
      im.setDisplayName(String.valueOf(Util.HideString("[originsgui.origin]-" + s + " ")) + 
          ChatColor.translateAlternateColorCodes('&', displayname));
      im.setLore(lore);
      is.setItemMeta(im);
      originsInv.setItem(slot, is);
    } 
    addFiller(originsInv);
  }
  
  public static void addFiller(Inventory inv) {
    Main main = Main.getMain();
    ItemStack is = new ItemStack(Material.getMaterial(main.getConfig().getString("gui.filler.type")), 1, 
        (byte)main.getConfig().getInt("gui.filler.data"));
    ItemMeta im = is.getItemMeta();
    im.setDisplayName(Util.HideString("[originsgui.filler]"));
    is.setItemMeta(im);
    for (int i = 0; i < inv.getSize(); i++) {
      if (inv.getItem(i) == null)
        inv.setItem(i, is); 
    } 
  }
  
  public static void openOriginsGUI(Player player) {
    player.openInventory(originsInv);
  }
  
  public static void selectedOrigin(Player player, String id) {
    Main main = Main.getMain();
    Util.debug(String.valueOf(player.getName()) + " has clicked on the " + id + " Origin!");
    if (!hasOrigin(player.getUniqueId().toString())) {
      if (originExists(id)) {
        selectOrigin(player.getUniqueId().toString(), id);
        player.closeInventory();
        Util.message(player, 
            main.getMessages().getString("selected.self").replaceAll("%origin%", getOrigin(id).getName()));
        Util.Broadcast(main.getMessages().getString("selected.broadcast")
            .replaceAll("%player%", player.getName()).replaceAll("%origin%", getOrigin(id).getName()));
      } else {
        Util.message(player, "&4ERROR:&7 Selected Origin does not exist.");
      } 
    } else {
      Util.debug(String.valueOf(player.getName()) + " already has a Origin!");
    } 
  }
  
  public static void selectOrigin(String uuid, String id) {
    Main main = Main.getMain();
    main.getData().set(String.valueOf(uuid) + ".origin", id);
    main.saveData();
    selectedorigin.put(uuid, id);
  }
  
  public static boolean hasOrigin(String uuid) {
    Main main = Main.getMain();
    if (main.getData().getString(String.valueOf(uuid) + ".origin") != null)
      return true; 
    return false;
  }
}
