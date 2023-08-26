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
                Inventory teamselect = Bukkit.createInventory(p, 27, ChatColor.DARK_AQUA + "[Select Team]");

                ItemStack g0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(0,g0);

                ItemStack g1 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(1,g1);

                ItemStack g2 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(2,g2);

                ItemStack g3 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(3,g3);

                ItemStack g4 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(4,g4);

                ItemStack g5 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(5,g5);

                ItemStack g6 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(6,g6);

                ItemStack g7 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(7,g7);

                ItemStack g8 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(8,g8);

                ItemStack g9 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(9,g9);

                ItemStack g10 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(10,g10);

                ItemStack rteam = new ItemStack(Material.RED_CONCRETE);
                ItemMeta RMeta = rteam.getItemMeta();
                RMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Click" + ChatColor.DARK_RED + " To Join Red");
                rteam.setItemMeta(RMeta);
                teamselect.setItem(11, rteam);

                ItemStack g12 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(12,g12);

                ItemStack g13 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(13,g13);

                ItemStack g14 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(14,g14);

                ItemStack bteam = new ItemStack(Material.BLUE_CONCRETE);
                ItemMeta BMeta = bteam.getItemMeta();
                BMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Click" + ChatColor.DARK_BLUE + " To Join Blue");
                bteam.setItemMeta(BMeta);
                teamselect.setItem(15, bteam);

                ItemStack g16 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(16,g16);

                ItemStack g17 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(17,g17);

                ItemStack g18 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(18,g18);

                ItemStack g19 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(19,g19);

                ItemStack g20 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(20,g20);

                ItemStack g21 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(21,g21);

                ItemStack g22 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(22,g22);

                ItemStack g23 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(23,g23);

                ItemStack g24 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(24,g24);

                ItemStack g25 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(25,g25);

                ItemStack g26 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(26,g26);

                ItemStack g27 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                teamselect.setItem(27,g27);



                p.openInventory(teamselect);

            }
        }
    }
}