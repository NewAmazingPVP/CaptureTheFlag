package mc.capturetheflag.listener;


import org.bukkit.ChatColor;
import org.bukkit.Material;
        import org.bukkit.entity.Entity;
        import org.bukkit.entity.LightningStrike;
        import org.bukkit.entity.Player;
        import org.bukkit.event.EventHandler;
        import org.bukkit.event.Listener;
        import org.bukkit.event.player.PlayerInteractEntityEvent;
        import org.bukkit.inventory.ItemStack;

public class Lightning_cythe implements Listener {

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType() == Material.NETHERITE_HOE && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Lightning Scythe")) {
            if (!(entity instanceof Player)) {
                entity.getWorld().strikeLightningEffect(entity.getLocation());
            }
        }
    }
}