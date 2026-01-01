package NecesseExpanded.Registry;

import necesse.engine.localization.message.GameMessage;
import necesse.engine.localization.message.LocalMessage;
import necesse.level.maps.levelData.settlementData.settler.DietThought;
import necesse.level.maps.levelData.settlementData.settler.FoodQuality;
import necesse.level.maps.levelData.settlementData.settler.PopulationThought;
import necesse.level.maps.levelData.settlementData.settler.RoomSize;
import necesse.level.maps.levelData.settlementData.settler.Settler;

public class UpdateHappinessMetrics {
  public static void Update() 
  {
    if (NecesseExpanded.Main.SettingsGetter.getBoolean("happiness_changes_enabled"))
    {
      System.out.println("[Necesse Expanded] Configuring settler happiness...");
      Settler.roomSizes.clear();
      Settler.roomSizes.add(new RoomSize((GameMessage)new LocalMessage("settlement", "sizebaby"), 0, 0));
      Settler.roomSizes.add(new RoomSize((GameMessage)new LocalMessage("settlement", "sizetiny"), 4, 4));
      Settler.roomSizes.add(new RoomSize((GameMessage)new LocalMessage("settlement", "sizesmall"), 9, 8));
      Settler.roomSizes.add(new RoomSize((GameMessage)new LocalMessage("settlement", "sizedecent"), 16, 12));
      Settler.roomSizes.add(new RoomSize((GameMessage)new LocalMessage("settlement", "sizelarge"), 25, 16));
      Settler.roomSizes.add(new RoomSize((GameMessage)new LocalMessage("settlement", "sizehuge"), 32, 24));
      Settler.populationThoughts.clear();
      Settler.populationThoughts.add(new PopulationThought((GameMessage)new LocalMessage("settlement", "tinysettlement"), 0, 5));
      Settler.populationThoughts.add(new PopulationThought((GameMessage)new LocalMessage("settlement", "smallsettlement"), 5, 10));
      Settler.populationThoughts.add(new PopulationThought((GameMessage)new LocalMessage("settlement", "averagesettlement"), 10, 15));
      Settler.populationThoughts.add(new PopulationThought((GameMessage)new LocalMessage("settlement", "largesettlement"), 15, 20));
      Settler.populationThoughts.add(new PopulationThought((GameMessage)new LocalMessage("settlement", "hugesettlement"), 20, 25));
      Settler.FOOD_SIMPLE = new FoodQuality((GameMessage)new LocalMessage("settlement", "foodsimple"), 8, "B-C-A", new String[] { "simple" });
      Settler.FOOD_FINE = new FoodQuality((GameMessage)new LocalMessage("settlement", "foodfine"), 12, "B-C-B", new String[] { "fine" });
      Settler.FOOD_GOURMET = new FoodQuality((GameMessage)new LocalMessage("settlement", "foodgourmet"), 18, "B-C-C", new String[] { "gourmet" });
      Settler.dietThoughts.clear();
      Settler.dietThoughts.add(new DietThought((GameMessage)new LocalMessage("settlement", "dietsame"), 0, 0));
      Settler.dietThoughts.add(new DietThought((GameMessage)new LocalMessage("settlement", "dietslightly"), 2, 10));
      Settler.dietThoughts.add(new DietThought((GameMessage)new LocalMessage("settlement", "dietsomewhat"), 4, 15));
      Settler.dietThoughts.add(new DietThought((GameMessage)new LocalMessage("settlement", "dietnicely"), 6, 20));
      Settler.dietThoughts.add(new DietThought((GameMessage)new LocalMessage("settlement", "dietextremely"), 8, 28));
    }
  }
}
