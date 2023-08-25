package mc.capturetheflag.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerJoin extends JavaPlugin implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = (Player) event.getPlayer();
        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "This game is under development so things may not work!");
        }
    }