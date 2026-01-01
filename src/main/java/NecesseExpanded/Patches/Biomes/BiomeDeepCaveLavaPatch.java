package NecesseExpanded.Patches.Biomes;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.registries.TileRegistry;
import necesse.level.maps.biomes.Biome;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModMethodPatch(arguments = {}, name = "getGenerationDeepCaveLavaTileID", target = Biome.class)
public class BiomeDeepCaveLavaPatch 
{
    @OnMethodExit
    public static void onExit(@This Biome This, @Advice.Return(readOnly = false) int Tile) 
    {
        if (This.getStringID() == "plains")
        {
            Tile = TileRegistry.spiritWaterID;
        }
        else if (This.getStringID() == "desert")
        {
            Tile = TileRegistry.quicksandID;
        }
        else if (This.getStringID() == "swamp")
        {
            Tile = TileRegistry.waterID;
        }
    }
}
