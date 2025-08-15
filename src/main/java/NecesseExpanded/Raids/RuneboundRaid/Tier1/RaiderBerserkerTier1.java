package NecesseExpanded.Raids.RuneboundRaid.Tier1;

import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.ChanceLootItemList;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;

public class RaiderBerserkerTier1 extends HumanRaiderMob
{
    public RaiderBerserkerTier1()
    {
        super();
        this.setMaxHealth(500);
        this.setSpeed(50F);
        this.setRegen(10F);
        this.setCombatRegen(5F);

        RaiderBerserkerTier1.lootTable = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)LootItem.between("coin", getMaxHealth() / 10, getMaxHealth() / 5),

                (LootItemInterface)new ChanceLootItemList
                (
                    0.5F, new LootItemInterface[] 
                    { 
                        (LootItemInterface) new OneOfLootItems
                        (
                            (LootItemInterface) LootItem.between("healthpotion", 1, 2),
                            (LootItemInterface) LootItem.between("speedpotion", 1, 2),
                            (LootItemInterface) LootItem.between("resistancepotion", 1, 2)
                        )
                    }
                ),

                (LootItemInterface)new ChanceLootItem(0.05F, "challengersbanner"),

                (LootItemInterface)new ChanceLootItemList
                (
                    0.5F, new LootItemInterface[] 
                    { 
                        (LootItemInterface) new OneOfLootItems
                        (
                            (LootItemInterface) LootItem.between("copperbar", 1, 2),
                            (LootItemInterface) LootItem.between("ironbar", 1, 2),
                            (LootItemInterface) LootItem.between("goldbar", 1, 2)
                        )
                    }
                )
            }
        );

        this.weapon = new InventoryItem("irongreatsword");
        this.helmet = new InventoryItem("runeboundhornhelmet");
        this.chest = new InventoryItem("runeboundleatherchest");
        this.boots = new InventoryItem("runeboundboots");
    }

    public void serverTick()
    {
        super.serverTick();
        this.buffManager.addBuff(new ActiveBuff("frenzyorbtrinket", this, 99, this), false);
    }
}
