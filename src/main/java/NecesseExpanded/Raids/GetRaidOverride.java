package NecesseExpanded.Raids;

import NecesseExpanded.Raids.DuskDawnKnights.KnightRaid;
import NecesseExpanded.Raids.NecromancerRaid.NecromancerRaid;
import NecesseExpanded.Raids.RuneboundRaid.RuneboundRaidEvent;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.util.GameRandom;
import net.bytebuddy.asm.Advice;
import necesse.level.maps.levelData.settlementData.SettlementLevelData;
import necesse.level.maps.levelData.settlementData.SettlementRaidOptions;
import necesse.entity.levelEvent.settlementRaidEvent.SettlementRaidLevelEvent;

@ModMethodPatch(target = SettlementLevelData.class, name = "getNextRaid", arguments = {SettlementRaidOptions.class})
public class GetRaidOverride
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
    static void onExit(@Advice.This SettlementLevelData LevelData, @Advice.Argument(0) SettlementRaidOptions Options, @Advice.Return(readOnly = false) SettlementRaidLevelEvent Event)
    {
        if (NecesseExpanded.Main.Options.isNewRaidSystemEnabled)
        {
            System.out.println("[NECESSE EXPANDED] Generating new complex raid...");
            if (Options.wealthCounter.getBestWeaponValue() > 1750.0)
            {
                Event = new KnightRaid(LevelData, Options);
            }
            else
            {
                Event = GameRandom.globalRandom.getOneOf
                (
                    new RuneboundRaidEvent(LevelData, Options),
                    new NecromancerRaid(LevelData, Options)
                );
            }
        }
    }
}