package mc.capturetheflag.game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TeamSelect {
    public static void joinTeamBlue(Player p){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam("BLUE");
        if (team == null) {
            team = scoreboard.registerNewTeam("BLUE");
        }
        team.setColor(ChatColor.BLUE);
        team.setPrefix(ChatColor.BLUE + "BLUE" + ChatColor.RESET + " ");
        team.addEntry(p.getName());
        team.setDisplayName(ChatColor.BLUE + "BLUE");
    }

    public static void joinTeamRed(Player p){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam("RED");
        if (team == null) {
            team = scoreboard.registerNewTeam("RED");
        }
        team.setColor(ChatColor.RED);
        team.setPrefix(ChatColor.RED + "RED" + ChatColor.RESET + " ");
        team.addEntry(p.getName());
        team.setDisplayName(ChatColor.RED + "RED");
    }

    public static void removeFromTeam(Player p){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team red = scoreboard.getTeam("RED");
        if (red == null) {
            return;
        }
        red.removeEntry(p.getName());
        Team blue = scoreboard.getTeam("BLUE");
        if (blue == null) {
            return;
        }
        blue.removeEntry(p.getName());
    }
}
