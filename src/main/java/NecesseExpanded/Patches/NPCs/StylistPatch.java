package NecesseExpanded.Patches.NPCs;

import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.seasons.GameSeasons;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import necesse.entity.mobs.friendly.human.humanShop.StylistHumanMob;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = StylistHumanMob.class, arguments = {})
public class StylistPatch 
{
  @OnMethodExit
  static void onExit(@This StylistHumanMob Mob) 
  {
      Mob.shop.addSellingItem("farmerhat", new SellingShopItem()).setStaticPriceBasedOnHappiness(85, 160, 30);
      Mob.shop.addSellingItem("farmershirt", new SellingShopItem()).setStaticPriceBasedOnHappiness(100, 200, 30);
      Mob.shop.addSellingItem("farmershoes", new SellingShopItem()).setStaticPriceBasedOnHappiness(70, 150, 30);
      Mob.shop.addSellingItem("rainhat", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("raincoat", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("rainboots", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("magehat", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("magerobe", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("mageshoes", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("engineergoggles", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("labapron", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("alchemistglasses", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("labcoat", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("labboots", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("hunterhood", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("huntershirt", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("hunterboots", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("animalkeepershat", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("animalkeepershirt", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("animalkeepershoes", new SellingShopItem()).setStaticPriceBasedOnHappiness(75, 150, 20);
      Mob.shop.addSellingItem("hulahat", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("hulaskirtwithtop", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("hulaskirt", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("sunglasses", new SellingShopItem()).setStaticPriceBasedOnHappiness(300, 600);
      Mob.shop.addSellingItem("swimsuit", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("swimtrunks", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("snowhood", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("snowcloak", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("snowboots", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("sailorhat", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("sailorshirt", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("sailorshoes", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("jesterhat", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("jestershirt", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("jesterboots", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("spacehelmet", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("spacesuit", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      Mob.shop.addSellingItem("spaceboots", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);

      if (GameSeasons.isChristmas())
      {
        Mob.shop.addSellingItem("christmashat", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      }
      else if (GameSeasons.isHalloween())
      {
        Mob.shop.addSellingItem("pumpkinmask", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 400);
      }
  }
}
