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

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;
import jp.llv.ce.server.bukkit.BukkitServer;
import org.bukkit.Bukkit;
import org.bukkit.Server;

/**
 *
 * @author Toyblocks
 */
public class BukkitServerImpl implements BukkitServer {

    private final Server server;
    
    public BukkitServerImpl(Server server) {
        this.server = server;
    }
    
    @Override
    public BukkitWorldImpl getWorld(String name) {
        return new BukkitWorldImpl(this.server.getWorld(name));
    }

    @Override
    public BukkitWorldImpl getWorld(UUID uuid) {
        return new BukkitWorldImpl(this.server.getWorld(uuid));
    }

    @Override
    public Collection<BukkitWorldImpl> getWorlds() {
        return this.server.getWorlds().stream().map(BukkitWorldImpl::new).collect(Collectors.toSet());
    }

    @Override
    public BukkitPlayerImpl getPlayer(String id) {
        return new BukkitPlayerImpl(this.server.getPlayer(id));
    }

    @Override
    public BukkitPlayerImpl getPlayer(UUID uuid) {
        return new BukkitPlayerImpl(this.server.getPlayer(uuid));
    }

    @Override
    public Collection<BukkitPlayerImpl> getPlayers() {
        return this.server.getOnlinePlayers().stream().map(BukkitPlayerImpl::new).collect(Collectors.toSet());
    }

    @Override
    public BukkitCommandSenderImpl getConsole() {
        return new BukkitCommandSenderImpl(this.server.getConsoleSender());
    }
    
    public Server getSource() {
        return this.server;
    }

    @Override
    public String getAPIVersion() {
        return Bukkit.getBukkitVersion();
    }

    @Override
    public String getVersion() {
        return Bukkit.getVersion();
    }
    
}
