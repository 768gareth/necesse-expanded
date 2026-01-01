package NecesseExpanded.Items.Weapons.Melee;

import necesse.engine.localization.Localization;
import necesse.engine.util.GameBlackboard;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.toolItem.swordToolItem.SwordToolItem;
import necesse.inventory.lootTable.presets.CloseRangeWeaponsLootTable;
import necesse.level.maps.incursion.IncursionData;

public class JuggernautAxeToolItem extends SwordToolItem
{
    public JuggernautAxeToolItem() 
    {
        super(250, CloseRangeWeaponsLootTable.closeRangeWeapons);
        this.rarity = Rarity.RARE;
        this.attackAnimTime.setBaseValue(450);
        this.attackDamage.setBaseValue(50.0F).setUpgradedValue(1.0F, 90.0F);
        this.attackRange.setBaseValue(80);
        this.knockback.setBaseValue(150);
        this.canBeUsedForRaids = true;
        this.maxRaidTier = IncursionData.ITEM_TIER_UPGRADE_CAP;
    }

    public ListGameTooltips getPreEnchantmentTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
      ListGameTooltips tooltips = super.getPreEnchantmentTooltips(item, perspective, blackboard);
      tooltips.add(Localization.translate("itemtooltip", "juggernaut_axe_tooltip"), 400);
      return tooltips;
   }
}
