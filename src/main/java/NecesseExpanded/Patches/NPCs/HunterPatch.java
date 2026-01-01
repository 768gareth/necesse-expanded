package NecesseExpanded.Patches.NPCs;

import NecesseExpanded.Utils.ClearRegistry;
import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.registries.GameRegistry;
import necesse.entity.mobs.friendly.human.humanShop.HunterHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = HunterHumanMob.class, arguments = {})
public class HunterPatch {
  @OnMethodExit
  static void onExit(@This HunterHumanMob Mob) 
  {
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);
      Mob.shop.addSellingItem("magicalquiver", new SellingShopItem()).setStaticPriceBasedOnHappiness(500, 750, 50);
      Mob.shop.addSellingItem("lensmaker_glasses", new SellingShopItem()).setStaticPriceBasedOnHappiness(400, 500, 10).addKilledMobRequirement("ancientvulture");
      Mob.shop.addSellingItem("ammopouch", new SellingShopItem()).setStaticPriceBasedOnHappiness(750, 1000, 50);
      Mob.shop.addSellingItem("ammobag", new SellingShopItem()).setStaticPriceBasedOnHappiness(1500, 2000, 50);
      Mob.shop.addSellingItem("ironbow", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 75, 5);
      Mob.shop.addSellingItem("demonicbow", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 250, 10).addKilledMobRequirement("evilsprotector");
      Mob.shop.addSellingItem("tungstenbow", new SellingShopItem()).setStaticPriceBasedOnHappiness(450, 500, 25).addKilledMobRequirement("reaper");
      Mob.shop.addSellingItem("bowofdualism", new SellingShopItem()).setStaticPriceBasedOnHappiness(700, 800, 50).addKilledMobRequirement("sageandgrit");
      Mob.shop.addSellingItem("stonearrow", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(2, 3, 0);
      Mob.shop.addSellingItem("firearrow", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(3, 4, 0);
      Mob.shop.addSellingItem("bouncingarrow", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(4, 5, 0);
      Mob.shop.addSellingItem("frostarrow", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(4, 5, 0);
      Mob.shop.addSellingItem("poisonarrow", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(4, 5, 0);
      Mob.shop.addSellingItem("ironarrow", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(5, 6, 0);
      Mob.shop.addSellingItem("bonearrow", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(6, 7, 0).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("spideritearrow", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(10, 12, 0).addKilledMobRequirement("fallenwizard");
  }
}