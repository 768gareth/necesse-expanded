package NecesseExpanded.Mobs.Hostile.Raiders.SlimeRaiders;

import java.awt.Rectangle;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.hostile.ItemAttackerRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.LootItem;

public class SlimeRaiderTemplate extends ItemAttackerRaiderMob {
    public SlimeRaiderTemplate() {
        super(false);
        this.setSpeed(40F);
        this.collision = new Rectangle(-10, -7, 20, 14);
        this.hitBox = new Rectangle(-14, -12, 28, 24);
        this.selectBox = new Rectangle(-15, -32, 30, 40);
        this.swimMaskMove = 10;
        this.swimMaskOffset = -2;
        this.swimSinkOffset = -8;
        this.weapon = new InventoryItem("ironaxe");

        SlimeRaiderTemplate.lootTable = new LootTable
        (
            new LootItemInterface[] 
            {
                (LootItemInterface) LootItem.between("coin", 30, 70),
                (LootItemInterface) new ChanceLootItem(0.25F, "slimematter", GameRandom.globalRandom.getIntBetween(1, 2))
            }
        );
    }

    public void updateArmor() {
    }
}
