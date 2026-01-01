package NecesseExpanded.Patches.NPCs;

import NecesseExpanded.Utils.ClearRegistry;
import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.registries.GameRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.friendly.human.humanShop.ExoticMerchantHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootList;
import necesse.inventory.lootTable.presets.CaveChestLootTable;
import necesse.inventory.lootTable.presets.DeepCaveChestLootTable;
import necesse.inventory.lootTable.presets.OldVinylsLootTable;
import necesse.inventory.lootTable.presets.PaintingSelectionTable;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;;

@ModConstructorPatch(target = ExoticMerchantHumanMob.class, arguments = {})
public class ExoticMerchantPatch 
{
  @OnMethodExit
  static void onExit(@This ExoticMerchantHumanMob Mob) 
  {
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);

      Mob.shop.addSellingItem("recallscroll", new SellingShopItem()).setRandomPrice(35, 45);
      Mob.shop.addSellingItem("jumpingball", new SellingShopItem()).setRandomPrice(600, 800);
      Mob.shop.addSellingItem("inefficientfeather", new SellingShopItem()).setRandomPrice(500, 1500);
      Mob.shop.addSellingItem("weticicle", new SellingShopItem()).setRandomPrice(300, 900);
      Mob.shop.addSellingItem("exoticseeds", new SellingShopItem()).setRandomPrice(400, 1000);
      Mob.shop.addSellingItem("binoculars", new SellingShopItem()).setRandomPrice(200, 300);
      Mob.shop.addSellingItem("recipebook", new SellingShopItem()).setRandomPrice(500, 800);

      String FoodItemID = GameRandom.globalRandom.getOneOf
      (
        "cappuccino", "wildsalad", "strawberrypie", "raspberrypie",
        "sweetlemonade", "pumpkinpie", "shishkebab", "spaghettibolognese",
        "deepfriedchicken", "parisiansteak", "jam_donut"
      );
      String DrinkItemID = GameRandom.globalRandom.getOneOf
      (
        "mead", "blackberry_wine", "blueberry_wine", "raspberry_wine",
        "beer", "cider", "whiskey"
      );
      Mob.shop.addSellingItem(FoodItemID, new SellingShopItem(20, 5)).setRandomPrice(60, 80);
      Mob.shop.addSellingItem(DrinkItemID, new SellingShopItem(20, 5)).setRandomPrice(40, 60);

      GameRandom Random = new GameRandom();
      Mob.shop.sellingShop.addItem("painting_rare", new SellingShopItem().setItem(PaintingSelectionTable.getRandomLargeRarePaintingIDBasedOnWeight(Random))).setRandomPrice(600, 800);
      Mob.shop.sellingShop.addItem("painting_uncommon", new SellingShopItem().setItem(PaintingSelectionTable.getRandomUncommonPaintingIDBasedOnWeight(Random))).setRandomPrice(400, 600);
      Mob.shop.sellingShop.addItem("painting_common", new SellingShopItem().setItem(PaintingSelectionTable.getRandomCommonPaintingIDBasedOnWeight(Random))).setRandomPrice(200, 400);

      // Vinyls
      LootList BasicMusicList = new LootList();
      CaveChestLootTable.basicVinyls.addPossibleCustomLoot(BasicMusicList, new Object[0]);
      CaveChestLootTable.snowVinyls.addPossibleCustomLoot(BasicMusicList, new Object[0]);
      CaveChestLootTable.desertVinyls.addPossibleCustomLoot(BasicMusicList, new Object[0]);
      CaveChestLootTable.plainsVinyls.addPossibleCustomLoot(BasicMusicList, new Object[0]);
      CaveChestLootTable.swampVinyls.addPossibleCustomLoot(BasicMusicList, new Object[0]);
      BasicMusicList.add("theeldersjinglejamvinyl").add("adventurebeginsvinyl");
      InventoryItem BasicVinyl = BasicMusicList.getCombinedItemsAndCustomItems().get(GameRandom.globalRandom.getIntBetween(0, BasicMusicList.getCombinedItemsAndCustomItems().size() - 1));
      Mob.shop.sellingShop.addItem("basic_vinyl", new SellingShopItem().setItem(BasicVinyl)).setRandomPrice(200, 400);

      LootList DeepMusicList = new LootList();
      DeepCaveChestLootTable.basicVinyls.addPossibleCustomLoot(DeepMusicList, new Object[0]);
      DeepCaveChestLootTable.snowVinyls.addPossibleCustomLoot(DeepMusicList, new Object[0]);
      DeepCaveChestLootTable.desertVinyls.addPossibleCustomLoot(DeepMusicList, new Object[0]);
      DeepCaveChestLootTable.plainsVinyls.addPossibleCustomLoot(DeepMusicList, new Object[0]);
      DeepCaveChestLootTable.swampVinyls.addPossibleCustomLoot(DeepMusicList, new Object[0]);
      InventoryItem DeepVinyl = DeepMusicList.getCombinedItemsAndCustomItems().get(GameRandom.globalRandom.getIntBetween(0, DeepMusicList.getCombinedItemsAndCustomItems().size() - 1));
      Mob.shop.sellingShop.addItem("deep_vinyl", new SellingShopItem().setItem(DeepVinyl)).setRandomPrice(400, 600).addKilledMobRequirement("piratecaptain");

      LootList OldMusicList = new LootList();
      OldVinylsLootTable.oldVinyls.addPossibleCustomLoot(OldMusicList, new Object[0]);
      InventoryItem OldVinyl = OldMusicList.getCombinedItemsAndCustomItems().get(GameRandom.globalRandom.getIntBetween(0, OldMusicList.getCombinedItemsAndCustomItems().size() - 1));
      Mob.shop.sellingShop.addItem("old_vinyl", new SellingShopItem().setItem(OldVinyl)).setRandomPrice(600, 800).addKilledMobRequirement("fallenwizard");
  }
}
