package NecesseExpanded.Utils.RaiderWeapons;

import necesse.inventory.item.toolItem.swordToolItem.SwordToolItem;

public class RaiderFakeSword extends SwordToolItem
{
    public RaiderFakeSword()
    {
        super(0, null);
        this.attackRange.setBaseValue(25);
        this.attackAnimTime.setBaseValue(100);
    }
}
