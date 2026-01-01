package NecesseExpanded.Journal;

import java.util.ArrayList;
import java.util.Iterator;

import necesse.engine.journal.ItemObtainedJournalChallenge;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootList;
import necesse.inventory.lootTable.presets.PirateChestLootTable;

public class PirateTrinketChallenge extends ItemObtainedJournalChallenge {
    public PirateTrinketChallenge() 
    {
       super(new String[0]);
    }
 
    @SuppressWarnings("rawtypes")
    public void onChallengeRegistryClosed() 
    {
       super.onChallengeRegistryClosed();
       @SuppressWarnings({ "unchecked" })
       ArrayList<String> itemStringIDs = new ArrayList();
       LootList list = new LootList();
       PirateChestLootTable.mainItems.addPossibleLoot(list, new Object[0]);
       Iterator var3 = list.getCombinedItemsAndCustomItems().iterator();
 
       while(var3.hasNext()) {
          InventoryItem invItem = (InventoryItem)var3.next();
          if (invItem.item.isTrinketItem()) {
             itemStringIDs.add(invItem.item.getStringID());
          }
       }
 
       this.itemStringIDs = (String[])itemStringIDs.toArray(new String[0]);
    }
 }
