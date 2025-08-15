package NecesseExpanded.Raids.RuneboundRaid.Tier3;

import necesse.engine.util.GameRandom;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.gfx.GameHair;
import necesse.gfx.HumanGender;
import necesse.gfx.HumanLook;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.ChanceLootItemList;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;

public class RaiderMeleeTier3 extends HumanRaiderMob
{
    public RaiderMeleeTier3()
    {
        super();
        this.setMaxHealth(800);
        this.setArmor(50);

        this.look = new HumanLook();
        updateLook();
        
        RaiderMeleeTier3.lootTable = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)LootItem.between("coin", getMaxHealth() / 30, getMaxHealth() / 20),

                (LootItemInterface)new ChanceLootItemList
                (
                    0.5F, new LootItemInterface[] 
                    { 
                        (LootItemInterface) new OneOfLootItems
                        (
                            (LootItemInterface) LootItem.between("superiorhealthpotion", 1, 2),
                            (LootItemInterface) LootItem.between("greaterresistancepotion", 1, 2),
                            (LootItemInterface) LootItem.between("greaterhealthregenpotion", 1, 2)
                        )
                    }
                ),

                (LootItemInterface)new ChanceLootItemList
                (
                    0.1F, new LootItemInterface[] 
                    { 
                        (LootItemInterface) new OneOfLootItems
                        (
                            (LootItemInterface) LootItem.between("shadowessence", 1, 2),
                            (LootItemInterface) LootItem.between("cryoessence", 1, 2),
                            (LootItemInterface) LootItem.between("bioessence", 1, 2),
                            (LootItemInterface) LootItem.between("primordialessence", 1, 2)
                        )
                    }
                ),

                (LootItemInterface)new ChanceLootItem(0.05F, "challengersbanner"),

                (LootItemInterface)new ChanceLootItemList
                (
                    0.05F, new LootItemInterface[] 
                    { 
                        (LootItemInterface) new OneOfLootItems
                        (
                            (LootItemInterface) new LootItem("clockworkheart", 1),
                            (LootItemInterface) new LootItem("carapaceshield", 1)
                        )
                    }
                )
            }
        );

        this.weapon = new InventoryItem
        (
            GameRandom.globalRandom.getOneOf
            (
                "antiquesword",
                "cryoglaive"
            )
        );

        this.setArmorItems
        (
            new InventoryItem("runeboundhelmet"), 
            new InventoryItem("runeboundleatherchest"), 
            new InventoryItem("runeboundboots")
        );
    }

    public void updateLook() 
    {
        GameRandom random = new GameRandom(this.lookSeed);
        HumanGender gender = (HumanGender)random.getOneOfWeighted(HumanGender.class, new Object[] { Integer.valueOf(30), HumanGender.MALE, 
              Integer.valueOf(60), HumanGender.FEMALE, 
              Integer.valueOf(10), HumanGender.NEUTRAL });
        this.look.setSkin(10);
        this.look.setEyeType(((Integer)random.getOneOf((Object[])new Integer[] { Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(4) })).intValue());
        this.look.setEyeColor(random.getIntBetween(0, 10));
        this.look.setHair(GameHair.getRandomHairBasedOnGender(random, gender));
        if (gender == HumanGender.MALE)
            this.look.setFacialFeature(((Integer)random.getOneOf((Object[])new Integer[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(6), Integer.valueOf(7) })).intValue()); 
        this.look.setHairColor(((Integer)random.getOneOf((Object[])new Integer[] { Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9) })).intValue());
    }
}
