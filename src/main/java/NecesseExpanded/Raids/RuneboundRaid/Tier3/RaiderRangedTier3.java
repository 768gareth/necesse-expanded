package NecesseExpanded.Raids.RuneboundRaid.Tier3;

import necesse.engine.util.GameRandom;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.ChanceLootItemList;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;

public class RaiderRangedTier3 extends HumanRaiderMob
{
    public RaiderRangedTier3()
    {
        super();
        this.setMaxHealth(700);
        this.setArmor(40);
        
        RaiderRangedTier3.lootTable = new LootTable
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
                            (LootItemInterface) LootItem.between("superiorhealthpotion", 1, 2),
                            (LootItemInterface) LootItem.between("greaterspeedpotion", 1, 2),
                            (LootItemInterface) LootItem.between("greaterrapidpotion", 1, 2)
                        )
                    }
                ),

                (LootItemInterface)new ChanceLootItemList
                (
                    0.1F, new LootItemInterface[] 
                    { 
                        (LootItemInterface) new OneOfLootItems
                        (
                            (LootItemInterface) LootItem.between("shadowessence", 1, 2),
                            (LootItemInterface) LootItem.between("cryoessence", 1, 2),
                            (LootItemInterface) LootItem.between("bioessence", 1, 2),
                            (LootItemInterface) LootItem.between("primordialessence", 1, 2)
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
                            (LootItemInterface) new LootItem("clockworkheart", 1),
                            (LootItemInterface) new LootItem("templependant", 1)
                        )
                    }
                )
            }
        );

        this.weapon = new InventoryItem
        (
            GameRandom.globalRandom.getOneOf
            (
                "antiquebow",
                "antiquerifle"
            )
        );

        this.setArmorItems
        (
            new InventoryItem("leatherhood"), 
            new InventoryItem("runeboundleatherchest"), 
            new InventoryItem("runeboundboots")
        );
    }
}
