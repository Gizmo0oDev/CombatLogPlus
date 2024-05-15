package io.github.gizmo0odev.combatlogplus.events;

import io.github.gizmo0odev.combatlogplus.CombatLogPlus;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    CombatLogPlus plugin;

    public PlayerMove(CombatLogPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent event) {

        TextComponent component = new TextComponent(CombatLogPlus.errorMessage);
        //component.setColor(net.md_5.bungee.api.ChatColor.RED);

        if(plugin.getCombatHandler().isCombat(event.getPlayer())) {

            if (CombatLogPlus.disableElytra == true) {

                if (event.getPlayer().isGliding()) {
                    event.getPlayer().setGliding(false);
                    event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, component);
                }

            }

            if (CombatLogPlus.disableTrident == true) {

                if (event.getPlayer().isRiptiding()) {
                    event.setCancelled(true);
                    event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, component);
                }

            }

        }
    }

}
