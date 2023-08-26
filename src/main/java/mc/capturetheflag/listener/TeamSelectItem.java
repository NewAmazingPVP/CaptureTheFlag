package mc.capturetheflag.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class TeamSelectItem implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            ItemStack heldItem = player.getInventory().getItemInMainHand();

            if (heldItem.getType() == Material.DIAMOND_SWORD) {
                // Perform your desired action here
                player.sendMessage("You right-clicked while holding a diamond sword!");
            }
        }
    }
}