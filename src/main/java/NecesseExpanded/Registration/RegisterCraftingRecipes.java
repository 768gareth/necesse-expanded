package NecesseExpanded.Registration;

import necesse.engine.registries.RecipeTechRegistry;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;
import necesse.inventory.recipe.Tech;

public class RegisterCraftingRecipes 
{
    public static void Register()
    {
        if (NecesseExpanded.Main.Options.isVanillaCraftingRecipesChangesEnabled)
        {
            System.out.println("[NECESSE EXPANDED] Registering new crafting recipes...");

            Recipes.registerModRecipe(new Recipe("fuzzydice", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("wool", 5) }));
            Recipes.registerModRecipe(new Recipe("shinebelt", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("leather", 10), new Ingredient("ironbar", 5) }));
            Recipes.registerModRecipe(new Recipe("noblehorseshoe", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("ironbar", 5) }));
            Recipes.registerModRecipe(new Recipe("vampiresgift", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("leather", 10), new Ingredient("batwing", 5) }));
            Recipes.registerModRecipe(new Recipe("fins", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("leather", 5) }));
            Recipes.registerModRecipe(new Recipe("zephyrcharm", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("ironbar", 5) }));
            
            Recipes.registerModRecipe(new Recipe("missionboard", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("anylog", 20) }));
            Recipes.registerModRecipe(new Recipe("shippingchest", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("anylog", 20), new Ingredient("goldbar", 5) }));
    
            Recipes.registerModRecipe(new Recipe("handgun", 1, RecipeTechRegistry.IRON_ANVIL, new Ingredient[] { new Ingredient("ironbar", 5) }));
            Recipes.registerModRecipe(new Recipe("machinegun", 1, RecipeTechRegistry.DEMONIC_ANVIL, new Ingredient[] { new Ingredient("ironbar", 10) }));
            Recipes.registerModRecipe(new Recipe("shotgun", 1, RecipeTechRegistry.DEMONIC_ANVIL, new Ingredient[] { new Ingredient("ironbar", 10) }));
            Recipes.registerModRecipe(new Recipe("sniperrifle", 1, RecipeTechRegistry.DEMONIC_ANVIL, new Ingredient[] { new Ingredient("ironbar", 10), new Ingredient("quartz", 5) }));
            
            Recipes.registerModRecipe(new Recipe("bannerstand", 1, RecipeTechRegistry.DEMONIC_ANVIL, new Ingredient[] { new Ingredient("ironbar", 5) }));
    
            Recipes.registerModRecipe(new Recipe("magicmanual", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("voidshard", 5), new Ingredient("book", 1) }));
            Recipes.registerModRecipe(new Recipe("mobilitycloak", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("leather", 5), new Ingredient("voidshard", 5) }));
            Recipes.registerModRecipe(new Recipe("magicfoci", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("demonicbar", 5) }));
            Recipes.registerModRecipe(new Recipe("rangefoci", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("demonicbar", 5) }));
            Recipes.registerModRecipe(new Recipe("meleefoci", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("demonicbar", 5) }));
            Recipes.registerModRecipe(new Recipe("summonfoci", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("demonicbar", 5) }));
            Recipes.registerModRecipe(new Recipe("mesmertablet", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("voidshard", 10) }));
            Recipes.registerModRecipe(new Recipe("miningcharm", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("quartz", 10) }));
            Recipes.registerModRecipe(new Recipe("calmingrose", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("frostshard", 10) }));
            Recipes.registerModRecipe(new Recipe("sparegemstones", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("sapphire", 5) }));
            Recipes.registerModRecipe(new Recipe("vambrace", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("ivybar", 5), new Ingredient("swampsludge", 5) }));
            
            Recipes.registerModRecipe(new Recipe("ammobox", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("tungstenbar", 5) }));
            Recipes.registerModRecipe(new Recipe("magicalquiver", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("leather", 5), new Ingredient("tungstenbar", 5) }));
            Recipes.registerModRecipe(new Recipe("challengerspauldron", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("tungstenbar", 10) }));
            Recipes.registerModRecipe(new Recipe("firestone", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("obsidian", 10) }));
            Recipes.registerModRecipe(new Recipe("froststone", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("glacialshard", 5) }));
            Recipes.registerModRecipe(new Recipe("spikedboots", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("glacialshard", 5), new Ingredient("leather", 5) }));
            Recipes.registerModRecipe(new Recipe("clockworkheart", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("ancientfossilbar", 10), new Ingredient("lifequartz", 15) }));
            Recipes.registerModRecipe(new Recipe("forbiddenspellbook", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("book", 1), new Ingredient("voidshard", 10), new Ingredient("ancientfossilbar", 10) }));
            
            Recipes.registerModRecipe(new Recipe("woodarrowtrap", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("anylog", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("woodsawtrap", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("anylog", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("stonearrowtrap", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("stone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("stoneflametrap", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("stone", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("stonesawtrap", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("stone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("sandstonearrowtrap", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("sandstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("sandstoneflametrap", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("sandstone", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("sandstonesawtrap", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("sandstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("swampstonearrowtrap", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("swampstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("swampstoneflametrap", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("swampstone", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("swampstonesawtrap", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("swampstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("snowstonearrowtrap", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("snowstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("snowstonesawtrap", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("snowstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("deepstonearrowtrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("deepstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("deepstoneflametrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("deepstone", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("deepstonesawtrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("deepstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("icearrowtrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("deepsnowstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("icesawtrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("deepsnowstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("deepsnowstonearrowtrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("deepsnowstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("deepsnowstoneflametrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("deepsnowstone", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("deepsnowstonesawtrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("deepsnowstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("deepswampstonearrowtrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("deepswampstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("deepswampstoneflametrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("deepswampstone", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("deepswampstonesawtrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("deepswampstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("deepsandstonearrowtrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("deepsandstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("deepsandstoneflametrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("deepsandstone", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("deepsandstonesawtrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("deepsandstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("spidercastlearrowtrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("spiderstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("obsidianarrowtrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("obsidian", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("obsidianflametrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("obsidian", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("obsidiansawtrap", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("obsidian", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
            Recipes.registerModRecipe(new Recipe("traptrack", 10, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("ironbar", 1) }));
            Recipes.registerModRecipe(new Recipe("spiketrap", 5, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
        }
        if (NecesseExpanded.Main.Options.isSettlementChangesEnabled)
        {
            //Tech Keg = RecipeTechRegistry.registerTech("keg", "keg");
            //Recipes.registerModRecipe(new Recipe("drink_mead", Keg, new Ingredient[] { new Ingredient("honey", 3) }));
            //Recipes.registerModRecipe(new Recipe("drink_wine", Keg, new Ingredient[] { new Ingredient("raspberry", 3) }));
            //Recipes.registerModRecipe(new Recipe("drink_wine", Keg, new Ingredient[] { new Ingredient("blueberry", 3) }));
            //Recipes.registerModRecipe(new Recipe("drink_wine", Keg, new Ingredient[] { new Ingredient("blackberry", 3) }));
            //Recipes.registerModRecipe(new Recipe("drink_beer", Keg, new Ingredient[] { new Ingredient("wheat", 3) }));
            //Recipes.registerModRecipe(new Recipe("drink_cider", Keg, new Ingredient[] { new Ingredient("apple", 3) }));
        }
    }
}
