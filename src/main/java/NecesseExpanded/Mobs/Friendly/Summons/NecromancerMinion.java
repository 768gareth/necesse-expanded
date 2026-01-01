package NecesseExpanded.Mobs.Friendly.Summons;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.MobRegistry;
import necesse.engine.sound.PrimitiveSoundEmitter;
import necesse.engine.sound.SoundEffect;
import necesse.engine.sound.SoundManager;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.Attacker;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.ai.behaviourTree.AINode;
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI;
import necesse.entity.mobs.ai.behaviourTree.trees.PlayerFollowerCollisionChaserAI;
import necesse.entity.mobs.friendly.FriendlyMob;
import necesse.entity.particle.FleshParticle;
import necesse.entity.particle.Particle;
import necesse.gfx.GameResources;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.human.HumanDrawOptions;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class NecromancerMinion extends FriendlyMob
{
    int Lifetime = 0;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public NecromancerMinion()
    {
        super(100);
        this.setSpeed(40.0F);
        this.setFriction(3.0F);
        this.collision = new Rectangle(-10, -7, 20, 14);
        this.hitBox = new Rectangle(-12, -14, 24, 24);
        this.selectBox = new Rectangle(-13, -30, 26, 40);
        this.swimMaskMove = 12;
        this.swimMaskOffset = 0;
        this.swimSinkOffset = 0;
        
        this.ai = new BehaviourTreeAI((Mob)this, (AINode)new PlayerFollowerCollisionChaserAI(1024, new GameDamage(20F), 25, 250, 640, 64));
    }

    public boolean canBeHit(Attacker attacker) {
      return false;
   }

    public void serverTick()
  {
    super.serverTick();
    if (Lifetime >= 160)
    {
        this.setHealth(0);
    }
    else
    {
        Lifetime++;
    }
  }

  protected void addHoverTooltips(ListGameTooltips tooltips, boolean debug) 
  {
      tooltips.add(this.getDisplayName());
  }
  
  public void playHitSound() {
    float pitch = ((Float)GameRandom.globalRandom.getOneOf((Object[])new Float[] { Float.valueOf(0.95F), Float.valueOf(1.0F), Float.valueOf(1.05F) })).floatValue();
    SoundManager.playSound(GameResources.crack, (SoundEffect)SoundEffect.effect((PrimitiveSoundEmitter)this).volume(1.6F).pitch(pitch));
  }
  
  public void playDeathSound() {
      float pitch = ((Float)GameRandom.globalRandom.getOneOf((Object[])new Float[] { Float.valueOf(0.95F), Float.valueOf(1.0F), Float.valueOf(1.05F) })).floatValue();
      SoundManager.playSound(GameResources.crackdeath, (SoundEffect)SoundEffect.effect((PrimitiveSoundEmitter)this).volume(0.3F).pitch(pitch));
    }
  
  public void spawnDeathParticles(float knockbackX, float knockbackY) {
    for (int i = 0; i < 5; i++)
      (getLevel()).entityManager.addParticle((Particle)new FleshParticle(getLevel(), MobRegistry.Textures.babyZombie.body, i, 8, 32, this.x, this.y, 20.0F, knockbackX, knockbackY), Particle.GType.IMPORTANT_COSMETIC); 
  }
  
  public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
    super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
    GameLight light = level.getLightLevel(x / 32, y / 32);
    int drawX = camera.getDrawX(x) - 22 - 10;
    int drawY = camera.getDrawY(y) - 44 - 7;
    int dir = getDir();
    Point sprite = getAnimSprite(x, y, dir);
    drawY += getBobbing(x, y);
    drawY += getLevel().getTile(x / 32, y / 32).getMobSinkingAmount((Mob)this);
    MaskShaderOptions swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
    HumanDrawOptions humanDrawOptions = (new HumanDrawOptions(level, MobRegistry.Textures.babyZombie)).sprite(sprite).dir(dir).mask(swimMask).light(light);
    
    final DrawOptions drawOptions = humanDrawOptions.pos(drawX, drawY);
    list.add(new MobDrawable() 
    {
          public void draw(TickManager tickManager) {
            drawOptions.draw();
          }
      });
  }
}