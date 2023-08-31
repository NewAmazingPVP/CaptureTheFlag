package mc.capturetheflag.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Speed_boost_block implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location to = event.getTo();
        Location below = to.clone().subtract(0, 1, 0);

        if (below.getBlock().getType() == Material.AMETHYST_BLOCK) {
            player.playSound(player.getLocation(), "minecraft:block.beacon.ambient", 1.0f, 2.0f);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 1, 5, true));
            player.spawnParticle(Particle.CLOUD, player.getLocation().add(0.5, 1.0, 0.5), 10);
        }
    }
}