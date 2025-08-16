package NecesseExpanded.Raids.RuneboundRaid.Tier2;

import necesse.engine.registries.BuffRegistry;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.ChanceLootItemList;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;

public class RaiderBerserkerTier2 extends HumanRaiderMob
{
    public RaiderBerserkerTier2()
    {
        super();
        this.setMaxHealth(1000);
        this.setArmor(5);
        this.setSpeed(55F);
        this.setRegen(15F);
        this.setCombatRegen(10F);

        RaiderBerserkerTier2.lootTable = new LootTable
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
                            (LootItemInterface) LootItem.between("greaterhealthpotion", 1, 2),
                            (LootItemInterface) LootItem.between("speedpotion", 1, 2),
                            (LootItemInterface) LootItem.between("resistancepotion", 1, 2)
                        )
                    }
                ),

                (LootItemInterface)new ChanceLootItem(0.5F, "tungstenbar"),

                (LootItemInterface)new ChanceLootItem(0.05F, "lifeelixir"),

                (LootItemInterface)new ChanceLootItem(0.05F, "challengersbanner")
            }
        );

        this.weapon = new InventoryItem("quartzglaive");
        this.helmet = new InventoryItem("runeboundhornhelmet");
        this.chest = new InventoryItem("runeboundleatherchest");
        this.boots = new InventoryItem("runeboundboots");
    }

    public void serverTick()
    {
        super.serverTick();
        this.addBuff(new ActiveBuff(BuffRegistry.getBuff("frenzyorbtrinket"), this, 10, null), true);
    }
}
