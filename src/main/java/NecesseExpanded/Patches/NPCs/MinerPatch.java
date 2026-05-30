package NecesseExpanded.Patches.NPCs;

import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.entity.mobs.friendly.human.humanShop.MinerHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = MinerHumanMob.class, arguments = {})
public class MinerPatch {
  @OnMethodExit
  static void onExit(@This MinerHumanMob Mob) 
  {
      Mob.shop.addSellingItem("coinpouch", new SellingShopItem()).setStaticPriceBasedOnHappiness(750, 1000, 50);
      Mob.shop.addSellingItem("ironbomb", new SellingShopItem()).setStaticPriceBasedOnHappiness(15, 25, 5);
      Mob.shop.addSellingItem("dynamitestick", new SellingShopItem()).setStaticPriceBasedOnHappiness(25, 50, 5);
      Mob.shop.addSellingItem("minersprosthetic", new SellingShopItem()).setStaticPriceBasedOnHappiness(700, 900, 10).addKilledMobRequirement("cryoqueen");
      Mob.shop.addSellingItem("diggingclaw", new SellingShopItem()).setStaticPriceBasedOnHappiness(800, 1000, 10).addKilledMobRequirement("sageandgrit");
  }
}

