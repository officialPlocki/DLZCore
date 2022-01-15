package de.dlz.core.config;

import de.dlz.core.Core;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

public class ConfigProvider {
  private final Core core;
  private YamlConfiguration config;

  public ConfigProvider(Core core) {
    this.core = core;
  }

  @SneakyThrows
  public void init(){
    var file = new File(core.getDataFolder().getParent() + File.separator + "DLZ" + File.separator + "config.yml");
    if (!file.getParentFile().exists()){
      Files.createDirectories(Path.of(file.getParentFile().getPath()));
    }

    if (!file.exists()){
      Files.createFile(Path.of(file.getPath()));
    }
    this.config = YamlConfiguration.loadConfiguration(file);

    config.options().copyDefaults(true);

    var mysqlSection = config.getConfigurationSection("MySQL");

    if (mysqlSection == null) {
      mysqlSection = config.createSection("MySQL");
      mysqlSection.set("Host", "localhost");
      mysqlSection.set("Port", "3306");
      mysqlSection.set("User", "root");
      mysqlSection.set("Password", "SuperSecret");
    }

    config.save(file);
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
