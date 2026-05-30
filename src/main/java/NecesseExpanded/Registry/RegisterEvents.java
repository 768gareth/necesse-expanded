package NecesseExpanded.Registry;

import NecesseExpanded.Events.Raids.*;
import NecesseExpanded.Events.Utils.BrimstoneExplosionEvent;
import necesse.engine.registries.LevelEventRegistry;

public class RegisterEvents 
{
    public static void Register()
    {
        System.out.println("[Necesse Expanded] Registering raid events...");

        LevelEventRegistry.registerEvent("spiderkin_raid", SpiderkinRaid.class);
        LevelEventRegistry.registerEvent("slimecave_raid", SlimeCaveRaid.class);
        LevelEventRegistry.registerEvent("graveyard_raid", GraveyardRaid.class);
        LevelEventRegistry.registerEvent("ancient_skeleton_raid", AncientSkeletonRaid.class);
        LevelEventRegistry.registerEvent("skeleton_raid", SkeletonRaid.class);
        LevelEventRegistry.registerEvent("pirate_raid", PirateRaid.class);
        LevelEventRegistry.registerEvent("ninja_raid", NinjaRaid.class);
        LevelEventRegistry.registerEvent("runebound_raid", RuneboundRaid.class);
        LevelEventRegistry.registerEvent("zombie_raid", ZombieRaid.class);

        System.out.println("[Necesse Expanded] Registering other events...");

        LevelEventRegistry.registerEvent("brimstone_explosion_event", BrimstoneExplosionEvent.class);
    }
}
