package NecesseExpanded.Mobs.Hostile.Raiders.SlimeRaiders;

import java.awt.Point;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.MobRegistry;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.itemAttack.ItemAttackDrawOptions;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.inventory.InventoryItem;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class SlimeWarriorRaider extends SlimeRaiderTemplate 
{
  public SlimeWarriorRaider() {
    super();
    this.setMaxHealth(600);
    this.setArmor(15);
    this.setSpeed(50F);
    this.weapon = new InventoryItem("slime_warrior_sword");
  }

  public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level,
      int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
    final DrawOptions arms;
    super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
    GameLight light = level.getLightLevel(x / 32, y / 32);
    int drawX = camera.getDrawX(x) - 32;
    int drawY = camera.getDrawY(y) - 50;
    int dir = getDir();
    Point sprite = getAnimSprite(x, y, dir);
    drawY += getBobbing(x, y);
    drawY += getLevel().getTile(x / 32, y / 32).getMobSinkingAmount((Mob) this);
    final MaskShaderOptions swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
    final TextureDrawOptionsEnd options = MobRegistry.Textures.warriorSlime.body.initDraw().sprite(sprite.x, sprite.y, 64)
        .addMaskShader(swimMask).light(light).pos(drawX, drawY);
    float attackProgress = getAttackAnimProgress();
    if (this.isAttacking) {
      arms = ItemAttackDrawOptions.start(dir).itemSprite(MobRegistry.Textures.warriorSlime.body, 0, 9, 32)
          .itemRotatePoint(6, 6).itemEnd().armSprite(MobRegistry.Textures.warriorSlime.body, 0, 8, 32)
          .setOffsets(((dir == 3) ? 36 : 28) + swimMask.drawXOffset, 22 + swimMask.drawYOffset, 8, 15, 12, 4, 12)
          .swingRotation(attackProgress).light(light).pos(drawX, drawY);
    } else {
      arms = null;
    }
    list.add(new MobDrawable() {
      public void draw(TickManager tickManager) {
        swimMask.use();
        options.draw();
        swimMask.stop();
        if (arms != null)
          arms.draw();
      }
    });
    TextureDrawOptionsEnd shadow = MobRegistry.Textures.warriorSlime.shadow.initDraw().sprite(sprite.x, sprite.y, 64)
        .light(light).pos(drawX, drawY);
    tileList.add(tm -> shadow.draw());
  }
}
