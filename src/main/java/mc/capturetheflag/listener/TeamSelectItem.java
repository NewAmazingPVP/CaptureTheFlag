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

            if (heldItem.getType() == Material.RECOVERY_COMPASS) {
                // Perform your desired action here
                Player p = event.getPlayer();
                player.playSound(player.getLocation(), "minecraft:block.note_block.bit", 1.0f, 2.0f);
                Inventory teamselect = Bukkit.createInventory(p, 27, ChatColor.DARK_AQUA + "[Select Team]");

                ItemStack rteam = new ItemStack(Material.RED_CONCRETE);
                ItemMeta RMeta = rteam.getItemMeta();
                RMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Click" + ChatColor.DARK_RED + " To Join Red");
                rteam.setItemMeta(RMeta);
                teamselect.setItem(11, rteam);

                ItemStack bteam = new ItemStack(Material.BLUE_CONCRETE);
                ItemMeta BMeta = bteam.getItemMeta();
                BMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Click" + ChatColor.DARK_BLUE + " To Join Blue");
                bteam.setItemMeta(BMeta);
                teamselect.setItem(15, bteam);

                ItemStack g0 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M0 = g0.getItemMeta();
                M0.setDisplayName(" ");
                g0.setItemMeta(M0);
                teamselect.setItem(0,g0);




                ItemStack g1 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M1 = g1.getItemMeta();
                M1.setDisplayName(" ");
                g1.setItemMeta(M1);
                teamselect.setItem(1,g1);




                ItemStack g2 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M2 = g2.getItemMeta();
                M2.setDisplayName(" ");
                g2.setItemMeta(M2);
                teamselect.setItem(2,g2);




                ItemStack g3 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M3 = g3.getItemMeta();
                M3.setDisplayName(" ");
                g3.setItemMeta(M3);
                teamselect.setItem(3,g3);




                ItemStack g4 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M4 = g4.getItemMeta();
                M4.setDisplayName(" ");
                g4.setItemMeta(M4);
                teamselect.setItem(4,g4);




                ItemStack g5 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M5 = g5.getItemMeta();
                M5.setDisplayName(" ");
                g5.setItemMeta(M5);
                teamselect.setItem(5,g5);




                ItemStack g6 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M6 = g6.getItemMeta();
                M6.setDisplayName(" ");
                g6.setItemMeta(M6);
                teamselect.setItem(6,g6);




                ItemStack g7 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M7 = g7.getItemMeta();
                M7.setDisplayName(" ");
                g7.setItemMeta(M7);
                teamselect.setItem(7,g7);




                ItemStack g8 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M8 = g8.getItemMeta();
                M8.setDisplayName(" ");
                g8.setItemMeta(M8);
                teamselect.setItem(8,g8);




                ItemStack g9 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M9 = g9.getItemMeta();
                M9.setDisplayName(" ");
                g9.setItemMeta(M9);
                teamselect.setItem(9,g9);




                ItemStack g10 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M10 = g10.getItemMeta();
                M10.setDisplayName(" ");
                g10.setItemMeta(M10);
                teamselect.setItem(10,g10);




                ItemStack g12 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M12 = g12.getItemMeta();
                M12.setDisplayName(" ");
                g12.setItemMeta(M12);
                teamselect.setItem(12,g12);




                ItemStack g13 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M13 = g13.getItemMeta();
                M13.setDisplayName(" ");
                g13.setItemMeta(M13);
                teamselect.setItem(13,g13);




                ItemStack g14 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M14 = g14.getItemMeta();
                M14.setDisplayName(" ");
                g14.setItemMeta(M14);
                teamselect.setItem(14,g14);




                ItemStack g16 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M16 = g16.getItemMeta();
                M16.setDisplayName(" ");
                g16.setItemMeta(M16);
                teamselect.setItem(16,g16);




                ItemStack g17 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M17 = g17.getItemMeta();
                M17.setDisplayName(" ");
                g17.setItemMeta(M17);
                teamselect.setItem(17,g17);




                ItemStack g18 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M18 = g18.getItemMeta();
                M18.setDisplayName(" ");
                g18.setItemMeta(M18);
                teamselect.setItem(18,g18);




                ItemStack g19 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M19 = g19.getItemMeta();
                M19.setDisplayName(" ");
                g19.setItemMeta(M19);
                teamselect.setItem(19,g19);




                ItemStack g20 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M20 = g20.getItemMeta();
                M20.setDisplayName(" ");
                g20.setItemMeta(M20);
                teamselect.setItem(20,g20);




                ItemStack g21 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M21 = g21.getItemMeta();
                M21.setDisplayName(" ");
                g21.setItemMeta(M21);
                teamselect.setItem(21,g21);




                ItemStack g22 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M22 = g22.getItemMeta();
                M22.setDisplayName(" ");
                g22.setItemMeta(M22);
                teamselect.setItem(22,g22);




                ItemStack g23 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M23 = g23.getItemMeta();
                M23.setDisplayName(" ");
                g23.setItemMeta(M23);
                teamselect.setItem(23,g23);




                ItemStack g24 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M24 = g24.getItemMeta();
                M24.setDisplayName(" ");
                g24.setItemMeta(M24);
                teamselect.setItem(24,g24);




                ItemStack g25 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta M25 = g25.getItemMeta();
                M25.setDisplayName(" ");
                g25.setItemMeta(M25);
                teamselect.setItem(25,g25);




                ItemStack NoTeam = new ItemStack(Material.BLACK_CONCRETE);
                ItemMeta noteam = NoTeam.getItemMeta();
                noteam.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Click" + ChatColor.DARK_GRAY + " To Have No Team (Spectate)");
                NoTeam.setItemMeta(noteam);
                teamselect.setItem(26,NoTeam);


                p.openInventory(teamselect);

            }
        }
    }
}