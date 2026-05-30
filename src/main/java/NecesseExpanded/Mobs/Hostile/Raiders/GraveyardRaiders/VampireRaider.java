package NecesseExpanded.Mobs.Hostile.Raiders.GraveyardRaiders;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import NecesseExpanded.Mobs.Hostile.Raiders.AncientSkeletonRaiders.AncientSkeletonRaider;
import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.network.client.Client;
import necesse.engine.registries.MobRegistry;
import necesse.engine.registries.MobRegistry.Textures;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.hostile.ItemAttackerRaiderMob;
import necesse.entity.particle.FleshParticle;
import necesse.entity.particle.Particle.GType;
import necesse.gfx.HumanLook;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.human.HumanDrawOptions;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.ItemHolding;
import necesse.inventory.item.armorItem.cosmetics.misc.ShirtArmorItem;
import necesse.inventory.item.armorItem.cosmetics.misc.ShoesArmorItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.level.maps.Level;
import necesse.level.maps.incursion.GraveyardIncursionBiome;
import necesse.level.maps.light.GameLight;
import necesse.level.maps.mapData.ClientDiscoveredMap;

public class VampireRaider extends ItemAttackerRaiderMob
{
    HumanLook Look = new HumanLook();
    int SummonTimer = 0;

    public VampireRaider()
    {
        super(false);
        this.setMaxHealth(1500);
        this.setSpeed(40F);
        this.collision = new Rectangle(-10, -7, 20, 14);
        this.hitBox = new Rectangle(-14, -12, 28, 24);
        this.selectBox = new Rectangle(-14, -41, 28, 48);
        this.swimMaskMove = 16;
        this.swimMaskOffset = -2;
        this.swimSinkOffset = -4;

        this.weapon = new InventoryItem(GameRandom.globalRandom.getOneOf("bloodclaw", "bloodgrimoire", "thecrimsonsky", "brimstone"));
        VampireRaider.lootTable = new LootTable
        (
          new LootItemInterface[]
          {
            (LootItemInterface)LootItem.between("coin", getMaxHealth() / 30, getMaxHealth() / 20),
            (LootItemInterface) new ChanceLootItem(0.66F, "phantomdust", GameRandom.globalRandom.getIntBetween(1, 2)),
            (LootItemInterface) GraveyardIncursionBiome.graveyardMobDrops,
            (LootItemInterface) new ChanceLootItem(0.05f, weapon.item.getStringID())
          }
        );
    }

    public void serverTick() 
    {
        super.serverTick();
        if (SummonTimer >= 400 && this.isInCombat())
        {
            AncientSkeletonRaider Summon = new AncientSkeletonRaider();
            this.getLevel().entityManager.addMob(Summon, this.getX(), this.getY());
            SummonTimer = 0;
        }
        SummonTimer++;
    }

    

    public void updateArmor() {}

    public void spawnDeathParticles(float knockbackX, float knockbackY) {
    for (int i = 0; i < 4; ++i) {
      this.getLevel().entityManager.addParticle(new FleshParticle(this.getLevel(), MobRegistry.Textures.cryptVampire.body,
          GameRandom.globalRandom.nextInt(5), 8, 32, this.x, this.y, 20.0F, knockbackX, knockbackY),
          GType.IMPORTANT_COSMETIC);
    }

  }

  public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level,
      int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
        super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
        GameLight light = level.getLightLevel(x / 32, y / 32);
        int drawX = camera.getDrawX(x) - 22 - 10;
        int drawY = camera.getDrawY(y) - 44 - 7;
        int dir = this.getDir();
        Point sprite = this.getAnimSprite(x, y, dir);
        boolean inLiquid = this.inLiquid(x, y);
        if (inLiquid) {
           sprite.x = 0;
        }
  
        drawY += this.getBobbing(x, y);
        drawY += this.getLevel().getTile(x / 32, y / 32).getMobSinkingAmount(this);
        MaskShaderOptions swimMask = this.getSwimMaskShaderOptions(this.inLiquidFloat(x, y));
        HumanDrawOptions humanOptions = (new HumanDrawOptions(level, Textures.cryptVampire)).sprite(sprite).mask(swimMask).dir(dir).light(light);
        if (inLiquid) {
           humanOptions.armSprite(0);
           humanOptions.mask(Textures.boat_mask[sprite.y % 4], 0, -7);
        }
  
        if (!this.isAttacking && this.carryingLoot != null) {
           InventoryItem holdItem = new InventoryItem("itemhold");
           ItemHolding.setGNDData(holdItem, this.carryingLoot);
           humanOptions.holdItem(holdItem);
        }
  
        if (!this.hasCurrentMovement()) {
           this.setupAttackDraw(humanOptions);
        }
  
        DrawOptions drawOptions = humanOptions.pos(drawX, drawY);
        DrawOptions boat = inLiquid ? Textures.woodBoat.initDraw().sprite(0, sprite.y, 64).light(light).pos(drawX, drawY + 7) : null;
    list.add(new MobDrawable() {
      public void draw(TickManager tickManager) {
        if (boat != null)
          boat.draw();
        drawOptions.draw();
      }
    });
    addShadowDrawables(tileList, level, x, y, light, camera);
  }

  public boolean shouldDrawOnMap() {
    return true;
  }

  public boolean isVisibleOnMap(Client client, ClientDiscoveredMap map) {
    return true;
  }

  public Rectangle drawOnMapBox(double tileScale, boolean isMinimap) {
    return new Rectangle(-10, -24, 20, 24);
  }

  public void drawOnMap(TickManager tickManager, Client client, int x, int y, double tileScale, Rectangle drawBounds,
      boolean isMinimap) {
    int dir = this.getDir();
    Point sprite = this.getAnimSprite(this.getDrawX(), this.getDrawY(), dir);
    HumanDrawOptions humanOptions = (new HumanDrawOptions(this.getLevel(), MobRegistry.Textures.cryptVampire)).sprite(sprite).dir(dir)
        .size(32, 32);
    if (this.helmet != null) {
      humanOptions.helmet(this.helmet);
    }

    if (this.chest != null) {
      humanOptions.chestplate(this.chest);
    } else {
      humanOptions.chestplate(ShirtArmorItem.addColorData(new InventoryItem("shirt"), this.Look.getShirtColor()));
    }

    if (this.boots != null) {
      humanOptions.boots(this.boots);
    } else {
      humanOptions.boots(ShoesArmorItem.addColorData(new InventoryItem("shoes"), this.Look.getShoesColor()));
    }

    humanOptions.pos(x - 15, y - 26).draw();
  }
}
