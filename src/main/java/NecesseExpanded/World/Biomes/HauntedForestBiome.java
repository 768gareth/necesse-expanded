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
import necesse.level.gameTile.GameTile;
import necesse.level.maps.Level;
import necesse.level.maps.biomes.Biome;
import necesse.level.maps.biomes.FishingLootTable;
import necesse.level.maps.biomes.FishingSpot;
import necesse.level.maps.biomes.MobSpawnTable;
import necesse.level.maps.presets.RandomCaveChestRoom;
import necesse.level.maps.presets.caveRooms.CaveRuins;
import necesse.level.maps.regionSystem.Region;

public class HauntedForestBiome extends Biome 
{
    public static FishingLootTable SurfaceFish = new FishingLootTable().addAll(Biome.defaultSurfaceFish);
    public static FishingLootTable CaveFish = new FishingLootTable().addAll(Biome.defaultCaveFish);
    public static FishingLootTable DeepCaveFish = new FishingLootTable().addWater(100, "heartfish");
    public static MobSpawnTable SurfaceMobs = new MobSpawnTable().add(25, "haunted_zombie").add(25, "voidapprentice");
    public static MobSpawnTable CaveMobs = new MobSpawnTable().add(25, "enchantedzombie").add(25, "enchantedzombiearcher");
    public static MobSpawnTable DeepCaveMobs = new MobSpawnTable().add(25, "skeleton");
    public static MobSpawnTable SurfaceCritters = new MobSpawnTable()
    .add(100, "swampslug")
    .add(80, "frog")
    .add(40, "bird")
    .add(40, "cardinalbird");
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
    public AbstractMusicList getLevelMusic(Level level, PlayerMob perspective) 
    {
        return new MusicList(MusicRegistry.InvasionoftheCrypt);
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
        return ObjectRegistry.rockID;
    }

    @Override
    public int getGenerationCaveTileID() 
    {
        return TileRegistry.cryptAshID;
    }

    public int getGenerationDeepCaveTileID() {
        return TileRegistry.cryptAshID;
     }
  
     public int getGenerationDeepCaveRockObjectID() {
        return ObjectRegistry.deepSwampRockID;
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
    }

    @Override
    public void generateRegionSurfaceTerrain(Region region, BiomeGeneratorStack stack, GameRandom random) 
    {
        super.generateRegionSurfaceTerrain(region, stack, random);
        int GrassTile = TileRegistry.getTileID("haunted_grass_tile");
        stack.startPlaceOnVein(this, region, random, "hauntedMudPatches").onlyOnTile(GrassTile).chance(0.8).placeTile(TileRegistry.mudID);
        stack.startPlaceOnVein(this, region, random, "deadwoodTrees").onlyOnTile(GrassTile).chance(0.2).placeObject("deadwoodtree");
        stack.startPlace(this, region, random).chance(0.003).placeObject("swampsurfacerock");
        stack.startPlace(this, region, random).chance(0.005).placeObject("swampsurfacerocksmall");
        region.updateLiquidManager();
        region.simulateWorldTime(10000000, true);
    }

    @Override
    public void generateRegionCaveTerrain(Region region, BiomeGeneratorStack stack, GameRandom random) {
        super.generateRegionCaveTerrain(region, stack, random);
        region.updateLiquidManager();
        region.simulateWorldTime(10000000, true);
    }

    @Override
    public void generateRegionDeepCaveTerrain(Region region, BiomeGeneratorStack stack, GameRandom random) {
        super.generateRegionDeepCaveTerrain(region, stack, random);
        region.updateLiquidManager();
        region.simulateWorldTime(10000000, true);
    }

    @Override
    public CaveRuins getNewCaveRuinsPreset(GameRandom random, AtomicInteger lootRotation) {
        return null;
    }

    @Override
    public CaveRuins getNewDeepCaveRuinsPreset(GameRandom random, AtomicInteger lootRotation) {
        return null;
    }

    @Override
    public RandomCaveChestRoom getNewCaveChestRoomPreset(GameRandom random, AtomicInteger lootRotation) {
        return null;
    }

    @Override
    public RandomCaveChestRoom getNewDeepCaveChestRoomPreset(GameRandom random, AtomicInteger lootRotation) {
        return null;
    }
}