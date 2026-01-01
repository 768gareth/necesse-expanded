package NecesseExpanded.World.Presets;

import necesse.engine.registries.ObjectRegistry;
import necesse.engine.util.GameRandom;
import necesse.inventory.lootTable.presets.DeepCaveChestLootTable;
import necesse.level.maps.presets.Preset;

public class FishianShrinePreset extends Preset
{
    public FishianShrinePreset() 
    {
        super("eNqtVE1rwzAM_Sv-ATrkcySHnNYedurYBjuMMJzYbTy8uDgOZRv777OduTFtUloIyEZ-71lSFKPHp_Xz-qX4OTCimiKHhrJdo7SjGKcPq654yzNAW9Y1DLfvBgSU5YD2PSGc1qKqOC2tWEsN4S9z9RRz-NxaUnOJv1a3dM2X-1OCqD5orWznA0CYSUBhkoTjP6gk_mZUw3dJAoj07Y6KlrBuz_GX0cbJqD1gzgFFWQRIVB0jGqsF7z9bK0xHIRFCutw68xBlck9n8ONusw0lB86G4z8zSoMpu16QeqBthi9JF0py2xfd1rISpFBYMdGanmvMWeD5vkWWiqZAv7jIo07CxtaJ3a3Y2ZE6BgzmA45dmComOgPDyXqGsbEZ3tw9p1gWSvYUzKNd6dEizymF9biZ4WrjblRD5SuTehptMe_o7x8nThVV");
        this.setObject(4, 4, ObjectRegistry.getObjectID("demonchest"));
        this.addInventory
        (
            DeepCaveChestLootTable.swampDeepCaveChest, 
            GameRandom.globalRandom,
            4, 
            4, 
            new Object[0]);
    }
}
