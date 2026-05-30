package NecesseExpanded.Patches.Gameplay;

import java.util.HashSet;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.Attacker;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.friendly.human.HumanMob;
import necesse.level.maps.levelData.settlementData.LevelSettler;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModMethodPatch(target = HumanMob.class, name = "onDeath", arguments = {Attacker.class, HashSet.class})
public class SettlerDeathHappinessPenalty 
{
    @OnMethodExit
    static void onExit(@This HumanMob ThisSettler)
    {
        if (ThisSettler.getSettlementServerData() != null && NecesseExpanded.Main.SettingsGetter.getBoolean("happiness_changes_enabled"))
        {
            for (LevelSettler Settler : ThisSettler.getSettlementServerData().settlers)
            {
                Settler.getMob().getMob().buffManager.addBuff(new ActiveBuff("settler_death_penalty", Settler.getMob().getMob(), 600f, Settler.getMob().getMob()), true);
            }
        }
    }
}
