package mc.capturetheflag.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static mc.capturetheflag.game.TeamSelect.removeFromTeam;

public class Team_sel_item implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by players.");
            return true;
        }

        Player player = (Player) sender;
        ItemStack teamsel = new ItemStack(Material.RECOVERY_COMPASS);
        ItemMeta SI = teamsel.getItemMeta();
        SI.setDisplayName(ChatColor.BOLD + "" + ChatColor.YELLOW + "Right Click" + ChatColor.BOLD + "" + ChatColor.GOLD + " To Select Your Team");
        teamsel.setItemMeta(SI);

        player.getInventory().addItem(teamsel);

        return true;
    }
}