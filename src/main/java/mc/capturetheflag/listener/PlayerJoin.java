package mc.capturetheflag.listener;

import io.papermc.paper.event.player.PlayerNameEntityEvent;
import mc.capturetheflag.game.PlayerMoney;
import mc.capturetheflag.scoreboard.FastBoard;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerJoin implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = (Player) event.getPlayer();
        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "This game is under development so things may not work!");
        player.displayName(ChatColor.DARK_GRAY + "Not In A Team")
        }
    }