package de.dlz.core.enums;

import static de.dlz.core.enums.Module.ESSENTIALS;
import static de.dlz.core.enums.Module.SKILL;

import lombok.Getter;

@Getter
public enum Permission {
    SKILL_BLOCK_EDIT(SKILL, "dlz.skill.blockedit"),
    ESSENTIALS_SUPPORT_END(ESSENTIALS, "dlz.essentials.support.end"),
    ESSENTIALS_SUPPORT_VIEW(ESSENTIALS, "dlz.essentials.support.view"),
    ESSENTIALS_SUPPORT_JOIN(ESSENTIALS, "dlz.essentials.support.join"),
    ESSENTIALS_SUPPORT_ANNOUNCE(ESSENTIALS, "dlz.essentials.support.announce");

    private final Module module;
    private final String permission;

    Permission(Module module, String permission) {
        this.module = module;
        this.permission = permission;
    }


    @Override
    public String toString() {
        return permission;
    }
}
