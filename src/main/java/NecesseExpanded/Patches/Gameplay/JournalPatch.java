package NecesseExpanded.Patches.Gameplay;

import necesse.engine.GameLoadingScreen;
import necesse.engine.journal.*;
import necesse.engine.localization.Localization;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.registries.BiomeRegistry;
import necesse.engine.registries.IncursionBiomeRegistry;
import necesse.engine.registries.JournalChallengeRegistry;
import necesse.engine.registries.JournalRegistry;
import necesse.engine.util.LevelIdentifier;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.LootTablePresets;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.Advice.OnMethodEnter;
import net.bytebuddy.asm.Advice.This;

@ModMethodPatch(target = JournalRegistry.class, name = "registerCore", arguments = {})
public class JournalPatch 
{
    @OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter(@This JournalRegistry Registry) 
    {
        GameLoadingScreen.drawLoadingString(Localization.translate("loading", "biomes"));

        // Forest
        JournalEntry forestSurface = JournalRegistry.registerJournalEntry("forestsurface", new JournalEntry(BiomeRegistry.FOREST, LevelIdentifier.SURFACE_IDENTIFIER));
        forestSurface.addBiomeLootEntry(new String[]{"oaklog", "sprucelog", "apple", "blueberry", "firemone", "gobfish", "halffish", "furfish", "carp", "herring", "mackerel", "salmon", "trout"});
        forestSurface.addMobEntries(new String[]{"cow", "bull", "sheep", "ram", "rabbit", "duck", "zombie", "zombiearcher", "stabbybush", "evilsprotector"});
        forestSurface.addTreasureEntry(new LootTable[]{LootTablePresets.surfaceRuinsChest, LootTablePresets.rollingPinDisplayStand});
        forestSurface.addEntryChallenges(new Integer[]{JournalChallengeRegistry.FOREST_SURFACE_CHALLENGES_ID});

        JournalEntry forestCave = JournalRegistry.registerJournalEntry("forestcave", new JournalEntry(BiomeRegistry.FOREST, LevelIdentifier.CAVE_IDENTIFIER));
        forestCave.addBiomeLootEntry(new String[]{"stone", "clay", "copperore", "ironore", "goldore", "sapphire", "salmon", "trout", "carp", "rockfish", "terrorfish", "demonfish"});
        forestCave.addMobEntries(new String[]{"zombie", "zombiearcher", "crawlingzombie", "goblin", "vampire", "cavemole", "giantcavespider", "trenchcoatgoblinstacked", "grizzlybear", "beetcavecroppler", "stonecaveling"});
        forestCave.addTreasureEntry(new LootTable[]{LootTablePresets.basicCaveChest, LootTablePresets.basicCaveRuinsChest});
        forestCave.addEntryChallenges(new Integer[]{JournalChallengeRegistry.FOREST_CAVES_CHALLENGES_ID});

        JournalEntry forestDeepCave = JournalRegistry.registerJournalEntry("forestdeepcave", new JournalEntry(BiomeRegistry.FOREST, LevelIdentifier.DEEP_CAVE_IDENTIFIER));
        forestDeepCave.addBiomeLootEntry(new String[]{"deepstone", "copperore", "ironore", "goldore", "obsidian", "tungstenore", "lifequartz", "ruby", "heartfish", "deep_treasure_chest"});
        forestDeepCave.addMobEntries(new String[]{"skeleton", "skeletonthrower", "skeletonminer", "deepcavespirit", "beetcavecroppler", "deepstonecaveling", "reaper"});
        forestDeepCave.addTreasureEntry(new LootTable[]{LootTablePresets.deepCaveChest, LootTablePresets.basicDeepCaveRuinsChest});
        forestDeepCave.addEntryChallenges(new Integer[]{JournalChallengeRegistry.FOREST_DEEP_CAVES_CHALLENGES_ID});

        // Pirate
        JournalEntry pirateVillage = JournalRegistry.registerJournalEntry("forestpiratevillage", new JournalEntry(BiomeRegistry.PIRATE_VILLAGE, LevelIdentifier.SURFACE_IDENTIFIER));
        pirateVillage.addBiomeLootEntry(new String[]{"oaklog", "sprucelog", "apple", "blueberry", "firemone"});
        pirateVillage.addMobEntries(new String[]{"pirateparrot", "piraterecruit", "piratecaptain"});
        pirateVillage.addTreasureEntry(new LootTable[]{LootTablePresets.pirateChest, LootTablePresets.pirateDisplayStand});
        pirateVillage.addEntryChallenges(new Integer[]{JournalChallengeRegistry.PIRATE_VILLAGE_CHALLENGES_ID});

        // Plains
        JournalEntry plainsSurface = JournalRegistry.registerJournalEntry("plainssurface", new JournalEntry(BiomeRegistry.PLAINS, LevelIdentifier.SURFACE_IDENTIFIER));
        plainsSurface.addBiomeLootEntry(new String[]{"birchlog", "maplelog", "raspberry", "sunflower", "gobfish", "halffish", "furfish", "carp", "herring", "mackerel", "salmon", "trout"});
        plainsSurface.addMobEntries(new String[]{"cow", "bull", "sheep", "ram", "rabbit", "duck", "zombie", "zombiearcher", "stabbybush", "evilsprotector"});
        plainsSurface.addTreasureEntry(new LootTable[]{LootTablePresets.surfaceRuinsChest, LootTablePresets.rollingPinDisplayStand});
        plainsSurface.addEntryChallenges(new Integer[]{JournalChallengeRegistry.PLAINS_SURFACE_CHALLENGES_ID});

        JournalEntry plainsCave = JournalRegistry.registerJournalEntry("plainscave", new JournalEntry(BiomeRegistry.PLAINS, LevelIdentifier.CAVE_IDENTIFIER));
        plainsCave.addBiomeLootEntry(new String[]{"granite", "runestone", "copperore", "ironore", "goldore", "salmon", "trout", "carp", "rockfish", "terrorfish"});
        plainsCave.addMobEntries(new String[]{"runeboundbrute", "runeboundshaman", "runeboundtrapper", "bonewalker", "goblin", "trenchcoatgoblinstacked", "grizzlybear", "beetcavecroppler", "granitecaveling", "chieftain"});
        plainsCave.addTreasureEntry(new LootTable[]{LootTablePresets.plainsCaveChest, LootTablePresets.plainsCaveRuinsChest});
        plainsCave.addEntryChallenges(new Integer[]{JournalChallengeRegistry.PLAINS_CAVES_CHALLENGES_ID});

        JournalEntry plainsDeepCave = JournalRegistry.registerJournalEntry("plainsdeepcave", new JournalEntry(BiomeRegistry.PLAINS, LevelIdentifier.DEEP_CAVE_IDENTIFIER));
        plainsDeepCave.addBiomeLootEntry(new String[]{"basalt", "amber", "dryadlog", "birchlog", "maplelog", "copperore", "ironore", "goldore", "tungstenore", "lifequartz", "topaz", "salmon", "trout", "carp", "rockfish", "terrorfish", "heartfish", "deep_treasure_chest"});
        plainsDeepCave.addMobEntries(new String[]{"forestspector", "dryadsentinel", "spiritghoul", "beetcavecroppler", "dryadcaveling", "thecursedcrone"});
        plainsDeepCave.addTreasureEntry(new LootTable[]{LootTablePresets.deepPlainsCaveChest, LootTablePresets.plainsDeepCaveRuinsChest});
        plainsDeepCave.addEntryChallenges(new Integer[]{JournalChallengeRegistry.PLAINS_DEEP_CAVES_CHALLENGES_ID});

        // Snow
        JournalEntry snowSurface = JournalRegistry.registerJournalEntry("snowsurface", new JournalEntry(BiomeRegistry.SNOW, LevelIdentifier.SURFACE_IDENTIFIER));
        snowSurface.addBiomeLootEntry(new String[]{"pinelog", "blackberry", "iceblossom", "gobfish", "halffish", "icefish", "carp", "cod", "salmon", "trout"});
        snowSurface.addMobEntries(new String[]{"sheep", "ram", "penguin", "snowhare", "duck", "polarbear", "zombie", "zombiearcher", "trapperzombie"});
        snowSurface.addTreasureEntry(new LootTable[]{LootTablePresets.surfaceRuinsChest, LootTablePresets.rollingPinDisplayStand});
        snowSurface.addEntryChallenges(new Integer[]{JournalChallengeRegistry.SNOW_SURFACE_CHALLENGES_ID});

        JournalEntry snowCave = JournalRegistry.registerJournalEntry("snowcave", new JournalEntry(BiomeRegistry.SNOW, LevelIdentifier.CAVE_IDENTIFIER));
        snowCave.addBiomeLootEntry(new String[]{"snowstone", "copperore", "ironore", "goldore", "frostshard", "salmon", "trout", "carp", "rockfish", "terrorfish", "demonfish"});
        snowCave.addMobEntries(new String[]{"trapperzombie", "cavemole", "frozendwarf", "frozen_dwarf", "frozen_dwarf_mage", "frostsentry", "goblin", "vampire", "blackcavespider", "beetcavecroppler", "snowstonecaveling", "queenspider"});
        snowCave.addTreasureEntry(new LootTable[]{LootTablePresets.snowCaveChest, LootTablePresets.snowCaveRuinsChest});
        snowCave.addEntryChallenges(new Integer[]{JournalChallengeRegistry.SNOW_CAVES_CHALLENGES_ID});

        JournalEntry snowDeepCave = JournalRegistry.registerJournalEntry("snowdeepcave", new JournalEntry(BiomeRegistry.SNOW, LevelIdentifier.DEEP_CAVE_IDENTIFIER));
        snowDeepCave.addBiomeLootEntry(new String[]{"deepsnowstone", "copperore", "ironore", "goldore", "tungstenore", "lifequartz", "glacialore", "salmon", "trout", "carp", "rockfish", "terrorfish", "heartfish", "glacierfish", "deep_treasure_chest"});
        snowDeepCave.addMobEntries(new String[]{"skeleton", "skeletonthrower", "snowwolf", "cryoflake", "ninja", "ice_golem", "beetcavecroppler", "deepsnowstonecaveling", "cryoqueen"});
        snowDeepCave.addTreasureEntry(new LootTable[]{LootTablePresets.deepSnowCaveChest, LootTablePresets.snowDeepCaveRuinsChest, LootTablePresets.stringsVinyls2LootTable});
        snowDeepCave.addEntryChallenges(new Integer[]{JournalChallengeRegistry.SNOW_DEEP_CAVES_CHALLENGES_ID});

        // Dungeon
        JournalEntry dungeon = JournalRegistry.registerJournalEntry("dungeon", new JournalEntry(BiomeRegistry.DUNGEON));
        dungeon.addMobEntries(new String[]{"enchantedzombie", "enchantedzombiearcher", "enchantedcrawlingzombie", "voidapprentice", "beetcavecroppler", "voidwizard"});
        dungeon.addTreasureEntry(new LootTable[]{LootTablePresets.dungeonChest});
        dungeon.addTreasureEntry(new String[]{"bashybush"});
        dungeon.addEntryChallenges(new Integer[]{JournalChallengeRegistry.DUNGEON_CHALLENGES_ID});

        // Swamp
        JournalEntry swampSurface = JournalRegistry.registerJournalEntry("swampsurface", new JournalEntry(BiomeRegistry.SWAMP, LevelIdentifier.SURFACE_IDENTIFIER));
        swampSurface.addBiomeLootEntry(new String[]{"willowlog", "cattail", "mushroom", "gobfish", "halffish", "swampfish", "carp", "mackerel", "salmon", "tuna"});
        swampSurface.addMobEntries(new String[]{"cow", "bull", "sheep", "ram", "swampslug", "frog", "duck", "zombie", "zombiearcher", "swampzombie", "swampslime"});
        swampSurface.addTreasureEntry(new LootTable[]{LootTablePresets.surfaceRuinsChest, LootTablePresets.rollingPinDisplayStand});
        swampSurface.addEntryChallenges(new Integer[]{JournalChallengeRegistry.SWAMP_SURFACE_CHALLENGES_ID});

        JournalEntry swampCave = JournalRegistry.registerJournalEntry("swampcave", new JournalEntry(BiomeRegistry.SWAMP, LevelIdentifier.CAVE_IDENTIFIER));
        swampCave.addBiomeLootEntry(new String[]{"swampstone", "copperore", "ironore", "goldore", "ivyore", "salmon", "carp", "rockfish", "terrorfish", "demonfish"});
        swampCave.addMobEntries(new String[]{"frog", "zombie", "zombiearcher", "crawlingzombie", "swampzombie", "swampslime", "swampshooter", "goblin", "vampire", "cavemole", "swampcavespider", "evilwitch", "beetcavecroppler", "swampstonecaveling", "swampguardian"});
        swampCave.addTreasureEntry(new LootTable[]{LootTablePresets.swampCaveChest, LootTablePresets.swampCaveRuinsChest, LootTablePresets.evilWitchChest});
        swampCave.addEntryChallenges(new Integer[]{JournalChallengeRegistry.SWAMP_CAVES_CHALLENGES_ID});

        JournalEntry swampDeepCave = JournalRegistry.registerJournalEntry("swampdeepcave", new JournalEntry(BiomeRegistry.SWAMP, LevelIdentifier.DEEP_CAVE_IDENTIFIER));
        swampDeepCave.addBiomeLootEntry(new String[]{"deepswampstone", "copperore", "ironore", "goldore", "tungstenore", "lifequartz", "myceliumore", "emerald", "heartfish", "deep_treasure_chest"});
        swampDeepCave.addMobEntries(new String[]{"ancientskeleton", "ancientskeletonthrower", "swampskeleton", "swampdweller", "giantswampslime", "smallswampcavespider", "staticjellyfish", "fishianhookwarrior", "fishianhealer", "mosquito", "beetcavecroppler", "deepswampstonecaveling", "pestwarden"});
        swampDeepCave.addTreasureEntry(new LootTable[]{LootTablePresets.deepSwampCaveChest, LootTablePresets.swampDeepCaveRuinsChest, LootTablePresets.fishianBarrel});
        swampDeepCave.addEntryChallenges(new Integer[]{JournalChallengeRegistry.SWAMP_DEEP_CAVES_CHALLENGES_ID});

        // Desert
        JournalEntry desertSurface = JournalRegistry.registerJournalEntry("desertsurface", new JournalEntry(BiomeRegistry.DESERT, LevelIdentifier.SURFACE_IDENTIFIER));
        desertSurface.addBiomeLootEntry(new String[]{"palmlog", "coconut", "gobfish", "halffish", "carp", "mackerel", "salmon", "tuna"});
        desertSurface.addMobEntries(new String[]{"wildostrich", "duck", "zombie", "zombiearcher", "mummy"});
        desertSurface.addTreasureEntry(new LootTable[]{LootTablePresets.surfaceRuinsChest, LootTablePresets.rollingPinDisplayStand});
        desertSurface.addEntryChallenges(new Integer[]{JournalChallengeRegistry.DESERT_SURFACE_CHALLENGES_ID});

        JournalEntry desertCave = JournalRegistry.registerJournalEntry("desertcave", new JournalEntry(BiomeRegistry.DESERT, LevelIdentifier.CAVE_IDENTIFIER));
        desertCave.addBiomeLootEntry(new String[]{"sandstone", "copperore", "ironore", "goldore", "quartz", "amethyst", "salmon", "carp", "rockfish", "terrorfish", "demonfish"});
        desertCave.addMobEntries(new String[]{"mummy", "mummymage", "sandspirit", "jackal", "beetcavecroppler", "sandstonecaveling", "ancientvulture"});
        desertCave.addTreasureEntry(new LootTable[]{LootTablePresets.desertCaveChest, LootTablePresets.desertCaveRuinsChest});
        desertCave.addEntryChallenges(new Integer[]{JournalChallengeRegistry.DESERT_CAVES_CHALLENGES_ID});

        JournalEntry desertDeepCave = JournalRegistry.registerJournalEntry("desertdeepcave", new JournalEntry(BiomeRegistry.DESERT, LevelIdentifier.DEEP_CAVE_IDENTIFIER));
        desertDeepCave.addBiomeLootEntry(new String[]{"deepsandstone", "copperore", "ironore", "goldore", "ancientfossilore", "lifequartz", "ruby", "heartfish", "deep_treasure_chest"});
        desertDeepCave.addMobEntries(new String[]{"ancientskeleton", "ancientskeletonthrower", "desertcrawler", "sandworm", "beetcavecroppler", "deepsandstonecaveling", "sageandgrit"});
        desertDeepCave.addTreasureEntry(new LootTable[]{LootTablePresets.deepDesertCaveChest, LootTablePresets.desertDeepCaveRuinsChest});
        desertDeepCave.addEntryChallenges(new Integer[]{JournalChallengeRegistry.DESERT_DEEP_CAVES_CHALLENGES_ID});

        JournalEntry temple = JournalRegistry.registerJournalEntry("temple", new JournalEntry(BiomeRegistry.TEMPLE));
        temple.addMobEntries(new String[]{"ancientskeleton", "ancientarmoredskeleton", "ancientskeletonthrower", "ancientskeletonmage", "beetcavecroppler", "fallenwizard"});
        temple.addTreasureEntry(new LootTable[]{LootTablePresets.templeChest});
        temple.addEntryChallenges(new Integer[]{JournalChallengeRegistry.TEMPLE_CHALLENGES_ID});

        // Tier 1 incursions
        JournalEntry forestDeepCaveIncursion = JournalRegistry.registerJournalEntry("forestdeepcaveincursion", new JournalEntry(BiomeRegistry.FOREST_DEEP_CAVE_INCURSION, IncursionBiomeRegistry.FOREST_DEEP_CAVE_INCURSION));
        forestDeepCaveIncursion.addBiomeLootEntry(new String[]{"deepstone", "tungstenore", "upgradeshard", "alchemyshard"});
        forestDeepCaveIncursion.addMobEntries(new String[]{"skeleton", "skeletonthrower", "deepcavespirit", "beetcavecroppler", "shard_caveling", "reaper"});

        JournalEntry snowDeepCaveIncursion = JournalRegistry.registerJournalEntry("snowdeepcaveincursion", new JournalEntry(BiomeRegistry.SNOW_DEEP_CAVE_INCURSION, IncursionBiomeRegistry.SNOW_DEEP_CAVE_INCURSION));
        snowDeepCaveIncursion.addBiomeLootEntry(new String[]{"deepsnowstone", "glacialore", "upgradeshard", "alchemyshard", "salmon", "trout", "carp", "rockfish", "terrorfish"});
        snowDeepCaveIncursion.addMobEntries(new String[]{"skeleton", "skeletonthrower", "snowwolf", "cryoflake", "ninja", "ice_golem", "beetcavecroppler", "shard_caveling", "cryoqueen"});

        JournalEntry swampDeepCaveIncursion = JournalRegistry.registerJournalEntry("swampdeepcaveincursion", new JournalEntry(BiomeRegistry.SWAMP_DEEP_CAVE_INCURSION, IncursionBiomeRegistry.SWAMP_DEEP_CAVE_INCURSION));
        swampDeepCaveIncursion.addBiomeLootEntry(new String[]{"deepswampstone", "myceliumore", "upgradeshard", "alchemyshard"});
        swampDeepCaveIncursion.addMobEntries(new String[]{"ancientskeleton", "ancientskeletonthrower", "swampskeleton", "swampdweller", "giantswampslime", "smallswampcavespider", "beetcavecroppler", "shard_caveling", "pestwarden"});
        
        JournalEntry desertDeepCaveIncursion = JournalRegistry.registerJournalEntry("desertdeepcaveincursion", new JournalEntry(BiomeRegistry.DESERT_DEEP_CAVE_INCURSION, IncursionBiomeRegistry.DESERT_DEEP_CAVE_INCURSION));
        desertDeepCaveIncursion.addBiomeLootEntry(new String[]{"deepsandstone", "ancientfossilore", "upgradeshard", "alchemyshard"});
        desertDeepCaveIncursion.addMobEntries(new String[]{"ancientskeleton", "ancientskeletonthrower", "desertcrawler", "sandworm", "beetcavecroppler", "shard_caveling", "sageandgrit"});
        
        // Tier 2 incursions
        JournalEntry slimeCaveIncursion = JournalRegistry.registerJournalEntry("slimecaveincursion", new JournalEntry(BiomeRegistry.SLIME_CAVE, IncursionBiomeRegistry.SLIME_CAVE));
        slimeCaveIncursion.addBiomeLootEntry(new String[]{"slimestone", "slimeum", "upgradeshard", "alchemyshard", "slimefish"});
        slimeCaveIncursion.addMobEntries(new String[]{"warriorslime", "leggedslimethrower", "mageslime", "ghostslime", "slimeworm", "beetcavecroppler", "shard_caveling", "motherslime"});
        
        JournalEntry graveyardIncursion = JournalRegistry.registerJournalEntry("graveyardincursion", new JournalEntry(BiomeRegistry.GRAVEYARD, IncursionBiomeRegistry.GRAVEYARD));
        graveyardIncursion.addBiomeLootEntry(new String[]{"nightsteelore", "upgradeshard", "alchemyshard"});
        graveyardIncursion.addMobEntries(new String[]{"cryptvampire", "cryptbat", "phantom", "beetcavecroppler", "shard_caveling", "nightswarm"});
        
        JournalEntry spiderCastleIncursion = JournalRegistry.registerJournalEntry("spidercastleincursion", new JournalEntry(BiomeRegistry.SPIDER_CASTLE, IncursionBiomeRegistry.SPIDER_CASTLE));
        spiderCastleIncursion.addBiomeLootEntry(new String[]{"spiderstone", "spideriteore", "upgradeshard", "alchemyshard"});
        spiderCastleIncursion.addMobEntries(new String[]{"spiderkin", "spiderkinwarrior", "spiderkinarcher", "spiderkinmage", "bloatedspider", "webspinner", "beetcavecroppler", "shard_caveling", "spiderempress"});
        
        // Tier 3 incursions
        JournalEntry sunArenaIncursion = JournalRegistry.registerJournalEntry("sunarenaincursion", new JournalEntry(BiomeRegistry.SUN_ARENA, IncursionBiomeRegistry.SUN_ARENA));
        sunArenaIncursion.addMobEntries(new String[]{"sunlightchampion"});

        JournalEntry moonArenaIncursion = JournalRegistry.registerJournalEntry("moonarenaincursion", new JournalEntry(BiomeRegistry.MOON_ARENA, IncursionBiomeRegistry.MOON_ARENA));
        moonArenaIncursion.addMobEntries(new String[]{"moonlightdancer"});

        // Tier 4 incursions
        JournalEntry crystalHollowIncursion = JournalRegistry.registerJournalEntry("crystalhollowincursion", new JournalEntry(BiomeRegistry.CRYSTAL_HOLLOW, IncursionBiomeRegistry.CRYSTAL_HOLLOW));
        crystalHollowIncursion.addBiomeLootEntry(new String[]{"omnicrystal", "amethyst", "sapphire", "emerald", "ruby", "pearlescentshard", "upgradeshard", "alchemyshard", "salmon", "carp", "rockfish", "terrorfish", "pearlfish"});
        crystalHollowIncursion.addMobEntries(new String[]{"crystalgolem", "crystalarmadillo", "shard_caveling", "crystal_caveling", "crystaldragon"});

        return true;
    }
}
