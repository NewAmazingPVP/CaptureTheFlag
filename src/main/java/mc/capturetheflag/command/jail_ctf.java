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

            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootsMeta.setColor(Color.ORANGE);
            boots.setItemMeta(bootsMeta);

            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
            leggingsMeta.setColor(Color.ORANGE);
            leggings.setItemMeta(leggingsMeta);

            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestplateMeta.setColor(Color.ORANGE);
            chestplate.setItemMeta(chestplateMeta);

            player.getInventory().setBoots(boots);
            player.getInventory().setLeggings(leggings);
            player.getInventory().setChestplate(chestplate);
        } else {
            sender.sendMessage("Specify player");
        }
        return true;
    }
}
