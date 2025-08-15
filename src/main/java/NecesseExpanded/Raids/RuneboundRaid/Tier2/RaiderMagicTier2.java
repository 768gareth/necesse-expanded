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

public class RaiderMagicTier2 extends HumanRaiderMob
{
    public RaiderMagicTier2()
    {
        super();
        this.setMaxHealth(500);
        this.setArmor(30);

        RaiderMagicTier2.lootTable = new LootTable
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
                            (LootItemInterface) LootItem.between("greatermanapotion", 1, 2),
                            (LootItemInterface) LootItem.between("manaregenpotion", 1, 2),
                            (LootItemInterface) LootItem.between("wisdompotion", 1, 2)
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
                            (LootItemInterface) new LootItem("spellstone", 1),
                            (LootItemInterface) new LootItem("hysteriatablet", 1),
                            (LootItemInterface) new LootItem("firestone", 1)
                        )
                    }
                )
            }
        );

        this.weapon = new InventoryItem
        (
            GameRandom.globalRandom.getOneOf
            (
                "voidstaff",
                "shadowbolt",
                "genielamp"
            )
        );

        this.setArmorItems
        (
            new InventoryItem("leatherhood"), 
            new InventoryItem(GameRandom.globalRandom.getOneOf("runeboundrobe", "runeboundbonesrobe")),
            new InventoryItem("runeboundboots")
        );
    }
}
