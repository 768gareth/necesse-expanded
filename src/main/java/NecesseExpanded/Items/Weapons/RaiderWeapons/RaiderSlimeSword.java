package NecesseExpanded.Utils.RaiderWeapons;

import necesse.inventory.item.toolItem.swordToolItem.SwordToolItem;

public class RaiderSlimeSword extends SwordToolItem
{
    public RaiderSlimeSword()
    {
        super(100, null);
        this.attackRange.setBaseValue(25);
        this.attackAnimTime.setBaseValue(200);
        this.attackDamage.setBaseValue(30.0F).setUpgradedValue(1.0F, 95.0F);
    }
}
