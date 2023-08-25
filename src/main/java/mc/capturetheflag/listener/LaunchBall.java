package mc.capturetheflag.listener;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LaunchBall implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && event.getItem().getType().equals(Material.SLIME_BALL)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 3, 70, true));
            player.playSound(player.getLocation(), "entity.blaze.shoot", 1.0f, 1.0f);
            player.spawnParticle(Particle.DRAGON_BREATH, player.getLocation().add(0, 1, 0), 100, 0.5, 0.5, 0.5, 0.1);

            if (player.getInventory().getItemInMainHand().getType() == Material.SLIME_BALL) {
                if (player.getInventory().getItemInMainHand().getAmount() > 1) {
                    player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                } else {
                    player.getInventory().setItemInMainHand(null);
                }
            }

            if (player.getInventory().getItemInOffHand().getType() == Material.SLIME_BALL) {
                if (player.getInventory().getItemInOffHand().getAmount() > 1) {
                    player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() - 1);
                } else {
                    player.getInventory().setItemInOffHand(null);
                }
            }
        }
    }
}