package de.dlz.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Getter
@RequiredArgsConstructor
public enum Messages {
    MAINTENANCE_MODE_ENABLED_KICK(ChatColor.RED + "Sorry, but we are currently in Maintenance!"),
    MAINTENANCE_WRONG_INPUT(ChatColor.RED + "Please use /maintenance <on/off>"),
    MAINTENANCE_ENABLE(ChatColor.GRAY + "The Maintenance Mode is now enabled."),
    MAINTENANCE_DISABLE(ChatColor.GRAY + "The Maintenance Mode is now disabled."),
    PLAYER_NOT_FOUND(ChatColor.RED + "Player not found!"),
    DO_NOT_HAVE_THE_RIGHT_PERMISSION(ChatColor.RED + "You don't have the right Permission to do this!"),
    LEAVE_EDIT_MODE(ChatColor.GREEN + "You successful leaved the Edit Mode!"),
    JOIN_EDIT_MODE(ChatColor.GREEN + "You successful entered the Edit Mode!"),
    ADD_BLOCK_TO_MINING(ChatColor.GREEN + "You added this Block"),
    REMOVE_BLOCK_TO_MINING(ChatColor.GREEN + "You removed this Block"),
    ITEM_IS_NO_MONEY(ChatColor.RED + "Sorry, but only money can be used in the wallet!"),
    NO_SUPPORTER_ONLINE(ChatColor.RED + "Sorry, but there is no Supporter online!"),
    SUPPORT_REQUESTED(ChatColor.GRAY + "The Support is called!"),
    SUPPORT_CLICK_HERE_1(ChatColor.GRAY + "Hey, %player% need Support ( %extra% ) ! To enter "),
    SUPPORT_CLICK_HERE_2(ChatColor.GOLD + "Click Here"),
    PLAYER_HAS_NO_OPEN_SUPPORT(ChatColor.RED + "The Player %player% has no open Support Ticket!"),
    SUPPORT_CHAT_END(ChatColor.GOLD + "The Support Chat has ended by %player%!"),
    SUPPORT_CHAT_NOT_OPEN(ChatColor.RED + "The Support Chat is not open!"),
    SUPPORT_TICKET_ALREADY_OPEN(ChatColor.RED + "You have already an open Support Ticket!"),
    SUPPORT_CHAT_MESSAGE_TO("%player% → You: %message%"),
    SUPPORT_CHAT_MESSAGE_FROM("YOU → %player%: %message%"),
    SUPPORT_CHAT_OPENED(ChatColor.GRAY + "The Support Chat was successfully opened!"),
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
    public String replacePlayerIfExists(String playerName){
        return message.replace("%player%", playerName);
    }

    @NotNull
    public String replacePlayerIfExists(Player player){
        return this.replacePlayerIfExists(player.getName());
    }


    @NotNull
    public String replace(String s1, String s2){
        return message.replace(s1, s2);
    }
}
