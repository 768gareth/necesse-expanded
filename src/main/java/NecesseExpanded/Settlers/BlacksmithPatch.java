package NecesseExpanded.Settlers;

import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.registries.GameRegistry;
import necesse.entity.mobs.friendly.human.humanShop.BlacksmithHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = BlacksmithHumanMob.class, arguments = {})
public class BlacksmithPatch 
{
  @OnMethodExit
  static void onExit(@This BlacksmithHumanMob Mob) 
  {
      if (NecesseExpanded.Main.Options.isShopChangesEnabled)
      {
        ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);

        // Iron equipment
        Mob.shop.addSellingItem("ironsword", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(50, 75, 5);
    
        Mob.shop.addSellingItem("ironpickaxe", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(50, 75, 5);
    
        Mob.shop.addSellingItem("ironaxe", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(50, 75, 5);
    
        Mob.shop.addSellingItem("ironshovel", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(50, 75, 5);
    
        // Demonic equipment
        Mob.shop.addSellingItem("demonicsword", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(150, 200, 10)
          .addKilledMobRequirement("evilsprotector");
    
        Mob.shop.addSellingItem("demonicpickaxe", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(150, 200, 10)
          .addKilledMobRequirement("evilsprotector");
    
        Mob.shop.addSellingItem("demonicaxe", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(150, 200, 10)
          .addKilledMobRequirement("evilsprotector");
    
        Mob.shop.addSellingItem("demonicshovel", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(150, 200, 10)
          .addKilledMobRequirement("evilsprotector");
    
        // Tungsten equipment
        Mob.shop.addSellingItem("tungstensword", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(300, 400, 25)
          .addKilledMobRequirement("reaper");
    
        Mob.shop.addSellingItem("tungstenpickaxe", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(300, 400, 25)
          .addKilledMobRequirement("reaper");
    
        Mob.shop.addSellingItem("tungstenaxe", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(300, 400, 25)
          .addKilledMobRequirement("reaper");
    
        Mob.shop.addSellingItem("tungstenshovel", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(300, 400, 25)
          .addKilledMobRequirement("reaper");
    
        // Ancient fossil equipment.
        Mob.shop.addSellingItem("ancientfossilpickaxe", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(600, 700, 50)
          .addKilledMobRequirement("sageandgrit");
    
        Mob.shop.addSellingItem("ancientfossilaxe", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(600, 700, 50)
          .addKilledMobRequirement("sageandgrit");
    
        Mob.shop.addSellingItem("ancientfossilshovel", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(600, 700, 50)
          .addKilledMobRequirement("sageandgrit");
    
        // Wiring equipment.
        Mob.shop.addSellingItem("wire", new SellingShopItem(200, 25))
          .setStaticPriceBasedOnHappiness(2, 4, 0);
    
        Mob.shop.addSellingItem("wrench", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(50, 75, 5);
    
        Mob.shop.addSellingItem("cutter", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(50, 75, 5);
      }
  }
}
