package mc.capturetheflag.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Keep_Invintory_test implements Listener {


    @EventHandler
    public void onDeathEvent(PlayerDeathEvent event) {
            Player player = (Player) event.getPlayer();
            if (player.hasMetadata("safe")) {
                // Do not clear the inventory if the player has the "safe" tag
                return;
            }

            // Clear the inventory if the player does not have the "safe" tag
            player.getInventory().clear();
        }
    }