package NecesseExpanded.Settlements.Objects;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.List;
import java.util.stream.Stream;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.ContainerRegistry;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.objectEntity.ObjectEntity;
import necesse.entity.objectEntity.ProcessingTechInventoryObjectEntity;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.texture.TextureDrawOptions;
import necesse.gfx.drawables.LevelSortedDrawable;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.container.object.OEInventoryContainer;
import necesse.inventory.item.toolItem.ToolType;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;
import necesse.level.gameObject.GameObject;
import necesse.level.maps.Level;
import necesse.level.maps.levelData.settlementData.SettlementWorkstationObject;
import necesse.level.maps.light.GameLight;

public class Keg extends GameObject implements SettlementWorkstationObject
{
    GameTexture Texture;

    public Keg()
    {
        super(new Rectangle(4, 6, 24, 20));
        setItemCategory(new String[] { "objects", "craftingstations" });
        setCraftingCategory(new String[] { "craftingstations" });
        this.mapColor = new Color(100, 80, 25);
        this.toolType = ToolType.ALL;
        this.objectHealth = 50;
        this.isLightTransparent = true;
        this.replaceCategories.add("workstation");
        this.canReplaceCategories.add("workstation");
        this.canReplaceCategories.add("wall");
        this.canReplaceCategories.add("furniture");
    }

    public ObjectEntity getNewObjectEntity(Level level, int x, int y) 
    {
        return (ObjectEntity)new KegObjectEntity(level, x, y);
    }

    public void addDrawables(List<LevelSortedDrawable> list, OrderableDrawables tileList, Level level, int tileX, int tileY, TickManager tickManager, GameCamera camera, PlayerMob perspective) 
    {
        GameLight light = level.getLightLevel(tileX, tileY);
        int drawX = camera.getTileDrawX(tileX);
        int drawY = camera.getTileDrawY(tileY);
        GameTexture texture = GameTexture.fromFile("objects/keg");
        TextureDrawOptions options = texture.initDraw().light(light).pos(drawX, drawY - texture.getHeight() + 32);
        list.add(new LevelSortedDrawable(this, tileX, tileY) {
            public int getSortY() 
            {
                return 16;
            }
            public void draw(TickManager tickManager) 
            {
                options.draw();
            }
        });
    }

    @Override
    public void loadTextures() 
    {
        super.loadTextures();
        Texture = GameTexture.fromFile("objects/keg");
    }

    public boolean canInteract(Level level, int x, int y, PlayerMob player) 
    {
        return true;
    }
  
    public void interact(Level level, int x, int y, PlayerMob player) 
    {
        if (level.isServer())
        OEInventoryContainer.openAndSendContainer(ContainerRegistry.PROCESSING_INVENTORY_CONTAINER, player.getServerClient(), level, x, y); 
    }

    public ProcessingTechInventoryObjectEntity getProcessingObjectEntity(Level level, int tileX, int tileY) 
    {
        ObjectEntity objectEntity = level.entityManager.getObjectEntity(tileX, tileY);
        if (objectEntity instanceof ProcessingTechInventoryObjectEntity)
            return (ProcessingTechInventoryObjectEntity)objectEntity; 
        return null;
    }

    @Override
    public Stream<Recipe> streamSettlementRecipes(Level level, int tileX, int tileY) 
    {
        ProcessingTechInventoryObjectEntity processingOE = getProcessingObjectEntity(level, tileX, tileY);
        if (processingOE != null)
            return Recipes.streamRecipes(processingOE.techs); 
        return Stream.empty();
    }
    
}
