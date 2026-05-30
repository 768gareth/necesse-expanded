package NecesseExpanded.Mobs.Hostile.Desert;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import java.util.function.Supplier;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.MobRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.StaticItemAttackSlot;
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI;
import necesse.entity.mobs.ai.behaviourTree.trees.ConfusedItemAttackerPlayerChaserWandererAI;
import necesse.entity.mobs.hostile.HostileItemAttackerMob;
import necesse.entity.mobs.itemAttacker.CheckSlotType;
import necesse.entity.mobs.itemAttacker.ItemAttackSlot;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.human.HumanDrawOptions;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItemList;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.presets.TempleChestLootTable;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class AncientWarrior extends HostileItemAttackerMob
{
    public InventoryItem helmet;
    public InventoryItem chest;
    public InventoryItem boots;
    public InventoryItem weapon;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public AncientWarrior()
    {
        super(725);
        this.setArmor(5);
        this.setSpeed(35F);
        this.collision = new Rectangle(-10, -7, 20, 14);
        this.hitBox = new Rectangle(-14, -12, 28, 24);
        this.selectBox = new Rectangle(-14, -41, 28, 48);
        this.swimMaskMove = 16;
        this.swimMaskOffset = -2;
        this.swimSinkOffset = -4;
        this.weapon = new InventoryItem("antiquesword");
        this.chest = new InventoryItem("ancientfossilchestplate");
        this.boots = new InventoryItem("ancientfossilboots");
        this.ai = new BehaviourTreeAI
        (
            this, 
            new ConfusedItemAttackerPlayerChaserWandererAI
            (
                (Supplier) null, 
                1000, 
                weapon, 
                40000
            )
        );
    }

    public LootTable getLootTable() 
    {
      return new LootTable
      (
        new LootItemInterface[]
        {
            new LootItem("bone", GameRandom.globalRandom.getIntBetween(1, 3)),
            new ChanceLootItemList(0.1f, TempleChestLootTable.mainItems)
        }
    );
    }

    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) 
    {
        super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
        GameLight light = level.getLightLevel(x / 32, y / 32);
        int drawX = camera.getDrawX(x) - 22 - 10;
        int drawY = camera.getDrawY(y) - 44 - 7;
        int dir = getDir();
        Point sprite = getAnimSprite(x, y, dir);
        drawY += getBobbing(x, y);
        drawY += getLevel().getTile(x / 32, y / 32).getMobSinkingAmount((Mob)this);
        MaskShaderOptions swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
        HumanDrawOptions humanDrawOptions = (new HumanDrawOptions(level, MobRegistry.Textures.ancientSkeleton)).sprite(sprite).dir(dir).mask(swimMask).light(light);
        if (this.helmet != null)
        {
            humanDrawOptions.helmet(this.helmet);
        }
        if (this.chest != null) 
        {
            humanDrawOptions.chestplate(this.chest);
        } 
        if (this.boots != null) 
        {
            humanDrawOptions.boots(this.boots);
        } 
        setupAttackDraw(humanDrawOptions);
        final DrawOptions drawOptions = humanDrawOptions.pos(drawX, drawY);
        list.add
        (   new MobDrawable() 
            {
                public void draw(TickManager tickManager) 
                {
                    drawOptions.draw();
                }
            }
        );
        addShadowDrawables(tileList, level, x, y, light, camera);
    }

    public ItemAttackSlot getCurrentSelectedAttackSlot() 
    {
        if (this.weapon == null)
        {
            return null; 
        }
        return (ItemAttackSlot)new StaticItemAttackSlot(this.weapon);
    }
  
    public boolean hasValidSummonItem(Item item, CheckSlotType slotType) 
    {
        return true;
    }
    
}
