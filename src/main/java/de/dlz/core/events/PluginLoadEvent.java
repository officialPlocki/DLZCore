package de.dlz.core.events;

import de.dlz.core.Core;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PluginLoadEvent extends Event {
  private static final HandlerList HANDLERS = new HandlerList();
  @Getter
  private final Core core;

  public PluginLoadEvent(Core core) {
    this.core = core;
  }

  public @NotNull HandlerList getHandlers() {
    return HANDLERS;
  }

  public static HandlerList getHandlerList() {
    return HANDLERS;
  }
}
