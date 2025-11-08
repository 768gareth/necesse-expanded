package NecesseExpanded.Registry;

import necesse.engine.util.GameRandom;
import necesse.entity.mobs.hostile.*;
import necesse.entity.mobs.hostile.bosses.*;
import necesse.entity.mobs.hostile.pirates.PirateMob;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.LootTablePresets;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.ChanceLootItemList;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.presets.*;
import necesse.level.maps.biomes.Biome;
import necesse.level.maps.biomes.swamp.SwampBiome;
import necesse.level.maps.incursion.GraveyardIncursionBiome;

public class UpdateLootTables 
{
    public static void Update() 
    {
        System.out.println("[Necesse Expanded] Configuring fishing loot...");

        SwampBiome.swampSurfaceFish.addWater(50, "swamp_eel");
        Biome.defaultSurfaceFish.addSaltWater(30, "saltwater_shark").addSaltWater(20, "seaweed").addWater(10, "surface_treasure_chest").addSaltWater(1, "pearl_oyster");
        Biome.defaultCaveFish.addWater(15, "cave_treasure_chest").addWater(20, "demonfish").addWater(20, "seaweed").addWater(20, "oyster").addWater(1, "pearl_oyster");

        if (NecesseExpanded.Main.SettingsGetter.getBoolean("starter_kit_enabled"))
        {
            System.out.println("[Necesse Expanded] Updating starter chest loot...");
            LootTablePresets.startChest = new LootTable
            (
                new LootItemInterface[] 
                {
                    (LootItemInterface) new LootItem("settlementflag"), 
                    (LootItemInterface) new LootItem("coin", 500),
                    (LootItemInterface) new LootItem("sprucelog", 250), 
                    (LootItemInterface) new LootItem("stone", 150),
                    (LootItemInterface) new LootItem("torch", 25), 
                    (LootItemInterface) new LootItem("farmland", 20),
                    (LootItemInterface) new LootItem("wheatseed", 20), 
                    (LootItemInterface) new LootItem("bread", 10),
                    (LootItemInterface) new LootItem("ironbomb", 10), 
                    (LootItemInterface) new LootItem("storagebox", 3),
                    (LootItemInterface) new LootItem("sprucebed", 3), 
                    (LootItemInterface) new LootItem("grainmill"),
                    (LootItemInterface) new LootItem("ironanvil"), 
                    (LootItemInterface) new LootItem("forge")
                }
            );
        }
        
        System.out.println("[Necesse Expanded] Updating mob/treasure loot tables...");
        
        // Forest
        VampireMob.lootTable.items.add(new ChanceLootItemList(0.05f, CaveCryptLootTable.uniqueItems));

        // Snow
        SnowWolfMob.lootTable.items.add(new LootItem("leather"));
        SnowWolfMob.lootTable.items.add(new LootItem("rawmutton"));

        // Dungeon
        VoidApprentice.lootTable.items.add(new ChanceLootItemList(0.05f, DungeonChestLootTable.mainItems));

        // Swamp
        SwampSlimeMob.lootTable.items.add(new ChanceLootItem(0.25f, "slime", GameRandom.globalRandom.getIntBetween(1, 2)));

        // Desert
        JackalMob.lootTable.items.add(new LootItem("leather"));
        JackalMob.lootTable.items.add(new LootItem("rawmutton"));

        // Pirates
        PirateMob.lootTable.items.add(new ChanceLootItem(0.25f, "rum"));

        // Deep swamp
        GiantSwampSlimeMob.lootTable.items.add(new LootItem("slime", GameRandom.globalRandom.getIntBetween(2, 4)));

        // Deep desert
        SandwormHead.lootTable.items.add(new ChanceLootItem(0.05F, "sandworm_tooth"));

        // Incursions
        GraveyardIncursionBiome.graveyardMobDrops.add(new ChanceLootItem(0.01F, "blood_crystal"));
        SlimeWormHead.lootTable.items.add(new LootItem("slime", GameRandom.globalRandom.getIntBetween(4, 8)));

        // Bosses
        CrystalDragonHead.lootTable.items.add(LootItem.between("omnicrystal", 12, 18).splitItems(4));
        CrystalDragonHead.lootTable.items.add(LootItem.between("pearlescentdiamond", 14, 18).splitItems(4));
        CrystalDragonHead.lootTable.items.add(LootItem.between("amethyst", 8, 12).splitItems(4));
        CrystalDragonHead.lootTable.items.add(LootItem.between("sapphire", 8, 12).splitItems(4));
        CrystalDragonHead.lootTable.items.add(LootItem.between("emerald", 8, 12).splitItems(4));
        CrystalDragonHead.lootTable.items.add(LootItem.between("ruby", 8, 12).splitItems(4));

        MoonlightDancerMob.uniqueDrops.items.clear();
        MoonlightDancerMob.uniqueDrops.items.add(new LootItem("lunar_essence", GameRandom.globalRandom.getIntBetween(20, 30)));

        SunlightChampionMob.uniqueDrops.items.clear();
        SunlightChampionMob.uniqueDrops.items.add(new LootItem("solar_essence", GameRandom.globalRandom.getIntBetween(20, 30)));

        ReaperMob.uniqueDrops.items.add(new LootItem("shadow_crystal"));

        // Chest loot tables
        // Forest
        CaveChestLootTable.basicMainItems.items.add(new LootItem("sparkler"));
        CaveChestLootTable.basicMainItems.items.add(new LootItem("leather_scabbard"));
        DeepCaveChestLootTable.basicMainItems.items.add(new LootItem("inferno"));
        DeepCaveChestLootTable.basicMainItems.items.add(new LootItem("juggernaut_axe"));

        // Snow
        CaveChestLootTable.snowMainItems.items.add(new LootItem("frostbolt"));
        DeepCaveChestLootTable.snowMainItems.items.add(new LootItem("winterwrath"));

        // Dungeon
        DungeonChestLootTable.mainItems.items.add(new LootItem("void_amulet"));

        // Swamp
        CaveChestLootTable.swampMainItems.items.add(new LootItem("berserker_ring"));
        DeepCaveChestLootTable.swampMainItems.items.add(new LootItem("murasama"));
        FishianBarrelLootTable.mainItems.items.add(new LootItem("forgotten_relic"));
        
        // Desert
        CaveChestLootTable.desertMainItems.items.add(new LootItem("lensmaker_glasses"));
        CaveChestLootTable.desertMainItems.items.add(new LootItem("warrior_ring"));
        CaveChestLootTable.desertMainItems.items.add(new LootItem("ancient_tablet"));
        CaveChestLootTable.desertMainItems.items.add(new LootItem("summoner_grimoire"));

        // Temple
        TempleChestLootTable.mainItems.items.add(new LootItem("brimstone"));
        
        // Pirates
        PirateDisplayStandLootTable.items.items.add(new LootItem("lucky_ring"));
        PirateDisplayStandLootTable.items.items.add(new LootItem("foolsgambit"));
        PirateChestLootTable.mainItems.items.add(new LootItem("lucky_ring"));
        PirateChestLootTable.mainItems.items.add(new LootItem("foolsgambit"));

        // Non-specific
        
    }
}
