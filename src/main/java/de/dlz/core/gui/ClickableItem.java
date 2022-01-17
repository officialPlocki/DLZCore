package de.dlz.core.gui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;

/**
 * @author Valuga
 */
@AllArgsConstructor
@Getter
@Setter
public abstract class ClickableItem {

    private ItemStack itemStack;

    public abstract ClickResult onClick(Player player, ItemStack itemStack, InventoryAction action);

}
