package mc.capturetheflag.listener;

import jdk.tools.jlink.plugin.Plugin;
import mc.capturetheflag.CaptureTheFlag;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Team;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.TimeUnit;

import static mc.capturetheflag.CaptureTheFlag.captureTheFlag;
import static mc.capturetheflag.game.GetArmor.armorColor;
import static mc.capturetheflag.game.GetTeam.getCurrentTeam;

public class ToxicWaistDetect implements Listener {


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location to = event.getTo();
        Location below = to.clone().subtract(0, 1, 0);
        Team team = getCurrentTeam(player);

        if (below.getBlock().getType() == Material.LIME_STAINED_GLASS) {
            player.playSound(player.getLocation(), "minecraft:block.lava.extinguish", 999999999999.0f, 1.0f);
            player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 55, true));
            player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 5, 55, true));
            player.spawnParticle(Particle.LAVA, player.getLocation().add(0.5, 1.0, 0.5), 10);
            player.damage(7.0);
            String message = (ChatColor.YELLOW + "" + ChatColor.BOLD + player + ChatColor.GREEN + "" + ChatColor.BOLD + "Fell Into Toxic Waste!");
            Bukkit.broadcastMessage(message);

            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootsMeta.setColor(Color.LIME);
            bootsMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Toxic Armor");
            boots.setItemMeta(bootsMeta);

            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
            leggingsMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Toxic Armor");
            leggingsMeta.setColor(Color.LIME);
            leggings.setItemMeta(leggingsMeta);


            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestplateMeta.setColor(Color.LIME);
            chestplateMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Toxic Armor");
            chestplate.setItemMeta(chestplateMeta);

            player.getInventory().setBoots(boots);
            player.getInventory().setLeggings(leggings);
            player.getInventory().setChestplate(chestplate);


            Bukkit.getScheduler().runTaskLater(captureTheFlag, () -> {
                if (team.getName().equalsIgnoreCase("red")) {
                    armorColor(player, "red");
                } else if (team.getName().equalsIgnoreCase("blue")) {
                    armorColor(player, "blue");
                }
            }, 20*10);
        }
    }
}

