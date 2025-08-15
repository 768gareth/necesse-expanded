package NecesseExpanded.Settlers;

import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.GameRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.friendly.human.humanShop.BuyingShopItem;
import necesse.entity.mobs.friendly.human.humanShop.HumanShop;
import necesse.entity.mobs.friendly.human.humanShop.MageHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.placeableItem.objectItem.HomestoneObjectItem;
import necesse.inventory.item.placeableItem.objectItem.WaystoneObjectItem;
import necesse.level.maps.levelData.settlementData.SettlementLevelData;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = MageHumanMob.class, arguments = {})
public class MagePatch {
  @OnMethodExit
  static void onExit(@This MageHumanMob Mob) 
  {
      if (NecesseExpanded.Main.Options.isShopChangesEnabled)
      {
        ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);

        // Bags.
        Mob.shop.addSellingItem("voidpouch", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(750, 1000, 50);
    
        Mob.shop.addSellingItem("voidbag", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(2500, 3000, 100);
    
        // Fast travel.
        Mob.shop.addSellingItem("homestone", new SellingShopItem())
          .setItem(MagePatch::GenerateHomestone)
          .setStaticPriceBasedOnHappiness(1000, 1250, 100);
    
        Mob.shop.addSellingItem("waystone", new SellingShopItem())
          .setItem(MagePatch::GenerateWaystone)
          .setStaticPriceBasedOnHappiness(250, 500, 100);
    
        Mob.shop.addSellingItem("travelstone", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(1000, 1250, 100);
    
        // Scrolls.
        Mob.shop.addSellingItem("recallscroll", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(25, 50, 5);
    
        Mob.shop.addSellingItem("travelscroll", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(50, 75, 5);
    
        // Weapons
        Mob.shop.addSellingItem("bloodbolt", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(60, 75, 5);
    
        Mob.shop.addSellingItem("voidstaff", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(400, 600, 10)
          .addKilledMobRequirement("evilsprotector");
    
        Mob.shop.addSellingItem("shadowbeam", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(800, 900, 25)
          .addKilledMobRequirement("reaper");
    
        Mob.shop.addSellingItem("venomshower", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(1200, 1500, 50)
          .addKilledMobRequirement("sageandgrit");
    
        // Potions
        Mob.shop.addSellingItem("manapotion", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(10, 25, 5);
    
        Mob.shop.addSellingItem("greatermanapotion", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(40, 50, 5)
          .addKilledMobRequirement("piratecaptain");
    
        Mob.shop.addSellingItem("superiormanapotion", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(80, 100, 5)
          .addKilledMobRequirement("fallenwizard");
    
        Mob.shop.addSellingItem("manaregenpotion", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(10, 25, 5);
    
        Mob.shop.addSellingItem("greatermanaregenpotion", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(50, 100, 5)
          .addKilledMobRequirement("fallenwizard");
    
        Mob.shop.addSellingItem("wisdompotion", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(25, 50, 5)
          .addKilledMobRequirement("piratecaptain");
    
        Mob.shop.addSellingItem("minionpotion", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(25, 50, 5)
          .addKilledMobRequirement("piratecaptain");
    
        // Accessory.
        Mob.shop.addSellingItem("magicmanual", new SellingShopItem())
          .setStaticPriceBasedOnHappiness(300, 400, 10)
          .addKilledMobRequirement("evilsprotector");
    
        // Buying options.
        Mob.shop.addBuyingItem("book", new BuyingShopItem())
          .setPriceBasedOnHappiness(30, 15, 5);
      }
      
  }
  
  public static InventoryItem GenerateHomestone(GameRandom random, ServerClient client, HumanShop mob) {
    SettlementLevelData Settlement = mob.getSettlementLevelData();
    return (Settlement != null) ? 
      HomestoneObjectItem.setupHomestoneItem(new InventoryItem("homestone"), Settlement.getLevel()) : 
      null;
  }
  
  public static InventoryItem GenerateWaystone(GameRandom random, ServerClient client, HumanShop mob) {
    SettlementLevelData Settlement = mob.getSettlementLevelData();
    return (Settlement != null) ? 
      WaystoneObjectItem.setupWaystoneItem(new InventoryItem("waystone"), Settlement.getLevel()) : 
      null;
  }
}