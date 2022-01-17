package de.dlz.core.gui;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author Valuga
 */
@RequiredArgsConstructor
public class ClickInventoryListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (ClickInventory.INVENTORIES.containsKey(player.getUniqueId())) {
            ClickInventory clickInventory = ClickInventory.INVENTORIES.get(player.getUniqueId());

            if (clickInventory.inventory.equals(event.getClickedInventory())) {
                ClickResult result = clickInventory.onClick(player, event.getSlot(), event.getAction());
                if (result != ClickResult.NOTHING) {
                    event.setCancelled(result == ClickResult.CANCEL);
                }
            }

            if (event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
                event.setCancelled(clickInventory.isPreventClick());
            }
        }

    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (ClickInventory.INVENTORIES.containsKey(player.getUniqueId())) {
            ClickInventory clickInventory = ClickInventory.INVENTORIES.get(player.getUniqueId());

            if (clickInventory.inventory.equals(event.getInventory())) {
                clickInventory.onClose(player);
            }
            ClickInventory.INVENTORIES.remove(event.getPlayer().getUniqueId());
        } else {
            ClickInventory.INVENTORIES.forEach((uuid, ci) -> {
                if (ci.getAdditional().contains(player.getUniqueId())) {
                    ci.onClose(player);
                }
            });
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        ClickInventory.INVENTORIES.remove(event.getPlayer().getUniqueId());
    }

}
