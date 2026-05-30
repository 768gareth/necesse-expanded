package NecesseExpanded.Buffs.Trinkets;

import necesse.engine.localization.Localization;
import necesse.entity.levelEvent.LevelEvent;
import necesse.entity.levelEvent.mobAbilityLevelEvent.MobManaChangeEvent;
import necesse.entity.mobs.MobWasHitEvent;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.trinketBuffs.TrinketBuff;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.trinketItem.TrinketItem;

public class ForgottenRelicBuff extends TrinketBuff {
    public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) 
    {

    }

    public void onWasHit(ActiveBuff buff, MobWasHitEvent event) 
    {
        buff.owner.getLevel().entityManager.events.add((LevelEvent) new MobManaChangeEvent(buff.owner, Math.max(1, event.damage / 10)));
    }

    public ListGameTooltips getTrinketTooltip(TrinketItem trinketItem, InventoryItem item, PlayerMob perspective) {
        ListGameTooltips tooltips = super.getTrinketTooltip(trinketItem, item, perspective);
        tooltips.add(Localization.translate("itemtooltip", "forgotten_relic_tooltip"));
        tooltips.add(Localization.translate("itemtooltip", "forgotten_relic_lore_tooltip"));
        return tooltips;
    }
}
