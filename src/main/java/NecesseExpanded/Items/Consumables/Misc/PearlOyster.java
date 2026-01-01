package NecesseExpanded.Items.Consumables.Misc;

import necesse.engine.localization.Localization;
import necesse.engine.network.gameNetworkData.GNDItemMap;
import necesse.engine.util.GameBlackboard;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.itemAttacker.ItemAttackSlot;
import necesse.entity.mobs.itemAttacker.ItemAttackerMob;
import necesse.entity.pickup.ItemPickupEntity;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.placeableItem.PlaceableItem;
import necesse.level.maps.Level;

public class PearlOyster extends PlaceableItem
{
    public PearlOyster() 
    {
        super(99, true);
        this.rarity = Item.Rarity.RARE;
    }

    public InventoryItem onAttack(Level level, int x, int y, ItemAttackerMob attackerMob, int attackHeight, InventoryItem item, ItemAttackSlot slot, int animAttack, int seed, GNDItemMap mapContent)
    {
        InventoryItem Pearl = new InventoryItem("pearl");
        ItemPickupEntity TreasureEntity = Pearl.getPickupEntity(level, attackerMob.x, attackerMob.y);
        level.entityManager.pickups.add(TreasureEntity);
        item.setAmount(item.getAmount() - 1);
        return item;
    }

    public ListGameTooltips getTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
      ListGameTooltips tooltips = super.getTooltips(item, perspective, blackboard);
      tooltips.add(Localization.translate("itemtooltip", "pearl_oyster"));
      tooltips.add(Localization.translate("itemtooltip", "pearl_oyster_tip"));
      return tooltips;
   }
}
