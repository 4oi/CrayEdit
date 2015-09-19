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
package jp.llv.ce.listener;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jp.llv.ce.UnfixEditBukkit;
import jp.llv.ce.cmd.RootCommand;
import jp.llv.ce.server.bukkit.BukkitCommandSenderImpl;
import jp.llv.ce.server.bukkit.BukkitPlayerImpl;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

/**
 *
 * @author Toyblocks
 */
public class CommandListener implements Listener {

    private final UnfixEditBukkit plugin;
    private final Pattern commandPattern = Pattern.compile("^/?:(.*)$");
    private final RootCommand commandHandler;

    public CommandListener(UnfixEditBukkit plugin, RootCommand command) {
        if (command == null) {
            throw new NullPointerException();
        }
        this.plugin = plugin;
        this.commandHandler = command;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void on(PlayerCommandPreprocessEvent e) {
        Matcher m = commandPattern.matcher(e.getMessage());
        if (!m.matches()) {
            return;
        }
        String main = m.group(1);
        List<String> args = new LinkedList<>(Arrays.asList(main.split(" ")));
        e.setCancelled(true);
        this.commandHandler.execute(new BukkitPlayerImpl(e.getPlayer()), args);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void on(AsyncPlayerChatEvent e) {
        Matcher m = commandPattern.matcher(e.getMessage());
        if (!m.matches()) {
            return;
        }
        String main = m.group(1);
        List<String> args = new LinkedList<>(Arrays.asList(main.split(" ")));
        e.setCancelled(true);
        this.plugin.getServer().getScheduler().runTask(this.plugin, ()
                -> this.commandHandler.execute(new BukkitPlayerImpl(e.getPlayer()), args));
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void on(PlayerChatTabCompleteEvent e) {
        Matcher m = commandPattern.matcher(e.getChatMessage());
        if (!m.matches()) {
            return;
        }
        String main = m.group(1);
        List<String> args = new LinkedList<>(Arrays.asList(main.split(" ")));
        if (e.getTabCompletions() != null) {
            List<String> completions = commandHandler.tabComplete(new BukkitPlayerImpl(e.getPlayer()), args);
            try {
                e.getTabCompletions().clear();
                e.getTabCompletions().addAll(completions);
            } catch (UnsupportedOperationException ex) {
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void on(ServerCommandEvent e) {
        Matcher m = commandPattern.matcher(e.getCommand());
        if (!m.matches()) {
            return;
        }
        String main = m.group(1);
        List<String> args = new LinkedList<>(Arrays.asList(main.split(" ")));
        e.setCancelled(true);
        this.commandHandler.execute(new BukkitCommandSenderImpl(e.getSender()), args);
    }

}
