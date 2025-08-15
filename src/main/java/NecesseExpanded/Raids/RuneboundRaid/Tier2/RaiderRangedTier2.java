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

public class RaiderRangedTier2 extends HumanRaiderMob
{
    public RaiderRangedTier2()
    {
        super();
        this.setMaxHealth(500);
        this.setArmor(30);
        
        RaiderRangedTier2.lootTable = new LootTable
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
                            (LootItemInterface) LootItem.between("greaterhealthpotion", 1, 2),
                            (LootItemInterface) LootItem.between("accuracypotion", 1, 2),
                            (LootItemInterface) LootItem.between("attackspeedpotion", 1, 2),
                            (LootItemInterface) LootItem.between("rapidpotion", 1, 2),
                            (LootItemInterface) LootItem.between("rangerpotion", 1, 2)
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
                            (LootItemInterface) new LootItem("ammobox", 1),
                            (LootItemInterface) new LootItem("magicalquiver", 1),
                            (LootItemInterface) new LootItem("assassinscowl", 1),
                            (LootItemInterface) new LootItem("ghostboots", 1)
                        )
                    }
                )
            }
        );

        this.weapon = new InventoryItem
        (
            GameRandom.globalRandom.getOneOf
            (
                "tungstenbow",
                "tungstengreatbow"
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
