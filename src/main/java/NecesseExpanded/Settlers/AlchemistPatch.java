package NecesseExpanded.Settlers;

import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.registries.GameRegistry;
import necesse.entity.mobs.friendly.human.humanShop.AlchemistHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.BuyingShopItem;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = AlchemistHumanMob.class, arguments = {})
public class AlchemistPatch 
{
  @OnMethodExit
  static void onExit(@This AlchemistHumanMob Mob) 
  {
      if (NecesseExpanded.Main.Options.isShopChangesEnabled)
      {
        ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);
        
        // Potion bags
        Mob.shop.addSellingItem("potionpouch", new SellingShopItem())
        .setStaticPriceBasedOnHappiness(750, 1000, 50);

        Mob.shop.addSellingItem("potionbag", new SellingShopItem())
        .setStaticPriceBasedOnHappiness(1500, 2000, 50);

        // Flasks
        Mob.shop.addSellingItem("recallflask", new SellingShopItem())
        .setStaticPriceBasedOnHappiness(750, 1000, 50);
        
        Mob.shop.addSellingItem("portalflask", new SellingShopItem())
        .setStaticPriceBasedOnHappiness(2000, 2500, 50);

        // Potions
        Mob.shop.addSellingItem("revivalpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(25, 50, 5);

        Mob.shop.addSellingItem("healthpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(15, 20, 5);

        Mob.shop.addSellingItem("greaterhealthpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(40, 50, 5)
        .addKilledMobRequirement("piratecaptain");

        Mob.shop.addSellingItem("superiorhealthpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(80, 100, 5)
        .addKilledMobRequirement("fallenwizard");

        Mob.shop.addSellingItem("manapotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(10, 25, 5);

        Mob.shop.addSellingItem("greatermanapotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(40, 50, 5)
        .addKilledMobRequirement("piratecaptain");

        Mob.shop.addSellingItem("superiormanapotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(80, 100, 5)
        .addKilledMobRequirement("fallenwizard");

        // Melee potions
        Mob.shop.addSellingItem("knockbackpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(25, 50, 5);

        Mob.shop.addSellingItem("resistancepotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(25, 50, 5);

        Mob.shop.addSellingItem("greaterresistancepotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(50, 100, 5)
        .addKilledMobRequirement("fallenwizard");

        Mob.shop.addSellingItem("strengthpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(25, 50, 5);

        // Ranged potions.
        Mob.shop.addSellingItem("accuracypotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(25, 50, 5);

        Mob.shop.addSellingItem("greateraccuracypotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(50, 100, 5)
        .addKilledMobRequirement("fallenwizard");

        Mob.shop.addSellingItem("rangerpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(25, 50, 5);

        Mob.shop.addSellingItem("rapidpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(25, 50, 5);

        Mob.shop.addSellingItem("greaterrapidpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(50, 100, 5)
        .addKilledMobRequirement("fallenwizard");

        Mob.shop.addSellingItem("speedpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(25, 50, 5);

        Mob.shop.addSellingItem("greaterspeedpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(50, 100, 5)
        .addKilledMobRequirement("fallenwizard");

        // Magic potions.
        Mob.shop.addSellingItem("manaregenpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(10, 25, 5);

        Mob.shop.addSellingItem("greatermanaregenpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(50, 100, 5)
        .addKilledMobRequirement("fallenwizard");

        Mob.shop.addSellingItem("wisdompotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(25, 50, 5)
        .addKilledMobRequirement("piratecaptain");
        
        Mob.shop.addSellingItem("minionpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(25, 50, 5)
        .addKilledMobRequirement("piratecaptain");

        // Fishing potions.
        Mob.shop.addSellingItem("fishingpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(15, 30, 5);

        Mob.shop.addSellingItem("greaterfishingpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(50, 100, 10)
        .addKilledMobRequirement("fallenwizard");

        // Other potions.
        Mob.shop.addSellingItem("treasurepotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(15, 30, 5);

        Mob.shop.addSellingItem("spelunkerpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(15, 30, 5);

        Mob.shop.addSellingItem("miningpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(15, 30, 5);

        Mob.shop.addSellingItem("greaterminingpotion", new SellingShopItem(50, 5))
        .setStaticPriceBasedOnHappiness(50, 100, 10)
        .addKilledMobRequirement("fallenwizard");

        // Buying options.
        Mob.shop.addBuyingItem("mushroom", new BuyingShopItem())
        .setPriceBasedOnHappiness(15, 12, 2);

        Mob.shop.addBuyingItem("cactus", new BuyingShopItem())
        .setPriceBasedOnHappiness(6, 4, 1);

        Mob.shop.addBuyingItem("ectoplasm", new BuyingShopItem())
        .setPriceBasedOnHappiness(25, 16, 4);

        Mob.shop.addBuyingItem("lifequartz", new BuyingShopItem())
        .setPriceBasedOnHappiness(40, 30, 5);

        Mob.shop.addBuyingItem("gobfish", new BuyingShopItem())
        .setPriceBasedOnHappiness(25, 16, 4);

        Mob.shop.addBuyingItem("halffish", new BuyingShopItem())
        .setPriceBasedOnHappiness(25, 16, 4);

        Mob.shop.addBuyingItem("furfish", new BuyingShopItem())
        .setPriceBasedOnHappiness(25, 16, 4);

        Mob.shop.addBuyingItem("icefish", new BuyingShopItem())
        .setPriceBasedOnHappiness(25, 16, 4);

        Mob.shop.addBuyingItem("swampfish", new BuyingShopItem())
        .setPriceBasedOnHappiness(25, 16, 4);

        Mob.shop.addBuyingItem("rockfish", new BuyingShopItem())
        .setPriceBasedOnHappiness(25, 16, 4);

        Mob.shop.addBuyingItem("terrorfish", new BuyingShopItem())
        .setPriceBasedOnHappiness(25, 16, 4);

        Mob.shop.addBuyingItem("shadowessence", new BuyingShopItem())
        .setPriceBasedOnHappiness(45, 25, 5);

        Mob.shop.addBuyingItem("cryoessence", new BuyingShopItem())
        .setPriceBasedOnHappiness(45, 25, 5);

        Mob.shop.addBuyingItem("bioessence", new BuyingShopItem())
        .setPriceBasedOnHappiness(45, 25, 5);

        Mob.shop.addBuyingItem("primordialessence", new BuyingShopItem())
        .setPriceBasedOnHappiness(45, 25, 5);
      }
  }
}