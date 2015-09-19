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
package jp.llv.ce.cmd.internal;

import java.util.List;
import static jp.llv.ce.UnfixedAPI.Container.getAPI;
import jp.llv.ce.cmd.Aliases;
import jp.llv.ce.cmd.BaseCommand;
import jp.llv.ce.exception.CommandException;
import jp.llv.ce.server.EditCommandSender;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;

/**
 *
 * @author Toyblocks
 */
@Aliases("v")
public class VersionCommand extends BaseCommand {

    public VersionCommand() {
        super("version");
    }

    @Override
    protected void run(EditCommandSender sender, List<String> args) throws CommandException {
        sender.sendMessage(new ComponentBuilder("Unfix").color(ChatColor.LIGHT_PURPLE)
                .append("Ed").color(ChatColor.RED)
                .append("it ").color(ChatColor.LIGHT_PURPLE)
                .append(getAPI().getVersion()).color(ChatColor.GOLD)
                .append(" with API ").color(ChatColor.WHITE)
                .append(getAPI().getAPIVersion()).color(ChatColor.GOLD)
                .append(" on Native Server ").color(ChatColor.WHITE)
                .append(getAPI().getServer().getVersion()).color(ChatColor.GOLD)
                .append(" with API  ").color(ChatColor.WHITE)
                .append(getAPI().getServer().getAPIVersion()).color(ChatColor.GOLD).create()
        );
    }

    @Override
    protected List<String> complete(EditCommandSender sender, List<String> args) {
        return null;
    }

}
