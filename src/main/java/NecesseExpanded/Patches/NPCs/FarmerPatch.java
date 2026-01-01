package NecesseExpanded.Patches.NPCs;

import NecesseExpanded.Utils.ClearRegistry;
import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.registries.GameRegistry;
import necesse.entity.mobs.friendly.human.humanShop.BuyingShopItem;
import necesse.entity.mobs.friendly.human.humanShop.FarmerHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = FarmerHumanMob.class, arguments = {})
public class FarmerPatch 
{
  @OnMethodExit
  static void onExit(@This FarmerHumanMob Mob) 
  {
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.buyingShop);
      
      Mob.shop.addSellingItem("lunchbox", new SellingShopItem()).setStaticPriceBasedOnHappiness(250, 300, 50);
      Mob.shop.addSellingItem("seedpouch", new SellingShopItem()).setStaticPriceBasedOnHappiness(250, 300, 50);
      Mob.shop.addSellingItem("farmland", new SellingShopItem()).setStaticPriceBasedOnHappiness(20, 30, 5);
      Mob.shop.addSellingItem("fertilizer", new SellingShopItem()).setStaticPriceBasedOnHappiness(20, 30, 5);
      Mob.shop.addSellingItem("rope", new SellingShopItem()).setStaticPriceBasedOnHappiness(10, 15, 0);
      Mob.shop.addSellingItem("farmingscythe", new SellingShopItem()).setStaticPriceBasedOnHappiness(250, 300, 50);
      Mob.shop.addSellingItem("wheatseed", new SellingShopItem()).setStaticPriceBasedOnHappiness(20, 50, 10);
      Mob.shop.addSellingItem("cornseed", new SellingShopItem()).setStaticPriceBasedOnHappiness(20, 50, 10);
      Mob.shop.addSellingItem("tomatoseed", new SellingShopItem()).setStaticPriceBasedOnHappiness(20, 50, 10);
      Mob.shop.addSellingItem("cabbageseed", new SellingShopItem()).setStaticPriceBasedOnHappiness(20, 50, 10);
      Mob.shop.addSellingItem("beetseed", new SellingShopItem()).setStaticPriceBasedOnHappiness(20, 50, 10);
      Mob.shop.addSellingItem("chilipepperseed", new SellingShopItem()).setStaticPriceBasedOnHappiness(30, 60, 10);
      Mob.shop.addSellingItem("sugarbeetseed", new SellingShopItem()).setStaticPriceBasedOnHappiness(30, 60, 10);
      Mob.shop.addSellingItem("eggplantseed", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 100, 15);
      Mob.shop.addSellingItem("potatoseed", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 100, 15);
      Mob.shop.addSellingItem("riceseed", new SellingShopItem()).setStaticPriceBasedOnHappiness(60, 120, 20);
      Mob.shop.addSellingItem("carrotseed", new SellingShopItem()).setStaticPriceBasedOnHappiness(60, 120, 20);
      Mob.shop.addSellingItem("blueberrysapling", new SellingShopItem()).setStaticPriceBasedOnHappiness(250, 500, 50);
      Mob.shop.addSellingItem("raspberrysapling", new SellingShopItem()).setStaticPriceBasedOnHappiness(250, 500, 50);
      Mob.shop.addSellingItem("blackberrysapling", new SellingShopItem()).setStaticPriceBasedOnHappiness(250, 500, 50);
      Mob.shop.addSellingItem("applesapling", new SellingShopItem()).setStaticPriceBasedOnHappiness(500, 1000, 100);
      Mob.shop.addSellingItem("coconutsapling", new SellingShopItem()).setStaticPriceBasedOnHappiness(500, 1000, 100);
      Mob.shop.addSellingItem("onionseed", new SellingShopItem()).setStaticPriceBasedOnHappiness(80, 160, 20).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("pumpkinseed", new SellingShopItem()).setStaticPriceBasedOnHappiness(80, 160, 20).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("strawberryseed", new SellingShopItem()).setStaticPriceBasedOnHappiness(100, 200, 25).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("coffeebeans", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 100, 15).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("lemonsapling", new SellingShopItem()).setStaticPriceBasedOnHappiness(1000, 1800, 150).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("bananasapling", new SellingShopItem()).setStaticPriceBasedOnHappiness(1000, 1800, 150).addKilledMobRequirement("piratecaptain");
      
      Mob.shop.addBuyingItem("wheat", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("corn", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("tomato", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("cabbage", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("chilipepper", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("potato", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("carrot", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("beet", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("seaweed", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("sugarbeet", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("riceseed", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("blueberry", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("blackberry", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("raspberry", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("coconut", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("apple", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("egg", new BuyingShopItem()).setPriceBasedOnHappiness(6, 5, 1);
      Mob.shop.addBuyingItem("onion", new BuyingShopItem()).setPriceBasedOnHappiness(12, 10, 1);
      Mob.shop.addBuyingItem("eggplant", new BuyingShopItem()).setPriceBasedOnHappiness(12, 10, 1);
      Mob.shop.addBuyingItem("coffeebeans", new BuyingShopItem()).setPriceBasedOnHappiness(12, 10, 1);
      Mob.shop.addBuyingItem("pumpkin", new BuyingShopItem()).setPriceBasedOnHappiness(12, 10, 1);
      Mob.shop.addBuyingItem("strawberry", new BuyingShopItem()).setPriceBasedOnHappiness(12, 10, 1);
      Mob.shop.addBuyingItem("lemon", new BuyingShopItem()).setPriceBasedOnHappiness(12, 10, 1);
  }
}