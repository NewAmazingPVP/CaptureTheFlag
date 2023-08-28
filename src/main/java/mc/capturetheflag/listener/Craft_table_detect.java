package mc.capturetheflag.listener;

import org.bukkit.event.Listener;

public class Craft_table_detect implements Listener {

}


    /*@EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Player player = (Player) event.getPlayer();
        if (!(event.getInventory().getType() == InventoryType.PLAYER)) if (!(event.getInventory().getType() == InventoryType.FURNACE)) if (!(event.getInventory().getType() == InventoryType.WORKBENCH)) {
            event.setCancelled(true); // Cancel the event to prevent opening the crafting table
            player.sendMessage(ChatColor.RED + "You can't open that!");
        }
    }
}*/