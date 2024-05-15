package io.github.gizmo0odev.combatlogplus.events;

import io.github.gizmo0odev.combatlogplus.CombatLogPlus;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    CombatLogPlus plugin;

    public PlayerJoin(CombatLogPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {

        if (CombatLogPlus.killOnDisconnect == true) {

            if (plugin.getCombatHandler().isCombat(event.getPlayer())) {

                Bukkit.getScheduler().runTaskLater(plugin, ()-> {
                    plugin.getCombatHandler().add(event.getPlayer());

                    if (plugin.getLocation().get(event.getPlayer().getUniqueId()) != null) {
                        Bukkit.getScheduler().runTaskLater(plugin, ()-> event.getPlayer().teleport(plugin.getLocation().get(event.getPlayer().getUniqueId())), 2);
                    }

                    event.getPlayer().setNoDamageTicks(1);
                    event.getPlayer().setMaximumNoDamageTicks(1);
                }, 1);

            }

        }

    }

}
