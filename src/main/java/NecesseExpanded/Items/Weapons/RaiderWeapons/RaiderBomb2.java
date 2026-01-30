package NecesseExpanded.Utils.RaiderWeapons;

import java.awt.Point;

import NecesseExpanded.Projectiles.RaiderBombProjectile2;
import necesse.engine.localization.Localization;
import necesse.engine.localization.message.GameMessage;
import necesse.engine.localization.message.LocalMessage;
import necesse.engine.network.gameNetworkData.GNDItemMap;
import necesse.engine.util.GameBlackboard;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.itemAttacker.ItemAttackSlot;
import necesse.entity.mobs.itemAttacker.ItemAttackerMob;
import necesse.entity.projectile.IronBombProjectile;
import necesse.entity.projectile.modifiers.ResilienceOnHitProjectileModifier;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.toolItem.projectileToolItem.throwToolItem.SettlerIgnoredThrowToolItem;
import necesse.level.maps.Level;

public class RaiderBomb2 extends SettlerIgnoredThrowToolItem
{
    public RaiderBomb2() {
      this.stackSize = 100;
      this.attackAnimTime.setBaseValue(1000);
      this.attackRange.setBaseValue(600);
      this.attackDamage.setBaseValue(0.0F);
      this.velocity.setBaseValue(100);
      this.rarity = Rarity.COMMON;
      this.resilienceGain.setBaseValue(0.0F);
   }

   public GameMessage getItemAttackerCanUseError(ItemAttackerMob mob, InventoryItem item) {
      return new LocalMessage("ui", "settlercantuseitem");
   }

   public ListGameTooltips getPreEnchantmentTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
      ListGameTooltips tooltips = super.getPreEnchantmentTooltips(item, perspective, blackboard);
      tooltips.add(Localization.translate("itemtooltip", "destructivetip"));
      return tooltips;
   }

   public Point getControllerAttackLevelPos(Level level, float aimDirX, float aimDirY, PlayerMob player, InventoryItem item) {
      int range = this.getAttackRange(item);
      return new Point((int)(player.x + aimDirX * (float)range), (int)(player.y + aimDirY * (float)range));
   }

   public InventoryItem onAttack(Level level, int x, int y, ItemAttackerMob attackerMob, int attackHeight, InventoryItem item, ItemAttackSlot slot, int animAttack, int seed, GNDItemMap mapContent) {
      GameRandom random = new GameRandom((long)seed);
      Point targetPos = this.controlledRangePosition(random, attackerMob, x, y, item, 0, 40);
      int newRange = (int)attackerMob.getDistance((float)targetPos.x, (float)targetPos.y);
      IronBombProjectile projectile = new RaiderBombProjectile2(attackerMob.x, attackerMob.y, (float)targetPos.x, (float)targetPos.y, this.getThrowingVelocity(item, attackerMob), newRange, new GameDamage(20F), attackerMob);
      projectile.setModifier(new ResilienceOnHitProjectileModifier(this.getResilienceGain(item)));
      projectile.setLevel(level);
      projectile.resetUniqueID(random);
      attackerMob.addAndSendAttackerProjectile(projectile);
      item.setAmount(item.getAmount() - 1);
      return item;
   }
}
