package de.dlz.core;

import de.dlz.core.config.ConfigProvider;
import de.dlz.core.database.DatabaseProvider;
import de.dlz.core.manager.PlayerManager;
import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.Contract;

@Getter
public class CoreLoader {
  @Getter(AccessLevel.NONE)
  private final Core core;

  private ConfigProvider configProvider;
  private DatabaseProvider database;
  private PlayerManager playerManager;

  public CoreLoader(Core core) {
    this.core = core;
  }

  public void init() {
    initManager();
    initListener();
    initCommands();
    initTimer();
  }

  private void initTimer() {
    Bukkit.getScheduler().runTaskTimerAsynchronously(core, () -> playerManager.saveAll(), 6000L, 6000L);
  }

  @Contract(pure = true)
  private void initManager() {
    this.configProvider = new ConfigProvider(this.core);
    this.configProvider.init();

    this.database = new DatabaseProvider(this.core);
    this.database.init();

    this.playerManager = new PlayerManager(core);
  }

  @Contract(pure = true)
  private void initListener() {
  }

  @Contract(pure = true)
  private void initCommands() {
  }

  public void shutdown() {
    this.playerManager.saveAll();
    this.database.shutdown();
  }
}
