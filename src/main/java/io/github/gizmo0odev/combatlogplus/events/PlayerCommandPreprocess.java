package io.github.gizmo0odev.combatlogplus.events;

import io.github.gizmo0odev.combatlogplus.CombatLogPlus;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandPreprocess implements Listener {

    CombatLogPlus plugin;

    public PlayerCommandPreprocess(CombatLogPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent event) {
        if (
                event.getMessage().replace("/", "").split(" ")[0].equalsIgnoreCase(CombatLogPlus.disableCommand1)
                        || event.getMessage().replace("/", "").split(" ")[0].equalsIgnoreCase(CombatLogPlus.disableCommand2)
                        || event.getMessage().replace("/", "").split(" ")[0].equalsIgnoreCase(CombatLogPlus.disableCommand3)
                        || event.getMessage().replace("/", "").split(" ")[0].equalsIgnoreCase(CombatLogPlus.disableCommand4)
                        || event.getMessage().replace("/", "").split(" ")[0].equalsIgnoreCase(CombatLogPlus.disableCommand5)
                        || event.getMessage().replace("/", "").split(" ")[0].equalsIgnoreCase(CombatLogPlus.disableCommand6)
                        || event.getMessage().replace("/", "").split(" ")[0].equalsIgnoreCase(CombatLogPlus.disableCommand7)
                        || event.getMessage().replace("/", "").split(" ")[0].equalsIgnoreCase(CombatLogPlus.disableCommand8)
                        || event.getMessage().replace("/", "").split(" ")[0].equalsIgnoreCase(CombatLogPlus.disableCommand9)
                        || event.getMessage().replace("/", "").split(" ")[0].equalsIgnoreCase(CombatLogPlus.disableCommand10)
        ) {

            if (plugin.getCombatHandler().isCombat(event.getPlayer())) {
                event.getPlayer().sendMessage(CombatLogPlus.errorMessage);
                event.setCancelled(true);
            }

        }
    }

}
