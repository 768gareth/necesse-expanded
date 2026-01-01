package NecesseExpanded.Utils.RaiderWeapons;

import necesse.engine.network.gameNetworkData.GNDItemMap;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.itemAttacker.ItemAttackSlot;
import necesse.entity.mobs.itemAttacker.ItemAttackerMob;
import necesse.entity.projectile.Projectile;
import necesse.entity.projectile.SlimeBoltProjectile;
import necesse.entity.projectile.modifiers.ResilienceOnHitProjectileModifier;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.toolItem.projectileToolItem.magicProjectileToolItem.MagicProjectileToolItem;
import necesse.level.maps.Level;

public class RaiderSlimeStaff extends MagicProjectileToolItem
{
    public RaiderSlimeStaff()
    {
        super(0, null);
        this.attackAnimTime.setBaseValue(800);
    }

    public InventoryItem onAttack(Level level, int x, int y, ItemAttackerMob attackerMob, int attackHeight, InventoryItem item, ItemAttackSlot slot, int animAttack, int seed, GNDItemMap mapContent) {
      GameRandom random = new GameRandom((long)seed);

      for(int i = -1; i <= 1; ++i) {
         Projectile projectile = new SlimeBoltProjectile(level, attackerMob.x, attackerMob.y, (float)x, (float)y, (float)this.getProjectileVelocity(item, attackerMob), this.getAttackRange(item), this.getAttackDamage(item), attackerMob);
         projectile.setModifier(new ResilienceOnHitProjectileModifier(this.getResilienceGain(item)));
         projectile.resetUniqueID(random);
         attackerMob.addAndSendAttackerProjectile(projectile, 20, (float)(10 * i));
      }

      this.consumeMana(attackerMob, item);
      return item;
   }
}
