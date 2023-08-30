package mc.capturetheflag.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PreventTemSelPickup implements Listener {
    @EventHandler
    public void onPlayerClick(InventoryClickEvent event) {
        if(event.getCurrentItem().getType() == Material.RECOVERY_COMPASS){
            event.setCancelled(true);
        }
    }
}