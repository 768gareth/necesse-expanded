package NecesseExpanded.Registration;

import NecesseExpanded.Raids.DuskDawnKnights.Buffs.*;
import necesse.engine.registries.BuffRegistry;

public class RegisterBuffs 
{
    public static void Register()
    {
        if (NecesseExpanded.Main.Options.isNewRaidSystemEnabled)
        {
            BuffRegistry.registerBuff("moonscorched", new Moonscorched());
            BuffRegistry.registerBuff("sunscorched", new Sunscorched());
            BuffRegistry.registerBuff("knightofdawnbuff", new KnightOfDawnBuff());
            BuffRegistry.registerBuff("knightofduskbuff", new KnightOfDuskBuff());
        }
    }
}
