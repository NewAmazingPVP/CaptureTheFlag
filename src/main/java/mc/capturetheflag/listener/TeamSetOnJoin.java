package mc.capturetheflag.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TeamSetOnJoin implements Listener {

    /*@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Get the player
        Player player = event.getPlayer();

        // Get the scoreboard
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        // Get or create the team for players not on a team
        Team team = scoreboard.getTeam("Not on a team");
        if (team == null) {
            team = scoreboard.registerNewTeam("Not on a team");
        }

        // Set the team color to gray
        team.setColor(ChatColor.GRAY);

        team.setPrefix(ChatColor.RED + "Not on a team" + ChatColor.RESET + " ");

        // Add the player to the team
        team.addEntry(player.getName());
        team.setDisplayName(ChatColor.RED + "RED");
    }*/

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        Team team = player.getScoreboard().getPlayerTeam(player);

        if (team != null && team.getName().equals("BLUE")) {
            event.setFormat(ChatColor.BLUE + "BLUE" + ChatColor.RESET + " " + player.getName() + ": " + event.getMessage());
        }
        if (team != null && team.getName().equals("RED")) {
            event.setFormat(ChatColor.RED + "RED" + ChatColor.RESET + " " + player.getName() + ": " + event.getMessage());
        }
    }

    @EventHandler
    public void onServerCommand(ServerCommandEvent event) {
        String command = event.getCommand().toLowerCase();

        if (command.equals("stop") || command.equals("restart")) {
            for(Player p : Bukkit.getOnlinePlayers()){
                p.performCommand("leave");
                p.clearActivePotionEffects();
            }
        }
    }
}