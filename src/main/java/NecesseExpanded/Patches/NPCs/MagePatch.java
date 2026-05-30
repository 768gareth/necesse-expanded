package NecesseExpanded.Patches.NPCs;

import NecesseExpanded.Utils.ClearRegistry;
import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.GameRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.friendly.human.humanShop.BuyingShopItem;
import necesse.entity.mobs.friendly.human.humanShop.HumanShop;
import necesse.entity.mobs.friendly.human.humanShop.MageHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.placeableItem.objectItem.WaystoneObjectItem;
import necesse.level.maps.levelData.settlementData.ServerSettlementData;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = MageHumanMob.class, arguments = {})
public class MagePatch 
{
  @OnMethodExit
  static void onExit(@This MageHumanMob Mob) 
  {
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);
      Mob.shop.addSellingItem("voidpouch", new SellingShopItem()).setStaticPriceBasedOnHappiness(750, 1000, 50);
      Mob.shop.addSellingItem("voidbag", new SellingShopItem()).setStaticPriceBasedOnHappiness(2500, 3000, 100);
      Mob.shop.addSellingItem("homestone", new SellingShopItem()).setItem(MagePatch::GenerateHomestone).setStaticPriceBasedOnHappiness(1000, 1250, 100);
      Mob.shop.addSellingItem("waystone", new SellingShopItem()).setItem(MagePatch::GenerateWaystone).setStaticPriceBasedOnHappiness(250, 500, 100);
      Mob.shop.addSellingItem("recallscroll", new SellingShopItem()).setStaticPriceBasedOnHappiness(25, 50, 5);
      Mob.shop.addSellingItem("bloodbolt", new SellingShopItem()).setStaticPriceBasedOnHappiness(70, 100, 5);
      Mob.shop.addSellingItem("frostbolt", new SellingShopItem()).setStaticPriceBasedOnHappiness(90, 100, 5).addKilledMobRequirement("queenspider");
      Mob.shop.addSellingItem("brainonastick", new SellingShopItem()).setStaticPriceBasedOnHappiness(425, 500, 15);
      Mob.shop.addSellingItem("voidstaff", new SellingShopItem()).setStaticPriceBasedOnHappiness(400, 600, 10).addKilledMobRequirement("evilsprotector");
      Mob.shop.addSellingItem("shadowbeam", new SellingShopItem()).setStaticPriceBasedOnHappiness(800, 900, 25).addKilledMobRequirement("reaper");
      Mob.shop.addSellingItem("inferno", new SellingShopItem()).setStaticPriceBasedOnHappiness(800, 900, 25).addKilledMobRequirement("reaper");
      Mob.shop.addSellingItem("reaperscall", new SellingShopItem()).setStaticPriceBasedOnHappiness(725, 800, 25).addKilledMobRequirement("reaper");
      Mob.shop.addSellingItem("venomshower", new SellingShopItem()).setStaticPriceBasedOnHappiness(1200, 1500, 50).addKilledMobRequirement("sageandgrit");
      Mob.shop.addSellingItem("manapotion", new SellingShopItem()).setStaticPriceBasedOnHappiness(10, 25, 5);
      Mob.shop.addSellingItem("greatermanapotion", new SellingShopItem()).setStaticPriceBasedOnHappiness(40, 50, 5).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("superiormanapotion", new SellingShopItem()).setStaticPriceBasedOnHappiness(80, 100, 5).addKilledMobRequirement("fallenwizard");
      Mob.shop.addSellingItem("manaregenpotion", new SellingShopItem()).setStaticPriceBasedOnHappiness(10, 25, 5);
      Mob.shop.addSellingItem("greatermanaregenpotion", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 100, 5).addKilledMobRequirement("fallenwizard");
      Mob.shop.addSellingItem("wisdompotion", new SellingShopItem()).setStaticPriceBasedOnHappiness(25, 50, 5).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("minionpotion", new SellingShopItem()).setStaticPriceBasedOnHappiness(25, 50, 5).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("magicmanual", new SellingShopItem()).setStaticPriceBasedOnHappiness(300, 400, 10).addKilledMobRequirement("evilsprotector");
      Mob.shop.addSellingItem("inducingamulet", new SellingShopItem()).setStaticPriceBasedOnHappiness(600, 800, 10).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("summoner_grimoire", new SellingShopItem()).setStaticPriceBasedOnHappiness(500, 700, 10).addKilledMobRequirement("ancientvulture");
      Mob.shop.addSellingItem("ancient_tablet", new SellingShopItem()).setStaticPriceBasedOnHappiness(500, 700, 10).addKilledMobRequirement("ancientvulture");
      Mob.shop.addBuyingItem("book", new BuyingShopItem()).setPriceBasedOnHappiness(30, 15, 5);
  }
  
  public static InventoryItem GenerateHomestone(GameRandom random, ServerClient client, HumanShop mob) {
    ServerSettlementData Settlement = mob.getSettlerSettlementServerData();
    return (Settlement != null) ? 
      new InventoryItem("homestone") : null;
  }
  
  public static InventoryItem GenerateWaystone(GameRandom random, ServerClient client, HumanShop mob) {
    ServerSettlementData Settlement = mob.getSettlerSettlementServerData();
    return (Settlement != null) ?  
      WaystoneObjectItem.setupWaystoneItem(new InventoryItem("waystone"), mob.getSettlementUniqueID()) : 
      null;
  }
}
