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

public class DetectBlock implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location to = event.getTo();
        Location below = to.clone().subtract(0, 2, 0);

        if (below.getBlock().getType() == Material.SPONGE) {
            player.playSound(player.getLocation(), "minecraft:block.slime_block.fall", 1.0f, 1.0f);
            player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 3, 55, true));
            player.spawnParticle(Particle.CLOUD, player.getLocation().add(0, 1, 0), 100, 0.5, 0.5, 0.5, 0.1);
        }
    }
}