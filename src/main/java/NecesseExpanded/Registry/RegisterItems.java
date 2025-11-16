package NecesseExpanded.Registry;

import NecesseExpanded.Items.Consumables.Misc.*;
import necesse.engine.registries.ItemRegistry;
import necesse.inventory.item.Item;
import necesse.inventory.item.Item.Rarity;
import necesse.inventory.item.matItem.FishItem;
import necesse.inventory.item.matItem.MatItem;
import necesse.inventory.item.placeableItem.tileItem.GrassSeedItem;

public class RegisterItems 
{
    public static void Register()
    {
        System.out.println("[Necesse Expanded] Registering new items...");

        // Fishing consumables
        ItemRegistry.registerItem("surface_treasure_chest", new SurfaceTreasureChest(), 25.0F, true);
        ItemRegistry.registerItem("cave_treasure_chest", new CaveTreasureChest(), 50.0F, true);
        ItemRegistry.registerItem("deep_treasure_chest", new DeepTreasureChest(), 75.0F, true);
        ItemRegistry.registerItem("incursion_treasure_chest", new IncursionTreasureChest(), 100.0F, true);
        ItemRegistry.registerItem("pearl_oyster", new PearlOyster(), 50f, true);

        // Crafting materials
        ItemRegistry.registerItem("swamp_eel", (new FishItem(250, Rarity.COMMON, new String[]{"anycommonfish"})).spoilDuration(240).setItemCategory(new String[]{"consumable", "commonfish"}), 12.0F, true);
        ItemRegistry.registerItem("saltwater_shark", (new FishItem(250, Rarity.COMMON, new String[]{"anycommonfish"})).spoilDuration(240).setItemCategory(new String[]{"consumable", "commonfish"}), 12.0F, true);
        ItemRegistry.registerItem("oyster", (new FishItem(250, Rarity.COMMON, new String[]{"anycommonfish"})).spoilDuration(240).setItemCategory(new String[]{"consumable", "commonfish"}), 12.0F, true);
        ItemRegistry.registerItem("demonfish", new FishItem(99, Item.Rarity.RARE, new String[0]).setItemCategory(new String[] { "materials", "specialfish" }), 15, true);
        ItemRegistry.registerItem("heartfish", new FishItem(99, Item.Rarity.RARE, new String[0]).setItemCategory(new String[] { "materials", "specialfish" }), 20, true);
        ItemRegistry.registerItem("glacierfish", new FishItem(99, Item.Rarity.RARE, new String[0]).setItemCategory(new String[] { "materials", "specialfish" }), 20, true);
        ItemRegistry.registerItem("slimefish", new FishItem(99, Item.Rarity.RARE, new String[0]).setItemCategory(new String[] { "materials", "specialfish" }), 40, true);
        ItemRegistry.registerItem("pearlfish", new FishItem(99, Item.Rarity.LEGENDARY, new String[0]).setItemCategory(new String[] { "materials", "specialfish" }), 50, true);
        ItemRegistry.registerItem("seaweed", (new MatItem(1000, Rarity.NORMAL, "compostabletip", new String[]{"anycompostable"})).setItemCategory(new String[]{"materials"}), 2F, true);
        ItemRegistry.registerItem("slime", (new MatItem(1000, Rarity.NORMAL, "compostabletip", new String[]{"anycompostable"})).setItemCategory(new String[]{"materials"}), 2F, true);
        ItemRegistry.registerItem("pearl", (new MatItem(250, Rarity.RARE, new String[0])).setItemCategory(new String[]{"materials", "minerals"}), 400.0F, true);
        ItemRegistry.registerItem("haunted_grass_seed", new GrassSeedItem("haunted_grass_tile"), 2.0F, true);
    }
}
