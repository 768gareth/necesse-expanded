package NecesseExpanded.Mobs.Friendly.Human;

import java.util.ArrayList;

import necesse.engine.localization.message.GameMessage;
import necesse.engine.network.server.ServerClient;
import necesse.entity.mobs.friendly.human.humanShop.HumanShop;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import necesse.gfx.drawOptions.human.HumanDrawOptions;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;

public class FriendlyDryadMob extends HumanShop 
{
   public FriendlyDryadMob() {
      super(2000, 2000, "friendly_dryad");
      this.attackCooldown = 500;
      this.attackAnimTime = 500;
      this.setSwimSpeed(1.0F);

      this.equipmentInventory.setItem(6, new InventoryItem("livingshotty"));

      this.shop.addSellingItem("willowisplantern", new SellingShopItem()).setRandomPrice(250, 300);
      this.shop.addSellingItem("explorersatchel", new SellingShopItem()).setRandomPrice(250, 300);
      this.shop.addSellingItem("healthpotion", new SellingShopItem(20, 5)).setRandomPrice(15, 20);
      this.shop.addSellingItem("greaterhealthpotion", new SellingShopItem(20, 5)).setRandomPrice(40, 50).addKilledMobRequirement("piratecaptain");
      this.shop.addSellingItem("superiorhealthpotion", new SellingShopItem(20, 5)).setRandomPrice(150, 200).addKilledMobRequirement("fallenwizard");
      this.shop.addSellingItem("manapotion", new SellingShopItem(20, 5)).setRandomPrice(10, 25);
      this.shop.addSellingItem("greatermanapotion", new SellingShopItem(20, 5)).setRandomPrice(40, 50).addKilledMobRequirement("piratecaptain");
      this.shop.addSellingItem("superiormanapotion", new SellingShopItem(20, 5)).setRandomPrice(150, 200).addKilledMobRequirement("fallenwizard");
      this.shop.addSellingItem("recallscroll", new SellingShopItem(10, 5)).setRandomPrice(25, 50);
   }

   public LootTable getLootTable() {
      return new LootTable( new LootItemInterface[] { new LootItem("spiriturn")} );
   }

   public void setDefaultArmor(HumanDrawOptions drawOptions) 
   {
      drawOptions.helmet(new InventoryItem("leatherhood"));
      drawOptions.chestplate(new InventoryItem("leathershirt"));
      drawOptions.boots(new InventoryItem("leatherboots"));
   }

   protected ArrayList<GameMessage> getMessages(ServerClient client) 
   {
      return this.getLocalMessages("dryadgreeting", 3);
   }
}
    

