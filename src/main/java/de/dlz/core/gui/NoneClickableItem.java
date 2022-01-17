package de.dlz.core.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;

/**
 * @author Valuga
 */
public class NoneClickableItem extends ClickableItem {

    private final ClickResult clickResult;

    public NoneClickableItem(ItemStack itemStack) {
        this(itemStack, ClickResult.CANCEL);
    }

    public NoneClickableItem(ItemStack itemStack, ClickResult clickResult) {
        super(itemStack);
        this.clickResult = clickResult;
    }

    @Override
    public ClickResult onClick(Player player, ItemStack itemStack, InventoryAction action) {
        return clickResult;
    }
}
