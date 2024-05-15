package io.github.gizmo0odev.combatlogplus;

import io.github.gizmo0odev.combatlogplus.events.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Duration;
import java.util.HashMap;
import java.util.UUID;

public final class CombatLogPlus extends JavaPlugin {

    private FileConfiguration config = getConfig();

    private HashMap<UUID, Duration> combat;
    private HashMap<UUID, Location> location;
    private CombatHandler combatHandler;

    public static String combatTitle;
    public static int combatDuration;
    public static boolean killOnDisconnect;
    public static boolean disableElytra;
    public static boolean disableTrident;
    public static boolean disableEnderPearl;
    public static boolean disableChorusFruit;
    public static String disableWorld;
    public static String disableCommand1;
    public static String disableCommand2;
    public static String disableCommand3;
    public static String disableCommand4;
    public static String disableCommand5;
    public static String disableCommand6;
    public static String disableCommand7;
    public static String disableCommand8;
    public static String disableCommand9;
    public static String disableCommand10;
    public static String errorMessage;

    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        combatTitle = config.getString("combat-title");
        combatDuration = config.getInt("combat-duration");
        killOnDisconnect = config.getBoolean("kill-on-disconnect");
        disableElytra = config.getBoolean("disable-elytra");
        disableTrident = config.getBoolean("disable-elytra");
        disableEnderPearl = config.getBoolean("disable-ender-pearl");
        disableChorusFruit = config.getBoolean("disable-chorus-fruit");
        disableWorld = config.getString("disable-world");
        disableCommand1 = config.getString("disable-command-1");
        disableCommand2 = config.getString("disable-command-2");
        disableCommand3 = config.getString("disable-command-3");
        disableCommand4 = config.getString("disable-command-4");
        disableCommand5 = config.getString("disable-command-5");
        disableCommand6 = config.getString("disable-command-6");
        disableCommand7 = config.getString("disable-command-7");
        disableCommand8 = config.getString("disable-command-8");
        disableCommand9 = config.getString("disable-command-9");
        disableCommand10 = config.getString("disable-command-10");
        errorMessage = config.getString("error-message");


        combat = new HashMap<>();
        location = new HashMap<>();
        combatHandler = new CombatHandler(this);

        Bukkit.getPluginManager().registerEvents(new EntityDamageByEntity(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerCommandPreprocess(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMove(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuit(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerRespawn(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerTeleport(this), this);

        init();

        getLogger().info("----------------------");
        getLogger().info(" ");
        getLogger().info("CombatLog+ Enabled!");
        getLogger().info(" ");
        getLogger().info("Author: Gizmo0o");
        getLogger().info(" ");
        getLogger().info("----------------------");

    }

    @Override
    public void onDisable() {

        getLogger().info("----------------------");
        getLogger().info(" ");
        getLogger().info("CombatLog+ Disabled!");
        getLogger().info(" ");
        getLogger().info("Author: Gizmo0o");
        getLogger().info(" ");
        getLogger().info("----------------------");

    }

    public void init() {
        Bukkit.getScheduler().runTaskTimer(this, ()-> combat.keySet().forEach((uuid -> combatHandler.update(uuid))), 0, 20);
    }

    public HashMap<UUID, Duration> getCombat() {
        return combat;
    }

    public CombatHandler getCombatHandler() {
        return combatHandler;
    }

    public HashMap<UUID, Location> getLocation() {
        return location;
    }

}
