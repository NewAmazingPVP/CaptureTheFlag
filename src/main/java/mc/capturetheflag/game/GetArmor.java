package mc.capturetheflag.game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class GetArmor {
    public static void armorColor(Player player, String teamName) {
        Color color = null;
        if ("red".equalsIgnoreCase(teamName)) {
            color = Color.RED;
        } else if ("blue".equalsIgnoreCase(teamName)) {
            color = Color.BLUE;
        }

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setColor(color);
        boots.setItemMeta(bootsMeta);

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
        leggingsMeta.setColor(color);
        leggings.setItemMeta(leggingsMeta);

        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        chestplateMeta.setColor(color);
        chestplate.setItemMeta(chestplateMeta);

        player.getInventory().setBoots(boots);
        player.getInventory().setLeggings(leggings);
        player.getInventory().setChestplate(chestplate);
    }
}
