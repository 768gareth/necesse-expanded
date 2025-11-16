package NecesseExpanded.Registry;

import necesse.engine.registries.TileRegistry;
import necesse.level.gameTile.CrystalGravelTile;
import necesse.level.gameTile.GameTile;
import necesse.level.gameTile.SimpleFloorTile;
import java.awt.Color;

import NecesseExpanded.Tiles.HauntedGrassTile;

public class RegisterTiles 
{
    public static void Register()
    {
        TileRegistry.registerTile("fishian_tile", new SimpleFloorTile("fishian_tile", new Color(0, 52, 91)), 2f, true);
        TileRegistry.registerTile("life_quartz_gravel", new CrystalGravelTile("life_quartz_gravel", new Color(255, 0, 0)), 10.0F, true);
        TileRegistry.registerTile("frost_shard_gravel", new CrystalGravelTile("frost_shard_gravel", new Color(255, 0, 0)), 10.0F, true);
        TileRegistry.registerTile("haunted_grass_tile", (GameTile)new HauntedGrassTile(), 0.0F, false, false, true, new String[0]);
    }
}
