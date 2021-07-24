package me.kodysimpson.icebergmenumanagermodule.menu.menus;

import me.kodysimpson.icebergmenumanagermodule.IcebergMenuManagerModule;
import me.kodysimpson.simpapi.exceptions.MenuManagerException;
import me.kodysimpson.simpapi.exceptions.MenuManagerNotSetupException;
import me.kodysimpson.simpapi.menu.Menu;
import me.kodysimpson.simpapi.menu.MenuManager;
import me.kodysimpson.simpapi.menu.PlayerMenuUtility;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ConfirmMeltMenu extends Menu {

    public ConfirmMeltMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Confirm Melt: " + playerMenuUtility.getData(PMUData.PLAYER_TO_MELT, Player.class).getDisplayName();
    }

    @Override
    public int getSlots() {
        return 9;
    }

    @Override
    public boolean cancelAllClicks() {
        return true;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) throws MenuManagerNotSetupException, MenuManagerException {

        switch (e.getCurrentItem().getType()){
            case GREEN_BANNER:

                Player target = playerMenuUtility.getData(PMUData.PLAYER_TO_MELT, Player.class);

                playerMenuUtility.getOwner().closeInventory();
                playerMenuUtility.getOwner().sendMessage(target.getDisplayName() + " has been melted!");

                IcebergMenuManagerModule.getFrozenPlayers().remove(target);

                break;
            case RED_BANNER:
                MenuManager.openMenu(MeltListMenu.class, playerMenuUtility.getOwner());
                break;
        }

    }

    @Override
    public void setMenuItems() {

        ItemStack yes = makeItem(Material.GREEN_BANNER, "Yes");
        ItemStack no = makeItem(Material.RED_BANNER, "No");

        inventory.setItem(3, yes);
        inventory.setItem(5, no);

    }
}
