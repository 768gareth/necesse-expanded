package NecesseExpanded.World.Biomes;

import java.util.concurrent.atomic.AtomicInteger;
import necesse.engine.AbstractMusicList;
import necesse.engine.MusicList;
import necesse.engine.registries.MusicRegistry;
import necesse.engine.registries.ObjectLayerRegistry;
import necesse.engine.registries.ObjectRegistry;
import necesse.engine.registries.TileRegistry;
import necesse.engine.sound.SoundSettings;
import necesse.engine.sound.SoundSettingsRegistry;
import necesse.engine.util.GameRandom;
import necesse.engine.util.LevelIdentifier;
import necesse.engine.world.biomeGenerator.BiomeGeneratorStack;
import necesse.engine.world.biomeGenerator.GeneratorPlaceFactory;
import necesse.entity.mobs.PlayerMob;
import necesse.level.gameObject.GameObject;
import necesse.level.gameTile.GameTile;
import necesse.level.maps.Level;
import necesse.level.maps.biomes.Biome;
import necesse.level.maps.biomes.FishingLootTable;
import necesse.level.maps.biomes.FishingSpot;
import necesse.level.maps.biomes.MobSpawnTable;
import necesse.level.maps.presets.RandomCaveChestRoom;
import necesse.level.maps.presets.caveRooms.CaveRuins;
import necesse.level.maps.regionSystem.Region;

public class TropicalBiome extends Biome 
{
    public static FishingLootTable SurfaceFish = new FishingLootTable().addAll(Biome.defaultSurfaceFish);
    public static FishingLootTable CaveFish = new FishingLootTable().addAll(Biome.defaultCaveFish);
    public static FishingLootTable DeepCaveFish = new FishingLootTable().addWater(100, "heartfish");
    public static MobSpawnTable SurfaceMobs = new MobSpawnTable().add(25, "zombie");
    public static MobSpawnTable CaveMobs = new MobSpawnTable().add(25, "zombie");
    public static MobSpawnTable DeepCaveMobs = new MobSpawnTable().add(25, "zombie");
    public static MobSpawnTable SurfaceCritters = new MobSpawnTable()
    .add(100, "swampslug")
    .add(100, "crab")
    .add(80, "frog")
    .add(40, "bird")
    .add(40, "cardinalbird");
    public static MobSpawnTable CaveCritters = new MobSpawnTable().include(defaultCaveCritters);
    public static MobSpawnTable DeepCaveCritters = new MobSpawnTable().include(defaultCaveCritters);

    public TropicalBiome() {  }

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
        return new MusicList(MusicRegistry.ByTheField);
    }

    @Override
    public GameTile getUnderLiquidTile(Level level, int tileX, int tileY) 
    {
        return TileRegistry.getTile(TileRegistry.sandID);
    }

    @Override
    public int getGenerationWaterTileID() {

        return TileRegistry.waterID;
    }

    @Override
    public int getGenerationCaveLavaTileID() 
    {
        return TileRegistry.waterID;
    }

    @Override
    public int getGenerationDeepCaveLavaTileID() 
    {
        return TileRegistry.waterID;
    }

    @Override
    public int getGenerationTerrainTileID() 
    {
        return TileRegistry.overgrownGrassID;
    }

    @Override
    public int getGenerationCaveRockObjectID() 
    {
        return ObjectRegistry.swampRockID;
    }

    @Override
    public int getGenerationCaveTileID() 
    {
        return TileRegistry.overgrownGrassID;
    }

    public int getGenerationDeepCaveTileID() {
        return TileRegistry.overgrownGrassID;
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
        stack.addRandomSimplexVeinsBranch("tropicalPalmTrees", 2.0F, 0.2F, 0.4F, 0);
        stack.addRandomVeinsBranch("tropicalBushes", 0.045F, 3, 5, 0.3F, 0, false);
        stack.addRandomSimplexVeinsBranch("tropicalMudPatches", 2.0F, 0.5F, 0.7F, 2);
        stack.addRandomSimplexVeinsBranch("tropicalGrassPatches", 3.5F, 0.85F, 0.9F, 2);

        stack.addRandomSimplexVeinsBranch("tropicalCaveWaterGrass", 2.0F, 0.33F, 1.0F, 0);
        stack.addRandomVeinsBranch("tropicalClay", 0.9F, 5, 10, 0.4F, 2, false);
        stack.addRandomVeinsBranch("tropicalCopper", 0.72F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("tropicalIron", 0.56F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("tropicalGold", 0.16F, 3, 6, 0.4F, 2, false);

        stack.addRandomVeinsBranch("tropicalWildCaveGlow", 0.32F, 4, 8, 0.4F, 2, false);
        stack.addRandomVeinsBranch("tropicalDeepCopper", 0.08F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("tropicalDeepIron", 0.4F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("tropicalDeepGold", 0.24F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("tropicalDeepTungsten", 0.32F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("tropicalDeepLifeQuartz", 0.08F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("tropicalDeepObsidian", 0.4F, 5, 10, 0.4F, 2, false);
    }

    @Override
    public void generateRegionSurfaceTerrain(Region region, BiomeGeneratorStack stack, GameRandom random) 
    {
        super.generateRegionSurfaceTerrain(region, stack, random);
        stack.startPlaceOnVein(this, region, random, "tropicalGrassPatches").onlyOnTile(TileRegistry.overgrownGrassID).chance(0.8).placeTile(TileRegistry.grassID);
        stack.startPlaceOnVein(this, region, random, "tropicalPalmTrees").onlyOnTile(TileRegistry.overgrownGrassID).chance(0.23).placeObject("palmtree");
        stack.startPlaceOnVein(this, region, random, "tropicalPalmTrees").onlyOnTile(TileRegistry.overgrownGrassID).chance(0.01).placeObject("bananatree");
        stack.startPlaceOnVein(this, region, random, "tropicalBushes").onlyOnTile(TileRegistry.overgrownGrassID).placeObjectFruitGrower("blueberrybush");
        stack.startPlaceOnVein(this, region, random, "tropicalBushes").onlyOnTile(TileRegistry.overgrownGrassID).placeObjectFruitGrower("blackberrybush");
        final GameObject wildMushroom = ObjectRegistry.getObject("wildmushroom");
        stack.startPlaceOnVein(this, region, random, "tropicalMudPatches").onlyOnTile(TileRegistry.overgrownGrassID)
        .customPlace(new GeneratorPlaceFactory.RegionPlaceFunction() 
        {
            public void place(GameRandom random, Region region, int regionTileX, int regionTileY, Level level, int tileX, int tileY) 
            {
                if (random.getChance(0.6F))
                {
                    region.tileLayer.setTileByRegion(regionTileX, regionTileY, TileRegistry.mudID);
                }
                if (region.objectLayer.getObjectIDByRegion(ObjectLayerRegistry.BASE_LAYER, regionTileX, regionTileY) == 0 && random.getChance(0.15F) && wildMushroom.canPlace(level, tileX, tileY, 0, false) == null)
                {
                    wildMushroom.placeObject(level, tileX, tileY, 0, false);
                }
          }
        });
        stack.startPlace(this, region, random).chance(0.003).placeObject("swampsurfacerock");
        stack.startPlace(this, region, random).chance(0.005).placeObject("swampsurfacerocksmall");
        region.updateLiquidManager();
        region.simulateWorldTime(10000000, true);
    }

    @Override
    public void generateRegionCaveTerrain(Region region, BiomeGeneratorStack stack, GameRandom random) {
        super.generateRegionCaveTerrain(region, stack, random);
        stack.startPlace(this, region, random).chance(0.029999999329447746D).placeCrates(new String[] { "crate" });
        stack.startPlace(this, region, random).chance(0.003).placeObject("swampsurfacerock");
        stack.startPlace(this, region, random).chance(0.005).placeObject("swampsurfacerocksmall");
        stack.startPlaceOnVein(this, region, random, "tropicalCaveWaterGrass").chance(0.30000001192092896D).placeObject("cavewatergrass");
        stack.startPlaceOnVein(this, region, random, "tropicalClay").onlyOnObject(ObjectRegistry.rockID).placeObjectForced("clayrock");
        stack.startPlaceOnVein(this, region, random, "tropicalCopper").onlyOnObject(ObjectRegistry.rockID).placeObjectForced("copperorerock");
        stack.startPlaceOnVein(this, region, random, "tropicalIron").onlyOnObject(ObjectRegistry.rockID).placeObjectForced("ironorerock");
        stack.startPlaceOnVein(this, region, random, "tropicalGold").onlyOnObject(ObjectRegistry.rockID).placeObjectForced("goldorerock");
        region.updateLiquidManager();
        region.simulateWorldTime(10000000, true);
    }

    @Override
    public void generateRegionDeepCaveTerrain(Region region, BiomeGeneratorStack stack, GameRandom random) {
        super.generateRegionDeepCaveTerrain(region, stack, random);
        stack.startPlace(this, region, random).chance(0.029999999329447746D).placeCrates(new String[] { "crate" });
        stack.startPlaceOnVein(this, region, random, "tropicalWildCaveGlow").onlyOnTile(TileRegistry.deepSwampRockID).chance(0.20000000298023224D).placeObject("wildcaveglow");
        stack.startPlaceOnVein(this, region, random, "tropicalDeepCopper").onlyOnObject(ObjectRegistry.deepSwampRockID).placeObjectForced("copperoredeepswamprock");
        stack.startPlaceOnVein(this, region, random, "tropicalDeepIron").onlyOnObject(ObjectRegistry.deepSwampRockID).placeObjectForced("ironoredeepswamprock");
        stack.startPlaceOnVein(this, region, random, "tropicalDeepGold").onlyOnObject(ObjectRegistry.deepSwampRockID).placeObjectForced("goldoredeepswamprock");
        stack.startPlaceOnVein(this, region, random, "tropicalDeepObsidian").onlyOnObject(ObjectRegistry.deepSwampRockID).placeObjectForced("obsidianrock");
        stack.startPlaceOnVein(this, region, random, "tropicalDeepTungsten").onlyOnObject(ObjectRegistry.deepSwampRockID).placeObjectForced("tungstenoredeepswamprock");
        stack.startPlaceOnVein(this, region, random, "tropicalDeepLifeQuartz").onlyOnObject(ObjectRegistry.deepSwampRockID).placeObjectForced("lifequartzdeepswamprock");
        stack.startPlace(this, region, random).chance(0.003).placeObject("swampsurfacerock");
        stack.startPlace(this, region, random).chance(0.005).placeObject("swampsurfacerocksmall");
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