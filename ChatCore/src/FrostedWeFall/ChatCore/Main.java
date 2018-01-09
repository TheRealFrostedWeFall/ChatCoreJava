package FrostedWeFall.ChatCore;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "ChatCore V0.1 Has been successfully enabled!");
        getServer().getPluginManager().registerEvents(new EventsClass(), this);
    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "ChatCore V0.1 Has been successfully disabled");

    }

}