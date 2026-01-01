package NecesseExpanded.Mobs.Friendly.Critters;

import java.awt.Color;

import necesse.engine.registries.MobRegistry.Textures;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.friendly.critters.caveling.CavelingMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootTable;

public class ShardCaveling extends CavelingMob {
   public ShardCaveling() {
      super(750, 55);
   }

   public void init() {
      super.init();
      this.texture = Textures.deepStoneCaveling;
      this.popParticleColor = new Color(105, 105, 105);
      this.singleRockSmallStringID = "deepcaverocksmall";
      if (this.item == null) {
         this.item = GameRandom.globalRandom.getOneOf
         (
            new InventoryItem("upgradeshard", GameRandom.globalRandom.getIntBetween(4, 8)),
            new InventoryItem("alchemyshard", GameRandom.globalRandom.getIntBetween(4, 8))
         );
      }
   }

   public LootTable getLootTable() {
      return super.getLootTable();
   }
}
