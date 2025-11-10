package NecesseExpanded.Registry;

import NecesseExpanded.World.Biomes.FishianDeepCaveBiome;
import NecesseExpanded.World.Biomes.TropicalBiome;
import necesse.engine.registries.BiomeRegistry;

public class RegisterBiomes 
{
    public static void Register()
    {
        System.out.println("[Necesse Expanded] Registering new biomes...");

        BiomeRegistry.registerBiome("fishian_cave", new FishianDeepCaveBiome(), true);
        BiomeRegistry.registerBiome("tropical_biome", new TropicalBiome().setGenerationWeight(0.75f), true);
    }
}
