package NecesseExpanded.Objects;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.List;
import java.util.Objects;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.ObjectLayerRegistry;
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

public class DryadSpiritLampObject extends GameObject {
    public float flameHue = 128.0f;
    public float smokeHue = 128.0f;
    public GameTexture texture;
    public int particleStartHeight = 20;

    public DryadSpiritLampObject() {
        super(new Rectangle(2, 2, 28, 28));
        this.mapColor = new Color(213, 132, 67);
        this.displayMapTooltip = true;
        this.lightLevel = 120;
        this.lightHue = 200f;
        this.lightSat = 0.5F;
        this.objectHealth = 1;
        this.stackSize = 500;
        this.toolType = ToolType.ALL;
        this.isLightTransparent = true;
        setItemCategory(new String[] { "objects", "lighting" });
        setCraftingCategory(new String[] { "objects", "lighting" });
        this.roomProperties.add("lights");
        this.canPlaceOnShore = true;
        this.replaceCategories.add("torch");
        this.validObjectLayers.add(Integer.valueOf(ObjectLayerRegistry.FENCE_AND_TABLE_DECOR));
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
        if (GameRandom.globalRandom.getEveryXthChance(20)) {
            int startHeight = this.particleStartHeight + (int) (GameRandom.globalRandom.nextGaussian() * 2.0D);
            int startX = tileX * 32 + 16 + GameRandom.globalRandom.getIntBetween(-5, 5);
            BombProjectile.spawnFuseParticle(level, startX, (tileY * 32 + 16 + 2), startHeight, this.flameHue,
                    this.smokeHue);
        }

    }

    public void addDrawables(List<LevelSortedDrawable> list, OrderableDrawables tileList, Level level, int tileX,
            int tileY, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
        int spriteX;
        GameLight light = level.getLightLevel(tileX, tileY);
        int drawX = camera.getTileDrawX(tileX);
        int drawY = camera.getTileDrawY(tileY);
        spriteX = 0 + GameUtils.getAnim(level.getWorldEntity().getTime() + Math.abs(getTileSeed(tileX, tileY, 52)), 4, 2000);
        final TextureDrawOptionsEnd options = this.texture.initDraw().sprite(spriteX, 0, 32, this.texture.getHeight())
                .addObjectDamageOverlay(this, level, tileX, tileY).light(light).pos(drawX, drawY - 32);
        list.add(new LevelSortedDrawable(this, tileX, tileY) {
            public int getSortY() {
                return 16;
            }

            public void draw(TickManager tickManager) {
                Objects.requireNonNull(options);
                options.draw();
            }
        });

    }

    public void drawPreview(Level level, int tileX, int tileY, int rotation, float alpha, PlayerMob player,
            GameCamera camera) {
        int drawX = camera.getTileDrawX(tileX);
        int drawY = camera.getTileDrawY(tileY);
        this.texture.initDraw()
                .sprite(0, 0, 32, this.texture.getHeight())
                .alpha(alpha)
                .draw(drawX, drawY - 32);
    }
}
