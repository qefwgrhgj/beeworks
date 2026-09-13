# Bee Works: Wooden Beehives & AI Fix 🐝

[![Modrinth](https://img.shields.io/badge/Modrinth-Download-00AF5C?style=for-the-badge&logo=modrinth)](https://modrinth.com/mod/beeworks)
[![Minecraft Forge](https://img.shields.io/badge/Minecraft%20Forge-1.20.1-orange?style=for-the-badge)](https://files.minecraftforge.net/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)

**Bee Works** brings all wooden beehive variants to Minecraft 1.20.1 Forge without requiring heavy libraries like Blueprint! It includes full support for vanilla and modded wood types, seamless integration with **Every Compat (Wood Good)**, and integrates vital AI and pathfinding bugfixes from **The Bee Fix**.

---

## ✨ Features

### 🪵 Wooden Beehives for All Woods
Craft beehives matching every wood palette in the game:
- 🌲 **Spruce Beehive**
- ⚪ **Birch Beehive**
- 🌴 **Jungle Beehive**
- 🏜️ **Acacia Beehive**
- 🌑 **Dark Oak Beehive**
- 🌿 **Mangrove Beehive**
- 🌸 **Cherry Beehive**
- 🎋 **Bamboo Beehive**
- 🔴 **Crimson Beehive**
- 🔵 **Warped Beehive**

All beehives feature fully dynamic textures showing honey accumulation (levels 0 through 5) and front, side, and bottom textures.

### 🚫 Zero Blueprint Dependency
Unlike other mods that require Team Abnormals' Blueprint library, **Bee Works is completely standalone**. No extra background library mods required!

### 🔄 Every Compat (Wood Good) Integration
Supports modded tree types through Every Compat (Biomes O' Plenty, Regions Unexplored, Twilight Forest, etc.). Unlike buggy alternatives where bees get stuck or cannot enter/exit, Bee Works ensures:
- Proper `PointOfInterest` (POI) registration tagged in `#minecraft:point_of_interest_type/bee_home`.
- Active server-side `BeehiveBlockEntity` ticking so bees correctly produce honey and exit the hive.

### 🧠 The Bee Fix AI & Bug Fixes Integrated
Includes essential fixes for longstanding vanilla bee bugs:
- **MC-168329**: Fixes bees refusing to leave hives in the Nether and the End (skylight weather calculation fix).
- **MC-190042**: Fixes bees randomly falling to the ground when pathfinding stops (`noGravity` state preservation).
- **MC-206401**: Fixes the northwest wandering drift bias (`RandomPos` centering fix).
- **MC-234364**: Fixes bee death animation rotation (flips 180° instead of 90°).
- **Turtle Egg Protection**: Prevents bees from crushing turtle eggs when floating over them.

### 🔁 Drop-in Woodworks Migration
If you previously used Woodworks, Bee Works automatically remaps missing `woodworks:*_beehive` blocks and items on world load, so you won't lose a single hive!

---

## 🛠️ Crafting Recipes

Crafted just like vanilla beehives using any wood planks and honeycombs:
```text
[ Plank ] [ Plank ] [ Plank ]
[ Honey ] [ Honey ] [ Honey ]
[ Plank ] [ Plank ] [ Plank ]
```

---

## 📦 Compatibility & Tags
- Tagged under `#minecraft:beehives`, `#forge:beehives`, and `#blueprint:wooden_beehives`.
- Tagged under `#minecraft:mineable/axe`.
- POI registered under `#minecraft:point_of_interest_type/bee_home`.

## 👥 Authors & Credits
- **Authors**: Guardian, DSCHEL
- **Credits**: Team Abnormals (original Woodworks inspiration), lupicus (The Bee Fix AI improvements)

---

## 📜 License
Distributed under the **MIT License**.
