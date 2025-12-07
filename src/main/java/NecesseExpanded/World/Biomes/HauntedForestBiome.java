package NecesseExpanded.World.Biomes;

import java.util.concurrent.atomic.AtomicInteger;
import necesse.engine.AbstractMusicList;
import necesse.engine.MusicList;
import necesse.engine.registries.MusicRegistry;
import necesse.engine.registries.ObjectRegistry;
import necesse.engine.registries.TileRegistry;
import necesse.engine.sound.SoundSettings;
import necesse.engine.sound.SoundSettingsRegistry;
import necesse.engine.util.GameRandom;
import necesse.engine.util.LevelIdentifier;
import necesse.engine.world.biomeGenerator.BiomeGeneratorStack;
import necesse.entity.mobs.PlayerMob;
import necesse.inventory.lootTable.LootTablePresets;
import necesse.level.gameTile.GameTile;
import necesse.level.maps.Level;
import necesse.level.maps.biomes.Biome;
import necesse.level.maps.biomes.FishingLootTable;
import necesse.level.maps.biomes.FishingSpot;
import necesse.level.maps.biomes.MobSpawnTable;
import necesse.level.maps.presets.RandomCaveChestRoom;
import necesse.level.maps.presets.caveRooms.CaveRuins;
import necesse.level.maps.presets.set.ChestRoomSet;
import necesse.level.maps.presets.set.FurnitureSet;
import necesse.level.maps.presets.set.WallSet;
import necesse.level.maps.regionSystem.Region;

public class HauntedForestBiome extends Biome 
{
    public static FishingLootTable SurfaceFish = new FishingLootTable().addAll(Biome.defaultSurfaceFish);
    public static FishingLootTable CaveFish = new FishingLootTable().addAll(Biome.defaultCaveFish);
    public static FishingLootTable DeepCaveFish = new FishingLootTable().addWater(100, "heartfish");
    public static MobSpawnTable SurfaceMobs = new MobSpawnTable().add(80, "haunted_zombie").add(20, "voidapprentice");
    public static MobSpawnTable CaveMobs = new MobSpawnTable().add(50, "enchantedzombie").add(50, "enchantedzombiearcher");
    public static MobSpawnTable DeepCaveMobs = new MobSpawnTable().add(25, "skeleton");
    public static MobSpawnTable SurfaceCritters = new MobSpawnTable().add(100, "spider").add(100, "mouse");
    public static MobSpawnTable CaveCritters = new MobSpawnTable().include(defaultCaveCritters);
    public static MobSpawnTable DeepCaveCritters = new MobSpawnTable().include(defaultCaveCritters);

    public HauntedForestBiome() {  }

    @Override
    public boolean canRain(Level level) 
    {
        return true;
    }

    @Override
    public FishingLootTable getFishingLootTable(FishingSpot Spot) 
    {
        if (Spot.tile.level.getIdentifier() == LevelIdentifier.DEEP_CAVE_IDENTIFIER)
        {
            return DeepCaveFish;
        }
        else if (Spot.tile.level.isCave)
        {
            return CaveFish;
        }
        else
        {
            return SurfaceFish;
        }
    }

    @Override
    public MobSpawnTable getCritterSpawnTable(Level Level) 
    {
        if (Level.getIdentifier() == LevelIdentifier.DEEP_CAVE_IDENTIFIER)
        {
            return DeepCaveCritters;
        }
        else if (Level.isCave)
        {
            return CaveCritters;
        }
        else
        {
            return SurfaceCritters;
        }
    }

    @Override
    public MobSpawnTable getMobSpawnTable(Level Level) 
    {
        if (Level.getIdentifier() == LevelIdentifier.DEEP_CAVE_IDENTIFIER)
        {
            return DeepCaveMobs;
        }
        else if (Level.isCave)
        {
            return CaveMobs;
        }
        else
        {
            return SurfaceMobs;
        }
    }

    @Override
    public AbstractMusicList getLevelMusic(Level Level, PlayerMob perspective) 
    {
        if (Level.getIdentifier() == LevelIdentifier.DEEP_CAVE_IDENTIFIER)
        {
            return new MusicList(MusicRegistry.GrindTheAlarms);
        }
        else if (Level.isCave)
        {
            return new MusicList(MusicRegistry.CaravanTusks);
        }
        else
        {
            return new MusicList(MusicRegistry.SilverLake);
        }
    }

    @Override
    public GameTile getUnderLiquidTile(Level level, int tileX, int tileY) 
    {
        return TileRegistry.getTile(TileRegistry.dirtID);
    }

    @Override
    public int getGenerationWaterTileID() {

        return TileRegistry.waterID;
    }

    @Override
    public int getGenerationCaveLavaTileID() 
    {
        return TileRegistry.lavaID;
    }

    @Override
    public int getGenerationDeepCaveLavaTileID() 
    {
        return TileRegistry.lavaID;
    }

    @Override
    public int getGenerationTerrainTileID() 
    {
        return TileRegistry.getTileID("haunted_grass_tile");
    }

    @Override
    public int getGenerationCaveRockObjectID() 
    {
        return ObjectRegistry.getObjectID("haunted_rock");
    }

    @Override
    public int getGenerationCaveTileID() 
    {
        return TileRegistry.getTileID("haunted_rock_tile");
    }

    public int getGenerationDeepCaveTileID() 
    {
        return TileRegistry.getTileID("haunted_rock_tile");
    }
  
    public int getGenerationDeepCaveRockObjectID() 
    {
    return ObjectRegistry.getObjectID("deep_haunted_rock");
    }

    public int getGenerationBeachTileID() 
    {
        return TileRegistry.sandID;
    }

    public SoundSettings getWindSound(Level level) 
    {
    return SoundSettingsRegistry.wind;
    }

    @Override
    public void initializeGeneratorStack(BiomeGeneratorStack stack) 
    {
        super.initializeGeneratorStack(stack);
        stack.addRandomSimplexVeinsBranch("deadwoodTrees", 2.0F, 0.2F, 0.4F, 0);
        stack.addRandomSimplexVeinsBranch("hauntedMudPatches", 2.0F, 0.5F, 0.7F, 2);
        stack.addRandomVeinsBranch("hauntedClay", 0.9F, 5, 10, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedCopper", 0.72F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedIron", 0.56F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedGold", 0.16F, 3, 6, 0.4F, 2, false);

        stack.addRandomVeinsBranch("hauntedWildCaveGlow", 0.32F, 4, 8, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedDeepCopper", 0.08F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedDeepIron", 0.4F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedDeepGold", 0.24F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedDeepTungsten", 0.32F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedDeepLifeQuartz", 0.08F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedDeepObsidian", 0.4F, 5, 10, 0.4F, 2, false);
    }

    @Override
    public void generateRegionSurfaceTerrain(Region region, BiomeGeneratorStack stack, GameRandom random) 
    {
        super.generateRegionSurfaceTerrain(region, stack, random);
        int GrassTile = TileRegistry.getTileID("haunted_grass_tile");
        stack.startPlaceOnVein(this, region, random, "hauntedMudPatches").onlyOnTile(GrassTile).chance(0.8).placeTile(TileRegistry.mudID);
        stack.startPlaceOnVein(this, region, random, "deadwoodTrees").onlyOnTile(GrassTile).chance(0.25).placeObject("deadwoodtree");
        stack.startPlace(this, region, random).chance(0.004).placeObject("haunted_rock_small");
        stack.startPlace(this, region, random).chance(0.002).placeObject("haunted_rock_large");
        region.updateLiquidManager();
        region.simulateWorldTime(10000000, true);
    }

    @Override
    public void generateRegionCaveTerrain(Region region, BiomeGeneratorStack stack, GameRandom random) {
        super.generateRegionCaveTerrain(region, stack, random);
        stack.startPlace(this, region, random).chance(0.029999999329447746D).placeCrates(new String[] { "crate" });
        int RockID = ObjectRegistry.getObjectID("haunted_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedClay").onlyOnObject(RockID).placeObjectForced("clayrock");
        stack.startPlaceOnVein(this, region, random, "hauntedCopper").onlyOnObject(RockID).placeObjectForced("copper_ore_haunted_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedIron").onlyOnObject(RockID).placeObjectForced("iron_ore_haunted_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedGold").onlyOnObject(RockID).placeObjectForced("gold_ore_haunted_rock");
        stack.startPlace(this, region, random).chance(0.004).placeObject("haunted_rock_small");
        stack.startPlace(this, region, random).chance(0.002).placeObject("haunted_rock_large");
        region.updateLiquidManager();
    }

    @Override
    public void generateRegionDeepCaveTerrain(Region region, BiomeGeneratorStack stack, GameRandom random) {
        super.generateRegionDeepCaveTerrain(region, stack, random);
        stack.startPlace(this, region, random).chance(0.029999999329447746D).placeCrates(new String[] { "crate" });
        int RockID = ObjectRegistry.getObjectID("deep_haunted_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedWildCaveGlow").onlyOnTile(RockID).chance(0.20000000298023224D).placeObject("wildcaveglow");
        stack.startPlaceOnVein(this, region, random, "hauntedDeepCopper").onlyOnObject(RockID).placeObjectForced("copper_ore_deep_haunted_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedDeepIron").onlyOnObject(RockID).placeObjectForced("iron_ore_deep_haunted_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedDeepGold").onlyOnObject(RockID).placeObjectForced("gold_ore_deep_haunted_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedDeepObsidian").onlyOnObject(RockID).placeObjectForced("obsidianrock");
        stack.startPlaceOnVein(this, region, random, "hauntedDeepTungsten").onlyOnObject(RockID).placeObjectForced("tungsten_ore_deep_haunted_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedDeepLifeQuartz").onlyOnObject(RockID).placeObjectForced("life_quartz_deep_haunted_rock");
        stack.startPlace(this, region, random).chance(0.004).placeObject("haunted_rock_small");
        stack.startPlace(this, region, random).chance(0.003).placeObject("haunted_rock_large");
        region.updateLiquidManager();
    }

    public RandomCaveChestRoom getNewCaveChestRoomPreset(GameRandom random, AtomicInteger lootRotation) {
    RandomCaveChestRoom chestRoom = new RandomCaveChestRoom(random, LootTablePresets.basicCaveChest, lootRotation, new ChestRoomSet[] { ChestRoomSet.stone, ChestRoomSet.wood });
    chestRoom.replaceTile(TileRegistry.stoneFloorID, ((Integer)random.getOneOf((Object[])new Integer[] { Integer.valueOf(TileRegistry.stoneFloorID), Integer.valueOf(TileRegistry.stoneBrickFloorID) })).intValue());
    return chestRoom;
  }
  
  public RandomCaveChestRoom getNewDeepCaveChestRoomPreset(GameRandom random, AtomicInteger lootRotation) {
    RandomCaveChestRoom chestRoom = new RandomCaveChestRoom(random, LootTablePresets.deepCaveChest, lootRotation, new ChestRoomSet[] { ChestRoomSet.deepStone, ChestRoomSet.obsidian });
    chestRoom.replaceTile(TileRegistry.deepStoneFloorID, ((Integer)random.getOneOf((Object[])new Integer[] { Integer.valueOf(TileRegistry.deepStoneFloorID), Integer.valueOf(TileRegistry.deepStoneBrickFloorID) })).intValue());
    return chestRoom;
  }
  
  public CaveRuins getNewCaveRuinsPreset(GameRandom random, AtomicInteger lootRotation) {
    WallSet wallSet = (WallSet)random.getOneOf((Object[])new WallSet[] { WallSet.stone, WallSet.wood });
    FurnitureSet furnitureSet = FurnitureSet.deadwood;
    String floorStringID = (String)random.getOneOf((Object[])new String[] { "stonefloor", "stonebrickfloor" });
    return ((CaveRuins.CaveRuinGetter)random.getOneOf(CaveRuins.caveRuinGetters))
      .get(random, wallSet, furnitureSet, floorStringID, LootTablePresets.basicCaveRuinsChest, lootRotation);
  }
  
  public CaveRuins getNewDeepCaveRuinsPreset(GameRandom random, AtomicInteger lootRotation) {
    WallSet wallSet = (WallSet)random.getOneOf((Object[])new WallSet[] { WallSet.deepStone, WallSet.obsidian });
    FurnitureSet furnitureSet = FurnitureSet.bone;
    String floorStringID = (String)random.getOneOf((Object[])new String[] { "deepstonefloor", "deepstonebrickfloor" });
    return ((CaveRuins.CaveRuinGetter)random.getOneOf(CaveRuins.caveRuinGetters))
      .get(random, wallSet, furnitureSet, floorStringID, LootTablePresets.basicDeepCaveRuinsChest, lootRotation);
  }
}