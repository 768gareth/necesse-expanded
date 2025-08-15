package NecesseExpanded.Registration;

import necesse.engine.modifiers.ModifierValue;
import necesse.engine.registries.ItemRegistry;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.inventory.item.Item;
import necesse.inventory.item.placeableItem.consumableItem.food.FoodConsumableItem;
import necesse.level.maps.levelData.settlementData.settler.Settler;

public class RegisterItems 
{
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void Register()
    {
        if (NecesseExpanded.Main.Options.isSettlementChangesEnabled)
        {
            ItemRegistry.registerItem
            (
                "mead", 
                (new FoodConsumableItem
                (
                    250, 
                    Item.Rarity.UNCOMMON, 
                    Settler.FOOD_FINE, 
                    5, 
                    240, 
                    new ModifierValue[] { new ModifierValue(BuffModifiers.MAX_RESILIENCE_FLAT, Integer.valueOf(20))}))
                .setItemCategory(new String[] {"consumable"}), 
                30, 
                true
            );
            ItemRegistry.registerItem
            (
                "wine", 
                (new FoodConsumableItem
                (
                    250, 
                    Item.Rarity.UNCOMMON, 
                    Settler.FOOD_FINE, 
                    5, 
                    240, 
                    new ModifierValue[] { new ModifierValue(BuffModifiers.MAX_MANA_FLAT, Integer.valueOf(20))}))
                .setItemCategory(new String[] {"consumable"}), 
                30, 
                true
            );
            ItemRegistry.registerItem
            (
                "beer", 
                (new FoodConsumableItem
                (
                    250, 
                    Item.Rarity.UNCOMMON, 
                    Settler.FOOD_FINE, 
                    5, 
                    240, 
                    new ModifierValue[] { new ModifierValue(BuffModifiers.MAX_HEALTH_FLAT, Integer.valueOf(20))}))
                .setItemCategory(new String[] {"consumable"}), 
                30, 
                true
            );
            ItemRegistry.registerItem
            (
                "cider", 
                (new FoodConsumableItem
                (
                    250, 
                    Item.Rarity.UNCOMMON, 
                    Settler.FOOD_FINE, 
                    5, 
                    240, 
                    new ModifierValue[] { new ModifierValue(BuffModifiers.CRIT_CHANCE, Float.valueOf(0.05F)) }))
                .setItemCategory(new String[] {"consumable"}), 
                30, 
                true
            );
        }
    }
}
