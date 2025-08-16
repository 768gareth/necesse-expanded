package NecesseExpanded.Raids.DuskDawnKnights.Tier3;

import necesse.engine.modifiers.ModifierValue;
import necesse.engine.registries.BuffRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;

public class KnightOfDusk extends HumanRaiderMob
{
    public KnightOfDusk()
    {
        super();
        this.setMaxHealth(1800);
        this.setArmor(30);

        KnightOfDawn.lootTable = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)LootItem.between("coin", getMaxHealth() / 10, getMaxHealth() / 5),

                (LootItemInterface) new OneOfLootItems
                (
                    (LootItemInterface) LootItem.between("slimeessence", 1, 2),
                    (LootItemInterface) LootItem.between("bloodessence", 1, 2),
                    (LootItemInterface) LootItem.between("spideressence", 1, 2)
                ),

                (LootItemInterface) new OneOfLootItems
                (
                    (LootItemInterface) LootItem.between("superiorhealthpotion", 1, 2),
                    (LootItemInterface) LootItem.between("superiormanapotion", 1, 2),
                    (LootItemInterface) LootItem.between("greatermanaregenpotion", 1, 2)
                )
            }
        );

        this.weapon = GameRandom.globalRandom.getOneOf
        (
            new InventoryItem("webweaver"), 
            new InventoryItem("phantompopper"),
            new InventoryItem("slimestaff")
        );

        this.setArmorItems
        (
            new InventoryItem("duskhelmet"), 
            new InventoryItem("duskchestplate"), 
            new InventoryItem("duskboots")
        );
    }

    public void serverTick()
    {
        super.serverTick();
        if (this.getLevel().getWorldEntity().isNight())
        {
            this.addBuff(new ActiveBuff(BuffRegistry.getBuff("froststonetrinket"), this, 10, null), true);
        }
        else
        {
            this.buffManager.removeBuff("froststonetrinket", true);
        }
    }
}
