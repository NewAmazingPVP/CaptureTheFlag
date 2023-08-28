package mc.capturetheflag.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static mc.capturetheflag.variables.Locations.jail;

public class jail_ctf implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            Player player = Bukkit.getPlayer(args[0]);
            assert player != null;
            player.teleport(jail);
            player.sendMessage(ChatColor.RED + "You were killed!... this is just a tes location idk...");
            player.setGameMode(GameMode.ADVENTURE);

        } else {
            sender.sendMessage("Specify player");
        }
        return true;
    }
}
