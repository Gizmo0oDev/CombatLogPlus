package io.github.gizmo0odev.combatlogplus.events;

import io.github.gizmo0odev.combatlogplus.CombatLogPlus;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity implements Listener {

    CombatLogPlus plugin;

    public EntityDamageByEntity(CombatLogPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {

        if (
                event.getDamager() instanceof Player damager && event.getEntity() instanceof Player victim
                        && !event.getDamager().getWorld().getName().equalsIgnoreCase(CombatLogPlus.disableWorld)
                        && !event.getEntity().getWorld().getName().equalsIgnoreCase(CombatLogPlus.disableWorld)
        ) {
            plugin.getCombatHandler().add(damager);
            plugin.getCombatHandler().add(victim);
        }

    }

}
