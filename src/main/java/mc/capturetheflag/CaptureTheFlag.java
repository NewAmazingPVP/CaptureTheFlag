package mc.capturetheflag;

import mc.capturetheflag.command.LeaveTeam;
import mc.capturetheflag.command.TeamJoin;
import mc.capturetheflag.command.Team_sel_item;
import mc.capturetheflag.command.jail_ctf;
import mc.capturetheflag.game.PlayerMoney;
import mc.capturetheflag.listener.*;
import mc.capturetheflag.scoreboard.FastBoard;
import mc.capturetheflag.utility.AutoUpload;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
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
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static mc.capturetheflag.variables.Locations.lobbyLoc;

public final class CaptureTheFlag extends JavaPlugin implements Listener {

    public static Economy economy;
    public static CaptureTheFlag captureTheFlag;
    private final Map<UUID, FastBoard> boards = new HashMap<>();

    public static void setupEconomy() {
        RegisteredServiceProvider<Economy> rsp = Bukkit.getServicesManager().getRegistration(Economy.class);
        if (rsp != null) {
            economy = rsp.getProvider();
        }
    }

    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        captureTheFlag = this;
        getCommand("join").setExecutor(new TeamJoin());
        getCommand("leave").setExecutor(new LeaveTeam());
        getCommand("jail_ctf").setExecutor(new jail_ctf());
        getCommand("getteamselitem").setExecutor(new Team_sel_item());
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
        getServer().getPluginManager().registerEvents(new NoTeamArmor(), this);
        getServer().getPluginManager().registerEvents(new CancelArmorTakeoff(), this);
        getServer().getPluginManager().registerEvents(new Red_Banner_Click(), this);
        getServer().getPluginManager().registerEvents(new TeamSelectItem(), this);
        getServer().getPluginManager().registerEvents(new TeamSelectMenuLis(), this);
        getServer().getPluginManager().registerEvents(new OpenJailBlue(), this);
        getServer().getPluginManager().registerEvents(new TestWorldGuard(), this);
        getServer().getPluginManager().registerEvents(new ToxicWaistDetect(), this);

        setupEconomy();
        getServer().getScheduler().runTaskTimer(this, () -> {
            for (FastBoard board : this.boards.values()) {
                updateBoard(board);
            }
        }, 0, 20);
        AutoUpload.startReleaseChecker();
    }

    @Override
    public void onDisable() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.performCommand("leave");
            p.clearActivePotionEffects();
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.teleport(lobbyLoc);
        TextComponent message = new TextComponent(ChatColor.GOLD + "Select your team!\n");

        TextComponent discordText = new TextComponent(ChatColor.BLUE + "BLUE ");
        discordText.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/join blue"));
        message.addExtra(discordText);
        message.addExtra("\n");
        TextComponent red = new TextComponent(ChatColor.RED + "RED ");
        red.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/join red"));
        message.addExtra(red);
        new BukkitRunnable() {
            @Override
            public void run() {
                player.sendMessage(message);
            }
        }.runTaskLater(this, 20);
        player.sendTitle(ChatColor.DARK_AQUA + "Welcome To CTF!", "");
        player.getWorld().strikeLightningEffect(event.getPlayer().getLocation());
        PlayerMoney.setCoins(player, 0);
        FastBoard board = new FastBoard(player);
        board.updateTitle(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Capture" + "" + ChatColor.DARK_BLUE + "" + ChatColor.BOLD + " The Flag");
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

    private void updateBoard(FastBoard board) {
        int coins = PlayerMoney.getCoins(board.getPlayer());

        board.updateLines(
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "--------------------",
                ChatColor.GREEN + "" + ChatColor.BOLD + "Time Left: N/A",
                "",
                ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Rounds Left: N/A",
                "",
                ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Souls: N/A",
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "--------------------",
                ChatColor.AQUA + "" + ChatColor.BOLD + "           Scores       ",
                "",
                ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Blue: N/A",
                "",
                ChatColor.DARK_RED + "" + ChatColor.BOLD + "Red: N/A",
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "--------------------"

        );
    }
}
