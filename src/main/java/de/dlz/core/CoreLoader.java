package de.dlz.core;

import de.dlz.core.config.ConfigProvider;
import de.dlz.core.database.DatabaseProvider;
import de.dlz.core.gui.ClickInventoryListener;
import de.dlz.core.listener.ConnectionHandler;
import de.dlz.core.manager.PlayerManager;
import de.dlz.core.pojo.Loader;
import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.Bukkit;

@Getter
public class CoreLoader extends Loader {
  @Getter(AccessLevel.NONE)
  private final Core core;

  private ConfigProvider configProvider;
  private DatabaseProvider database;
  private PlayerManager playerManager;

  public CoreLoader(Core core) {
    this.core = core;
  }

  @Override
  public void init() {
    initManager();
    initListener();
    initCommands();
    initTimer();
  }

  private void initTimer() {
    Bukkit.getScheduler().runTaskTimerAsynchronously(core, () -> playerManager.saveAll(), 6000L, 6000L);
  }


  public void initManager() {
    this.configProvider = new ConfigProvider(this.core);
    this.configProvider.init();

    this.database = new DatabaseProvider(this.core);
    this.database.init();

    this.playerManager = new PlayerManager(core);
  }


  public void initListener() {
    Bukkit.getPluginManager().registerEvents(new ClickInventoryListener(), core);
    new ConnectionHandler(core);
  }

  public void initCommands() {
  }

  public void shutdown() {
    this.playerManager.saveAll();
    this.database.shutdown();
  }
}
