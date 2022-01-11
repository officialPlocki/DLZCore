package de.dlz.core.pojo;

import org.bukkit.entity.Player;

public interface RPPlayer {

  Player getPlayer();
  String getRpName();

  void save();
}
