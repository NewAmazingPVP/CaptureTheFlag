package mc.capturetheflag.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class InvintoryClickPTest implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        // Check if the player is in the desired world
        if (player.getWorld().getName().equalsIgnoreCase("world")) {

            // Cancel the event to prevent the player from picking up items
            event.setCancelled(true);

            // Send a message to the player
            player.sendMessage(ChatColor.RED + "Sorry, but you can't pick up items in this world.");
        }
    }
}
