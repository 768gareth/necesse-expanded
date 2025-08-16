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

public class RaiderRangedTier1 extends HumanRaiderMob
{
    public RaiderRangedTier1()
    {
        super();
        this.setMaxHealth(200);
        this.setArmor(20);
        
        RaiderRangedTier1.lootTable = new LootTable
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
                            (LootItemInterface) LootItem.between("accuracypotion", 1, 2),
                            (LootItemInterface) LootItem.between("attackspeedpotion", 1, 2)
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

                (LootItemInterface)new ChanceLootItemList
                (
                    0.05F, new LootItemInterface[] 
                    { 
                        (LootItemInterface) new OneOfLootItems
                        (
                            (LootItemInterface) new LootItem("fuzzydice", 1),
                            (LootItemInterface) new LootItem("noblehorseshoe", 1),
                            (LootItemInterface) new LootItem("rangedfoci", 1)
                        )
                    }
                )
            }
        );

        this.weapon = new InventoryItem
        (
            GameRandom.globalRandom.getOneOf
            (
                "ironbow",
                "ninjastar"
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
