package mc.capturetheflag.listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Open_Furnace implements Listener {


    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Player player = (Player) event.getPlayer();
        if ((event.getInventory().getType() == InventoryType.FURNACE)) {
            event.setCancelled(true); // Cancel the event to prevent opening the crafting table
            player.openWorkbench(player.getLocation(), true);
            player.sendMessage(ChatColor.DARK_RED + "What did yiu think would happen... A furnace opening" + ChatColor.DARK_GREEN + "( ˘•ω•˘ )");
        }
    }
}