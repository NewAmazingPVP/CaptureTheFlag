package mc.capturetheflag.command;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import static mc.capturetheflag.variables.Locations.jail;

public class jail_ctf implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            Player player = Bukkit.getPlayer(args[0]);
            assert player != null;
            player.teleport(jail);
            player.sendMessage(ChatColor.RED + "You were killed!");

        } else {
            sender.sendMessage("Specify player");
        }
        return true;
    }
}
