package NecesseExpanded.World.WorldPresets;

import java.awt.Dimension;
import java.awt.Point;
import NecesseExpanded.World.Presets.DryadHousePreset;
import necesse.engine.gameLoop.tickManager.PerformanceTimerManager;
import necesse.engine.registries.BiomeRegistry;
import necesse.engine.util.GameRandom;
import necesse.engine.util.LevelIdentifier;
import necesse.engine.world.biomeGenerator.BiomeGeneratorStack;
import necesse.engine.world.worldPresets.LevelPresetsRegion;
import necesse.engine.world.worldPresets.WorldPreset;
import necesse.level.maps.Level;
import necesse.level.maps.presets.Preset;
import necesse.level.maps.presets.PresetUtils;

public class DryadHouseWorldPreset extends WorldPreset {
  protected Dimension size = new Dimension(14, 15);
  
  public boolean shouldAddToRegion(LevelPresetsRegion presetsRegion) {
    return (presetsRegion.identifier.equals(LevelIdentifier.SURFACE_IDENTIFIER) && presetsRegion
      .hasAnyOfBiome(BiomeRegistry.PLAINS.getID()));
  }
  
  public void addToRegion(GameRandom random, LevelPresetsRegion presetsRegion, final BiomeGeneratorStack generatorStack, PerformanceTimerManager performanceTimer) {
    int total = getTotalBiomePoints(random, presetsRegion, BiomeRegistry.PLAINS, 0.008F);
    for (int i = 0; i < total; i++) {
      final Point tile = findRandomBiomePresetTile(random, presetsRegion, generatorStack, BiomeRegistry.PLAINS, 50, this.size, new String[] { "loot", "villages" }, new WorldPreset.ValidTilePredicate() {
            public boolean isValidPosition(int tileX, int tileY) {
              return (!generatorStack.isSurfaceExpensiveWater(tileX, tileY) && generatorStack
              .getLazyBiomeID(tileX, tileY) == BiomeRegistry.PLAINS.getID());
            }});
      if (tile != null)
        presetsRegion.addPreset(this, tile.x, tile.y, this.size, new String[] { "loot", "villages" }, new LevelPresetsRegion.WorldPresetPlaceFunction() {
              public void place(GameRandom random, Level level, PerformanceTimerManager timer) 
              {
                WorldPreset.ensureRegionsAreGenerated(level, tile.x, tile.y, 11, 9);
                DryadHousePreset preset = new DryadHousePreset();
                PresetUtils.clearMobsInPreset((Preset)preset, level, tile.x, tile.y);
                preset.applyToLevel(level, tile.x, tile.y);
              }
            }).setRemoveIfWithinSpawnRegionRange(1); 
    } 
  }
}
