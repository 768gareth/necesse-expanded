package NecesseExpanded.Raids.RuneboundRaid.Tier2;

import necesse.engine.util.GameRandom;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.ChanceLootItemList;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;

public class RaiderMeleeTier2 extends HumanRaiderMob
{
    public RaiderMeleeTier2()
    {
        super();
        this.setMaxHealth(600);
        this.setArmor(40);
        
        RaiderMeleeTier2.lootTable = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)LootItem.between("coin", getMaxHealth() / 30, getMaxHealth() / 20), // Coin loot.
                (LootItemInterface)new ChanceLootItemList
                (
                    0.5F, new LootItemInterface[] 
                    { 
                        (LootItemInterface) new OneOfLootItems
                        (
                            (LootItemInterface) LootItem.between("greaterhealthpotion", 1, 2),
                            (LootItemInterface) LootItem.between("speedpotion", 1, 2),
                            (LootItemInterface) LootItem.between("resistancepotion", 1, 2),
                            (LootItemInterface) LootItem.between("strengthpotion", 1, 2)
                        )
                    }
                ),

                (LootItemInterface)new ChanceLootItem(0.5F, "tungstenbar"),

                (LootItemInterface)new ChanceLootItem(0.05F, "lifeelixir"),

                (LootItemInterface)new ChanceLootItem(0.05F, "challengersbanner"),

                (LootItemInterface)new ChanceLootItemList
                (
                    0.05F, new LootItemInterface[] 
                    { 
                        (LootItemInterface) new OneOfLootItems
                        (
                            (LootItemInterface) new LootItem("tungstenshield", 1),
                            (LootItemInterface) new LootItem("firestone", 1),
                            (LootItemInterface) new LootItem("froststone", 1)
                        )
                    }
                )
            }
        );

        this.weapon = new InventoryItem
        (
            GameRandom.globalRandom.getOneOf
            (
                "tungstenspear",
                "tungstensword"
            )
        );

        this.setArmorItems
        (
            new InventoryItem("runeboundhelmet"), 
            new InventoryItem("runeboundleatherchest"), 
            new InventoryItem("runeboundboots")
        );
    }
}
