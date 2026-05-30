package NecesseExpanded.Mobs.Hostile.Raiders.PirateRaiders;

import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.lootItem.LootItem;

// Throws explosives.
public class PirateGrenadierRaider extends PirateRaiderTemplate
{
    public PirateGrenadierRaider()
    {
        super();
        setSpeed(30F);
        this.setMaxHealth(350);
        this.setWeapon(new InventoryItem("raider_bomb"));
        this.helmet = new InventoryItem("engineergoggles");
        this.chest = new InventoryItem("smithingapron");

        PirateGrenadierRaider.lootTable.items.add((LootItemInterface)LootItem.between("ironbomb", 2, 4));

        if (NecesseExpanded.Main.SettingsGetter.getBoolean("raider_bombs_destructive"))
        {
          this.weapon = new InventoryItem("ironbomb");
        }
    }
}
