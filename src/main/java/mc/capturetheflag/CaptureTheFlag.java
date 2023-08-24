package mc.capturetheflag;

import mc.capturetheflag.listener.DetectBlock;
import org.bukkit.plugin.java.JavaPlugin;

public final class CaptureTheFlag extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DetectBlock(), this);

    }
}
