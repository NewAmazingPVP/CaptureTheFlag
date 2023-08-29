package mc.capturetheflag.command;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static mc.capturetheflag.game.TeamSelect.joinTeamBlue;
import static mc.capturetheflag.game.TeamSelect.joinTeamRed;

public class start_ctf implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        return true;
    }
}