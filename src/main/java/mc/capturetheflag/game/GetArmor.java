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
        String Name = null;
        Color color = null;
        if ("red".equalsIgnoreCase(teamName)) {
            color = Color.RED;
            String Name = (ChatColor.DARK_RED + "" + ChatColor.BOLD + "Red Armor");*/
        } else if ("blue".equalsIgnoreCase(teamName)) {
            color = Color.BLUE;
            String Name = (ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Blue Armor");*/
        }



        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setColor(color);
        bootsMeta.setDisplayName(Name);
        boots.setItemMeta(bootsMeta);

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
        leggingsMeta.setColor(color);
        bootsMeta.setDisplayName(Name);
        leggings.setItemMeta(leggingsMeta);

        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        chestplateMeta.setColor(color);
        bootsMeta.setDisplayName(Name);

        chestplate.setItemMeta(chestplateMeta);

        player.getInventory().setBoots(boots);
        player.getInventory().setLeggings(leggings);
        player.getInventory().setChestplate(chestplate);
    }
}
