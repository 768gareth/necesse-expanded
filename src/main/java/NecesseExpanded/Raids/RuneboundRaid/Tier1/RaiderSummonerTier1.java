package NecesseExpanded.Raids.RuneboundRaid.Tier1;

import necesse.engine.eventStatusBars.EventStatusBarManager;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.level.maps.Level;

public class RaiderSummonerTier1 extends HumanRaiderMob
{
    int SummonTimer;
    int NumberOfSummons;

    public RaiderSummonerTier1()
    {
        super();
        this.setMaxHealth(1250);
        this.setArmor(10);

        this.SummonTimer = 0;
        this.NumberOfSummons = 0;

        RaiderSummonerTier1.lootTable = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)LootItem.between("coin", getMaxHealth() / 10, getMaxHealth() / 5),
            }
        );

        this.weapon = new InventoryItem("goldglaive");

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
                new RaiderMagicTier1(),
                new RaiderMeleeTier1(),
                new RaiderRangedTier1()
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
