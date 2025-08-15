package NecesseExpanded.Other;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import necesse.engine.eventStatusBars.EventStatusBarManager;
import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.MobRegistry;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.ai.behaviourTree.AINode;
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI;
import necesse.entity.mobs.ai.behaviourTree.trees.ConfusedCollisionPlayerChaserWandererAI;
import necesse.entity.mobs.hostile.bosses.BossMob;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.level.maps.light.GameLight;
import necesse.level.maps.Level;

public class SecretBoss extends BossMob
{
    LootTable Loot;

    public SecretBoss() 
    {
        super(20000);
        this.setSpeed(80F);
        this.setFriction(10.0F);
        this.setArmor(0);
        this.collision = new Rectangle(-12, -9, 24, 18);
        this.hitBox = new Rectangle(-16, -12, 32, 24);
        this.selectBox = new Rectangle(-18, -40, 36, 46);
        this.swimMaskMove = 16;
        this.swimMaskOffset = 0;
        this.swimSinkOffset = 0;

        this.Loot = new LootTable
        (
            new LootItemInterface[] 
            { 
                (LootItemInterface)new LootItem("spoiledfood", 99)
            }
        );
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void init() 
    {
        super.init();
        this.ai = new BehaviourTreeAI((Mob)this, (AINode)new ConfusedCollisionPlayerChaserWandererAI(() -> Boolean.valueOf(false), 100000, new GameDamage(99999.0F), 0, 0));
    }

    public LootTable getLootTable() 
    {
        return Loot;
    }

    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) 
    {
        super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
        GameLight light = level.getLightLevel(x / 32, y / 32);
        int drawX = camera.getDrawX(x) - 22 - 10;
        int drawY = camera.getDrawY(y) - 44 - 7;
        int dir = getDir();
        Point sprite = getAnimSprite(x, y, dir);
        drawY += getBobbing(x, y);
        drawY -= 4;
        drawY += getLevel().getTile(x / 32, y / 32).getMobSinkingAmount((Mob)this);
        final MaskShaderOptions swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
        final TextureDrawOptionsEnd options = MobRegistry.Textures.cow.initDraw().sprite(sprite.x, sprite.y, 64).light(light).addMaskShader(swimMask).pos(drawX, drawY);
        list.add(new MobDrawable() 
        {
              public void draw(TickManager tickManager) 
              {
                swimMask.use();
                options.draw();
                swimMask.stop();
              }
        });
    }

    public void serverTick()
    {
        super.serverTick();
        EventStatusBarManager.registerMobHealthStatusBar((Mob)this);
    }
}
