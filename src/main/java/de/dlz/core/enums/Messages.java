package de.dlz.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Getter
@RequiredArgsConstructor
public enum Messages {
  PLAYER_NOT_FOUND(ChatColor.RED + "Player not found!"),
  DO_NOT_HAVE_THE_RIGHT_PERMISSION(ChatColor.RED + "You don't have the right Permission to do this!"),
  LEAVE_EDIT_MODE(ChatColor.GREEN + "You successful leaved the Edit Mode!"),
  JOIN_EDIT_MODE(ChatColor.GREEN + "You successful entered the Edit Mode!"),
  ADD_BLOCK_TO_MINING(ChatColor.GREEN + "You added this Block"),
  REMOVE_BLOCK_TO_MINING(ChatColor.GREEN + "You removed this Block"),
  ITEM_IS_NO_MONEY(ChatColor.RED + "Sorry, but only money can be used in the wallet!"),
  PLAYER_KICK_MESSAGE("""
          §i§6--------------------DLZ-RP--------------------

          §eDu wurdest vom Server gekickt!
          §eGrund:
          
          §i§c %reason%
          
          §9 %time%
          §9
          §i§6----------------------------------------------"""),
  PLAYER_KICK_DEFAULT_EMPTY(ChatColor.RED + "nicht angegeben"),
  PLAYER_KICKED(ChatColor.GREEN + "Player was successfully ejected!"),
  PLUGIN_ARGUMENT_MISSING(ChatColor.RED + "Arguments missing!"),
  WHITELIST_PLAYER_ALREADY_WHITELISTED(ChatColor.RED + "Player already whitelisted!");




  private final String message;

  @NotNull
  public String getWithPrefix(@NotNull Module module){
    return module.getPrefix() + " " + message;
  }

  @NotNull
  public String replace(String s1, String s2){
    return message.replace(s1, s2);
  }
}
