package NecesseExpanded.Items.Weapons.Melee;

import necesse.engine.localization.Localization;
import necesse.engine.util.GameBlackboard;
import necesse.entity.levelEvent.mobAbilityLevelEvent.ToolItemMobAbilityEvent;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.toolItem.spearToolItem.SpearToolItem;
import necesse.inventory.lootTable.presets.SpearWeaponsLootTable;
import necesse.level.maps.Level;

public class GlacialSpearToolItem extends SpearToolItem
{
    public GlacialSpearToolItem() {
      super(1400, SpearWeaponsLootTable.spearWeapons);
      this.rarity = Rarity.RARE;
      this.attackAnimTime.setBaseValue(400);
      this.attackDamage.setBaseValue(40.0F).setUpgradedValue(1.0F, 50.0F);
      this.attackRange.setBaseValue(140);
      this.knockback.setBaseValue(50);
      this.canBeUsedForRaids = true;
      this.raidTicketsModifier = 0.5F;
      this.useForRaidsOnlyIfObtained = true;
   }

   public ListGameTooltips getPreEnchantmentTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
      ListGameTooltips tooltips = super.getPreEnchantmentTooltips(item, perspective, blackboard);
      tooltips.add(Localization.translate("itemtooltip", "glacial_spear_tip"));
      return tooltips;
   }

   public void hitMob(InventoryItem item, ToolItemMobAbilityEvent event, Level level, Mob target, Mob attacker)
   {
        if (target != null)
        {
            target.buffManager.addBuff(new ActiveBuff("frostburn", target, 5000, attacker), true);
        }
        if (event.totalHits == 0 && target.canGiveResilience(attacker)) {
         attacker.addResilience(this.getResilienceGain(item));
         }
        target.isServerHit(this.getAttackDamage(item), target.x - attacker.x, target.y - attacker.y, (float)this.getKnockback(item, attacker), this.getToolItemEventAttacker(item, event, level, target, attacker));
   }
}
