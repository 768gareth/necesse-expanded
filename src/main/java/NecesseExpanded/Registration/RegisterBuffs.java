package NecesseExpanded.Registration;

import NecesseExpanded.Raids.DuskDawnKnights.Tier3.Buffs.Moonscorched;
import NecesseExpanded.Raids.DuskDawnKnights.Tier3.Buffs.Sunscorched;
import necesse.engine.registries.BuffRegistry;

public class RegisterBuffs 
{
    public static void Register()
    {
        if (NecesseExpanded.Main.Options.isNewRaidSystemEnabled)
        {
            BuffRegistry.registerBuff("moonscorched", new Moonscorched());
            BuffRegistry.registerBuff("sunscorched", new Sunscorched());
        }
    }
}
