package NecesseExpanded.Items.Weapons.Magic;

import NecesseExpanded.Projectiles.InfernoProjectile;
import necesse.engine.localization.Localization;
import necesse.engine.network.gameNetworkData.GNDItemMap;
import necesse.engine.sound.SoundEffect;
import necesse.engine.sound.SoundManager;
import necesse.engine.util.GameBlackboard;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.itemAttacker.ItemAttackSlot;
import necesse.entity.mobs.itemAttacker.ItemAttackerMob;
import necesse.entity.projectile.Projectile;
import necesse.entity.projectile.modifiers.ResilienceOnHitProjectileModifier;
import necesse.gfx.GameResources;
import necesse.gfx.drawOptions.itemAttack.ItemAttackDrawOptions;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.toolItem.projectileToolItem.magicProjectileToolItem.MagicProjectileToolItem;
import necesse.inventory.lootTable.presets.MagicWeaponsLootTable;
import necesse.level.maps.Level;

public class InfernoMagicToolItem extends MagicProjectileToolItem 
{
   public InfernoMagicToolItem() {
      super(300, MagicWeaponsLootTable.magicWeapons);
      this.rarity = Rarity.RARE;
      this.attackAnimTime.setBaseValue(200);
      this.attackDamage.setBaseValue(16.0F).setUpgradedValue(1.0F, 50.0F);
      this.velocity.setBaseValue(100);
      this.attackXOffset = 14;
      this.attackYOffset = 4;
      this.attackRange.setBaseValue(300);
      this.manaCost.setBaseValue(1.5F).setUpgradedValue(1.0F, 3.0F);
      this.resilienceGain.setBaseValue(1F);
      this.itemAttackerProjectileCanHitWidth = 25.0F;
      this.itemAttackerPredictionDistanceOffset = -20.0F;
      this.canBeUsedForRaids = true;
   }

   public ListGameTooltips getPreEnchantmentTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
      ListGameTooltips tooltips = super.getPreEnchantmentTooltips(item, perspective, blackboard);
      tooltips.add(Localization.translate("itemtooltip", "inferno_tip"));
      return tooltips;
   }

   public void setDrawAttackRotation(InventoryItem item, ItemAttackDrawOptions drawOptions, float attackDirX, float attackDirY, float attackProgress) {
      drawOptions.pointRotation(attackDirX, attackDirY).forEachItemSprite((i) -> {
         i.itemRotateOffset(45.0F);
      });
   }

   public void showAttack(Level level, int x, int y, ItemAttackerMob attackerMob, int attackHeight, InventoryItem item, int animAttack, int seed, GNDItemMap mapContent) {
      if (level.isClient()) {
         SoundManager.playSound(GameResources.magicbolt2, SoundEffect.effect(attackerMob).volume(0.4F).pitch(GameRandom.globalRandom.getFloatBetween(0.8F, 0.9F)));
      }

   }

   public InventoryItem onAttack(Level level, int x, int y, ItemAttackerMob attackerMob, int attackHeight, InventoryItem item, ItemAttackSlot slot, int animAttack, int seed, GNDItemMap mapContent) {
      Projectile projectile = new InfernoProjectile(level, attackerMob.x, attackerMob.y, (float)x, (float)y, this.getAttackRange(item), this.getAttackDamage(item), attackerMob);
      projectile.setModifier(new ResilienceOnHitProjectileModifier(this.getResilienceGain(item)));
      projectile.resetUniqueID(new GameRandom((long)seed));
      attackerMob.addAndSendAttackerProjectile(projectile, 20);
      this.consumeMana(attackerMob, item);
      return item;
   }
}
