package mc.capturetheflag.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public class LaunchPadParticles extends BukkitRunnable {

    @Override
    public void run() {
        Bukkit.getServer().getWorlds().forEach(world -> {
            world.getEntities().forEach(entity -> {
                if (entity.getLocation().getBlock().getType() == Material.SHROOMLIGHT) {
                    entity.getWorld().spawnParticle(Particle.CLOUD, entity.getLocation().add(0.5, 1.0, 0.5), 10);
                }
            });
        });
    }
}