package NecesseExpanded.Raids.DuskDawnKnights.Tier3.Buffs;

import necesse.engine.localization.Localization;
import necesse.engine.util.GameBlackboard;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;
import necesse.gfx.gameTooltips.ListGameTooltips;

public class Sunscorched extends Buff
{
    public Sunscorched()
    {
        this.canCancel = false;
        this.isVisible = true;
        this.isImportant = false;
    }

    @Override
    public void init(ActiveBuff Buff, BuffEventSubscriber Subscriber) 
    {
        Buff.setModifier(BuffModifiers.ARMOR_FLAT, -10);
    }

    public ListGameTooltips getTooltip(ActiveBuff ab, GameBlackboard blackboard) 
    {
        ListGameTooltips tooltips = super.getTooltip(ab, blackboard);
        tooltips.add(Localization.translate("bufftooltip", "sunscorching"));
        return tooltips;
    }
}
