package mc.capturetheflag.listener;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class ShearSheepTest implements Listener {

    @EventHandler
    public void onPlayerShearEntity(PlayerShearEntityEvent event) {
        Player player = event.getPlayer();
        if (event.getEntity() instanceof Sheep) {
            event.setCancelled(true);
            Sheep sheep = (Sheep) event.getEntity();
            sheep.getWorld().spawnParticle(Particle.REDSTONE, sheep.getLocation(), 10, 0.6, 0.6, 0.6, new Particle.DustOptions(Color.RED, 3));
            sheep.setHealth(0.0);
            player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Shit u killed it! That is NOT how you shear a sheep!");
            player.playSound(player.getLocation(), "minecraft:entity.slime.death", 1.0f, 1.0f);
        }
    }
}