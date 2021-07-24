package me.kodysimpson.icebergmenumanagermodule.menu.menus;

import me.kodysimpson.icebergmenumanagermodule.IcebergMenuManagerModule;
import me.kodysimpson.simpapi.exceptions.MenuManagerException;
import me.kodysimpson.simpapi.exceptions.MenuManagerNotSetupException;
import me.kodysimpson.simpapi.menu.Menu;
import me.kodysimpson.simpapi.menu.MenuManager;
import me.kodysimpson.simpapi.menu.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MeltListMenu extends Menu {

    public MeltListMenu(PlayerMenuUtility pmu) {
        super(pmu);
    }

    @Override
    public String getMenuName() {
        return "Choose a Player to Melt";
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public boolean cancelAllClicks() {
        return true;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) throws MenuManagerNotSetupException, MenuManagerException {

        switch (e.getCurrentItem().getType()){
            case PLAYER_HEAD:

                Player target = Bukkit.getPlayer(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                playerMenuUtility.setData(PMUData.PLAYER_TO_MELT, target);

                MenuManager.openMenu(ConfirmMeltMenu.class, playerMenuUtility.getOwner());

                break;
        }

    }

    @Override
    public void setMenuItems() {

        IcebergMenuManagerModule.getFrozenPlayers().stream()
                .forEach(player -> {
                    ItemStack head = makeItem(Material.PLAYER_HEAD, player.getDisplayName());
                    inventory.addItem(head);
                });

    }
}
