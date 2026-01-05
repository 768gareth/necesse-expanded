package NecesseExpanded.Registry;

import java.awt.Color;

import NecesseExpanded.Tiles.HauntedGrassTile;
import NecesseExpanded.Tiles.HauntedRockTile;
import necesse.engine.registries.TileRegistry;
import necesse.level.gameTile.CrystalGravelTile;
import necesse.level.gameTile.GameTile;
import necesse.level.gameTile.PathTiledTile;
import necesse.level.gameTile.SimpleFloorTile;

public class RegisterTiles 
{
    public static void Register()
    {
        TileRegistry.registerTile("fishian_tile", new SimpleFloorTile("fishian_tile", new Color(0, 52, 91)), 2f, true);
        TileRegistry.registerTile("fishian_path", (GameTile)new PathTiledTile("fishian_path", new Color(0, 61, 98)), 2.0F, true);
        TileRegistry.registerTile("life_quartz_gravel", new CrystalGravelTile("life_quartz_gravel", new Color(255, 0, 0)), 10.0F, true);
        TileRegistry.registerTile("frost_shard_gravel", new CrystalGravelTile("frost_shard_gravel", new Color(255, 0, 0)), 10.0F, true);
        TileRegistry.registerTile("haunted_grass_tile", (GameTile) new HauntedGrassTile(), 0.0F, true);
        TileRegistry.registerTile("haunted_rock_tile", (GameTile) new HauntedRockTile(), 0, true);
    }
}
