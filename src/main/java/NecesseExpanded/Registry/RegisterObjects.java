package NecesseExpanded.Registry;

import java.awt.Color;

import NecesseExpanded.Objects.CustomKegObject;
import NecesseExpanded.Objects.DryadSpiritLampObject;
import NecesseExpanded.Objects.FishianBrazierObject;
import NecesseExpanded.Objects.FishianDeepCaveEntranceObject;
import NecesseExpanded.Objects.HauntedGrassObject;
import NecesseExpanded.Objects.VenomTrapObject;
import necesse.engine.registries.ObjectRegistry;
import necesse.level.gameObject.CrystalClusterObject;
import necesse.level.gameObject.CrystalClusterSmallObject;
import necesse.level.gameObject.GameObject;
import necesse.level.gameObject.RandomVaseObject;
import necesse.level.gameObject.RockObject;
import necesse.level.gameObject.RockOreObject;
import necesse.level.gameObject.SingleRockObject;
import necesse.level.gameObject.SingleRockSmall;
import necesse.level.gameObject.StatueObject;
import necesse.level.gameObject.TableDecorationObject;
import necesse.level.gameObject.TreeObject;
import necesse.level.gameObject.WallObject;

public class RegisterObjects 
{
    public static void Register()
    {
        System.out.println("[Necesse Expanded] Registering new objects...");

        // Categories
        String[] crystalsCategory = new String[]{"objects", "landscaping", "crystals"};
        String[] genericRocksCategory = new String[]{"objects", "landscaping"};

        // Crafting Stations
        ObjectRegistry.registerObject("keg", new CustomKegObject(), 10, true);

        // Functional objects
        ObjectRegistry.registerObject("fishian_vases", new RandomVaseObject("fishian_vases"), -1.0f, true);
        ObjectRegistry.registerObject("dryad_spirit_lamp", new DryadSpiritLampObject(), -1.0f, true);

        // Decorative objects
        ObjectRegistry.registerObject("crystal_ball", (GameObject)new TableDecorationObject("crystal_ball", new Color(134, 223, 255), 16, 18, 0, 4), -1.0F, true);


        // Crystal mini-biomes
        CrystalClusterObject.registerCrystalCluster("frostshard_cluster", new Color(82, 150, 255), 240.0F, "frostshard", 3, 4, 3, 15f, true, crystalsCategory);
        CrystalClusterObject.registerCrystalCluster("frostshard_cluster_pure", new Color(82, 150, 255), 240.0F, "frostshard", 3, 4, 3, 15f, true, crystalsCategory);
        ObjectRegistry.registerObject("frostshard_cluster_small", new CrystalClusterSmallObject("frostshard_cluster_small", new Color(82, 150, 255), 240.0F, "frostshard", 1, 2, 1, crystalsCategory), 5f, true);

        CrystalClusterObject.registerCrystalCluster("life_quartz_cluster", new Color(255, 100, 100), 0F, "lifequartz", 3, 4, 3, 15f, true, crystalsCategory);
        CrystalClusterObject.registerCrystalCluster("life_quartz_cluster_pure", new Color(255, 100, 100), 0F, "lifequartz", 3, 4, 3, 15f, true, crystalsCategory);
        ObjectRegistry.registerObject("life_quartz_cluster_small", new CrystalClusterSmallObject("life_quartz_cluster_small", new Color(255, 100, 100), 0F, "lifequartz", 1, 2, 1, crystalsCategory), 5f, true);

        // Haunted Biome
        ObjectRegistry.registerObject("haunted_grass", (GameObject)new HauntedGrassObject(), 0.0F, false, false, true, new String[0]);
        ObjectRegistry.registerObject("haunted_tree", new TreeObject("haunted_tree", "haunted_log", "haunted_sapling", new Color(75, 65, 36), 32, 60, 120, "pineleaves"), 0.0F, false, false, true, new String[0]);

        RockObject HauntedRock;
        RockObject DeepHauntedRock;
        ObjectRegistry.registerObject("haunted_rock", HauntedRock = new RockObject("haunted_rock", new Color(50, 50, 150), "haunted_stone", genericRocksCategory), 0, true);
        ObjectRegistry.registerObject("deep_haunted_rock", DeepHauntedRock = new RockObject("deep_haunted_rock", new Color(50, 50, 150), "haunted_stone", genericRocksCategory), 0, true);
        ObjectRegistry.registerObject("haunted_rock_small", new SingleRockSmall(HauntedRock, "haunted_rock_small", new Color(70, 70, 152), genericRocksCategory), -1.0F, true);
        SingleRockObject.registerSurfaceRock(HauntedRock, "haunted_rock_large", new Color(49, 142, 184), -1.0F, true, genericRocksCategory);

        ObjectRegistry.registerObject("iron_ore_haunted_rock", new RockOreObject(HauntedRock, "oremask", "ironore", new Color(169, 128, 106), "ironore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("copper_ore_haunted_rock", new RockOreObject(HauntedRock, "oremask", "copperore", new Color(161, 83, 42), "copperore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("gold_ore_haunted_rock", new RockOreObject(HauntedRock, "oremask", "goldore", new Color(198, 145, 47), "goldore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("demonic_ore_haunted_rock", new RockOreObject(HauntedRock, "oremask", "demonic_ore", new Color(88, 0, 108), "demonic_ore", genericRocksCategory), -1.0F, true);
       
        ObjectRegistry.registerObject("iron_ore_deep_haunted_rock", new RockOreObject(DeepHauntedRock, "oremask", "ironore", new Color(169, 128, 106), "ironore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("copper_ore_deep_haunted_rock", new RockOreObject(DeepHauntedRock, "oremask", "copperore", new Color(161, 83, 42), "copperore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("gold_ore_deep_haunted_rock", new RockOreObject(DeepHauntedRock, "oremask", "goldore", new Color(198, 145, 47), "goldore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("tungsten_ore_deep_haunted_rock", new RockOreObject(DeepHauntedRock, "oremask", "tungstenore", new Color(40, 49, 57), "tungstenore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("life_quartz_deep_haunted_rock", new RockOreObject(DeepHauntedRock, "oremask", "lifequartzore", new Color(180, 50, 61), "lifequartz", 1, 1, 1, genericRocksCategory), -1.0F, true);

        // Tropical Biome
        RockObject TropicalRock;
        RockObject DeepTropicalRock;
        ObjectRegistry.registerObject("tropical_rock", TropicalRock = new RockObject("tropical_rock", new Color(122, 100, 0), "tropical_stone", genericRocksCategory), 0, true);
        ObjectRegistry.registerObject("deep_tropical_rock", DeepTropicalRock = new RockObject("deep_tropical_rock", new Color(60, 49, 0), "tropical_stone", genericRocksCategory), 0, true);

        ObjectRegistry.registerObject("iron_ore_tropical_rock", new RockOreObject(TropicalRock, "oremask", "ironore", new Color(169, 128, 106), "ironore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("copper_ore_tropical_rock", new RockOreObject(TropicalRock, "oremask", "copperore", new Color(161, 83, 42), "copperore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("gold_ore_tropical_rock", new RockOreObject(TropicalRock, "oremask", "goldore", new Color(198, 145, 47), "goldore", genericRocksCategory), -1.0F, true);

        ObjectRegistry.registerObject("iron_ore_deep_tropical_rock", new RockOreObject(DeepTropicalRock, "oremask", "ironore", new Color(169, 128, 106), "ironore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("copper_ore_deep_tropical_rock", new RockOreObject(DeepTropicalRock, "oremask", "copperore", new Color(161, 83, 42), "copperore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("gold_ore_deep_tropical_rock", new RockOreObject(DeepTropicalRock, "oremask", "goldore", new Color(198, 145, 47), "goldore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("tungsten_ore_deep_tropical_rock", new RockOreObject(DeepTropicalRock, "oremask", "tungstenore", new Color(40, 49, 57), "tungstenore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("life_quartz_deep_tropical_rock", new RockOreObject(DeepTropicalRock, "oremask", "lifequartzore", new Color(180, 50, 61), "lifequartz", 1, 1, 1, genericRocksCategory), -1.0F, true);
        

        // Fishian Biome
        int[] FishWallIDs = WallObject.registerWallObjects("fishian_", "fishian_wall", 3.0F, new Color(0, 62, 81), 0.5F, 1.0F);
        WallObject FishWall = (WallObject)ObjectRegistry.getObject(FishWallIDs[0]);
        ObjectRegistry.registerObject("fishian_venom_trap", new VenomTrapObject(FishWall), 50.0f, true);
        ObjectRegistry.registerObject("fishian_brazier", new FishianBrazierObject(), 10f, true);
        ObjectRegistry.registerObject("fishian_entrance", new FishianDeepCaveEntranceObject(), 0, false);
        ObjectRegistry.registerObject("fishian_statue", (GameObject)new StatueObject("fishian_statue"), -1.0F, true);
    }
}
