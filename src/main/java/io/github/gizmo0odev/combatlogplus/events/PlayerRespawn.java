package io.github.gizmo0odev.combatlogplus.events;

import io.github.gizmo0odev.combatlogplus.CombatLogPlus;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener {

    CombatLogPlus plugin;

    public PlayerRespawn(CombatLogPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerRespawnEvent(PlayerRespawnEvent event) {
        plugin.getCombatHandler().remove(event.getPlayer().getUniqueId());
    }

}
