package NecesseExpanded.Raids.RuneboundRaid.Tier1;

import necesse.engine.util.GameRandom;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.ChanceLootItemList;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;

public class RaiderMagicTier1 extends HumanRaiderMob
{
    public RaiderMagicTier1()
    {
        super();
        this.setMaxHealth(200);
        this.setArmor(20);

        RaiderMagicTier1.lootTable = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)LootItem.between("coin", getMaxHealth() / 30, getMaxHealth() / 20),

                (LootItemInterface)new ChanceLootItemList
                (
                    0.5F, new LootItemInterface[] 
                    { 
                        (LootItemInterface) new OneOfLootItems
                        (
                            (LootItemInterface) LootItem.between("healthpotion", 1, 2),
                            (LootItemInterface) LootItem.between("manapotion", 1, 2),
                            (LootItemInterface) LootItem.between("manaregenpotion", 1, 2)
                        )
                    }
                ),

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
                ),

                (LootItemInterface)new ChanceLootItem(0.05F, "challengersbanner"),

                (LootItemInterface)new ChanceLootItemList
                (
                    0.05F, new LootItemInterface[] 
                    { 
                        (LootItemInterface) new OneOfLootItems
                        (
                            (LootItemInterface) new LootItem("dreamcatcher", 1),
                            (LootItemInterface) new LootItem("magicfoci", 1),
                            (LootItemInterface) new LootItem("summonfoci", 1)
                        )
                    }
                )
            }
        );

        this.weapon = new InventoryItem
        (
            GameRandom.globalRandom.getOneOf
            (
                "woodstaff",
                "sparkler",
                "venomstaff"
            )
        );

        this.setArmorItems
        (
            new InventoryItem("leatherhood"),
            new InventoryItem("leathershirt"), 
            new InventoryItem("leatherboots")
        );
    }
}
