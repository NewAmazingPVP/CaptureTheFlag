package mc.capturetheflag.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class TeamSelectMenuLis implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        Player player = event.getPlayer();
        //this is for the team select menu thing good luck de bugging xD
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_AQUA + "[Select Team]")) {



            if (event.getCurrentItem() == null) {
                return;
            }
            if (event.getCurrentItem().getType() == Material.RED_CONCRETE) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "/join red");

            } else if (event.getCurrentItem().getType() == Material.BLUE_CONCRETE) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "/join blue");
            }


            event.setCancelled(true);

        }

    }

}

