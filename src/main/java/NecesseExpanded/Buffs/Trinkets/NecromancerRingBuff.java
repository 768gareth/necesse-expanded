package NecesseExpanded.Buffs.Trinkets;

import NecesseExpanded.Mobs.Friendly.Summons.NecromancerMinion;
import necesse.engine.localization.Localization;
import necesse.entity.mobs.MobWasKilledEvent;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.WormMobBody;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.trinketBuffs.TrinketBuff;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.trinketItem.TrinketItem;

public class NecromancerRingBuff extends TrinketBuff
{
    public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) 
    {}

    public void onHasKilledTarget(ActiveBuff buff, MobWasKilledEvent event) 
    {
      if (!event.target.isBoss() && !(event.target instanceof WormMobBody))
      {
        event.target.getLevel().entityManager.addMob(new NecromancerMinion(), event.target.x, event.target.y);
      }
    }

    public ListGameTooltips getTrinketTooltip(TrinketItem trinketItem, InventoryItem item, PlayerMob perspective) 
    {
      ListGameTooltips tooltips = super.getTrinketTooltip(trinketItem, item, perspective);
      tooltips.add(Localization.translate("itemtooltip", "necromancer_ring_tip"));
      return tooltips;
    }
}
