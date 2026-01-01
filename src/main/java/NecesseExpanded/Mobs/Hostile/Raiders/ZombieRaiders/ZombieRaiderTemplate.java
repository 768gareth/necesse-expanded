package NecesseExpanded.Mobs.Hostile.Raiders.ZombieRaiders;

import java.awt.Rectangle;

import necesse.engine.util.GameRandom;
import necesse.entity.mobs.hostile.ItemAttackerRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.LootTablePresets;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.ChanceLootItemList;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.presets.CaveChestLootTable;

public class ZombieRaiderTemplate extends ItemAttackerRaiderMob
{
    public ZombieRaiderTemplate()
    {
        super(false);
        ZombieRaiderTemplate.lootTable = LootTablePresets.basicCrate;
        this.collision = new Rectangle(-10, -7, 20, 14);
        this.hitBox = new Rectangle(-14, -12, 28, 24);
        this.selectBox = new Rectangle(-14, -41, 28, 48);
        this.swimMaskMove = 16;
        this.swimMaskOffset = -2;
        this.swimSinkOffset = -4;
        this.setArmor(5);
        this.weapon = new InventoryItem("ironaxe");

        ZombieArcherRaider.lootTable = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)LootItem.between("coin", getMaxHealth() / 30, getMaxHealth() / 20),
                (LootItemInterface) new ChanceLootItem(0.05f, "mysteriousportal"),
                (LootItemInterface)new ChanceLootItemList
                (
                    0.5F,
                    new LootItem("copperore", GameRandom.globalRandom.getIntBetween(2, 4)),
                    new LootItem("ironore", GameRandom.globalRandom.getIntBetween(2, 4)),
                    new LootItem("mapfragment", GameRandom.globalRandom.getIntBetween(2, 4))
                ),
                (LootItemInterface)new ChanceLootItemList
                (
                    0.05F,
                    CaveChestLootTable.basicMainItems
                ),
                new ChanceLootItem(0.05f, weapon.toString())
            }
        );
    }

    public void updateArmor() {}
}
