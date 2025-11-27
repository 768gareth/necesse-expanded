package NecesseExpanded.Mobs.Friendly.Husbandry;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

import necesse.engine.GameTileRange;
import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.MobRegistry;
import necesse.engine.sound.PrimitiveSoundEmitter;
import necesse.engine.sound.SoundEffect;
import necesse.engine.sound.SoundManager;
import necesse.engine.sound.SoundSettings;
import necesse.engine.util.GameMath;
import necesse.engine.util.GameRandom;
import necesse.engine.util.GameUtils;
import necesse.entity.Entity;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.ability.MobAbility;
import necesse.entity.mobs.ai.behaviourTree.AINode;
import necesse.entity.mobs.ai.behaviourTree.AINodeResult;
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI;
import necesse.entity.mobs.ai.behaviourTree.Blackboard;
import necesse.entity.mobs.ai.behaviourTree.decorators.MoveTaskAINode;
import necesse.entity.mobs.ai.behaviourTree.event.AIEvent;
import necesse.entity.mobs.ai.behaviourTree.trees.HusbandryImpregnateWandererAI;
import necesse.entity.mobs.ai.behaviourTree.util.AIMover;
import necesse.entity.mobs.friendly.HusbandryMob;
import necesse.entity.mobs.misc.MobProcessObjectHandler;
import necesse.entity.mobs.misc.StartMobProcessObjectMobAbility;
import necesse.entity.particle.FleshParticle;
import necesse.entity.particle.Particle;
import necesse.entity.pickup.PickupEntity;
import necesse.gfx.GameResources;
import necesse.gfx.HumanGender;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameTexture;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootTable;
import necesse.level.gameObject.ProcessObjectHandler;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;
import necesse.level.maps.multiTile.MultiTile;

public class HoneySlimeHusbandryMob extends HusbandryMob 
{
  public static GameTexture Texture;

  public static GameTileRange LAY_PLORT_TILE_RANGE = new GameTileRange(15, new Point[0]);

  public static int LAY_PLORT_COOLDOWN_SECONDS_MIN = 600;

  public long nextPlortLayingTime;

  public boolean nextPlortIsFertilized;

  protected MobProcessObjectHandler layPlortHandler = new MobProcessObjectHandler((Mob) this) {
    public void tickInProgress() {
      super.tickInProgress();
      if (!HoneySlimeHusbandryMob.this.isServer() && GameRandom.globalRandom.nextInt(20) == 0)
        HoneySlimeHusbandryMob.this.spawnLayPlortParticles();
    }

    public void onCompleted() {
      super.onCompleted();
      if (!HoneySlimeHusbandryMob.this.isClient() &&
          this.target != null && this.target.canProcess()) {
        this.target.process();
        HoneySlimeHusbandryMob.this.refreshNextPlortLayingTime();
        HoneySlimeHusbandryMob.this.ai.blackboard.submitEvent("wanderNow", new AIEvent());
      }
      if (!HoneySlimeHusbandryMob.this.isServer()) {
        SoundManager.playSound(GameResources.pop, (SoundEffect) SoundEffect
            .effect((PrimitiveSoundEmitter) HoneySlimeHusbandryMob.this).volume(0.3F).pitch(0.7F));
        for (int i = 0; i < 5; i++)
          HoneySlimeHusbandryMob.this.spawnLayPlortParticles();
      }
    }
  };

  public StartMobProcessObjectMobAbility layPlortAbility;

  public HoneySlimeHusbandryMob() {
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
    this.layPlortAbility = (StartMobProcessObjectMobAbility)registerAbility((MobAbility)new StartMobProcessObjectMobAbility(this.layPlortHandler));
  }

  public void clientTick() {
    super.clientTick();
    this.layPlortHandler.tick();
  }

  public void serverTick() {
    super.serverTick();
    this.layPlortHandler.tick();
    if (HoneySlimeHusbandryMob.this.hunger > 0f)
    {
      this.canDespawn = false;
    }
  }

  public LootTable getLootTable() 
  {
    return new LootTable();
  }

  public void spawnLayPlortParticles() {
    if (this.layPlortHandler.isTargetOnTile) {
      spawnPlortParticles(getLevel(), this.layPlortHandler.tileX, this.layPlortHandler.tileY);
    } else {
      spawnPlortParticles(getLevel(), this.x + GameRandom.globalRandom
          .getIntBetween(-10, 10), this.y
              + GameRandom.globalRandom
                  .getIntBetween(-5, 5));
    }
  }

  public static void spawnPlortParticles(Level level, int tileX, int tileY) {
    MultiTile multiTile = level.getObject(tileX, tileY).getMultiTile(level, 0, tileX, tileY);
    Point offset = new Point(multiTile.getCenterXOffset() * 16, multiTile.getCenterYOffset() * 16);
    spawnPlortParticles(level, tileX * 32.0F + offset.x + GameRandom.globalRandom
        .nextInt(32), tileY * 32.0F + offset.y + 32.0F);
  }

  public static void spawnPlortParticles(Level level, float posX, float posY) {
    int startHeight = 8 + GameRandom.globalRandom.nextInt(24);
    level.entityManager
        .addParticle(posX, posY, Particle.GType.COSMETIC)

        .color(new Color(255, 239, 157, 255))
        .heightMoves(startHeight, (startHeight + 40))
        .lifeTime(2000);
  }

  public InventoryItem onFed(InventoryItem item) {
    this.hunger += this.defaultHungerGainPerFeed;
    this.sendMovementPacket(false);
    item.setAmount(item.getAmount() - 1);
    return item;
  }

  public boolean canFeed(InventoryItem item) {
    return (!isOnFeedCooldown()
        &&
        ((item.item.getStringID() == "blueberry"
            || item.item.getStringID() == "raspberry"
            || item.item.getStringID() == "blackberry"
            || item.item.getStringID() == "strawberry")));
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public void init() {
    super.init();
    this.ai = new BehaviourTreeAI((Mob) this, (AINode) new HoneySlimeAI<>(30000), new AIMover());
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

  public void spawnDeathParticles(float knockbackX, float knockbackY) {
    for (int i = 0; i < 4; i++)
      (getLevel()).entityManager.addParticle((Particle) new FleshParticle(getLevel(), Texture,
          GameRandom.globalRandom.nextInt(5), 8, 32, this.x, this.y, 10.0F, knockbackX, knockbackY),
          Particle.GType.IMPORTANT_COSMETIC);
  }

  public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level,
      int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
    final MaskShaderOptions swimMask;
    super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
    GameLight light = level.getLightLevel(getTileCoordinate(x), getTileCoordinate(y));
    int drawX = camera.getDrawX(x) - 22 - 10;
    int drawY = camera.getDrawY(y) - 44 - 7;
    int dir = getDir();
    Point sprite = getAnimSprite(x, y, dir);
    drawY += getBobbing(x, y);
    TextureDrawOptionsEnd textureDrawOptionsEnd1 = MobRegistry.Textures.swampSlime_shadow.initDraw().sprite(0, dir, 64)
        .light(light).pos(drawX, drawY);
    tileList.add(tm -> textureDrawOptionsEnd1.draw());
    drawY += level.getTile(getTileCoordinate(x), getTileCoordinate(y)).getMobSinkingAmount((Mob) this);
    swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
    final TextureDrawOptionsEnd options = Texture.initDraw().sprite(sprite.x, sprite.y, 64).light(light)
        .addMaskShader(swimMask).pos(drawX, drawY);
    list.add(new MobDrawable() {
      public void draw(TickManager tickManager) {
        swimMask.use();
        options.draw();
        swimMask.stop();
      }
    });
  }

  protected int getRockSpeed() {
    return 20;
  }

  public HumanGender getGender() {
    return HumanGender.NEUTRAL;
  }

  public boolean isLayingPlort() {
    return this.layPlortHandler.isInProgress();
  }

  public boolean canLayPlort() 
  {
    return (isGrown() && this.nextPlortLayingTime <= getWorldTime() && !isLayingPlort());
  }

  public void refreshNextPlortLayingTime() 
  {
    this.nextPlortLayingTime = getWorldTime() + LAY_PLORT_COOLDOWN_SECONDS_MIN * 1000L;
  }

  protected void addDebugTooltips(ListGameTooltips tooltips) {
    super.addDebugTooltips(tooltips);
    tooltips.add("Next Plort in: " + GameUtils.getTimeStringMillis(this.nextPlortLayingTime - getWorldTime()));
  }

  public static class HoneySlimeAI<T extends HoneySlimeHusbandryMob> extends HusbandryImpregnateWandererAI<T> {
    public final HoneySlimeHusbandryMob.HoneySlimeLayPlortAINode<T> PlortLayingNode;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public HoneySlimeAI(int wanderFrequency) {
      super(wanderFrequency);
      addChildFirst((AINode) (this.PlortLayingNode = new HoneySlimeHusbandryMob.HoneySlimeLayPlortAINode<>()));
    }
  }

  public static class HoneySlimeLayPlortAINode<T extends HoneySlimeHusbandryMob> extends MoveTaskAINode<T> {
    public ProcessObjectHandler target;

    protected void onRootSet(AINode<T> root, T mob, Blackboard<T> blackboard) {
    }

    public void init(T mob, Blackboard<T> blackboard) {
    }

    public AINodeResult tick(T mob, Blackboard<T> blackboard) {
      if (this.target != null && this.target.reservable != null)
        this.target.reservable.reserve((Entity) mob);
      return super.tick((T) mob, blackboard);
    }

    @SuppressWarnings("rawtypes")
    public AINodeResult tickNode(T mob, Blackboard<T> blackboard) {
      if (blackboard.mover.isCurrentlyMovingFor((AINode) this))
        return AINodeResult.SUCCESS;
      if (this.target == null && mob.canLayPlort()) {
        List<HusbandryMob> nearbyMobs = mob.getNearbyHusbandryMobs();
        final boolean instant = (mob.getRopeMob() != null || mob.isBeingInteractedWith());
        if (instant || !((HoneySlimeHusbandryMob) mob).nextPlortIsFertilized
            || nearbyMobs.size() > HusbandryMob.maxCloseMobsToBirth) {
          this.target = new ProcessObjectHandler(mob.getTileX(), mob.getTileY(), null) {
            public boolean canProcess() {
              return true;
            }

            public void process() {
              InventoryItem product = new InventoryItem("honey_plort");
              Level level = ((HoneySlimeHusbandryMob) HoneySlimeHusbandryMob.HoneySlimeLayPlortAINode.this.mob())
                  .getLevel();
              level.entityManager.pickups.add((PickupEntity) product.getPickupEntity(level,
                  ((HoneySlimeHusbandryMob) HoneySlimeHusbandryMob.HoneySlimeLayPlortAINode.this.mob()).x,
                  ((HoneySlimeHusbandryMob) HoneySlimeHusbandryMob.HoneySlimeLayPlortAINode.this.mob()).y));
            }

            public boolean isValid() {
              return true;
            }

            public int getTimeItTakesInMilliseconds() {
              return instant ? 0 : 4000;
            }
          };
        } else 
          {
          ArrayList<ProcessObjectHandler> validTiles = new ArrayList<>();
          if (!validTiles.isEmpty()) {
            this.target = (ProcessObjectHandler) GameRandom.globalRandom.getOneOf(validTiles);
            if (this.target.reservable != null)
              this.target.reservable.reserve((Entity) mob);
            return moveToTileTask(this.target.tileX, this.target.tileY, null,
                path -> path.moveIfWithin(-1, 0, null) ? AINodeResult.SUCCESS : AINodeResult.FAILURE);
          }
          this.target = new ProcessObjectHandler(mob.getTileX(), mob.getTileY(), null) {
            public boolean canProcess() {
              return true;
            }

            public void process() {
              InventoryItem product = new InventoryItem("honey_plort");
              Level level = ((HoneySlimeHusbandryMob) HoneySlimeHusbandryMob.HoneySlimeLayPlortAINode.this.mob())
                  .getLevel();
              level.entityManager.pickups.add((PickupEntity) product.getPickupEntity(level,
                  ((HoneySlimeHusbandryMob) HoneySlimeHusbandryMob.HoneySlimeLayPlortAINode.this.mob()).x,
                  ((HoneySlimeHusbandryMob) HoneySlimeHusbandryMob.HoneySlimeLayPlortAINode.this.mob()).y));
            }

            public boolean isValid() {
              return true;
            }

            public int getTimeItTakesInMilliseconds() {
              return 4000;
            }
          };
        }
      }
      if (this.target != null && this.target.isValid()) {
        if (this.target.canProcess() && !mob.isLayingPlort() && mob.canLayPlort() && GameMath
            .diagonalMoveDistance(this.target.tileX, this.target.tileY, mob.getTileX(), mob.getTileY()) <= 1.0D)
          ((HoneySlimeHusbandryMob) mob).layPlortAbility.runAndSend(this.target);
        if (mob.isLayingPlort())
          return AINodeResult.SUCCESS;
        this.target = null;
        return AINodeResult.SUCCESS;
      }
      this.target = null;
      return AINodeResult.FAILURE;
    }
  }
}