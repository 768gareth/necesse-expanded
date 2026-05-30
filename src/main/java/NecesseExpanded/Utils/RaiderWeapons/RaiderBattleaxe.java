package NecesseExpanded.Utils.RaiderWeapons;

import necesse.engine.network.gameNetworkData.GNDItemMap;
import necesse.engine.sound.SoundSettings;
import necesse.entity.mobs.attackHandler.AttackHandler;
import necesse.entity.mobs.attackHandler.BrutesBattleaxeAttackHandler;
import necesse.entity.mobs.itemAttacker.ItemAttackSlot;
import necesse.entity.mobs.itemAttacker.ItemAttackerMob;
import necesse.gfx.GameResources;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.toolItem.swordToolItem.greatswordToolItem.GreatswordToolItem;
import necesse.level.maps.Level;

// Reimplementation of the Brute's Battleaxe for raiders, for better accuracy.
public class RaiderBattleaxe extends GreatswordToolItem 
{
    public RaiderBattleaxe()
    {
        super(0, null, getThreeChargeLevels(500, 600, 700));
        this.attackDamage.setBaseValue(84.0F).setUpgradedValue(1.0F, 165.66672F);
        this.attackRange.setBaseValue(70);
        this.knockback.setBaseValue(150);
        this.attackXOffset = 12;
        this.attackYOffset = 12;
    }
    public InventoryItem onAttack(Level level, int x, int y, ItemAttackerMob attackerMob, int attackHeight,
            InventoryItem item, ItemAttackSlot slot, int animAttack, int seed, GNDItemMap mapContent) {
        attackerMob.startAttackHandler((AttackHandler) new BrutesBattleaxeAttackHandler(attackerMob, level, item,
                this, seed, x, y, false, slot, this.chargeLevels));
        return item;
    }

    protected SoundSettings getGreatswordSwingSound1() {
      return (new SoundSettings(GameResources.brutesBattleAxe1)).volume(0.3F);
   }

   protected SoundSettings getGreatswordSwingSound2() {
      return (new SoundSettings(GameResources.brutesBattleAxe2)).volume(0.3F);
   }

   protected SoundSettings getGreatswordSwingSound3() {
      return (new SoundSettings(GameResources.brutesBattleAxe3)).volume(0.5F);
   }
}
