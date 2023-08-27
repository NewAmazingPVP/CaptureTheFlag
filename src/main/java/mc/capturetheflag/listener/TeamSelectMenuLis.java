package mc.capturetheflag.listener;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class TeamSelectMenuLis implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        //this is for the team select menu thing good luck de bugging xD
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_AQUA + "[Select Team]")) {



            if (event.getCurrentItem() == null) {
                return;
            }
            if (event.getCurrentItem().getType() == Material.RED_CONCRETE) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "/join red");
                Player player = (Player) event.getView().getPlayer();
                player.performCommand("join red");
                player.playSound(player.getLocation(), "minecraft:block.note_block.pling", 1.0f, 2.0f);
                player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 10, 0.6, 0.6, 0.6, new Particle.DustOptions(Color.RED, 3));

            } else if (event.getCurrentItem().getType() == Material.BLUE_CONCRETE) {

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "/join blue");
                Player player = (Player) event.getView().getPlayer();
                player.performCommand("join blue");
                player.playSound(player.getLocation(), "minecraft:block.note_block.pling", 1.0f, 2.0f);
                player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 10, 0.6, 0.6, 0.6, new Particle.DustOptions(Color.BLUE, 3));

            } else if (event.getCurrentItem().getType() == Material.BLACK_CONCRETE) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "/leave");
                Player player = (Player) event.getView().getPlayer();
                player.performCommand("leave");
                player.playSound(player.getLocation(), "minecraft:block.note_block.pling", 1.0f, 5.0f);
                player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 10, 0.6, 0.6, 0.6, new Particle.DustOptions(Color.BLACK, 3));


            }


            event.setCancelled(true);

        }

    }

}

