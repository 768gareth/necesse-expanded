package NecesseExpanded.Patches.Gameplay;

import java.util.function.Predicate;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.registries.BiomeRegistry;
import necesse.level.maps.biomes.Biome;
import necesse.level.maps.biomes.FishingLootTable;
import necesse.level.maps.biomes.FishingSpot;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModMethodPatch(target = Biome.class, name = "getFishingLootTable", arguments = {FishingSpot.class})
public class FishingLootTablePatch 
{
    @OnMethodExit
    static void onExit(@This Biome Biome, @Advice.Argument(0) FishingSpot Spot, @Advice.Return(readOnly = false) FishingLootTable Loot)
    {
        if (Spot.tile.level.isIncursionLevel && Spot.tile.level.baseBiome == BiomeRegistry.CRYSTAL_HOLLOW)
        {
            Loot = (new FishingLootTable()).addWater(10, "pearlfish").addWater(20, "incursion_treasure_chest").addWater(40, "deep_treasure_chest");
        }
        else if (Spot.tile.level.isIncursionLevel && Spot.tile.level.baseBiome == BiomeRegistry.SLIME_CAVE)
        {
            Loot = (new FishingLootTable()).add(10, SlimeTileCheck(), "slimefish").add(20, SlimeTileCheck(), "incursion_treasure_chest").add(40, SlimeTileCheck(), "deep_treasure_chest");
        }
        else if (Spot.tile.level.isIncursionLevel)
        {
            Loot = (new FishingLootTable()).addWater(10, "incursion_treasure_chest").addWater(40, "deep_treasure_chest");
        }
        else if (Spot.tile.level.getIdentifier().isDeepCave() && Spot.tile.level.baseBiome == BiomeRegistry.SNOW)
        {
            Loot = (new FishingLootTable()).addWater(40, "deep_treasure_chest").addWater(20, "heartfish").addWater(20, "glacierfish");
        }
        else if (Spot.tile.level.getIdentifier().isDeepCave())
        {
            Loot = (new FishingLootTable()).addWater(40, "deep_treasure_chest").addWater(20, "heartfish");
        }
    }

    public static Predicate<FishingSpot> SlimeTileCheck()
    {
        return Target -> Target.tile.tile.getStringID().equals("liquidslimetile");
    }
}
