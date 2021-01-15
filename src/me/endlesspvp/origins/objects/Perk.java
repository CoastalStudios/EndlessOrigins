package me.endlesspvp.origins.objects;

import me.endlesspvp.origins.Main;
import me.endlesspvp.origins.api.Perks;
import me.endlesspvp.origins.util.Util;

public class Perk {
  Main main = Main.getMain();
  
  String id;
  
  double pvedamage_out_inc;
  
  double pvedamage_out_dec;
  
  double pvedamage_in_inc;
  
  double pvedamage_in_dec;
  
  double pvpdamage_out_inc;
  
  double pvpdamage_out_dec;
  
  double pvpdamage_in_inc;
  
  double pvpdamage_in_dec;
  
  double moblootbonus;
  
  double doubledamage;
  
  double cropgrowthrate_inc;
  
  double cropgrowthrate_dec;
  
  double cropdropchance;
  
  double increaseddurability;
  
  double expboost_inc;
  
  double expboost_dec;
  
  double doubledropchance;
  
  double autosmelt;
  
  double enchanterdiscount;
  
  double enchantproccchance;
  
  public Perk(String id) {
    this.id = id;
    Perks.perks.put(id, this);
    load();
  }
  
  public double getPVEDamageOutIncreased() {
    return this.pvedamage_out_inc;
  }
  
  public double getPVEDamageOutDecreased() {
    return this.pvedamage_out_dec;
  }
  
  public double getPVEDamageInIncreased() {
    return this.pvedamage_in_inc;
  }
  
  public double getPVEDamageInDecreased() {
    return this.pvedamage_in_dec;
  }
  
  public double getPVPDamageOutIncreased() {
    return this.pvpdamage_out_inc;
  }
  
  public double getPVPDamageOutDecreased() {
    return this.pvpdamage_in_dec;
  }
  
  public double getPVPDamageInIncreased() {
    return this.pvpdamage_out_inc;
  }
  
  public double getPVPDamageInDecreased() {
    return this.pvpdamage_in_dec;
  }
  
  public double getDoubleDamage() {
    return this.doubledamage;
  }
  
  public double getExpBoostIncreased() {
    return this.expboost_inc;
  }
  
  public double getExpBoostDecreased() {
    return this.expboost_dec;
  }
  
  public double getDoubleDropChance() {
    return this.doubledropchance;
  }
  
  public double getCropDropChance() {
    return this.cropdropchance;
  }
  
  public double getAutoSmelt() {
    return this.autosmelt;
  }
  
  public double getCropGrowthRateIncreased() {
    return this.cropgrowthrate_inc;
  }
  
  public double getCropGrowthRateDecreased() {
    return this.cropgrowthrate_dec;
  }
  
  public double getIncreasedDurability() {
    return this.increaseddurability;
  }
  
  public void load() {
    String pvedamage_out_inc = this.main.getPerks().getString(String.valueOf(this.id) + ".outgoing-pve-damage.increased");
    String pvedamage_in_inc = this.main.getPerks().getString(String.valueOf(this.id) + ".incoming-pve-damage.increased");
    String pvedamage_out_dec = this.main.getPerks().getString(String.valueOf(this.id) + ".outgoing-pve-damage.decreased");
    String pvedamage_in_dec = this.main.getPerks().getString(String.valueOf(this.id) + ".incoming-pve-damage.decreased");
    String pvpdamage_out_inc = this.main.getPerks().getString(String.valueOf(this.id) + ".outgoing-pvp-damage.increased");
    String pvpdamage_in_inc = this.main.getPerks().getString(String.valueOf(this.id) + ".incoming-pvp-damage.increased");
    String pvpdamage_out_dec = this.main.getPerks().getString(String.valueOf(this.id) + ".outgoing-pvp-damage.decreased");
    String pvpdamage_in_dec = this.main.getPerks().getString(String.valueOf(this.id) + ".incoming-pvp-damage.decreased");
    String moblootbonus = this.main.getPerks().getString(String.valueOf(this.id) + ".mob-loot-bonus");
    String doubledamage = this.main.getPerks().getString(String.valueOf(this.id) + ".double-damage");
    String cropgrowthrate_inc = this.main.getPerks().getString(String.valueOf(this.id) + ".crop-growth-rate.increased");
    String cropgrowthrate_dec = this.main.getPerks().getString(String.valueOf(this.id) + ".crop-growth-rate.decreased");
    String cropdropchance = this.main.getPerks().getString(String.valueOf(this.id) + ".crop-drop-chance");
    String increaseddurability = this.main.getPerks().getString(String.valueOf(this.id) + ".increased-durability");
    String expboost_inc = this.main.getPerks().getString(String.valueOf(this.id) + ".exp-boost.increased");
    String expboost_dec = this.main.getPerks().getString(String.valueOf(this.id) + ".exp-boost.decreased");
    String doubledropchance = this.main.getPerks().getString(String.valueOf(this.id) + ".double-drop-chance");
    String autosmelt = this.main.getPerks().getString(String.valueOf(this.id) + ".auto-smelt");
    String enchanterdiscount = this.main.getPerks().getString(String.valueOf(this.id) + ".enchanter-discount");
    String enchantproccchance = this.main.getPerks().getString(String.valueOf(this.id) + ".enchant-procc-chance");
    if (pvedamage_out_inc != null)
      if (pvedamage_out_inc.contains("%")) {
        this.pvedamage_out_inc = Double.parseDouble(pvedamage_out_inc.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".outgoing-pve-damage.increased || Needs to be a percentage. Ex: 5%");
      }  
    if (pvedamage_out_dec != null)
      if (pvedamage_out_dec.contains("%")) {
        this.pvedamage_out_inc = Double.parseDouble(pvedamage_out_dec.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".outgoing-pve-damage.decreased || Needs to be a percentage. Ex: 5%");
      }  
    if (pvedamage_in_dec != null)
      if (pvedamage_in_dec.contains("%")) {
        this.pvedamage_in_inc = Double.parseDouble(pvedamage_in_dec.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".outgoing-pve-damage.decreased || Needs to be a percentage. Ex: 5%");
      }  
    if (pvedamage_in_inc != null)
      if (pvedamage_in_inc.contains("%")) {
        this.pvedamage_in_inc = Double.parseDouble(pvedamage_in_inc.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".outgoing-pve-damage.increased || Needs to be a percentage. Ex: 5%");
      }  
    if (pvpdamage_out_inc != null)
      if (pvpdamage_out_inc.contains("%")) {
        this.pvpdamage_out_inc = Double.parseDouble(pvpdamage_out_inc.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".outgoing-pvp-damage.increased || Needs to be a percentage. Ex: 5%");
      }  
    if (pvpdamage_out_dec != null)
      if (pvpdamage_out_dec.contains("%")) {
        this.pvpdamage_out_inc = Double.parseDouble(pvpdamage_out_dec.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".outgoing-pvp-damage.decreased || Needs to be a percentage. Ex: 5%");
      }  
    if (pvpdamage_in_dec != null)
      if (pvpdamage_in_dec.contains("%")) {
        this.pvpdamage_in_inc = Double.parseDouble(pvpdamage_in_dec.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".outgoing-pvp-damage.decreased || Needs to be a percentage. Ex: 5%");
      }  
    if (pvpdamage_in_inc != null)
      if (pvpdamage_in_inc.contains("%")) {
        this.pvpdamage_in_inc = Double.parseDouble(pvpdamage_in_inc.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".outgoing-pvp-damage.increased || Needs to be a percentage. Ex: 5%");
      }  
    if (moblootbonus != null)
      if (moblootbonus.contains("%")) {
        this.moblootbonus = Double.parseDouble(moblootbonus.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".mob-loot-bonus || Needs to be a percentage. Ex: 5%");
      }  
    if (doubledamage != null)
      if (doubledamage.contains("%")) {
        this.doubledamage = Double.parseDouble(doubledamage.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".double-damage || Needs to be a percentage. Ex: 5%");
      }  
    if (cropgrowthrate_inc != null)
      if (cropgrowthrate_inc.contains("%")) {
        this.cropgrowthrate_inc = Double.parseDouble(cropgrowthrate_inc.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".crop-growth-rate.increased || Needs to be a percentage. Ex: 5%");
      }  
    if (cropgrowthrate_dec != null)
      if (cropgrowthrate_dec.contains("%")) {
        this.cropgrowthrate_dec = Double.parseDouble(cropgrowthrate_dec.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".crop-growth-rate.decreased || Needs to be a percentage. Ex: 5%");
      }  
    if (cropdropchance != null)
      if (cropdropchance.contains("%")) {
        this.cropdropchance = Double.parseDouble(cropdropchance.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".crop-drop-chance || Needs to be a percentage. Ex: 5%");
      }  
    if (increaseddurability != null)
      if (increaseddurability.contains("%")) {
        this.increaseddurability = Double.parseDouble(increaseddurability.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".increased-durability || Needs to be a percentage. Ex: 5%");
      }  
    if (expboost_inc != null)
      if (expboost_inc.contains("%")) {
        this.expboost_inc = Double.parseDouble(expboost_inc.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".exp-boost.increased || Needs to be a percentage. Ex: 5%");
      }  
    if (expboost_dec != null)
      if (expboost_dec.contains("%")) {
        this.expboost_dec = Double.parseDouble(expboost_dec.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".exp-boost.decreased || Needs to be a percentage. Ex: 5%");
      }  
    if (doubledropchance != null)
      if (doubledropchance.contains("%")) {
        this.doubledropchance = Double.parseDouble(doubledropchance.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".double-drop-chance || Needs to be a percentage. Ex: 5%");
      }  
    if (autosmelt != null)
      if (autosmelt.contains("%")) {
        this.autosmelt = Double.parseDouble(autosmelt.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".auto-smelt || Needs to be a percentage. Ex: 5%");
      }  
    if (enchanterdiscount != null)
      if (enchanterdiscount.contains("%")) {
        this.enchanterdiscount = Double.parseDouble(enchanterdiscount.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".enchanter-discount || Needs to be a percentage. Ex: 5%");
      }  
    if (enchantproccchance != null)
      if (enchantproccchance.contains("%")) {
        this.enchantproccchance = Double.parseDouble(enchantproccchance.split("%")[0]);
      } else {
        Util.debug(String.valueOf(this.id) + ".enchant-procc-chance || Needs to be a percentage. Ex: 5%");
      }  
  }
  
  public void store() {
    this.main.getPerks().set(String.valueOf(this.id) + ".outgoing-pve-damage.increased", String.valueOf(this.pvedamage_out_inc) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".outgoing-pve-damage.decreased", String.valueOf(this.pvedamage_out_dec) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".incoming-pve-damage.increased", String.valueOf(this.pvedamage_out_inc) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".incoming-pve-damage.decreased", String.valueOf(this.pvedamage_out_dec) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".outgoing-pvp-damage.increased", String.valueOf(this.pvpdamage_out_inc) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".outgoing-pvp-damage.decreased", String.valueOf(this.pvpdamage_out_dec) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".incoming-pvp-damage.increased", String.valueOf(this.pvpdamage_out_inc) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".incoming-pvp-damage.decreased", String.valueOf(this.pvpdamage_out_dec) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".mob-loot-bonus", String.valueOf(this.moblootbonus) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".double-damage", String.valueOf(this.doubledamage) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".crop-growth-rate.increased", String.valueOf(this.cropgrowthrate_inc) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".crop-growth-rate.decreased", String.valueOf(this.cropgrowthrate_dec) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".crop-drop-chance", String.valueOf(this.cropdropchance) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".increased-durability", String.valueOf(this.increaseddurability) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".exp-boost.increased", String.valueOf(this.expboost_inc) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".exp-boost.decreased", String.valueOf(this.expboost_dec) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".double-drop-chance", String.valueOf(this.doubledropchance) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".auto-smelt", String.valueOf(this.autosmelt) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".enchanter-discount", String.valueOf(this.enchanterdiscount) + "%");
    this.main.getPerks().set(String.valueOf(this.id) + ".enchant-procc-chance", String.valueOf(this.enchantproccchance) + "%");
    this.main.savePerks();
  }
}
