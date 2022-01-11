package de.dlz.core;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Core extends JavaPlugin {

  private CoreLoader loader;

  @Override
  public void onEnable() {
    // Plugin startup logic
    this.loader = new CoreLoader(this);
    this.loader.init();
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
    this.loader.shutdown();
  }
}
