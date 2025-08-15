package NecesseExpanded.Raids.RuneboundRaid.Tier3;

import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.ChanceLootItemList;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;

public class RaiderBerserkerTier3 extends HumanRaiderMob
{
    public RaiderBerserkerTier3()
    {
        super();
        this.setMaxHealth(1500);
        this.setArmor(20);
        this.setSpeed(65F);
        this.setRegen(25F);
        this.setCombatRegen(20F);

        RaiderBerserkerTier3.lootTable = new LootTable
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
                            (LootItemInterface) LootItem.between("greaterspeedpotion", 1, 2),
                            (LootItemInterface) LootItem.between("greaterresistancepotion", 1, 2)
                        )
                    }
                ),

                (LootItemInterface)new ChanceLootItem(0.05F, "challengersbanner")
            }
        );

        this.weapon = new InventoryItem("brutesbattleaxe");
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
