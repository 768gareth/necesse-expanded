package NecesseExpanded.World.Presets;

import java.awt.Point;

import necesse.engine.registries.ObjectRegistry;
import necesse.engine.registries.TileRegistry;
import necesse.engine.util.GameRandom;
import necesse.level.maps.presets.Preset;

public class FishianDeepCaveEntrancePreset extends Preset 
{    
    public FishianDeepCaveEntrancePreset(GameRandom random) 
    {
      super(12, 12);
      int mid = 12 / 2;
      int maxDistance = 12 / 2 * 32;
      int dungeonFloor = TileRegistry.getTileID("fishian_tile");
      int dungeonWall = ObjectRegistry.getObjectID("fishian_wall");
      for (int x = 0; x < this.width; x++) {
        for (int y = 0; y < this.height; y++) {
          float distance = (float)(new Point(mid * 32 + 16, mid * 32 + 16)).distance((x * 32 + 16), (y * 32 + 16));
          float distancePerc = distance / maxDistance;
          if (distancePerc < 0.4F) {
            setTile(x, y, dungeonFloor);
            setObject(x, y, 0);
          } else if (distancePerc <= 1.0F) {
            float chance = Math.abs((distancePerc - 0.5F) * 2.0F - 1.0F) * 2.0F;
            if (random.getChance(chance)) {
              setTile(x, y, dungeonFloor);
              setObject(x, y, 0);
            } 
          } 
          if (distance < maxDistance && distance >= (maxDistance - 40) && 
            random.getChance(0.4F))
            setObject(x, y, dungeonWall); 
        } 
      } 
      int chaliceOffset = 3;
      setObject(mid - chaliceOffset - 1, mid - chaliceOffset - 1, ObjectRegistry.getObjectID("fishian_brazier"));
      setObject(mid - chaliceOffset - 1, mid + chaliceOffset, ObjectRegistry.getObjectID("fishian_brazier"));
      setObject(mid + chaliceOffset, mid - chaliceOffset - 1, ObjectRegistry.getObjectID("fishian_brazier"));
      setObject(mid + chaliceOffset, mid + chaliceOffset, ObjectRegistry.getObjectID("fishian_brazier"));
      setObject(mid, mid, ObjectRegistry.getObjectID("fishian_entrance"));
      int mobOffset = 5;
      addMob("fishianhookwarrior", mid - mobOffset, mid - mobOffset, false);
      addMob("fishianhookwarrior", mid + mobOffset, mid - mobOffset, false);
      addMob("fishianhookwarrior", mid - mobOffset, mid + mobOffset, false);
      addMob("fishianhealer", mid + mobOffset, mid + mobOffset, false);
    }
}
