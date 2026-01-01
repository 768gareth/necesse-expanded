package NecesseExpanded.Patches.Gameplay;

import NecesseExpanded.Journal.PirateTrinketChallenge;
import necesse.engine.journal.*;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.registries.JournalChallengeRegistry;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.Advice.OnMethodEnter;
import net.bytebuddy.asm.Advice.This;

@ModMethodPatch(target = JournalChallengeRegistry.class, name = "registerCore", arguments = {})
public class JournalChallengesPatch 
{
    @OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter(@This JournalChallengeRegistry Registry) 
    {
            JournalChallengeRegistry.KILL_ZOMBIES_ID = JournalChallengeRegistry.registerChallenge("killzombies", new KillZombiesInForestSurfaceJournalChallenge());
            JournalChallengeRegistry.CAPTURE_COW_ID = JournalChallengeRegistry.registerChallenge("capturecow", new SimpleJournalChallenge());
            JournalChallengeRegistry.USE_MYSTERIOUS_PORTAL_ID = JournalChallengeRegistry.registerChallenge("usemysteriousportal", new SimpleJournalChallenge());
            JournalChallengeRegistry.FOREST_SURFACE_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("forestsurface", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.KILL_ZOMBIES_ID, JournalChallengeRegistry.CAPTURE_COW_ID, JournalChallengeRegistry.USE_MYSTERIOUS_PORTAL_ID})).setReward(JournalChallengeRegistry.FOREST_SURFACE_REWARD));
            
            JournalChallengeRegistry.BEAT_A_BEAR_ID = JournalChallengeRegistry.registerChallenge("beatabear", new DefeatMobJournalChallenge(new String[]{"grizzlybear"}));
            JournalChallengeRegistry.MINE_ORE_WITH_EXPLOSIVES_ID = JournalChallengeRegistry.registerChallenge("mineorewithexplosive", new MineOreWithExplosivesChallenge());
            JournalChallengeRegistry.DEFEAT_CAVELING_ID = JournalChallengeRegistry.registerChallenge("defeatcaveling", new DefeatMobJournalChallenge(new String[]{"stonecaveling"}));
            JournalChallengeRegistry.FOREST_CAVES_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("forestcave", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.BEAT_A_BEAR_ID, JournalChallengeRegistry.MINE_ORE_WITH_EXPLOSIVES_ID, JournalChallengeRegistry.DEFEAT_CAVELING_ID})).setReward(JournalChallengeRegistry.FOREST_CAVE_REWARD));
            
            JournalChallengeRegistry.CRAFT_TUNGSTEN_WEAPON_ID = JournalChallengeRegistry.registerChallenge("crafttungstenweapon", new CraftItemJournalChallenge(new String[]{"tungstensword", "tungstenspear", "tungstenbow", "tungstengreatbow", "tungstenboomerang"}));
            JournalChallengeRegistry.CRAFT_LIFE_ELIXIR_ID = JournalChallengeRegistry.registerChallenge("craftlifeelixir", new CraftItemJournalChallenge(new String[]{"lifeelixir"}));
            JournalChallengeRegistry.PLANT_LEMON_TREE_ID = JournalChallengeRegistry.registerChallenge("plantlemontree", new ObjectPlacedJournalChallenge(new String[]{"lemonsapling"}));
            JournalChallengeRegistry.FOREST_DEEP_CAVES_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("forestdeepcave", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.CRAFT_TUNGSTEN_WEAPON_ID, JournalChallengeRegistry.CRAFT_LIFE_ELIXIR_ID, JournalChallengeRegistry.PLANT_LEMON_TREE_ID})).setReward(JournalChallengeRegistry.FOREST_DEEP_CAVE_REWARD));
            
            JournalChallengeRegistry.CRAFT_RASPBERRY_JUICE_ID = JournalChallengeRegistry.registerChallenge("craftraspberryjuice", new CraftItemJournalChallenge(new String[]{"raspberryjuice"}));
            JournalChallengeRegistry.SMACK_LEAF_PILES_ID = JournalChallengeRegistry.registerChallenge("smackleafpiles", new ObjectsDestroyedJournalChallenge(20, new String[]{"leafpile"}));
            JournalChallengeRegistry.CAPTURE_BEE_ID = JournalChallengeRegistry.registerChallenge("capturebee", new SimpleJournalChallenge());
            JournalChallengeRegistry.PLAINS_SURFACE_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("plainssurface", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.CRAFT_RASPBERRY_JUICE_ID, JournalChallengeRegistry.SMACK_LEAF_PILES_ID, JournalChallengeRegistry.CAPTURE_BEE_ID})).setReward(JournalChallengeRegistry.PLAINS_SURFACE_REWARD));
            
            JournalChallengeRegistry.BREAK_RUNIC_BOULDERS_ID = JournalChallengeRegistry.registerChallenge("breakrunicboulder", new ObjectsDestroyedJournalChallenge(3, new String[]{"runicboulder"}));
            JournalChallengeRegistry.EQUIP_RUNIC_SET_ID = JournalChallengeRegistry.registerChallenge("equiprunicset", new EquippedArmorSetJournalChallenge("runicboots", "runicchestplate", new String[]{"runichat", "runichood", "runichelmet", "runiccrown"}));
            JournalChallengeRegistry.FELL_THE_CHIEFTAIN_ID = JournalChallengeRegistry.registerChallenge("fellthechieftain", new DefeatMobJournalChallenge(new String[]{"chieftain"}));
            JournalChallengeRegistry.PLAINS_CAVES_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("plainscave", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.BREAK_RUNIC_BOULDERS_ID, JournalChallengeRegistry.EQUIP_RUNIC_SET_ID, JournalChallengeRegistry.FELL_THE_CHIEFTAIN_ID})).setReward(JournalChallengeRegistry.PLAINS_CAVE_REWARD));
            
            JournalChallengeRegistry.CRAFT_DRYAD_WEAPON_ID = JournalChallengeRegistry.registerChallenge("craftdryadweapon", new CraftItemJournalChallenge(new String[]{"dryadgreathammer", "dryadbow", "dryadbarrage", "dryadbranch"}));
            JournalChallengeRegistry.POSSESSED_BY_FOREST_SPECTOR_ID = JournalChallengeRegistry.registerChallenge("possessedbyforestspector", new BecomePossessedByAForestSpectorJournalChallenge());
            JournalChallengeRegistry.WIN_TIC_TAC_TOE_VS_CRONE_ID = JournalChallengeRegistry.registerChallenge("wintictactoevscrone", new SimpleJournalChallenge());
            JournalChallengeRegistry.PLAINS_DEEP_CAVES_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("plainsdeepcave", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.CRAFT_DRYAD_WEAPON_ID, JournalChallengeRegistry.POSSESSED_BY_FOREST_SPECTOR_ID, JournalChallengeRegistry.WIN_TIC_TAC_TOE_VS_CRONE_ID})).setReward(JournalChallengeRegistry.PLAINS_DEEP_CAVE_REWARD));
            
            JournalChallengeRegistry.CATCH_ICEFISH_ID = JournalChallengeRegistry.registerChallenge("catchicefish", new SimpleJournalChallenge());
            JournalChallengeRegistry.PICKUP_SNOWBALLS_ID = JournalChallengeRegistry.registerChallenge("pickupsnowballs", new PickupItemsJournalChallenge(25, true, new String[]{"snowball"}));
            JournalChallengeRegistry.FIND_WET_ICICLE_ID = JournalChallengeRegistry.registerChallenge("findweticicle", new ItemObtainedJournalChallenge(new String[]{"weticicle"}));
            JournalChallengeRegistry.SNOW_SURFACE_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("snowsurface", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.CATCH_ICEFISH_ID, JournalChallengeRegistry.PICKUP_SNOWBALLS_ID, JournalChallengeRegistry.FIND_WET_ICICLE_ID})).setReward(JournalChallengeRegistry.SNOW_SURFACE_REWARD));
            
            int DEFEAT_DWARVEN_MAGES = JournalChallengeRegistry.registerChallenge("snow_defeatmages", new MobsKilledJournalChallenge(3, "frozen_dwarf_mage"));
            JournalChallengeRegistry.IMPALE_FIVE_ICE_JAVELINS_ID = JournalChallengeRegistry.registerChallenge("impalejavelins", new ImpaleIceJavelinsJournalChallenge());
            JournalChallengeRegistry.DESTROY_ROYAL_EGG_ID = JournalChallengeRegistry.registerChallenge("destroyroyalegg", new SimpleJournalChallenge());
            JournalChallengeRegistry.SNOW_CAVES_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("snowcave", (new MultiJournalChallenge(new Integer[]{DEFEAT_DWARVEN_MAGES, JournalChallengeRegistry.IMPALE_FIVE_ICE_JAVELINS_ID, JournalChallengeRegistry.DESTROY_ROYAL_EGG_ID})).setReward(JournalChallengeRegistry.SNOW_CAVE_REWARD));
            
            JournalChallengeRegistry.WALK_ON_DEEP_ICE_ID = JournalChallengeRegistry.registerChallenge("walkondeepice", new SimpleJournalChallenge());
            int DEFEAT_ICE_GOLEMS = JournalChallengeRegistry.registerChallenge("snow_defeatgolems", new MobsKilledJournalChallenge(5, "ice_golem"));
            JournalChallengeRegistry.SEVERAL_POTION_BUFFS_ID = JournalChallengeRegistry.registerChallenge("severalpotionbuffs", new SeveralPotionBuffsInDeepSnowCavesJournalChallenge());
            JournalChallengeRegistry.SNOW_DEEP_CAVES_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("snowdeepcave", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.WALK_ON_DEEP_ICE_ID, DEFEAT_ICE_GOLEMS, JournalChallengeRegistry.SEVERAL_POTION_BUFFS_ID})).setReward(JournalChallengeRegistry.SNOW_DEEP_CAVE_REWARD));
            
            JournalChallengeRegistry.FREE_CAPTURED_MAGE_ID = JournalChallengeRegistry.registerChallenge("freecapturedmage", new FreeMageJournalChallenge());
            JournalChallengeRegistry.UPGRADE_ALCHEMY_TABLE = JournalChallengeRegistry.registerChallenge("upgradealchemytable", new SimpleJournalChallenge());
            JournalChallengeRegistry.FIND_VOID_WIZARD_CHAMBER_ID = JournalChallengeRegistry.registerChallenge("findvoidwizardchamber", new LevelVisitedJournalChallenge(new String[]{"dungeonarena"}));
            JournalChallengeRegistry.DUNGEON_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("dungeon", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.FREE_CAPTURED_MAGE_ID, JournalChallengeRegistry.UPGRADE_ALCHEMY_TABLE, JournalChallengeRegistry.FIND_VOID_WIZARD_CHAMBER_ID})).setReward(JournalChallengeRegistry.DUNGEON_REWARD));
            
            JournalChallengeRegistry.CRAFT_ROASTED_FROG_LEG_ID = JournalChallengeRegistry.registerChallenge("craftroastedfrogleg", new CraftItemJournalChallenge(new String[]{"roastedfrogleg"}));
            JournalChallengeRegistry.PICK_UP_SWAMP_LARVAE_ID = JournalChallengeRegistry.registerChallenge("pickupswamplarvae", new PickupItemsJournalChallenge(10, true, new String[]{"swamplarva"}));
            JournalChallengeRegistry.GATHER_MUSHROOMS_ID = JournalChallengeRegistry.registerChallenge("gathermushrooms", new PickupItemsJournalChallenge(30, true, new String[]{"mushroom"}));
            JournalChallengeRegistry.SWAMP_SURFACE_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("swampsurface", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.CRAFT_ROASTED_FROG_LEG_ID, JournalChallengeRegistry.PICK_UP_SWAMP_LARVAE_ID, JournalChallengeRegistry.GATHER_MUSHROOMS_ID})).setReward(JournalChallengeRegistry.SWAMP_SURFACE_REWARD));
            
            JournalChallengeRegistry.CUT_SWAMP_THORNS_ID = JournalChallengeRegistry.registerChallenge("cutswampthorns", new CutSwampThornsJournalChallenge());
            JournalChallengeRegistry.CRAFT_IVY_TOOL_ID = JournalChallengeRegistry.registerChallenge("craftivytool", new CraftItemJournalChallenge(new String[]{"ivypickaxe", "ivyaxe", "ivyshovel"}));
            JournalChallengeRegistry.PARTY_IN_SWAMP_CAVES_ID = JournalChallengeRegistry.registerChallenge("partyinswampcaves", new PartyInSwampCavesJournalChallenge());
            JournalChallengeRegistry.SWAMP_CAVES_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("swampcave", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.CUT_SWAMP_THORNS_ID, JournalChallengeRegistry.CRAFT_IVY_TOOL_ID, JournalChallengeRegistry.PARTY_IN_SWAMP_CAVES_ID})).setReward(JournalChallengeRegistry.SWAMP_CAVE_REWARD));
            
            JournalChallengeRegistry.ENCHANT_AND_EQUIP_ARMOR_SET_ID = JournalChallengeRegistry.registerChallenge("enchantandequipset", new EnchantAndEquipJournalChallenge());
            JournalChallengeRegistry.CRAFT_DECAYING_LEAF_ID = JournalChallengeRegistry.registerChallenge("craftdecayingleaf", new CraftItemJournalChallenge(new String[]{"decayingleaf"}));
            JournalChallengeRegistry.CUT_SWAMP_COBWEB_ID = JournalChallengeRegistry.registerChallenge("cutswampcobweb", new CutSwampCobwebJournalChallenge());
            JournalChallengeRegistry.SWAMP_DEEP_CAVES_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("swampdeepcave", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.ENCHANT_AND_EQUIP_ARMOR_SET_ID, JournalChallengeRegistry.CRAFT_DECAYING_LEAF_ID, JournalChallengeRegistry.CUT_SWAMP_COBWEB_ID})).setReward(JournalChallengeRegistry.SWAMP_DEEP_CAVE_REWARD));
            
            JournalChallengeRegistry.FIND_INEFFICIENT_FEATHER_ID = JournalChallengeRegistry.registerChallenge("findinefficientfeather", new ItemObtainedJournalChallenge(new String[]{"inefficientfeather"}));
            JournalChallengeRegistry.EAT_COCONUT_ID = JournalChallengeRegistry.registerChallenge("eatcoconut", new FoodConsumedJournalChallenge(new String[]{"coconut"}));
            JournalChallengeRegistry.CRAFT_PALM_FURNITURE_ID = JournalChallengeRegistry.registerChallenge("craftpalmfurniture", new CraftItemJournalChallenge(new String[]{"palmchest", "palmdinnertable", "palmdesk", "palmmodulartable", "palmchair", "palmbench", "palmbookshelf", "palmcabinet", "palmbed", "palmdoublebed", "palmdresser", "palmclock", "palmcandelabra", "palmdisplay", "palmbathtub", "palmtoilet"}));
            JournalChallengeRegistry.DESERT_SURFACE_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("desertsurface", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.FIND_INEFFICIENT_FEATHER_ID, JournalChallengeRegistry.EAT_COCONUT_ID, JournalChallengeRegistry.CRAFT_PALM_FURNITURE_ID})).setReward(JournalChallengeRegistry.DESERT_SURFACE_REWARD));
            
            JournalChallengeRegistry.SMASH_VASES_ID = JournalChallengeRegistry.registerChallenge("smashvases", new DestroyVasesInDesertCaveJournalChallenge());
            JournalChallengeRegistry.EQUIP_SETTLER_QUARTZ_ID = JournalChallengeRegistry.registerChallenge("equipsettlerquartz", new EquipSettlerWithQuartzJournalChallenge());
            JournalChallengeRegistry.FIND_CAVELING_OASIS_ID = JournalChallengeRegistry.registerChallenge("findcavelingoasis", new SimpleJournalChallenge());
            JournalChallengeRegistry.DESERT_CAVES_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("desertcave", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.SMASH_VASES_ID, JournalChallengeRegistry.EQUIP_SETTLER_QUARTZ_ID, JournalChallengeRegistry.FIND_CAVELING_OASIS_ID})).setReward(JournalChallengeRegistry.DESERT_CAVE_REWARD));
            
            JournalChallengeRegistry.LOOT_DEEP_DESERT_TRINKET_ID = JournalChallengeRegistry.registerChallenge("lootdeepdeserttrinket", new ObtainDeepDesertTrinketJournalChallenge());
            JournalChallengeRegistry.ONESHOT_SKELETON_ID = JournalChallengeRegistry.registerChallenge("oneshotskeleton", new SimpleJournalChallenge());
            JournalChallengeRegistry.FIND_TEMPLE_BIOME_ID = JournalChallengeRegistry.registerChallenge("findtemplebiome", new LevelVisitedJournalChallenge(new String[]{"temple", "templearena"}));
            JournalChallengeRegistry.DESERT_DEEP_CAVES_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("desertdeepcave", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.LOOT_DEEP_DESERT_TRINKET_ID, JournalChallengeRegistry.ONESHOT_SKELETON_ID, JournalChallengeRegistry.FIND_TEMPLE_BIOME_ID})).setReward(JournalChallengeRegistry.DESERT_DEEP_CAVE_REWARD));
            
            JournalChallengeRegistry.FIND_SECRET_PAINTING_ID = JournalChallengeRegistry.registerChallenge("findsecretpainting", new ItemObtainedJournalChallenge(new String[]{"paintingcooljonas", "paintingelder"}));
            JournalChallengeRegistry.DEFEAT_OLD_NEMESIS_ID = JournalChallengeRegistry.registerChallenge("defeatoldnemesis", new DefeatMobJournalChallenge(new String[]{"fallenwizard"}));
            JournalChallengeRegistry.CRAFT_FALLEN_ALTAR_ID = JournalChallengeRegistry.registerChallenge("craftfallenaltar", new CraftItemJournalChallenge(new String[]{"fallenaltar"}));
            JournalChallengeRegistry.TEMPLE_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("temple", (new MultiJournalChallenge(new Integer[]{JournalChallengeRegistry.FIND_SECRET_PAINTING_ID, JournalChallengeRegistry.DEFEAT_OLD_NEMESIS_ID, JournalChallengeRegistry.CRAFT_FALLEN_ALTAR_ID})).setReward(JournalChallengeRegistry.TEMPLE_REWARD));
            
            int DEFEAT_PIRATE_CAPTAIN = JournalChallengeRegistry.registerChallenge("defeatpiratecaptain", new DefeatMobJournalChallenge(new String[]{"piratecaptain"}));
            JournalChallengeRegistry.FREE_CAPTURED_STYLIST_ID = JournalChallengeRegistry.registerChallenge("freecapturedstylist", new FreeStylistJournalChallenge());
            int FIND_PIRATE_TRINKET = JournalChallengeRegistry.registerChallenge("findpiratetrinket", new PirateTrinketChallenge());
            JournalChallengeRegistry.PIRATE_VILLAGE_CHALLENGES_ID = JournalChallengeRegistry.registerChallenge("forestpiratevillage", (new MultiJournalChallenge(new Integer[]{DEFEAT_PIRATE_CAPTAIN, JournalChallengeRegistry.FREE_CAPTURED_STYLIST_ID, FIND_PIRATE_TRINKET})).setReward(JournalChallengeRegistry.PIRATE_VILLAGE_REWARD));
            return true;
    }
}
