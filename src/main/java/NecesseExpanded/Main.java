package NecesseExpanded;

import NecesseExpanded.Mobs.Hostile.Snow.IceGolemMob;
import NecesseExpanded.Registry.PreRegisterItems;
import NecesseExpanded.Registry.PreRegisterMobs;
import NecesseExpanded.Registry.RegisterBiomes;
import NecesseExpanded.Registry.RegisterBuffs;
import NecesseExpanded.Registry.RegisterEvents;
import NecesseExpanded.Registry.RegisterExpeditions;
import NecesseExpanded.Registry.RegisterItems;
import NecesseExpanded.Registry.RegisterLevels;
import NecesseExpanded.Registry.RegisterMobs;
import NecesseExpanded.Registry.RegisterObjects;
import NecesseExpanded.Registry.RegisterProjectiles;
import NecesseExpanded.Registry.RegisterRecipeTechs;
import NecesseExpanded.Registry.RegisterRecipes;
import NecesseExpanded.Registry.RegisterTiles;
import NecesseExpanded.Registry.RegisterWorldPresets;
import NecesseExpanded.Registry.UpdateAmmoTypes;
import NecesseExpanded.Registry.UpdateHappinessMetrics;
import NecesseExpanded.Registry.UpdateLootTables;
import NecesseExpanded.Registry.UpdateSpawnTables;
import customsettingslib.components.settings.IntSetting;
import customsettingslib.settings.CustomModSettings;
import customsettingslib.settings.CustomModSettingsGetter;
import necesse.engine.modLoader.ModSettings;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.gfx.gameTexture.GameTexture;

@ModEntry
public class Main 
{
    public static CustomModSettingsGetter SettingsGetter;

    public void preInit()
    {
        PreRegisterMobs.Register();
        PreRegisterItems.Register();
    }

    public void init() 
    {
        RegisterItems.Register();
        RegisterMobs.Register();
        RegisterObjects.Register();
        RegisterEvents.Register();
        RegisterBuffs.Register();
        RegisterTiles.Register();
        RegisterProjectiles.Register();
        RegisterExpeditions.Register();
        RegisterRecipeTechs.Register();
        RegisterBiomes.Register();
        RegisterLevels.Register();
        RegisterWorldPresets.Register();
        RegisterRecipes.Register();
    } 

    public void initResources()
    {
        IceGolemMob.texture = GameTexture.fromFile("mobs/ice_golem");
        // HoneySlimeHusbandryMob.Texture = GameTexture.fromFile("mobs/honey_slime");
    }

    public void postInit()
    {
        UpdateHappinessMetrics.Update();
        UpdateLootTables.Update();
        UpdateSpawnTables.Update();
        UpdateAmmoTypes.Update();
    }

    public ModSettings initSettings() 
    {
        CustomModSettings ModSettings = new CustomModSettings()

        // Raid Settings
        .addTextSeparator("ne_settings_separator_1")

        .addBooleanSetting("raids_enabled", true)
        .addParagraph("raids_tip")

        .addBooleanSetting("include_vanilla_raids", false)
        .addParagraph("vanilla_raids_tip")

        .addIntSetting("vanilla_raid_chance", 50, 1, 100, IntSetting.DisplayMode.BAR)
        .addParagraph("vanilla_raid_chance_tip")

        .addBooleanSetting("raider_bombs_destructive", false)
        .addParagraph("bombs_tip")

        .addIntSetting("raid_size_multiplier", 3, 1, 100, IntSetting.DisplayMode.BAR)
        .addParagraph("raid_size_tip")

        // Settlement Settings
        .addTextSeparator("ne_settings_separator_2")

        .addBooleanSetting("happiness_changes_enabled", true)
        .addParagraph("happiness_changes_tip")

        .addBooleanSetting("settlers_share_rooms_without_penalty", false)
        .addParagraph("settlers_sharing_room_tip")

        // Miscellaneous Settings
        .addTextSeparator("ne_settings_separator_3")

        .addBooleanSetting("starter_equipment_enabled", true)
        .addParagraph("starter_equipment_tip")

        .addBooleanSetting("starter_kit_enabled", true)
        .addParagraph("starter_kit_tip")

        .addBooleanSetting("player_speed_patch", true)
        .addParagraph("player_speed_tip")

        .addIntSetting("player_speed_value", 50, 40, 80, IntSetting.DisplayMode.BAR)
        .addParagraph("player_speed_value_tip")

        .addIntSetting("chest_size_value", 60, 40, 120, IntSetting.DisplayMode.BAR)
        .addParagraph("chest_size_tip");

        SettingsGetter = ModSettings.getGetter();
        ModSettings.addServerSettings
        (
            "raids_enabled", 
            "include_vanilla_raids",
            "vanilla_raid_chance",
            "raider_bombs_destructive", 
            "raid_size_multiplier",
            "happiness_changes_enabled",
            "settlers_share_rooms_without_penalty",
            "starter_equipment_enabled",
            "starter_kit_enabled",
            "player_speed_patch",
            "player_speed_value",
            "chest_size_value"
        );
        return ModSettings;
    }
}
