package me.endlesspvp.origins.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.endlesspvp.origins.Main;

public class Util {
  public static void debug(String message) {
    Main main = Main.getMain();
    if (main.getConfig().getBoolean("debug"))
      System.out.println("[DEBUG EndlessOrigins] - " + message); 
  }
  
  public static double round(double value, int places) {
    if (places < 0)
      throw new IllegalArgumentException(); 
    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }
  
  public static void Broadcast(String message) {
    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
  }
  
  public static String FormatMoney(double value) {
    String output = NumberFormat.getNumberInstance(Locale.US).format(value);
    return output;
  }
  
  public static void message(CommandSender sender, String message) {
    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
  }
  
  public static boolean isInteger(String str) {
    if (str == null)
      return false; 
    if (str.isEmpty())
      return false; 
    int i = 0;
    int length = str.length();
    if (str.charAt(0) == '-') {
      if (length == 1)
        return false; 
      i = 1;
    } 
    for (; i < length; i++) {
      char c = str.charAt(i);
      if (c < '0' || c > '9')
        return false; 
    } 
    return true;
  }
  
  public static void msg(Player player, String path) {
    Main main = Main.getMain();
    String message = main.getConfig().getString(path);
    if (message != null) {
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    } else {
      debug("Message path not found: " + path);
    } 
  }
  
  public static void message(Player player, String message) {
    player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
  }
  
  public static void msg(Player player, String path, String repl, String with) {
    Main main = Main.getMain();
    String message = main.getConfig().getString(path);
    if (message != null) {
      message = message.replaceAll(repl, with);
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    } else {
      debug("Message path not found: " + path);
    } 
  }
  
  public static String trim(String string, int maxLength) {
    if (string.length() > 32) {
      String newString = "";
      for (int i = 0; i < string.length(); i++) {
        if (i < maxLength)
          newString = String.valueOf(newString) + string.charAt(i); 
      } 
      debug(newString);
      return newString;
    } 
    return string;
  }
  
  public static String HideString(String string) {
    StringBuilder builder = new StringBuilder();
    byte b;
    int i;
    char[] arrayOfChar;
    for (i = (arrayOfChar = string.toCharArray()).length, b = 0; b < i; ) {
      char c = arrayOfChar[b];
      builder.append("").append(c);
      b++;
    } 
    return builder.toString();
  }
  
  public static Location StringToLocation(String locString) {
    return new Location(Bukkit.getWorld(locString.split(" ")[0]), Double.parseDouble(locString.split(" ")[1]), 
        Double.parseDouble(locString.split(" ")[2]), Double.parseDouble(locString.split(" ")[3]));
  }
  
  public static String LocationToString(Location location) {
    return String.valueOf(location.getWorld().getName()) + " " + location.getBlockX() + " " + location.getBlockY() + " " + 
      location.getBlockZ();
  }
}
