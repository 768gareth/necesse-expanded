package NecesseExpanded.Settlements.Objects;

import necesse.engine.registries.RecipeTechRegistry;
import necesse.entity.objectEntity.ProcessingTechInventoryObjectEntity;
import necesse.inventory.recipe.Tech;
import necesse.level.maps.Level;

public class KegObjectEntity extends ProcessingTechInventoryObjectEntity
{
    public KegObjectEntity(Level level, int x, int y)
    {
        super(level, "keg", x, y, 1, 1, new Tech [] { RecipeTechRegistry.getTech("keg") });
    }

    @Override
    public int getProcessTime() 
    {
        return 120000; // 120 seconds.
    }
    
}
