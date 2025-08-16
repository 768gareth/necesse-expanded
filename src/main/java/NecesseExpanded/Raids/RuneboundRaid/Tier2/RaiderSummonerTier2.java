package NecesseExpanded.Raids.RuneboundRaid.Tier2;

import necesse.engine.eventStatusBars.EventStatusBarManager;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.level.maps.Level;

public class RaiderSummonerTier2 extends HumanRaiderMob
{
    int SummonTimer = 0;
    int NumberOfSummons = 0;
    int ProjectileTimer = 0;

    public RaiderSummonerTier2()
    {
        super();
        this.setMaxHealth(1750);
        this.setArmor(20);

        RaiderSummonerTier2.lootTable = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)LootItem.between("coin", getMaxHealth() / 10, getMaxHealth() / 5),
                (LootItemInterface)LootItem.between("tungstenbar", 2, 4),
            }
        );

        this.weapon = new InventoryItem("quartzglaive");

        this.setArmorItems
        (
            new InventoryItem("runiccrown"), 
            new InventoryItem("runicchestplate"), 
            new InventoryItem("runicboots")
        );
    }

    public void serverTick()
    {
        super.serverTick();
        EventStatusBarManager.registerMobHealthStatusBar((Mob)this);
        if (this.SummonTimer > 200 && this.isInCombat() == true && NumberOfSummons < 8)
        {
            HumanRaiderMob SummonedRaider = GameRandom.globalRandom.getOneOf
            (
                new RaiderMagicTier2(),
                new RaiderMeleeTier2(),
                new RaiderRangedTier2()
            );
            SummonedRaider.setHealth(SummonedRaider.getMaxHealth());
            Level LocalLevel = this.getLevel();
            LocalLevel.entityManager.addMob
            (
                SummonedRaider,
                this.x,
                this.y
            );
            this.NumberOfSummons++;
            this.SummonTimer = 0;
        }
        this.SummonTimer++;
    }
}
