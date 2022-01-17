package de.dlz.core.enums;

import lombok.Getter;
import org.bukkit.ChatColor;

@Getter
public enum Module {
  SKILL(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "SKILL" + ChatColor.DARK_GRAY + "]"),
  CORE,
  ECONOMY(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Economy" + ChatColor.DARK_GRAY + "]");
  private String prefix;

  Module() {
  }

  Module(String prefix) {
    this.prefix = prefix;
  }
}
