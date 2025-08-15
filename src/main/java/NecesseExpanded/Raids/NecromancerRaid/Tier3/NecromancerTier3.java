package NecesseExpanded.Raids.NecromancerRaid.Tier3;

import necesse.engine.util.GameRandom;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;
import necesse.level.maps.Level;

public class NecromancerTier3 extends HumanRaiderMob
{
    int SummonTimer;
    int NumberOfSummons;

    public NecromancerTier3()
    {
        super();
        this.setMaxHealth(3000);
        this.setArmor(30);

        this.SummonTimer = 0;
        this.NumberOfSummons = 0;

        NecromancerTier3.lootTable = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)LootItem.between("coin", getMaxHealth() / 10, getMaxHealth() / 5),

                (LootItemInterface) new OneOfLootItems
                (
                    (LootItemInterface) LootItem.between("shadowessence", 4, 8),
                    (LootItemInterface) LootItem.between("cryoessence", 4, 8),
                    (LootItemInterface) LootItem.between("bioessence", 4, 8),
                    (LootItemInterface) LootItem.between("primordialessence", 4, 8)
                )
            }
        );

        this.weapon = new InventoryItem("shadowbeam");

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
                AncientSkeletonRaider SummonedRaider = new AncientSkeletonRaider();
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
