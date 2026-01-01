package NecesseExpanded.Items.Consumables.Potions;

import necesse.inventory.item.Item;
import necesse.inventory.item.ItemCategory;
import necesse.inventory.item.placeableItem.consumableItem.potionConsumableItem.SimplePotionItem;

public class StaminaPotion extends SimplePotionItem
{
    public StaminaPotion() 
    {
        super(100, Item.Rarity.COMMON, "stamina_potion_buff", 300, new String[] { "stamina_potion" });
        setItemCategory(ItemCategory.craftingManager, new String[] { "consumable", "buffpotions" });
    }
}
