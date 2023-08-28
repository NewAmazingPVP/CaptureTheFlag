package mc.capturetheflag.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CancelArmorTakeoff implements Listener {

        @EventHandler
        public void onInventoryClick(InventoryClickEvent event) {
            if (event.getWhoClicked() instanceof Player) {
                Player player = (Player) event.getWhoClicked();
                ItemStack clickedItem = event.getCurrentItem();

                if (clickedItem != null && clickedItem.getType().name().contains("HELMET")) {
                    event.setCancelled(true);
                } else if (clickedItem != null && clickedItem.getType().name().contains("CHESTPLATE")) {
                    event.setCancelled(true);
                } else if (clickedItem != null && clickedItem.getType().name().contains("LEGGINGS")) {
                    event.setCancelled(true);
                } else if (clickedItem != null && clickedItem.getType().name().contains("BOOTS")) {
                    event.setCancelled(true);
                } else if (clickedItem != null && clickedItem.getType().name().contains("ARMOR")) {
                    event.setCancelled(true);
                }
            }
        }
    }