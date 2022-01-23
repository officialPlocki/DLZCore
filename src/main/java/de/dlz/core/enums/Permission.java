package de.dlz.core.enums;

import static de.dlz.core.enums.Module.ESSENTIALS;
import static de.dlz.core.enums.Module.SKILL;

import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public enum Permission {

    COMMAND_KICK(ESSENTIALS,"dlz.command.kick"),
    WHITELIST_ADD(ESSENTIALS, "dlw.command.AddToWhitelist"),
    WHITELIST_REMOVE(ESSENTIALS, "dlw.command.RemoveFromWhitelist"),
    SKILL_BLOCK_EDIT(SKILL, "dlz.skill.blockedit"),
    ESSENTIALS_SUPPORT_END(ESSENTIALS, "dlz.support.end"),
    ESSENTIALS_SUPPORT_VIEW(ESSENTIALS, "dlz.support.view"),
    ESSENTIALS_SUPPORT_JOIN(ESSENTIALS, "dlz.support.join"),
    ESSENTIALS_SUPPORT_ANNOUNCE(ESSENTIALS, "dlz.support.announce"),
    ESSENTIALS_MAINTENANCE_CHANGE(ESSENTIALS, "dlz.maintenance.change"),
    ESSENTIALS_MAINTENANCE_JOIN(ESSENTIALS, "dlz.maintenance.join");

    private final Module module;
    private final String permission;

    Permission(Module module, String permission) {
        this.module = module;
        this.permission = permission;
    }

    public boolean hasPermission(Player player){
        return player.hasPermission(permission);
    }
    @Override
    public String toString() {
        return permission;
    }
}
