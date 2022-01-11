package de.dlz.core.enums;

import static de.dlz.core.enums.Module.SKILL;

import lombok.Getter;

@Getter
public enum Permission {
  BLOCK_EDIT(SKILL, "dlz.skill.blockedit");

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
