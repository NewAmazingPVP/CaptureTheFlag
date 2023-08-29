package mc.capturetheflag.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OpenJailBlue implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Player player = (Player) event.getPlayer();
        if (event.getAction().toString().contains("LEFT_CLICK") && event.getClickedBlock() != null) {
            Block clickedBlock = event.getClickedBlock();
            if (clickedBlock.getType() == Material.BLUE_GLAZED_TERRACOTTA) {
                //For this we will have it break / place every door for a team on every map. No one can tell that it's happening anyway, so it's faster to code =D


            }
        }

    }
}
