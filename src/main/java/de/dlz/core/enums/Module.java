package de.dlz.core.enums;

import lombok.Getter;
import org.bukkit.ChatColor;

@Getter
public enum Module {
  SKILL(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "SKILL" + ChatColor.DARK_GRAY + "]"),
  CORE;
  private String prefix;

  Module() {
  }

  Module(String prefix) {
    this.prefix = prefix;
  }
}
