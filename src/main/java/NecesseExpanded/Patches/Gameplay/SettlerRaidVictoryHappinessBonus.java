package NecesseExpanded.Patches.Gameplay;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.levelEvent.settlementRaidEvent.SettlementRaidLevelEvent;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.level.maps.levelData.settlementData.LevelSettler;
import necesse.level.maps.levelData.settlementData.ServerSettlementData;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModMethodPatch(target = ServerSettlementData.class, name = "onRaidOver", arguments = {SettlementRaidLevelEvent.class, float.class})
public class SettlerRaidVictoryHappinessBonus
{
    @OnMethodExit
    static void onExit(@This ServerSettlementData Settlement)
    {
        if (Settlement != null && NecesseExpanded.Main.SettingsGetter.getBoolean("happiness_changes_enabled"))
        {
            for (LevelSettler Settler : Settlement.settlers)
            {
                Settler.getMob().getMob().buffManager.addBuff(new ActiveBuff("settler_raid_bonus", Settler.getMob().getMob(), 600f, Settler.getMob().getMob()), true);
            }
        }
    }
}
