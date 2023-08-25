package mc.capturetheflag.listener;

import org.bukkit.ChatColor;
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
            sheep.setHealth(0.0);
            player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Shit u killed it! That is NOT how you shear a sheep!");
        }
    }
}