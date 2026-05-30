package NecesseExpanded.Patches.NPCs;

import NecesseExpanded.Utils.ClearRegistry;
import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.registries.GameRegistry;
import necesse.entity.mobs.friendly.human.humanShop.AnglerHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.BuyingShopItem;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = AnglerHumanMob.class, arguments = {})
public class AnglerPatch {
  @OnMethodExit
  static void onExit(@This AnglerHumanMob Mob) 
  {
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);
    
      Mob.shop.addSellingItem("wormbait", new SellingShopItem(50, 10)).setStaticPriceBasedOnHappiness(10, 15, 5);
      Mob.shop.addSellingItem("anglersbait", new SellingShopItem(50, 10)).setStaticPriceBasedOnHappiness(20, 30, 5);
      Mob.shop.addSellingItem("woodfishingrod", new SellingShopItem()).setStaticPriceBasedOnHappiness(60, 70, 5);
      Mob.shop.addSellingItem("ironfishingrod", new SellingShopItem()).setStaticPriceBasedOnHappiness(150, 180, 5);
      Mob.shop.addSellingItem("overgrownfishingrod", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 300, 10).addKilledMobRequirement("swampguardian");
      Mob.shop.addSellingItem("goldfishingrod", new SellingShopItem()).setStaticPriceBasedOnHappiness(350, 400, 10).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("depthscatcher", new SellingShopItem()).setStaticPriceBasedOnHappiness(500, 600, 25).addKilledMobRequirement("reaper");

      Mob.shop.buyingShop.addItem("demonfish", new BuyingShopItem().setPriceBasedOnHappiness(25, 15).addKilledMobRequirement("voidwizard"));
      Mob.shop.buyingShop.addItem("heartfish", new BuyingShopItem().setPriceBasedOnHappiness(35, 25).addKilledMobRequirement("reaper"));
      Mob.shop.buyingShop.addItem("glacierfish", new BuyingShopItem().setPriceBasedOnHappiness(35, 25).addKilledMobRequirement("reaper"));
      Mob.shop.buyingShop.addItem("slimefish", new BuyingShopItem().setPriceBasedOnHappiness(45, 35).addKilledMobRequirement("fallenwizard"));
      Mob.shop.buyingShop.addItem("pearlfish", new BuyingShopItem().setPriceBasedOnHappiness(60, 50).addKilledMobRequirement("crystaldragon"));
  }
}