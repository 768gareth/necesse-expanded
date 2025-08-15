package NecesseExpanded.Raids.NecromancerRaid;

import necesse.engine.localization.Localization;
import necesse.engine.localization.message.GameMessage;
import necesse.engine.localization.message.LocalMessage;
import necesse.engine.util.GameRandom;
import necesse.entity.levelEvent.settlementRaidEvent.SettlementRaidLevelEvent;
import necesse.level.maps.levelData.settlementData.SettlementLevelData;
import necesse.level.maps.levelData.settlementData.SettlementRaidLoadout;
import necesse.level.maps.levelData.settlementData.SettlementRaidOptions;

public class NecromancerRaid extends SettlementRaidLevelEvent
{
    GameRandom LocalRandom = new GameRandom();

    @Override
    public GameMessage getApproachMessage(GameMessage settlementName, boolean isFirst) {
        return (GameMessage) new LocalMessage("misc", "raidapproaching", new Object[] {
            "settlement", settlementName,
            "direction", this.direction.displayName,
            "raidtype", Localization.translate("misc", "necromancerraidertype")
        });
    }
    
    @Override
    public GameMessage getPreparingMessage(GameMessage settlementName) {
        return (GameMessage) new LocalMessage("misc", "raidpreparing", new Object[] {
            "settlement", settlementName,
            "raidtype", Localization.translate("misc", "necromancerraidertype")
        });
    }
    
    @Override
    public GameMessage getStartMessage(GameMessage settlementName) {
        return (GameMessage) new LocalMessage("misc", "raidattacking", new Object[] {
            "settlement", settlementName,
            "raidtype", Localization.translate("misc", "necromancerraidertype")
        });
    }
    
    @Override
    public GameMessage getDefeatedMessage() {
        return (GameMessage) new LocalMessage("misc", "raiddefeated", "raidtype",
            Localization.translate("misc", "necromancerraidertype"));
    }
    
    @Override
    public GameMessage getLeavingMessage() {
        return (GameMessage) new LocalMessage("misc", "raidended", "raidtype",
            Localization.translate("misc", "necromancerraidertype"));
    }
    
    @Override
    public GameMessage getLeavingWithLootMessage() {
        return (GameMessage) new LocalMessage("misc", "raidlooting", "raidtype",
            Localization.translate("misc", "necromancerraidertype"));
    }

    public NecromancerRaid() {}

    public NecromancerRaid(SettlementLevelData Data, SettlementRaidOptions Options)
    {
        float ServerDifficultyModifer = Data.getLevel().getServer().world.settings.difficulty.raiderDamageModifier;
        float RaidMultiplier = NecesseExpanded.Main.Options.RaidMultiplier;
        float RaidSize = Data.countTotalSettlers() * ServerDifficultyModifer * Options.difficultyModifier * RaidMultiplier;
    
        if (Data.hasCompletedQuestTier("fallenwizard")) // Tier 3
        {
            for (int Raiders = 0; Raiders < RaidSize; Raiders++)
            {
                this.loadouts.add(new SettlementRaidLoadout("necromancer_tier3"));
            }
        }

        else if (Data.hasCompletedQuestTier("piratecaptain")) // Tier 2
        {
            for (int Raiders = 0; Raiders < RaidSize; Raiders++)
            {
                this.loadouts.add(new SettlementRaidLoadout("necromancer_tier2"));
            }
        }

        else // Tier 1
        {
            for (int Raiders = 0; Raiders < RaidSize; Raiders++)
            {
                this.loadouts.add(new SettlementRaidLoadout("necromancer_tier1"));
            }
        }
    }
}