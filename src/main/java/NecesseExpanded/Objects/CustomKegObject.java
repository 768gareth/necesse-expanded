package NecesseExpanded.Objects;

import java.awt.Rectangle;
import java.util.List;
import java.util.stream.Stream;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.ContainerRegistry;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.objectEntity.ObjectEntity;
import necesse.entity.objectEntity.ProcessingTechInventoryObjectEntity;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.LevelSortedDrawable;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.container.object.OEInventoryContainer;
import necesse.inventory.item.Item;
import necesse.inventory.item.toolItem.ToolType;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;
import necesse.level.gameObject.GameObject;
import necesse.level.gameObject.ObjectHoverHitbox;
import necesse.level.maps.Level;
import necesse.level.maps.levelData.settlementData.SettlementWorkstationObject;
import necesse.level.maps.light.GameLight;

public class CustomKegObject extends GameObject implements SettlementWorkstationObject
{
    GameTexture texture;
  
    public int statueXOffset;
  
    public int spriteCount;

    public CustomKegObject()
    {
        super(new Rectangle(2, 2, 28, 28));
        this.displayMapTooltip = true;
        this.stackSize = 10;
        this.objectHealth = 100;
        this.isLightTransparent = true;
        this.rarity = Item.Rarity.NORMAL;
        this.toolType = ToolType.PICKAXE;
        this.spriteCount = 4;
        setItemCategory(new String[] { "objects", "craftingstations" });
        setCraftingCategory(new String[] { "craftingstations" });
    }

    public ObjectEntity getNewObjectEntity(Level level, int x, int y) 
    {
        return (ObjectEntity)new KegObjectEntity(level, x, y);
    }

    public void addDrawables(List<LevelSortedDrawable> list, OrderableDrawables tileList, Level level, int tileX, int tileY, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
    GameLight light = level.getLightLevel(tileX, tileY);
    int spriteWidth = this.texture.getWidth() / this.spriteCount;
    int drawX = camera.getTileDrawX(tileX) - this.statueXOffset;
    int drawY = camera.getTileDrawY(tileY);
    int rotation = level.getObjectRotation(tileX, tileY) % this.texture.getWidth() / spriteWidth;
    final TextureDrawOptionsEnd options = this.texture.initDraw().sprite(rotation, 0, spriteWidth, this.texture.getHeight()).addObjectDamageOverlay(this, level, tileX, tileY).light(light).pos(drawX, drawY - this.texture.getHeight() + 32);
    list.add(new LevelSortedDrawable(this, tileX, tileY) {
          public int getSortY() {
            return 16;
          }
          
          public void draw(TickManager tickManager) {
            options.draw();
          }
        });
  }
  
  public void drawPreview(Level level, int tileX, int tileY, int rotation, float alpha, PlayerMob player, GameCamera camera) {
    int spriteWidth = this.texture.getWidth() / this.spriteCount;
    int drawX = camera.getTileDrawX(tileX) - this.statueXOffset;
    int drawY = camera.getTileDrawY(tileY);
    rotation = (byte)(rotation % this.texture.getWidth() / spriteWidth);
    this.texture.initDraw()
      .sprite(rotation, 0, spriteWidth, this.texture.getHeight())
      .alpha(alpha)
      .draw(drawX, drawY - this.texture.getHeight() + 32);
  }
  
  public List<ObjectHoverHitbox> getHoverHitboxes(Level level, int layerID, int tileX, int tileY) {
    List<ObjectHoverHitbox> list = super.getHoverHitboxes(level, layerID, tileX, tileY);
    list.add(new ObjectHoverHitbox(layerID, tileX, tileY, 0, -16, 32, 32));
    return list;
  }

    @Override
    public void loadTextures() 
    {
        super.loadTextures();
        texture = GameTexture.fromFile("objects/custom_keg");
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
