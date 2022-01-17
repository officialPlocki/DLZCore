package de.dlz.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

@Getter
@RequiredArgsConstructor
public enum Messages {
  DO_NOT_HAVE_THE_RIGHT_PERMISSION(ChatColor.RED + "You don't have the right Permission to do this!"),
  LEAVE_EDIT_MODE(ChatColor.GREEN + "You successful leaved the Edit Mode!"),
  JOIN_EDIT_MODE(ChatColor.GREEN + "You successful entered the Edit Mode!"),
  ADD_BLOCK_TO_MINING(ChatColor.GREEN + "You added this Block"),
  REMOVE_BLOCK_TO_MINING(ChatColor.GREEN + "You removed this Block"),
  ITEM_IS_NO_MONEY(ChatColor.RED + "Sorry, but only money can be used in the wallet!");


  private final String message;

  @NotNull
  public String getWithPrefix(@NotNull Module module){
    return module.getPrefix() + " " + message;
  }
}
