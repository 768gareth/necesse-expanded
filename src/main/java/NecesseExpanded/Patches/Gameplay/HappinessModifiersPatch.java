package NecesseExpanded.Patches.Gameplay;

import java.util.ArrayList;
import java.util.List;
import necesse.engine.localization.message.GameMessage;
import necesse.engine.localization.message.GameMessageBuilder;
import necesse.engine.localization.message.LocalMessage;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.friendly.human.HappinessModifier;
import necesse.entity.mobs.friendly.human.HumanMob;
import necesse.level.maps.levelData.settlementData.ServerSettlementData;
import necesse.level.maps.levelData.settlementData.SettlementBed;
import necesse.level.maps.levelData.settlementData.SettlementRoom;
import necesse.level.maps.levelData.settlementData.settler.DietThought;
import necesse.level.maps.levelData.settlementData.settler.FoodQuality;
import necesse.level.maps.levelData.settlementData.settler.PopulationThought;
import necesse.level.maps.levelData.settlementData.settler.RoomQuality;
import necesse.level.maps.levelData.settlementData.settler.RoomSize;
import necesse.level.maps.levelData.settlementData.settler.Settler;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.Return;
import net.bytebuddy.asm.Advice.This;

@ModMethodPatch(target = HumanMob.class, name = "getHappinessModifiers", arguments = {})
public class HappinessModifiersPatch 
{
    @OnMethodExit
    static void onExit(@This HumanMob ThisSettler, @Return(readOnly = false) List<HappinessModifier> list) 
    {
        ArrayList<HappinessModifier> Modifiers = new ArrayList<>();
        if (ThisSettler.getWorldEntity() != null && NecesseExpanded.Main.SettingsGetter.getBoolean("happiness_changes_enabled"))
        {
            if (ThisSettler.lastFoodEaten != null && ThisSettler.lastFoodEaten.quality != null) 
            {
                if (ThisSettler.lastFoodEaten.quality.happinessIncrease == 10) 
                {
                    Modifiers.add(new HappinessModifier(8, (GameMessage) new LocalMessage("settlement", "simplemeal")));
                } 
                else if (ThisSettler.lastFoodEaten.quality.happinessIncrease == 20) 
                {
                    Modifiers.add(new HappinessModifier(12, (GameMessage) new LocalMessage("settlement", "finemeal")));
                } 
                else if (ThisSettler.lastFoodEaten.quality.happinessIncrease == 35) 
                {
                    Modifiers.add(new HappinessModifier(18, (GameMessage) new LocalMessage("settlement", "gourmetmeal")));
                } 
                else if (ThisSettler.lastFoodEaten.quality.happinessIncrease == 40)
                {
                    Modifiers.add(new HappinessModifier(24, (GameMessage) new LocalMessage("settlement", "perfectmeal")));
                }
            } 
            else 
            {
                Modifiers.add(FoodQuality.noFoodModifier);
            }
            int differentFoodsEaten = (int) ThisSettler.recentFoodItemIDsEaten.stream().distinct().count();
            DietThought DietThought = Settler.getDietThought(differentFoodsEaten);
            if (DietThought != null)
            {
                Modifiers.add(DietThought.getModifier());
            }
            if (ThisSettler.levelSettler != null) 
            {
                HappinessModifier.bedOutsideModifier = new HappinessModifier(-10, (GameMessage) new LocalMessage("settlement", "bedoutside"));
                HappinessModifier.noBedModifier = new HappinessModifier(-20, (GameMessage) new LocalMessage("settlement", "nobed"));
                SettlementBed Bed = ThisSettler.levelSettler.getBed();
                if (Bed != null) 
                {
                    SettlementRoom Room = Bed.getRoom();
                    if (Room != null) 
                    {
                        int NumberOfOccupiedBeds = Bed.getRoom().getOccupiedBeds();
                        if (NumberOfOccupiedBeds > 1 && !NecesseExpanded.Main.SettingsGetter.getBoolean("settlers_share_rooms_without_penalty"))
                        {
                            Modifiers.add(new HappinessModifier(-5 * NumberOfOccupiedBeds, (GameMessage) (new GameMessageBuilder()).append("settlement", "sharingroom").append(" (" + (NumberOfOccupiedBeds - 1) + ")")));
                        }

                        int RoomSize = Room.getRoomSize();
                        if (RoomSize > 0) 
                        {
                            RoomSize Size = Settler.getRoomSize(RoomSize);
                            Modifiers.add(Size.getModifier());
                        }

                        int RoomQuality = Room.getFurnitureScore();
                        if (RoomQuality > 0) 
                        {
                            RoomQuality Quality = Settler.getRoomQuality(RoomQuality);
                            Modifiers.add(Quality.getModifier());
                        }
                        
                        if (Room.getRoomProperty("lights") <= 0)
                        {
                            Modifiers.add(new HappinessModifier(-3, (GameMessage) (new GameMessageBuilder()).append("settlement", "roommissinglights")));
                        }
                        if (Room.getRoomProperty("outsidefloor") > 0)
                        {
                            Modifiers.add(new HappinessModifier(-3, (GameMessage) (new GameMessageBuilder()).append("settlement", "roommissingfloor")));
                        }   
                    } 
                    else 
                    {
                        Modifiers.add(HappinessModifier.bedOutsideModifier);
                    }
                } 
                else 
                {
                    Modifiers.add(HappinessModifier.noBedModifier);
                }
            }
            PopulationThought PopulationThought = Settler
                    .getPopulationThough(ThisSettler.levelSettler.data.countTotalSettlers());
            if (PopulationThought != null)
                Modifiers.add(PopulationThought.getModifier());
            ServerSettlementData LevelData = ThisSettler.getSettlementServerData();
            if (LevelData != null) {
                int NumberOfQuestsCompleted = LevelData.getQuestTiersCompleted();
                if (NumberOfQuestsCompleted > 1)
                    Modifiers.add(new HappinessModifier(NumberOfQuestsCompleted - 1,
                            (GameMessage) (new GameMessageBuilder()).append("settlement", "progression_bonus")
                                    .append(" (" + NumberOfQuestsCompleted + ")")));
            }
            if (LevelData != null)
                if (LevelData.getHomestoneTile() != null)
                    Modifiers.add(new HappinessModifier(3, (GameMessage) new LocalMessage("settlement", "travel_bonus")));
            if (LevelData != null)
                if (LevelData.getNextRaidDifficultyMod() >= 1.25F) {
                    Modifiers.add(
                            new HappinessModifier(6, (GameMessage) new LocalMessage("settlement", "well_defended_bonus")));
                } else if (LevelData.getNextRaidDifficultyMod() <= 0.75F) {
                    Modifiers.add(new HappinessModifier(-3,
                            (GameMessage) new LocalMessage("settlement", "poorly_defended_penalty")));
                }

            if (ThisSettler.buffManager.hasBuff("settler_death_penalty"))
            {
                Modifiers.add(new HappinessModifier(-5, (GameMessage) new LocalMessage("settlement", "recent_settler_death")));
            }
            if (ThisSettler.buffManager.hasBuff("settler_raid_bonus"))
            {
                Modifiers.add(new HappinessModifier(4, (GameMessage) new LocalMessage("settlement", "settlement_survived_raid")));
            }
            list = Modifiers;
        }
    }
}
