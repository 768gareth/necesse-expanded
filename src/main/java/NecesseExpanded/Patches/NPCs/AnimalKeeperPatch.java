package NecesseExpanded.Patches.NPCs;

import NecesseExpanded.Utils.ClearRegistry;
import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.registries.GameRegistry;
import necesse.entity.mobs.friendly.human.humanShop.AnimalKeeperHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.BuyingShopItem;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = AnimalKeeperHumanMob.class, arguments = {})
public class AnimalKeeperPatch 
{
  @OnMethodExit
  static void onExit(@This AnimalKeeperHumanMob Mob) 
  {
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);
    
      Mob.shop.addSellingItem("queenbee", new SellingShopItem()).setStaticPriceBasedOnHappiness(300, 400, 10);
      Mob.shop.addSellingItem("shears", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 100, 10);
      Mob.shop.addSellingItem("bucket", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 100, 10);
      Mob.shop.addSellingItem("rope", new SellingShopItem(10, 5)).setStaticPriceBasedOnHappiness(20, 40, 10);
      Mob.shop.addSellingItem("infiniterope", new SellingShopItem()).setStaticPriceBasedOnHappiness(600, 800, 10);
      
      Mob.shop.addBuyingItem("leather", new BuyingShopItem()).setPriceBasedOnHappiness(5, 2, 0);
      Mob.shop.addBuyingItem("wool", new BuyingShopItem()).setPriceBasedOnHappiness(5, 2, 0);
      Mob.shop.addBuyingItem("egg", new BuyingShopItem()).setPriceBasedOnHappiness(7, 4, 0);

      
  }
}
