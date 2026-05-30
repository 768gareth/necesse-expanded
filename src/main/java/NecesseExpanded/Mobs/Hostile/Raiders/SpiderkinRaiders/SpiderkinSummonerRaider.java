package NecesseExpanded.Mobs.Hostile.Raiders.SpiderkinRaiders;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.network.client.Client;
import necesse.engine.registries.MobRegistry;
import necesse.engine.registries.MobRegistry.Textures;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI;
import necesse.entity.mobs.ai.behaviourTree.trees.CollisionPlayerChaserWandererAI;
import necesse.entity.mobs.hostile.BloatedSpiderMob;
import necesse.entity.particle.FleshParticle;
import necesse.entity.particle.Particle.GType;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.human.HumanDrawOptions;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.ItemHolding;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class SpiderkinSummonerRaider extends SpiderkinRaiderTemplate
{
    int SummonTimer = 0;

    public SpiderkinSummonerRaider()
    {
        super();
        setMaxHealth(600);
        this.weapon = new InventoryItem("webweaver");
        this.helmet = new InventoryItem("empressmask");
        this.chest = new InventoryItem("spideritechestplate");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void serverTick() 
    {
        super.serverTick();
        if (SummonTimer >= 400 && this.isInCombat())
        {
            BloatedSpiderMob Summon = new BloatedSpiderMob();
            Summon.ai = new BehaviourTreeAI(this, new CollisionPlayerChaserWandererAI((java.util.function.Supplier)null, 99999, (GameDamage)null, 100, 40000));
            this.getLevel().entityManager.addMob(Summon, this.getX(), this.getY());
            SummonTimer = 0;
        }
        SummonTimer++;
    }

    public void spawnDeathParticles(float knockbackX, float knockbackY) {
        for (int i = 0; i < 4; ++i) {
            this.getLevel().entityManager.addParticle(new FleshParticle(this.getLevel(), Textures.spiderkin.body,
                    GameRandom.globalRandom.nextInt(5), 8, 32, this.x, this.y, 20.0F, knockbackX, knockbackY),
                    GType.IMPORTANT_COSMETIC);
        }

    }

    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList,
            Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
        super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
        GameLight light = level.getLightLevel(x / 32, y / 32);
        int drawX = camera.getDrawX(x) - 22 - 10;
        int drawY = camera.getDrawY(y) - 44 - 7;
        int dir = getDir();
        Point sprite = getAnimSprite(x, y, dir);
        boolean inLiquid = inLiquid(x, y);
        if (inLiquid)
            sprite.x = 0;
        drawY += getBobbing(x, y);
        drawY += getLevel().getTile(x / 32, y / 32).getMobSinkingAmount((Mob) this);
        MaskShaderOptions swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
        HumanDrawOptions humanOptions = (new HumanDrawOptions(level, MobRegistry.Textures.spiderkin)).sprite(sprite)
                .dir(dir).mask(swimMask).light(light);
        if (inLiquid) {
            humanOptions.armSprite(2);
            humanOptions.mask(MobRegistry.Textures.boat_mask[sprite.y % 4], 0, -7);
        }
        if (this.helmet != null)
            humanOptions.helmet(this.helmet);
        if (this.chest != null)
            humanOptions.chestplate(this.chest);
        if (this.boots != null)
            humanOptions.boots(this.boots);
        if (!this.isAttacking && this.carryingLoot != null) {
            InventoryItem holdItem = new InventoryItem("itemhold");
            ItemHolding.setGNDData(holdItem, this.carryingLoot);
            humanOptions.holdItem(holdItem);
        }
        setupAttackDraw(humanOptions);
        final DrawOptions drawOptions = humanOptions.pos(drawX, drawY);
        final TextureDrawOptionsEnd boat = inLiquid
                ? MobRegistry.Textures.steelBoat.initDraw().sprite(0, sprite.y, 64).light(light).pos(drawX, drawY + 7)
                : null;
        list.add(new MobDrawable() {
            public void draw(TickManager tickManager) {
                if (boat != null)
                    boat.draw();
                drawOptions.draw();
            }
        });
        addShadowDrawables(tileList, level, x, y, light, camera);
    }

    public void drawOnMap(TickManager tickManager, Client client, int x, int y, double tileScale, Rectangle drawBounds,
            boolean isMinimap) {
        int dir = this.getDir();
        Point sprite = this.getAnimSprite(this.getDrawX(), this.getDrawY(), dir);
        HumanDrawOptions humanOptions = (new HumanDrawOptions(this.getLevel(), MobRegistry.Textures.spiderkin))
                .sprite(sprite).dir(dir)
                .size(32, 32);
        humanOptions.pos(x - 15, y - 26).draw();
    }
}
