package de.dlz.core.config;

import de.dlz.core.Core;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class ConfigProvider {
  private final Core core;
  private FileConfiguration config;

  public ConfigProvider(Core core) {
    this.core = core;
  }

  @SneakyThrows
  public void init(){
    var file = new File(core.getDataFolder() + "config.yml");
    if (!file.getParentFile().exists()){
      Files.createDirectories(Path.of(file.getParentFile().getPath()));
    }

    if (!file.exists()){
      Files.createFile(Path.of(file.getPath()));
    }

    this.config = core.getConfig();
    config.options().copyDefaults(true);

    config.addDefault("MySQL.Host", "localhost");
    config.addDefault("MySQL.Port", "3306");
    config.addDefault("MySQL.User", "root");
    config.addDefault("MySQL.Password", "SuperSecret");

    config.save(core.getDataFolder() + "config.yml");
  }

  /**
   * Returns the MySQL Configuration.
   * @return MySQL Configuration <br> 0 = Host <br> 1 = Port <br> 2 = User <br> 3 = Password
   */
  public @NotNull String[] getMySQL(){
    var s = new String[4];
    s[0] = config.getString("MySQL.Host");
    s[1] = config.getString("MySQL.Port");
    s[2] = config.getString("MySQL.User");
    s[3] = config.getString("MySQL.Password");
    return s;
  }
}
