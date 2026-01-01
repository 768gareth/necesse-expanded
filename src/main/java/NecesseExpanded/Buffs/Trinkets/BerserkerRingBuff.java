package NecesseExpanded.Buffs.Trinkets;

import necesse.engine.localization.Localization;
import necesse.entity.mobs.MobWasHitEvent;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.trinketBuffs.TrinketBuff;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.trinketItem.TrinketItem;

public class BerserkerRingBuff extends TrinketBuff
{
    public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) {}

    public void onWasHit(ActiveBuff buff, MobWasHitEvent event)
    {
        buff.owner.buffManager.addBuff(new ActiveBuff("endurance_stack_buff", buff.owner, 10f, buff.owner), true);
    }

    public ListGameTooltips getTrinketTooltip(TrinketItem trinketItem, InventoryItem item, PlayerMob perspective) 
    {
        ListGameTooltips tooltips = super.getTrinketTooltip(trinketItem, item, perspective);
        tooltips.add(Localization.translate("itemtooltip", "berserker_ring_tooltip"));
        return tooltips;
    }
}
