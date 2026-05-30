package NecesseExpanded.Objects;

import necesse.entity.objectEntity.ObjectEntity;
import necesse.inventory.item.toolItem.ToolType;
import necesse.level.gameObject.WallObject;
import necesse.level.gameObject.WallTrapObject;
import necesse.level.maps.Level;

public class VenomTrapObject extends WallTrapObject {
    public VenomTrapObject(WallObject wallObject) {
       super(wallObject, "arrowtrap");
    }
 
    public VenomTrapObject(WallObject wallObject, float toolTier, ToolType toolType) {
       super(wallObject, "arrowtrap", toolTier, toolType);
    }
 
    public ObjectEntity getNewObjectEntity(Level level, int x, int y) {
       return new VenomTrapObjectEntity(level, x, y);
    }
 }
