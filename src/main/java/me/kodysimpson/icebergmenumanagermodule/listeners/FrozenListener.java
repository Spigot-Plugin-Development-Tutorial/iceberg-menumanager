package me.kodysimpson.icebergmenumanagermodule.listeners;

import me.kodysimpson.icebergmenumanagermodule.IcebergMenuManagerModule;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FrozenListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e){

        if (IcebergMenuManagerModule.getFrozenPlayers().contains(e.getPlayer())){
            e.setCancelled(true);
        }

    }

}
