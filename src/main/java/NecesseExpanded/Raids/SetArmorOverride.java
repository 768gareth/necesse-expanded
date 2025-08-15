package NecesseExpanded.Raids;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.hostile.ItemAttackerRaiderMob;
import net.bytebuddy.asm.Advice;

@ModMethodPatch(target = ItemAttackerRaiderMob.class, name = "updateArmor", arguments = {})
public class SetArmorOverride 
{
    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter()
    {
        if (NecesseExpanded.Main.Options.isNewRaidSystemEnabled)
        {
            return true;
        }
        return false;
    }

    @Advice.OnMethodExit()
    static void onExit(@Advice.This ItemAttackerRaiderMob ThisMob)
    {
        if (NecesseExpanded.Main.Options.isNewRaidSystemEnabled)
        {
            if (ThisMob.canEquipArmor) 
            {
                ThisMob.equipmentBuffManager.updateArmorBuffs();
                ThisMob.equipmentBuffManager.updateCosmeticSetBonus();
                ThisMob.equipmentBuffManager.updateTrinketBuffs();
            }
    
            int CurrentHealth = ThisMob.getHealth();
            float HealthPercent = ThisMob.getHealth() / ThisMob.getMaxHealth();
            ThisMob.setHealthHidden(Math.max(CurrentHealth, (int)(ThisMob.getMaxHealth() * HealthPercent)));
        }
    }
}
