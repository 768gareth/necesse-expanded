package NecesseExpanded;

import NecesseExpanded.Patches.UpdateStartingEquipment;
import NecesseExpanded.Registration.*;
import NecesseExpanded.Settlements.SettlerHappiness;
import necesse.engine.modLoader.ModSettings;
import necesse.engine.modLoader.annotations.ModEntry;

@ModEntry
public class Main 
{
    public static NecesseExpandedSettings Options;
    
    public void init()
    {
        System.out.println("[NECESSE EXPANDED] Initialising mod...");

        RegisterEvents.Register();
        RegisterMobs.Register();
        RegisterCraftingRecipes.Register();
        SettlerHappiness.Update();
    }

    public void postInit()
    {
        UpdateStartingEquipment.Update();
    }

    public ModSettings initSettings() 
    {
        Options = new NecesseExpandedSettings();
        return Options;
    }
}
