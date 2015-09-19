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
import jp.llv.ce.math.rcs.Point3d;
import jp.llv.ce.server.EditPlayerCore;
import jp.llv.ce.server.bukkit.util.PlayerUtil;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 *
 * @author Toyblocks
 */
public class BukkitPlayerImpl extends EditPlayerCore implements BukkitPlayer {

    private final Player player;

    public BukkitPlayerImpl(Player player) {
        this.player = player;
    }

    @Override
    public String getName() {
        return this.player.getName();
    }

    @Override
    public UUID getUUID() {
        return this.player.getUniqueId();
    }

    @Override
    public boolean hasPermission(String permission) {
        return this.player.hasPermission(permission);
    }

    @Override
    public void sendMessage(ChatMessageType type, BaseComponent ... message) {
        PlayerUtil.sendMessage(type, player, message);
    }

    @Override
    public Type getType() {
        return Type.PLAYER;
    }

    @Override
    public BukkitWorldImpl getWorld() {
        return new BukkitWorldImpl(this.player.getWorld());
    }

    @Override
    public Point3d getLocation() {
        Location l = this.player.getLocation();
        return new Point3d(l.getX(), l.getY(), l.getZ());
    }
    
    public Player getSource() {
        return this.player;
    }
    
}
