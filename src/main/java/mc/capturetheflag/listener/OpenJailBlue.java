package mc.capturetheflag.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class OpenJailBlue implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = (Player) event.getPlayer();
        if (event.getAction().toString().contains("LEFT_CLICK") && event.getClickedBlock() != null) {
            Block clickedBlock = event.getClickedBlock();
            if (clickedBlock.getType() == Material.RED_GLAZED_TERRACOTTA) {
                player.sendMessage("test");
            }
        }

    }
}
