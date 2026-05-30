package NecesseExpanded.Registry;

import necesse.inventory.item.toolItem.projectileToolItem.gunProjectileToolItem.GunProjectileToolItem;

public class UpdateAmmoTypes 
{
    public static void Update()
    {
        System.out.println("[Necesse Expanded] Updating ammo types for ranged weapons...");
        GunProjectileToolItem.NORMAL_AMMO_TYPES.add("vampire_bullet");
        GunProjectileToolItem.NORMAL_AMMO_TYPES.add("venom_bullet");
    }
}
