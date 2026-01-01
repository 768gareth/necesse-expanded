package NecesseExpanded.Patches.Gameplay;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.registries.BiomeRegistry;
import necesse.level.maps.Level;
import necesse.level.maps.biomes.Biome;
import necesse.level.maps.biomes.MobSpawnTable;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModMethodPatch(target = Biome.class, name = "getCritterSpawnTable", arguments = {Level.class})
public class CritterSpawnTablePatch 
{
    @OnMethodExit
    static void onExit(@This Biome Biome, @Advice.Argument(0) Level ThisLevel, @Advice.Return(readOnly = false) MobSpawnTable Table)
    {
        if (ThisLevel.baseBiome == BiomeRegistry.CRYSTAL_HOLLOW)
        {
            Table.add(20, "shard_caveling").add(20, "crystal_caveling");
        }
        else if (ThisLevel.baseBiome == BiomeRegistry.SLIME_CAVE)
        {
            Table.add(20, "shard_caveling").add(20, "slime_caveling");
        }
        else if (ThisLevel.isIncursionLevel)
        {
            Table.add(20, "shard_caveling");
        }
    }
}
