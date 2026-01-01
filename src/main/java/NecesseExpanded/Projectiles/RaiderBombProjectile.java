package NecesseExpanded.Projectiles;

import necesse.entity.levelEvent.explosionEvent.BombExplosionEvent;
import necesse.entity.levelEvent.explosionEvent.ExplosionEvent;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.Mob;
import necesse.entity.projectile.IronBombProjectile;

public class RaiderBombProjectile extends IronBombProjectile
{
   public RaiderBombProjectile() {}
    public RaiderBombProjectile(float x, float y, float targetX, float targetY, int speed, int distance, GameDamage damage, Mob owner) {
      super(x, y, targetX, targetY, speed, distance, damage, owner);
   }

    public ExplosionEvent getExplosionEvent(float x, float y) {
      return new BombExplosionEvent(x, y, 80, new GameDamage(80.0F, 120.0F), false, false, 0, this.getOwner());
   }
}
