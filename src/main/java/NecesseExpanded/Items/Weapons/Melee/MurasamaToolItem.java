package NecesseExpanded.Items.Weapons.Melee;

import java.awt.Color;
import java.util.HashMap;

import necesse.engine.localization.Localization;
import necesse.engine.network.gameNetworkData.GNDItemMap;
import necesse.engine.registries.BuffRegistry;
import necesse.engine.util.GameBlackboard;
import necesse.engine.util.GameMath;
import necesse.entity.levelEvent.mobAbilityLevelEvent.ToolItemMobAbilityEvent;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.attackHandler.KatanaDashAttackHandler;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.itemAttacker.ItemAttackSlot;
import necesse.entity.mobs.itemAttacker.ItemAttackerMob;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.toolItem.swordToolItem.KatanaToolItem;
import necesse.inventory.lootTable.presets.CloseRangeWeaponsLootTable;
import necesse.level.maps.Level;

public class MurasamaToolItem extends KatanaToolItem
{
    public MurasamaToolItem()
    {
        super(400, CloseRangeWeaponsLootTable.closeRangeWeapons);
        this.rarity = Rarity.LEGENDARY;
        this.attackAnimTime.setBaseValue(200);
        this.attackDamage.setBaseValue(50.0F).setUpgradedValue(1.0F, 100.0F);
        this.attackRange.setBaseValue(100);
        this.knockback.setBaseValue(55);
        this.resilienceGain.setBaseValue(1.0F);
        this.maxDashStacks.setBaseValue(10);
        this.dashRange.setBaseValue(350);
        this.attackXOffset = 4;
        this.attackYOffset = 4;
        this.canBeUsedForRaids = true;
        this.raidTicketsModifier = 0.2F;
        this.useForRaidsOnlyIfObtained = true;
    }

    public ListGameTooltips getPreEnchantmentTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
      ListGameTooltips tooltips = new ListGameTooltips();
      ItemAttackerMob equippedMob = (ItemAttackerMob)blackboard.get(ItemAttackerMob.class, "equippedMob", perspective);
      if (equippedMob == null) {
         equippedMob = (ItemAttackerMob)blackboard.get(ItemAttackerMob.class, "perspective", perspective);
      }

      if (equippedMob == null) {
         equippedMob = perspective;
      }

      this.addStatTooltips(tooltips, item, (InventoryItem)blackboard.get(InventoryItem.class, "compareItem"), blackboard.getBoolean("showDifference"), blackboard.getBoolean("forceAdd"), (ItemAttackerMob)equippedMob);
      tooltips.add(Localization.translate("itemtooltip", "murasama_tip_1", "stacks", this.maxDashStacks.getValue(this.getUpgradeTier(item))), 400);
      tooltips.add(Localization.translate("itemtooltip", "murasama_tip_2"), 400);
      return tooltips;
   }

   public void hitMob(InventoryItem item, ToolItemMobAbilityEvent event, Level level, Mob target, Mob attacker) {
    if (event.totalHits == 0 && target.canGiveResilience(attacker)) {
       attacker.addResilience(this.getResilienceGain(item));
    }
    target.isServerHit(this.getAttackDamage(item), target.x - attacker.x, target.y - attacker.y, (float)this.getKnockback(item, attacker), attacker);
    if (target.hasDied() == true)
    {
        attacker.buffManager.addBuff(new ActiveBuff("murasama_revenge_buff", attacker, 8f, attacker), true);
    }
 }

  

  public InventoryItem onAttack(Level level, int x, int y, ItemAttackerMob attackerMob, int attackHeight, InventoryItem item, ItemAttackSlot slot, int animAttack, int seed, GNDItemMap mapContent) {
      if (!attackerMob.isPlayer && this.canDash(attackerMob)) {
         float stacksPercent = (float)attackerMob.buffManager.getStacks(BuffRegistry.KATANA_DASH_STACKS) / (float)this.maxDashStacks.getValue(this.getUpgradeTier(item));
         float animModifier = (float)GameMath.lerp(Math.min(Math.pow((double)(stacksPercent * 2.0F), 0.5), 1.0), 8L, 1L);
         int animTime = (int)((float)this.getAttackAnimTime(item, attackerMob) * animModifier);
         mapContent.setBoolean("chargeUp", true);
         attackerMob.startAttackHandler(new KatanaDashAttackHandler(attackerMob, slot, item, this, animTime, new Color(172, 0, 0), seed, x, y));
         return item;
      } else {
         boolean isSlash = item.getGndData().getBoolean("slash");
         item.getGndData().setBoolean("slash", !isSlash);
         item.getGndData().setBoolean("chargeUp", false);
         item.getGndData().setBoolean("sliceDash", false);
         if (animAttack == 0) {
            int animTime = this.getAttackAnimTime(item, attackerMob);
            @SuppressWarnings({ "rawtypes", "unchecked" })
            ToolItemMobAbilityEvent event = new ToolItemMobAbilityEvent(attackerMob, seed, item, x - attackerMob.getX(), y - attackerMob.getY() + attackHeight, animTime, animTime, isSlash ? new HashMap() : null);
            attackerMob.addAndSendAttackerLevelEvent(event);
         }

         return item;
      }
   }
}
