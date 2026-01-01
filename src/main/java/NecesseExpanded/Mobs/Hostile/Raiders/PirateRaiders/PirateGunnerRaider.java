package NecesseExpanded.Mobs.Hostile.Raiders.PirateRaiders;

import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.lootItem.LootItem;

// A ranged unit.
public class PirateGunnerRaider extends PirateRaiderTemplate
{
    public PirateGunnerRaider()
    {
        super();
        setSpeed(30F);
        this.setMaxHealth(300);
        this.setWeapon(new InventoryItem("flintlock"));
        this.helmet = new InventoryItem("piratebandana");

        PirateGunnerRaider.lootTable.items.add((LootItemInterface)LootItem.between("simplebullet", 24, 48));
    }
}
