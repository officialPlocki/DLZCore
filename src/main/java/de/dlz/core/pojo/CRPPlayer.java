package de.dlz.core.pojo;

import de.dlz.core.Core;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CRPPlayer implements RPPlayer {
    private final Core core;
    private String rpName;
    private final UUID uuid;

    public CRPPlayer(UUID uuid, Core core) {
        this.uuid = uuid;
        this.core = core;
        try (var con = core.getLoader().getDatabase().getConnection()) {
            var preparedStatement = con.prepareStatement("SELECT * FROM dlz.user WHERE uuid = ?");
            preparedStatement.setString(1, uuid.toString());
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                this.rpName = resultSet.getString("rpCharName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Player getPlayer(){
        return Bukkit.getPlayer(uuid);
    }

    @Override
    public String getRpName(){
        return rpName;
    }

    @Override
    public void save() {
        try (Connection con = core.getLoader().getDatabase().getConnection()){
            var preparedStatement = con.prepareStatement("INSERT INTO dlz.user(uuid, rpCharName) VALUES (?, ?) ON DUPLICATE KEY UPDATE rpCharName = ?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, rpName);
            preparedStatement.setString(3, rpName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
