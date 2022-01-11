package de.dlz.core.listener;

import de.dlz.core.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ConnectionHandler implements Listener {

  private final Core core;

  public ConnectionHandler(Core core) {
    this.core = core;
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    core.getLoader().getPlayerManager().getRPPlayer(event.getPlayer());
  }
}
