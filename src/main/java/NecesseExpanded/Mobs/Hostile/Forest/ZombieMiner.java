package NecesseExpanded.Mobs.Hostile.Forest;

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
import necesse.gfx.drawOptions.human.HumanDrawOptions.HumanDrawOptionsGetter;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.ArmorItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class ZombieMiner extends HostileItemAttackerMob
{
    public InventoryItem helmet;
    public InventoryItem chest;
    public InventoryItem boots;
    public InventoryItem weapon;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ZombieMiner()
    {
        super(125);
        this.setArmor(5);
        this.setSpeed(35F);
        this.collision = new Rectangle(-10, -7, 20, 14);
        this.hitBox = new Rectangle(-14, -12, 28, 24);
        this.selectBox = new Rectangle(-14, -41, 28, 48);
        this.swimMaskMove = 16;
        this.swimMaskOffset = -2;
        this.swimSinkOffset = -4;
        this.weapon = new InventoryItem("ironsword");
        this.helmet = new InventoryItem("minerhat");
        this.chest = new InventoryItem("minershirt");
        this.boots = new InventoryItem("minerboots");
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
            new OneOfLootItems
            (
                new LootItem("copperore", GameRandom.globalRandom.getIntBetween(8, 12)),
                new LootItem("ironore", GameRandom.globalRandom.getIntBetween(4, 8)),
                new LootItem("goldore", GameRandom.globalRandom.getIntBetween(2, 4))
            ),
            new LootItem("beet", GameRandom.globalRandom.getIntBetween(1, 2))
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
        HumanDrawOptions humanDrawOptions = (new HumanDrawOptions(level, MobRegistry.Textures.zombie)).sprite(sprite).dir(dir).mask(swimMask).light(light);
        if (this.helmet != null)
        {
            humanDrawOptions.helmet(this.helmet); 
            humanDrawOptions.hatTexture((HumanDrawOptionsGetter)null, ArmorItem.HairDrawMode.NO_HAIR);
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
