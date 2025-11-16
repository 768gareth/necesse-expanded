package NecesseExpanded.Registry;

import NecesseExpanded.World.WorldPresets.DesertHouseWorldPreset;
import NecesseExpanded.World.WorldPresets.DryadHouseWorldPreset;
import NecesseExpanded.World.WorldPresets.FishianDeepCaveEntranceWorldPreset;
import necesse.engine.registries.BiomeRegistry;
import necesse.engine.registries.WorldPresetRegistry;
import necesse.engine.util.LevelIdentifier;
import necesse.engine.world.worldPresets.CustomCrystalsWorldPreset;
import necesse.engine.world.worldPresets.WorldPreset;

public class RegisterWorldPresets 
{
    public static void Register()
    {
        WorldPresetRegistry.registerPreset("dryad_house", (WorldPreset) new DryadHouseWorldPreset());
        WorldPresetRegistry.registerPreset("fishian_biome_entrance", (WorldPreset) new FishianDeepCaveEntranceWorldPreset());
        WorldPresetRegistry.registerPreset("desert_pawnbroker_house", (WorldPreset) new DesertHouseWorldPreset());

        WorldPresetRegistry.registerPreset("snow_cave_frost_shards", new CustomCrystalsWorldPreset(BiomeRegistry.SNOW, LevelIdentifier.CAVE_IDENTIFIER, 0.006F, "frost_shard_gravel", "frostshard_cluster_small", "frostshard_cluster"));

        WorldPresetRegistry.registerPreset("deep_forest_life_quartz", new CustomCrystalsWorldPreset(BiomeRegistry.FOREST, LevelIdentifier.DEEP_CAVE_IDENTIFIER, 0.012F, "life_quartz_gravel", "life_quartz_cluster_small", "life_quartz_cluster"));
        WorldPresetRegistry.registerPreset("deep_snow_life_quartz", new CustomCrystalsWorldPreset(BiomeRegistry.SNOW, LevelIdentifier.DEEP_CAVE_IDENTIFIER, 0.012F, "life_quartz_gravel", "life_quartz_cluster_small", "life_quartz_cluster"));
        WorldPresetRegistry.registerPreset("deep_plains_life_quartz", new CustomCrystalsWorldPreset(BiomeRegistry.PLAINS, LevelIdentifier.DEEP_CAVE_IDENTIFIER, 0.012F, "life_quartz_gravel", "life_quartz_cluster_small", "life_quartz_cluster"));
        WorldPresetRegistry.registerPreset("deep_swamp_life_quartz", new CustomCrystalsWorldPreset(BiomeRegistry.SWAMP, LevelIdentifier.DEEP_CAVE_IDENTIFIER, 0.012F, "life_quartz_gravel", "life_quartz_cluster_small", "life_quartz_cluster"));
        WorldPresetRegistry.registerPreset("deep_desert_life_quartz", new CustomCrystalsWorldPreset(BiomeRegistry.DESERT, LevelIdentifier.DEEP_CAVE_IDENTIFIER, 0.012F, "life_quartz_gravel", "life_quartz_cluster_small", "life_quartz_cluster"));
    }
}
