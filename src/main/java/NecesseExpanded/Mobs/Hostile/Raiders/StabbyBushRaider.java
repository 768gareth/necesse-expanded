package NecesseExpanded.Mobs.Hostile.Raiders;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.MobRegistry;
import necesse.entity.mobs.DeathMessageTable;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.hostile.ItemAttackerRaiderMob;
import necesse.entity.particle.FleshParticle;
import necesse.entity.particle.Particle.GType;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.human.HumanDrawOptions;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.ItemHolding;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class StabbyBushRaider extends ItemAttackerRaiderMob
{
    public StabbyBushRaider()
    {
        super(false);
        this.setSpeed(30.0F);
        this.setFriction(2.0F);
        this.weapon = new InventoryItem("ironsword");
        this.collision = new Rectangle(-10, -7, 20, 14);
        this.hitBox = new Rectangle(-16, -22, 32, 32);
        this.selectBox = new Rectangle(-26, -32, 52, 42);
    }

    public DeathMessageTable getDeathMessages() {
      return this.getDeathMessages("stabbybush", 3);
   }

   public void spawnDeathParticles(float knockbackX, float knockbackY) {
      for(int i = 0; i < 4; ++i) {
         this.getLevel().entityManager.addParticle(new FleshParticle(this.getLevel(), MobRegistry.Textures.stabbyBush.body, i, 8, 32, this.x, this.y, 20.0F, knockbackX, knockbackY), GType.IMPORTANT_COSMETIC);
      }

   }

    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level,
      int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
    super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
    GameLight light = level.getLightLevel(x / 32, y / 32);
    int drawX = camera.getDrawX(x) - 22 - 10;
    int drawY = camera.getDrawY(y) - 44 - 7;
    int dir = getDir();
    Point sprite = getAnimSprite(x, y, dir);
    boolean inLiquid = inLiquid(x, y);
    if (inLiquid)
      sprite.x = 0;
    drawY += getBobbing(x, y);
    drawY += getLevel().getTile(x / 32, y / 32).getMobSinkingAmount((Mob) this);
    MaskShaderOptions swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
    HumanDrawOptions humanOptions = (new HumanDrawOptions(level, MobRegistry.Textures.stabbyBush)).sprite(sprite).dir(dir)
        .mask(swimMask).light(light);
    if (!this.isAttacking && this.carryingLoot != null) {
      InventoryItem holdItem = new InventoryItem("itemhold");
      ItemHolding.setGNDData(holdItem, this.carryingLoot);
      humanOptions.holdItem(holdItem);
    }
    setupAttackDraw(humanOptions);
    final DrawOptions drawOptions = humanOptions.pos(drawX, drawY);
    final TextureDrawOptionsEnd boat = inLiquid
        ? MobRegistry.Textures.steelBoat.initDraw().sprite(0, sprite.y, 64).light(light).pos(drawX, drawY + 7)
        : null;
    list.add(new MobDrawable() {
      public void draw(TickManager tickManager) {
        if (boat != null)
          boat.draw();
        drawOptions.draw();
      }
    });
    addShadowDrawables(tileList, level, x, y, light, camera);
  }
}
