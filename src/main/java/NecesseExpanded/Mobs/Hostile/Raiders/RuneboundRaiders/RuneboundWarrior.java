package NecesseExpanded.Mobs.Hostile.Raiders.RuneboundRaiders;

import necesse.engine.util.GameRandom;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;

public class RuneboundWarrior extends RuneboundRaiderTemplate
{
    public RuneboundWarrior()
    {
        super();
        
        this.setMaxHealth(350);
        this.setSpeed(30F);
        this.weapon = new InventoryItem(GameRandom.globalRandom.getOneOf("ironspear", "ironsword"));
        this.helmet = new InventoryItem("runeboundhornhelmet");
        this.chest = new InventoryItem("runeboundleatherchest");
        RuneboundWarrior.lootTable.items.add((LootItemInterface) new ChanceLootItem(0.05f, weapon.toString()));
    }
}
