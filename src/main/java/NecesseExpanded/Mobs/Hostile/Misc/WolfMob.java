package NecesseExpanded.Mobs.Hostile.Misc;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import java.util.stream.Stream;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.modifiers.ModifierValue;
import necesse.engine.registries.MobRegistry;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.MobTexture;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.ai.behaviourTree.AINode;
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI;
import necesse.entity.mobs.ai.behaviourTree.trees.ConfusedCollisionPlayerChaserWandererAI;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.hostile.HostileMob;
import necesse.entity.particle.FleshParticle;
import necesse.entity.particle.Particle;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class WolfMob extends HostileMob 
{
    public LootTable Loot = new LootTable( new LootItemInterface[] { new LootItem("leather", 2)});
    public static MobTexture Texture;

    public WolfMob() 
    {
        super(300);
        setSpeed(45.0F);
        setFriction(4.0F);
        setKnockbackModifier(0.5F);
        setArmor(20);
        this.moveAccuracy = 8;
        this.collision = new Rectangle(-10, -7, 20, 14);
        this.hitBox = new Rectangle(-14, -12, 28, 24);
        this.selectBox = new Rectangle(-18, -24, 36, 36);
        this.swimMaskMove = 16;
        this.swimMaskOffset = 0;
        this.swimSinkOffset = -12;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void init() {
        super.init();
        this.ai = new BehaviourTreeAI((Mob) this,
                (AINode) new ConfusedCollisionPlayerChaserWandererAI(null, 512, new GameDamage(10f), 100, 40000));
    }

  public LootTable getLootTable() {
    return Loot;
  }

    public void spawnDeathParticles(float knockbackX, float knockbackY) {
        for (int i = 0; i < 4; i++)
            (getLevel()).entityManager.addParticle((Particle) new FleshParticle(getLevel(),
                    MobRegistry.Textures.snowWolf.body, 12, i, 32, this.x, this.y, 20.0F, knockbackX, knockbackY),
                    Particle.GType.IMPORTANT_COSMETIC);
    }

    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList,
            Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
        super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
        GameLight light = level.getLightLevel(getTileCoordinate(x), getTileCoordinate(y));
        int drawX = camera.getDrawX(x) - 32;
        int drawY = camera.getDrawY(y) - 36;
        int dir = getDir();
        Point sprite = getAnimSprite(x, y, dir);
        drawY += getBobbing(x, y);
        drawY += level.getTile(getTileCoordinate(x), getTileCoordinate(y)).getMobSinkingAmount((Mob) this);
        final MaskShaderOptions swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
        final TextureDrawOptionsEnd body = Texture.body.initDraw().sprite(sprite.x, sprite.y, 64)
                .addMaskShader(swimMask).light(light).pos(drawX, drawY);
        list.add(new MobDrawable() {
            public void draw(TickManager tickManager) {
                swimMask.use();
                body.draw();
                swimMask.stop();
            }
        });
        TextureDrawOptionsEnd textureDrawOptionsEnd2 = MobRegistry.Textures.snowWolf.shadow.initDraw()
                .sprite(0, sprite.y, 64).light(light).pos(drawX, drawY);
        tileList.add(tm -> textureDrawOptionsEnd2.draw());
    }

    public int getSwimMaskMove() {
        if (getDir() != 2)
            return super.getSwimMaskMove() + 4;
        return super.getSwimMaskMove();
    }

    public int getRockSpeed() {
        return 13;
    }

    public Stream<ModifierValue<?>> getDefaultModifiers() {
        return Stream.of((new ModifierValue(BuffModifiers.FRICTION,
                Float.valueOf(0.0F))).min(Float.valueOf(0.75F)));
    }
}