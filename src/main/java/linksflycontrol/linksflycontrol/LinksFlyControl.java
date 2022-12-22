package linksflycontrol.linksflycontrol;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class LinksFlyControl extends JavaPlugin implements Listener {
    private static LinksFlyControl instance;
    private static final String prefix = "§a§l[ §6§lLinks-FC §a§l]";

    @Override
    public void onEnable() {
        final File f = new File(this.getDataFolder() + File.separator + "config.yml");
        if (!f.exists()) {
            saveDefaultConfig();
            log("Файл конфигурации не был найден! Создаю новый...");
        }
        instance = this;
        log("------------------------------------");
        log("        Включен. Версия 1.0         ");
        log("           Dev. Link_play           ");
        log("------------------------------------");
    }

    public static LinksFlyControl getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        log("------------------------------------");
        log("        Включен. Версия 1.0         ");
        log("           Dev. Link_play           ");
        log("------------------------------------");
    }

    @EventHandler
    public void test(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (getConfig().getBoolean("FlyControl.FlyFix")) {
            if (!p.isOp()) {
                if (!p.hasPermission("cmi.command.fly")) {
                    p.teleport(new Location(p.getWorld(), 11955,68,1373));
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    p.sendMessage(getConfig().getString("FlyControl.FixMSG").replaceAll("&", "§"));
                }
            }
        }
    }


    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage(getPrefix() + message);
    }

    public static String getPrefix() {
        return prefix;
    }
}
