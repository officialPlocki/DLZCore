package de.dlz.core.gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * @author Valuga
 */
public abstract class ClickInventory {

    public static final Map<UUID, ClickInventory> INVENTORIES = new HashMap<>();

    @Getter
    public final Inventory inventory;
    private final Map<Integer, ClickableItem> items = new HashMap<>();
    @Getter
    private final List<UUID> additional = new ArrayList<>();

    @Getter
    private final boolean preventClick;

    @Getter
    @Setter
    private boolean closing = false;
    /**
     * A HashMap Used to store Values when working in multipleGUIs
     */
    @Getter
    private final Map<String, Object> storedValues = new HashMap<>();

    public ClickInventory(Collection<?> collection, String title) {
        this(InventoryHelper.addTo(9, collection.size()), title);
    }

    public ClickInventory(int size, String title) {
        this(Bukkit.createInventory(null, size, title), true);
    }

    public ClickInventory(int size, String title, boolean preventClick) {
        this(Bukkit.createInventory(null, size, title), preventClick);
    }

    public ClickInventory(Inventory parent, boolean preventClick) {
        this.inventory = parent;
        this.preventClick = preventClick;
    }

    public void open(Player player) {
        player.openInventory(inventory);
        INVENTORIES.put(player.getUniqueId(), this);
    }


    public void close(Player player) {
        player.closeInventory();
    }

    public ClickResult onClick(Player player, int slot, InventoryAction action) {
        if (items.containsKey(slot)) {
            ClickableItem item = items.get(slot);
            return item.onClick(player, item.getItemStack(), action);
        }
        return ClickResult.NOTHING;
    }

    public abstract void onClose(Player player);

    public boolean isSlotEmpty(int slot) {
        return inventory.getItem(slot) == null || inventory.getItem(slot).equals(Material.AIR);
    }

    public ItemStack getItemInSlot(int slot) {
        if (!isSlotEmpty(slot)) {
            return inventory.getItem(slot);
        }
        return null;
    }

    public int getFirstEmpty() {
        for (var slot = 0; slot < inventory.getContents().length; slot++) {
            var itemStack = inventory.getItem(slot);
            if (itemStack == null || itemStack.getType() == Material.AIR) {
                return slot;
            }
        }
        return -1;
    }

    public int getLastSlot() {
        return inventory.getContents().length;
    }

    public void setItem(int slot, ClickableItem item) {
        items.put(slot, item);
        inventory.setItem(slot, item.getItemStack());
    }

    public int getItemSlot(ItemStack itemStack) {
        for (var i = 0; i < inventory.getContents().length; i++) {
            if (itemStack.isSimilar(inventory.getItem(i))) {
                return i;
            }
        }
        return 0;
    }

    public int addItem(ClickableItem item) {
        for (var slot = 0; slot < inventory.getContents().length; slot++) {
            var itemStack = inventory.getItem(slot);
            if (itemStack == null || itemStack.getType() == Material.AIR) {
                setItem(slot, item);
                return slot;
            }
        }
        return -1;
    }

    public int addItem(int startingSlot, ClickableItem item) {
        for (var slot = startingSlot; slot < inventory.getContents().length; slot++) {
            var itemStack = inventory.getItem(slot);
            if (itemStack == null || itemStack.getType() == Material.AIR) {
                setItem(slot, item);
                return slot;
            }
        }
        return -1;
    }

    public int addItem(int startingSlot, int endingSlot, ClickableItem item) {
        for (var slot = startingSlot; slot < endingSlot; slot++) {
            var itemStack = inventory.getItem(slot);
            if (itemStack == null || itemStack.getType() == Material.AIR) {
                setItem(slot, item);
                return slot;
            }
        }
        return -1;
    }


}
