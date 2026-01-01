package NecesseExpanded.Buffs.Trinkets;

import necesse.engine.localization.Localization;
import necesse.entity.levelEvent.LevelEvent;
import necesse.entity.levelEvent.mobAbilityLevelEvent.MobHealthChangeEvent;
import necesse.entity.mobs.MobWasKilledEvent;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.WormMobBody;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.trinketBuffs.TrinketBuff;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.trinketItem.TrinketItem;

public class BloodCrystalBuff extends TrinketBuff
{
    public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) {}

    public void onHasKilledTarget(ActiveBuff buff, MobWasKilledEvent event) 
    {
        if (!(event.target instanceof WormMobBody))
        {
            buff.owner.getLevel().entityManager.events.add((LevelEvent) new MobHealthChangeEvent(buff.owner, buff.owner.getMaxHealth() / 20));
        }
    }

    public ListGameTooltips getTrinketTooltip(TrinketItem trinketItem, InventoryItem item, PlayerMob perspective) 
    {
        ListGameTooltips tooltips = super.getTrinketTooltip(trinketItem, item, perspective);
        tooltips.add(Localization.translate("itemtooltip", "blood_crystal_tooltip"));
        return tooltips;
    }
}
