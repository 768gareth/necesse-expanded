package NecesseExpanded.Mobs.Friendly.Husbandry;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.MobRegistry;
import necesse.engine.sound.SoundSettings;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.ai.behaviourTree.AINode;
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI;
import necesse.entity.mobs.ai.behaviourTree.util.AIMover;
import necesse.entity.mobs.friendly.ChickenMob.ChickenAI;
import necesse.entity.mobs.friendly.HusbandryMob;
import necesse.entity.particle.FleshParticle;
import necesse.entity.particle.Particle;
import necesse.gfx.GameResources;
import necesse.gfx.HumanGender;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.InventoryItem;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class HoneySlimeHusbandryMob extends HusbandryMob 
{
    public static GameTexture Texture;
    
    public HoneySlimeHusbandryMob() 
    {
      super(250);
      setSpeed(25.0F);
      setFriction(3.0F);
      this.collision = new Rectangle(-12, -9, 24, 18);
      this.hitBox = new Rectangle(-16, -12, 32, 24);
      this.selectBox = new Rectangle(-18, -30, 36, 36);
      this.swimMaskMove = 8;
      this.swimMaskOffset = 0;
      this.swimSinkOffset = 0;
      this.timeToGrowUp = 0;
      this.canDespawn = true;
    }

    public InventoryItem onFed(InventoryItem item) 
    {
      this.hunger += this.defaultHungerGainPerFeed;
      this.sendMovementPacket(false);
      item.setAmount(item.getAmount() - 1);
      this.getLevel().entityManager.pickups.add(new InventoryItem("honey_plort").getPickupEntity(this.getLevel(), this.x, this.y));
      return item;
    }

    public boolean canFeed(InventoryItem item) 
    {
      return 
      (
        !isOnFeedCooldown() 
        && 
        (
          (
            item.item.getStringID() == "blueberry" 
            || item.item.getStringID() == "raspberry" 
            || item.item.getStringID() == "blackberry"
            || item.item.getStringID() == "strawberry"
          )
        )
      );
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void init() 
    {
      super.init();
      this.ai = new BehaviourTreeAI((Mob)this, (AINode)new ChickenAI<>(30000), new AIMover());
    }
    
    protected SoundSettings getAmbientSound() {
      return (new SoundSettings(GameResources.slimeSplash1));
    }
    
    protected SoundSettings getHurtSound() {
      return new SoundSettings(GameResources.slimeSplash3);
    }
    
    protected SoundSettings getDeathSound() {
      return (new SoundSettings(GameResources.slimeSplash4));
    }
    
    public void spawnDeathParticles(float knockbackX, float knockbackY) 
    {
      for (int i = 0; i < 4; i++)
        (getLevel()).entityManager.addParticle((Particle)new FleshParticle(getLevel(), Texture, GameRandom.globalRandom.nextInt(5), 8, 32, this.x, this.y, 10.0F, knockbackX, knockbackY), Particle.GType.IMPORTANT_COSMETIC); 
    }
    
    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
      final MaskShaderOptions swimMask;
      super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
      GameLight light = level.getLightLevel(getTileCoordinate(x), getTileCoordinate(y));
      int drawX = camera.getDrawX(x) - 22 - 10;
      int drawY = camera.getDrawY(y) - 44 - 7;
      int dir = getDir();
      Point sprite = getAnimSprite(x, y, dir);
      drawY += getBobbing(x, y);
      TextureDrawOptionsEnd textureDrawOptionsEnd1 = MobRegistry.Textures.swampSlime_shadow.initDraw().sprite(0, dir, 64).light(light).pos(drawX, drawY);
      tileList.add(tm -> textureDrawOptionsEnd1.draw());
      drawY += level.getTile(getTileCoordinate(x), getTileCoordinate(y)).getMobSinkingAmount((Mob)this);
      swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
      final TextureDrawOptionsEnd options = Texture.initDraw().sprite(sprite.x, sprite.y, 64).light(light).addMaskShader(swimMask).pos(drawX, drawY);
      list.add(new MobDrawable() {
            public void draw(TickManager tickManager) {
              swimMask.use();
              options.draw();
              swimMask.stop();
            }
          });
    }
    
    protected int getRockSpeed() 
    {
      return 20;
    }
    
    public HumanGender getGender() 
    {
      return HumanGender.NEUTRAL;
    }
}