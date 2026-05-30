package NecesseExpanded.Patches.NPCs;

import NecesseExpanded.Utils.ClearRegistry;
import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.registries.GameRegistry;
import necesse.entity.mobs.friendly.human.humanShop.BlacksmithHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.BuyingShopItem;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = BlacksmithHumanMob.class, arguments = {})
public class BlacksmithPatch 
{
  @OnMethodExit
  static void onExit(@This BlacksmithHumanMob Mob) 
  {
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);
      Mob.shop.addSellingItem("ironsword", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 75, 5);
      Mob.shop.addSellingItem("ironpickaxe", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 75, 5);
      Mob.shop.addSellingItem("ironaxe", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 75, 5);
      Mob.shop.addSellingItem("ironshovel", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 75, 5);
      Mob.shop.addSellingItem("demonicsword", new SellingShopItem()).setStaticPriceBasedOnHappiness(150, 200, 10).addKilledMobRequirement("evilsprotector");
      Mob.shop.addSellingItem("demonicpickaxe", new SellingShopItem()).setStaticPriceBasedOnHappiness(150, 200, 10).addKilledMobRequirement("evilsprotector");
      Mob.shop.addSellingItem("demonicaxe", new SellingShopItem()).setStaticPriceBasedOnHappiness(150, 200, 10).addKilledMobRequirement("evilsprotector");
      Mob.shop.addSellingItem("demonicshovel", new SellingShopItem()).setStaticPriceBasedOnHappiness(150, 200, 10).addKilledMobRequirement("evilsprotector");
      Mob.shop.addSellingItem("tungstensword", new SellingShopItem()).setStaticPriceBasedOnHappiness(300, 400, 25).addKilledMobRequirement("reaper");
      Mob.shop.addSellingItem("tungstenpickaxe", new SellingShopItem()).setStaticPriceBasedOnHappiness(300, 400, 25).addKilledMobRequirement("reaper");
      Mob.shop.addSellingItem("tungstenaxe", new SellingShopItem()).setStaticPriceBasedOnHappiness(300, 400, 25).addKilledMobRequirement("reaper");
      Mob.shop.addSellingItem("tungstenshovel", new SellingShopItem()).setStaticPriceBasedOnHappiness(300, 400, 25).addKilledMobRequirement("reaper");
      Mob.shop.addSellingItem("ancientfossilpickaxe", new SellingShopItem()).setStaticPriceBasedOnHappiness(600, 700, 50).addKilledMobRequirement("sageandgrit");
      Mob.shop.addSellingItem("ancientfossilaxe", new SellingShopItem()).setStaticPriceBasedOnHappiness(600, 700, 50).addKilledMobRequirement("sageandgrit");
      Mob.shop.addSellingItem("ancientfossilshovel", new SellingShopItem()).setStaticPriceBasedOnHappiness(600, 700, 50).addKilledMobRequirement("sageandgrit");
      Mob.shop.addSellingItem("wire", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(2, 4, 0);
      Mob.shop.addSellingItem("wrench", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 75, 5);
      Mob.shop.addSellingItem("cutter", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 75, 5);
      Mob.shop.addSellingItem("warrior_ring", new SellingShopItem()).setStaticPriceBasedOnHappiness(500, 700, 10).addKilledMobRequirement("ancientvulture");
      
      Mob.shop.addBuyingItem("sapphire", new BuyingShopItem()).setPriceBasedOnHappiness(35, 25, 5);
      Mob.shop.addBuyingItem("amethyst", new BuyingShopItem()).setPriceBasedOnHappiness(35, 25, 5);
      Mob.shop.addBuyingItem("ruby", new BuyingShopItem()).setPriceBasedOnHappiness(35, 25, 5);
      Mob.shop.addBuyingItem("emerald", new BuyingShopItem()).setPriceBasedOnHappiness(35, 25, 5);
      Mob.shop.addBuyingItem("topaz", new BuyingShopItem()).setPriceBasedOnHappiness(35, 25, 5);
      Mob.shop.addBuyingItem("pearl", new BuyingShopItem()).setPriceBasedOnHappiness(125, 75, 5);
      Mob.shop.addBuyingItem("glacialshard", new BuyingShopItem()).setPriceBasedOnHappiness(20, 12, 2).addKilledMobRequirement("piratecaptain");
      Mob.shop.addBuyingItem("amber", new BuyingShopItem()).setPriceBasedOnHappiness(25, 15, 2).addKilledMobRequirement("piratecaptain");
      Mob.shop.addBuyingItem("phantomdust", new BuyingShopItem()).setPriceBasedOnHappiness(35, 20, 2).addKilledMobRequirement("nightswarm");
      Mob.shop.addBuyingItem("slimematter", new BuyingShopItem()).setPriceBasedOnHappiness(35, 20, 2).addKilledMobRequirement("motherslime");
      Mob.shop.addBuyingItem("spidervenom", new BuyingShopItem()).setPriceBasedOnHappiness(35, 20, 2).addKilledMobRequirement("spiderempress");
      Mob.shop.addBuyingItem("nightsteelbar", new BuyingShopItem()).setPriceBasedOnHappiness(50, 25, 2).addKilledMobRequirement("nightswarm");
      Mob.shop.addBuyingItem("spideritebar", new BuyingShopItem()).setPriceBasedOnHappiness(50, 25, 2).addKilledMobRequirement("spiderempress");
      Mob.shop.addBuyingItem("slimeum", new BuyingShopItem()).setPriceBasedOnHappiness(30, 20, 2).addKilledMobRequirement("motherslime");
      Mob.shop.addBuyingItem("omnicrystal", new BuyingShopItem()).setPriceBasedOnHappiness(60, 40, 2).addKilledMobRequirement("crystaldragon");
      Mob.shop.addBuyingItem("pearlescentdiamond", new BuyingShopItem()).setPriceBasedOnHappiness(60, 40, 2).addKilledMobRequirement("crystaldragon");
  }
}
