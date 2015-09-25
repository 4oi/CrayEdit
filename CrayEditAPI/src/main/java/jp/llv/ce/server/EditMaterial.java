/*
 * The MIT License
 *
 * Copyright 2015 Toyblocks.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jp.llv.ce.server;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * A material of an item or a block.
 * Not only vanilla materials, but also ones added by server mod.
 * @see Vanilla
 * @author Toyblocks
 */
public interface EditMaterial {

    String getDomain();

    String getID();

    default String getFullID() {
        return this.getDomain() + this.getID();
    }

    String getName(short meta);

    default String getName() {
        return this.getName((short) 0);
    }

    @Deprecated
    default short[] getLegacyID() {
        return new short[0];
    }

    boolean isValidMeta(short meta);

    boolean isPlaceable();

    boolean isHoldable();

    enum Vanilla implements EditMaterial {

        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Air")
        @Holdable
        @LegacyID(0)
        @Placeable
        AIR,
        @MetaRange(min = 0, max = 6)
        @Meta(val = 0, name = "Stone")
        @Meta(val = 1, name = "Granite")
        @Meta(val = 2, name = "Polished Granite")
        @Meta(val = 3, name = "Diorite")
        @Meta(val = 4, name = "Polished Diorite")
        @Meta(val = 5, name = "Andesite")
        @Meta(val = 6, name = "Polished Andesite")
        @Holdable
        @LegacyID(1)
        @Placeable
        STONE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Grass")
        @Holdable
        @LegacyID(2)
        @Placeable
        GRASS,
        @MetaRange(min = 0, max = 2)
        @Meta(val = 0, name = "Dirt")
        @Meta(val = 1, name = "Coarse Dirt")
        @Meta(val = 2, name = "Podzol")
        @Holdable
        @LegacyID(3)
        @Placeable
        DIRT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Cobblestone")
        @Holdable
        @LegacyID(4)
        @Placeable
        COBBLESTONE,
        @MetaRange(min = 0, max = 5)
        @Meta(val = 0, name = "Oak Wood Plank")
        @Meta(val = 1, name = "Spruce Wood Plank")
        @Meta(val = 2, name = "Birch Wood Plank")
        @Meta(val = 3, name = "Jungle Wood Plank")
        @Meta(val = 4, name = "Acacia Wood Plank")
        @Meta(val = 5, name = "Dark Oak Wood Plank")
        @Holdable
        @LegacyID(5)
        @Placeable
        PLANKS,
        @MetaRange(min = 0, max = 5)
        @Meta(val = 0, name = "Oak Sapling")
        @Meta(val = 1, name = "Spruce Sapling")
        @Meta(val = 2, name = "Birch Sapling")
        @Meta(val = 3, name = "Jungle Sapling")
        @Meta(val = 4, name = "Acacia Sapling")
        @Meta(val = 5, name = "Dark Oak Sapling")
        @Holdable
        @LegacyID(6)
        @Placeable
        SAPLING,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Bedrock")
        @Holdable
        @LegacyID(7)
        @Placeable
        BEDROCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Flowing Water")
        @Holdable
        @LegacyID(8)
        @Placeable
        FLOWING_WATER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Still Water")
        @Holdable
        @LegacyID(9)
        @Placeable
        WATER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Flowing Lava")
        @Holdable
        @LegacyID(10)
        @Placeable
        FLOWING_LAVA,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Still Lava")
        @Holdable
        @LegacyID(11)
        @Placeable
        LAVA,
        @MetaRange(min = 0, max = 1)
        @Meta(val = 0, name = "Sand")
        @Meta(val = 1, name = "Red Sand")
        @Holdable
        @LegacyID(12)
        @Placeable
        SAND,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Gravel")
        @Holdable
        @LegacyID(13)
        @Placeable
        GRAVEL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Gold Ore")
        @Holdable
        @LegacyID(14)
        @Placeable
        GOLD_ORE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Ore")
        @Holdable
        @LegacyID(15)
        @Placeable
        IRON_ORE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Coal Ore")
        @Holdable
        @LegacyID(16)
        @Placeable
        COAL_ORE,
        @MetaRange(min = 0, max = 3)
        @Meta(val = 0, name = "Oak Wood")
        @Meta(val = 1, name = "Spruce Wood")
        @Meta(val = 2, name = "Birch Wood")
        @Meta(val = 3, name = "Jungle Wood")
        @Holdable
        @LegacyID(17)
        @Placeable
        LOG,
        @MetaRange(min = 0, max = 3)
        @Meta(val = 0, name = "Oak Leaves")
        @Meta(val = 1, name = "Spruce Leaves")
        @Meta(val = 2, name = "Birch Leaves")
        @Meta(val = 3, name = "Jungle Leaves")
        @Holdable
        @LegacyID(18)
        @Placeable
        LEAVES,
        @MetaRange(min = 0, max = 1)
        @Meta(val = 0, name = "Sponge")
        @Meta(val = 1, name = "Wet Sponge")
        @Holdable
        @LegacyID(19)
        @Placeable
        SPONGE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Glass")
        @Holdable
        @LegacyID(20)
        @Placeable
        GLASS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Lapis Lazuli Ore")
        @Holdable
        @LegacyID(21)
        @Placeable
        LAPIS_ORE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Lapis Lazuli Block")
        @Holdable
        @LegacyID(22)
        @Placeable
        LAPIS_BLOCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Dispenser")
        @Holdable
        @LegacyID(23)
        @Placeable
        DISPENSER,
        @MetaRange(min = 0, max = 2)
        @Meta(val = 0, name = "Sandstone")
        @Meta(val = 1, name = "Chiseled Sandstone")
        @Meta(val = 2, name = "Smooth Sandstone")
        @Holdable
        @LegacyID(24)
        @Placeable
        SANDSTONE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Note Block")
        @Holdable
        @LegacyID(25)
        @Placeable
        NOTEBLOCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Bed")
        @Meta(val = 0, name = "Bed")
        @Holdable
        @LegacyID(26)
        @LegacyID(355)
        /*@NotPlaceable*/
        BED,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Powered Rail")
        @Holdable
        @LegacyID(27)
        @Placeable
        GOLDEN_RAIL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Detector Rail")
        @Holdable
        @LegacyID(28)
        @Placeable
        DETECTOR_RAIL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Sticky Piston")
        @Holdable
        @LegacyID(29)
        @Placeable
        STICKY_PISTON,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Cobweb")
        @Holdable
        @LegacyID(30)
        @Placeable
        WEB,
        @MetaRange(min = 0, max = 2)
        @Meta(val = 0, name = "Dead Shrub")
        @Meta(val = 1, name = "Grass")
        @Meta(val = 2, name = "Fern")
        @Holdable
        @LegacyID(31)
        @Placeable
        TALLGRASS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Dead Bush")
        @Holdable
        @LegacyID(32)
        @Placeable
        DEADBUSH,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Piston")
        @Holdable
        @LegacyID(33)
        @Placeable
        PISTON,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Piston Head")
        @Holdable
        @LegacyID(34)
        @Placeable
        PISTON_HEAD,
        @MetaRange(min = 0, max = 15)
        @Meta(val = 0, name = "White Wool")
        @Meta(val = 1, name = "Orange Wool")
        @Meta(val = 2, name = "Magenta Wool")
        @Meta(val = 3, name = "Light Blue Wool")
        @Meta(val = 4, name = "Yellow Wool")
        @Meta(val = 5, name = "Lime Wool")
        @Meta(val = 6, name = "Pink Wool")
        @Meta(val = 7, name = "Gray Wool")
        @Meta(val = 8, name = "Light Gray Wool")
        @Meta(val = 9, name = "Cyan Wool")
        @Meta(val = 10, name = "Purple Wool")
        @Meta(val = 11, name = "Blue Wool")
        @Meta(val = 12, name = "Brown Wool")
        @Meta(val = 13, name = "Green Wool")
        @Meta(val = 14, name = "Red Wool")
        @Meta(val = 15, name = "Black Wool")
        @Holdable
        @LegacyID(35)
        @Placeable
        WOOL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Dandelion")
        @Holdable
        @LegacyID(37)
        @Placeable
        YELLOW_FLOWER,
        @MetaRange(min = 0, max = 8)
        @Meta(val = 0, name = "Poppy")
        @Meta(val = 1, name = "Blue Orchid")
        @Meta(val = 2, name = "Allium")
        @Meta(val = 3, name = "Azure Bluet")
        @Meta(val = 4, name = "Red Tulip")
        @Meta(val = 5, name = "Orange Tulip")
        @Meta(val = 6, name = "White Tulip")
        @Meta(val = 7, name = "Pink Tulip")
        @Meta(val = 8, name = "Oxeye Daisy")
        @Holdable
        @LegacyID(38)
        @Placeable
        RED_FLOWER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Brown Mushroom")
        @Holdable
        @LegacyID(39)
        @Placeable
        BROWN_MUSHROOM,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Red Mushroom")
        @Holdable
        @LegacyID(40)
        @Placeable
        RED_MUSHROOM,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Gold Block")
        @Holdable
        @LegacyID(41)
        @Placeable
        GOLD_BLOCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Block")
        @Holdable
        @LegacyID(42)
        @Placeable
        IRON_BLOCK,
        @MetaRange(min = 0, max = 7)
        @Meta(val = 0, name = "Double Stone Slab")
        @Meta(val = 1, name = "Double Sandstone Slab")
        @Meta(val = 2, name = "Double Wooden Slab")
        @Meta(val = 3, name = "Double Cobblestone Slab")
        @Meta(val = 4, name = "Double Brick Slab")
        @Meta(val = 5, name = "Double Stone Brick Slab")
        @Meta(val = 6, name = "Double Nether Brick Slab")
        @Meta(val = 7, name = "Double Quartz Slab")
        @Holdable
        @LegacyID(43)
        @Placeable
        DOUBLE_STONE_SLAB,
        @MetaRange(min = 0, max = 7)
        @Meta(val = 0, name = "Stone Slab")
        @Meta(val = 1, name = "Sandstone Slab")
        @Meta(val = 2, name = "Wooden Slab")
        @Meta(val = 3, name = "Cobblestone Slab")
        @Meta(val = 4, name = "Brick Slab")
        @Meta(val = 5, name = "Stone Brick Slab")
        @Meta(val = 6, name = "Nether Brick Slab")
        @Meta(val = 7, name = "Quartz Slab")
        @Holdable
        @LegacyID(44)
        @Placeable
        STONE_SLAB,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Bricks")
        @Holdable
        @LegacyID(45)
        @Placeable
        BRICK_BLOCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "TNT")
        @Holdable
        @LegacyID(46)
        @Placeable
        TNT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Bookshelf")
        @Holdable
        @LegacyID(47)
        @Placeable
        BOOKSHELF,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Moss Stone")
        @Holdable
        @LegacyID(48)
        @Placeable
        MOSSY_COBBLESTONE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Obsidian")
        @Holdable
        @LegacyID(49)
        @Placeable
        OBSIDIAN,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Torch")
        @Holdable
        @LegacyID(50)
        @Placeable
        TORCH,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Fire")
        @Holdable
        @LegacyID(51)
        @Placeable
        FIRE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Monster Spawner")
        @Holdable
        @LegacyID(52)
        @Placeable
        MOB_SPAWNER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Oak Wood Stairs")
        @Holdable
        @LegacyID(53)
        @Placeable
        OAK_STAIRS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Chest")
        @Holdable
        @LegacyID(54)
        @Placeable
        CHEST,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Redstone Wire")
        @Holdable
        @LegacyID(55)
        @Placeable
        REDSTONE_WIRE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Diamond Ore")
        @Holdable
        @LegacyID(56)
        @Placeable
        DIAMOND_ORE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Diamond Block")
        @Holdable
        @LegacyID(57)
        @Placeable
        DIAMOND_BLOCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Crafting Table")
        @Holdable
        @LegacyID(58)
        @Placeable
        CRAFTING_TABLE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Wheat Crops")
        @Meta(val = 0, name = "Wheat")
        @Holdable
        @LegacyID(59)
        @LegacyID(296)
        /*@NotPlaceable*/
        WHEAT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Farmland")
        @Holdable
        @LegacyID(60)
        @Placeable
        FARMLAND,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Furnace")
        @Holdable
        @LegacyID(61)
        @Placeable
        FURNACE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Burning Furnace")
        @Holdable
        @LegacyID(62)
        @Placeable
        LIT_FURNACE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Standing Sign Block")
        @Holdable
        @LegacyID(63)
        @Placeable
        STANDING_SIGN,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Oak Door Block")
        @Meta(val = 0, name = "Oak Door")
        @Holdable
        @LegacyID(64)
        @LegacyID(324)
        /*@NotPlaceable*/
        WOODEN_DOOR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Ladder")
        @Holdable
        @LegacyID(65)
        @Placeable
        LADDER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Rail")
        @Holdable
        @LegacyID(66)
        @Placeable
        RAIL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Cobblestone Stairs")
        @Holdable
        @LegacyID(67)
        @Placeable
        STONE_STAIRS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Wall-mounted Sign Block")
        @Holdable
        @LegacyID(68)
        @Placeable
        WALL_SIGN,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Lever")
        @Holdable
        @LegacyID(69)
        @Placeable
        LEVER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Stone Pressure Plate")
        @Holdable
        @LegacyID(70)
        @Placeable
        STONE_PRESSURE_PLATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Door Block")
        @Meta(val = 0, name = "Iron Door")
        @Holdable
        @LegacyID(71)
        @LegacyID(330)
        /*@NotPlaceable*/
        IRON_DOOR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Wooden Pressure Plate")
        @Holdable
        @LegacyID(72)
        @Placeable
        WOODEN_PRESSURE_PLATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Redstone Ore")
        @Holdable
        @LegacyID(73)
        @Placeable
        REDSTONE_ORE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Glowing Redstone Ore")
        @Holdable
        @LegacyID(74)
        @Placeable
        LIT_REDSTONE_ORE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Redstone Torch (off)")
        @Holdable
        @LegacyID(75)
        @Placeable
        UNLIT_REDSTONE_TORCH,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Redstone Torch (on)")
        @Holdable
        @LegacyID(76)
        @Placeable
        REDSTONE_TORCH,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Stone Button")
        @Holdable
        @LegacyID(77)
        @Placeable
        STONE_BUTTON,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Snow")
        @Holdable
        @LegacyID(78)
        @Placeable
        SNOW_LAYER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Ice")
        @Holdable
        @LegacyID(79)
        @Placeable
        ICE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Snow Block")
        @Holdable
        @LegacyID(80)
        @Placeable
        SNOW,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Cactus")
        @Holdable
        @LegacyID(81)
        @Placeable
        CACTUS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Clay")
        @Holdable
        @LegacyID(82)
        @Placeable
        CLAY,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Sugar Canes")
        @Meta(val = 0, name = "Sugar Canes")
        @Holdable
        @LegacyID(83)
        @LegacyID(338)
        /*@NotPlaceable*/
        REEDS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Jukebox")
        @Holdable
        @LegacyID(84)
        @Placeable
        JUKEBOX,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Oak Fence")
        @Holdable
        @LegacyID(85)
        @Placeable
        FENCE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Pumpkin")
        @Holdable
        @LegacyID(86)
        @Placeable
        PUMPKIN,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Netherrack")
        @Holdable
        @LegacyID(87)
        @Placeable
        NETHERRACK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Soul Sand")
        @Holdable
        @LegacyID(88)
        @Placeable
        SOUL_SAND,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Glowstone")
        @Holdable
        @LegacyID(89)
        @Placeable
        GLOWSTONE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Nether Portal")
        @Holdable
        @LegacyID(90)
        @Placeable
        PORTAL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Jack o'Lantern")
        @Holdable
        @LegacyID(91)
        @Placeable
        LIT_PUMPKIN,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Cake Block")
        @Meta(val = 0, name = "Cake")
        @Holdable
        @LegacyID(92)
        @LegacyID(354)
        /*@NotPlaceable*/
        CAKE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Redstone Repeater Block (off)")
        @Holdable
        @LegacyID(93)
        @Placeable
        UNPOWERED_REPEATER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Redstone Repeater Block (on)")
        @Holdable
        @LegacyID(94)
        @Placeable
        POWERED_REPEATER,
        @MetaRange(min = 0, max = 15)
        @Meta(val = 0, name = "White Stained Glass")
        @Meta(val = 1, name = "Orange Stained Glass")
        @Meta(val = 2, name = "Magenta Stained Glass")
        @Meta(val = 3, name = "Light Blue Stained Glass")
        @Meta(val = 4, name = "Yellow Stained Glass")
        @Meta(val = 5, name = "Lime Stained Glass")
        @Meta(val = 6, name = "Pink Stained Glass")
        @Meta(val = 7, name = "Gray Stained Glass")
        @Meta(val = 8, name = "Light Gray Stained Glass")
        @Meta(val = 9, name = "Cyan Stained Glass")
        @Meta(val = 10, name = "Purple Stained Glass")
        @Meta(val = 11, name = "Blue Stained Glass")
        @Meta(val = 12, name = "Brown Stained Glass")
        @Meta(val = 13, name = "Green Stained Glass")
        @Meta(val = 14, name = "Red Stained Glass")
        @Meta(val = 15, name = "Black Stained Glass")
        @Holdable
        @LegacyID(95)
        @Placeable
        STAINED_GLASS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Wooden Trapdoor")
        @Holdable
        @LegacyID(96)
        @Placeable
        TRAPDOOR,
        @MetaRange(min = 0, max = 5)
        @Meta(val = 0, name = "Stone Monster Egg")
        @Meta(val = 1, name = "Cobblestone Monster Egg")
        @Meta(val = 2, name = "Stone Brick Monster Egg")
        @Meta(val = 3, name = "Mossy Stone Brick Monster Egg")
        @Meta(val = 4, name = "Cracked Stone Brick Monster Egg")
        @Meta(val = 5, name = "Chiseled Stone Brick Monster Egg")
        @Holdable
        @LegacyID(97)
        @Placeable
        MONSTER_EGG,
        @MetaRange(min = 0, max = 3)
        @Meta(val = 0, name = "Stone Bricks")
        @Meta(val = 1, name = "Mossy Stone Bricks")
        @Meta(val = 2, name = "Cracked Stone Bricks")
        @Meta(val = 3, name = "Chiseled Stone Bricks")
        @Holdable
        @LegacyID(98)
        @Placeable
        STONEBRICK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Brown Mushroom Block")
        @Holdable
        @LegacyID(99)
        @Placeable
        BROWN_MUSHROOM_BLOCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Red Mushroom Block")
        @Holdable
        @LegacyID(100)
        @Placeable
        RED_MUSHROOM_BLOCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Bars")
        @Holdable
        @LegacyID(101)
        @Placeable
        IRON_BARS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Glass Pane")
        @Holdable
        @LegacyID(102)
        @Placeable
        GLASS_PANE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Melon Block")
        @Holdable
        @LegacyID(103)
        @Placeable
        MELON_BLOCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Pumpkin Stem")
        @Holdable
        @LegacyID(104)
        @Placeable
        PUMPKIN_STEM,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Melon Stem")
        @Holdable
        @LegacyID(105)
        @Placeable
        MELON_STEM,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Vines")
        @Holdable
        @LegacyID(106)
        @Placeable
        VINE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Oak Fence Gate")
        @Holdable
        @LegacyID(107)
        @Placeable
        FENCE_GATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Brick Stairs")
        @Holdable
        @LegacyID(108)
        @Placeable
        BRICK_STAIRS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Stone Brick Stairs")
        @Holdable
        @LegacyID(109)
        @Placeable
        STONE_BRICK_STAIRS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Mycelium")
        @Holdable
        @LegacyID(110)
        @Placeable
        MYCELIUM,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Lily Pad")
        @Holdable
        @LegacyID(111)
        @Placeable
        WATERLILY,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Nether Brick")
        @Holdable
        @LegacyID(112)
        @Placeable
        NETHER_BRICK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Nether Brick Fence")
        @Holdable
        @LegacyID(113)
        @Placeable
        NETHER_BRICK_FENCE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Nether Brick Stairs")
        @Holdable
        @LegacyID(114)
        @Placeable
        NETHER_BRICK_STAIRS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Nether Wart")
        @Meta(val = 0, name = "Nether Wart")
        @Holdable
        @LegacyID(115)
        @LegacyID(372)
        /*@NotPlaceable*/
        NETHER_WART,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Enchantment Table")
        @Holdable
        @LegacyID(116)
        @Placeable
        ENCHANTING_TABLE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Brewing Stand")
        @Meta(val = 0, name = "Brewing Stand")
        @Holdable
        @LegacyID(117)
        @LegacyID(379)
        /*@NotPlaceable*/
        BREWING_STAND,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Cauldron")
        @Meta(val = 0, name = "Cauldron")
        @Holdable
        @LegacyID(118)
        @LegacyID(380)
        /*@NotPlaceable*/
        CAULDRON,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "End Portal")
        @Holdable
        @LegacyID(119)
        @Placeable
        END_PORTAL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "End Portal Frame")
        @Holdable
        @LegacyID(120)
        @Placeable
        END_PORTAL_FRAME,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "End Stone")
        @Holdable
        @LegacyID(121)
        @Placeable
        END_STONE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Dragon Egg")
        @Holdable
        @LegacyID(122)
        @Placeable
        DRAGON_EGG,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Redstone Lamp (inactive)")
        @Holdable
        @LegacyID(123)
        @Placeable
        REDSTONE_LAMP,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Redstone Lamp (active)")
        @Holdable
        @LegacyID(124)
        @Placeable
        LIT_REDSTONE_LAMP,
        @MetaRange(min = 0, max = 5)
        @Meta(val = 0, name = "Double Oak Wood Slab")
        @Meta(val = 1, name = "Double Spruce Wood Slab")
        @Meta(val = 2, name = "Double Birch Wood Slab")
        @Meta(val = 3, name = "Double Jungle Wood Slab")
        @Meta(val = 4, name = "Double Acacia Wood Slab")
        @Meta(val = 5, name = "Double Dark Oak Wood Slab")
        @Holdable
        @LegacyID(125)
        @Placeable
        DOUBLE_WOODEN_SLAB,
        @MetaRange(min = 0, max = 5)
        @Meta(val = 0, name = "Oak Wood Slab")
        @Meta(val = 1, name = "Spruce Wood Slab")
        @Meta(val = 2, name = "Birch Wood Slab")
        @Meta(val = 3, name = "Jungle Wood Slab")
        @Meta(val = 4, name = "Acacia Wood Slab")
        @Meta(val = 5, name = "Dark Oak Wood Slab")
        @Holdable
        @LegacyID(126)
        @Placeable
        WOODEN_SLAB,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Cocoa")
        @Holdable
        @LegacyID(127)
        @Placeable
        COCOA,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Sandstone Stairs")
        @Holdable
        @LegacyID(128)
        @Placeable
        SANDSTONE_STAIRS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Emerald Ore")
        @Holdable
        @LegacyID(129)
        @Placeable
        EMERALD_ORE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Ender Chest")
        @Holdable
        @LegacyID(130)
        @Placeable
        ENDER_CHEST,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Tripwire Hook")
        @Meta(val = 0, name = "Tripwire")
        @Holdable
        @LegacyID(131)
        @LegacyID(132)
        @Placeable
        TRIPWIRE_HOOK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Emerald Block")
        @Holdable
        @LegacyID(133)
        @Placeable
        EMERALD_BLOCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Spruce Wood Stairs")
        @Holdable
        @LegacyID(134)
        @Placeable
        SPRUCE_STAIRS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Birch Wood Stairs")
        @Holdable
        @LegacyID(135)
        @Placeable
        BIRCH_STAIRS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Jungle Wood Stairs")
        @Holdable
        @LegacyID(136)
        @Placeable
        JUNGLE_STAIRS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Command Block")
        @Holdable
        @LegacyID(137)
        @Placeable
        COMMAND_BLOCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Beacon")
        @Holdable
        @LegacyID(138)
        @Placeable
        BEACON,
        @MetaRange(min = 0, max = 1)
        @Meta(val = 0, name = "Cobblestone Wall")
        @Meta(val = 1, name = "Mossy Cobblestone Wall")
        @Holdable
        @LegacyID(139)
        @Placeable
        COBBLESTONE_WALL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Flower Pot")
        @Meta(val = 0, name = "Flower Pot")
        @Holdable
        @LegacyID(140)
        @LegacyID(390)
        /*@NotPlaceable*/
        FLOWER_POT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Carrots")
        @Holdable
        @LegacyID(141)
        @Placeable
        CARROTS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Potatoes")
        @Holdable
        @LegacyID(142)
        @Placeable
        POTATOES,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Wooden Button")
        @Holdable
        @LegacyID(143)
        @Placeable
        WOODEN_BUTTON,
        @MetaRange(min = 0, max = 4)
        @Meta(val = 0, name = "Mob Head")
        @Meta(val = 0, name = "Mob Head (Skeleton)")
        @Meta(val = 1, name = "Mob Head (Wither Skeleton)")
        @Meta(val = 2, name = "Mob Head (Zombie)")
        @Meta(val = 3, name = "Mob Head (Human)")
        @Meta(val = 4, name = "Mob Head (Creeper)")
        @Holdable
        @LegacyID(144)
        @LegacyID(397)
        /*@NotPlaceable*/
        SKULL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Anvil")
        @Holdable
        @LegacyID(145)
        @Placeable
        ANVIL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Trapped Chest")
        @Holdable
        @LegacyID(146)
        @Placeable
        TRAPPED_CHEST,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Weighted Pressure Plate (light)")
        @Holdable
        @LegacyID(147)
        @Placeable
        LIGHT_WEIGHTED_PRESSURE_PLATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Weighted Pressure Plate (heavy)")
        @Holdable
        @LegacyID(148)
        @Placeable
        HEAVY_WEIGHTED_PRESSURE_PLATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Redstone Comparator (inactive)")
        @Holdable
        @LegacyID(149)
        @Placeable
        UNPOWERED_COMPARATOR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Redstone Comparator (active)")
        @Holdable
        @LegacyID(150)
        @Placeable
        POWERED_COMPARATOR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Daylight Sensor")
        @Holdable
        @LegacyID(151)
        @Placeable
        DAYLIGHT_DETECTOR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Redstone Block")
        @Holdable
        @LegacyID(152)
        @Placeable
        REDSTONE_BLOCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Nether Quartz Ore")
        @Holdable
        @LegacyID(153)
        @Placeable
        QUARTZ_ORE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Hopper")
        @Holdable
        @LegacyID(154)
        @Placeable
        HOPPER,
        @MetaRange(min = 0, max = 2)
        @Meta(val = 0, name = "Quartz Block")
        @Meta(val = 1, name = "Chiseled Quartz Block")
        @Meta(val = 2, name = "Pillar Quartz Block")
        @Holdable
        @LegacyID(155)
        @Placeable
        QUARTZ_BLOCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Quartz Stairs")
        @Holdable
        @LegacyID(156)
        @Placeable
        QUARTZ_STAIRS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Activator Rail")
        @Holdable
        @LegacyID(157)
        @Placeable
        ACTIVATOR_RAIL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Dropper")
        @Holdable
        @LegacyID(158)
        @Placeable
        DROPPER,
        @MetaRange(min = 0, max = 15)
        @Meta(val = 0, name = "White Stained Clay")
        @Meta(val = 1, name = "Orange Stained Clay")
        @Meta(val = 2, name = "Magenta Stained Clay")
        @Meta(val = 3, name = "Light Blue Stained Clay")
        @Meta(val = 4, name = "Yellow Stained Clay")
        @Meta(val = 5, name = "Lime Stained Clay")
        @Meta(val = 6, name = "Pink Stained Clay")
        @Meta(val = 7, name = "Gray Stained Clay")
        @Meta(val = 8, name = "Light Gray Stained Clay")
        @Meta(val = 9, name = "Cyan Stained Clay")
        @Meta(val = 10, name = "Purple Stained Clay")
        @Meta(val = 11, name = "Blue Stained Clay")
        @Meta(val = 12, name = "Brown Stained Clay")
        @Meta(val = 13, name = "Green Stained Clay")
        @Meta(val = 14, name = "Red Stained Clay")
        @Meta(val = 15, name = "Black Stained Clay")
        @Holdable
        @LegacyID(159)
        @Placeable
        STAINED_HARDENED_CLAY,
        @MetaRange(min = 0, max = 15)
        @Meta(val = 0, name = "White Stained Glass Pane")
        @Meta(val = 1, name = "Orange Stained Glass Pane")
        @Meta(val = 2, name = "Magenta Stained Glass Pane")
        @Meta(val = 3, name = "Light Blue Stained Glass Pane")
        @Meta(val = 4, name = "Yellow Stained Glass Pane")
        @Meta(val = 5, name = "Lime Stained Glass Pane")
        @Meta(val = 6, name = "Pink Stained Glass Pane")
        @Meta(val = 7, name = "Gray Stained Glass Pane")
        @Meta(val = 8, name = "Light Gray Stained Glass Pane")
        @Meta(val = 9, name = "Cyan Stained Glass Pane")
        @Meta(val = 10, name = "Purple Stained Glass Pane")
        @Meta(val = 11, name = "Blue Stained Glass Pane")
        @Meta(val = 12, name = "Brown Stained Glass Pane")
        @Meta(val = 13, name = "Green Stained Glass Pane")
        @Meta(val = 14, name = "Red Stained Glass Pane")
        @Meta(val = 15, name = "Black Stained Glass Pane")
        @Holdable
        @LegacyID(160)
        @Placeable
        STAINED_GLASS_PANE,
        @MetaRange(min = 0, max = 1)
        @Meta(val = 0, name = "Acacia Leaves")
        @Meta(val = 1, name = "Dark Oak Leaves")
        @Holdable
        @LegacyID(161)
        @Placeable
        LEAVES2,
        @MetaRange(min = 0, max = 1)
        @Meta(val = 0, name = "Acacia Wood")
        @Meta(val = 1, name = "Dark Oak Wood")
        @Holdable
        @LegacyID(162)
        @Placeable
        LOG2,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Acacia Wood Stairs")
        @Holdable
        @LegacyID(163)
        @Placeable
        ACACIA_STAIRS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Dark Oak Wood Stairs")
        @Holdable
        @LegacyID(164)
        @Placeable
        DARK_OAK_STAIRS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Slime Block")
        @Holdable
        @LegacyID(165)
        @Placeable
        SLIME,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Barrier")
        @Holdable
        @LegacyID(166)
        @Placeable
        BARRIER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Trapdoor")
        @Holdable
        @LegacyID(167)
        @Placeable
        IRON_TRAPDOOR,
        @MetaRange(min = 0, max = 2)
        @Meta(val = 0, name = "Prismarine")
        @Meta(val = 1, name = "Prismarine Bricks")
        @Meta(val = 2, name = "Dark Prismarine")
        @Holdable
        @LegacyID(168)
        @Placeable
        PRISMARINE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Sea Lantern")
        @Holdable
        @LegacyID(169)
        @Placeable
        SEA_LANTERN,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Hay Bale")
        @Holdable
        @LegacyID(170)
        @Placeable
        HAY_BLOCK,
        @MetaRange(min = 0, max = 15)
        @Meta(val = 0, name = "White Carpet")
        @Meta(val = 1, name = "Orange Carpet")
        @Meta(val = 2, name = "Magenta Carpet")
        @Meta(val = 3, name = "Light Blue Carpet")
        @Meta(val = 4, name = "Yellow Carpet")
        @Meta(val = 5, name = "Lime Carpet")
        @Meta(val = 6, name = "Pink Carpet")
        @Meta(val = 7, name = "Gray Carpet")
        @Meta(val = 8, name = "Light Gray Carpet")
        @Meta(val = 9, name = "Cyan Carpet")
        @Meta(val = 10, name = "Purple Carpet")
        @Meta(val = 11, name = "Blue Carpet")
        @Meta(val = 12, name = "Brown Carpet")
        @Meta(val = 13, name = "Green Carpet")
        @Meta(val = 14, name = "Red Carpet")
        @Meta(val = 15, name = "Black Carpet")
        @Holdable
        @LegacyID(171)
        @Placeable
        CARPET,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Hardened Clay")
        @Holdable
        @LegacyID(172)
        @Placeable
        HARDENED_CLAY,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Block of Coal")
        @Holdable
        @LegacyID(173)
        @Placeable
        COAL_BLOCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Packed Ice")
        @Holdable
        @LegacyID(174)
        @Placeable
        PACKED_ICE,
        @MetaRange(min = 0, max = 5)
        @Meta(val = 0, name = "Sunflower")
        @Meta(val = 1, name = "Lilac")
        @Meta(val = 2, name = "Double Tallgrass")
        @Meta(val = 3, name = "Large Fern")
        @Meta(val = 4, name = "Rose Bush")
        @Meta(val = 5, name = "Peony")
        @Holdable
        @LegacyID(175)
        @Placeable
        DOUBLE_PLANT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Free-standing Banner")
        @Holdable
        @LegacyID(176)
        @Placeable
        STANDING_BANNER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Wall-mounted Banner")
        @Holdable
        @LegacyID(177)
        @Placeable
        WALL_BANNER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Inverted Daylight Sensor")
        @Holdable
        @LegacyID(178)
        @Placeable
        DAYLIGHT_DETECTOR_INVERTED,
        @MetaRange(min = 0, max = 2)
        @Meta(val = 0, name = "Red Sandstone")
        @Meta(val = 1, name = "Chiseled Red Sandstone")
        @Meta(val = 2, name = "Smooth Red Sandstone")
        @Holdable
        @LegacyID(179)
        @Placeable
        RED_SANDSTONE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Red Sandstone Stairs")
        @Holdable
        @LegacyID(180)
        @Placeable
        RED_SANDSTONE_STAIRS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Double Red Sandstone Slab")
        @Holdable
        @LegacyID(181)
        @Placeable
        STONE_SLAB2,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Red Sandstone Slab")
        @Holdable
        @LegacyID(182)
        @Placeable
        DOUBLE_STONE_SLAB2,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Spruce Fence Gate")
        @Holdable
        @LegacyID(183)
        @Placeable
        SPRUCE_FENCE_GATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Birch Fence Gate")
        @Holdable
        @LegacyID(184)
        @Placeable
        BIRCH_FENCE_GATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Jungle Fence Gate")
        @Holdable
        @LegacyID(185)
        @Placeable
        JUNGLE_FENCE_GATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Dark Oak Fence Gate")
        @Holdable
        @LegacyID(186)
        @Placeable
        DARK_OAK_FENCE_GATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Acacia Fence Gate")
        @Holdable
        @LegacyID(187)
        @Placeable
        ACACIA_FENCE_GATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Spruce Fence")
        @Holdable
        @LegacyID(188)
        @Placeable
        SPRUCE_FENCE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Birch Fence")
        @Holdable
        @LegacyID(189)
        @Placeable
        BIRCH_FENCE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Jungle Fence")
        @Holdable
        @LegacyID(190)
        @Placeable
        JUNGLE_FENCE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Dark Oak Fence")
        @Holdable
        @LegacyID(191)
        @Placeable
        DARK_OAK_FENCE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Acacia Fence")
        @Holdable
        @LegacyID(192)
        @Placeable
        ACACIA_FENCE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Spruce Door Block")
        @Meta(val = 0, name = "Spruce Door")
        @Holdable
        @LegacyID(193)
        @LegacyID(427)
        /*@NotPlaceable*/
        SPRUCE_DOOR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Birch Door Block")
        @Meta(val = 0, name = "Birch Door")
        @Holdable
        @LegacyID(194)
        @LegacyID(428)
        /*@NotPlaceable*/
        BIRCH_DOOR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Jungle Door Block")
        @Meta(val = 0, name = "Jungle Door")
        @Holdable
        @LegacyID(195)
        @LegacyID(429)
        /*@NotPlaceable*/
        JUNGLE_DOOR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Acacia Door Block")
        @Meta(val = 0, name = "Acacia Door")
        @Holdable
        @LegacyID(196)
        @LegacyID(430)
        /*@NotPlaceable*/
        ACACIA_DOOR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Dark Oak Door Block")
        @Meta(val = 0, name = "Dark Oak Door")
        @Holdable
        @LegacyID(197)
        @LegacyID(431)
        /*@NotPlaceable*/
        DARK_OAK_DOOR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Shovel")
        @Holdable
        @LegacyID(256)
        /*@NotPlaceable*/
        IRON_SHOVEL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Pickaxe")
        @Holdable
        @LegacyID(257)
        /*@NotPlaceable*/
        IRON_PICKAXE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Axe")
        @Holdable
        @LegacyID(258)
        /*@NotPlaceable*/
        IRON_AXE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Flint and Steel")
        @Holdable
        @LegacyID(259)
        /*@NotPlaceable*/
        FLINT_AND_STEEL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Apple")
        @Holdable
        @LegacyID(260)
        /*@NotPlaceable*/
        APPLE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Bow")
        @Holdable
        @LegacyID(261)
        /*@NotPlaceable*/
        BOW,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Arrow")
        @Holdable
        @LegacyID(262)
        /*@NotPlaceable*/
        ARROW,
        @MetaRange(min = 0, max = 1)
        @Meta(val = 0, name = "Coal")
        @Meta(val = 1, name = "Charcoal")
        @Holdable
        @LegacyID(263)
        /*@NotPlaceable*/
        COAL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Diamond")
        @Holdable
        @LegacyID(264)
        /*@NotPlaceable*/
        DIAMOND,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Ingot")
        @Holdable
        @LegacyID(265)
        /*@NotPlaceable*/
        IRON_INGOT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Gold Ingot")
        @Holdable
        @LegacyID(266)
        /*@NotPlaceable*/
        GOLD_INGOT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Sword")
        @Holdable
        @LegacyID(267)
        /*@NotPlaceable*/
        IRON_SWORD,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Wooden Sword")
        @Holdable
        @LegacyID(268)
        /*@NotPlaceable*/
        WOODEN_SWORD,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Wooden Shovel")
        @Holdable
        @LegacyID(269)
        /*@NotPlaceable*/
        WOODEN_SHOVEL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Wooden Pickaxe")
        @Holdable
        @LegacyID(270)
        /*@NotPlaceable*/
        WOODEN_PICKAXE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Wooden Axe")
        @Holdable
        @LegacyID(271)
        /*@NotPlaceable*/
        WOODEN_AXE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Stone Sword")
        @Holdable
        @LegacyID(272)
        /*@NotPlaceable*/
        STONE_SWORD,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Stone Shovel")
        @Holdable
        @LegacyID(273)
        /*@NotPlaceable*/
        STONE_SHOVEL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Stone Pickaxe")
        @Holdable
        @LegacyID(274)
        /*@NotPlaceable*/
        STONE_PICKAXE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Stone Axe")
        @Holdable
        @LegacyID(275)
        /*@NotPlaceable*/
        STONE_AXE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Diamond Sword")
        @Holdable
        @LegacyID(276)
        /*@NotPlaceable*/
        DIAMOND_SWORD,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Diamond Shovel")
        @Holdable
        @LegacyID(277)
        /*@NotPlaceable*/
        DIAMOND_SHOVEL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Diamond Pickaxe")
        @Holdable
        @LegacyID(278)
        /*@NotPlaceable*/
        DIAMOND_PICKAXE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Diamond Axe")
        @Holdable
        @LegacyID(279)
        /*@NotPlaceable*/
        DIAMOND_AXE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Stick")
        @Holdable
        @LegacyID(280)
        /*@NotPlaceable*/
        STICK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Bowl")
        @Holdable
        @LegacyID(281)
        /*@NotPlaceable*/
        BOWL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Mushroom Stew")
        @Holdable
        @LegacyID(282)
        /*@NotPlaceable*/
        MUSHROOM_STEW,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Golden Sword")
        @Holdable
        @LegacyID(283)
        /*@NotPlaceable*/
        GOLDEN_SWORD,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Golden Shovel")
        @Holdable
        @LegacyID(284)
        /*@NotPlaceable*/
        GOLDEN_SHOVEL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Golden Pickaxe")
        @Holdable
        @LegacyID(285)
        /*@NotPlaceable*/
        GOLDEN_PICKAXE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Golden Axe")
        @Holdable
        @LegacyID(286)
        /*@NotPlaceable*/
        GOLDEN_AXE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "String")
        @Holdable
        @LegacyID(287)
        /*@NotPlaceable*/
        STRING,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Feather")
        @Holdable
        @LegacyID(288)
        /*@NotPlaceable*/
        FEATHER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Gunpowder")
        @Holdable
        @LegacyID(289)
        /*@NotPlaceable*/
        GUNPOWDER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Wooden Hoe")
        @Holdable
        @LegacyID(290)
        /*@NotPlaceable*/
        WOODEN_HOE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Stone Hoe")
        @Holdable
        @LegacyID(291)
        /*@NotPlaceable*/
        STONE_HOE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Hoe")
        @Holdable
        @LegacyID(292)
        /*@NotPlaceable*/
        IRON_HOE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Diamond Hoe")
        @Holdable
        @LegacyID(293)
        /*@NotPlaceable*/
        DIAMOND_HOE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Golden Hoe")
        @Holdable
        @LegacyID(294)
        /*@NotPlaceable*/
        GOLDEN_HOE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Wheat Seeds")
        @Holdable
        @LegacyID(295)
        /*@NotPlaceable*/
        WHEAT_SEEDS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Bread")
        @Holdable
        @LegacyID(297)
        /*@NotPlaceable*/
        BREAD,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Leather Helmet")
        @Holdable
        @LegacyID(298)
        /*@NotPlaceable*/
        LEATHER_HELMET,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Leather Tunic")
        @Holdable
        @LegacyID(299)
        /*@NotPlaceable*/
        LEATHER_CHESTPLATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Leather Pants")
        @Holdable
        @LegacyID(300)
        /*@NotPlaceable*/
        LEATHER_LEGGINGS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Leather Boots")
        @Holdable
        @LegacyID(301)
        /*@NotPlaceable*/
        LEATHER_BOOTS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Chainmail Helmet")
        @Holdable
        @LegacyID(302)
        /*@NotPlaceable*/
        CHAINMAIL_HELMET,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Chainmail Chestplate")
        @Holdable
        @LegacyID(303)
        /*@NotPlaceable*/
        CHAINMAIL_CHESTPLATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Chainmail Leggings")
        @Holdable
        @LegacyID(304)
        /*@NotPlaceable*/
        CHAINMAIL_LEGGINGS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Chainmail Boots")
        @Holdable
        @LegacyID(305)
        /*@NotPlaceable*/
        CHAINMAIL_BOOTS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Helmet")
        @Holdable
        @LegacyID(306)
        /*@NotPlaceable*/
        IRON_HELMET,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Chestplate")
        @Holdable
        @LegacyID(307)
        /*@NotPlaceable*/
        IRON_CHESTPLATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Leggings")
        @Holdable
        @LegacyID(308)
        /*@NotPlaceable*/
        IRON_LEGGINGS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Boots")
        @Holdable
        @LegacyID(309)
        /*@NotPlaceable*/
        IRON_BOOTS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Diamond Helmet")
        @Holdable
        @LegacyID(310)
        /*@NotPlaceable*/
        DIAMOND_HELMET,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Diamond Chestplate")
        @Holdable
        @LegacyID(311)
        /*@NotPlaceable*/
        DIAMOND_CHESTPLATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Diamond Leggings")
        @Holdable
        @LegacyID(312)
        /*@NotPlaceable*/
        DIAMOND_LEGGINGS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Diamond Boots")
        @Holdable
        @LegacyID(313)
        /*@NotPlaceable*/
        DIAMOND_BOOTS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Golden Helmet")
        @Holdable
        @LegacyID(314)
        /*@NotPlaceable*/
        GOLDEN_HELMET,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Golden Chestplate")
        @Holdable
        @LegacyID(315)
        /*@NotPlaceable*/
        GOLDEN_CHESTPLATE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Golden Leggings")
        @Holdable
        @LegacyID(316)
        /*@NotPlaceable*/
        GOLDEN_LEGGINGS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Golden Boots")
        @Holdable
        @LegacyID(317)
        /*@NotPlaceable*/
        GOLDEN_BOOTS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Flint")
        @Holdable
        @LegacyID(318)
        /*@NotPlaceable*/
        FLINT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Raw Porkchop")
        @Holdable
        @LegacyID(319)
        /*@NotPlaceable*/
        PORKCHOP,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Cooked Porkchop")
        @Holdable
        @LegacyID(320)
        /*@NotPlaceable*/
        COOKED_PORKCHOP,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Painting")
        @Holdable
        @LegacyID(321)
        /*@NotPlaceable*/
        PAINTING,
        @MetaRange(min = 0, max = 1)
        @Meta(val = 0, name = "Golden Apple")
        @Meta(val = 1, name = "Enchanted Golden Apple")
        @Holdable
        @LegacyID(322)
        /*@NotPlaceable*/
        GOLDEN_APPLE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Sign")
        @Holdable
        @LegacyID(323)
        /*@NotPlaceable*/
        SIGN,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Bucket")
        @Holdable
        @LegacyID(325)
        /*@NotPlaceable*/
        BUCKET,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Water Bucket")
        @Holdable
        @LegacyID(326)
        /*@NotPlaceable*/
        WATER_BUCKET,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Lava Bucket")
        @Holdable
        @LegacyID(327)
        /*@NotPlaceable*/
        LAVA_BUCKET,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Minecart")
        @Holdable
        @LegacyID(328)
        /*@NotPlaceable*/
        MINECART,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Saddle")
        @Holdable
        @LegacyID(329)
        /*@NotPlaceable*/
        SADDLE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Redstone")
        @Holdable
        @LegacyID(331)
        /*@NotPlaceable*/
        REDSTONE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Snowball")
        @Holdable
        @LegacyID(332)
        /*@NotPlaceable*/
        SNOWBALL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Boat")
        @Holdable
        @LegacyID(333)
        /*@NotPlaceable*/
        BOAT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Leather")
        @Holdable
        @LegacyID(334)
        /*@NotPlaceable*/
        LEATHER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Milk Bucket")
        @Holdable
        @LegacyID(335)
        /*@NotPlaceable*/
        MILK_BUCKET,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Brick")
        @Holdable
        @LegacyID(336)
        /*@NotPlaceable*/
        BRICK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Clay")
        @Holdable
        @LegacyID(337)
        /*@NotPlaceable*/
        CLAY_BALL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Paper")
        @Holdable
        @LegacyID(339)
        /*@NotPlaceable*/
        PAPER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Book")
        @Holdable
        @LegacyID(340)
        /*@NotPlaceable*/
        BOOK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Slimeball")
        @Holdable
        @LegacyID(341)
        /*@NotPlaceable*/
        SLIME_BALL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Minecart with Chest")
        @Holdable
        @LegacyID(342)
        /*@NotPlaceable*/
        CHEST_MINECART,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Minecart with Furnace")
        @Holdable
        @LegacyID(343)
        /*@NotPlaceable*/
        FURNACE_MINECART,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Egg")
        @Holdable
        @LegacyID(344)
        /*@NotPlaceable*/
        EGG,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Compass")
        @Holdable
        @LegacyID(345)
        /*@NotPlaceable*/
        COMPASS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Fishing Rod")
        @Holdable
        @LegacyID(346)
        /*@NotPlaceable*/
        FISHING_ROD,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Clock")
        @Holdable
        @LegacyID(347)
        /*@NotPlaceable*/
        CLOCK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Glowstone Dust")
        @Holdable
        @LegacyID(348)
        /*@NotPlaceable*/
        GLOWSTONE_DUST,
        @MetaRange(min = 0, max = 3)
        @Meta(val = 0, name = "Raw Fish")
        @Meta(val = 1, name = "Raw Salmon")
        @Meta(val = 2, name = "Clownfish")
        @Meta(val = 3, name = "Pufferfish")
        @Holdable
        @LegacyID(349)
        /*@NotPlaceable*/
        FISH,
        @MetaRange(min = 0, max = 1)
        @Meta(val = 0, name = "Cooked Fish")
        @Meta(val = 1, name = "Cooked Salmon")
        @Holdable
        @LegacyID(350)
        /*@NotPlaceable*/
        COOKED_FISH,
        @MetaRange(min = 0, max = 15)
        @Meta(val = 0, name = "Ink Sack")
        @Meta(val = 1, name = "Rose Red")
        @Meta(val = 2, name = "Cactus Green")
        @Meta(val = 3, name = "Coco Beans")
        @Meta(val = 4, name = "Lapis Lazuli")
        @Meta(val = 5, name = "Purple Dye")
        @Meta(val = 6, name = "Cyan Dye")
        @Meta(val = 7, name = "Light Gray Dye")
        @Meta(val = 8, name = "Gray Dye")
        @Meta(val = 9, name = "Pink Dye")
        @Meta(val = 10, name = "Lime Dye")
        @Meta(val = 11, name = "Dandelion Yellow")
        @Meta(val = 12, name = "Light Blue Dye")
        @Meta(val = 13, name = "Magenta Dye")
        @Meta(val = 14, name = "Orange Dye")
        @Meta(val = 15, name = "Bone Meal")
        @Holdable
        @LegacyID(351)
        /*@NotPlaceable*/
        DYE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Bone")
        @Holdable
        @LegacyID(352)
        /*@NotPlaceable*/
        BONE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Sugar")
        @Holdable
        @LegacyID(353)
        /*@NotPlaceable*/
        SUGAR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Redstone Repeater")
        @Holdable
        @LegacyID(356)
        /*@NotPlaceable*/
        REPEATER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Cookie")
        @Holdable
        @LegacyID(357)
        /*@NotPlaceable*/
        COOKIE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Map")
        @Holdable
        @LegacyID(358)
        /*@NotPlaceable*/
        FILLED_MAP,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Shears")
        @Holdable
        @LegacyID(359)
        /*@NotPlaceable*/
        SHEARS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Melon")
        @Holdable
        @LegacyID(360)
        /*@NotPlaceable*/
        MELON,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Pumpkin Seeds")
        @Holdable
        @LegacyID(361)
        /*@NotPlaceable*/
        PUMPKIN_SEEDS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Melon Seeds")
        @Holdable
        @LegacyID(362)
        /*@NotPlaceable*/
        MELON_SEEDS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Raw Beef")
        @Holdable
        @LegacyID(363)
        /*@NotPlaceable*/
        BEEF,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Steak")
        @Holdable
        @LegacyID(364)
        /*@NotPlaceable*/
        COOKED_BEEF,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Raw Chicken")
        @Holdable
        @LegacyID(365)
        /*@NotPlaceable*/
        CHICKEN,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Cooked Chicken")
        @Holdable
        @LegacyID(366)
        /*@NotPlaceable*/
        COOKED_CHICKEN,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Rotten Flesh")
        @Holdable
        @LegacyID(367)
        /*@NotPlaceable*/
        ROTTEN_FLESH,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Ender Pearl")
        @Holdable
        @LegacyID(368)
        /*@NotPlaceable*/
        ENDER_PEARL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Blaze Rod")
        @Holdable
        @LegacyID(369)
        /*@NotPlaceable*/
        BLAZE_ROD,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Ghast Tear")
        @Holdable
        @LegacyID(370)
        /*@NotPlaceable*/
        GHAST_TEAR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Gold Nugget")
        @Holdable
        @LegacyID(371)
        /*@NotPlaceable*/
        GOLD_NUGGET,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Potion")
        @Holdable
        @LegacyID(373)
        /*@NotPlaceable*/
        POTION,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Glass Bottle")
        @Holdable
        @LegacyID(374)
        /*@NotPlaceable*/
        GLASS_BOTTLE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Spider Eye")
        @Holdable
        @LegacyID(375)
        /*@NotPlaceable*/
        SPIDER_EYE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Fermented Spider Eye")
        @Holdable
        @LegacyID(376)
        /*@NotPlaceable*/
        FERMENTED_SPIDER_EYE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Blaze Powder")
        @Holdable
        @LegacyID(377)
        /*@NotPlaceable*/
        BLAZE_POWDER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Magma Cream")
        @Holdable
        @LegacyID(378)
        /*@NotPlaceable*/
        MAGMA_CREAM,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Eye of Ender")
        @Holdable
        @LegacyID(381)
        /*@NotPlaceable*/
        ENDER_EYE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Glistering Melon")
        @Holdable
        @LegacyID(382)
        /*@NotPlaceable*/
        SPECKLED_MELON,
        @MetaRange(min = 50, max = 120)
        @Meta(val = 50, name = "Spawn Creeper")
        @Meta(val = 51, name = "Spawn Skeleton")
        @Meta(val = 52, name = "Spawn Spider")
        @Meta(val = 54, name = "Spawn Zombie")
        @Meta(val = 55, name = "Spawn Slime")
        @Meta(val = 56, name = "Spawn Ghast")
        @Meta(val = 57, name = "Spawn Pigman")
        @Meta(val = 58, name = "Spawn Enderman")
        @Meta(val = 59, name = "Spawn Cave Spider")
        @Meta(val = 60, name = "Spawn Silverfish")
        @Meta(val = 61, name = "Spawn Blaze")
        @Meta(val = 62, name = "Spawn Magma Cube")
        @Meta(val = 65, name = "Spawn Bat")
        @Meta(val = 66, name = "Spawn Witch")
        @Meta(val = 67, name = "Spawn Endermite")
        @Meta(val = 68, name = "Spawn Guardian")
        @Meta(val = 90, name = "Spawn Pig")
        @Meta(val = 91, name = "Spawn Sheep")
        @Meta(val = 92, name = "Spawn Cow")
        @Meta(val = 93, name = "Spawn Chicken")
        @Meta(val = 94, name = "Spawn Squid")
        @Meta(val = 95, name = "Spawn Wolf")
        @Meta(val = 96, name = "Spawn Mooshroom")
        @Meta(val = 98, name = "Spawn Ocelot")
        @Meta(val = 100, name = "Spawn Horse")
        @Meta(val = 101, name = "Spawn Rabbit")
        @Meta(val = 120, name = "Spawn Villager")
        @Holdable
        @LegacyID(383)
        /*@NotPlaceable*/
        SPAWN_EGG,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Bottle o' Enchanting")
        @Holdable
        @LegacyID(384)
        /*@NotPlaceable*/
        EXPERIENCE_BOTTLE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Fire Charge")
        @Holdable
        @LegacyID(385)
        /*@NotPlaceable*/
        FIRE_CHARGE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Book and Quill")
        @Holdable
        @LegacyID(386)
        /*@NotPlaceable*/
        WRITABLE_BOOK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Written Book")
        @Holdable
        @LegacyID(387)
        /*@NotPlaceable*/
        WRITTEN_BOOK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Emerald")
        @Holdable
        @LegacyID(388)
        /*@NotPlaceable*/
        EMERALD,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Item Frame")
        @Holdable
        @LegacyID(389)
        /*@NotPlaceable*/
        ITEM_FRAME,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Carrot")
        @Holdable
        @LegacyID(391)
        /*@NotPlaceable*/
        CARROT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Potato")
        @Holdable
        @LegacyID(392)
        /*@NotPlaceable*/
        POTATO,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Baked Potato")
        @Holdable
        @LegacyID(393)
        /*@NotPlaceable*/
        BAKED_POTATO,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Poisonous Potato")
        @Holdable
        @LegacyID(394)
        /*@NotPlaceable*/
        POISONOUS_POTATO,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Empty Map")
        @Holdable
        @LegacyID(395)
        /*@NotPlaceable*/
        MAP,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Golden Carrot")
        @Holdable
        @LegacyID(396)
        /*@NotPlaceable*/
        GOLDEN_CARROT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Carrot on a Stick")
        @Holdable
        @LegacyID(398)
        /*@NotPlaceable*/
        CARROT_ON_A_STICK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Nether Star")
        @Holdable
        @LegacyID(399)
        /*@NotPlaceable*/
        NETHER_STAR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Pumpkin Pie")
        @Holdable
        @LegacyID(400)
        /*@NotPlaceable*/
        PUMPKIN_PIE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Firework Rocket")
        @Holdable
        @LegacyID(401)
        /*@NotPlaceable*/
        FIREWORKS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Firework Star")
        @Holdable
        @LegacyID(402)
        /*@NotPlaceable*/
        FIREWORK_CHARGE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Enchanted Book")
        @Holdable
        @LegacyID(403)
        /*@NotPlaceable*/
        ENCHANTED_BOOK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Redstone Comparator")
        @Holdable
        @LegacyID(404)
        /*@NotPlaceable*/
        COMPARATOR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Nether Brick")
        @Holdable
        @LegacyID(405)
        /*@NotPlaceable*/
        NETHERBRICK,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Nether Quartz")
        @Holdable
        @LegacyID(406)
        /*@NotPlaceable*/
        QUARTZ,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Minecart with TNT")
        @Holdable
        @LegacyID(407)
        /*@NotPlaceable*/
        TNT_MINECART,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Minecart with Hopper")
        @Holdable
        @LegacyID(408)
        /*@NotPlaceable*/
        HOPPER_MINECART,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Prismarine Shard")
        @Holdable
        @LegacyID(409)
        /*@NotPlaceable*/
        PRISMARINE_SHARD,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Prismarine Crystals")
        @Holdable
        @LegacyID(410)
        /*@NotPlaceable*/
        PRISMARINE_CRYSTALS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Raw Rabbit")
        @Holdable
        @LegacyID(411)
        /*@NotPlaceable*/
        RABBIT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Cooked Rabbit")
        @Holdable
        @LegacyID(412)
        /*@NotPlaceable*/
        COOKED_RABBIT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Rabbit Stew")
        @Holdable
        @LegacyID(413)
        /*@NotPlaceable*/
        RABBIT_STEW,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Rabbit's Foot")
        @Holdable
        @LegacyID(414)
        /*@NotPlaceable*/
        RABBIT_FOOT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Rabbit Hide")
        @Holdable
        @LegacyID(415)
        /*@NotPlaceable*/
        RABBIT_HIDE,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Armor Stand")
        @Holdable
        @LegacyID(416)
        /*@NotPlaceable*/
        ARMOR_STAND,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Iron Horse Armor")
        @Holdable
        @LegacyID(417)
        /*@NotPlaceable*/
        IRON_HORSE_ARMOR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Golden Horse Armor")
        @Holdable
        @LegacyID(418)
        /*@NotPlaceable*/
        GOLDEN_HORSE_ARMOR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Diamond Horse Armor")
        @Holdable
        @LegacyID(419)
        /*@NotPlaceable*/
        DIAMOND_HORSE_ARMOR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Lead")
        @Holdable
        @LegacyID(420)
        /*@NotPlaceable*/
        LEAD,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Name Tag")
        @Holdable
        @LegacyID(421)
        /*@NotPlaceable*/
        NAME_TAG,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Minecart with Command Block")
        @Holdable
        @LegacyID(422)
        /*@NotPlaceable*/
        COMMAND_BLOCK_MINECART,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Raw Mutton")
        @Holdable
        @LegacyID(423)
        /*@NotPlaceable*/
        MUTTON,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Cooked Mutton")
        @Holdable
        @LegacyID(424)
        /*@NotPlaceable*/
        COOKED_MUTTON,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Banner")
        @Holdable
        @LegacyID(425)
        /*@NotPlaceable*/
        BANNER,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "13 Disc")
        @Holdable
        @LegacyID(2256)
        /*@NotPlaceable*/
        RECORD_13,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Cat Disc")
        @Holdable
        @LegacyID(2257)
        /*@NotPlaceable*/
        RECORD_CAT,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Blocks Disc")
        @Holdable
        @LegacyID(2258)
        /*@NotPlaceable*/
        RECORD_BLOCKS,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Chirp Disc")
        @Holdable
        @LegacyID(2259)
        /*@NotPlaceable*/
        RECORD_CHIRP,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Far Disc")
        @Holdable
        @LegacyID(2260)
        /*@NotPlaceable*/
        RECORD_FAR,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Mall Disc")
        @Holdable
        @LegacyID(2261)
        /*@NotPlaceable*/
        RECORD_MALL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Mellohi Disc")
        @Holdable
        @LegacyID(2262)
        /*@NotPlaceable*/
        RECORD_MELLOHI,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Stal Disc")
        @Holdable
        @LegacyID(2263)
        /*@NotPlaceable*/
        RECORD_STAL,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Strad Disc")
        @Holdable
        @LegacyID(2264)
        /*@NotPlaceable*/
        RECORD_STRAD,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Ward Disc")
        @Holdable
        @LegacyID(2265)
        /*@NotPlaceable*/
        RECORD_WARD,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "11 Disc")
        @Holdable
        @LegacyID(2266)
        /*@NotPlaceable*/
        RECORD_11,
        @MetaRange(min = 0, max = 0)
        @Meta(val = 0, name = "Wait Disc")
        @Holdable
        @LegacyID(2267)
        /*@NotPlaceable*/
        RECORD_WAIT,;

        private static final String DOMAIN = "minecraft";
        
        private final MetaRange range;
        private final Meta[] metas;
        private final short[] ids;
        private final boolean placeable, holdable;
        
        private Vanilla() {
            try {
                Field f = Vanilla.class.getField(this.name());
                this.range = f.getAnnotation(MetaRange.class);
                this.metas = f.getAnnotationsByType(Meta.class);
                LegacyID[] idsInA = f.getAnnotationsByType(LegacyID.class);
                this.ids = new short[idsInA.length];
                for (int i = 0; i < idsInA.length; i++) {
                    this.ids[i] = idsInA[i].value();
                }
                this.placeable =f.isAnnotationPresent(Placeable.class);
                this.holdable = f.isAnnotationPresent(Holdable.class);
            } catch(ReflectiveOperationException ex) {
                throw new RuntimeException(ex);
            }
        }
        
        @Override
        public String getDomain() {
            return DOMAIN;
        }

        @Override
        public String getID() {
            return this.name().toLowerCase();
        }

        @Override
        public String getName(short meta) {
            for (Meta m : this.metas) {
                if (m.val() == meta) {
                    return m.name();
                }
            }
            return this.getID();
        }

        @Override
        public short[] getLegacyID() {
            return this.ids.clone();
        }

        @Override
        public boolean isValidMeta(short meta) {
            return this.range.min() <= meta && meta <= this.range.max();
        }

        @Override
        public boolean isPlaceable() {
            return this.placeable;
        }

        @Override
        public boolean isHoldable() {
            return this.holdable;
        }
        
        public static EditMaterial.Vanilla getByLegacyID(short legacyId) {
            for (Vanilla m : Vanilla.values()) {
                for (short id : m.getLegacyID()) {
                    if (id == legacyId) {
                        return m;
                    }
                }
            }
            return null;
        }

        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        private @interface MetaRange {

            short min() default 0;

            short max();

        }

        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        private @interface MetaValues {

            Meta[] value();

        }

        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        @Repeatable(MetaValues.class)
        private @interface Meta {

            short val();

            String name();

        }

        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        private @interface LegacyIDs {

            LegacyID[] value();

        }

        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        @Repeatable(LegacyIDs.class)
        private @interface LegacyID {

            short value();

        }

        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        private @interface Placeable {
        }

        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        private @interface Holdable {
        }

    }

}
