package NecesseExpanded.Raids.RuneboundRaid.Other;

import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.ChanceLootItemList;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;

public class RaiderTrapper extends HumanRaiderMob
{
    public RaiderTrapper()
    {
        super();
        this.setMaxHealth(400);
        this.setArmor(30);
        this.setSpeed(50F);
        
        RaiderTrapper.lootTable = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)LootItem.between("coin", getMaxHealth() / 20, getMaxHealth() / 10),
                
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

        this.weapon = new InventoryItem("captorsshortbow");

        this.setArmorItems
        (
            new InventoryItem("runeboundskullhelmet"),
            new InventoryItem("runeboundleatherchest"), 
            new InventoryItem("runeboundboots")
        );
    }
}
