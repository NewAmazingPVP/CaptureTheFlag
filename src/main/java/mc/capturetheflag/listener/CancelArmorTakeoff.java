package mc.capturetheflag.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class CancelArmorTakeoff implements Listener {

        @EventHandler
        public void onInventoryClick(InventoryClickEvent event) {
            if (event.getWhoClicked() instanceof Player) {
                Player player = (Player) event.getWhoClicked();
                ItemStack clickedItem = event.getCurrentItem();

                if (clickedItem != null && clickedItem.getType().name().contains("HELMET")) {
                    event.setCancelled(true);
                    player.sendMessage("You cannot remove your helmet!");
                } else if (clickedItem != null && clickedItem.getType().name().contains("CHESTPLATE")) {
                    event.setCancelled(true);
                    player.sendMessage("You cannot remove your chestplate!");
                } else if (clickedItem != null && clickedItem.getType().name().contains("LEGGINGS")) {
                    event.setCancelled(true);
                    player.sendMessage("You cannot remove your leggings!");
                } else if (clickedItem != null && clickedItem.getType().name().contains("BOOTS")) {
                    event.setCancelled(true);
                    player.sendMessage("You cannot remove your boots!");
                } else if (clickedItem != null && clickedItem.getType().name().contains("ARMOR")) {
                    event.setCancelled(true);
                    player.sendMessage("You cannot interact with armor items!");
                }
            }
        }
    }