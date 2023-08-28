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

public class Blue_Banner_Click implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Team team = getCurrentTeam(player);
        Location to = event.getTo();

        if (to.getBlock().getType() == Material.BLUE_BANNER && team != null && team.getName().equalsIgnoreCase("red")) {
            player.sendMessage(ChatColor.DARK_BLUE + "Blue Flag Picked Up!");
            player.spawnParticle(Particle.COMPOSTER, player.getLocation().add(0, 1, 0), 100, 0.5, 0.5, 0.5, 0.1);
            player.playSound(player.getLocation(), "minecraft:block.note_block.bit", 1.0f, 2.0f);
            to.getBlock().setType(Material.AIR);
            ItemStack blueBanner = new ItemStack(Material.BLUE_BANNER);
            player.getEquipment().setItem(EquipmentSlot.HEAD, blueBanner);
            player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 10, 0.6, 0.6, 0.6, new Particle.DustOptions(Color.BLUE, 3));
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 999999999, 1, true));

            /*Block block = event.getBlock();
            World world = block.getWorld();

            // Create a falling block entity with blue concrete block state
            FallingBlock fallingBlock = world.spawnFallingBlock(block.getLocation(), Material.BLUE_CONCRETE.createBlockData());

            // Set the velocity of the falling block
            fallingBlock.setVelocity(new Vector(0, 1, 0));*/

            Sound sound = Sound.ENTITY_ENDER_DRAGON_GROWL;
            float volume = 1.0f;
            float pitch = 0.0f;
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.playSound(all.getLocation(), sound, volume, pitch);
            }
        }
    }
}