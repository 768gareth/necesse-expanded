package NecesseExpanded.Projectiles;

import java.awt.Color;

import necesse.engine.network.server.ServerClient;
import necesse.engine.util.GameRandom;
import necesse.entity.levelEvent.LevelEvent;
import necesse.entity.levelEvent.mobAbilityLevelEvent.MobHealthChangeEvent;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.Mob;
import necesse.entity.projectile.bulletProjectile.BulletProjectile;
import necesse.entity.trails.Trail;
import necesse.gfx.GameResources;
import necesse.gfx.gameTexture.GameSprite;
import necesse.level.maps.LevelObjectHit;

public class VampireBulletProjectile extends BulletProjectile
{
    Mob ProjectileOwner;

    public VampireBulletProjectile(){}

    public VampireBulletProjectile(float x, float y, float targetX, float targetY, float speed, int distance, GameDamage damage, int knockback, Mob owner) 
    {
        super(x, y, targetX, targetY, speed, distance, damage, knockback, owner);
        ProjectileOwner = owner;
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
                    int TargetHealthChange = ProjectileOwner.getMaxHealth() / 100;
                    ProjectileOwner.getLevel().entityManager.events.add((LevelEvent) new MobHealthChangeEvent(ProjectileOwner, TargetHealthChange));
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
      return new Color(225, 25, 25);
   }
}
