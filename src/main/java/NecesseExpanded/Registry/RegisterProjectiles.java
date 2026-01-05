package NecesseExpanded.Registry;

import NecesseExpanded.Projectiles.BrimstoneProjectile;
import NecesseExpanded.Projectiles.FrostboltProjectile;
import NecesseExpanded.Projectiles.InfernoProjectile;
import NecesseExpanded.Projectiles.RaiderBombProjectile;
import NecesseExpanded.Projectiles.RaiderBombProjectile2;
import NecesseExpanded.Projectiles.VampireBulletProjectile;
import NecesseExpanded.Projectiles.VenomBulletProjectile;
import NecesseExpanded.Projectiles.VoidBoltProjectile;
import NecesseExpanded.Projectiles.WinterWrathProjectile;
import necesse.engine.registries.ProjectileRegistry;

public class RegisterProjectiles 
{
    public static void Register()
    {
        System.out.println("[Necesse Expanded] Registering new projectiles...");

        // Raider bombs
        ProjectileRegistry.registerProjectile("raider_bomb_projectile", RaiderBombProjectile.class, "ironbomb", "ironbomb_shadow");
        ProjectileRegistry.registerProjectile("raider_bomb_projectile_2", RaiderBombProjectile2.class, "dynamitestick", "dynamitestick_shadow");

        // Ammunition
        ProjectileRegistry.registerProjectile("vampire_bullet", VampireBulletProjectile.class, (String)null, (String)null);
        ProjectileRegistry.registerProjectile("venom_bullet", VenomBulletProjectile.class, (String)null, (String)null);

        // Magic weapon projectiles
        ProjectileRegistry.registerProjectile("frostbolt_projectile", FrostboltProjectile.class, "frostbolt_projectile", "bloodbolt_shadow");
        ProjectileRegistry.registerProjectile("voidbolt_projectile", VoidBoltProjectile.class, "voidbolt_projectile", "bloodbolt_shadow");
        ProjectileRegistry.registerProjectile("inferno_projectile", InfernoProjectile.class, (String)null, (String)null);
        ProjectileRegistry.registerProjectile("winterwrath_projectile", WinterWrathProjectile.class, "winterwrath_projectile", "froststaff_shadow");
        ProjectileRegistry.registerProjectile("brimstone_projectile", BrimstoneProjectile.class, "brimstone_projectile", "webball_shadow");
    }
}
