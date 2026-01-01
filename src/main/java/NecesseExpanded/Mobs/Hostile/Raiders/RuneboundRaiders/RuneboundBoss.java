package NecesseExpanded.Mobs.Hostile.Raiders.RuneboundRaiders;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import necesse.engine.eventStatusBars.EventStatusBarManager;
import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.network.client.Client;
import necesse.engine.registries.MobRegistry;
import necesse.engine.registries.MusicRegistry;
import necesse.engine.sound.SoundManager;
import necesse.engine.sound.SoundManager.MusicPriority;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.staticBuffs.BossNearbyBuff;
import necesse.entity.mobs.hostile.ItemAttackerRaiderMob;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.human.HumanDrawOptions;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTooltips.GameTooltips;
import necesse.gfx.gameTooltips.StringTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.ItemHolding;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class RuneboundBoss extends ItemAttackerRaiderMob {
  
  public RuneboundBoss() {
    super(false);
    this.setMaxHealth(3500);
    setSpeed(30.0F);
    setFriction(3.0F);
    setArmor(25);
    this.collision = new Rectangle(-10, -7, 20, 14);
    this.hitBox = new Rectangle(-26, -24, 52, 48);
    this.selectBox = new Rectangle(-19, -52, 38, 64);
    this.swimMaskMove = 0;
    this.swimMaskOffset = 0;
    this.swimSinkOffset = 0;

    RuneboundBoss.lootTable = new LootTable
    (
        new LootItemInterface[] 
        { 
            (LootItemInterface)LootItem.between("coin", getMaxHealth() / 30, getMaxHealth() / 20),
            (LootItemInterface)LootItem.between("runestone", 6, 12),
            new LootItem("brutesbattleaxe")
        }
    );
    this.weapon = new InventoryItem("battleaxe_special");
  }

  public void init()
  {
    super.init();
  }

  public void clientTick() {
    super.clientTick();
    if (this.isHostile) {
         if (this.isClientPlayerNearby()) {
            SoundManager.setMusic(MusicRegistry.TheRuneboundTrialPart2, MusicPriority.EVENT, 1.5F);
            EventStatusBarManager.registerMobHealthStatusBar(this);
         }
         BossNearbyBuff.applyAround(this);
      }
  }

  public void updateArmor() {}

  public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level,
      int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
    Point armCenterPos;
    super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
    GameLight light = level.getLightLevel(x / 32, y / 32);
    int drawX = camera.getDrawX(x) - 64;
    int drawY = camera.getDrawY(y) - 86;
    int dir = getDir();
    Point sprite = getAnimSprite(x, y, dir);
    boolean inLiquid = inLiquid(x, y);
    if (inLiquid)
      sprite.x = 0;
    drawY += getBobbing(x, y);
    drawY += getLevel().getTile(x / 32, y / 32).getMobSinkingAmount((Mob) this);
    if (dir == 0) {
      armCenterPos = new Point(70, 20);
    } else if (dir == 1) {
      armCenterPos = new Point(53, 23);
    } else if (dir == 2) {
      armCenterPos = new Point(41, 22);
    } else {
      armCenterPos = new Point(73, 25);
    }
    MaskShaderOptions swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
    HumanDrawOptions humanDrawOptions = (new HumanDrawOptions(level, MobRegistry.Textures.chieftain))
        .sprite(sprite, 128).size(128, 128).mask(swimMask).dir(dir).light(light)
        .attackOffsets(armCenterPos.x, armCenterPos.y, 20, 30, 25, 0, 30);
    if (!this.isAttacking && this.carryingLoot != null) {
      InventoryItem holdItem = new InventoryItem("itemhold");
      ItemHolding.setGNDData(holdItem, this.carryingLoot);
      humanDrawOptions.holdItem(holdItem);
    }
    setupAttackDraw(humanDrawOptions);
    final DrawOptions drawOptions = humanDrawOptions.pos(drawX, drawY);
    list.add(new MobDrawable() {
      public void draw(TickManager tickManager) {
        drawOptions.draw();
      }
    });
    addShadowDrawables(tileList, level, x, y, light, camera);
  }

  public boolean shouldDrawOnMap() {
    return true;
  }

  public Rectangle drawOnMapBox(double tileScale, boolean isMinimap) {
    return new Rectangle(-12, -28, 24, 34);
  }

  public GameTooltips getMapTooltips() {
    return (GameTooltips) new StringTooltips(getDisplayName() + " " + getHealth() + "/" + getMaxHealth());
  }

  

  public void drawOnMap(TickManager tickManager, Client client, int x, int y, double tileScale, Rectangle drawBounds,
      boolean isMinimap) {
    super.drawOnMap(tickManager, client, x, y, tileScale, drawBounds, isMinimap);
    int drawX = x - 32;
    int drawY = y - 34;
    int dir = getDir();
    Point sprite = getAnimSprite(getDrawX(), getDrawY(), dir);
    (new HumanDrawOptions(getLevel(), MobRegistry.Textures.chieftain))
        .sprite(sprite, 128)
        .dir(dir)
        .size(64, 64)
        .draw(drawX, drawY);
  }
}
