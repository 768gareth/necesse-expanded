package NecesseExpanded.Settlements;

import java.util.ArrayList;
import java.util.List;

import necesse.engine.localization.message.GameMessage;
import necesse.engine.localization.message.LocalMessage;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.friendly.human.HappinessModifier;
import necesse.entity.mobs.friendly.human.HumanMob;

import necesse.level.maps.levelData.settlementData.SettlementBed;
import necesse.level.maps.levelData.settlementData.settler.DietThought;
import necesse.level.maps.levelData.settlementData.settler.FoodQuality;
import necesse.level.maps.levelData.settlementData.settler.PopulationThought;
import necesse.level.maps.levelData.settlementData.settler.Settler;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.Advice.OnMethodEnter;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModMethodPatch(target = HumanMob.class, name = "getHappinessModifiers", arguments = {})
public class HappinessModifiersPatch 
{
    @OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter(@This HumanMob ThisSettler)
    {
        if (NecesseExpanded.Main.Options.isSettlementChangesEnabled)
        {
            return true;
        }
        return false;
    }

    @OnMethodExit()
    static void onExit(@This HumanMob ThisSettler, @Advice.Return(readOnly = false) List<HappinessModifier> List)
    {
        if (NecesseExpanded.Main.Options.isSettlementChangesEnabled)
        {
            ArrayList<HappinessModifier> Modifiers = new ArrayList<>();
            if (ThisSettler.lastFoodEaten != null && ThisSettler.lastFoodEaten.quality != null)
            {
                Modifiers.add(ThisSettler.lastFoodEaten.quality.getModifier());
            }
            else
            {
                Modifiers.add(FoodQuality.noFoodModifier);
            }
            int differentFoodsEaten = (int)ThisSettler.recentFoodItemIDsEaten.stream().distinct().count();
            DietThought DietThought = Settler.getDietThought(differentFoodsEaten);
            if (DietThought != null)
            {
                Modifiers.add(DietThought.getModifier());
            }
            if (ThisSettler.levelSettler != null)
            {
                SettlementBed bed = ThisSettler.levelSettler.getBed();
                if (bed != null)
                {
                    Modifiers.addAll(bed.getHappinessModifiers());
                }
                else
                {
                    Modifiers.add(HappinessModifier.noBedModifier);
                }
            }
            PopulationThought PopulationThought = Settler.getPopulationThough(ThisSettler.levelSettler.data.countTotalSettlers());
            if (PopulationThought != null)
            {
                Modifiers.add(PopulationThought.getModifier());
            }
    
            // Apply progression modifiers.
            if (ThisSettler.levelSettler.data.hasCompletedQuestTier("fallenwizard"))
            {
                Modifiers.add(new HappinessModifier(10, (GameMessage)new LocalMessage("settlement", "progression_bonus_2")));
            }
            else if (ThisSettler.levelSettler.data.hasCompletedQuestTier("piratecaptain"))
            {
                Modifiers.add(new HappinessModifier(5, (GameMessage)new LocalMessage("settlement", "progression_bonus_1")));
            }
    
            List = Modifiers;
        }
    }
}
