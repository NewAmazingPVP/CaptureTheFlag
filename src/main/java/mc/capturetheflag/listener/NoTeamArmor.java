package mc.capturetheflag.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class NoTeamArmor implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        handlePlayer(player);
    }

    //FIX THISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS [game still works just shows wrong armor color
    private void handlePlayer(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getEntryTeam(player.getName());

        if (team != null && (team.getName().equals("RED") || team.getName().equals("BLUE"))) {
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootsMeta.setColor(Color.BLACK);
            bootsMeta.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Black Armor");
            boots.setItemMeta(bootsMeta);

            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
            leggingsMeta.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Black Armor");
            leggingsMeta.setColor(Color.BLACK);
            leggings.setItemMeta(leggingsMeta);


            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestplateMeta.setColor(Color.BLACK);
            chestplateMeta.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Black Armor");
            chestplate.setItemMeta(chestplateMeta);

            player.getInventory().setBoots(boots);
            player.getInventory().setLeggings(leggings);
            player.getInventory().setChestplate(chestplate);
        }
    }

}