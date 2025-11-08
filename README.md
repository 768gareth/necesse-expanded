# Necesse Expanded (v0.6)
Necesse Expanded is an all-in-one mod package, developed by myself, for the open world survival crafting game Necesse, 
which was published by Fair Games ApS. This mod is intended to provide a comprehensive overhaul of the vanilla Necesse
experience, adding new content and mechanics, and updating vanilla content to a higher standard.

- This mod can be installed at any point during a playthrough, though the world generation changes require visiting new areas for the changes to appear, as they will not affect already-generated biomes. 

- This mod is safe to use with dedicated servers. If you need help with installing mods on a dedicated server, please visit the official Necesse discord: https://discord.gg/FAFgrKD

- Due to known issues with how Steam Workshop handles updating installed mods, please make sure to verify your game files/unsubscribe and resubscribe if you are experiencing any major bugs or crashes. If the issue persists, please post about the issue to the bug report thread on the steam workshop page. If it's causing crashes, please include the crash log (the window that pops up on crash), as this is a very useful resource for finding and fixing such issues.

Please note that this repository is intended to help other modders understand how to develop their own Necesse mods, and to provide more details on what this mod does for users. Please do not download from this repository
with the expectation that you are accessing a more 'up-to-date' version of the mod, or that what you download is functional and playable.

The latest working version of this mod can be found at the mod's Steam Workshop page, now with over 10,000 downloads and 30,000 views!
https://steamcommunity.com/sharedfiles/filedetails/?id=3546316000

If you're interesting in joining this project, either as a developer, sprite artist, or translator, please let me know!

# What does this mod add/change?
## Gameplay changes
This section broadly covers the modifications to vanilla gameplay systems, such the new raid system, modified settler happiness system, modified world generation, modified mob/chest loot tables, overhauled NPC shops, and miscellaneous changes like player movement speed and starting equipment.

### New Custom Raid System
A new custom raid system that can replace or be used alongside Necesse's original raid system, depending on configuration. This raid system features nine new raid types, 25 new raider mobs, and a raider mini-boss (Runebound Captain, which only spawns in the Runebound Raiders raid type). 

Raid difficulty for the new raid system is based on settlement quest progression, so you'll encounter new raid types and more difficult raiders as you complete more quests for a settlement. Please note that this system is built on the expectation that you're completing quests in order, so skipping quests may result in skipped raid tiers.

Using the default mod configuration, Necesse Expanded's custom raid system has a 50% chance to replace a vanilla raid with a custom raid. You can configure the system to allow only custom raids, or disable it entirely to allow only vanilla raids.

This mod does not affect vanilla raids themselves in any capacity.

#### Raid tiers (and available raids for each tier)
- Fallen Wizard: Spiderkin Raiders, Slime Cave Raiders, Graveyard Raiders
- Pest Warden: Ancient Skeleton Raiders
- Pirate Captain: Skeleton Raiders, Ninja Raiders
- Swamp Guardian: Pirate Raiders, Runebound Raiders
- Pre-Swamp Guardian: Zombie Raiders

### Overhauled Settler Happiness System
Settler happiness mechanics have been significantly reworked for balancing and gameplay purposes.

- Settler expectations regarding room size and diet variety have been reduced, and happiness gains modified. 

- Settlers gain happiness from living in larger settlements, to encourage building larger settlements. 

- Happiness gains from eating food have been modified.

- Happiness penalty for settlers sharing rooms has been reworked. Now, the happiness penalty for settlers sharing rooms is -5 * (number of settlers sleeping in the same room).

- The happiness penalty for missing any floor tile, and for missing a light source, have been reduced to -3 happiness each. Likewise, the penalty for missing a bed has been reduced to -20, and the penalty for an outdoor bed has been reduced to -10.

- Settlers gain happiness from completed settlement quests. +1 happiness per completed quest, up to +13 happiness for all 13 quests completed, with a minimum of two quests completed to gain the bonus.

- Settlers gain +4 happiness from surviving raids, +6 happiness if a settlement has been well-defended against raiders, and suffer a -3 happiness penalty if a settlement has been poorly defended against raiders.

- Settlers gain a -5 happiness penalty if another settler dies, which lasts for ten minutes.

- Settlers gain +3 happiness if a settlement has a homestone placed down.

| Room Size    | Happiness |
| -------- | ------- |
| 0  | +0    |
| 4 | +4     |
| 9    | +8    |
| 16    | +12    |
| 25    | +16    |
| 32    | +24    |

| Settlement Size    | Happiness |
| -------- | ------- |
| 0  | +5    |
| 5 | +10     |
| 10    | +15    |
| 15    | +20    |
| 20    | +25    |

| Food Quality    | Happiness |
| -------- | ------- |
| Simple  | +8    |
| Fine | +12     |
| Gourmet    | +18    |
| Perfect    | +24   |

| Diet Variety    | Happiness |
| -------- | ------- |
| 0  | +0    |
| 2 | +10     |
| 4    | +15    |
| 6    | +20   |
| 8    | +28   |

### Modified World Generation
This mod also significantly changes the vanilla world generation system for gameplay purposes.

- The density of rock walls in caves and deep caves has been reduced for ease of exploration. In other words, both types of caves should be more spacious and easier to navigate. This does not affect incursions, due to them using a different generation system.

- Frost Shard clusters have a small chance to spawn in Snow Caves, providing a little variety in how to acquire frost shards. There's also a very, very rare chance for a snowman to spawn.

- Life Quartz clusters have a small chance to spawn in all deep cave types.

- Plains Deep Cave generation code has been modified. Topaz clusters have a small chance to spawn on rock tiles. Lava tiles have been replaced with spirit water, matching the original biome art style from before 1.0. Leaf piles also appear occasionally as decorations.

- In Swamp Deep Caves, lava tiles have been replaced with water tiles, and emerald clusters have a small chance to spawn on rock tiles.

- In Desert Deep Caves, lava tiles have been replaced with quicksand, and ruby clusters have a small chance to spawn on rock tiles.

### Hostile mob/boss loot changes
Necesse Expanded modifies certain vanilla hostile mob loot tables to make acquiring certain items easier.

- All types of slimes (except for incursion slimes) now have a chance to drop Slime, a new crafting material.

- Vampires have a 5% chance to drop a random main item from the cave crypt loot table.

- Snow wolves and Jackals drop 1 leather, and 1 raw mutton.

- Void apprentices have a 5% chance to drop a random main item from the dungeon chest loot table.

- Pirates have a 25% chance to drop a bottle of Pirate's Rum.

- Sandworms have a 5% chance to drop the new Sandworm Tooth trinket.

- Graveyard incursion mods have a 1% chance to drop the new Blood Crystal trinket.

- The Crystal Dragon drops omni-crystals, pearlescent diamonds, and most types of crystals.

- The Moonlight Dancer and Sunlight Champion now drop Lunar Essence and Solar Essence respectively, rather than their associated armour sets. Use those new crafting materials to craft the armour instead.

- The Reaper's main item loot pool now includes the new Shadow Crystal trinket.

### Cave chest loot table changes
- Added Sparkler and Leather Scabbard to Forest Caves chest loot.

- Added Inferno and Juggernaut Axe to Deep Forest Caves chest loot.

- Added Frost Bolt to Snow Caves chest loot.

- Added Winter's Wrath to Deep Snow Caves chest loot.

- Added Void Amulet to Dungeon chest loot.

- Added Berserker's Ring to Swamp Caves chest loot.

- Added Murasama to Deep Swamp Caves chest loot.

- Added Forgotten Relic to Deep Swamp Caves fishian mini-biome barrel loot.

- Added Lensmaker's Glasses, Warrior Ring, Ancient Tablet, and Summoner's Grimoire to Desert Caves chest loot.

- Added Brimstone to Temple chest loot.

- Added Lucky Ring and Fool's Gambit to Pirate chest and display stand loot tables.

### Settler shop changes
Necesse Expanded modifies most NPC shops to add new items, and remove unnecessary shop clutter. For balancing and progression purposes, some items require you to defeat certain bosses before they can be purchased. Most settler shops have had their cosmetic sets moved to the Stylist's shop.

- Alchemists now sell potion pouches/bags, recall/portal flasks, revival potions, and most types of potions. Most items are initially unavailable until certain bosses have been defeated, for balancing purposes (i.e incursion potions are unavailable until the fallen wizard has been defeated). Alchemists now buy most alchemy ingredients, incursion essences, and alchemy shards.

- Anglers sell bait, and most types of fishing rod (except for Crystal Fishing Rod). They also buy the new fish added by Necesse Expanded.

- Animal keepers now sell queen bees, shears, buckets, ropes, and infinite rope. They'll buy leather, wool, and eggs.

- Blacksmiths sell iron, demonic, tungsten, and ancient fossil tools depending on progression, as well as wiring tools, and a new trinket. They'll also buy most types of crystals, as well as more valuable crafting materials, including incursion tier materials.

- Elders now sell two new map items that lead to some new content (see Fishian Biome and Dryad House for further details).

- Exotic Merchants now sell recall scrolls, mounts, pets, and recipe books. They'll also sell a random gourmet quality food item, a random drink item (such as wine or mead), a random rare painting, a random uncommon painting, a random common painting, and a number of randomly selected vinyls from various loot pools.

- Farmers sell lunchboxes, seed pouches, farmland, fertilizer, rope, farming scythes, most types of seeds, and fruit saplings (trees/bushes). They'll buy most types of crops/fruits, seaweed, and eggs.

- Gunsmiths sell Ammo Box, Lensmaker's Glasses, ammo pouches/bags, a variety of guns, and all types of bullets.

- Hunters sell Magical Quiver, Lensmaker's Glasses, ammo pouches/bags, a variety of bows, and all types of arrows.

- Mages sell void pouches/bags, homestones/waystones (available without defeating any bosses), recall scrolls, a variety of magic weapons, magic and summoning related potions, and a variety of trinkets related to magic and summoning. They'll also buy books.

- Miners sell coin pouches, iron bombs, dynamite, and a few mining relating trinkets.

- Stylists sell a massive range of cosmetic items, including those removed from other shops, to ensure that they are still available for those that want them.

### Additional vanilla crafting recipes
Necesse Expanded includes a large number of crafting recipes for vanilla items, allowing for the crafting of items that are difficult to acquire, rendered otherwise unobtainable by NPC shop changes, or unobtainable in vanilla Necesse.

There's too many new recipes to list here (without obscuring other important information), so to briefly summarise:

- Added recipes for most types of traps available in vanilla Necesse. Besides arrow traps and flame traps, which are obtainable in vanilla, this mod also allows for the crafting of saw traps, saw tracks, and spike traps, which are only available in creative mode, and are otherwise unavailable in survival mode.

- Added alternative recipes for most incursion-tier potions, using progression appropriate ingredients and some modded ingredients.

- Added alternative recipes for health potions, and mana potions.

- Added recipes for a large number of vanilla trinkets that were previously only accessible via exploration, minimising dependence on RNG for acquiring items necessary for trinket crafting progression.

- Added recipes for a few ranged weapons only available via the Gunsmith, due to those items being removed from the Gunsmith's shop and replaced with other items.

- Added recipes for iron bomb, dynamite, rope, and Angler's bait.

- Added recipes for Dawn Armour pieces using Solar Essence (new item), and Dusk Armour pieces using Lunar Essence (new item).

- Added recipes for banner stand, and trader chest using Workstation, and mission board using Demonic Workstation. This does make these objects available significantly earlier than in vanilla Necesse.

- Added recipes for music player and portable music player using Demonic Workstation.

### Miscellaneous changes
- Default player movement speed has been slightly increased, from 40 (default vanilla value) to 50 (+25% movement speed). This movement speed value can be configured in the mod settings menu, if you prefer to move at vanilla speed, or even faster (up to +100% movement speed).

- New player characters have better starting equipment. On spawn, you start with iron tools, torches, health potions, bread, a recipe book, and leather dashers. Enabled by default. This can be toggled.

- If the tutorial/elder house is allowed to spawn, the chest within will contain a settlement starter kit, including a settlement flag, coins, crafting materials, farmland, seeds, food, beds, chests, and basic crafting stations. Enabled by default. This can be toggled.

- Elders can now perform basic settlement tasks (hauling, crafting, farming, and forestry). This should make the early game a little easier.

## New content
### New weapons
#### Melee
- Juggernaut Axe: A powerful but slow battle axe with high knockback. Spawns in Deep Forest Caves chests. Can be crafted using 16 ectoplasm and 12 tungsten bars.

- Glacial Spear: Inflicts slowing and frost damage over time to enemies. Can be crafted using fourteen glacial bars and six glacial shards.

- Murasama: A powerful katana that grants a stacking buff upon killing an enemy, granting additional resilience gain and damage up to +100% and +20% respectively. Can be found in Deep Swamp caves chests, or crafted using 20 bio essence.

#### Ranged

#### Magic
- Frost Bolt: Launches a homing bolt that slows enemies for two seconds on hit. Can be found as a treasure item in the Snow Caves, or bought from Mages.

- Inferno: An upgraded version of the Sparkler, dealing more damage, and inflicting a more powerful debuff. Can be found as a treasure item in the Deep Forest Caves, or crafted using 20 shadow essence.

- Winter's Wrath: Launches three homing icicles, piercing through enemies, slowing and damaging enemies over time. Can be found as a treasure item in the deep snow caves, or crafted using 20 cryo essence.

- Brimstone: Launches a fireball that explodes on impact, dealing massive damage and igniting enemies within the blast radius. Can be found as a treasure item in the Temple, or crafted using 20 primordial essence.

#### Summoning

### New Trinkets
- Leather Scabbard: +10 max resilience. Crafted using 8 leather.

- Void Amulet: +15% magic attack speed. Can be found in Dungeon chests.

- Berserker's Ring: On receiving damage, gain a stack of Endurance, increasing your resilience gain by +10%, up to a maximum of +100%. Can be found in Swamp Caves.

- Lensmaker's Glasses: +10% ranged attack speed, +25% ranged crit damage. Can be found in Desert Caves chests, or bought from Hunters/Gunsmiths.

- Summoner's Grimoire: +15% summons speed, +10% summons damage. Can be found in Desert Caves chests, or bought from Mages.

- Ancient Tablet: +25 mana, +10% magic attack speed. Can be found in Desert Caves chests, or bought from Mages.
- Warrior's Ring: +10% melee crit chance, +25% melee crit damage. Can be found in Desert Caves chests, or bought from Blacksmiths.

- Lucky Ring: Killing enemies causes them to drop 10% of their maximum health in coins. Doesn't work on bosses. Can be found in Pirate Villages, or crafted at a Tungsten Workstation using 8 Gold Bars and 6 Tungsten Bars.

- Shadow Crystal: On kill, gain a temporary 20% damage bonus. Can be dropped by Reaper (Deep Forest Caves boss), or crafted at a Fallen Workstation using 18 Shadow Essence.

- Sandworm Tooth: Melee attacks have a chance to inflict a powerful poison, dealing additional damage. 5% chance to be dropped by Sandworm (Deep Desert Caves).

- Blood Crystal: On kill, you are healed by 5% of your maximum health. Can be dropped by enemies in the Graveyard incursion, or crafted at a Fallen Workstation using 16 Blood Essence and 8 Ruby.

- Necromancer's Ring: On kill, enemies are converted into a temporary melee summon that does not consume summon slots. Can be crafted at a Fallen Workstation using 6 Tungsten Bars and 10 tier 2 essence.
