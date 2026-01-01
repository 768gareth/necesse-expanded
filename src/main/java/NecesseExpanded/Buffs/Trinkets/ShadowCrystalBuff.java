package NecesseExpanded.Buffs.Trinkets;

import necesse.engine.localization.Localization;
import necesse.entity.mobs.MobWasKilledEvent;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.trinketBuffs.TrinketBuff;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.trinketItem.TrinketItem;

public class ShadowCrystalBuff extends TrinketBuff
{
    public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) {}

    public void onHasKilledTarget(ActiveBuff buff, MobWasKilledEvent event) 
    {
        buff.owner.buffManager.addBuff(new ActiveBuff("shadow_crystal_bonus", buff.owner, 10F, null), true);
    }

    public ListGameTooltips getTrinketTooltip(TrinketItem trinketItem, InventoryItem item, PlayerMob perspective) {
    ListGameTooltips tooltips = super.getTrinketTooltip(trinketItem, item, perspective);
    tooltips.add(Localization.translate("itemtooltip", "shadow_crystal_tooltip"));
    return tooltips;
  }
}
