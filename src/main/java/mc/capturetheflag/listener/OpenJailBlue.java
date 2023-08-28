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

                Inventory openblue = Bukkit.createInventory(p, 9, ChatColor.DARK_BLUE + "[Open Jail]");

                ItemStack OPB = new ItemStack(Material.BLUE_GLAZED_TERRACOTTA);
                ItemMeta Bmeta = OPB.getItemMeta();
                Bmeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Click" + ChatColor.DARK_BLUE + "" +ChatColor.BOLD + " To Open Jail!");
                OPB.setItemMeta(Bmeta);
                openblue.setItem(5, OPB);



                p.openInventory(openblue);
            }
        }

    }
}
