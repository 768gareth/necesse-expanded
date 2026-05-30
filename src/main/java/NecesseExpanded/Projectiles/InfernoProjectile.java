package NecesseExpanded.Projectiles;

import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.projectile.SparklerProjectile;
import necesse.level.maps.Level;
import necesse.level.maps.LevelObjectHit;

public class InfernoProjectile extends SparklerProjectile
{
    public InfernoProjectile()
    {
      super();
    }
    
    public InfernoProjectile(Level level, float x, float y, float targetX, float targetY, int distance, GameDamage damage, Mob owner)
    {
        super(level, x, y, targetX, targetY, distance, damage, owner);
    }

    public void doHitLogic(Mob mob, LevelObjectHit object, float x, float y) 
    {
      super.doHitLogic(mob, object, x, y);
      if (this.isServer() && mob != null) {
         ActiveBuff ab = new ActiveBuff("ablaze", mob, 5.0F, this.getOwner());
         mob.addBuff(ab, true);
      }
   }
}
