package mc.capturetheflag.command;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

import static mc.capturetheflag.game.TeamSelect.joinTeamBlue;
import static mc.capturetheflag.game.TeamSelect.joinTeamRed;

public class start_ctf implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        Player player = (Player) sender;
        ItemStack teamsel = new ItemStack(Material.RECOVERY_COMPASS);
        ItemMeta SI = teamsel.getItemMeta();
        SI.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Right Click" + "" + ChatColor.GOLD + " To Select Your Team");
        teamsel.setItemMeta(SI);
        player.getInventory().setItem(4, teamsel);

        return true;
    }
}