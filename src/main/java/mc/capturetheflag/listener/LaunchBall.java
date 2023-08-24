package mc.capturetheflag.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LaunchBall implements Listener {

    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();
        ItemStack offHandItem = player.getInventory().getItemInOffHand();

        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
                && event.getItem().getType().equals(Material.SLIME_BALL)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 3, 55, true));
            player.playSound(player.getLocation(), "entity.blaze.shoot", 1.0f, 1.0f);
            player.spawnParticle(Particle.DRAGON_BREATH, player.getLocation().add(0, 1, 0), 100, 0.5, 0.5, 0.5, 0.1);

            if (mainHandItem.getType() == Material.SLIME_BALL) {
                if (mainHandItem.getAmount() > 1) {
                    mainHandItem.setAmount(mainHandItem.getAmount() - 1);
                } else {
                    player.getInventory().setItemInMainHand(null);
                }
            }

            if (offHandItem.getType() == Material.SLIME_BALL) {
                if (offHandItem.getAmount() > 1) {
                    offHandItem.setAmount(offHandItem.getAmount() - 1);
                } else {
                    player.getInventory().setItemInOffHand(null);
                }
            }
        }
    }
}