package NecesseExpanded.Items.Weapons.Melee;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.awt.geom.Point2D;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.localization.Localization;
import necesse.engine.network.gameNetworkData.GNDItemMap;
import necesse.engine.registries.BuffRegistry;
import necesse.engine.util.GameBlackboard;
import necesse.engine.util.GameMath;
import necesse.engine.util.GameRandom;
import necesse.entity.levelEvent.LevelEvent;
import necesse.entity.levelEvent.SwordCleanSliceAttackEvent;
import necesse.entity.levelEvent.mobAbilityLevelEvent.ToolItemMobAbilityEvent;
import necesse.entity.mobs.AttackAnimMob;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.attackHandler.KatanaDashAttackHandler;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.itemAttacker.ItemAttackSlot;
import necesse.entity.mobs.itemAttacker.ItemAttackerMob;
import necesse.entity.trails.Trail;
import necesse.entity.trails.TrailVector;
import necesse.gfx.GameResources;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawables.LevelSortedDrawable;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameSprite;
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

 public void showKatanaAttack(Level level, final AttackAnimMob mob, final int seed, final InventoryItem item) {
    level.entityManager.events.addHidden((LevelEvent)new SwordCleanSliceAttackEvent(mob, seed, 12, this) {
          Trail[] trails = null;
          
          public void tick(float angle, float currentAttackProgress) {
            int attackRange = getAttackRange(item);
            Point2D.Float base = new Point2D.Float(mob.x, mob.y);
            int attackDir = mob.getDir();
            if (attackDir == 0) {
              base.x += 8.0F;
            } else if (attackDir == 2) {
              base.x -= 8.0F;
            } 
            int distancePerTrail = 15;
            boolean strictTrailAngles = item.getGndData().getBoolean("sliceDash");
            if (strictTrailAngles) {
              attackRange -= 20;
              angle = ((Float)getSwingDirection(item, mob).apply(Float.valueOf(currentAttackProgress))).floatValue();
            } else {
              angle = ((Float)getSwingDirection(item, mob).apply(Float.valueOf(currentAttackProgress))).floatValue();
            } 
            Point2D.Float dir = GameMath.getAngleDir(angle);
            int sliceDirOffset = getAnimInverted(item) ? -90 : 90;
            if (attackDir == 3)
              sliceDirOffset = -sliceDirOffset; 
            Point2D.Float sliceDir = GameMath.getAngleDir(angle + sliceDirOffset);
            if (this.trails == null) {
              int fadeTime = strictTrailAngles ? 500 : 250;
              int trailCount = 3;
              this.trails = new Trail[trailCount];
              for (int i = 0; i < this.trails.length; i++) {
                Trail trail = new Trail(getVector(currentAttackProgress, attackRange, i, distancePerTrail, base, dir, sliceDir), this.level, new Color(244, 177, 255), fadeTime) {
                    public void addDrawables(OrderableDrawables list, int startTileY, int endTileY, TickManager tickManager, GameCamera camera) {
                      super.addDrawables(list, startTileY, endTileY, tickManager, camera);
                    }
                    
                    public void addDrawables(List<LevelSortedDrawable> list, int startTileY, int endTileY, TickManager tickManager, GameCamera camera) {
                      super.addDrawables(list, startTileY, endTileY, tickManager, camera);
                    }
                  };
                this.trails[i] = trail;
                trail.removeOnFadeOut = false;
                trail.sprite = new GameSprite(GameResources.chains, 11, 0, 32);
                trail.lightLevel = 100;
                trail.lightHue = 0.0F;
                this.level.entityManager.addTrail(trail);
              } 
            } else {
              for (int i = 0; i < this.trails.length; i++) {
                if (strictTrailAngles) {
                  this.trails[i].addPointIfSameDirection(getVector(currentAttackProgress, attackRange, i, distancePerTrail, base, dir, sliceDir), 0.2F, 20.0F, 50.0F);
                } else {
                  this.trails[i].addPoint(getVector(currentAttackProgress, attackRange, i, distancePerTrail, base, dir, sliceDir));
                } 
              } 
            } 
          }
          
          public TrailVector getVector(float currentAttackProgress, int attackRange, int index, int distancePerTrail, Point2D.Float base, Point2D.Float dir, Point2D.Float sliceDir) {
            float thickness = GameMath.lerp(index / (this.trails.length - 1), 25.0F, 10.0F);
            if (currentAttackProgress < 0.33F) {
              thickness *= 3.0F * currentAttackProgress;
            } else if (currentAttackProgress > 0.66F) {
              thickness *= 3.0F * (1.0F - currentAttackProgress);
            } 
            int distanceOffset = attackRange - index * distancePerTrail;
            GameRandom random = (new GameRandom(seed)).nextSeeded(index + 5);
            float xOffset = random.getFloatOffset(0.0F, 10.0F);
            float yOffset = random.getFloatOffset(0.0F, 10.0F);
            Point2D.Float edgePos = new Point2D.Float(base.x + dir.x * distanceOffset + xOffset, base.y + dir.y * distanceOffset + yOffset);
            return new TrailVector(edgePos.x, edgePos.y, sliceDir.x, sliceDir.y, thickness, 0.0F);
          }
          
          public void onDispose() {
            super.onDispose();
            if (this.trails != null)
              for (Trail trail : this.trails)
                trail.removeOnFadeOut = true;  
          }
        });
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
