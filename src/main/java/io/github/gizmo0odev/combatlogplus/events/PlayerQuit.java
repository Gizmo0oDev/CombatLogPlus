package io.github.gizmo0odev.combatlogplus.events;

import io.github.gizmo0odev.combatlogplus.CombatLogPlus;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class PlayerQuit implements Listener {

    CombatLogPlus plugin;

    public PlayerQuit(CombatLogPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {

        if (plugin.getCombatHandler().isCombat(event.getPlayer())) {

            plugin.getLocation().put(event.getPlayer().getUniqueId(), event.getPlayer().getLocation());

            if (CombatLogPlus.killOnDisconnect == false) {

                for (ItemStack content : event.getPlayer().getInventory().getContents()) {
                    if (content != null) {
                        event.getPlayer().getWorld().dropItem(event.getPlayer().getLocation(), content).setVelocity(new Vector(0, 0, 0));
                    }
                }

                event.getPlayer().getInventory().clear();
                event.getPlayer().setHealth(0);
                plugin.getCombatHandler().remove(event.getPlayer().getUniqueId());

            }

        }

    }

}
