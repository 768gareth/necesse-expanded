package NecesseExpanded.Settlers;

import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.entity.mobs.friendly.human.humanShop.MinerHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = MinerHumanMob.class, arguments = {})
public class MinerPatch 
{
  @OnMethodExit
  static void onExit(@This MinerHumanMob Mob) 
  {
      if (NecesseExpanded.Main.Options.isShopChangesEnabled)
      {
        Mob.shop.addSellingItem("coinpouch", new SellingShopItem())
        .setStaticPriceBasedOnHappiness(750, 1000, 50);
  
        Mob.shop.addSellingItem("ironbomb", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(15, 25, 5);
  
        Mob.shop.addSellingItem("dynamitestick", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(25, 50, 5);
      }
  }
}
