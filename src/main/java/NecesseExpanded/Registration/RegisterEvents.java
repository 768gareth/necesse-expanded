package NecesseExpanded.Registration;

import NecesseExpanded.Raids.DuskDawnKnights.KnightRaid;
import NecesseExpanded.Raids.NecromancerRaid.NecromancerRaid;
import NecesseExpanded.Raids.RuneboundRaid.RuneboundRaidEvent;
import necesse.engine.registries.LevelEventRegistry;

public class RegisterEvents 
{
    public static void Register()
    {
        if (NecesseExpanded.Main.Options.isNewRaidSystemEnabled)
        {
            System.out.println("[NECESSE EXPANDED] Registering custom raid events...");
            LevelEventRegistry.registerEvent("runeboundraid", RuneboundRaidEvent.class);
            LevelEventRegistry.registerEvent("necromancerraid", NecromancerRaid.class);
            LevelEventRegistry.registerEvent("knightsraid", KnightRaid.class);
        }
    }
}
