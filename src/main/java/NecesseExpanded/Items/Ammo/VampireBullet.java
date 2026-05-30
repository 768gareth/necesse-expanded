package NecesseExpanded.Items.Ammo;

import NecesseExpanded.Projectiles.VampireBulletProjectile;
import necesse.engine.localization.Localization;
import necesse.engine.util.GameBlackboard;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.projectile.Projectile;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.bulletItem.BulletItem;

public class VampireBullet extends BulletItem
{
    public VampireBullet() 
    {
        this.damage = 12;
        this.rarity = Rarity.LEGENDARY;
    }

    public boolean overrideProjectile() 
    {
        return true;
    }

    public Projectile getProjectile(float x, float y, float targetX, float targetY, float velocity, int range, GameDamage damage, int knockback, Mob owner) 
    {
        return new VampireBulletProjectile(x, y, targetX, targetY, velocity, range, damage, knockback, owner);
    }

    public ListGameTooltips getTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) 
    {
        ListGameTooltips tooltips = super.getTooltips(item, perspective, blackboard);
        tooltips.add(Localization.translate("itemtooltip", "vampire_bullet_tip"));
        return tooltips;
    }
}
