package NecesseExpanded.Registry;

import java.awt.Color;

import NecesseExpanded.Objects.*;
import necesse.engine.registries.ObjectRegistry;
import necesse.level.gameObject.CrystalClusterObject;
import necesse.level.gameObject.CrystalClusterSmallObject;
import necesse.level.gameObject.GameObject;
import necesse.level.gameObject.RockObject;
import necesse.level.gameObject.RockOreObject;
import necesse.level.gameObject.WallObject;

public class RegisterObjects 
{
    public static void Register()
    {
        System.out.println("[Necesse Expanded] Registering new objects...");
        ObjectRegistry.registerObject("keg", new CustomKegObject(), 10, true);

        String[] crystalsCategory = new String[]{"objects", "landscaping", "crystals"};
        String[] genericRocksCategory = new String[]{"objects", "landscaping"};

        CrystalClusterObject.registerCrystalCluster("frostshard_cluster", new Color(82, 150, 255), 240.0F, "frostshard", 3, 4, 3, 15f, true, crystalsCategory);
        CrystalClusterObject.registerCrystalCluster("frostshard_cluster_pure", new Color(82, 150, 255), 240.0F, "frostshard", 3, 4, 3, 15f, true, crystalsCategory);
        ObjectRegistry.registerObject("frostshard_cluster_small", new CrystalClusterSmallObject("frostshard_cluster_small", new Color(82, 150, 255), 240.0F, "frostshard", 1, 2, 1, crystalsCategory), 5f, true);

        CrystalClusterObject.registerCrystalCluster("life_quartz_cluster", new Color(255, 100, 100), 0F, "lifequartz", 3, 4, 3, 15f, true, crystalsCategory);
        CrystalClusterObject.registerCrystalCluster("life_quartz_cluster_pure", new Color(255, 100, 100), 0F, "lifequartz", 3, 4, 3, 15f, true, crystalsCategory);
        ObjectRegistry.registerObject("life_quartz_cluster_small", new CrystalClusterSmallObject("life_quartz_cluster_small", new Color(255, 100, 100), 0F, "lifequartz", 1, 2, 1, crystalsCategory), 5f, true);

        int[] FishWallIDs = WallObject.registerWallObjects("fishian_", "fishian_wall", 3.0F, new Color(0, 62, 81), 0.5F, 1.0F);
        WallObject FishWall = (WallObject)ObjectRegistry.getObject(FishWallIDs[0]);
        ObjectRegistry.registerObject("fishian_venom_trap", new VenomTrapObject(FishWall), 50.0f, true);
        ObjectRegistry.registerObject("fishian_brazier", new FishianBrazierObject(), 10f, true);
        ObjectRegistry.registerObject("fishian_entrance", new FishianDeepCaveEntranceObject(), 0, false);

        ObjectRegistry.registerObject("haunted_grass", (GameObject)new HauntedGrassObject(), -1.0F, false);

        ObjectRegistry.registerObject("haunted_rock", new RockObject("haunted_rock", new Color(50, 50, 150), "haunted_stone", genericRocksCategory), 0, false);
        ObjectRegistry.registerObject("deep_haunted_rock", new RockObject("deep_haunted_rock", new Color(50, 50, 150), "haunted_stone", genericRocksCategory), 0, false);

        ObjectRegistry.registerObject("iron_ore_haunted_rock", new RockOreObject(new RockObject("haunted_rock", new Color(50, 50, 150), "haunted_stone", genericRocksCategory), "oremask", "ironore", new Color(169, 128, 106), "ironore", genericRocksCategory), -1.0F, false);
        ObjectRegistry.registerObject("copper_ore_haunted_rock", new RockOreObject(new RockObject("haunted_rock", new Color(50, 50, 150), "haunted_stone", genericRocksCategory), "oremask", "copperore", new Color(161, 83, 42), "copperore", genericRocksCategory), -1.0F, false);
        ObjectRegistry.registerObject("gold_ore_haunted_rock", new RockOreObject(new RockObject("haunted_rock", new Color(50, 50, 150), "haunted_stone", genericRocksCategory), "oremask", "goldore", new Color(198, 145, 47), "goldore", genericRocksCategory), -1.0F, false);
       
        ObjectRegistry.registerObject("iron_ore_deep_haunted_rock", new RockOreObject(new RockObject("deep_haunted_rock", new Color(50, 50, 150), "haunted_stone", genericRocksCategory), "oremask", "ironore", new Color(169, 128, 106), "ironore", genericRocksCategory), -1.0F, false);
        ObjectRegistry.registerObject("copper_ore_deep_haunted_rock", new RockOreObject(new RockObject("deep_haunted_rock", new Color(50, 50, 150), "haunted_stone", genericRocksCategory), "oremask", "copperore", new Color(161, 83, 42), "copperore", genericRocksCategory), -1.0F, false);
        ObjectRegistry.registerObject("gold_ore_deep_haunted_rock", new RockOreObject(new RockObject("deep_haunted_rock", new Color(50, 50, 150), "haunted_stone", genericRocksCategory), "oremask", "goldore", new Color(198, 145, 47), "goldore", genericRocksCategory), -1.0F, false);
        ObjectRegistry.registerObject("tungsten_ore_deep_haunted_rock", new RockOreObject(new RockObject("deep_haunted_rock", new Color(50, 50, 150), "haunted_stone", genericRocksCategory), "oremask", "tungstenore", new Color(40, 49, 57), "tungstenore", genericRocksCategory), -1.0F, false);
        ObjectRegistry.registerObject("life_quartz_deep_haunted_rock", new RockOreObject(new RockObject("deep_haunted_rock", new Color(50, 50, 150), "haunted_stone", genericRocksCategory), "oremask", "lifequartzore", new Color(180, 50, 61), "lifequartz", 1, 1, 1, genericRocksCategory), -1.0F, false);
    }
}
