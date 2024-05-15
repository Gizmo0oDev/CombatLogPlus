package io.github.gizmo0odev.combatlogplus;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class CombatHandler {

    CombatLogPlus plugin;

    public CombatHandler(CombatLogPlus plugin) {
        this.plugin = plugin;
    }

    public boolean isCombat(Player player) {
        return plugin.getCombat().containsKey(player.getUniqueId());
    }

    public void add(Player player) {
        Duration duration = Duration.of(CombatLogPlus.combatDuration, ChronoUnit.SECONDS);
        plugin.getCombat().put(player.getUniqueId(), duration);
        sendTitle(player, duration);
    }

    public void update(UUID uuid) {
        Duration duration = plugin.getCombat().get(uuid);

        if (duration.isZero() || duration.isNegative()) {
            remove(uuid);
        } else {
            plugin.getCombat().put(uuid, duration.minus(Duration.of(1, ChronoUnit.SECONDS)));
            sendTitle(Bukkit.getPlayer(uuid), duration);
        }

    }

    public void remove(UUID uuid) {
        Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, ()-> plugin.getCombat().remove(uuid), 1);
    }

    private void sendTitle(Player player, Duration duration) {

        if (player != null) {

            TextComponent component = new TextComponent(CombatLogPlus.combatTitle);
            //component.setColor(ChatColor.WHITE);
            TextComponent time = new TextComponent(String.valueOf(duration.getSeconds()));
            time.setColor(ChatColor.DARK_RED);
            component.addExtra(time);
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, component);

        }

    }

}
