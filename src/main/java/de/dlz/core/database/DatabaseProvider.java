package de.dlz.core.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import de.dlz.core.Core;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseProvider {

  private final Core core;
  private HikariDataSource dataSource;

  public DatabaseProvider(Core core){
    this.core = core;
  }

  public void init(){
    var mySQLConfig = this.core.getLoader().getConfigProvider().getMySQL();
    var config = new HikariConfig();
    config.setPoolName("Core");
    config.setJdbcUrl("jdbc:mysql://" + mySQLConfig[0] + ":" + mySQLConfig[1]);
    config.setUsername(mySQLConfig[2]);
    config.setPassword(mySQLConfig[3]);
    this.dataSource = new HikariDataSource(config);
  }

  public Connection getConnection(){
    try {
      return dataSource.getConnection();
    } catch (SQLException e) {
      return null;
    }
  }

  public void shutdown() {
    this.dataSource.close();
  }
}
