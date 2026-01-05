package NecesseExpanded.Tiles;

import java.awt.Color;
import java.awt.Point;

import necesse.engine.registries.ObjectRegistry;
import necesse.engine.util.GameMath;
import necesse.engine.util.GameRandom;
import necesse.entity.particle.Particle;
import necesse.gfx.GameResources;
import necesse.gfx.gameTexture.GameTextureSection;
import necesse.inventory.lootTable.LootTable;
import necesse.level.gameObject.GameObject;
import necesse.level.gameTile.GrassTile;
import necesse.level.gameTile.TerrainSplatterTile;
import necesse.level.maps.Level;
import necesse.level.maps.regionSystem.SimulatePriorityList;

public class HauntedGrassTile extends TerrainSplatterTile 
{
    public static double growChance = GameMath.getAverageSuccessRuns(12000.0D);
    
    private final GameRandom drawRandom;
    
    public HauntedGrassTile() 
    {
        super(false, "haunted_grass");
        this.mapColor = new Color(35, 80, 0);
        this.canBeMined = true;
        this.drawRandom = new GameRandom();
        this.isOrganic = true;
    }
    
    public void addSimulateLogic(Level level, int x, int y, long ticks, SimulatePriorityList list, boolean sendChanges) {
      GrassTile.addSimulateGrow(level, x, y, growChance, ticks, "haunted_grass", list, sendChanges);
    }
    
    public void tick(Level level, int x, int y) {
      if (!level.isServer())
        return; 
      if (level.getObjectID(x, y) == 0 && 
        GameRandom.globalRandom.getChance(growChance)) {
        GameObject grass = ObjectRegistry.getObject(ObjectRegistry.getObjectID("haunted_grass"));
        if (grass.canPlace(level, x, y, 0, false) == null) {
          grass.placeObject(level, x, y, 0, false);
          level.sendObjectUpdatePacket(x, y);
        } 
      } 
    }
    
    public void tickEffect(Level level, int x, int y) {
      super.tickEffect(level, x, y);
      if (GameRandom.globalRandom.getChance(0.002F) && 
        !level.getObject(x, y).drawsFullTile() && level.getLightLevel(x, y).getLevel() > 0.0F) {
        int posX = x * 32 + GameRandom.globalRandom.nextInt(32);
        int posY = y * 32 + GameRandom.globalRandom.nextInt(32);
        boolean mirror = GameRandom.globalRandom.nextBoolean();
        level.entityManager.addParticle(posX, (posY + 30), Particle.GType.COSMETIC)
          .sprite(GameResources.fogParticles.sprite(GameRandom.globalRandom.nextInt(4), 0, 32, 16))
          .fadesAlpha(0.4F, 0.4F)
          .size((options, lifeTime, timeAlive, lifePercent) -> {
            
            }).height(30.0F)
          .dontRotate()
          .movesConstant(GameRandom.globalRandom.getFloatBetween(2.0F, 5.0F) * ((Float)GameRandom.globalRandom.getOneOf((Object[])new Float[] { Float.valueOf(1.0F), Float.valueOf(-1.0F) })).floatValue(), 0.0F)
          .modify((options, lifeTime, timeAlive, lifePercent) -> options.mirror(mirror, false))
          .lifeTime(3000);
      } 
    }
    
    public LootTable getLootTable(Level level, int tileX, int tileY) {
      return new LootTable();
    }
    
    public Point getTerrainSprite(GameTextureSection terrainTexture, Level level, int tileX, int tileY) {
      int tile;
      synchronized (this.drawRandom) {
        tile = this.drawRandom.seeded(getTileSeed(tileX, tileY)).nextInt(terrainTexture.getHeight() / 32);
      } 
      return new Point(0, tile);
    }
    
    public int getTerrainPriority() {
      return 200;
    }
  }
