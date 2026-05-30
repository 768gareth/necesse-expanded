package NecesseExpanded.Registry;

import NecesseExpanded.Mobs.Friendly.Critters.CrystalCaveling;
import NecesseExpanded.Mobs.Friendly.Critters.ShardCaveling;
import NecesseExpanded.Mobs.Friendly.Critters.SlimeCaveling;
// import NecesseExpanded.Mobs.Friendly.Husbandry.HoneySlimeHusbandryMob;
import NecesseExpanded.Mobs.Hostile.Desert.AncientWarrior;
import NecesseExpanded.Mobs.Hostile.Forest.ZombieMiner;
import NecesseExpanded.Mobs.Hostile.HauntedForest.HauntedZombie;
import NecesseExpanded.Mobs.Hostile.Jungle.ZombiePirate;
import NecesseExpanded.Mobs.Hostile.Jungle.ZombiePirateGunner;
import NecesseExpanded.Mobs.Hostile.Snow.FrozenDwarf;
import NecesseExpanded.Mobs.Hostile.Snow.FrozenDwarfMage;
import NecesseExpanded.Mobs.Hostile.Snow.IceGolemMob;
import NecesseExpanded.Mobs.Friendly.Summons.NecromancerMinion;

import necesse.engine.registries.MobRegistry;

// preInit() registration of mobs for inclusion in journal. Must be used to ensure mobs appear in journal.
public class PreRegisterMobs 
{
    public static void Register()
    {
        System.out.println("[Necesse Expanded] Pre-registering mobs...");

        // Forest
        MobRegistry.registerMob("zombie_miner", ZombieMiner.class, true);

        // Snow
        MobRegistry.registerMob("frozen_dwarf", FrozenDwarf.class, true);
        MobRegistry.registerMob("frozen_dwarf_mage", FrozenDwarfMage.class, true);
        MobRegistry.registerMob("ice_golem", IceGolemMob.class, true);

        // Dungeon

        // Plains

        // Swamp

        // Desert
        MobRegistry.registerMob("ancient_warrior", AncientWarrior.class, true);

        // Haunted Forest
        MobRegistry.registerMob("haunted_zombie", HauntedZombie.class, true);

        // Tropical
        MobRegistry.registerMob("zombie_pirate", ZombiePirate.class, true);
        MobRegistry.registerMob("zombie_pirate_gunner", ZombiePirateGunner.class, true);

        // Summons
        MobRegistry.registerMob("necromancer_minion", NecromancerMinion.class, false);

        // Critters
        MobRegistry.registerMob("crystal_caveling", CrystalCaveling.class, true);
        MobRegistry.registerMob("shard_caveling", ShardCaveling.class, true);
        MobRegistry.registerMob("slime_caveling", SlimeCaveling.class, true);

        // Slimes
        // MobRegistry.registerMob("honey_slime", HoneySlimeHusbandryMob.class, true);
    }
}
