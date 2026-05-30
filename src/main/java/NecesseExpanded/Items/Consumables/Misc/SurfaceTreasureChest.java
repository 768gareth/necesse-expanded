package NecesseExpanded.Items.Consumables.Misc;

import necesse.engine.localization.Localization;
import necesse.engine.network.gameNetworkData.GNDItemMap;
import necesse.engine.util.GameBlackboard;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.itemAttacker.ItemAttackSlot;
import necesse.entity.mobs.itemAttacker.ItemAttackerMob;
import necesse.entity.pickup.ItemPickupEntity;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.placeableItem.PlaceableItem;
import necesse.inventory.lootTable.LootList;
import necesse.inventory.lootTable.presets.CaveChestLootTable;
import necesse.level.maps.Level;

public class SurfaceTreasureChest extends PlaceableItem
{
    public SurfaceTreasureChest() 
    {
        super(99, true);
        this.rarity = Item.Rarity.COMMON;
    }

    public InventoryItem onAttack(Level level, int x, int y, ItemAttackerMob attackerMob, int attackHeight, InventoryItem item, ItemAttackSlot slot, int animAttack, int seed, GNDItemMap mapContent)
    {
        LootList List = new LootList();
        CaveChestLootTable.basicVinyls.addPossibleLoot(List, new Object[0]);
        CaveChestLootTable.desertVinyls.addPossibleLoot(List, new Object[0]);
        CaveChestLootTable.swampVinyls.addPossibleLoot(List, new Object[0]);
        CaveChestLootTable.snowVinyls.addPossibleLoot(List, new Object[0]);
        CaveChestLootTable.plainsVinyls.addPossibleLoot(List, new Object[0]);
        InventoryItem Vinyl = List.getCombinedItemsAndCustomItems().get(GameRandom.globalRandom.getIntBetween(0, List.getCombinedItemsAndCustomItems().size() - 1));
        ItemPickupEntity VinylPickup = Vinyl.getPickupEntity(level, attackerMob.x, attackerMob.y);
        level.entityManager.pickups.add(VinylPickup);
        item.setAmount(item.getAmount() - 1);
        return item;
    }

    public ListGameTooltips getTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
      ListGameTooltips tooltips = super.getTooltips(item, perspective, blackboard);
      tooltips.add(Localization.translate("itemtooltip", "treasure_chest"));
      tooltips.add(Localization.translate("itemtooltip", "chest_tip"));
      return tooltips;
   }
}
