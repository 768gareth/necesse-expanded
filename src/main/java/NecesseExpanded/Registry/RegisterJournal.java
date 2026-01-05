package NecesseExpanded.Registry;

import necesse.engine.journal.JournalEntry;
import necesse.engine.registries.BiomeRegistry;
import necesse.engine.registries.JournalRegistry;
import necesse.engine.util.LevelIdentifier;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.LootTablePresets;

public class RegisterJournal 
{
    public static void Register()
    {
        JournalEntry HauntedSurface = JournalRegistry.registerJournalEntry("haunted_surface", new JournalEntry(BiomeRegistry.getBiome("haunted_biome"), LevelIdentifier.SURFACE_IDENTIFIER));
        
        HauntedSurface.addBiomeLootEntry
        (      
            new String[] 
            { 
                "deadwoodlog", "gobfish", "halffish", "furfish", "carp", "herring", 
                "mackerel", "salmon", "trout" 
            }
        );

        HauntedSurface.addMobEntries
        (
            new String[] 
            { 
                "haunted_zombie", "voidapprentice", "spider", "mouse"
            }
        );

        HauntedSurface.addTreasureEntry(new LootTable[] { LootTablePresets.surfaceRuinsChest });

        JournalEntry HauntedCaves = JournalRegistry.registerJournalEntry("haunted_caves", new JournalEntry(BiomeRegistry.getBiome("haunted_biome"), LevelIdentifier.CAVE_IDENTIFIER));


        JournalEntry HauntedDeepCaves = JournalRegistry.registerJournalEntry("haunted_deep_caves", new JournalEntry(BiomeRegistry.getBiome("haunted_biome"), LevelIdentifier.DEEP_CAVE_IDENTIFIER));


        JournalEntry TropicalSurface = JournalRegistry.registerJournalEntry("tropical_surface", new JournalEntry(BiomeRegistry.getBiome("tropical_biome"), LevelIdentifier.SURFACE_IDENTIFIER));


        JournalEntry TropicalCaves = JournalRegistry.registerJournalEntry("tropical_caves", new JournalEntry(BiomeRegistry.getBiome("tropical_biome"), LevelIdentifier.CAVE_IDENTIFIER));


        JournalEntry TropicalDeepCaves = JournalRegistry.registerJournalEntry("tropical_deep_caves", new JournalEntry(BiomeRegistry.getBiome("tropical_biome"), LevelIdentifier.DEEP_CAVE_IDENTIFIER));
    }
}
