/*
 * Copyright (C) 2015 Toyblocks
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
package jp.llv.ce;

import java.util.logging.Logger;
import jp.llv.ce.UnfixedAPICoreLevelImpl;
import jp.llv.ce.UnfixedBukkitAPI;
import jp.llv.ce.server.bukkit.BukkitServerImpl;

/**
 *
 * @author Toyblocks
 */
public final class UnfixedAPIBukkitImpl extends UnfixedAPICoreLevelImpl implements UnfixedBukkitAPI {

    private final UnfixEditBukkit plugin;
    private final BukkitServerImpl server;

    public UnfixedAPIBukkitImpl(UnfixEditBukkit plugin) {
        this.plugin = plugin;
        this.server = new BukkitServerImpl(plugin.getServer());
    }
    
    @Override
    public BukkitServerImpl getServer() {
        return this.server;
    }

    @Override
    public Logger getLogger() {
        return this.plugin.getLogger();
    }
    
}
