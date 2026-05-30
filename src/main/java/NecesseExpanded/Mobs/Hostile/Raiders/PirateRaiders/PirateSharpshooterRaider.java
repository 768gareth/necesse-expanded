package NecesseExpanded.Mobs.Hostile.Raiders.PirateRaiders;

import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.lootItem.LootItem;

// A ranged unit.
public class PirateSharpshooterRaider extends PirateRaiderTemplate
{
    public PirateSharpshooterRaider()
    {
        super();
        setSpeed(30F);
        this.setMaxHealth(300);
        this.setWeapon(new InventoryItem("sniperrifle"));
        this.helmet = new InventoryItem("leatherhood");

        PirateSharpshooterRaider.lootTable.items.add((LootItemInterface)LootItem.between("simplebullet", 24, 48));
    }
}
