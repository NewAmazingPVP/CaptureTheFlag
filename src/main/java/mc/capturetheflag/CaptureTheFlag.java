package mc.capturetheflag;

import mc.capturetheflag.game.PlayerMoney;
import mc.capturetheflag.listener.*;
import mc.capturetheflag.scoreboard.FastBoard;
import mc.capturetheflag.utility.AutoUpload;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class CaptureTheFlag extends JavaPlugin implements Listener {

    public static Economy economy;
    public static CaptureTheFlag captureTheFlag;
    private final Map<UUID, FastBoard> boards = new HashMap<>();

    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        captureTheFlag = this;
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new DetectBlock(), this);
        getServer().getPluginManager().registerEvents(new LaunchBall(), this);
        getServer().getPluginManager().registerEvents(new Craft_table_detect(), this);
        getServer().getPluginManager().registerEvents(new Blue_Banner_Click(), this);
        getServer().getPluginManager().registerEvents(new Open_Furnace(), this);
        getServer().getPluginManager().registerEvents(new LaunchTNT(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new TeamSetOnJoin(), this);
        getServer().getPluginManager().registerEvents(new ShearSheepTest(), this);

        setupEconomy();
        getServer().getScheduler().runTaskTimer(this, () -> {
            for (FastBoard board : this.boards.values()) {
                updateBoard(board);
            }
        }, 0, 20);
        AutoUpload.startReleaseChecker();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendTitle(ChatColor.DARK_AQUA + "Welcome!", "");
        player.getWorld().strikeLightningEffect(event.getPlayer().getLocation());
        PlayerMoney.setCoins(player, 0);
        FastBoard board = new FastBoard(player);
        board.updateTitle(ChatColor.AQUA + "Capture The Flag");
        this.boards.put(player.getUniqueId(), board);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        FastBoard board = this.boards.remove(player.getUniqueId());
        if (board != null) {
            board.delete();
        }
    }

    public static void setupEconomy() {
        RegisteredServiceProvider<Economy> rsp = Bukkit.getServicesManager().getRegistration(Economy.class);
        if (rsp != null) {
            economy = rsp.getProvider();
        }
    }

    private void updateBoard(FastBoard board) {
        int coins = PlayerMoney.getCoins(board.getPlayer());

        board.updateLines(
                "",
                ChatColor.DARK_AQUA + "Souls: " + 1,
                ChatColor.GREEN + "Time Left: " + 1
        );
    }
}
