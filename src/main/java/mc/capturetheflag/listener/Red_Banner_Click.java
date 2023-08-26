package mc.capturetheflag.listener;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static mc.capturetheflag.game.GetTeam.getCurrentTeam;

public class Red_Banner_Click implements Listener {
    private final Map<UUID, Long> flagCooldowns = new HashMap<>();
    private static final long FLAG_COOLDOWN_TIME = 1000; //milliseconds

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Team team = getCurrentTeam(player);
        Location to = event.getTo();

        if (flagCooldowns.containsKey(player.getUniqueId())) {
            long cooldownEnd = flagCooldowns.get(player.getUniqueId());
            if (System.currentTimeMillis() < cooldownEnd) {
                return;
            } else {
                flagCooldowns.remove(player.getUniqueId());
            }
        }

        if (to.getBlock().getType() == Material.RED_BANNER && team != null && team.getName().equalsIgnoreCase("blue")) {
            player.sendMessage(ChatColor.DARK_RED + "Red Flag Picked Up!");
            player.spawnParticle(Particle.COMPOSTER, player.getLocation().add(0, 1, 0), 100, 0.5, 0.5, 0.5, 0.1);
            player.playSound(player.getLocation(), "minecraft:block.note_block.bit", 1.0f, 2.0f);
            Location location = player.getLocation();
            location.getBlock().setType(Material.AIR);
            ItemStack blueBanner = new ItemStack(Material.RED_BANNER);
            player.getEquipment().setItem(EquipmentSlot.HEAD, blueBanner);
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 999999999, 1, true));
            Sound sound = Sound.ENTITY_ENDER_DRAGON_GROWL;
            float volume = 1.0f;
            float pitch = 1.0f;
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.playSound(all.getLocation(), sound, volume, pitch);
            }
            flagCooldowns.put(player.getUniqueId(), System.currentTimeMillis() + FLAG_COOLDOWN_TIME);
        }
    }

}