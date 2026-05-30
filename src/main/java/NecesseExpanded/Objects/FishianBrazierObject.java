package NecesseExpanded.Objects;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.List;
import java.util.Objects;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.util.GameRandom;
import necesse.engine.util.GameUtils;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.projectile.BombProjectile;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.LevelSortedDrawable;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.item.toolItem.ToolType;
import necesse.level.gameObject.GameObject;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class FishianBrazierObject extends GameObject {
    public float flameHue = 128.0f;
    public float smokeHue = 128.0f;
    public GameTexture texture;
    public int particleStartHeight = 20;
    
    public FishianBrazierObject() {
      super(new Rectangle(2, 2, 28, 28));
      this.mapColor = new Color(213, 132, 67);
      this.displayMapTooltip = true;
      this.lightLevel = 125;
      this.lightHue = 128f;
      this.objectHealth = 1;
      this.stackSize = 500;
      this.toolType = ToolType.ALL;
      this.isLightTransparent = true;
      setItemCategory(new String[] { "objects", "lighting" });
      setCraftingCategory(new String[] { "objects", "lighting" });
      this.roomProperties.add("lights");
      this.canPlaceOnShore = true;
      this.replaceCategories.add("torch");
      this.canReplaceCategories.add("torch");
      this.canReplaceCategories.add("furniture");
      this.canReplaceCategories.add("column");
      this.replaceRotations = false;
    }
    
    public void loadTextures() {
      super.loadTextures();
      this.texture = GameTexture.fromFile("objects/" + getStringID());
    }
    
    public void tickEffect(Level level, int layerID, int tileX, int tileY) {
      if (GameRandom.globalRandom.getEveryXthChance(20) && 
        isActive(level, tileX, tileY)) {
        int startHeight = this.particleStartHeight + (int)(GameRandom.globalRandom.nextGaussian() * 2.0D);
        int startX = tileX * 32 + 16 + GameRandom.globalRandom.getIntBetween(-5, 5);
        BombProjectile.spawnFuseParticle(level, startX, (tileY * 32 + 16 + 2), startHeight, this.flameHue, this.smokeHue);
      } 
    }
    
    public void addDrawables(List<LevelSortedDrawable> list, OrderableDrawables tileList, Level level, int tileX, int tileY, TickManager tickManager, GameCamera camera, PlayerMob perspective) 
    {
      int spriteX;
      GameLight light = level.getLightLevel(tileX, tileY);
      int drawX = camera.getTileDrawX(tileX);
      int drawY = camera.getTileDrawY(tileY);
      boolean active = isActive(level, tileX, tileY);
      if (active) {
        spriteX = 1 + GameUtils.getAnim(level.getWorldEntity().getTime() + Math.abs(getTileSeed(tileX, tileY, 52)), 4, 500);
      } else {
        spriteX = 0;
      } 
      final TextureDrawOptionsEnd options = this.texture.initDraw().sprite(spriteX, 0, 32, this.texture.getHeight()).addObjectDamageOverlay(this, level, tileX, tileY).light(light).pos(drawX, drawY - 32);
      list.add(new LevelSortedDrawable(this, tileX, tileY) {
            public int getSortY() 
            {
              return 16;
            }
            public void draw(TickManager tickManager) 
            {
              Objects.requireNonNull(options);
              options.draw();
            }
          });
        
    }
    
    public void drawPreview(Level level, int tileX, int tileY, int rotation, float alpha, PlayerMob player, GameCamera camera) {
      int drawX = camera.getTileDrawX(tileX);
      int drawY = camera.getTileDrawY(tileY);
      this.texture.initDraw()
        .sprite(0, 0, 32, this.texture.getHeight())
        .alpha(alpha)
        .draw(drawX, drawY - 32);
    }
    
    public int getLightLevel(Level level, int layerID, int tileX, int tileY) {
      return isActive(level, tileX, tileY) ? this.lightLevel : 0;
    }
    
    public boolean isActive(Level level, int x, int y) {
      byte rotation = level.getObjectRotation(x, y);
      return getMultiTile(rotation).streamIDs(x, y).noneMatch(c -> level.wireManager.isWireActiveAny(c.tileX, c.tileY));
    }
    
    public void onWireUpdate(Level level, int layerID, int tileX, int tileY, int wireID, boolean active) {
      byte rotation = level.getObjectRotation(tileX, tileY);
      Rectangle rect = getMultiTile(rotation).getTileRectangle(tileX, tileY);
      level.lightManager.updateStaticLight(rect.x, rect.y, rect.x + rect.width - 1, rect.y + rect.height - 1, true);
    }
  }
