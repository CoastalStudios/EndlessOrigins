package me.endlesspvp.origins.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.endlesspvp.origins.Main;
import me.endlesspvp.origins.api.Origins;
import me.endlesspvp.origins.util.Util;

public class CommandOrigins implements CommandExecutor {
  Main main = Main.getMain();
  
  public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
    if (args.length == 0) {
      if (sender instanceof Player) {
        Player player = (Player)sender;
        if (player.hasPermission("") || player.isOp()) {
          Origins.openOriginsGUI(player);
        } else {
          Util.message(player, "&4ERROR:&7 You do not have permission to use that command.");
        } 
      } 
    } else if (sender.hasPermission("endless.originset") || sender.isOp()) {
      if (args[0].equalsIgnoreCase("set"))
        if (args.length == 3) {
          String p = args[1];
          String originId = args[2];
          Player player = Bukkit.getPlayer(p);
          if (player != null) {
            if (Origins.originExists(originId)) {
              Origins.selectOrigin(player.getUniqueId().toString(), originId);
              Util.message(sender, 
                  "&aYou've set " + player.getName() + "'s Origin Class to " + originId);
              Util.message(player, "&aYou've selected the Origin Class: " + 
                  this.main.getOrigins().getString(String.valueOf(originId) + ".name"));
            } else {
              Util.message(sender, "&4ERROR:&7 Origin Id does not exist.");
            } 
          } else {
            Util.message(sender, "&4ERROR:&7 Target player is not online.");
          } 
        } else {
          Util.message(sender, "&7Usage:&e /origin set <player> <origin>");
        }  
    } else {
      Util.message(sender, "&4ERROR:&7 You do not have permission to use this command");
    } 
    return false;
  }
}
