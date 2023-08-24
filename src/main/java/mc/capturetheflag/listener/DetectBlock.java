package mc.capturetheflag.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
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

        if (to.getBlock().getType() == Material.SPONGE) {
            player.sendMessage("test");
            player.playSound(player.getLocation(), "entity.blaze.shoot", 1.0f, 1.0f);
            player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20, 0));
        }
    }
}