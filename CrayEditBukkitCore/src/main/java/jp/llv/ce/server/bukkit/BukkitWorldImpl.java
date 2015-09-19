/*
 * Copyright (c) 2015 Toyblocks
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jp.llv.ce.server.bukkit;

import java.util.UUID;
import jp.llv.ce.server.bukkit.BukkitWorld;
import org.bukkit.World;

/**
 *
 * @author Toyblocks
 */
public class BukkitWorldImpl implements BukkitWorld {

    private final World world;

    public BukkitWorldImpl(World world) {
        this.world = world;
    }
    
    @Override
    public String getName() {
        return this.world.getName();
    }

    @Override
    public UUID getUUID() {
        return this.world.getUID();
    }
    
    public World getSource() {
        return this.world;
    }
    
}
