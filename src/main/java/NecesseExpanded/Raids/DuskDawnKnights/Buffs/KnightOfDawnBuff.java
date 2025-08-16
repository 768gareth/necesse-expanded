package NecesseExpanded.Raids.DuskDawnKnights.Buffs;

import necesse.engine.registries.BuffRegistry;
import necesse.entity.mobs.MobWasHitEvent;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class KnightOfDawnBuff extends Buff
{
    @Override
    public void init(ActiveBuff Buff, BuffEventSubscriber Subscriber) {}

    public void onHasAttacked(ActiveBuff Buff, MobWasHitEvent Event)
    {
        super.onHasAttacked(Buff, Event);
        if (!Event.wasPrevented)
        {
            Event.target.buffManager.addBuff(new ActiveBuff(BuffRegistry.getBuff("sunscorched"), Event.target, 8.0F, Event.attacker), true);
        }
    } 
}
