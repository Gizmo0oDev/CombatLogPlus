package io.github.gizmo0odev.combatlogplus.events;

import io.github.gizmo0odev.combatlogplus.CombatLogPlus;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleport implements Listener {

    CombatLogPlus plugin;

    public PlayerTeleport(CombatLogPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerTeleportEvent(PlayerTeleportEvent event) {

        if (CombatLogPlus.disableEnderPearl == true) {

            if (event.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL && plugin.getCombatHandler().isCombat(event.getPlayer())) {
                plugin.getCombatHandler().add(event.getPlayer());
            }

        }

        if (CombatLogPlus.disableChorusFruit == true) {

            if (event.getCause() == PlayerTeleportEvent.TeleportCause.CHORUS_FRUIT && plugin.getCombatHandler().isCombat(event.getPlayer())) {
                plugin.getCombatHandler().add(event.getPlayer());
            }

        }

    }

}
