package NecesseExpanded.Projectiles;

import java.util.List;

import NecesseExpanded.Events.Utils.BrimstoneExplosionEvent;

import java.awt.Color;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.network.server.ServerClient;
import necesse.entity.Entity;
import necesse.entity.levelEvent.LevelEvent;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.projectile.Projectile;
import necesse.entity.trails.Trail;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.EntityDrawable;
import necesse.gfx.drawables.LevelSortedDrawable;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.level.maps.Level;
import necesse.level.maps.LevelObjectHit;
import necesse.level.maps.light.GameLight;

public class BrimstoneProjectile extends Projectile
{
    public BrimstoneProjectile() 
    {
        super();
    }

    public void init() {
    super.init();
    this.givesLight = true;
    this.height = 18.0F;
    this.piercing = 0;
  }
  
  protected int getExtraSpinningParticles() {
    return super.getExtraSpinningParticles() + 1;
  }
  
  public Color getParticleColor() {
    return new Color(207, 21, 21);
  }
  
  public Trail getTrail() {
    return new Trail(this, getLevel(), new Color(207, 21, 21), 6.0F, 500, 18.0F);
  }

  public void onHit(Mob mob, LevelObjectHit object, float x, float y, boolean fromPacket, ServerClient packetSubmitter)
    {
        super.onHit(mob, object, x, y, fromPacket, packetSubmitter);
        if (this.isServer()) 
        {
            if (mob != null) 
            {
                mob.buffManager.addBuff(new ActiveBuff("ablaze", mob, 10000, null), true, true);
            }
        }
        BrimstoneExplosionEvent Event = new BrimstoneExplosionEvent(x, y, 150, getDamage(), false, 0, null);
        this.getLevel().entityManager.events.add((LevelEvent)Event);
    }
  
  public void addDrawables(List<LevelSortedDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, OrderableDrawables overlayList, Level level, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
    if (removed())
      return; 
    GameLight light = level.getLightLevel((Entity)this);
    int drawX = camera.getDrawX(this.x) - this.texture.getWidth() / 2;
    int drawY = camera.getDrawY(this.y);
    final TextureDrawOptionsEnd options = this.texture.initDraw().light(light).rotate(getAngle(), this.texture.getWidth() / 2, 0).pos(drawX, drawY - (int)getHeight());
    list.add(new EntityDrawable((Entity)this) {
          public void draw(TickManager tickManager) {
            options.draw();
          }
        });
    addShadowDrawables(tileList, drawX, drawY, light, getAngle(), 0);
  }
}
