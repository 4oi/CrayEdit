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
package jp.llv.ce.util;

import jp.llv.ce.server.EditMaterial;

/**
 *
 * @author Toyblocks
 */
public interface IDTable {

    EditMaterial get(String id);
    
    EditMaterial getByLegacyID(short legacyID);
    
    void register(EditMaterial material);
    
    enum VanillaMaterial implements EditMaterial {

        AIR((short) 0) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Air";
                            default:
                                return this.toString();
                        }
                    }
                },
        STONE((short) 1) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Stone";
                            case 1:
                                return "Granite";
                            case 2:
                                return "Polished Granite";
                            case 3:
                                return "Diorite";
                            case 4:
                                return "Polished Diorite";
                            case 5:
                                return "Andesite";
                            case 6:
                                return "Polished Andesite";
                            default:
                                return this.toString();
                        }
                    }
                },
        GRASS((short) 2) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Grass";
                            default:
                                return this.toString();
                        }
                    }
                },
        DIRT((short) 3) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Dirt";
                            case 1:
                                return "Coarse Dirt";
                            case 2:
                                return "Podzol";
                            default:
                                return this.toString();
                        }
                    }
                },
        COBBLESTONE((short) 4) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cobblestone";
                            default:
                                return this.toString();
                        }
                    }
                },
        PLANKS((short) 5) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Oak Wood Plank";
                            case 1:
                                return "Spruce Wood Plank";
                            case 2:
                                return "Birch Wood Plank";
                            case 3:
                                return "Jungle Wood Plank";
                            case 4:
                                return "Acacia Wood Plank";
                            case 5:
                                return "Dark Oak Wood Plank";
                            default:
                                return this.toString();
                        }
                    }
                },
        SAPLING((short) 6) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Oak Sapling";
                            case 1:
                                return "Spruce Sapling";
                            case 2:
                                return "Birch Sapling";
                            case 3:
                                return "Jungle Sapling";
                            case 4:
                                return "Acacia Sapling";
                            case 5:
                                return "Dark Oak Sapling";
                            default:
                                return this.toString();
                        }
                    }
                },
        BEDROCK((short) 7) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Bedrock";
                            default:
                                return this.toString();
                        }
                    }
                },
        FLOWING_WATER((short) 8) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Flowing Water";
                            default:
                                return this.toString();
                        }
                    }
                },
        WATER((short) 9) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Still Water";
                            default:
                                return this.toString();
                        }
                    }
                },
        FLOWING_LAVA((short) 10) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Flowing Lava";
                            default:
                                return this.toString();
                        }
                    }
                },
        LAVA((short) 11) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Still Lava";
                            default:
                                return this.toString();
                        }
                    }
                },
        SAND((short) 12) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Sand";
                            case 1:
                                return "Red Sand";
                            default:
                                return this.toString();
                        }
                    }
                },
        GRAVEL((short) 13) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Gravel";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLD_ORE((short) 14) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Gold Ore";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_ORE((short) 15) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Ore";
                            default:
                                return this.toString();
                        }
                    }
                },
        COAL_ORE((short) 16) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Coal Ore";
                            default:
                                return this.toString();
                        }
                    }
                },
        LOG((short) 17) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Oak Wood";
                            case 1:
                                return "Spruce Wood";
                            case 2:
                                return "Birch Wood";
                            case 3:
                                return "Jungle Wood";
                            default:
                                return this.toString();
                        }
                    }
                },
        LEAVES((short) 18) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Oak Leaves";
                            case 1:
                                return "Spruce Leaves";
                            case 2:
                                return "Birch Leaves";
                            case 3:
                                return "Jungle Leaves";
                            default:
                                return this.toString();
                        }
                    }
                },
        SPONGE((short) 19) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Sponge";
                            case 1:
                                return "Wet Sponge";
                            default:
                                return this.toString();
                        }
                    }
                },
        GLASS((short) 20) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Glass";
                            default:
                                return this.toString();
                        }
                    }
                },
        LAPIS_ORE((short) 21) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Lapis Lazuli Ore";
                            default:
                                return this.toString();
                        }
                    }
                },
        LAPIS_BLOCK((short) 22) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Lapis Lazuli Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        DISPENSER((short) 23) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Dispenser";
                            default:
                                return this.toString();
                        }
                    }
                },
        SANDSTONE((short) 24) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Sandstone";
                            case 1:
                                return "Chiseled Sandstone";
                            case 2:
                                return "Smooth Sandstone";
                            default:
                                return this.toString();
                        }
                    }
                },
        NOTEBLOCK((short) 25) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Note Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        BED((short) 355) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Bed";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLDEN_RAIL((short) 27) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Powered Rail";
                            default:
                                return this.toString();
                        }
                    }
                },
        DETECTOR_RAIL((short) 28) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Detector Rail";
                            default:
                                return this.toString();
                        }
                    }
                },
        STICKY_PISTON((short) 29) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Sticky Piston";
                            default:
                                return this.toString();
                        }
                    }
                },
        WEB((short) 30) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cobweb";
                            default:
                                return this.toString();
                        }
                    }
                },
        TALLGRASS((short) 31) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Dead Shrub";
                            case 1:
                                return "Grass";
                            case 2:
                                return "Fern";
                            default:
                                return this.toString();
                        }
                    }
                },
        DEADBUSH((short) 32) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Dead Bush";
                            default:
                                return this.toString();
                        }
                    }
                },
        PISTON((short) 33) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Piston";
                            default:
                                return this.toString();
                        }
                    }
                },
        PISTON_HEAD((short) 34) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Piston Head";
                            default:
                                return this.toString();
                        }
                    }
                },
        WOOL((short) 35) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "White Wool";
                            case 1:
                                return "Orange Wool";
                            case 2:
                                return "Magenta Wool";
                            case 3:
                                return "Light Blue Wool";
                            case 4:
                                return "Yellow Wool";
                            case 5:
                                return "Lime Wool";
                            case 6:
                                return "Pink Wool";
                            case 7:
                                return "Gray Wool";
                            case 8:
                                return "Light Gray Wool";
                            case 9:
                                return "Cyan Wool";
                            case 10:
                                return "Purple Wool";
                            case 11:
                                return "Blue Wool";
                            case 12:
                                return "Brown Wool";
                            case 13:
                                return "Green Wool";
                            case 14:
                                return "Red Wool";
                            case 15:
                                return "Black Wool";
                            default:
                                return this.toString();
                        }
                    }
                },
        YELLOW_FLOWER((short) 37) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Dandelion";
                            default:
                                return this.toString();
                        }
                    }
                },
        RED_FLOWER((short) 38) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Poppy";
                            case 1:
                                return "Blue Orchid";
                            case 2:
                                return "Allium";
                            case 3:
                                return "Azure Bluet";
                            case 4:
                                return "Red Tulip";
                            case 5:
                                return "Orange Tulip";
                            case 6:
                                return "White Tulip";
                            case 7:
                                return "Pink Tulip";
                            case 8:
                                return "Oxeye Daisy";
                            default:
                                return this.toString();
                        }
                    }
                },
        BROWN_MUSHROOM((short) 39) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Brown Mushroom";
                            default:
                                return this.toString();
                        }
                    }
                },
        RED_MUSHROOM((short) 40) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Red Mushroom";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLD_BLOCK((short) 41) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Gold Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_BLOCK((short) 42) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        DOUBLE_STONE_SLAB((short) 43) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Double Stone Slab";
                            case 1:
                                return "Double Sandstone Slab";
                            case 2:
                                return "Double Wooden Slab";
                            case 3:
                                return "Double Cobblestone Slab";
                            case 4:
                                return "Double Brick Slab";
                            case 5:
                                return "Double Stone Brick Slab";
                            case 6:
                                return "Double Nether Brick Slab";
                            case 7:
                                return "Double Quartz Slab";
                            default:
                                return this.toString();
                        }
                    }
                },
        STONE_SLAB((short) 44) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Stone Slab";
                            case 1:
                                return "Sandstone Slab";
                            case 2:
                                return "Wooden Slab";
                            case 3:
                                return "Cobblestone Slab";
                            case 4:
                                return "Brick Slab";
                            case 5:
                                return "Stone Brick Slab";
                            case 6:
                                return "Nether Brick Slab";
                            case 7:
                                return "Quartz Slab";
                            default:
                                return this.toString();
                        }
                    }
                },
        BRICK_BLOCK((short) 45) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Bricks";
                            default:
                                return this.toString();
                        }
                    }
                },
        TNT((short) 46) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "TNT";
                            default:
                                return this.toString();
                        }
                    }
                },
        BOOKSHELF((short) 47) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Bookshelf";
                            default:
                                return this.toString();
                        }
                    }
                },
        MOSSY_COBBLESTONE((short) 48) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Moss Stone";
                            default:
                                return this.toString();
                        }
                    }
                },
        OBSIDIAN((short) 49) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Obsidian";
                            default:
                                return this.toString();
                        }
                    }
                },
        TORCH((short) 50) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Torch";
                            default:
                                return this.toString();
                        }
                    }
                },
        FIRE((short) 51) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Fire";
                            default:
                                return this.toString();
                        }
                    }
                },
        MOB_SPAWNER((short) 52) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Monster Spawner";
                            default:
                                return this.toString();
                        }
                    }
                },
        OAK_STAIRS((short) 53) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Oak Wood Stairs";
                            default:
                                return this.toString();
                        }
                    }
                },
        CHEST((short) 54) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Chest";
                            default:
                                return this.toString();
                        }
                    }
                },
        REDSTONE_WIRE((short) 55) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Redstone Wire";
                            default:
                                return this.toString();
                        }
                    }
                },
        DIAMOND_ORE((short) 56) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Diamond Ore";
                            default:
                                return this.toString();
                        }
                    }
                },
        DIAMOND_BLOCK((short) 57) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Diamond Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        CRAFTING_TABLE((short) 58) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Crafting Table";
                            default:
                                return this.toString();
                        }
                    }
                },
        WHEAT((short) 296) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Wheat";
                            default:
                                return this.toString();
                        }
                    }
                },
        FARMLAND((short) 60) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Farmland";
                            default:
                                return this.toString();
                        }
                    }
                },
        FURNACE((short) 61) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Furnace";
                            default:
                                return this.toString();
                        }
                    }
                },
        LIT_FURNACE((short) 62) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Burning Furnace";
                            default:
                                return this.toString();
                        }
                    }
                },
        STANDING_SIGN((short) 63) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Standing Sign Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        WOODEN_DOOR((short) 324) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Oak Door";
                            default:
                                return this.toString();
                        }
                    }
                },
        LADDER((short) 65) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Ladder";
                            default:
                                return this.toString();
                        }
                    }
                },
        RAIL((short) 66) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Rail";
                            default:
                                return this.toString();
                        }
                    }
                },
        STONE_STAIRS((short) 67) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cobblestone Stairs";
                            default:
                                return this.toString();
                        }
                    }
                },
        WALL_SIGN((short) 68) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Wall-mounted Sign Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        LEVER((short) 69) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Lever";
                            default:
                                return this.toString();
                        }
                    }
                },
        STONE_PRESSURE_PLATE((short) 70) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Stone Pressure Plate";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_DOOR((short) 330) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Door";
                            default:
                                return this.toString();
                        }
                    }
                },
        WOODEN_PRESSURE_PLATE((short) 72) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Wooden Pressure Plate";
                            default:
                                return this.toString();
                        }
                    }
                },
        REDSTONE_ORE((short) 73) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Redstone Ore";
                            default:
                                return this.toString();
                        }
                    }
                },
        LIT_REDSTONE_ORE((short) 74) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Glowing Redstone Ore";
                            default:
                                return this.toString();
                        }
                    }
                },
        UNLIT_REDSTONE_TORCH((short) 75) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Redstone Torch (off)";
                            default:
                                return this.toString();
                        }
                    }
                },
        REDSTONE_TORCH((short) 76) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Redstone Torch (on)";
                            default:
                                return this.toString();
                        }
                    }
                },
        STONE_BUTTON((short) 77) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Stone Button";
                            default:
                                return this.toString();
                        }
                    }
                },
        SNOW_LAYER((short) 78) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Snow";
                            default:
                                return this.toString();
                        }
                    }
                },
        ICE((short) 79) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Ice";
                            default:
                                return this.toString();
                        }
                    }
                },
        SNOW((short) 80) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Snow Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        CACTUS((short) 81) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cactus";
                            default:
                                return this.toString();
                        }
                    }
                },
        CLAY((short) 82) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Clay";
                            default:
                                return this.toString();
                        }
                    }
                },
        REEDS((short) 338) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Sugar Canes";
                            default:
                                return this.toString();
                        }
                    }
                },
        JUKEBOX((short) 84) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Jukebox";
                            default:
                                return this.toString();
                        }
                    }
                },
        FENCE((short) 85) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Oak Fence";
                            default:
                                return this.toString();
                        }
                    }
                },
        PUMPKIN((short) 86) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Pumpkin";
                            default:
                                return this.toString();
                        }
                    }
                },
        NETHERRACK((short) 87) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Netherrack";
                            default:
                                return this.toString();
                        }
                    }
                },
        SOUL_SAND((short) 88) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Soul Sand";
                            default:
                                return this.toString();
                        }
                    }
                },
        GLOWSTONE((short) 89) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Glowstone";
                            default:
                                return this.toString();
                        }
                    }
                },
        PORTAL((short) 90) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Nether Portal";
                            default:
                                return this.toString();
                        }
                    }
                },
        LIT_PUMPKIN((short) 91) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Jack o'Lantern";
                            default:
                                return this.toString();
                        }
                    }
                },
        CAKE((short) 354) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cake";
                            default:
                                return this.toString();
                        }
                    }
                },
        UNPOWERED_REPEATER((short) 93) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Redstone Repeater Block (off)";
                            default:
                                return this.toString();
                        }
                    }
                },
        POWERED_REPEATER((short) 94) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Redstone Repeater Block (on)";
                            default:
                                return this.toString();
                        }
                    }
                },
        STAINED_GLASS((short) 95) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "White Stained Glass";
                            case 1:
                                return "Orange Stained Glass";
                            case 2:
                                return "Magenta Stained Glass";
                            case 3:
                                return "Light Blue Stained Glass";
                            case 4:
                                return "Yellow Stained Glass";
                            case 5:
                                return "Lime Stained Glass";
                            case 6:
                                return "Pink Stained Glass";
                            case 7:
                                return "Gray Stained Glass";
                            case 8:
                                return "Light Gray Stained Glass";
                            case 9:
                                return "Cyan Stained Glass";
                            case 10:
                                return "Purple Stained Glass";
                            case 11:
                                return "Blue Stained Glass";
                            case 12:
                                return "Brown Stained Glass";
                            case 13:
                                return "Green Stained Glass";
                            case 14:
                                return "Red Stained Glass";
                            case 15:
                                return "Black Stained Glass";
                            default:
                                return this.toString();
                        }
                    }
                },
        TRAPDOOR((short) 96) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Wooden Trapdoor";
                            default:
                                return this.toString();
                        }
                    }
                },
        MONSTER_EGG((short) 97) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Stone Monster Egg";
                            case 1:
                                return "Cobblestone Monster Egg";
                            case 2:
                                return "Stone Brick Monster Egg";
                            case 3:
                                return "Mossy Stone Brick Monster Egg";
                            case 4:
                                return "Cracked Stone Brick Monster Egg";
                            case 5:
                                return "Chiseled Stone Brick Monster Egg";
                            default:
                                return this.toString();
                        }
                    }
                },
        STONEBRICK((short) 98) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Stone Bricks";
                            case 1:
                                return "Mossy Stone Bricks";
                            case 2:
                                return "Cracked Stone Bricks";
                            case 3:
                                return "Chiseled Stone Bricks";
                            default:
                                return this.toString();
                        }
                    }
                },
        BROWN_MUSHROOM_BLOCK((short) 99) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Brown Mushroom Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        RED_MUSHROOM_BLOCK((short) 100) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Red Mushroom Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_BARS((short) 101) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Bars";
                            default:
                                return this.toString();
                        }
                    }
                },
        GLASS_PANE((short) 102) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Glass Pane";
                            default:
                                return this.toString();
                        }
                    }
                },
        MELON_BLOCK((short) 103) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Melon Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        PUMPKIN_STEM((short) 104) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Pumpkin Stem";
                            default:
                                return this.toString();
                        }
                    }
                },
        MELON_STEM((short) 105) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Melon Stem";
                            default:
                                return this.toString();
                        }
                    }
                },
        VINE((short) 106) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Vines";
                            default:
                                return this.toString();
                        }
                    }
                },
        FENCE_GATE((short) 107) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Oak Fence Gate";
                            default:
                                return this.toString();
                        }
                    }
                },
        BRICK_STAIRS((short) 108) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Brick Stairs";
                            default:
                                return this.toString();
                        }
                    }
                },
        STONE_BRICK_STAIRS((short) 109) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Stone Brick Stairs";
                            default:
                                return this.toString();
                        }
                    }
                },
        MYCELIUM((short) 110) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Mycelium";
                            default:
                                return this.toString();
                        }
                    }
                },
        WATERLILY((short) 111) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Lily Pad";
                            default:
                                return this.toString();
                        }
                    }
                },
        NETHER_BRICK((short) 112) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Nether Brick";
                            default:
                                return this.toString();
                        }
                    }
                },
        NETHER_BRICK_FENCE((short) 113) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Nether Brick Fence";
                            default:
                                return this.toString();
                        }
                    }
                },
        NETHER_BRICK_STAIRS((short) 114) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Nether Brick Stairs";
                            default:
                                return this.toString();
                        }
                    }
                },
        NETHER_WART((short) 372) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Nether Wart";
                            default:
                                return this.toString();
                        }
                    }
                },
        ENCHANTING_TABLE((short) 116) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Enchantment Table";
                            default:
                                return this.toString();
                        }
                    }
                },
        BREWING_STAND((short) 379) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Brewing Stand";
                            default:
                                return this.toString();
                        }
                    }
                },
        CAULDRON((short) 380) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cauldron";
                            default:
                                return this.toString();
                        }
                    }
                },
        END_PORTAL((short) 119) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "End Portal";
                            default:
                                return this.toString();
                        }
                    }
                },
        END_PORTAL_FRAME((short) 120) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "End Portal Frame";
                            default:
                                return this.toString();
                        }
                    }
                },
        END_STONE((short) 121) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "End Stone";
                            default:
                                return this.toString();
                        }
                    }
                },
        DRAGON_EGG((short) 122) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Dragon Egg";
                            default:
                                return this.toString();
                        }
                    }
                },
        REDSTONE_LAMP((short) 123) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Redstone Lamp (inactive)";
                            default:
                                return this.toString();
                        }
                    }
                },
        LIT_REDSTONE_LAMP((short) 124) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Redstone Lamp (active)";
                            default:
                                return this.toString();
                        }
                    }
                },
        DOUBLE_WOODEN_SLAB((short) 125) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Double Oak Wood Slab";
                            case 1:
                                return "Double Spruce Wood Slab";
                            case 2:
                                return "Double Birch Wood Slab";
                            case 3:
                                return "Double Jungle Wood Slab";
                            case 4:
                                return "Double Acacia Wood Slab";
                            case 5:
                                return "Double Dark Oak Wood Slab";
                            default:
                                return this.toString();
                        }
                    }
                },
        WOODEN_SLAB((short) 126) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Oak Wood Slab";
                            case 1:
                                return "Spruce Wood Slab";
                            case 2:
                                return "Birch Wood Slab";
                            case 3:
                                return "Jungle Wood Slab";
                            case 4:
                                return "Acacia Wood Slab";
                            case 5:
                                return "Dark Oak Wood Slab";
                            default:
                                return this.toString();
                        }
                    }
                },
        COCOA((short) 127) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cocoa";
                            default:
                                return this.toString();
                        }
                    }
                },
        SANDSTONE_STAIRS((short) 128) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Sandstone Stairs";
                            default:
                                return this.toString();
                        }
                    }
                },
        EMERALD_ORE((short) 129) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Emerald Ore";
                            default:
                                return this.toString();
                        }
                    }
                },
        ENDER_CHEST((short) 130) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Ender Chest";
                            default:
                                return this.toString();
                        }
                    }
                },
        TRIPWIRE_HOOK((short) 132) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Tripwire";
                            default:
                                return this.toString();
                        }
                    }
                },
        EMERALD_BLOCK((short) 133) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Emerald Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        SPRUCE_STAIRS((short) 134) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Spruce Wood Stairs";
                            default:
                                return this.toString();
                        }
                    }
                },
        BIRCH_STAIRS((short) 135) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Birch Wood Stairs";
                            default:
                                return this.toString();
                        }
                    }
                },
        JUNGLE_STAIRS((short) 136) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Jungle Wood Stairs";
                            default:
                                return this.toString();
                        }
                    }
                },
        COMMAND_BLOCK((short) 137) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Command Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        BEACON((short) 138) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Beacon";
                            default:
                                return this.toString();
                        }
                    }
                },
        COBBLESTONE_WALL((short) 139) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cobblestone Wall";
                            case 1:
                                return "Mossy Cobblestone Wall";
                            default:
                                return this.toString();
                        }
                    }
                },
        FLOWER_POT((short) 390) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Flower Pot";
                            default:
                                return this.toString();
                        }
                    }
                },
        CARROTS((short) 141) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Carrots";
                            default:
                                return this.toString();
                        }
                    }
                },
        POTATOES((short) 142) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Potatoes";
                            default:
                                return this.toString();
                        }
                    }
                },
        WOODEN_BUTTON((short) 143) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Wooden Button";
                            default:
                                return this.toString();
                        }
                    }
                },
        SKULL((short) 397) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Mob Head (Skeleton)";
                            case 1:
                                return "Mob Head (Wither Skeleton)";
                            case 2:
                                return "Mob Head (Zombie)";
                            case 3:
                                return "Mob Head (Human)";
                            case 4:
                                return "Mob Head (Creeper)";
                            default:
                                return this.toString();
                        }
                    }
                },
        ANVIL((short) 145) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Anvil";
                            default:
                                return this.toString();
                        }
                    }
                },
        TRAPPED_CHEST((short) 146) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Trapped Chest";
                            default:
                                return this.toString();
                        }
                    }
                },
        LIGHT_WEIGHTED_PRESSURE_PLATE((short) 147) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Weighted Pressure Plate (light)";
                            default:
                                return this.toString();
                        }
                    }
                },
        HEAVY_WEIGHTED_PRESSURE_PLATE((short) 148) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Weighted Pressure Plate (heavy)";
                            default:
                                return this.toString();
                        }
                    }
                },
        UNPOWERED_COMPARATOR((short) 149) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Redstone Comparator (inactive)";
                            default:
                                return this.toString();
                        }
                    }
                },
        POWERED_COMPARATOR((short) 150) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Redstone Comparator (active)";
                            default:
                                return this.toString();
                        }
                    }
                },
        DAYLIGHT_DETECTOR((short) 151) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Daylight Sensor";
                            default:
                                return this.toString();
                        }
                    }
                },
        REDSTONE_BLOCK((short) 152) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Redstone Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        QUARTZ_ORE((short) 153) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Nether Quartz Ore";
                            default:
                                return this.toString();
                        }
                    }
                },
        HOPPER((short) 154) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Hopper";
                            default:
                                return this.toString();
                        }
                    }
                },
        QUARTZ_BLOCK((short) 155) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Quartz Block";
                            case 1:
                                return "Chiseled Quartz Block";
                            case 2:
                                return "Pillar Quartz Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        QUARTZ_STAIRS((short) 156) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Quartz Stairs";
                            default:
                                return this.toString();
                        }
                    }
                },
        ACTIVATOR_RAIL((short) 157) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Activator Rail";
                            default:
                                return this.toString();
                        }
                    }
                },
        DROPPER((short) 158) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Dropper";
                            default:
                                return this.toString();
                        }
                    }
                },
        STAINED_HARDENED_CLAY((short) 159) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "White Stained Clay";
                            case 1:
                                return "Orange Stained Clay";
                            case 2:
                                return "Magenta Stained Clay";
                            case 3:
                                return "Light Blue Stained Clay";
                            case 4:
                                return "Yellow Stained Clay";
                            case 5:
                                return "Lime Stained Clay";
                            case 6:
                                return "Pink Stained Clay";
                            case 7:
                                return "Gray Stained Clay";
                            case 8:
                                return "Light Gray Stained Clay";
                            case 9:
                                return "Cyan Stained Clay";
                            case 10:
                                return "Purple Stained Clay";
                            case 11:
                                return "Blue Stained Clay";
                            case 12:
                                return "Brown Stained Clay";
                            case 13:
                                return "Green Stained Clay";
                            case 14:
                                return "Red Stained Clay";
                            case 15:
                                return "Black Stained Clay";
                            default:
                                return this.toString();
                        }
                    }
                },
        STAINED_GLASS_PANE((short) 160) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "White Stained Glass Pane";
                            case 1:
                                return "Orange Stained Glass Pane";
                            case 2:
                                return "Magenta Stained Glass Pane";
                            case 3:
                                return "Light Blue Stained Glass Pane";
                            case 4:
                                return "Yellow Stained Glass Pane";
                            case 5:
                                return "Lime Stained Glass Pane";
                            case 6:
                                return "Pink Stained Glass Pane";
                            case 7:
                                return "Gray Stained Glass Pane";
                            case 8:
                                return "Light Gray Stained Glass Pane";
                            case 9:
                                return "Cyan Stained Glass Pane";
                            case 10:
                                return "Purple Stained Glass Pane";
                            case 11:
                                return "Blue Stained Glass Pane";
                            case 12:
                                return "Brown Stained Glass Pane";
                            case 13:
                                return "Green Stained Glass Pane";
                            case 14:
                                return "Red Stained Glass Pane";
                            case 15:
                                return "Black Stained Glass Pane";
                            default:
                                return this.toString();
                        }
                    }
                },
        LEAVES2((short) 161) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Acacia Leaves";
                            case 1:
                                return "Dark Oak Leaves";
                            default:
                                return this.toString();
                        }
                    }
                },
        LOG2((short) 162) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Acacia Wood";
                            case 1:
                                return "Dark Oak Wood";
                            default:
                                return this.toString();
                        }
                    }
                },
        ACACIA_STAIRS((short) 163) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Acacia Wood Stairs";
                            default:
                                return this.toString();
                        }
                    }
                },
        DARK_OAK_STAIRS((short) 164) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Dark Oak Wood Stairs";
                            default:
                                return this.toString();
                        }
                    }
                },
        SLIME((short) 165) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Slime Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        BARRIER((short) 166) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Barrier";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_TRAPDOOR((short) 167) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Trapdoor";
                            default:
                                return this.toString();
                        }
                    }
                },
        PRISMARINE((short) 168) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Prismarine";
                            case 1:
                                return "Prismarine Bricks";
                            case 2:
                                return "Dark Prismarine";
                            default:
                                return this.toString();
                        }
                    }
                },
        SEA_LANTERN((short) 169) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Sea Lantern";
                            default:
                                return this.toString();
                        }
                    }
                },
        HAY_BLOCK((short) 170) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Hay Bale";
                            default:
                                return this.toString();
                        }
                    }
                },
        CARPET((short) 171) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "White Carpet";
                            case 1:
                                return "Orange Carpet";
                            case 2:
                                return "Magenta Carpet";
                            case 3:
                                return "Light Blue Carpet";
                            case 4:
                                return "Yellow Carpet";
                            case 5:
                                return "Lime Carpet";
                            case 6:
                                return "Pink Carpet";
                            case 7:
                                return "Gray Carpet";
                            case 8:
                                return "Light Gray Carpet";
                            case 9:
                                return "Cyan Carpet";
                            case 10:
                                return "Purple Carpet";
                            case 11:
                                return "Blue Carpet";
                            case 12:
                                return "Brown Carpet";
                            case 13:
                                return "Green Carpet";
                            case 14:
                                return "Red Carpet";
                            case 15:
                                return "Black Carpet";
                            default:
                                return this.toString();
                        }
                    }
                },
        HARDENED_CLAY((short) 172) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Hardened Clay";
                            default:
                                return this.toString();
                        }
                    }
                },
        COAL_BLOCK((short) 173) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Block of Coal";
                            default:
                                return this.toString();
                        }
                    }
                },
        PACKED_ICE((short) 174) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Packed Ice";
                            default:
                                return this.toString();
                        }
                    }
                },
        DOUBLE_PLANT((short) 175) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Sunflower";
                            case 1:
                                return "Lilac";
                            case 2:
                                return "Double Tallgrass";
                            case 3:
                                return "Large Fern";
                            case 4:
                                return "Rose Bush";
                            case 5:
                                return "Peony";
                            default:
                                return this.toString();
                        }
                    }
                },
        STANDING_BANNER((short) 176) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Free-standing Banner";
                            default:
                                return this.toString();
                        }
                    }
                },
        WALL_BANNER((short) 177) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Wall-mounted Banner";
                            default:
                                return this.toString();
                        }
                    }
                },
        DAYLIGHT_DETECTOR_INVERTED((short) 178) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Inverted Daylight Sensor";
                            default:
                                return this.toString();
                        }
                    }
                },
        RED_SANDSTONE((short) 179) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Red Sandstone";
                            case 1:
                                return "Chiseled Red Sandstone";
                            case 2:
                                return "Smooth Red Sandstone";
                            default:
                                return this.toString();
                        }
                    }
                },
        RED_SANDSTONE_STAIRS((short) 180) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Red Sandstone Stairs";
                            default:
                                return this.toString();
                        }
                    }
                },
        STONE_SLAB2((short) 181) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Double Red Sandstone Slab";
                            default:
                                return this.toString();
                        }
                    }
                },
        DOUBLE_STONE_SLAB2((short) 182) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Red Sandstone Slab";
                            default:
                                return this.toString();
                        }
                    }
                },
        SPRUCE_FENCE_GATE((short) 183) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Spruce Fence Gate";
                            default:
                                return this.toString();
                        }
                    }
                },
        BIRCH_FENCE_GATE((short) 184) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Birch Fence Gate";
                            default:
                                return this.toString();
                        }
                    }
                },
        JUNGLE_FENCE_GATE((short) 185) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Jungle Fence Gate";
                            default:
                                return this.toString();
                        }
                    }
                },
        DARK_OAK_FENCE_GATE((short) 186) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Dark Oak Fence Gate";
                            default:
                                return this.toString();
                        }
                    }
                },
        ACACIA_FENCE_GATE((short) 187) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Acacia Fence Gate";
                            default:
                                return this.toString();
                        }
                    }
                },
        SPRUCE_FENCE((short) 188) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Spruce Fence";
                            default:
                                return this.toString();
                        }
                    }
                },
        BIRCH_FENCE((short) 189) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Birch Fence";
                            default:
                                return this.toString();
                        }
                    }
                },
        JUNGLE_FENCE((short) 190) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Jungle Fence";
                            default:
                                return this.toString();
                        }
                    }
                },
        DARK_OAK_FENCE((short) 191) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Dark Oak Fence";
                            default:
                                return this.toString();
                        }
                    }
                },
        ACACIA_FENCE((short) 192) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Acacia Fence";
                            default:
                                return this.toString();
                        }
                    }
                },
        SPRUCE_DOOR((short) 427) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Spruce Door";
                            default:
                                return this.toString();
                        }
                    }
                },
        BIRCH_DOOR((short) 428) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Birch Door";
                            default:
                                return this.toString();
                        }
                    }
                },
        JUNGLE_DOOR((short) 429) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Jungle Door";
                            default:
                                return this.toString();
                        }
                    }
                },
        ACACIA_DOOR((short) 430) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Acacia Door";
                            default:
                                return this.toString();
                        }
                    }
                },
        DARK_OAK_DOOR((short) 431) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Dark Oak Door";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_SHOVEL((short) 256) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Shovel";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_PICKAXE((short) 257) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Pickaxe";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_AXE((short) 258) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Axe";
                            default:
                                return this.toString();
                        }
                    }
                },
        FLINT_AND_STEEL((short) 259) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Flint and Steel";
                            default:
                                return this.toString();
                        }
                    }
                },
        APPLE((short) 260) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Apple";
                            default:
                                return this.toString();
                        }
                    }
                },
        BOW((short) 261) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Bow";
                            default:
                                return this.toString();
                        }
                    }
                },
        ARROW((short) 262) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Arrow";
                            default:
                                return this.toString();
                        }
                    }
                },
        COAL((short) 263) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Coal";
                            case 1:
                                return "Charcoal";
                            default:
                                return this.toString();
                        }
                    }
                },
        DIAMOND((short) 264) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Diamond";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_INGOT((short) 265) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Ingot";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLD_INGOT((short) 266) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Gold Ingot";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_SWORD((short) 267) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Sword";
                            default:
                                return this.toString();
                        }
                    }
                },
        WOODEN_SWORD((short) 268) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Wooden Sword";
                            default:
                                return this.toString();
                        }
                    }
                },
        WOODEN_SHOVEL((short) 269) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Wooden Shovel";
                            default:
                                return this.toString();
                        }
                    }
                },
        WOODEN_PICKAXE((short) 270) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Wooden Pickaxe";
                            default:
                                return this.toString();
                        }
                    }
                },
        WOODEN_AXE((short) 271) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Wooden Axe";
                            default:
                                return this.toString();
                        }
                    }
                },
        STONE_SWORD((short) 272) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Stone Sword";
                            default:
                                return this.toString();
                        }
                    }
                },
        STONE_SHOVEL((short) 273) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Stone Shovel";
                            default:
                                return this.toString();
                        }
                    }
                },
        STONE_PICKAXE((short) 274) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Stone Pickaxe";
                            default:
                                return this.toString();
                        }
                    }
                },
        STONE_AXE((short) 275) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Stone Axe";
                            default:
                                return this.toString();
                        }
                    }
                },
        DIAMOND_SWORD((short) 276) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Diamond Sword";
                            default:
                                return this.toString();
                        }
                    }
                },
        DIAMOND_SHOVEL((short) 277) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Diamond Shovel";
                            default:
                                return this.toString();
                        }
                    }
                },
        DIAMOND_PICKAXE((short) 278) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Diamond Pickaxe";
                            default:
                                return this.toString();
                        }
                    }
                },
        DIAMOND_AXE((short) 279) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Diamond Axe";
                            default:
                                return this.toString();
                        }
                    }
                },
        STICK((short) 280) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Stick";
                            default:
                                return this.toString();
                        }
                    }
                },
        BOWL((short) 281) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Bowl";
                            default:
                                return this.toString();
                        }
                    }
                },
        MUSHROOM_STEW((short) 282) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Mushroom Stew";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLDEN_SWORD((short) 283) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Golden Sword";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLDEN_SHOVEL((short) 284) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Golden Shovel";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLDEN_PICKAXE((short) 285) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Golden Pickaxe";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLDEN_AXE((short) 286) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Golden Axe";
                            default:
                                return this.toString();
                        }
                    }
                },
        STRING((short) 287) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "String";
                            default:
                                return this.toString();
                        }
                    }
                },
        FEATHER((short) 288) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Feather";
                            default:
                                return this.toString();
                        }
                    }
                },
        GUNPOWDER((short) 289) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Gunpowder";
                            default:
                                return this.toString();
                        }
                    }
                },
        WOODEN_HOE((short) 290) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Wooden Hoe";
                            default:
                                return this.toString();
                        }
                    }
                },
        STONE_HOE((short) 291) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Stone Hoe";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_HOE((short) 292) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Hoe";
                            default:
                                return this.toString();
                        }
                    }
                },
        DIAMOND_HOE((short) 293) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Diamond Hoe";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLDEN_HOE((short) 294) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Golden Hoe";
                            default:
                                return this.toString();
                        }
                    }
                },
        WHEAT_SEEDS((short) 295) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Wheat Seeds";
                            default:
                                return this.toString();
                        }
                    }
                },
        BREAD((short) 297) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Bread";
                            default:
                                return this.toString();
                        }
                    }
                },
        LEATHER_HELMET((short) 298) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Leather Helmet";
                            default:
                                return this.toString();
                        }
                    }
                },
        LEATHER_CHESTPLATE((short) 299) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Leather Tunic";
                            default:
                                return this.toString();
                        }
                    }
                },
        LEATHER_LEGGINGS((short) 300) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Leather Pants";
                            default:
                                return this.toString();
                        }
                    }
                },
        LEATHER_BOOTS((short) 301) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Leather Boots";
                            default:
                                return this.toString();
                        }
                    }
                },
        CHAINMAIL_HELMET((short) 302) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Chainmail Helmet";
                            default:
                                return this.toString();
                        }
                    }
                },
        CHAINMAIL_CHESTPLATE((short) 303) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Chainmail Chestplate";
                            default:
                                return this.toString();
                        }
                    }
                },
        CHAINMAIL_LEGGINGS((short) 304) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Chainmail Leggings";
                            default:
                                return this.toString();
                        }
                    }
                },
        CHAINMAIL_BOOTS((short) 305) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Chainmail Boots";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_HELMET((short) 306) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Helmet";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_CHESTPLATE((short) 307) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Chestplate";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_LEGGINGS((short) 308) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Leggings";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_BOOTS((short) 309) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Boots";
                            default:
                                return this.toString();
                        }
                    }
                },
        DIAMOND_HELMET((short) 310) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Diamond Helmet";
                            default:
                                return this.toString();
                        }
                    }
                },
        DIAMOND_CHESTPLATE((short) 311) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Diamond Chestplate";
                            default:
                                return this.toString();
                        }
                    }
                },
        DIAMOND_LEGGINGS((short) 312) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Diamond Leggings";
                            default:
                                return this.toString();
                        }
                    }
                },
        DIAMOND_BOOTS((short) 313) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Diamond Boots";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLDEN_HELMET((short) 314) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Golden Helmet";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLDEN_CHESTPLATE((short) 315) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Golden Chestplate";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLDEN_LEGGINGS((short) 316) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Golden Leggings";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLDEN_BOOTS((short) 317) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Golden Boots";
                            default:
                                return this.toString();
                        }
                    }
                },
        FLINT((short) 318) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Flint";
                            default:
                                return this.toString();
                        }
                    }
                },
        PORKCHOP((short) 319) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Raw Porkchop";
                            default:
                                return this.toString();
                        }
                    }
                },
        COOKED_PORKCHOP((short) 320) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cooked Porkchop";
                            default:
                                return this.toString();
                        }
                    }
                },
        PAINTING((short) 321) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Painting";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLDEN_APPLE((short) 322) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Golden Apple";
                            case 1:
                                return "Enchanted Golden Apple";
                            default:
                                return this.toString();
                        }
                    }
                },
        SIGN((short) 323) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Sign";
                            default:
                                return this.toString();
                        }
                    }
                },
        BUCKET((short) 325) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Bucket";
                            default:
                                return this.toString();
                        }
                    }
                },
        WATER_BUCKET((short) 326) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Water Bucket";
                            default:
                                return this.toString();
                        }
                    }
                },
        LAVA_BUCKET((short) 327) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Lava Bucket";
                            default:
                                return this.toString();
                        }
                    }
                },
        MINECART((short) 328) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Minecart";
                            default:
                                return this.toString();
                        }
                    }
                },
        SADDLE((short) 329) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Saddle";
                            default:
                                return this.toString();
                        }
                    }
                },
        REDSTONE((short) 331) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Redstone";
                            default:
                                return this.toString();
                        }
                    }
                },
        SNOWBALL((short) 332) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Snowball";
                            default:
                                return this.toString();
                        }
                    }
                },
        BOAT((short) 333) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Boat";
                            default:
                                return this.toString();
                        }
                    }
                },
        LEATHER((short) 334) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Leather";
                            default:
                                return this.toString();
                        }
                    }
                },
        MILK_BUCKET((short) 335) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Milk Bucket";
                            default:
                                return this.toString();
                        }
                    }
                },
        BRICK((short) 336) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Brick";
                            default:
                                return this.toString();
                        }
                    }
                },
        CLAY_BALL((short) 337) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Clay";
                            default:
                                return this.toString();
                        }
                    }
                },
        PAPER((short) 339) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Paper";
                            default:
                                return this.toString();
                        }
                    }
                },
        BOOK((short) 340) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Book";
                            default:
                                return this.toString();
                        }
                    }
                },
        SLIME_BALL((short) 341) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Slimeball";
                            default:
                                return this.toString();
                        }
                    }
                },
        CHEST_MINECART((short) 342) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Minecart with Chest";
                            default:
                                return this.toString();
                        }
                    }
                },
        FURNACE_MINECART((short) 343) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Minecart with Furnace";
                            default:
                                return this.toString();
                        }
                    }
                },
        EGG((short) 344) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Egg";
                            default:
                                return this.toString();
                        }
                    }
                },
        COMPASS((short) 345) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Compass";
                            default:
                                return this.toString();
                        }
                    }
                },
        FISHING_ROD((short) 346) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Fishing Rod";
                            default:
                                return this.toString();
                        }
                    }
                },
        CLOCK((short) 347) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Clock";
                            default:
                                return this.toString();
                        }
                    }
                },
        GLOWSTONE_DUST((short) 348) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Glowstone Dust";
                            default:
                                return this.toString();
                        }
                    }
                },
        FISH((short) 349) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Raw Fish";
                            case 1:
                                return "Raw Salmon";
                            case 2:
                                return "Clownfish";
                            case 3:
                                return "Pufferfish";
                            default:
                                return this.toString();
                        }
                    }
                },
        COOKED_FISH((short) 350) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cooked Fish";
                            case 1:
                                return "Cooked Salmon";
                            default:
                                return this.toString();
                        }
                    }
                },
        DYE((short) 351) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Ink Sack";
                            case 1:
                                return "Rose Red";
                            case 2:
                                return "Cactus Green";
                            case 3:
                                return "Coco Beans";
                            case 4:
                                return "Lapis Lazuli";
                            case 5:
                                return "Purple Dye";
                            case 6:
                                return "Cyan Dye";
                            case 7:
                                return "Light Gray Dye";
                            case 8:
                                return "Gray Dye";
                            case 9:
                                return "Pink Dye";
                            case 10:
                                return "Lime Dye";
                            case 11:
                                return "Dandelion Yellow";
                            case 12:
                                return "Light Blue Dye";
                            case 13:
                                return "Magenta Dye";
                            case 14:
                                return "Orange Dye";
                            case 15:
                                return "Bone Meal";
                            default:
                                return this.toString();
                        }
                    }
                },
        BONE((short) 352) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Bone";
                            default:
                                return this.toString();
                        }
                    }
                },
        SUGAR((short) 353) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Sugar";
                            default:
                                return this.toString();
                        }
                    }
                },
        REPEATER((short) 356) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Redstone Repeater";
                            default:
                                return this.toString();
                        }
                    }
                },
        COOKIE((short) 357) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cookie";
                            default:
                                return this.toString();
                        }
                    }
                },
        FILLED_MAP((short) 358) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Map";
                            default:
                                return this.toString();
                        }
                    }
                },
        SHEARS((short) 359) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Shears";
                            default:
                                return this.toString();
                        }
                    }
                },
        MELON((short) 360) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Melon";
                            default:
                                return this.toString();
                        }
                    }
                },
        PUMPKIN_SEEDS((short) 361) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Pumpkin Seeds";
                            default:
                                return this.toString();
                        }
                    }
                },
        MELON_SEEDS((short) 362) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Melon Seeds";
                            default:
                                return this.toString();
                        }
                    }
                },
        BEEF((short) 363) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Raw Beef";
                            default:
                                return this.toString();
                        }
                    }
                },
        COOKED_BEEF((short) 364) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Steak";
                            default:
                                return this.toString();
                        }
                    }
                },
        CHICKEN((short) 365) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Raw Chicken";
                            default:
                                return this.toString();
                        }
                    }
                },
        COOKED_CHICKEN((short) 366) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cooked Chicken";
                            default:
                                return this.toString();
                        }
                    }
                },
        ROTTEN_FLESH((short) 367) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Rotten Flesh";
                            default:
                                return this.toString();
                        }
                    }
                },
        ENDER_PEARL((short) 368) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Ender Pearl";
                            default:
                                return this.toString();
                        }
                    }
                },
        BLAZE_ROD((short) 369) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Blaze Rod";
                            default:
                                return this.toString();
                        }
                    }
                },
        GHAST_TEAR((short) 370) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Ghast Tear";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLD_NUGGET((short) 371) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Gold Nugget";
                            default:
                                return this.toString();
                        }
                    }
                },
        POTION((short) 373) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Potion";
                            default:
                                return this.toString();
                        }
                    }
                },
        GLASS_BOTTLE((short) 374) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Glass Bottle";
                            default:
                                return this.toString();
                        }
                    }
                },
        SPIDER_EYE((short) 375) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Spider Eye";
                            default:
                                return this.toString();
                        }
                    }
                },
        FERMENTED_SPIDER_EYE((short) 376) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Fermented Spider Eye";
                            default:
                                return this.toString();
                        }
                    }
                },
        BLAZE_POWDER((short) 377) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Blaze Powder";
                            default:
                                return this.toString();
                        }
                    }
                },
        MAGMA_CREAM((short) 378) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Magma Cream";
                            default:
                                return this.toString();
                        }
                    }
                },
        ENDER_EYE((short) 381) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Eye of Ender";
                            default:
                                return this.toString();
                        }
                    }
                },
        SPECKLED_MELON((short) 382) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Glistering Melon";
                            default:
                                return this.toString();
                        }
                    }
                },
        SPAWN_EGG((short) 383) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 50:
                                return "Spawn Creeper";
                            case 51:
                                return "Spawn Skeleton";
                            case 52:
                                return "Spawn Spider";
                            case 54:
                                return "Spawn Zombie";
                            case 55:
                                return "Spawn Slime";
                            case 56:
                                return "Spawn Ghast";
                            case 57:
                                return "Spawn Pigman";
                            case 58:
                                return "Spawn Enderman";
                            case 59:
                                return "Spawn Cave Spider";
                            case 60:
                                return "Spawn Silverfish";
                            case 61:
                                return "Spawn Blaze";
                            case 62:
                                return "Spawn Magma Cube";
                            case 65:
                                return "Spawn Bat";
                            case 66:
                                return "Spawn Witch";
                            case 67:
                                return "Spawn Endermite";
                            case 68:
                                return "Spawn Guardian";
                            case 90:
                                return "Spawn Pig";
                            case 91:
                                return "Spawn Sheep";
                            case 92:
                                return "Spawn Cow";
                            case 93:
                                return "Spawn Chicken";
                            case 94:
                                return "Spawn Squid";
                            case 95:
                                return "Spawn Wolf";
                            case 96:
                                return "Spawn Mooshroom";
                            case 98:
                                return "Spawn Ocelot";
                            case 100:
                                return "Spawn Horse";
                            case 101:
                                return "Spawn Rabbit";
                            case 120:
                                return "Spawn Villager";
                            default:
                                return this.toString();
                        }
                    }
                },
        EXPERIENCE_BOTTLE((short) 384) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Bottle o' Enchanting";
                            default:
                                return this.toString();
                        }
                    }
                },
        FIRE_CHARGE((short) 385) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Fire Charge";
                            default:
                                return this.toString();
                        }
                    }
                },
        WRITABLE_BOOK((short) 386) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Book and Quill";
                            default:
                                return this.toString();
                        }
                    }
                },
        WRITTEN_BOOK((short) 387) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Written Book";
                            default:
                                return this.toString();
                        }
                    }
                },
        EMERALD((short) 388) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Emerald";
                            default:
                                return this.toString();
                        }
                    }
                },
        ITEM_FRAME((short) 389) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Item Frame";
                            default:
                                return this.toString();
                        }
                    }
                },
        CARROT((short) 391) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Carrot";
                            default:
                                return this.toString();
                        }
                    }
                },
        POTATO((short) 392) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Potato";
                            default:
                                return this.toString();
                        }
                    }
                },
        BAKED_POTATO((short) 393) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Baked Potato";
                            default:
                                return this.toString();
                        }
                    }
                },
        POISONOUS_POTATO((short) 394) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Poisonous Potato";
                            default:
                                return this.toString();
                        }
                    }
                },
        MAP((short) 395) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Empty Map";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLDEN_CARROT((short) 396) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Golden Carrot";
                            default:
                                return this.toString();
                        }
                    }
                },
        CARROT_ON_A_STICK((short) 398) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Carrot on a Stick";
                            default:
                                return this.toString();
                        }
                    }
                },
        NETHER_STAR((short) 399) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Nether Star";
                            default:
                                return this.toString();
                        }
                    }
                },
        PUMPKIN_PIE((short) 400) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Pumpkin Pie";
                            default:
                                return this.toString();
                        }
                    }
                },
        FIREWORKS((short) 401) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Firework Rocket";
                            default:
                                return this.toString();
                        }
                    }
                },
        FIREWORK_CHARGE((short) 402) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Firework Star";
                            default:
                                return this.toString();
                        }
                    }
                },
        ENCHANTED_BOOK((short) 403) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Enchanted Book";
                            default:
                                return this.toString();
                        }
                    }
                },
        COMPARATOR((short) 404) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Redstone Comparator";
                            default:
                                return this.toString();
                        }
                    }
                },
        NETHERBRICK((short) 405) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Nether Brick";
                            default:
                                return this.toString();
                        }
                    }
                },
        QUARTZ((short) 406) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Nether Quartz";
                            default:
                                return this.toString();
                        }
                    }
                },
        TNT_MINECART((short) 407) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Minecart with TNT";
                            default:
                                return this.toString();
                        }
                    }
                },
        HOPPER_MINECART((short) 408) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Minecart with Hopper";
                            default:
                                return this.toString();
                        }
                    }
                },
        PRISMARINE_SHARD((short) 409) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Prismarine Shard";
                            default:
                                return this.toString();
                        }
                    }
                },
        PRISMARINE_CRYSTALS((short) 410) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Prismarine Crystals";
                            default:
                                return this.toString();
                        }
                    }
                },
        RABBIT((short) 411) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Raw Rabbit";
                            default:
                                return this.toString();
                        }
                    }
                },
        COOKED_RABBIT((short) 412) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cooked Rabbit";
                            default:
                                return this.toString();
                        }
                    }
                },
        RABBIT_STEW((short) 413) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Rabbit Stew";
                            default:
                                return this.toString();
                        }
                    }
                },
        RABBIT_FOOT((short) 414) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Rabbit's Foot";
                            default:
                                return this.toString();
                        }
                    }
                },
        RABBIT_HIDE((short) 415) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Rabbit Hide";
                            default:
                                return this.toString();
                        }
                    }
                },
        ARMOR_STAND((short) 416) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Armor Stand";
                            default:
                                return this.toString();
                        }
                    }
                },
        IRON_HORSE_ARMOR((short) 417) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Iron Horse Armor";
                            default:
                                return this.toString();
                        }
                    }
                },
        GOLDEN_HORSE_ARMOR((short) 418) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Golden Horse Armor";
                            default:
                                return this.toString();
                        }
                    }
                },
        DIAMOND_HORSE_ARMOR((short) 419) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Diamond Horse Armor";
                            default:
                                return this.toString();
                        }
                    }
                },
        LEAD((short) 420) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Lead";
                            default:
                                return this.toString();
                        }
                    }
                },
        NAME_TAG((short) 421) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Name Tag";
                            default:
                                return this.toString();
                        }
                    }
                },
        COMMAND_BLOCK_MINECART((short) 422) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Minecart with Command Block";
                            default:
                                return this.toString();
                        }
                    }
                },
        MUTTON((short) 423) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Raw Mutton";
                            default:
                                return this.toString();
                        }
                    }
                },
        COOKED_MUTTON((short) 424) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cooked Mutton";
                            default:
                                return this.toString();
                        }
                    }
                },
        BANNER((short) 425) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Banner";
                            default:
                                return this.toString();
                        }
                    }
                },
        RECORD_13((short) 2256) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "13 Disc";
                            default:
                                return this.toString();
                        }
                    }
                },
        RECORD_CAT((short) 2257) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Cat Disc";
                            default:
                                return this.toString();
                        }
                    }
                },
        RECORD_BLOCKS((short) 2258) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Blocks Disc";
                            default:
                                return this.toString();
                        }
                    }
                },
        RECORD_CHIRP((short) 2259) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Chirp Disc";
                            default:
                                return this.toString();
                        }
                    }
                },
        RECORD_FAR((short) 2260) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Far Disc";
                            default:
                                return this.toString();
                        }
                    }
                },
        RECORD_MALL((short) 2261) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Mall Disc";
                            default:
                                return this.toString();
                        }
                    }
                },
        RECORD_MELLOHI((short) 2262) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Mellohi Disc";
                            default:
                                return this.toString();
                        }
                    }
                },
        RECORD_STAL((short) 2263) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Stal Disc";
                            default:
                                return this.toString();
                        }
                    }
                },
        RECORD_STRAD((short) 2264) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Strad Disc";
                            default:
                                return this.toString();
                        }
                    }
                },
        RECORD_WARD((short) 2265) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Ward Disc";
                            default:
                                return this.toString();
                        }
                    }
                },
        RECORD_11((short) 2266) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "11 Disc";
                            default:
                                return this.toString();
                        }
                    }
                },
        RECORD_WAIT((short) 2267) {
                    @Override
                    public String getName(short id) {
                        switch (id) {
                            case 0:
                                return "Wait Disc";
                            default:
                                return this.toString();
                        }
                    }
                },;

        public static final String DOMAIN = "minecraft";
        private final short legacyID;

        private VanillaMaterial(short legacyID) {
            this.legacyID = legacyID;
        }

        @Override
        public String getDomain() {
            return DOMAIN;
        }

        @Override
        public String getID() {
            return this.toString().toLowerCase();
        }

        @Override
        public abstract String getName(short meta);

        @Override
        @Deprecated
        public short getLegacyID() {
            return this.legacyID;
        }

        @Override
        public boolean isValidMeta(short meta) {
            return !this.toString().equals(this.getName(meta));
        }

    }

}
