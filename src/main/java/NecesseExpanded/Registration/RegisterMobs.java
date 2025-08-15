package NecesseExpanded.Registration;

import NecesseExpanded.Raids.DuskDawnKnights.Tier3.KnightOfDawn;
import NecesseExpanded.Raids.DuskDawnKnights.Tier3.KnightOfDusk;
import NecesseExpanded.Raids.NecromancerRaid.Tier1.NecromancerTier1;
import NecesseExpanded.Raids.NecromancerRaid.Tier1.ZombieRaider;

import NecesseExpanded.Raids.NecromancerRaid.Tier2.NecromancerTier2;
import NecesseExpanded.Raids.NecromancerRaid.Tier2.SkeletonRaider;

import NecesseExpanded.Raids.NecromancerRaid.Tier3.AncientSkeletonRaider;
import NecesseExpanded.Raids.NecromancerRaid.Tier3.NecromancerTier3;
import NecesseExpanded.Other.SecretBoss;
import NecesseExpanded.Raids.RuneboundRaid.Other.RaiderTrapper;

import NecesseExpanded.Raids.RuneboundRaid.Tier1.RaiderBerserkerTier1;
import NecesseExpanded.Raids.RuneboundRaid.Tier1.RaiderMagicTier1;
import NecesseExpanded.Raids.RuneboundRaid.Tier1.RaiderMeleeTier1;
import NecesseExpanded.Raids.RuneboundRaid.Tier1.RaiderRangedTier1;
import NecesseExpanded.Raids.RuneboundRaid.Tier1.RaiderSummonerTier1;

import NecesseExpanded.Raids.RuneboundRaid.Tier2.RaiderBerserkerTier2;
import NecesseExpanded.Raids.RuneboundRaid.Tier2.RaiderMagicTier2;
import NecesseExpanded.Raids.RuneboundRaid.Tier2.RaiderMeleeTier2;
import NecesseExpanded.Raids.RuneboundRaid.Tier2.RaiderRangedTier2;
import NecesseExpanded.Raids.RuneboundRaid.Tier2.RaiderSummonerTier2;

import NecesseExpanded.Raids.RuneboundRaid.Tier3.RaiderBerserkerTier3;
import NecesseExpanded.Raids.RuneboundRaid.Tier3.RaiderMagicTier3;
import NecesseExpanded.Raids.RuneboundRaid.Tier3.RaiderMeleeTier3;
import NecesseExpanded.Raids.RuneboundRaid.Tier3.RaiderRangedTier3;
import NecesseExpanded.Raids.RuneboundRaid.Tier3.RaiderSummonerTier3;

import necesse.engine.registries.MobRegistry;

public class RegisterMobs 
{
    public static void Register()
    {
        if (NecesseExpanded.Main.Options.isNewRaidSystemEnabled)
        {
            System.out.println("[NECESSE EXPANDED] Registering custom raiders...");

            // The Runebound Raiders.
            MobRegistry.registerMob("raider_magic_tier1", RaiderMagicTier1.class, true);
            MobRegistry.registerMob("raider_melee_tier1", RaiderMeleeTier1.class, true);
            MobRegistry.registerMob("raider_ranged_tier1", RaiderRangedTier1.class, true);
            MobRegistry.registerMob("raider_berserker_tier1", RaiderBerserkerTier1.class, true);
    
            MobRegistry.registerMob("raider_magic_tier2", RaiderMagicTier2.class, true);
            MobRegistry.registerMob("raider_melee_tier2", RaiderMeleeTier2.class, true);
            MobRegistry.registerMob("raider_ranged_tier2", RaiderRangedTier2.class, true);
            MobRegistry.registerMob("raider_berserker_tier2", RaiderBerserkerTier2.class, true);
    
            MobRegistry.registerMob("raider_magic_tier3", RaiderMagicTier3.class, true);
            MobRegistry.registerMob("raider_melee_tier3", RaiderMeleeTier3.class, true);
            MobRegistry.registerMob("raider_ranged_tier3", RaiderRangedTier3.class, true);
            MobRegistry.registerMob("raider_berserker_tier3", RaiderBerserkerTier3.class, true);
    
            // Additional types of Runebound Raiders.
            MobRegistry.registerMob("raider_trapper", RaiderTrapper.class, true);
    
            // Runebound mini-bosses.
            MobRegistry.registerMob("raider_summoner_tier1", RaiderSummonerTier1.class, true);
            MobRegistry.registerMob("raider_summoner_tier2", RaiderSummonerTier2.class, true);
            MobRegistry.registerMob("raider_summoner_tier3", RaiderSummonerTier3.class, true);
    
            // The Necromancers
            MobRegistry.registerMob("necromancer_tier1", NecromancerTier1.class, true);
            MobRegistry.registerMob("necromancer_tier2", NecromancerTier2.class, true);
            MobRegistry.registerMob("necromancer_tier3", NecromancerTier3.class, true);
    
            // The Necromancers' Summons
            MobRegistry.registerMob("zombie_raider", ZombieRaider.class, true);
            MobRegistry.registerMob("skeleton_raider", SkeletonRaider.class, true);
            MobRegistry.registerMob("ancient_skeleton_raider", AncientSkeletonRaider.class, true);

            // Knights of Dusk and Dawn
            MobRegistry.registerMob("dawn_knight", KnightOfDawn.class, true);
            MobRegistry.registerMob("dusk_knight", KnightOfDusk.class, true);
        }
        // Secret boss!
        MobRegistry.registerMob("secret_boss", SecretBoss.class, true);
    }
}
