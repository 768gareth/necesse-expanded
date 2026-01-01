package NecesseExpanded.Items.Weapons.Magic;

import necesse.engine.localization.Localization;
import necesse.engine.network.gameNetworkData.GNDItemMap;
import necesse.engine.registries.ProjectileRegistry;
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
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.toolItem.projectileToolItem.magicProjectileToolItem.MagicProjectileToolItem;
import necesse.inventory.lootTable.presets.MagicWeaponsLootTable;
import necesse.level.maps.Level;

public class BrimstoneMagicToolItem extends MagicProjectileToolItem
{
    public BrimstoneMagicToolItem() 
   {
      super(1200, MagicWeaponsLootTable.magicWeapons);
      this.rarity = Rarity.RARE;
      this.attackAnimTime.setBaseValue(500);
      this.attackDamage.setBaseValue(60.0F).setUpgradedValue(1.0F, 100.0F);
      this.velocity.setBaseValue(100);
      this.attackXOffset = 8;
      this.attackYOffset = 10;
      this.attackCooldownTime.setBaseValue(600);
      this.attackRange.setBaseValue(1000);
      this.manaCost.setBaseValue(12F).setUpgradedValue(1.0F, 36.0F);
      this.resilienceGain.setBaseValue(5.0F);
      this.itemAttackerProjectileCanHitWidth = 5.0F;
      this.itemAttackerPredictionDistanceOffset = -20.0F;
      this.canBeUsedForRaids = true;
   }

   public ListGameTooltips getPreEnchantmentTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
      ListGameTooltips tooltips = super.getPreEnchantmentTooltips(item, perspective, blackboard);
      tooltips.add(Localization.translate("itemtooltip", "brimstone_tip_1"));
      tooltips.add(Localization.translate("itemtooltip", "brimstone_tip_2"));
      tooltips.add(Localization.translate("itemtooltip", "brimstone_tip_3"));
      return tooltips;
   }

   public void showAttack(Level level, int x, int y, ItemAttackerMob attackerMob, int attackHeight, InventoryItem item, int animAttack, int seed, GNDItemMap mapContent) {
      if (level.isClient()) {
         SoundManager.playSound(GameResources.magicbolt2, SoundEffect.effect(attackerMob).volume(0.7F).pitch(GameRandom.globalRandom.getFloatBetween(0.9F, 1.0F)));
      }

   }

   public InventoryItem onAttack(Level level, int x, int y, ItemAttackerMob attackerMob, int attackHeight, InventoryItem item, ItemAttackSlot slot, int animAttack, int seed, GNDItemMap mapContent) {
      if (attackerMob.buffManager.hasBuff("manaexhaustion"))
      {
         return item;
      }
      else
      {
         Projectile projectile = ProjectileRegistry.getProjectile("brimstone_projectile", level, attackerMob.x, attackerMob.y, (float)x, (float)y, (float)this.getProjectileVelocity(item, attackerMob), this.getAttackRange(item), this.getAttackDamage(item), this.getKnockback(item, attackerMob), attackerMob);
         projectile.setModifier(new ResilienceOnHitProjectileModifier(this.getResilienceGain(item)));
         projectile.resetUniqueID(new GameRandom((long)seed));
         attackerMob.addAndSendAttackerProjectile(projectile, 20);
         this.consumeMana(attackerMob, item);
         return item;
      }
   }
}
