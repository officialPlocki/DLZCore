package de.dlz.core.pojo;

import org.bukkit.entity.Player;

public interface IRPPlayer {

  Player getPlayer();
  String getRpName();

  void save();
}
