package mc.capturetheflag.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scoreboard.Team;

import static mc.capturetheflag.game.GetTeam.getCurrentTeam;

public class random_walk_test implements Listener {


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        Team team = getCurrentTeam(player);
        if (team.getName().equalsIgnoreCase("stuck")) {
            event.setCancelled(true);
        }
    }
}