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
package jp.llv.ce.cmd;

import jp.llv.ce.exception.CommandException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import jp.llv.ce.CrayAPI;
import jp.llv.ce.Msg;
import jp.llv.ce.server.EditCommandSender;
import net.md_5.bungee.api.ChatColor;

/**
 * コマンド基底クラス.
 *
 * @author Toyblocks
 */
public abstract class BaseCommand implements Completable {

    private static final Pattern NAME_PATTERN = Pattern.compile("^\\w+$");
    
    /*package*/ final String name;
    /*package*/ final Msg simpleUsage;
    /*package*/ final Msg[] usage;

    /*package*/ final String[] aliases;
    /*package*/ final boolean reqPerm;
    /*package*/ final int minArgs;
    /*package*/ final EditCommandSender.Type[] target;

    /*package*/ BaseCommand(String name, String[] aliases, Msg simpleUsage, Msg... usage) {
        if (name == null || simpleUsage == null || usage == null) {
            throw new NullPointerException();
        }
        if (Arrays.asList(usage).contains(null)) {
            throw new NullPointerException();
        }
        this.name = name;
        this.simpleUsage = simpleUsage;
        this.usage = usage;
        this.reqPerm = this.getClass().isAnnotationPresent(ReqPerm.class);
        this.aliases = aliases != null ? aliases : this.getClass().isAnnotationPresent(Aliases.class) ? this.getClass().getAnnotation(Aliases.class).value() : new String[0];
        this.minArgs = this.getClass().isAnnotationPresent(MinArgs.class) ? this.getClass().getAnnotation(MinArgs.class).value() : 0;
        this.target = this.getClass().isAnnotationPresent(SenderOnly.class) ? this.getClass().getAnnotation(SenderOnly.class).value() : null;
    }

    protected BaseCommand(String name, Msg... usage) {
        this(name, null, Msg.fromKey("cmd." + name + ".usage"), usage);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public final void execute(StringBuilder caller, EditCommandSender sender, List<String> args) {
        String permission = caller.append('.').append(this.name).toString();
        if (reqPerm && !sender.hasPermission(permission)) {
            Msg.fromKey("err.cmd.permission", permission).sendTo(sender);
            return;
        }

        if (this.target != null) {
            boolean isTarget = false;
            for (EditCommandSender.Type st : this.target) {
                if (sender.getType() == st) {
                    isTarget = true;
                    break;
                }
            }
            if (!isTarget) {
                Msg.fromKey("err.cmd.target").sendTo(sender);
                return;
            }
        }

        if (args.size() < this.minArgs) {
            Msg.fromKey("err.cmd.minarg").sendTo(sender);
            this.sendUsage(caller, sender);
            return;
        }

        if (args.size() >= 1 && args.get(0).equalsIgnoreCase("help")) {
            this.sendUsage(caller, sender);
            return;
        }

        try {
            this.preRun(caller, sender, args);
        } catch (CommandException ex) {
            sender.sendMessage(ex.getMessage());
        } catch (Exception ex) {
            CrayAPI.Container.getAPI().debug("Internal command error", ex);
            Msg.fromKey("err.cmd.internal").sendTo(sender);
        }
    }

    /*package*/ void preRun(StringBuilder caller, EditCommandSender sender, List<String> args) throws CommandException {
        this.run(sender, args);
    }

    protected abstract void run(EditCommandSender sender, List<String> args) throws CommandException;

    @Override
    public final List<String> tabComplete(StringBuilder caller, EditCommandSender sender, List<String> args) {
        if (reqPerm && !sender.hasPermission(caller.append('.').append(this.name).toString())) {
            return Collections.EMPTY_LIST;//Not enough permission
        }
        try {
            List<String> result = this.preComplete(caller, sender, args);
            return result != null ? result : Collections.EMPTY_LIST;
        } catch (Exception ex) {
            CrayAPI.Container.getAPI().debug("Internal command complete error", ex);
            return Collections.EMPTY_LIST;
        }
    }

    /*package*/ List<String> preComplete(StringBuilder caller, EditCommandSender sender, List<String> args) {
        return this.complete(sender, args);
    }

    protected abstract List<String> complete(EditCommandSender sender, List<String> args);

    @Override
    public final void sendSimpleUsage(StringBuilder caller, EditCommandSender sendTo) {
        sendTo.sendMessage(ChatColor.translateAlternateColorCodes('&', caller.append(" &a").append(this.name).append(" &d").append(this.simpleUsage.toString()).toString()));
    }

    public void sendUsage(StringBuilder caller, EditCommandSender sendTo) {
        this.sendSimpleUsage(caller, sendTo);
        for (Msg m : this.usage) {
            m.sendTo(sendTo);
        }
    }

}
