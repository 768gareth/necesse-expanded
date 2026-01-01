package NecesseExpanded.Events.Utils;

import necesse.engine.sound.SoundEffect;
import necesse.engine.sound.SoundManager;
import necesse.entity.levelEvent.explosionEvent.ExplosionEvent;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.gfx.GameResources;

public class BrimstoneExplosionEvent extends ExplosionEvent
{
   public BrimstoneExplosionEvent() {
      this(0.0F, 0.0F, 40, new GameDamage(80.0F), true, 0.0F, (Mob)null);
    }
    
    public BrimstoneExplosionEvent(float x, float y, int range, GameDamage damage, boolean destructive, float toolTier, Mob owner) {
      super(x, y, range, damage, destructive, toolTier, owner);
    }
    
    public BrimstoneExplosionEvent(float x, float y, int range, GameDamage damage, boolean destroysObjects, boolean destroysTiles, float toolTier, Mob owner) {
      super(x, y, range, damage, destroysObjects, destroysTiles, toolTier, owner);
    }
    
    protected GameDamage getTotalObjectDamage(float mod) {
      float objectMod = (float)Math.pow(mod, 0.699999988079071D) * 10.0F;
      return super.getTotalObjectDamage(mod).modDamage(objectMod);
    }
    
    protected void playExplosionEffects() {
      SoundManager.playSound(GameResources.explosionHeavy, (SoundEffect)SoundEffect.effect(this.x, this.y).volume(2.5F).pitch(1.5F));
      this.level.getClient().startCameraShake(this.x, this.y, 300, 40, 3.0F, 3.0F, true);
    }

    protected void onMobWasHit(Mob mob, float distance) {
      float mod = this.getDistanceMod(distance);
      GameDamage damage = this.getTotalMobDamage(mod);
      float knockback = (float)this.knockback * mod;
      mob.isServerHit(damage, (float)mob.getX() - this.x, (float)mob.getY() - this.y, knockback, this);
      mob.buffManager.addBuff(new ActiveBuff("ablaze", mob, 10000, this), true);
   }
}
