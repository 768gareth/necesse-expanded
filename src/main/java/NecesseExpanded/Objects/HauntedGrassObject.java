package NecesseExpanded.Objects;

import java.awt.Color;

import necesse.engine.registries.ObjectLayerRegistry;
import necesse.engine.registries.TileRegistry;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.level.gameObject.GameObject;
import necesse.level.gameObject.GrassObject;
import necesse.level.maps.Level;

public class HauntedGrassObject extends GrassObject 
{
    public HauntedGrassObject() 
    {
      super("haunted_grass", 2);
      this.mapColor = new Color(30, 100, 25);
    }
    
    public LootTable getLootTable(Level level, int layerID, int tileX, int tileY) {
    if (level.objectLayer.isPlayerPlaced(tileX, tileY))
      return super.getLootTable(level, layerID, tileX, tileY); 
    float baitChance = 35.0F;
    if (level.weatherLayer.isRaining())
      baitChance = 15.0F; 
    String seedItem = "haunted_grass_seed";
    return new LootTable(new LootItemInterface[] { (LootItemInterface)new ChanceLootItem(1.0F / baitChance, "wormbait"), (LootItemInterface)new ChanceLootItem(0.01F, seedItem) });
  }

    public LootTable getLootTable(Level level, int tileX, int tileY) {
    return new LootTable(new LootItemInterface[] { (LootItemInterface)new ChanceLootItem(0.04F, "haunted_grass_seed") });
  }
    
    public boolean canPlaceOn(Level level, int layerID, int x, int y, GameObject other) {
      return (other.getID() == 0 || !other.getValidObjectLayers().contains(Integer.valueOf(ObjectLayerRegistry.TILE_LAYER)));
    }
    
    public String canPlace(Level level, int layerID, int x, int y, int rotation, boolean byPlayer, boolean ignoreOtherLayers) {
      String error = super.canPlace(level, layerID, x, y, rotation, byPlayer, ignoreOtherLayers);
      if (error != null)
        return error; 
      if (level.getObjectID(ObjectLayerRegistry.TILE_LAYER, x, y) != 0)
        return "occupied"; 
      if (byPlayer && (level.getTile(x, y)).isOrganic)
        return null; 
      if (level.getTileID(x, y) != TileRegistry.getTileID("haunted_grass_tile"))
        return "wrongtile"; 
      return null;
    }
    
    public boolean isValid(Level level, int layerID, int x, int y) {
      if (!super.isValid(level, layerID, x, y))
        return false; 
      if (level.getObjectID(ObjectLayerRegistry.TILE_LAYER, x, y) != 0)
        return false; 
      if (level.objectLayer.isPlayerPlaced(layerID, x, y) && (level.getTile(x, y)).isOrganic)
        return true; 
      return (level.getTileID(x, y) == TileRegistry.getTileID("haunted_grass_tile"));
    }
  }