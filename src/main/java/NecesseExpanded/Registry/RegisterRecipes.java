package NecesseExpanded.Registry;

import necesse.engine.network.gameNetworkData.GNDItemMap;
import necesse.engine.registries.RecipeTechRegistry;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;

public class RegisterRecipes 
{
    public static void Register()
    {
        System.out.println("[Necesse Expanded] Registering new recipes...");

        // Objects
        Recipes.registerModRecipe(new Recipe("keg", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("anylog", 10), new Ingredient("demonicbar", 5) }));
        
        Recipes.registerModRecipe(new Recipe("musicplayer", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("anylog", 10), new Ingredient("demonicbar", 10) }));
        Recipes.registerModRecipe(new Recipe("portablemusicplayer", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("anylog", 10), new Ingredient("demonicbar", 10), new Ingredient("quartz", 12) }));
        
        Recipes.registerModRecipe(new Recipe("missionboard", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("anylog", 20), new Ingredient("coin", 200) }));
        Recipes.registerModRecipe(new Recipe("shippingchest", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("anylog", 20), new Ingredient("coin", 400) }));
        Recipes.registerModRecipe(new Recipe("bannerstand", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("demonicbar", 6) }));
        
        Recipes.registerModRecipe(new Recipe("woodarrowtrap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("anylog", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("woodsawtrap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("anylog", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
        
        Recipes.registerModRecipe(new Recipe("stonearrowtrap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("stone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("stoneflametrap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("stone", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("stonesawtrap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("stone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
        
        Recipes.registerModRecipe(new Recipe("sandstonearrowtrap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("sandstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("sandstoneflametrap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("sandstone", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("sandstonesawtrap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("sandstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
        
        Recipes.registerModRecipe(new Recipe("swampstonearrowtrap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("swampstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("swampstoneflametrap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("swampstone", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("swampstonesawtrap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("swampstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
        
        Recipes.registerModRecipe(new Recipe("snowstonearrowtrap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("snowstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("snowstonesawtrap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("snowstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
        
        Recipes.registerModRecipe(new Recipe("deepstonearrowtrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("deepstoneflametrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepstone", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("deepstonesawtrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
        
        Recipes.registerModRecipe(new Recipe("icearrowtrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepsnowstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("icesawtrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepsnowstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
        
        Recipes.registerModRecipe(new Recipe("deepsnowstonearrowtrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepsnowstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("deepsnowstoneflametrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepsnowstone", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("deepsnowstonesawtrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepsnowstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
        
        Recipes.registerModRecipe(new Recipe("deepswampstonearrowtrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepswampstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("deepswampstoneflametrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepswampstone", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("deepswampstonesawtrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepswampstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
        
        Recipes.registerModRecipe(new Recipe("deepsandstonearrowtrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepsandstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("deepsandstoneflametrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepsandstone", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("deepsandstonesawtrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepsandstone", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
        
        Recipes.registerModRecipe(new Recipe("spidercastlearrowtrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("spiderstone", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
        
        Recipes.registerModRecipe(new Recipe("obsidianarrowtrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("obsidian", 5), new Ingredient("stonearrow", 25), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("obsidianflametrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("obsidian", 5), new Ingredient("firemone", 5), new Ingredient("wire", 5) }));
        Recipes.registerModRecipe(new Recipe("obsidiansawtrap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("obsidian", 5), new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
        
        Recipes.registerModRecipe(new Recipe("traptrack", 10, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("ironbar", 1) }));
        Recipes.registerModRecipe(new Recipe("spiketrap", 5, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("ironbar", 1), new Ingredient("wire", 5) }));
        
        Recipes.registerModRecipe(new Recipe("fishian_venom_trap", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepswampstone", 5), new Ingredient("swampsludge", 5), new Ingredient("wire", 5) }));

        Recipes.registerModRecipe(new Recipe("fishian_wall", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepswampstone", 4) }));
        Recipes.registerModRecipe(new Recipe("fishian_door", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepswampstone", 4) }));
        Recipes.registerModRecipe(new Recipe("fishian_tile", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepswampstone", 2) }));
        Recipes.registerModRecipe(new Recipe("fishian_brazier", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("deepswampstone", 10), new Ingredient("voidshard", 5) }));

        Recipes.registerModRecipe(new Recipe("frostshard_cluster", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("frostshard", 4)}));
        Recipes.registerModRecipe(new Recipe("frostshard_cluster_pure", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("frostshard", 4)}));
        Recipes.registerModRecipe(new Recipe("frostshard_cluster_small", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("frostshard", 2)}));

        Recipes.registerModRecipe(new Recipe("life_quartz_cluster", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("lifequartz", 4)}));
        Recipes.registerModRecipe(new Recipe("life_quartz_cluster_pure", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("lifequartz", 4)}));
        Recipes.registerModRecipe(new Recipe("life_quartz_cluster_small", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("lifequartz", 2)}));

        // Consumables
        Recipes.registerModRecipe(new Recipe("greater_mana_elixir", RecipeTechRegistry.FALLEN_WORKSTATION, new Ingredient[] { new Ingredient("glassbottle", 1), new Ingredient("alchemyshard", 5), new Ingredient("upgradeshard", 5), new Ingredient("anytier2essence", 5) }).showAfter("greaterlifeelixir"));
        Recipes.registerModRecipe(new Recipe("mana_elixir", RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("glassbottle", 1), new Ingredient("caveglow", 10), new Ingredient("glacialshard", 3) }).showAfter("lifeelixir"));
        Recipes.registerModRecipe(new Recipe("healthpotion", 1, RecipeTechRegistry.ALCHEMY, new Ingredient[] { new Ingredient("glassbottle", 1), new Ingredient("seaweed", 2) }).showBefore("healthpotion"));
        Recipes.registerModRecipe(new Recipe("greaterhealthpotion", 1, RecipeTechRegistry.CAVEGLOW_ALCHEMY, new Ingredient[] { new Ingredient("glassbottle", 1), new Ingredient("caveglow", 1), new Ingredient("sunflower", 3),}).showBefore("greaterhealthpotion"));
        Recipes.registerModRecipe(new Recipe("greatermanapotion", 1, RecipeTechRegistry.CAVEGLOW_ALCHEMY, new Ingredient[] { new Ingredient("glassbottle", 1), new Ingredient("caveglow", 1), new Ingredient("iceblossom", 3),}).showBefore("greatermanapotion"));
        Recipes.registerModRecipe(new Recipe("greaterbattlepotion", 1, RecipeTechRegistry.FALLEN_ALCHEMY, new Ingredient[] { new Ingredient("glassbottle", 1), new Ingredient("caveglow", 4), new Ingredient("thorns", 3), new Ingredient("terrorfish", 1)}).showBefore("greaterbattlepotion"));
        Recipes.registerModRecipe(new Recipe("superiorhealthpotion", 1, RecipeTechRegistry.FALLEN_ALCHEMY, new Ingredient[] { new Ingredient("glassbottle", 1), new Ingredient("caveglow", 3), new Ingredient("sunflower", 4),}).showBefore("superiorhealthpotion"));
        Recipes.registerModRecipe(new Recipe("superiormanapotion", 1, RecipeTechRegistry.FALLEN_ALCHEMY, new Ingredient[] { new Ingredient("glassbottle", 1), new Ingredient("caveglow", 3), new Ingredient("iceblossom", 4) }).showBefore("superiormanapotion"));
        Recipes.registerModRecipe(new Recipe("greaterhealthregenpotion", 1, RecipeTechRegistry.FALLEN_ALCHEMY, new Ingredient[] { new Ingredient("glassbottle", 1), new Ingredient("caveglow", 3), new Ingredient("firemone", 5), new Ingredient("heartfish", 1)}).showBefore("greaterhealthregenpotion"));
        Recipes.registerModRecipe(new Recipe("greatermanaregenpotion", 1, RecipeTechRegistry.FALLEN_ALCHEMY, new Ingredient[] { new Ingredient("glassbottle", 1), new Ingredient("caveglow", 3), new Ingredient("iceblossom", 5), new Ingredient("furfish", 1)}).showBefore("greatermanaregenpotion"));
        Recipes.registerModRecipe(new Recipe("greaterspeedpotion", 1, RecipeTechRegistry.FALLEN_ALCHEMY, new Ingredient[] { new Ingredient("glassbottle", 1), new Ingredient("caveglow", 3), new Ingredient("mushroom", 4), new Ingredient("glacierfish", 1)}).showBefore("greaterspeedpotion"));
        Recipes.registerModRecipe(new Recipe("greaterattackspeedpotion", 1, RecipeTechRegistry.FALLEN_ALCHEMY, new Ingredient[] { new Ingredient("glassbottle", 1), new Ingredient("caveglow", 3), new Ingredient("firemone", 3), new Ingredient("demonfish", 1)}).showBefore("greaterattackspeedpotion"));
        Recipes.registerModRecipe(new Recipe("mead", RecipeTechRegistry.getTech("keg"), new Ingredient[] { new Ingredient("honey", 2) }));
        Recipes.registerModRecipe(new Recipe("raspberry_wine", RecipeTechRegistry.getTech("keg"), new Ingredient[] { new Ingredient("raspberry", 2) }));
        Recipes.registerModRecipe(new Recipe("blueberry_wine", RecipeTechRegistry.getTech("keg"), new Ingredient[] { new Ingredient("blueberry", 2) }));
        Recipes.registerModRecipe(new Recipe("blackberry_wine", RecipeTechRegistry.getTech("keg"), new Ingredient[] { new Ingredient("blackberry", 2) }));
        Recipes.registerModRecipe(new Recipe("beer", RecipeTechRegistry.getTech("keg"), new Ingredient[] { new Ingredient("wheat", 2) }));
        Recipes.registerModRecipe(new Recipe("cider", RecipeTechRegistry.getTech("keg"), new Ingredient[] { new Ingredient("apple", 2) }));
        Recipes.registerModRecipe(new Recipe("whiskey", RecipeTechRegistry.getTech("keg"), new Ingredient[] { new Ingredient("corn", 2) }));
        Recipes.registerModRecipe(new Recipe("elder_coffee", RecipeTechRegistry.COOKING_POT, new Ingredient[] { new Ingredient("blackcoffee", 1), new Ingredient("whiskey", 1), new Ingredient("sugar", 2), new Ingredient("milk", 1)}));
        Recipes.registerModRecipe(new Recipe("miner_brew", RecipeTechRegistry.COOKING_POT, new Ingredient[] { new Ingredient("whiskey", 1), new Ingredient("sugar", 2), new Ingredient("chilipepper", 2)}));
        Recipes.registerModRecipe(new Recipe("pearlescent_wine", RecipeTechRegistry.getTech("keg"), new Ingredient[] { new Ingredient("anyfruit", 3), new Ingredient("sugar", 3), new Ingredient("pearlescentdiamond", 1)}));
        Recipes.registerModRecipe(new Recipe("fruit_jam", RecipeTechRegistry.getTech("keg"), new Ingredient[] { new Ingredient("anyfruit", 3) }));
        Recipes.registerModRecipe(new Recipe("jam_donut", RecipeTechRegistry.COOKING_POT, new Ingredient[] { new Ingredient("fruit_jam", 1), new Ingredient("donut", 1),  new Ingredient("sugar", 2),}));
        Recipes.registerModRecipe(new Recipe("angler_fish_stew", RecipeTechRegistry.COOKING_POT, new Ingredient[] { new Ingredient("anycommonfish", 1), new Ingredient("potato", 2), new Ingredient("carrot", 1) }));
        Recipes.registerModRecipe(new Recipe("heartfish_stew", RecipeTechRegistry.COOKING_POT, new Ingredient[] { new Ingredient("heartfish", 1), new Ingredient("potato", 2), new Ingredient("carrot", 2), new Ingredient("onion", 1) }));
        Recipes.registerModRecipe(new Recipe("pearlfish_stew", RecipeTechRegistry.COOKING_POT, new Ingredient[] { new Ingredient("pearlfish", 1), new Ingredient("chilipepper", 2), new Ingredient("onion", 2), new Ingredient("carrot", 2), new Ingredient("potato", 2),}));
        Recipes.registerModRecipe(new Recipe("mushroom_stew", RecipeTechRegistry.COOKING_POT, new Ingredient[] { new Ingredient("mushroom", 2)}));
        Recipes.registerModRecipe(new Recipe("stamina_potion", 1, RecipeTechRegistry.ALCHEMY, new Ingredient[] { new Ingredient("glassbottle", 1), new Ingredient("wheat", 1), new Ingredient("firemone", 1)}));

        // Trinkets
        Recipes.registerModRecipe(new Recipe("blood_crystal", RecipeTechRegistry.FALLEN_WORKSTATION, new Ingredient[] { new Ingredient("bloodessence", 16), new Ingredient("ruby", 8) }));
        Recipes.registerModRecipe(new Recipe("shadow_crystal", RecipeTechRegistry.FALLEN_WORKSTATION, new Ingredient[] { new Ingredient("shadowessence", 18) }));
        Recipes.registerModRecipe(new Recipe("necromancer_ring", RecipeTechRegistry.FALLEN_WORKSTATION, new Ingredient[] { new Ingredient("tungstenbar", 6), new Ingredient("anytier2essence", 10)}));
        Recipes.registerModRecipe(new Recipe("lucky_ring", RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("goldbar", 8), new Ingredient("tungstenbar", 6)}));
        Recipes.registerModRecipe(new Recipe("lensmaker_glasses", RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("quartz", 16), new Ingredient("ironbar", 8)}));
        Recipes.registerModRecipe(new Recipe("ancient_tablet", RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("sandstone", 20), new Ingredient("quartz", 16)}));
        Recipes.registerModRecipe(new Recipe("warrior_ring", RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("ironbar", 8), new Ingredient("quartz", 14)}));
        Recipes.registerModRecipe(new Recipe("summoner_grimoire", RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("book", 1), new Ingredient("quartz", 16)}));
        Recipes.registerModRecipe(new Recipe("leather_scabbard", RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("leather", 8)}).showAfter("leatherglove"));

        Recipes.registerModRecipe(new Recipe("fuzzydice", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("wool", 12), new Ingredient("leather", 6)}));
        Recipes.registerModRecipe(new Recipe("shinebelt", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("leather", 10), new Ingredient("ironbar", 5), new Ingredient("voidshard", 2) }));
        Recipes.registerModRecipe(new Recipe("noblehorseshoe", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("goldbar", 8) }));
        Recipes.registerModRecipe(new Recipe("vampiresgift", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("leather", 12), new Ingredient("batwing", 8) }));
        Recipes.registerModRecipe(new Recipe("fins", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("leather", 5) }));
        Recipes.registerModRecipe(new Recipe("zephyrcharm", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("ironbar", 5),  new Ingredient("frostshard", 6)}));
        Recipes.registerModRecipe(new Recipe("magicmanual", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("voidshard", 9), new Ingredient("book", 1) }));
        Recipes.registerModRecipe(new Recipe("mobilitycloak", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("leather", 8), new Ingredient("voidshard", 6) }));
        Recipes.registerModRecipe(new Recipe("magicfoci", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("demonicbar", 8) }));
        Recipes.registerModRecipe(new Recipe("rangefoci", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("demonicbar", 8) }));
        Recipes.registerModRecipe(new Recipe("meleefoci", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("demonicbar", 8) }));
        Recipes.registerModRecipe(new Recipe("summonfoci", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("demonicbar", 8) }));
        Recipes.registerModRecipe(new Recipe("mesmertablet", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("voidshard", 16), new Ingredient("book", 4) }));
        Recipes.registerModRecipe(new Recipe("miningcharm", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("quartz", 22), new Ingredient("miningpotion", 3) }));
        Recipes.registerModRecipe(new Recipe("calmingrose", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("frostshard", 16), new Ingredient("iceblossom", 12) }));
        Recipes.registerModRecipe(new Recipe("sparegemstones", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("sapphire", 5), new Ingredient("frostshard", 8) }));
        Recipes.registerModRecipe(new Recipe("vambrace", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("ivybar", 5), new Ingredient("swampsludge", 5) }));
        Recipes.registerModRecipe(new Recipe("ammobox", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("tungstenbar", 5) }));
        Recipes.registerModRecipe(new Recipe("magicalquiver", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("leather", 5), new Ingredient("tungstenbar", 5) }));
        Recipes.registerModRecipe(new Recipe("challengerspauldron", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("tungstenbar", 10) }));
        Recipes.registerModRecipe(new Recipe("firestone", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("obsidian", 10) }));
        Recipes.registerModRecipe(new Recipe("froststone", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("glacialshard", 5) }));
        Recipes.registerModRecipe(new Recipe("spikedboots", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("glacialshard", 5), new Ingredient("leather", 5) }));
        Recipes.registerModRecipe(new Recipe("clockworkheart", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("ancientfossilbar", 10), new Ingredient("lifequartz", 15) }));
        Recipes.registerModRecipe(new Recipe("forbiddenspellbook", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("book", 1), new Ingredient("voidshard", 10), new Ingredient("ancientfossilbar", 10) }));

        // Weapons
        Recipes.registerModRecipe(new Recipe("murasama", 1, RecipeTechRegistry.FALLEN_ANVIL, new Ingredient[] { new Ingredient("bioessence", 20)}));
        Recipes.registerModRecipe(new Recipe("inferno", 1, RecipeTechRegistry.FALLEN_ANVIL, new Ingredient[] { new Ingredient("shadowessence", 20)}));
        Recipes.registerModRecipe(new Recipe("winterwrath", 1, RecipeTechRegistry.FALLEN_ANVIL, new Ingredient[] { new Ingredient("cryoessence", 20)}));
        Recipes.registerModRecipe(new Recipe("brimstone", 1, RecipeTechRegistry.FALLEN_ANVIL, new Ingredient[] { new Ingredient("primordialessence", 20)}));
        Recipes.registerModRecipe(new Recipe("juggernaut_axe", 1, RecipeTechRegistry.TUNGSTEN_ANVIL, new Ingredient[] { new Ingredient("ectoplasm", 16), new Ingredient("tungstenbar", 12)}).showAfter("tungstensword"));
        Recipes.registerModRecipe(new Recipe("glacial_spear", 1, RecipeTechRegistry.TUNGSTEN_ANVIL, new Ingredient[] { new Ingredient("glacialbar", 14), new Ingredient("glacialshard", 6)}).showAfter("glacialboomerang"));
        Recipes.registerModRecipe(new Recipe("handgun", 1, RecipeTechRegistry.IRON_ANVIL, new Ingredient[] { new Ingredient("ironbar", 5) }));
        Recipes.registerModRecipe(new Recipe("machinegun", 1, RecipeTechRegistry.DEMONIC_ANVIL, new Ingredient[] { new Ingredient("ironbar", 10) }));
        Recipes.registerModRecipe(new Recipe("shotgun", 1, RecipeTechRegistry.DEMONIC_ANVIL, new Ingredient[] { new Ingredient("ironbar", 12), new Ingredient("frostshard", 8) }));
        Recipes.registerModRecipe(new Recipe("sniperrifle", 1, RecipeTechRegistry.DEMONIC_ANVIL, new Ingredient[] { new Ingredient("ironbar", 15), new Ingredient("quartz", 16) }));
        Recipes.registerModRecipe(new Recipe("ninjastar", 10, RecipeTechRegistry.IRON_ANVIL, new Ingredient[] { new Ingredient("ironbar", 1) }));

        // Ammo
        Recipes.registerModRecipe(new Recipe("venom_bullet", 100, RecipeTechRegistry.FALLEN_ANVIL, new Ingredient[] { new Ingredient("spidervenom", 1), new Ingredient("simplebullet", 100)}));
        Recipes.registerModRecipe(new Recipe("vampire_bullet", 100, RecipeTechRegistry.FALLEN_ANVIL, new Ingredient[] { new Ingredient("phantomdust", 1), new Ingredient("simplebullet", 100)}));

        // Armour
        Recipes.registerModRecipe(new Recipe("dawnhelmet", 1, RecipeTechRegistry.FALLEN_ANVIL, new Ingredient[] { new Ingredient("solar_essence", 14)}, false, (new GNDItemMap()).setInt("upgradeLevel", 100)).showBefore("slimehelmet"));
        Recipes.registerModRecipe(new Recipe("dawnchestplate", 1, RecipeTechRegistry.FALLEN_ANVIL, new Ingredient[] { new Ingredient("solar_essence", 18)}, false, (new GNDItemMap()).setInt("upgradeLevel", 100)).showBefore("slimehelmet"));
        Recipes.registerModRecipe(new Recipe("dawnboots", 1, RecipeTechRegistry.FALLEN_ANVIL, new Ingredient[] { new Ingredient("solar_essence", 12)}, false, (new GNDItemMap()).setInt("upgradeLevel", 100)).showBefore("slimehelmet"));
        Recipes.registerModRecipe(new Recipe("duskhelmet", 1, RecipeTechRegistry.FALLEN_ANVIL, new Ingredient[] { new Ingredient("lunar_essence", 14)}, false, (new GNDItemMap()).setInt("upgradeLevel", 100)).showBefore("slimehelmet"));
        Recipes.registerModRecipe(new Recipe("duskchestplate", 1, RecipeTechRegistry.FALLEN_ANVIL, new Ingredient[] { new Ingredient("lunar_essence", 18)}, false, (new GNDItemMap()).setInt("upgradeLevel", 100)).showBefore("slimehelmet"));
        Recipes.registerModRecipe(new Recipe("duskboots", 1, RecipeTechRegistry.FALLEN_ANVIL, new Ingredient[] { new Ingredient("lunar_essence", 12)}, false, (new GNDItemMap()).setInt("upgradeLevel", 100)).showBefore("slimehelmet"));

        // Tools
        Recipes.registerModRecipe(new Recipe("crystal_fishing_rod", RecipeTechRegistry.FALLEN_ANVIL, new Ingredient[] { new Ingredient("omnicrystal", 12)}));
        Recipes.registerModRecipe(new Recipe("ironbomb", 3, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("fertilizer", 3), new Ingredient("ironbar", 1) }));
        Recipes.registerModRecipe(new Recipe("dynamitestick", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("firemone", 3), new Ingredient("ironbomb", 1) }));
        Recipes.registerModRecipe(new Recipe("rope", 10, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("wool", 5), new Ingredient("leather", 1) }));
        
        // Bait
        Recipes.registerModRecipe(new Recipe("anglersbait", 1, RecipeTechRegistry.WORKSTATION, new Ingredient[] { new Ingredient("wormbait", 1), new Ingredient("seaweed", 1)}));

        // Crafting Materials
        Recipes.registerModRecipe(new Recipe("sugar", 2, RecipeTechRegistry.COMPOST_BIN, new Ingredient[] { new Ingredient("honey_plort", 1)}));

        // Misc
        Recipes.registerModRecipe(new Recipe("voidshard", 3, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("demonfish", 1)}));
        Recipes.registerModRecipe(new Recipe("lifequartz", 3, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("heartfish", 1)}));
    }
}
