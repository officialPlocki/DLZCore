package de.dlz.core.enums;

import static de.dlz.core.enums.Module.ESSENTIALS;
import static de.dlz.core.enums.Module.SKILL;

import lombok.Getter;

@Getter
public enum Permission {

  COMMAND_KICK(ESSENTIALS,"dlz.command.kick"),
  BLOCK_EDIT(SKILL, "dlz.skill.blockedit"),
  WHITELIST_ADD(ESSENTIALS, "dlw.command.AddToWhitelist"),
  WHITELIST_REMOVE(ESSENTIALS, "dlw.command.RemoveFromWhitelist");

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
