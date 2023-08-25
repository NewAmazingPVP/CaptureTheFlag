package mc.capturetheflag.listener;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class NoTeamArmor implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        handlePlayer(player);
    }

    private void handlePlayer(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getEntryTeam(player.getName());

        if (team != null && team.getName().equals("Not on a team")) {
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta meta = (LeatherArmorMeta) boots.getItemMeta();
            meta.setColor(Color.GRAY);
            boots.setItemMeta(meta);

            ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta dick = (LeatherArmorMeta) legs.getItemMeta();
            dick.setColor(Color.GRAY);
            legs.setItemMeta(dick);

            player.getInventory().setBoots(boots);
        }
    }
}