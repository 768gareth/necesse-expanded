package NecesseExpanded.Registry;

import NecesseExpanded.Buffs.Trinkets.BerserkerRingBuff;
import NecesseExpanded.Buffs.Trinkets.BloodCrystalBuff;
import NecesseExpanded.Buffs.Trinkets.EnduranceStackBuff;
import NecesseExpanded.Buffs.Trinkets.ForgottenRelicBuff;
import NecesseExpanded.Buffs.Trinkets.LuckyRingBuff;
import NecesseExpanded.Buffs.Trinkets.NecromancerRingBuff;
import NecesseExpanded.Buffs.Trinkets.SandwormToothBuff;
import NecesseExpanded.Buffs.Trinkets.ShadowCrystalBuff;
import NecesseExpanded.Buffs.Weapons.Melee.MurasamaRevengeBuff;
import necesse.engine.modifiers.ModifierValue;
import necesse.engine.registries.BuffRegistry;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.SimplePotionBuff;
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.trinketBuffs.SimpleTrinketBuff;

public class RegisterBuffs 
{
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void Register()
    {
        System.out.println("[Necesse Expanded] Registering new buffs/debuffs...");

        // Complex buffs that require files and icons.
        BuffRegistry.registerBuff("murasama_revenge_buff", new MurasamaRevengeBuff());
        BuffRegistry.registerBuff("endurance_stack_buff", new EnduranceStackBuff());

        // Trinket buffs, that need files, but no need for icons
        BuffRegistry.registerBuff("blood_crystal_buff", new BloodCrystalBuff());
        BuffRegistry.registerBuff("shadow_crystal_buff", new ShadowCrystalBuff());
        BuffRegistry.registerBuff("sandworm_tooth_buff", new SandwormToothBuff());
        BuffRegistry.registerBuff("lucky_ring_buff", new LuckyRingBuff());
        BuffRegistry.registerBuff("necromancer_ring_buff", new NecromancerRingBuff());
        BuffRegistry.registerBuff("forgotten_relic_buff", new ForgottenRelicBuff());
        BuffRegistry.registerBuff("berserker_ring_buff", new BerserkerRingBuff());
        
        // Simple buffs that don't need specific files but do need icons.
        BuffRegistry.registerBuff("shadow_crystal_bonus", new SimplePotionBuff(true, new ModifierValue[]{new ModifierValue(BuffModifiers.ALL_DAMAGE, 0.25F)}));
        BuffRegistry.registerBuff("venom_bullet_debuff", new SimplePotionBuff(true, new ModifierValue[]{new ModifierValue(BuffModifiers.INCOMING_DAMAGE_MOD, 1.20F)}));
        BuffRegistry.registerBuff("stamina_potion_buff", new SimplePotionBuff(false, new ModifierValue[]{new ModifierValue(BuffModifiers.STAMINA_CAPACITY, 0.25f), new ModifierValue(BuffModifiers.STAMINA_REGEN, 0.10f)}));
        
        // Simple buffs that don't need files or icons.
        BuffRegistry.registerBuff("lensmaker_buff", new SimpleTrinketBuff(new ModifierValue[]{new ModifierValue(BuffModifiers.RANGED_ATTACK_SPEED, 0.10F), new ModifierValue(BuffModifiers.RANGED_CRIT_DAMAGE, 0.25F)}));
        BuffRegistry.registerBuff("summoner_book_buff", new SimpleTrinketBuff(new ModifierValue[]{new ModifierValue(BuffModifiers.SUMMONS_SPEED, 0.15F), new ModifierValue(BuffModifiers.SUMMON_DAMAGE, 0.10F)}));
        BuffRegistry.registerBuff("warrior_ring_buff", new SimpleTrinketBuff(new ModifierValue[]{new ModifierValue(BuffModifiers.MELEE_CRIT_CHANCE, 0.10F), new ModifierValue(BuffModifiers.MELEE_CRIT_DAMAGE, 0.25F)}));
        BuffRegistry.registerBuff("ancient_tablet_buff", new SimpleTrinketBuff(new ModifierValue[]{new ModifierValue(BuffModifiers.MAX_MANA_FLAT, 25), new ModifierValue(BuffModifiers.MAGIC_ATTACK_SPEED, 0.10F)}));
        BuffRegistry.registerBuff("leather_scabbard_buff", new SimpleTrinketBuff(new ModifierValue[]{new ModifierValue(BuffModifiers.MAX_RESILIENCE_FLAT, 10)}));
        BuffRegistry.registerBuff("void_amulet_buff", new SimpleTrinketBuff(new ModifierValue[]{new ModifierValue(BuffModifiers.MAGIC_ATTACK_SPEED, 0.15F)}));

        // Special invisible buffs that are unavailable to players. These should only be used to confer temporary happiness effects.
        BuffRegistry.registerBuff("settler_death_penalty", new SimplePotionBuff(new ModifierValue[]{new ModifierValue(BuffModifiers.ATTACK_SPEED, 0F)}));
        BuffRegistry.registerBuff("settler_raid_bonus", new SimplePotionBuff(new ModifierValue[]{new ModifierValue(BuffModifiers.ATTACK_SPEED, 0F)}));
    }
}
