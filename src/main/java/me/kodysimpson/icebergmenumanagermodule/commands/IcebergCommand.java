package me.kodysimpson.icebergmenumanagermodule.commands;

import me.kodysimpson.icebergmenumanagermodule.menu.menus.FreezeMainMenu;
import me.kodysimpson.simpapi.exceptions.MenuManagerException;
import me.kodysimpson.simpapi.exceptions.MenuManagerNotSetupException;
import me.kodysimpson.simpapi.menu.MenuManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IcebergCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player p = (Player) sender;

            try {
                MenuManager.openMenu(FreezeMainMenu.class, p);
            } catch (MenuManagerException | MenuManagerNotSetupException e) {
                e.printStackTrace();
            }

        }

        return true;
    }

}
