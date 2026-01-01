package NecesseExpanded.Objects;

import necesse.entity.objectEntity.PortalObjectEntity;
import java.util.function.Function;

import NecesseExpanded.World.Levels.FishianDeepCaveLevel;
import necesse.engine.network.server.Server;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.ObjectRegistry;
import necesse.engine.util.LevelIdentifier;
import necesse.level.gameObject.GameObject;
import necesse.level.maps.Level;

public class FishianDeepCaveEntranceObjectEntity extends PortalObjectEntity {
    public static LevelIdentifier getDungeonLevelIdentifier(LevelIdentifier currentIdentifier, int tileX, int tileY) {
        return new LevelIdentifier(currentIdentifier.stringID + "-fishian_dungeon" + tileX + "x" + tileY);
    }

    public FishianDeepCaveEntranceObjectEntity(Level level, int x, int y) {
        super(level, "fishian_dungeon_entrance", x, y, level.getIdentifier(), x, y);
    }

    public void init() {
        super.init();
        this.destinationTileX = Integer.MIN_VALUE;
        this.destinationTileY = Integer.MIN_VALUE;
    }

    public void use(Server server, ServerClient client) 
    {
        client.setFallbackLevel(getLevel(), this.tileX, this.tileY);
        LevelIdentifier currentIdentifier = getLevel().getIdentifier();
        this.destinationIdentifier = new LevelIdentifier(currentIdentifier.stringID + "-fishiandungeon" + this.tileX + "x" + this.tileY);
        Function<LevelIdentifier, Level> levelGenerator = identifier -> 
        {
            (getLevel()).childLevels.add(this.destinationIdentifier);
            return (Level)(new FishianDeepCaveLevel(identifier, server.world.worldEntity));
        };
        teleportClientToAroundDestination(client, levelGenerator, level -> 
        {
            if (this.destinationTileX != Integer.MIN_VALUE && this.destinationTileY != Integer.MIN_VALUE)
            {
                return true;
            }
            int exitID = ObjectRegistry.getObjectID("dungeonexit");
            boolean foundExit = false;
            for (int tileX = 0; tileX < level.tileWidth; tileX++) {
              for (int tileY = 0; tileY < level.tileHeight; tileY++) {
                level.regionManager.ensureTileIsLoaded(tileX, tileY);
                if (level.getObjectID(tileX, tileY) == exitID) {
                  this.destinationTileX = tileX;
                  this.destinationTileY = tileY;
                  foundExit = true;
                  break;
                } 
              } 
              if (foundExit)
                break; 
            } 
            if (!foundExit) {
              this.destinationTileX = level.tileWidth / 2;
              this.destinationTileY = level.tileHeight / 2;
            } 
            GameObject exitObject = ObjectRegistry.getObject(exitID);
            if (level.getObjectID(this.destinationTileX, this.destinationTileY) != exitID)
              exitObject.placeObject(level, this.destinationTileX, this.destinationTileY, 0, false); 
            PortalObjectEntity exitEntity = (PortalObjectEntity)level.entityManager.getObjectEntity(this.destinationTileX, this.destinationTileY, PortalObjectEntity.class);
            if (exitEntity != null) {
              exitEntity.destinationTileX = this.tileX;
              exitEntity.destinationTileY = this.tileY;
              exitEntity.destinationIdentifier = currentIdentifier;
            } 
            runClearMobs(level, this.destinationTileX, this.destinationTileY);
            return true;
          },
          true);
    }
}