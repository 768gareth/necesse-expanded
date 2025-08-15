package NecesseExpanded.Settlers;

import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.registries.GameRegistry;
import necesse.entity.mobs.friendly.human.humanShop.AnglerHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = AnglerHumanMob.class, arguments = {})
public class AnglerPatch 
{
  @OnMethodExit
  static void onExit(@This AnglerHumanMob Mob) 
  {
      if (NecesseExpanded.Main.Options.isShopChangesEnabled)
      {
        ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);

        // Bait
        Mob.shop.addSellingItem("wormbait", new SellingShopItem(50, 10))
          .setStaticPriceBasedOnHappiness(10, 15, 5);
    
        Mob.shop.addSellingItem("anglersbait", new SellingShopItem(50, 10))
          .setStaticPriceBasedOnHappiness(20, 30, 5);
        
        // Fishing rods.
        Mob.shop.addSellingItem("woodfishingrod", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(40, 50, 5);
    
        Mob.shop.addSellingItem("ironfishingrod", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(75, 100, 5);
    
        Mob.shop.addSellingItem("overgrownfishingrod", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(150, 200, 10)
          .addKilledMobRequirement("swampguardian");
    
        Mob.shop.addSellingItem("goldfishingrod", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(250, 300, 10)
          .addKilledMobRequirement("piratecaptain");
    
        Mob.shop.addSellingItem("depthscatcher", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(400, 500, 25)
          .addKilledMobRequirement("reaper");
      }
  }
}