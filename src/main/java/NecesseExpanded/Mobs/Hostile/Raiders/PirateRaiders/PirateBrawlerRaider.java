package NecesseExpanded.Mobs.Hostile.Raiders.PirateRaiders;

import necesse.inventory.InventoryItem;

// A powerful melee unit.
public class PirateBrawlerRaider extends PirateRaiderTemplate
{
    public PirateBrawlerRaider()
    {
        super();
        setSpeed(30F);
        this.setMaxHealth(350);
        this.setWeapon(new InventoryItem("cutlass"));
        this.helmet = new InventoryItem("wig");
    }
}
