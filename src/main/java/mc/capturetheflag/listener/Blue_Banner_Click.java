package mc.capturetheflag.listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Blue_Banner_Click implements Listener {


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        Location to = event.getTo();
        Location below = to.clone().subtract(0, 0, 0);

        if (below.getBlock().getType() == Material.BLUE_BANNER) {
            player.sendMessage(ChatColor.DARK_GREEN + "Blue Picked Up!");
            player.spawnParticle(Particle.COMPOSTER, player.getLocation().add(0, 1, 0), 100, 0.5, 0.5, 0.5, 0.1);
        }
    }
}