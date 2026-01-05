package NecesseExpanded.Registry;

import NecesseExpanded.World.Biomes.FishianBiome;
import NecesseExpanded.World.Biomes.HauntedBiome;
import NecesseExpanded.World.Biomes.TropicalBiome;
import necesse.engine.registries.BiomeRegistry;

public class RegisterBiomes 
{
    public static void Register()
    {
        System.out.println("[Necesse Expanded] Registering new biomes...");

        BiomeRegistry.registerBiome("fishian_biome", new FishianBiome(), true);
        BiomeRegistry.registerBiome("tropical_biome", new TropicalBiome().setGenerationWeight(0.75f), true);
        BiomeRegistry.registerBiome("haunted_biome", new HauntedBiome().setGenerationWeight(0.75f), true);
    }
}
