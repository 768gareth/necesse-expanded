package NecesseExpanded.World.Levels;

import NecesseExpanded.World.Presets.FishianShrinePreset;
import necesse.engine.GameEvents;
import necesse.engine.events.GameEvent;
import necesse.engine.events.PreventableGameEvent;
import necesse.engine.events.worldGeneration.GenerateCaveLayoutEvent;
import necesse.engine.events.worldGeneration.GenerateCaveMiniBiomesEvent;
import necesse.engine.events.worldGeneration.GenerateCaveOresEvent;
import necesse.engine.events.worldGeneration.GenerateCaveStructuresEvent;
import necesse.engine.events.worldGeneration.GeneratedCaveLayoutEvent;
import necesse.engine.events.worldGeneration.GeneratedCaveMiniBiomesEvent;
import necesse.engine.events.worldGeneration.GeneratedCaveOresEvent;
import necesse.engine.events.worldGeneration.GeneratedCaveStructuresEvent;
import necesse.engine.localization.message.GameMessage;
import necesse.engine.localization.message.LocalMessage;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.BiomeRegistry;
import necesse.engine.registries.ObjectRegistry;
import necesse.engine.registries.TileRegistry;
import necesse.engine.util.GameRandom;
import necesse.engine.util.LevelIdentifier;
import necesse.engine.world.WorldEntity;
import necesse.level.gameObject.GameObject;
import necesse.level.maps.Level;
import necesse.level.maps.generationModules.CaveGeneration;
import necesse.level.maps.generationModules.CellAutomaton;
import necesse.level.maps.generationModules.GenerationTools;
import necesse.level.maps.generationModules.LinesGeneration;
import necesse.level.maps.generationModules.PresetGeneration;

public class FishianDeepCaveLevel extends Level {
   public FishianDeepCaveLevel(LevelIdentifier identifier, int width, int height, WorldEntity worldEntity) {
      super(identifier, width, height, worldEntity);
    }
    
    public FishianDeepCaveLevel(LevelIdentifier identifier, WorldEntity worldEntity) {
      super(identifier, 200, 200, worldEntity);
      this.baseBiome = BiomeRegistry.getBiome("fishian_cave");
      this.isCave = true;
      generateLevel();
    }

   public void onLoadingComplete() {
      super.onLoadingComplete();
      this.baseBiome = BiomeRegistry.getBiome("fishian_cave");
   }

   public GameMessage getSetSpawnError(int x, int y, ServerClient client) {
      return new LocalMessage("misc", "spawndungeon");
   }

   public void generateLevel() {
      CaveGeneration cg = new CaveGeneration(this, TileRegistry.getTileStringID(TileRegistry.puddleCobble),
            ObjectRegistry.getObjectStringID(ObjectRegistry.deepSwampRockID));
      GameEvents.triggerEvent(new GenerateCaveLayoutEvent(this, cg), (e) -> {
         cg.generateLevel();
      });
      GameEvents.triggerEvent(new GeneratedCaveLayoutEvent(this, cg));
      GameEvents.triggerEvent(new GenerateCaveMiniBiomesEvent(this, cg), (e) -> {
         GenerationTools.generateRandomSmoothTileVeins(this, cg.random, 0.06F, 2, 8.0F, 10.0F, 6.0F, 12.0F,
               TileRegistry.getTileID("watertile"), 1.0F, true);
      });
      GenerationTools.generateRandomPoints(this, cg.random, 0.08F, 32, (initialPos) -> {
         LinesGeneration lg = (new LinesGeneration(initialPos.x, initialPos.y)).addRandomArms(cg.random, 4, 8.0F, 12.0F,
               8.0F, 12.0F);
         CellAutomaton ca = lg.doCellularAutomaton(cg.random);
         ca.forEachTile(this, (level, tileX, tileY) -> {
            level.setObject(tileX, tileY, 0);
         });
         ca.forEachTile(this, (l, tileX, tileY) -> {
            if (cg.random.getChance(0.12F)) {
               GameObject object = ObjectRegistry.getObject("glowcoral");
               if (object.canPlace(l, tileX, tileY, 0, false) == null)
                  object.placeObject(l, tileX, tileY, 0, false);
            }
         });
         ca.forEachTile(this, (l, tileX, tileY) -> {
            if (cg.random.getChance(0.03F)) {
               GameObject object = ObjectRegistry.getObject("bambootree");
               if (object.canPlace(l, tileX, tileY, 0, false) == null)
                  object.placeObject(l, tileX, tileY, 0, false);
            }
         });
         ca.forEachTile(this, (l, tileX, tileY) -> {
            if (cg.random.getChance(0.3F)) {
               GameObject object = ObjectRegistry.getObject("watergrass");
               if (object.canPlace(l, tileX, tileY, 0, false) == null)
                  object.placeObject(l, tileX, tileY, 0, false);
            }
         });

         ca.forEachTile(this, (l, tileX, tileY) -> {
            if (cg.random.getChance(0.001F)) {
               GameObject object = ObjectRegistry.getObject("fishianbanner");
               if (object.canPlace(l, tileX, tileY, 0, false) == null)
                  object.placeObject(l, tileX, tileY, 0, false);
            }
         });

      });
      GameEvents.triggerEvent((GameEvent) new GeneratedCaveMiniBiomesEvent(this, cg));
      GameEvents.triggerEvent((PreventableGameEvent) new GenerateCaveOresEvent(this, cg), e -> {
         cg.generateOreVeins(0.05F, 3, 6, ObjectRegistry.getObjectID("copperoredeepswamprock"));
         cg.generateOreVeins(0.1F, 3, 6, ObjectRegistry.getObjectID("ironoredeepswamprock"));
         cg.generateOreVeins(0.15F, 3, 6, ObjectRegistry.getObjectID("goldoredeepswamprock"));
         cg.generateOreVeins(0.05F, 3, 6, ObjectRegistry.getObjectID("tungstenoredeepswamprock"));
         cg.generateOreVeins(0.05F, 3, 6, ObjectRegistry.getObjectID("lifequartzdeepswamprock"));
         cg.generateOreVeins(0.17F, 3, 6, ObjectRegistry.getObjectID("myceliumoredeepswamprock"));
      });
      GameEvents.triggerEvent((GameEvent) new GeneratedCaveOresEvent(this, cg));

      PresetGeneration presets = new PresetGeneration(this);
      GameEvents.triggerEvent((PreventableGameEvent) new GenerateCaveStructuresEvent(this, cg, presets), e -> {
         for (int x = 0; x < 6; x++)
         {
            presets.findRandomValidPositionAndApply(GameRandom.globalRandom, 20, new FishianShrinePreset(), 3, false, false);
         }
      });

      GameEvents.triggerEvent((GameEvent) new GeneratedCaveStructuresEvent(this, cg, presets));
      cg.generateRandomCrates(0.03F, new int[] { ObjectRegistry.getObjectID("swampcrate") });

      for (int x = tileWidth / 2 - 1; x < tileWidth / 2 + 2; x++)
      {
         for (int y = tileHeight / 2 - 1; y < tileHeight / 2 + 2; y++)
         {
            this.setObject(x, y, 0);
            this.setTile(x, y, TileRegistry.getTileID("fishian_tile"));
         }
      }
      this.setObject(tileWidth / 2, tileHeight / 2, ObjectRegistry.getObjectID("dungeonexit"));
      // this.entityManager.getObjectEntity(tileWidth / 2, tileHeight / 2);

      GenerationTools.checkValid(this);
   }
}