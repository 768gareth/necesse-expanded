package NecesseExpanded.Mobs.Hostile.Raiders.SpiderkinRaiders;

import java.awt.Rectangle;

import necesse.engine.network.client.Client;
import necesse.engine.network.gameNetworkData.GNDItemMap;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.hostile.ItemAttackerRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.level.maps.mapData.ClientDiscoveredMap;

public class SpiderkinRaiderTemplate extends ItemAttackerRaiderMob
{
    public SpiderkinRaiderTemplate()
    {
        super(false);
        this.collision = new Rectangle(-10, -7, 20, 14);
        this.hitBox = new Rectangle(-14, -12, 28, 24);
        this.selectBox = new Rectangle(-14, -41, 28, 48);
        this.swimMaskMove = 16;
        this.swimMaskOffset = -2;
        this.swimSinkOffset = -4;
        this.setSpeed(40F);
        this.setArmor(30);
        this.weapon = new InventoryItem("ironaxe");

        SpiderkinRaiderTemplate.lootTable = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface) LootItem.between("coin", getMaxHealth() / 30, getMaxHealth() / 20),
                (LootItemInterface) new ChanceLootItem(0.25F, "spidervenom", GameRandom.globalRandom.getIntBetween(1, 2)),
                (LootItemInterface) new ChanceLootItem(0.05F, "spideressence", GameRandom.globalRandom.getIntBetween(1, 2)),
                new ChanceLootItem(0.05f, weapon.toString(), new GNDItemMap().setInt("upgradeLevel", 100))
            }
        );
    }

    public void updateArmor() {}

    public boolean shouldDrawOnMap() {
        return true;
    }

    public boolean isVisibleOnMap(Client client, ClientDiscoveredMap map) {
    return true;
  }

    public Rectangle drawOnMapBox(double tileScale, boolean isMinimap) {
        return new Rectangle(-10, -24, 20, 24);
    }
}
