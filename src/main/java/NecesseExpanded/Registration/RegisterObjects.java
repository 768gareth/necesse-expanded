package NecesseExpanded.Registration;

import NecesseExpanded.Settlements.Objects.Keg;
import necesse.engine.registries.ObjectRegistry;

public class RegisterObjects 
{
    public static void Register()
    {
        if (NecesseExpanded.Main.Options.isSettlementChangesEnabled)
        {
            ObjectRegistry.registerObject("keg", new Keg(), 10, true);
        }
    }
}
