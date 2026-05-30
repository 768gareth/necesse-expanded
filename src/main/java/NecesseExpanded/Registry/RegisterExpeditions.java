package NecesseExpanded.Registry;

import necesse.engine.expeditions.TypesFishingTripExpedition;
import necesse.engine.registries.ExpeditionMissionRegistry;

public class RegisterExpeditions 
{
    public static void Register()
    {
        System.out.println("[Necesse Expanded] Registering new expeditions...");
        ExpeditionMissionRegistry.registerFishingTrip("demonfish_expedition", new TypesFishingTripExpedition("voidwizard", 400, 300, 400, "demonfish", new String[]{"rockfish", "terrorfish", "cave_treasure_chest"}));
        ExpeditionMissionRegistry.registerFishingTrip("heartfish_expedition", new TypesFishingTripExpedition("reaper", 600, 500, 600, "heartfish", new String[]{"rockfish", "terrorfish", "demonfish", "cave_treasure_chest", "deep_treasure_chest"}));
        ExpeditionMissionRegistry.registerFishingTrip("glacierfish_expedition", new TypesFishingTripExpedition("cryoqueen", 600, 500, 600, "glacierfish", new String[]{"rockfish", "terrorfish", "demonfish", "heartfish", "cave_treasure_chest", "deep_treasure_chest"}));
        ExpeditionMissionRegistry.registerFishingTrip("seaweed_expedition", new TypesFishingTripExpedition((String)null, 200, 50, 100, "seaweed", new String[]{ "oyster", "pearl_oyster"}));
        ExpeditionMissionRegistry.registerFishingTrip("surface_treasure", new TypesFishingTripExpedition((String)null, 200, 100, 200, "surface_treasure_chest"));
        ExpeditionMissionRegistry.registerFishingTrip("cave_treasure", new TypesFishingTripExpedition("piratecaptain", 400, 200, 400, "cave_treasure_chest"));
        ExpeditionMissionRegistry.registerFishingTrip("deep_treasure", new TypesFishingTripExpedition("fallenwizard", 800, 400, 800, "deep_treasure_chest"));
        ExpeditionMissionRegistry.registerFishingTrip("incursion_treasure", new TypesFishingTripExpedition("fallenwizard", 1200, 600, 1200, "incursion_treasure_chest"));
    }
}
