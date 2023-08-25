package mc.capturetheflag.listener;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class Blue_Banner_Click implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        World world = player.getWorld();
        Location to = event.getTo();
        Location below = to.clone().subtract(0, 0, 0);

        if (below.getBlock().getType() == Material.BLUE_BANNER) {
            player.sendMessage(ChatColor.DARK_GREEN + "Blue Picked Up!");
            player.spawnParticle(Particle.COMPOSTER, player.getLocation().add(0, 1, 0), 100, 0.5, 0.5, 0.5, 0.1);
            player.playSound(player.getLocation(), "minecraft:block.note_block.bit", 1.0f, 2.0f);
            int x = -81;
            int y = 71;
            int z = 0;
            Material blockType = Material.AIR;
            Location location = new Location(world, -81, 71, 0);
            location.getBlock().setType(blockType);

        }
    }
}