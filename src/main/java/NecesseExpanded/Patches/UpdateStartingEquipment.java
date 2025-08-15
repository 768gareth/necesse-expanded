package NecesseExpanded.Patches;

import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.LootTablePresets;
import necesse.inventory.lootTable.lootItem.LootItem;

public class UpdateStartingEquipment 
{
    public static void Update()
    {
        if (NecesseExpanded.Main.Options.isStarterEquipmentChangesEnabled)
        {
            System.out.println("[NECESSE EXPANDED] Updating starter chest equipment...");
            LootTablePresets.startChest = new LootTable
            (
                new LootItemInterface[]
                {
                    (LootItemInterface)new LootItem("settlementflag"), 
                    (LootItemInterface)new LootItem("coin", 500), 
                    (LootItemInterface)new LootItem("sprucelog", 250), 
                    (LootItemInterface)new LootItem("stone", 150), 
                    (LootItemInterface)new LootItem("torch", 25), 
                    (LootItemInterface)new LootItem("farmland", 20), 
                    (LootItemInterface)new LootItem("cornseed", 10), 
                    (LootItemInterface)new LootItem("wheatseed", 10), 
                    (LootItemInterface)new LootItem("bread", 10), 
                    (LootItemInterface)new LootItem("storagebox", 3),
                    (LootItemInterface)new LootItem("sprucebed", 3), 
                    (LootItemInterface)new LootItem("grainmill"), 
                    (LootItemInterface)new LootItem("ironanvil"), 
                    (LootItemInterface)new LootItem("forge")
                }
            );
        }
    }
}
