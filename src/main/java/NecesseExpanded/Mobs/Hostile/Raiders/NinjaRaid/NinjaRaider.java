package NecesseExpanded.Mobs.Hostile.Raiders.NinjaRaid;

import java.awt.Rectangle;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.PathDoorOption;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.gfx.HumanLook;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.LootItem;

public class NinjaRaider extends HumanRaiderMob
{
    HumanLook Look = new HumanLook();
    
    public NinjaRaider() 
    {
        super();
        this.setArmor(20);
        this.setMaxHealth(400);
        this.setSpeed(50F);
        this.collision = new Rectangle(-10, -7, 20, 14);
        this.hitBox = new Rectangle(-14, -12, 28, 24);
        this.selectBox = new Rectangle(-14, -41, 28, 48);
        this.swimMaskMove = 16;
        this.swimMaskOffset = -2;
        this.swimSinkOffset = -4;
        NinjaRaider.lootTable = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)LootItem.between("coin", getMaxHealth() / 30, getMaxHealth() / 20),
                (LootItemInterface) new ChanceLootItem(0.5F, "ninjastar", GameRandom.globalRandom.getIntBetween(8, 12)),
                (LootItemInterface) new ChanceLootItem(0.1F, "glacialshard"),
                (LootItemInterface) new ChanceLootItem(0.05F, "reinforcedkatana"),
                (LootItemInterface) new ChanceLootItem(0.05F, "ninjahood"),
                (LootItemInterface) new ChanceLootItem(0.05F, "ninjarobe"),
                (LootItemInterface) new ChanceLootItem(0.05F, "ninjashoes"),
                (LootItemInterface) new ChanceLootItem(0.05F, "ninjasmark"),
            }
        );
        this.weapon = new InventoryItem("ninjastar");
        this.helmet = new InventoryItem("ninjahood");
        this.chest = new InventoryItem("ninjarobe");
        this.boots = new InventoryItem("ninjashoes");
    }

   public PathDoorOption getPathDoorOption() 
   {
      return this.getLevel() != null ? this.getLevel().regionManager.CAN_OPEN_DOORS_OPTIONS : null;
   }

    public void updateArmor() {}
}
