package NecesseExpanded.Raids.NecromancerRaid.Tier3;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.network.client.Client;
import necesse.engine.registries.MobRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.hostile.ItemAttackerRaiderMob;
import necesse.entity.particle.FleshParticle;
import necesse.entity.particle.Particle;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.human.HumanDrawOptions;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.InventoryItem;
import necesse.level.maps.Level;
import necesse.inventory.item.ItemHolding;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.ChanceLootItemList;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;
import necesse.level.maps.LevelMap;
import necesse.level.maps.light.GameLight;

public class AncientSkeletonRaider extends ItemAttackerRaiderMob
{
    public AncientSkeletonRaider() 
    {
        super(false);
        setMaxHealth(600);
        setSpeed(30.0F);
        setArmor(50);
        setFriction(3.0F);
        this.setRegen(10F);
        this.setCombatRegen(5F);
        this.collision = new Rectangle(-10, -7, 20, 14);
        this.hitBox = new Rectangle(-14, -12, 28, 24);
        this.selectBox = new Rectangle(-14, -41, 28, 48);
        this.swimMaskMove = 16;
        this.swimMaskOffset = -2;
        this.swimSinkOffset = -4;

        this.chest = new InventoryItem("tungstenchestplate");
        this.boots = new InventoryItem("tungstenboots");

        this.weapon = GameRandom.globalRandom.getOneOf
        (
            new InventoryItem("antiquesword"),
            new InventoryItem("antiquebow"),
            new InventoryItem("antiquerifle"),
            new InventoryItem("ancientdredgingstaff")
        );
    }

    public LootTable getLootTable() 
    {
        return new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)LootItem.between("coin", 10, 20),

                (LootItemInterface)new ChanceLootItem(0.25F, "spoiledfood", 1),

                (LootItemInterface)new ChanceLootItemList
                (
                    0.10F, new LootItemInterface[] 
                    { 
                        (LootItemInterface) new OneOfLootItems
                        (
                            (LootItemInterface) LootItem.between("shadowessence", 1, 2),
                            (LootItemInterface) LootItem.between("cryoessence", 1, 2),
                            (LootItemInterface) LootItem.between("bioessence", 1, 2),
                            (LootItemInterface) LootItem.between("primordialessence", 1, 2)
                        )
                    }
                ),

                (LootItemInterface)new ChanceLootItem(0.005F, "challengersbanner")
            }

            
        );
    }

    public void updateAIAndLook() 
    {
        super.updateAIAndLook();
    }

    public void spawnDeathParticles(float knockbackX, float knockbackY) 
    {
        GameTexture bodyTexture = MobRegistry.Textures.zombie.body;
        for (int i = 0; i < 4; i++)
        (getLevel()).entityManager.addParticle((Particle)new FleshParticle(getLevel(), bodyTexture, GameRandom.globalRandom.nextInt(5), 8, 32, this.x, this.y, 10.0F, knockbackX, knockbackY), Particle.GType.IMPORTANT_COSMETIC); 
    }
  
    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) 
    {
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
    drawY += getLevel().getTile(x / 32, y / 32).getMobSinkingAmount((Mob)this);
    MaskShaderOptions swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
    HumanDrawOptions humanOptions = (new HumanDrawOptions(level, MobRegistry.Textures.ancientSkeleton)).sprite(sprite).mask(swimMask).dir(dir).light(light);
    if (inLiquid) {
      humanOptions.armSprite(2);
      humanOptions.mask(MobRegistry.Textures.boat_mask[sprite.y % 4], 0, -7);
    } 

        if (this.helmet != null) 
        {
            humanOptions.helmet(this.helmet);
        }

        if (this.chest != null) 
        {
            humanOptions.chestplate(this.chest);
        }

        if (this.boots != null) 
        {
            humanOptions.boots(this.boots);
        }

    if (!this.isAttacking && this.carryingLoot != null) {
      InventoryItem holdItem = new InventoryItem("itemhold");
      ItemHolding.setGNDData(holdItem, this.carryingLoot);
      humanOptions.holdItem(holdItem);
    } 
    setupAttackDraw(humanOptions);
    final DrawOptions drawOptions = humanOptions.pos(drawX, drawY);
    final TextureDrawOptionsEnd boat = inLiquid ? MobRegistry.Textures.woodBoat.initDraw().sprite(0, sprite.y, 64).light(light).pos(drawX, drawY + 7) : null;
    list.add(new MobDrawable() {
          public void draw(TickManager tickManager) {
            if (boat != null)
              boat.draw(); 
            drawOptions.draw();
          }
        });
    addShadowDrawables(tileList, x, y, light, camera);
    }
  
    public boolean shouldDrawOnMap() 
    {
        return true;
    }
  
    public boolean isVisibleOnMap(Client client, LevelMap map) 
    {
        return true;
    }
  
    public Rectangle drawOnMapBox(double tileScale, boolean isMinimap) 
    {
        return new Rectangle(-10, -24, 20, 24);
    }
  
    public void drawOnMap(TickManager tickManager, Client client, int x, int y, double tileScale, Rectangle drawBounds, boolean isMinimap) 
    {
        int dir = getDir();
        Point sprite = getAnimSprite(getDrawX(), getDrawY(), dir);
        HumanDrawOptions humanOptions = (new HumanDrawOptions(getLevel(), MobRegistry.Textures.ancientSkeleton)).sprite(sprite).dir(dir).size(32, 32);
        humanOptions.pos(x - 15, y - 26).draw();
    }


}
