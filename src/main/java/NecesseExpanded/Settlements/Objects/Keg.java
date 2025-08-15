package NecesseExpanded.Settlements.Objects;

import necesse.engine.registries.RecipeTechRegistry;
import necesse.entity.objectEntity.ProcessingTechInventoryObjectEntity;
import necesse.level.maps.Level;

public class Keg extends ProcessingTechInventoryObjectEntity
{
    public Keg(Level level, int x, int y) 
    {
        super(level, "keg", x, y, 1, 1, RecipeTechRegistry.getTech("keg"));
    }

    @Override
    public int getProcessTime() 
    {
        return 90000;
    }
}
