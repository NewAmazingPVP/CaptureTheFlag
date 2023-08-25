package mc.capturetheflag.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.java.JavaPlugin;

public class Craft_table_detect extends JavaPlugin implements Listener {


    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Player player = (Player) event.getPlayer();
        if (!(event.getInventory().getType() == InventoryType.PLAYER)) if (!(event.getInventory().getType() == InventoryType.FURNACE)) if (!(event.getInventory().getType() == InventoryType.WORKBENCH)) {
            event.setCancelled(true); // Cancel the event to prevent opening the crafting table
            player.sendMessage(ChatColor.RED + "You can't open that!");
        }
    }
}