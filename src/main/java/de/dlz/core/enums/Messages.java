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
    NO_SUPPORTER_ONLINE(ChatColor.RED + "Sorry, but there is no Supporter online!"),
    SUPPORT_REQUESTED(ChatColor.GRAY + "The Support is called!"),
    SUPPORT_CLICK_HERE_1(ChatColor.GRAY + "Hey, %player% need Support! To enter "),
    SUPPORT_CLICK_HERE_2(ChatColor.GOLD + "Click Here"),
    PLAYER_HAS_NO_OPEN_SUPPORT(ChatColor.RED + "The Player %player% has no open Support Ticket!"),
    SUPPORT_CHAT_NOT_OPEN(ChatColor.RED + "The Support Chat is not open!");


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


}
