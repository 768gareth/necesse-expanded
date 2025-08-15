package NecesseExpanded.Raids.NecromancerRaid.Tier1;

import necesse.engine.util.GameRandom;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.level.maps.Level;

public class NecromancerTier1 extends HumanRaiderMob
{
    int SummonTimer;
    int NumberOfSummons;

    public NecromancerTier1()
    {
        super();
        this.setMaxHealth(750);
        this.setArmor(10);

        this.SummonTimer = 0;
        this.NumberOfSummons = 0;

        NecromancerTier1.lootTable = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)LootItem.between("coin", getMaxHealth() / 10, getMaxHealth() / 5),
            }
        );

        this.weapon = new InventoryItem("bloodbolt");

        this.setArmorItems
        (
            new InventoryItem("shadowhat"), 
            new InventoryItem("shadowmantle"), 
            new InventoryItem("shadowboots")
        );
    }

    public void serverTick()
    {
        super.serverTick();
        if (this.SummonTimer > 400 && NumberOfSummons < 8)
        {
            Level LocalLevel = this.getLevel();
            for (int Summons = 0; Summons < GameRandom.globalRandom.getIntBetween(2, 4); Summons++)
            {
                ZombieRaider SummonedRaider = new ZombieRaider();
                SummonedRaider.setHealth(SummonedRaider.getMaxHealth());
            
                LocalLevel.entityManager.addMob
                (
                    SummonedRaider,
                    this.x,
                    this.y
                );

                SummonedRaider.setFollowing(this, false);

                this.NumberOfSummons++;
            }
            this.SummonTimer = 0;
        }
        this.SummonTimer++;
    }
}
