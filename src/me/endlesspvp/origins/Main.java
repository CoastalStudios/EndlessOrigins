package me.endlesspvp.origins;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.endlesspvp.origins.api.Origins;
import me.endlesspvp.origins.api.Perks;
import me.endlesspvp.origins.commands.CommandOrigins;
import me.endlesspvp.origins.listeners.InventoryListener;
import me.endlesspvp.origins.listeners.PerksListener;
import me.endlesspvp.origins.listeners.PlayerListener;

public class Main extends JavaPlugin {
  static Main main;
  
  File messagesFile;
  
  FileConfiguration messages;
  
  File originsFile;
  
  FileConfiguration origins;
  
  File perksFile;
  
  FileConfiguration perks;
  
  File dataFile;
  
  FileConfiguration data;
  
  public static Main getMain() {
    return main;
  }
  
  public void onEnable() {
    main = this;
    LoadYMLFiles();
    RegisterListeners();
    RegisterCommands();
    Perks.loadPerks();
    Origins.loadOrigins();
    Origins.setupOriginsGUI();
  }
  
  void LoadYMLFiles() {
    saveDefaultConfig();
    this.messagesFile = new File(getDataFolder(), "messages.yml");
    if (!this.messagesFile.exists()) {
      this.messagesFile.getParentFile().mkdirs();
      saveResource("messages.yml", false);
    } 
    this.messages = (FileConfiguration)new YamlConfiguration();
    try {
      this.messages.load(this.messagesFile);
    } catch (IOException|org.bukkit.configuration.InvalidConfigurationException e) {
      e.printStackTrace();
    } 
    this.dataFile = new File(getDataFolder(), "data.yml");
    if (!this.dataFile.exists()) {
      this.dataFile.getParentFile().mkdirs();
      saveResource("data.yml", false);
    } 
    this.data = (FileConfiguration)new YamlConfiguration();
    try {
      this.data.load(this.dataFile);
    } catch (IOException|org.bukkit.configuration.InvalidConfigurationException e) {
      e.printStackTrace();
    } 
    this.originsFile = new File(getDataFolder(), "origins.yml");
    if (!this.originsFile.exists()) {
      this.originsFile.getParentFile().mkdirs();
      saveResource("origins.yml", false);
    } 
    this.origins = (FileConfiguration)new YamlConfiguration();
    try {
      this.origins.load(this.originsFile);
    } catch (IOException|org.bukkit.configuration.InvalidConfigurationException e) {
      e.printStackTrace();
    } 
    this.perksFile = new File(getDataFolder(), "perks.yml");
    if (!this.perksFile.exists()) {
      this.perksFile.getParentFile().mkdirs();
      saveResource("perks.yml", false);
    } 
    this.perks = (FileConfiguration)new YamlConfiguration();
    try {
      this.perks.load(this.perksFile);
    } catch (IOException|org.bukkit.configuration.InvalidConfigurationException e) {
      e.printStackTrace();
    } 
  }
  
  public void saveMessages() {
    try {
      this.messages.save(this.messagesFile);
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void saveData() {
    try {
      this.data.save(this.dataFile);
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void saveOrigins() {
    try {
      this.origins.save(this.originsFile);
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void savePerks() {
    try {
      this.perks.save(this.perksFile);
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public FileConfiguration getMessages() {
    return this.messages;
  }
  
  public FileConfiguration getData() {
    return this.data;
  }
  
  public FileConfiguration getOrigins() {
    return this.origins;
  }
  
  public FileConfiguration getPerks() {
    return this.perks;
  }
  
  void RegisterListeners() {
    getServer().getPluginManager().registerEvents((Listener)new InventoryListener(), (Plugin)this);
    getServer().getPluginManager().registerEvents((Listener)new PlayerListener(), (Plugin)this);
    getServer().getPluginManager().registerEvents((Listener)new PerksListener(), (Plugin)this);
    getServer().getPluginManager().registerEvents(new BlockListener(), (Plugin)this);
  }
  
  void RegisterCommands() {
    getCommand("origins").setExecutor((CommandExecutor)new CommandOrigins());
  }
}
