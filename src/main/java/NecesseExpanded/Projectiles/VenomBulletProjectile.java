package NecesseExpanded.Projectiles;

import java.awt.Color;

import necesse.engine.network.server.ServerClient;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.projectile.bulletProjectile.BulletProjectile;
import necesse.entity.trails.Trail;
import necesse.gfx.GameResources;
import necesse.gfx.gameTexture.GameSprite;
import necesse.level.maps.LevelObjectHit;

public class VenomBulletProjectile extends BulletProjectile
{
    public VenomBulletProjectile(){}

    public VenomBulletProjectile(float x, float y, float targetX, float targetY, float speed, int distance, GameDamage damage, int knockback, Mob owner) 
    {
        super(x, y, targetX, targetY, speed, distance, damage, knockback, owner);
    }

    public void init() 
    {
        super.init();
    }

    public void onHit(Mob mob, LevelObjectHit object, float x, float y, boolean fromPacket, ServerClient packetSubmitter)
    {
        super.onHit(mob, object, x, y, fromPacket, packetSubmitter);
        if (this.isServer()) 
        {
            if (mob != null) 
            {
                if (GameRandom.globalRandom.getChance(0.10F))
                {
                    mob.buffManager.addBuff(new ActiveBuff("venom_bullet_debuff", mob, 5000, null), true, true);
                }
            }
        }
    }

    public Trail getTrail() 
    {
      Trail trail = new Trail(this, this.getLevel(), new Color(48, 105, 157), 22.0F, 100, this.getHeight());
      trail.sprite = new GameSprite(GameResources.chains, 7, 0, 32);
      return trail;
    }

   protected Color getWallHitColor() 
   {
      return new Color(25, 25, 255);
   }
}
