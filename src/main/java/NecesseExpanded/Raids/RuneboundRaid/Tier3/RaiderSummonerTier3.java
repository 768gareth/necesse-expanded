package NecesseExpanded.Raids.RuneboundRaid.Tier3;

import necesse.engine.eventStatusBars.EventStatusBarManager;
import necesse.engine.registries.BuffRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.level.maps.Level;

public class RaiderSummonerTier3 extends HumanRaiderMob
{
    int SummonTimer = 0;
    int NumberOfSummons = 0;

    public RaiderSummonerTier3()
    {
        super();
        this.setMaxHealth(3500);
        this.setArmor(38);

        this.SummonTimer = 0;
        this.NumberOfSummons = 0;

        RaiderSummonerTier3.lootTable = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)LootItem.between("coin", getMaxHealth() / 10, getMaxHealth() / 5),
            }
        );

        this.weapon = new InventoryItem("cryoglaive");

        this.setArmorItems
        (
            new InventoryItem("runiccrown"), 
            new InventoryItem("tungstenchestplate"), 
            new InventoryItem("tungstenboots")
        );
    }

    public void serverTick()
    {
        super.serverTick();
        EventStatusBarManager.registerMobHealthStatusBar((Mob)this);
        this.addBuff(new ActiveBuff(BuffRegistry.getBuff("ivyhoodsetbonus"), this, 10, null), true);

        if (this.SummonTimer > 200 && this.isInCombat() == true && NumberOfSummons < 8)
        {
            HumanRaiderMob SummonedRaider = GameRandom.globalRandom.getOneOf
            (
                new RaiderMagicTier3(),
                new RaiderMeleeTier3(),
                new RaiderRangedTier3()
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
