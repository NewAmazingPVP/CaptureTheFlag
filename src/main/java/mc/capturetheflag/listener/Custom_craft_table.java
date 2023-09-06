package mc.capturetheflag.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Custom_craft_table implements Listener {


    /*@EventHandler
    public void onPlayerInteract(InventoryOpenEvent event) {
        Player player = (Player) event.getPlayer();
        if ((event.getInventory().getType() == InventoryType.WORKBENCH)) {
            event.setCancelled(true); // Cancel the event to prevent opening the crafting table

                player.playSound(player.getLocation(), "minecraft:block.note_block.bit", 1.0f, 2.0f);
                Inventory teamselect = Bukkit.createInventory(player, 27, ChatColor.DARK_AQUA +  "" + ChatColor.BOLD +"4X4 Crafting Table");

                ItemStack rteam = new ItemStack(Material.RED_CONCRETE);
                ItemMeta RMeta = rteam.getItemMeta();
                RMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Click" + ChatColor.DARK_RED + " To Join Red");
                rteam.setItemMeta(RMeta);
                teamselect.setItem(11, rteam);

            ItemStack g0 = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
            ItemMeta M0 = g0.getItemMeta();
            M0.setDisplayName(" ");
            g0.setItemMeta(M0);
            teamselect.setItem(0, g0);


                player.openInventory(teamselect);*/
            }