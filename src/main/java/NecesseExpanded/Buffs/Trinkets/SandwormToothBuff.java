package NecesseExpanded.Buffs.Trinkets;

import necesse.engine.localization.Localization;
import necesse.engine.registries.BuffRegistry;
import necesse.engine.registries.DamageTypeRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.MobWasHitEvent;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.trinketBuffs.TrinketBuff;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.trinketItem.TrinketItem;

public class SandwormToothBuff extends TrinketBuff
{
    public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) {}

    public void onHasAttacked(ActiveBuff buff, MobWasHitEvent event) 
    {
        if (!event.wasPrevented && event.damageType == DamageTypeRegistry.MELEE && GameRandom.globalRandom.getChance(0.25F))
        {
            event.target.buffManager.addBuff(new ActiveBuff(BuffRegistry.Debuffs.SAND_KNIFE_WOUND_BUFF, event.target, 1.0F, event.attacker), event.target.isServer());
        }
    }

    public ListGameTooltips getTrinketTooltip(TrinketItem trinketItem, InventoryItem item, PlayerMob perspective) {
    ListGameTooltips tooltips = super.getTrinketTooltip(trinketItem, item, perspective);
    tooltips.add(Localization.translate("itemtooltip", "sandworm_tooth_tooltip"));
    return tooltips;
    }
}
