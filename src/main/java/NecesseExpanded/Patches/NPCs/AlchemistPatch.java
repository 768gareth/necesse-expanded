package NecesseExpanded.Patches.NPCs;

import NecesseExpanded.Utils.ClearRegistry;
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
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);
    
      Mob.shop.addSellingItem("potionpouch", new SellingShopItem()).setStaticPriceBasedOnHappiness(750, 1000, 50);
      Mob.shop.addSellingItem("potionbag", new SellingShopItem()).setStaticPriceBasedOnHappiness(1500, 2000, 50);
      Mob.shop.addSellingItem("recallflask", new SellingShopItem()).setStaticPriceBasedOnHappiness(750, 1000, 50);
      Mob.shop.addSellingItem("portalflask", new SellingShopItem()).setStaticPriceBasedOnHappiness(2000, 2500, 50);
      Mob.shop.addSellingItem("revivalpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(25, 50, 5);
      Mob.shop.addSellingItem("healthpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(15, 20, 5);
      Mob.shop.addSellingItem("greaterhealthpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(40, 50, 5).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("superiorhealthpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(150, 200, 5).addKilledMobRequirement("fallenwizard");
      Mob.shop.addSellingItem("manapotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(10, 25, 5);
      Mob.shop.addSellingItem("greatermanapotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(40, 50, 5).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("superiormanapotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(150, 200, 5).addKilledMobRequirement("fallenwizard");
      Mob.shop.addSellingItem("knockbackpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(25, 50, 5).addKilledMobRequirement("queenspider");
      Mob.shop.addSellingItem("resistancepotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(25, 50, 5).addKilledMobRequirement("queenspider");
      Mob.shop.addSellingItem("greaterresistancepotion", new SellingShopItem(50, 5)).setStaticPriceBasedOnHappiness(150, 200, 5).addKilledMobRequirement("fallenwizard");
      Mob.shop.addSellingItem("strengthpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(25, 50, 5).addKilledMobRequirement("queenspider");
      Mob.shop.addSellingItem("accuracypotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(25, 50, 5);
      Mob.shop.addSellingItem("greateraccuracypotion", new SellingShopItem(50, 5)).setStaticPriceBasedOnHappiness(150, 200, 5).addKilledMobRequirement("fallenwizard");
      Mob.shop.addSellingItem("rangerpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(25, 50, 5).addKilledMobRequirement("queenspider");
      Mob.shop.addSellingItem("rapidpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(25, 50, 5).addKilledMobRequirement("queenspider");
      Mob.shop.addSellingItem("greaterrapidpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(150, 200, 5).addKilledMobRequirement("fallenwizard");
      Mob.shop.addSellingItem("speedpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(25, 50, 5);
      Mob.shop.addSellingItem("greaterspeedpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(150, 200, 5).addKilledMobRequirement("fallenwizard");
      Mob.shop.addSellingItem("manaregenpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(10, 25, 5).addKilledMobRequirement("voidwizard");
      Mob.shop.addSellingItem("greatermanaregenpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(150, 200, 5).addKilledMobRequirement("fallenwizard");
      Mob.shop.addSellingItem("wisdompotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(25, 50, 5).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("minionpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(25, 50, 5).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("fishingpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(15, 30, 5);
      Mob.shop.addSellingItem("greaterfishingpotion", new SellingShopItem(50, 5)).setStaticPriceBasedOnHappiness(150, 200, 5).addKilledMobRequirement("fallenwizard");
      Mob.shop.addSellingItem("treasurepotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(15, 30, 5).addKilledMobRequirement("voidwizard");
      Mob.shop.addSellingItem("spelunkerpotion", new SellingShopItem(20, 5)).setStaticPriceBasedOnHappiness(15, 30, 5).addKilledMobRequirement("voidwizard");
      Mob.shop.addSellingItem("miningpotion", new SellingShopItem(20, 2)).setStaticPriceBasedOnHappiness(15, 30, 5).addKilledMobRequirement("voidwizard");
      Mob.shop.addSellingItem("greaterminingpotion", new SellingShopItem(20, 2)).setStaticPriceBasedOnHappiness(150, 200, 5).addKilledMobRequirement("fallenwizard");
      
      Mob.shop.addBuyingItem("mushroom", new BuyingShopItem()).setPriceBasedOnHappiness(15, 12, 2);
      Mob.shop.addBuyingItem("cactus", new BuyingShopItem()).setPriceBasedOnHappiness(6, 4, 1);
      Mob.shop.addBuyingItem("ectoplasm", new BuyingShopItem()).setPriceBasedOnHappiness(25, 16, 4);
      Mob.shop.addBuyingItem("lifequartz", new BuyingShopItem()).setPriceBasedOnHappiness(40, 30, 5);
      Mob.shop.addBuyingItem("gobfish", new BuyingShopItem()).setPriceBasedOnHappiness(25, 16, 4);
      Mob.shop.addBuyingItem("halffish", new BuyingShopItem()).setPriceBasedOnHappiness(25, 16, 4);
      Mob.shop.addBuyingItem("furfish", new BuyingShopItem()).setPriceBasedOnHappiness(25, 16, 4);
      Mob.shop.addBuyingItem("icefish", new BuyingShopItem()).setPriceBasedOnHappiness(25, 16, 4);
      Mob.shop.addBuyingItem("swampfish", new BuyingShopItem()).setPriceBasedOnHappiness(25, 16, 4);
      Mob.shop.addBuyingItem("rockfish", new BuyingShopItem()).setPriceBasedOnHappiness(25, 16, 4);
      Mob.shop.addBuyingItem("terrorfish", new BuyingShopItem()).setPriceBasedOnHappiness(25, 16, 4);
      Mob.shop.addBuyingItem("alchemyshard", new BuyingShopItem()).setPriceBasedOnHappiness(15, 8, 1);
      Mob.shop.addBuyingItem("shadowessence", new BuyingShopItem()).setPriceBasedOnHappiness(50, 25, 5);
      Mob.shop.addBuyingItem("cryoessence", new BuyingShopItem()).setPriceBasedOnHappiness(50, 25, 5);
      Mob.shop.addBuyingItem("bioessence", new BuyingShopItem()).setPriceBasedOnHappiness(50, 25, 5);
      Mob.shop.addBuyingItem("primordialessence", new BuyingShopItem()).setPriceBasedOnHappiness(50, 25, 5);
      Mob.shop.addBuyingItem("slimeessence", new BuyingShopItem()).setPriceBasedOnHappiness(75, 50, 5);
      Mob.shop.addBuyingItem("bloodessence", new BuyingShopItem()).setPriceBasedOnHappiness(75, 50, 5);
      Mob.shop.addBuyingItem("spideressence", new BuyingShopItem()).setPriceBasedOnHappiness(75, 50, 5);
      Mob.shop.addBuyingItem("solar_essence", new BuyingShopItem()).setPriceBasedOnHappiness(80, 70, 5);
      Mob.shop.addBuyingItem("lunar_essence", new BuyingShopItem()).setPriceBasedOnHappiness(80, 70, 5);
  }
}
