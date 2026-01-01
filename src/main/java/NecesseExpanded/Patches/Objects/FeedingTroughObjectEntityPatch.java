package NecesseExpanded.Patches.Objects;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.objectEntity.FeedingTroughObjectEntity;
import necesse.inventory.item.Item;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.Advice.OnMethodExit;

@ModMethodPatch(target = FeedingTroughObjectEntity.class, name = "isValidFeed", arguments = {Item.class})
public class FeedingTroughObjectEntityPatch 
{
    @OnMethodExit
    static void onExit(@Advice.Return(readOnly = false) boolean isValidFeedItem, @Advice.Argument(0) Item InventoryItem)
    {
        String ItemID = InventoryItem.getStringID();
        if 
        (
            ItemID == "wheat" || ItemID == "blueberry" || ItemID == "raspberry"
            || ItemID == "blackberry" || ItemID == "strawberry"
        )
        {
            isValidFeedItem = true;
        }
    }
}
