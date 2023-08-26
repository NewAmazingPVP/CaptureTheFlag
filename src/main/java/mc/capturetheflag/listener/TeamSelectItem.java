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
import org.bukkit.inventory.meta.ItemMeta;


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


                ItemStack rteam = new ItemStack(Material.RED_CONCRETE);
                ItemMeta RMeta = rteam.getItemMeta();
                RMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Click" + ChatColor.DARK_RED + " To Join Red");
                rteam.setItemMeta(RMeta);
                inventory.setItem(12, rteam);


                ItemStack bteam = new ItemStack(Material.BLUE_CONCRETE);
                ItemMeta BMeta = bteam.getItemMeta();
                BMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Click" + ChatColor.DARK_BLUE + " To Join Blue");
                bteam.setItemMeta(BMeta);
                inventory.setItem(16,bteam);


                p.openInventory(inventory);

            }
        }
    }
}