package mc.capturetheflag.listener;

import mc.capturetheflag.CaptureTheFlag;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LaunchPadParticles implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.SHROOMLIGHT) {
            // Schedule a task to continuously spawn particles above the block
            Bukkit.getScheduler().runTaskTimer(plugin, () -> {
                event.getBlock().getWorld().spawnParticle(Particle.CLOUD, event.getBlock().getLocation().add(0.5, 1.0, 0.5), 10);
            }, 0L, 20L); // Change the delay and period as needed (in ticks)
        }
    }