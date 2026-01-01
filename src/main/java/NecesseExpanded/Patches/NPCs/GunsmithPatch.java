package NecesseExpanded.Patches.NPCs;

import NecesseExpanded.Utils.ClearRegistry;
import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.registries.GameRegistry;
import necesse.entity.mobs.friendly.human.humanShop.GunsmithHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = GunsmithHumanMob.class, arguments = {})
public class GunsmithPatch 
{
  @OnMethodExit
  static void onExit(@This GunsmithHumanMob Mob) 
  {
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);
      Mob.shop.addSellingItem("ammobox", new SellingShopItem()).setStaticPriceBasedOnHappiness(500, 750, 50);
      Mob.shop.addSellingItem("lensmaker_glasses", new SellingShopItem()).setStaticPriceBasedOnHappiness(400, 500, 10).addKilledMobRequirement("ancientvulture");
      Mob.shop.addSellingItem("ammopouch", new SellingShopItem()).setStaticPriceBasedOnHappiness(750, 1000, 50);
      Mob.shop.addSellingItem("ammobag", new SellingShopItem()).setStaticPriceBasedOnHappiness(1500, 2000, 50);
      Mob.shop.addSellingItem("handgun", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 250, 5);
      Mob.shop.addSellingItem("machinegun", new SellingShopItem()).setStaticPriceBasedOnHappiness(400, 500, 10).addKilledMobRequirement("evilsprotector");
      Mob.shop.addSellingItem("deathripper", new SellingShopItem()).setStaticPriceBasedOnHappiness(800, 900, 25).addKilledMobRequirement("reaper");
      Mob.shop.addSellingItem("antiquerifle", new SellingShopItem()).setStaticPriceBasedOnHappiness(1200, 1500, 50).addKilledMobRequirement("sageandgrit");
      Mob.shop.addSellingItem("simplebullet", new SellingShopItem()).setStaticPriceBasedOnHappiness(1, 2, 0);
      Mob.shop.addSellingItem("bouncingbullet", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(3, 4, 0);
      Mob.shop.addSellingItem("voidbullet", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(4, 5, 0);
      Mob.shop.addSellingItem("frostbullet", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(4, 5, 0);
      Mob.shop.addSellingItem("crystalbullet", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(10, 12, 0).addKilledMobRequirement("fallenwizard");
      Mob.shop.addSellingItem("vampire_bullet", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(10, 12, 0).addKilledMobRequirement("nightswarm");
      Mob.shop.addSellingItem("venom_bullet", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(10, 12, 0).addKilledMobRequirement("motherslime");
      Mob.shop.addSellingItem("cannonball", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(15, 20, 0).addKilledMobRequirement("piratecaptain");
  }
}