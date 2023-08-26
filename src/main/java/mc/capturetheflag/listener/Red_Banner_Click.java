package mc.capturetheflag.listener;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Team;

import static mc.capturetheflag.game.GetTeam.getCurrentTeam;

public class Red_Banner_Click implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Team team = getCurrentTeam(player);
        Location to = event.getTo();

        if (to.getBlock().getType() == Material.RED_BANNER && team != null && team.getName().equalsIgnoreCase("blue")) {
            player.sendMessage(ChatColor.DARK_RED + "Red Flag Picked Up!");
            player.spawnParticle(Particle.COMPOSTER, player.getLocation().add(0, 1, 0), 100, 0.5, 0.5, 0.5, 0.1);
            player.playSound(player.getLocation(), "minecraft:block.note_block.bit", 1.0f, 2.0f);
            to.getBlock().setType(Material.AIR);
            ItemStack blueBanner = new ItemStack(Material.RED_BANNER);
            player.getEquipment().setItem(EquipmentSlot.HEAD, blueBanner);
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 999999999, 1, true));
            Sound sound = Sound.ENTITY_ENDER_DRAGON_GROWL;
            float volume = 1.0f;
            float pitch = 1.0f;
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.playSound(all.getLocation(), sound, volume, pitch);
            }
        }
    }

}