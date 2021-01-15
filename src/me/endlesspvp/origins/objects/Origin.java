package me.endlesspvp.origins.objects;

import java.util.List;

import me.endlesspvp.origins.Main;
import me.endlesspvp.origins.api.Origins;

public class Origin {
  Main main = Main.getMain();
  
  String id;
  
  String name;
  
  List<String> perks;
  
  public Origin(String id) {
    this.id = id;
    Origins.origins.put(id, this);
    load();
  }
  
  public void load() {
    String name = this.main.getOrigins().getString(String.valueOf(this.id) + ".name");
    List<String> perks = this.main.getOrigins().getStringList(String.valueOf(this.id) + ".perks");
    this.perks = perks;
    this.name = name;
  }
  
  public void store() {
    this.main.getOrigins().set(String.valueOf(this.id) + ".name", this.name);
    this.main.getOrigins().set(String.valueOf(this.id) + ".perks", this.perks);
    this.main.saveOrigins();
  }
  
  public List<String> getPerks() {
    return this.perks;
  }
  
  public String getName() {
    return this.name;
  }
}
