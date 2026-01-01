package NecesseExpanded.Mobs.Hostile.Raiders.RuneboundRaiders;

import necesse.engine.util.GameRandom;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;

public class RuneboundTrapper extends RuneboundRaiderTemplate
{
    public RuneboundTrapper()
    {
        super();
        this.setMaxHealth(325);
        this.setSpeed(30F);
        this.setWeapon(new InventoryItem("captorsshortbow"));
        this.helmet = new InventoryItem("leatherhood");
        this.chest = new InventoryItem("runeboundleatherchest");
        RuneboundTrapper.lootTable.items.add(new ChanceLootItem(0.25F, "poisonarrow", GameRandom.globalRandom.getIntBetween(12, 24)));
    }
}
