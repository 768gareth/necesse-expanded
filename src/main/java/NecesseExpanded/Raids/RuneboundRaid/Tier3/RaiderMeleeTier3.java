package NecesseExpanded.Raids.RuneboundRaid.Tier3;

import necesse.engine.registries.BuffRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.ChanceLootItemList;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;

public class RaiderMeleeTier3 extends HumanRaiderMob
{
    public RaiderMeleeTier3()
    {
        super();
        this.setMaxHealth(800);
        this.setArmor(50);
        
        RaiderMeleeTier3.lootTable = new LootTable
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
                            (LootItemInterface) LootItem.between("greaterresistancepotion", 1, 2),
                            (LootItemInterface) LootItem.between("greaterhealthregenpotion", 1, 2)
                        )
                    }
                ),

                (LootItemInterface)new ChanceLootItemList
                (
                    0.1F, new LootItemInterface[] 
                    { 
                        (LootItemInterface) new OneOfLootItems
                        (
                            (LootItemInterface) LootItem.between("tungstenbar", 1, 2),
                            (LootItemInterface) LootItem.between("glacialbar", 1, 2),
                            (LootItemInterface) LootItem.between("myceliumbar", 1, 2),
                            (LootItemInterface) LootItem.between("ancientfossilbar", 1, 2)
                        )
                    }
                ),

                (LootItemInterface)new ChanceLootItemList
                (
                    0.05F, new LootItemInterface[] 
                    { 
                        (LootItemInterface) new OneOfLootItems
                        (
                            (LootItemInterface) new LootItem("clockworkheart", 1),
                            (LootItemInterface) new LootItem("carapaceshield", 1)
                        )
                    }
                )
            }
        );

        this.weapon = new InventoryItem
        (
            GameRandom.globalRandom.getOneOf
            (
                "antiquesword",
                "cryoglaive"
            )
        );

        this.setArmorItems
        (
            new InventoryItem("runichelmet"),
            new InventoryItem("tungstenchestplate"), 
            new InventoryItem("tungstenboots")
        );
    }

    public void serverTick()
    {
        super.serverTick();
        this.addBuff(new ActiveBuff(BuffRegistry.getBuff("ivyhoodsetbonus"), this, 10, null), true);
    }
}
