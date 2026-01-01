package NecesseExpanded.Mobs.Friendly.Critters;

import java.awt.Color;

import necesse.engine.registries.MobRegistry.Textures;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.friendly.critters.caveling.CavelingMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootTable;

public class SlimeCaveling extends CavelingMob {
   public SlimeCaveling() {
      super(750, 55);
   }

   public void init() {
      super.init();
      this.texture = Textures.deepStoneCaveling;
      this.popParticleColor = new Color(18, 48, 18);
      this.singleRockSmallStringID = "slimecaverocksmall";
      if (this.item == null) {
         this.item = new InventoryItem("slimeum", GameRandom.globalRandom.getIntBetween(4, 8));
      }
   }

   public LootTable getLootTable() {
      return super.getLootTable();
   }
}
