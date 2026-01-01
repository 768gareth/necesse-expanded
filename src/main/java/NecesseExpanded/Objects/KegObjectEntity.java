package NecesseExpanded.Objects;

import necesse.engine.localization.Localization;
import necesse.engine.registries.RecipeTechRegistry;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.objectEntity.ProcessingTechInventoryObjectEntity;
import necesse.gfx.gameTooltips.GameTooltipManager;
import necesse.gfx.gameTooltips.GameTooltips;
import necesse.gfx.gameTooltips.StringTooltips;
import necesse.gfx.gameTooltips.TooltipLocation;
import necesse.inventory.recipe.Tech;
import necesse.level.maps.Level;

public class KegObjectEntity extends ProcessingTechInventoryObjectEntity
{
    public KegObjectEntity(Level level, int x, int y)
    {
        super(level, "keg", x, y, 3, 1, new Tech [] { RecipeTechRegistry.getTech("keg") });
    }

    @Override
    public int getProcessTime() 
    {
        return 120000; // 120 seconds.
    }

    public void onMouseHover(PlayerMob perspective, boolean debug) 
    {
        super.onMouseHover(perspective, debug);
        StringTooltips tooltips = new StringTooltips(getObject().getDisplayName());
        if (isProcessing()) 
        {
            tooltips.add(Localization.translate("ui", "keg_active"));
        } 
        else 
        {
            tooltips.add(Localization.translate("ui", "keg_inactive"));
        } 
        GameTooltipManager.addTooltip((GameTooltips)tooltips, TooltipLocation.INTERACT_FOCUS);
    }
    
}
