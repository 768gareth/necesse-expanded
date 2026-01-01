package NecesseExpanded.Patches.Raids;

import NecesseExpanded.Events.Raids.*;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.util.GameRandom;
import net.bytebuddy.asm.Advice;
import necesse.level.maps.levelData.settlementData.ServerSettlementData;
import necesse.level.maps.levelData.settlementData.SettlementRaidOptions;
import necesse.entity.levelEvent.settlementRaidEvent.*;

@ModMethodPatch(target = ServerSettlementData.class, name = "getNextRaid", arguments = {SettlementRaidOptions.class})
public class RaidConfiguration
{
    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter()
    {
        if (NecesseExpanded.Main.SettingsGetter.getBoolean("raids_enabled"))
        {
            return true;
        }
        return false;
    }

    @Advice.OnMethodExit()
    static void onExit(@Advice.This ServerSettlementData LevelData, @Advice.Argument(0) SettlementRaidOptions Options, @Advice.Return(readOnly = false) SettlementRaidLevelEvent Event)
    {
        // If custom raids and vanilla raids are enabled.
        if (NecesseExpanded.Main.SettingsGetter.getBoolean("raids_enabled") && NecesseExpanded.Main.SettingsGetter.getBoolean("include_vanilla_raids"))
        {
            if (GameRandom.globalRandom.getChance((float) NecesseExpanded.Main.SettingsGetter.getInt("vanilla_raid_chance") / 100))
            {
                // Late hardmode
                if (LevelData.hasCompletedQuestTier("pestwarden"))
                {
                    Event = GameRandom.globalRandom.getOneOf
                    (
                        new HumanSettlementRaidLevelEvent(),
                        new AncientSkeletonRaidLevelEvent(),
                        new FishianSettlementRaidLevelEvent(),
                        new MummiesSettlementRaidLevelEvent(),
                        new TheMafiaRaidLevelEvent(),
                        new VoidApprenticesSettlementRaidLevelEvent(),
                        new FrozenDwarvesSettlementRaidLevelEvent(),
                        new ChickenPeopleSettlementRaidLevelEvent(),
                        new PiratesSettlementRaidLevelEvent(),
                        new NinjaSettlementRaidLevelEvent(),
                        new VampiresSettlementRaidLevelEvent(),
                        new RogueHuntersSettlementRaidLevelEvent()
                    );
                }

                // Early hardmode
                else if (LevelData.hasCompletedQuestTier("piratecaptain"))
                {
                    Event = GameRandom.globalRandom.getOneOf
                    (
                        new HumanSettlementRaidLevelEvent(),
                        new VoidApprenticesSettlementRaidLevelEvent(),
                        new FrozenDwarvesSettlementRaidLevelEvent(),
                        new ChickenPeopleSettlementRaidLevelEvent(),
                        new PiratesSettlementRaidLevelEvent(),
                        new NinjaSettlementRaidLevelEvent(),
                        new VampiresSettlementRaidLevelEvent(),
                        new RogueHuntersSettlementRaidLevelEvent()
                    );
                }

                // Mid normal mode
                else if (LevelData.hasCompletedQuestTier("voidwizard"))
                {
                    Event = GameRandom.globalRandom.getOneOf
                    (
                        new HumanSettlementRaidLevelEvent(),
                        new ChickenPeopleSettlementRaidLevelEvent(),
                        new PiratesSettlementRaidLevelEvent(),
                        new NinjaSettlementRaidLevelEvent(),
                        new VampiresSettlementRaidLevelEvent(),
                        new RogueHuntersSettlementRaidLevelEvent()
                    );
                }

                // Early normal mode: Just human raiders and rogue hunters.
                else
                {
                    Event = GameRandom.globalRandom.getOneOf
                    (
                        new HumanSettlementRaidLevelEvent(),
                        new RogueHuntersSettlementRaidLevelEvent()
                    );
                }
            }
            else
            {
                Event = GetCustomRaid(LevelData, Options);
            }
        }
        
        // If custom raids are enabled but vanilla raids disabled.
        else if (NecesseExpanded.Main.SettingsGetter.getBoolean("raids_enabled") && !NecesseExpanded.Main.SettingsGetter.getBoolean("include_vanilla_raids"))
        {
            Event = GetCustomRaid(LevelData, Options);
        }

        // If custom raids are disabled, then we just use the vanilla raid system instead.
    }

    public static SettlementRaidLevelEvent GetCustomRaid(ServerSettlementData LevelData, SettlementRaidOptions Options)
    {
        // Incursion raid options
        if (LevelData.hasCompletedQuestTier("fallenwizard"))
        {
            return GameRandom.globalRandom.getOneOf
            (
                new SpiderkinRaid(LevelData, Options),
                new SlimeCaveRaid(LevelData, Options),
                new GraveyardRaid(LevelData, Options)
            );
        }

        // Late hardmode options.
        else if (LevelData.hasCompletedQuestTier("pestwarden"))
        {
            return new AncientSkeletonRaid(LevelData, Options);
            // Fishian raiders
        }

        // Early hardmode options.
        else if (LevelData.hasCompletedQuestTier("piratecaptain"))
        {
            return GameRandom.globalRandom.getOneOf
            (
                new SkeletonRaid(LevelData, Options),
                new NinjaRaid(LevelData, Options)
            );
        }

        // Late normal mode.
        else if (LevelData.hasCompletedQuestTier("swampguardian"))
        {
            return GameRandom.globalRandom.getOneOf
            (
                new PirateRaid(LevelData, Options),
                new RuneboundRaid(LevelData, Options)
                // Frozen dwarf raiders
            );
        }

        // Early normal mode.
        else
        {
            return new ZombieRaid(LevelData, Options);
            // Goblin raiders
        }
    }
}