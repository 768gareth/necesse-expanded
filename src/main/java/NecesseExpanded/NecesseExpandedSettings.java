package NecesseExpanded;

import necesse.engine.modLoader.ModSettings;
import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;

public class NecesseExpandedSettings extends ModSettings
{
    public Boolean isStarterEquipmentChangesEnabled = true;
    public Boolean isSettlementChangesEnabled = true;
    public Boolean isVanillaCraftingRecipesChangesEnabled = true;
    public Boolean isShopChangesEnabled = true;
    public Boolean isNewRaidSystemEnabled = true;

    public float RaidMultiplier = 1.0F;
    
    @Override
    public void addSaveData(SaveData Save) 
    {
        Save.addBoolean
        (
            "starter_equipment", 
            isStarterEquipmentChangesEnabled, 
            "If enabled, new player characters have better equipment."     
        );
        Save.addBoolean
        (
            "settlement_upgrades", 
            isSettlementChangesEnabled, 
            "If enabled, settlement mechanics are expanded. See workshop page for details."     
        );
        Save.addBoolean
        (
            "vanilla_crafting_recipes", 
            isVanillaCraftingRecipesChangesEnabled, 
            "If enabled, adds 64 new crafting recipes for vanilla items."     
        );
        Save.addBoolean
        (
            "shop_changes", 
            isShopChangesEnabled, 
            "If enabled, modifies some NPC shop lists to add and remove items."     
        );
        Save.addBoolean
        (
            "new_raids_enabled", 
            isNewRaidSystemEnabled, 
            "If enabled, the new raid system will be used. See workshop page for details."     
        );
        Save.addFloat
        (
            "raid_multiplier", 
            RaidMultiplier, 
            "Acts as a size multiplier for complex raids. Default: 1.0"
        );
    }

    @Override
    public void applyLoadData(LoadData Save) 
    {
        if (Save == null)
        {
            return;
        }
        isStarterEquipmentChangesEnabled = Save.getBoolean("starter_equipment");
        isSettlementChangesEnabled = Save.getBoolean("settlement_upgrades");
        isVanillaCraftingRecipesChangesEnabled = Save.getBoolean("vanilla_crafting_recipes");
        isShopChangesEnabled = Save.getBoolean("shop_changes");
        isNewRaidSystemEnabled = Save.getBoolean("new_raids_enabled");
        RaidMultiplier = Save.getFloat("raid_multiplier");
    }
}
