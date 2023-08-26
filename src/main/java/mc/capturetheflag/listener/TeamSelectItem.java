package mc.capturetheflag.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;


public class TeamSelectItem implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            ItemStack heldItem = player.getInventory().getItemInMainHand();

            if (heldItem.getType() == Material.NOTE_BLOCK) {
                // Perform your desired action here
                Player p = event.getPlayer();
                player.playSound(player.getLocation(), "minecraft:block.note_block.bit", 1.0f, 2.0f);
                Inventory inventory = Bukkit.createInventory(p,27, ChatColor.DARK_AQUA + "[Select Team]");

            }
        }
    }
}