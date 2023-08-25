package mc.capturetheflag.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static mc.capturetheflag.game.TeamSelect.joinTeamBlue;
import static mc.capturetheflag.game.TeamSelect.joinTeamRed;

public class TeamJoin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by players.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage("Usage: /join <team>");
            return true;
        }

        Player player = (Player) sender;
        String selectedTeam = args[0].toLowerCase(); // Convert to lowercase for easier comparison

        if (selectedTeam.equals("blue")) {
            joinTeamBlue(player);
            player.sendMessage("You have joined the blue team!");
        } else if (selectedTeam.equals("red")) {
            joinTeamRed(player);
            player.sendMessage("You have joined the red team!");
        } else {
            player.sendMessage("Invalid team. Available teams: blue, red");
        }

        return true;
    }
}
