package NecesseExpanded.Registry;

import NecesseExpanded.Mobs.Friendly.Human.FriendlyDryadMob;
import NecesseExpanded.Mobs.Hostile.Raiders.StabbyBushRaider;
import NecesseExpanded.Mobs.Hostile.Raiders.AncientSkeletonRaiders.*;
import NecesseExpanded.Mobs.Hostile.Raiders.GraveyardRaiders.*;
import NecesseExpanded.Mobs.Hostile.Raiders.NinjaRaid.NinjaRaider;
import NecesseExpanded.Mobs.Hostile.Raiders.PirateRaiders.*;
import NecesseExpanded.Mobs.Hostile.Raiders.RuneboundRaiders.*;
import NecesseExpanded.Mobs.Hostile.Raiders.SkeletonRaiders.*;
import NecesseExpanded.Mobs.Hostile.Raiders.SlimeRaiders.*;
import NecesseExpanded.Mobs.Hostile.Raiders.SpiderkinRaiders.*;
import NecesseExpanded.Mobs.Hostile.Raiders.ZombieRaiders.*;
import necesse.engine.registries.MobRegistry;

// Registering raiders and other mobs that don't require a journal entry.
public class RegisterMobs 
{
    public static void Register()
    {
        System.out.println("[Necesse Expanded] Registering new human mobs...");
        
        MobRegistry.registerMob("friendly_dryad", FriendlyDryadMob.class, true);

        System.out.println("[Necesse Expanded] Registering new raiders...");

        // Misc raiders
        MobRegistry.registerMob("stabby_bush_raider", StabbyBushRaider.class, true);

        // Zombie raiders
        MobRegistry.registerMob("zombie_raider", ZombieRaider.class, true);
        MobRegistry.registerMob("zombie_archer_raider", ZombieArcherRaider.class, true);

        // Runebound raiders
        MobRegistry.registerMob("runebound_boss", RuneboundBoss.class, true);
        MobRegistry.registerMob("runebound_berserker", RuneboundBerserker.class, true);
        MobRegistry.registerMob("runebound_trapper", RuneboundTrapper.class, true);
        MobRegistry.registerMob("runebound_warrior", RuneboundWarrior.class, true);

        // Pirate raiders
        MobRegistry.registerMob("pirate_brawler", PirateBrawlerRaider.class, true);
        MobRegistry.registerMob("pirate_gunner", PirateGunnerRaider.class, true);
        MobRegistry.registerMob("pirate_sharpshooter", PirateSharpshooterRaider.class, true);
        MobRegistry.registerMob("pirate_grenadier", PirateGrenadierRaider.class, true);

        // Skeleton raiders
        MobRegistry.registerMob("skeleton_raider", SkeletonRaider.class, true);
        MobRegistry.registerMob("skeleton_summoner_raider", SkeletonSummonerRaider.class, true);
        MobRegistry.registerMob("skeleton_miner_raider", SkeletonMinerRaider.class, true);

        // Ninja raider
        MobRegistry.registerMob("ninja_raider", NinjaRaider.class, true);

        // Ancient skeleton raiders
        MobRegistry.registerMob("ancient_skeleton_raider", AncientSkeletonRaider.class, true);
        MobRegistry.registerMob("ancient_skeleton_summoner_raider", AncientSkeletonSummonerRaider.class, true);
        MobRegistry.registerMob("ancient_skeleton_miner_raider", AncientSkeletonMinerRaider.class, true);

        // Spiderkin raiders
        MobRegistry.registerMob("spiderkin_warrior_raider", SpiderkinWarriorRaider.class, true);
        MobRegistry.registerMob("spiderkin_mage_raider", SpiderkinMageRaider.class, true);
        MobRegistry.registerMob("spiderkin_summoner_raider", SpiderkinSummonerRaider.class, true);
        MobRegistry.registerMob("spiderkin_archer_raider", SpiderkinArcherRaider.class, true);
        MobRegistry.registerMob("spiderkin_healer_raider", SpiderkinHealerRaider.class, true);

        // Slime raiders
        MobRegistry.registerMob("mage_slime_raider", SlimeMageRaider.class, true);
        MobRegistry.registerMob("warrior_slime_raider", SlimeWarriorRaider.class, true);

        // Graveyard raiders
        MobRegistry.registerMob("vampire_raider", VampireRaider.class, true);
    }
}
