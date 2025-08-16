package NecesseExpanded.Raids.DuskDawnKnights.Tier3;

import java.util.stream.Stream;

import necesse.engine.registries.BuffRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;

public class KnightOfDawn extends HumanRaiderMob
{
    
    public KnightOfDawn()
    {
        super();
        this.setMaxHealth(2000);
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
                    (LootItemInterface) LootItem.between("greaterresistancepotion", 1, 2),
                    (LootItemInterface) LootItem.between("greaterhealthregenpotion", 1, 2)
                )
            }
        );

        this.weapon = GameRandom.globalRandom.getOneOf
        (
            new InventoryItem("causticexecutioner"), 
            new InventoryItem("slimeglaive"),
            new InventoryItem("arachnidwebbow")
        );

        this.setArmorItems
        (
            new InventoryItem("dawnhelmet"), 
            new InventoryItem("dawnchestplate"), 
            new InventoryItem("dawnboots")
        );
    }

    public void serverTick()
    {
        super.serverTick();
        if (this.getLevel().getWorldEntity().isNight())
        {
            this.addBuff(new ActiveBuff(BuffRegistry.getBuff("firestonetrinket"), this, 10, null), true);
        }
        else
        {
            this.buffManager.removeBuff("firestonetrinket", true);
        }
    }
}
