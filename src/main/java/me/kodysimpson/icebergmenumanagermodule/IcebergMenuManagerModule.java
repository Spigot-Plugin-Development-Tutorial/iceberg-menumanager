package me.kodysimpson.icebergmenumanagermodule;

import me.kodysimpson.icebergmenumanagermodule.commands.IcebergCommand;
import me.kodysimpson.icebergmenumanagermodule.listeners.FrozenListener;
import me.kodysimpson.simpapi.menu.MenuManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class IcebergMenuManagerModule extends JavaPlugin {

    private static ArrayList<Player> frozenPlayers = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Setup and register the MenuManager. It will take care of the annoying parts.
        MenuManager.setup(getServer(), this);

        getCommand("iceberg").setExecutor(new IcebergCommand());

        getServer().getPluginManager().registerEvents(new FrozenListener(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ArrayList<Player> getFrozenPlayers() {
        return frozenPlayers;
    }

    public static void setFrozenPlayers(ArrayList<Player> frozenPlayers) {
        IcebergMenuManagerModule.frozenPlayers = frozenPlayers;
    }
}
