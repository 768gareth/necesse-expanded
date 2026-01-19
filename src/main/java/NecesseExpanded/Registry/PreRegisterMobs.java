package NecesseExpanded.Registry;

import NecesseExpanded.Mobs.Friendly.Critters.CrystalCaveling;
import NecesseExpanded.Mobs.Friendly.Critters.ShardCaveling;
import NecesseExpanded.Mobs.Friendly.Critters.SlimeCaveling;
import NecesseExpanded.Mobs.Friendly.Summons.NecromancerMinion;
import NecesseExpanded.Mobs.Hostile.Desert.AncientWarrior;
import NecesseExpanded.Mobs.Hostile.Forest.ZombieMinerMob;
import NecesseExpanded.Mobs.Hostile.Haunted.HauntedZombieMob;
import NecesseExpanded.Mobs.Hostile.Misc.WolfMob;
import NecesseExpanded.Mobs.Hostile.Snow.CustomFrozenDwarfMob;
import NecesseExpanded.Mobs.Hostile.Snow.FrozenDwarfMageMob;
import NecesseExpanded.Mobs.Hostile.Snow.IceGolemMob;
import NecesseExpanded.Mobs.Hostile.Tropical.ZombiePirateGunnerMob;
import NecesseExpanded.Mobs.Hostile.Tropical.ZombiePirateMob;
import necesse.engine.registries.MobRegistry;

// preInit() registration of mobs for inclusion in journal. Must be used to ensure mobs appear in journal.
public class PreRegisterMobs 
{
    public static void Register()
    {
        System.out.println("[Necesse Expanded] Pre-registering new mobs for vanilla biomes...");

        // Forest
        MobRegistry.registerMob("zombie_miner", ZombieMinerMob.class, true);
        MobRegistry.registerMob("wolf", WolfMob.class, true);

        // Snow
        MobRegistry.registerMob("frozen_dwarf", CustomFrozenDwarfMob.class, true);
        MobRegistry.registerMob("frozen_dwarf_mage", FrozenDwarfMageMob.class, true);
        MobRegistry.registerMob("ice_golem", IceGolemMob.class, true);

        // Dungeon

        // Plains

        // Swamp

        // Desert
        MobRegistry.registerMob("ancient_warrior", AncientWarrior.class, true);

        // Haunted Forest
        MobRegistry.registerMob("haunted_zombie", HauntedZombieMob.class, true);

        // Tropical
        MobRegistry.registerMob("zombie_pirate", ZombiePirateMob.class, true);
        MobRegistry.registerMob("zombie_pirate_gunner", ZombiePirateGunnerMob.class, true);

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
