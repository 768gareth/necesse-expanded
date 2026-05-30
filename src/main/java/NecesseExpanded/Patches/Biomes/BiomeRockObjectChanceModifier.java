package NecesseExpanded.Patches.Biomes;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.level.maps.biomes.Biome;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.Advice.OnMethodExit;

@ModMethodPatch(arguments = {}, name = "getGenerationCaveRockObjectChance", target = Biome.class)
public class BiomeRockObjectChanceModifier 
{
    @OnMethodExit
    public static void onExit(@Advice.Return(readOnly = false) float Chance) 
    {
        Chance = 0.31f;
    }
}
