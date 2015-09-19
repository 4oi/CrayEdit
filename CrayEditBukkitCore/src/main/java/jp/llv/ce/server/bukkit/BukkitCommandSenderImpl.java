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

import java.util.Arrays;
import java.util.stream.Collectors;
import jp.llv.ce.server.EditCommandSender;
import jp.llv.ce.server.bukkit.BukkitCommandSender;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.minecart.CommandMinecart;

/**
 *
 * @author Toyblocks
 */
public class BukkitCommandSenderImpl implements BukkitCommandSender {

    private final CommandSender sender;
    private BukkitWorldImpl world;
    
    public BukkitCommandSenderImpl(CommandSender sender) {
        if (sender == null) throw new NullPointerException();
        this.sender = sender;
    }
            
    @Override
    public boolean hasPermission(String permission) {
        return this.sender.hasPermission(permission);
    }

    @Override
    public void sendMessage(ChatMessageType type, BaseComponent ... message) {
        this.sender.sendMessage(Arrays.stream(message).map(bc -> bc.toPlainText()).collect(Collectors.joining()));
    }

    @Override
    public Type getType() {
        if (sender instanceof Player) {
            return EditCommandSender.Type.PLAYER;
        } else if (sender instanceof ConsoleCommandSender) {
            return EditCommandSender.Type.CONSOLE;
        } else if  (sender instanceof BlockCommandSender) {
            return EditCommandSender.Type.COMMAND_BLOCK;
        } else if (sender instanceof CommandMinecart) {
            return EditCommandSender.Type.COMMAND_MINECART;
        } else {
            return EditCommandSender.Type.OTHER;
        }
    }

    @Override
    public BukkitWorldImpl getWorld() {
        return this.world;
    }
    
    public void setWorld(BukkitWorldImpl world) {
        this.world = world;
    }
    
    public CommandSender getSource() {
        return this.sender;
    }
    
}
