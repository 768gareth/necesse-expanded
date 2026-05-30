package NecesseExpanded.Registry;

import NecesseExpanded.World.Levels.FishianDeepCaveLevel;
import necesse.engine.registries.LevelRegistry;

public class RegisterLevels 
{
    public static void Register()
    {
        System.out.println("[Necesse Expanded] Registering new levels...");

        LevelRegistry.registerLevel("fishian_dungeon", FishianDeepCaveLevel.class);
    }
}
