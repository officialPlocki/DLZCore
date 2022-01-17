package de.dlz.core.pojo;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemBuilder {

  private final ItemStack itemStack;

  public ItemBuilder(Material material) {
    this.itemStack = new ItemStack(material);
  }

  public ItemBuilder(ItemStack itemStack) {
    this.itemStack = itemStack;
  }

  public ItemBuilder setLore(String... lore) {
    var meta = this.itemStack.getItemMeta();
    meta.setLore(List.of(lore));
    this.itemStack.setItemMeta(meta);
    return this;
  }

  public ItemBuilder setAmount(int amount){
    this.itemStack.setAmount(amount);
    return this;
  }

  public ItemBuilder setName(String name){
    var meta = this.itemStack.getItemMeta();
    meta.setDisplayName(name);
    this.itemStack.setItemMeta(meta);
    return this;
  }

  public ItemBuilder setType(Material material){
    this.itemStack.setType(material);
    return this;
  }

  public ItemBuilder setCustomModel(int i){
    var meta = this.itemStack.getItemMeta();
    meta.setCustomModelData(i);
    this.itemStack.setItemMeta(meta);
    return this;
  }

  public String getName(){
    return this.itemStack.getItemMeta().getDisplayName();
  }

  public ItemStack get(){
    return this.itemStack;
  }

  public static ItemBuilder create(Material material){
    return new ItemBuilder(material);
  }
}
