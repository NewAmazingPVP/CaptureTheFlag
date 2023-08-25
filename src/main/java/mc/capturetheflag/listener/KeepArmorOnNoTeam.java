package mc.capturetheflag.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class KeepArmorOnNoTeam implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
            Team team = scoreboard.getEntryTeam(player.getName());

            if (team != null && team.getName().equals("Not on a team")) {
                if (event.getSlotType() == InventoryType.SlotType.ARMOR && event.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
                    event.setCancelled(true);
                }
            }
        }
    }
}