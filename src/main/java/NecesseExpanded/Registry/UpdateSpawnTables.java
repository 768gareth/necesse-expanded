package NecesseExpanded.Registry;

import necesse.level.maps.biomes.Biome;
import necesse.level.maps.biomes.MobSpawnTable;
import necesse.level.maps.biomes.snow.SnowBiome;
import necesse.level.maps.biomes.swamp.SwampBiome;
import necesse.level.maps.biomes.temple.TempleBiome;

public class UpdateSpawnTables 
{
    public static void Update()
    {
        Biome.defaultCaveMobs.add(2, "zombie_miner");
        Biome.defaultSurfaceMobs.add(10, "wolf");

        // TODO: Fix this table eventually.
        SnowBiome.caveMobs = (new MobSpawnTable())
        .add(60, "frozen_dwarf")
        .add(25, "frostsentry")
        .add(10, "trapperzombie")
        .add(5, "frozen_dwarf_mage");

        SwampBiome.surfaceCritters.add(50, "crocodile");
        SwampBiome.caveCritters.add(50, "crocodile");

        SnowBiome.deepSnowCaveMobs.add(30, "ice_golem");

        TempleBiome.templeMobs.add(15, "ancient_warrior");

        // Biome.defaultSurfaceCritters.add(5, "honey_slime");
    }
}
