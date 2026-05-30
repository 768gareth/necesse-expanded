package NecesseExpanded.Buffs.Trinkets;

import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class EnduranceStackBuff extends Buff
{
    public EnduranceStackBuff() {
      this.isImportant = true;
      this.canCancel = false;
   }

   public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) {
   }

   public void serverTick(ActiveBuff buff) 
   {
      buff.setModifier(BuffModifiers.RESILIENCE_GAIN, (Float) 0.01f * buff.owner.buffManager.getStacks(this));
   }

   public int getStackSize(ActiveBuff buff) {
      return 10;
   }

   public boolean overridesStackDuration() {
      return true;
   }

   public boolean showsFirstStackDurationText() {
      return super.showsFirstStackDurationText();
   }
}
