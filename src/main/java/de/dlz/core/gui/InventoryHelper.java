package de.dlz.core.gui;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * @author Valuga
 */
public class InventoryHelper {
    public static ItemStack nameItem(ItemStack itemStack, String name, String... lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static int addTo(int to, int s) {
        return (s % to == 0 ? s : addTo(to, (s + 1)));
    }
}
