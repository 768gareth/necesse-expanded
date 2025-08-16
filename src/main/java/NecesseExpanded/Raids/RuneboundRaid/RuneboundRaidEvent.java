package NecesseExpanded.Raids.RuneboundRaid;

import necesse.engine.localization.Localization;
import necesse.engine.localization.message.GameMessage;
import necesse.engine.localization.message.LocalMessage;
import necesse.engine.util.GameRandom;
import necesse.entity.levelEvent.settlementRaidEvent.SettlementRaidLevelEvent;
import necesse.level.maps.levelData.settlementData.SettlementLevelData;
import necesse.level.maps.levelData.settlementData.SettlementRaidLoadout;
import necesse.level.maps.levelData.settlementData.SettlementRaidOptions;

public class RuneboundRaidEvent extends SettlementRaidLevelEvent
{
    GameRandom LocalRandom = new GameRandom();

    @Override
    public GameMessage getApproachMessage(GameMessage settlementName, boolean isFirst) {
        return (GameMessage) new LocalMessage("misc", "raidapproaching", new Object[] {
            "settlement", settlementName,
            "direction", this.direction.displayName,
            "raidtype", Localization.translate("misc", "runeboundraidertype")
        });
    }
    
    @Override
    public GameMessage getPreparingMessage(GameMessage settlementName) {
        return (GameMessage) new LocalMessage("misc", "raidpreparing", new Object[] {
            "settlement", settlementName,
            "raidtype", Localization.translate("misc", "runeboundraidertype")
        });
    }
    
    @Override
    public GameMessage getStartMessage(GameMessage settlementName) {
        return (GameMessage) new LocalMessage("misc", "raidattacking", new Object[] {
            "settlement", settlementName,
            "raidtype", Localization.translate("misc", "runeboundraidertype")
        });
    }
    
    @Override
    public GameMessage getDefeatedMessage() {
        return (GameMessage) new LocalMessage("misc", "raiddefeated", "raidtype",
            Localization.translate("misc", "runeboundraidertype"));
    }
    
    @Override
    public GameMessage getLeavingMessage() {
        return (GameMessage) new LocalMessage("misc", "raidended", "raidtype",
            Localization.translate("misc", "runeboundraidertype"));
    }
    
    @Override
    public GameMessage getLeavingWithLootMessage() {
        return (GameMessage) new LocalMessage("misc", "raidlooting", "raidtype",
            Localization.translate("misc", "runeboundraidertype"));
    }

    public RuneboundRaidEvent() {}

    public RuneboundRaidEvent(SettlementLevelData Data, SettlementRaidOptions Options)
    {
        float ServerDifficultyModifer = Data.getLevel().getServer().world.settings.difficulty.raiderDamageModifier;
        float RaidMultiplier = NecesseExpanded.Main.Options.RaidMultiplier;
        float RaidSize = Data.countTotalSettlers() * 2 * ServerDifficultyModifer * Options.difficultyModifier * RaidMultiplier;

        if (Data.hasCompletedQuestTier("fallenwizard"))
        {
            for (int Raiders = 0; Raiders < RaidSize + 8; Raiders++)
            {
                if (Raiders == 0)
                {
                    this.loadouts.add(new SettlementRaidLoadout("raider_summoner_tier3"));
                }
                else if (Raiders % 6 == 0)
                {
                    this.loadouts.add(new SettlementRaidLoadout("raider_berserker_tier3"));
                }
                this.loadouts.add
                (
                    GameRandom.globalRandom.getOneOf
                    (
                        new SettlementRaidLoadout("raider_magic_tier3"),
                        new SettlementRaidLoadout("raider_melee_tier3"),
                        new SettlementRaidLoadout("raider_ranged_tier3")
                    )
                );
            };
        }

        else if (Data.hasCompletedQuestTier("piratecaptain"))
        {
            for (int Raiders = 0; Raiders < RaidSize + 4; Raiders++)
            {
                if (Raiders == 0)
                {
                    this.loadouts.add(new SettlementRaidLoadout("raider_summoner_tier2"));
                }
                else if (Raiders % 6 == 0)
                {
                    this.loadouts.add(new SettlementRaidLoadout("raider_berserker_tier2"));
                }
                this.loadouts.add
                (
                    GameRandom.globalRandom.getOneOf
                    (
                        new SettlementRaidLoadout("raider_magic_tier2"),
                        new SettlementRaidLoadout("raider_melee_tier2"),
                        new SettlementRaidLoadout("raider_ranged_tier2")
                    )
                );
            };
        }

        else
        {
            for (int Raiders = 0; Raiders < RaidSize + 2; Raiders++)
            {
                if (Raiders == 0)
                {
                    this.loadouts.add(new SettlementRaidLoadout("raider_summoner_tier1"));
                }
                else if (Raiders % 6 == 0)
                {
                    this.loadouts.add(new SettlementRaidLoadout("raider_berserker_tier1"));
                }
                this.loadouts.add
                (
                    GameRandom.globalRandom.getOneOf
                    (
                        new SettlementRaidLoadout("raider_magic_tier1"),
                        new SettlementRaidLoadout("raider_melee_tier1"),
                        new SettlementRaidLoadout("raider_ranged_tier1")
                    )
                );
            };
        }
    }
}