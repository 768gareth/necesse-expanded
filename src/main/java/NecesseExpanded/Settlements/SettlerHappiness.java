package NecesseExpanded.Settlements;

import necesse.engine.localization.message.LocalMessage;
import necesse.level.maps.levelData.settlementData.settler.PopulationThought;
import necesse.level.maps.levelData.settlementData.settler.RoomSize;
import necesse.level.maps.levelData.settlementData.settler.Settler;

public class SettlerHappiness 
{
    public static void Update()
    {
        if (NecesseExpanded.Main.Options.isSettlementChangesEnabled)
        {
            System.out.println("[NECESSE EXPANDED] Configuring settler happiness metrics...");

            Settler.roomSizes.clear();
            Settler.roomSizes.add(new RoomSize(new LocalMessage("settlement", "sizebaby"), 0, 0));
            Settler.roomSizes.add(new RoomSize(new LocalMessage("settlement", "sizetiny"), 4, 5));
            Settler.roomSizes.add(new RoomSize(new LocalMessage("settlement", "sizesmall"), 9, 10));
            Settler.roomSizes.add(new RoomSize(new LocalMessage("settlement", "sizedecent"), 16, 15));
            Settler.roomSizes.add(new RoomSize(new LocalMessage("settlement", "sizelarge"), 25, 20));
    
            Settler.populationThoughts.clear();
            Settler.populationThoughts.add(new PopulationThought(new LocalMessage("settlement", "tinysettlement"), 0, 0));
            Settler.populationThoughts.add(new PopulationThought(new LocalMessage("settlement", "smallsettlement"), 5, 5));
            Settler.populationThoughts.add(new PopulationThought(new LocalMessage("settlement", "averagesettlement"), 10, 10));
            Settler.populationThoughts.add(new PopulationThought(new LocalMessage("settlement", "largesettlement"), 15, 15));
            Settler.populationThoughts.add(new PopulationThought(new LocalMessage("settlement", "hugesettlement"), 20, 20));
        }
    }
}
