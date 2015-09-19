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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.llv.ce.Msg;
import jp.llv.ce.server.EditCommandSender;

/**
 *
 * @author Toyblocks
 */
@MinArgs(1)
public class ParentCommand extends BaseCommand {

    private final Map<String, Executable> commandMap = new HashMap<>();

    public ParentCommand(String name, String[] aliases, Msg simpleUsage, Executable... commands) {
        super(name, aliases, simpleUsage);
        for (Executable bc : commands) {
            if (!(bc instanceof BaseCommand)) {
                continue;
            }
            for (String alias : ((BaseCommand) bc).aliases) {
                this.commandMap.put(alias, bc);
            }
        }
        for (Executable bc : commands) {
            this.commandMap.put(bc.getName(), bc);
        }
    }

    public ParentCommand(String name, String[] aliases, Executable... commands) {
        this(name, aliases, Msg.fromKey("cmd." + name + ".usage"), commands);
    }

    public ParentCommand(String name, Msg simpleUsage, Executable... commands) {
        this(name, null, simpleUsage, commands);
    }

    public ParentCommand(String name, Executable... commands) {
        this(name, Msg.fromKey("cmd." + name + ".usage"), commands);
    }

    @Override
    /*package*/ void preRun(StringBuilder caller, EditCommandSender sender, List<String> args) throws CommandException {
        Executable toExe = this.commandMap.get(args.get(0));
        if (toExe == null) {
            Msg.fromKey("err.cmd.unknown", args.get(0)).sendTo(sender);
            return;
        }
        args.remove(0);
        toExe.execute(caller.append(' ').append(this.name), sender, args);
    }

    @Override
    protected void run(EditCommandSender sender, List<String> args) {
        throw new UnsupportedOperationException("ParentCommand has no implementation. Use #preRun instead of #run.");
    }

    @Override
    /*package*/ List<String> preComplete(StringBuilder caller, EditCommandSender sender, List<String> args) {
        if (args.isEmpty()) {
            return new ArrayList<>(this.commandMap.keySet());
        }
        if (args.size() == 1) {
            List<String> result = new ArrayList<>();
            this.commandMap.keySet().stream().filter(k -> k.startsWith(args.get(0))).forEach(result::add);
            return result;
        }
        Executable toExe = this.commandMap.get(args.get(0));
        if (toExe == null || !(toExe instanceof Completable)) {
            return Collections.EMPTY_LIST;
        }

        args.remove(0);
        return ((Completable) toExe).tabComplete(caller.append('.').append(this.name), sender, args);
    }

    @Override
    protected List<String> complete(EditCommandSender sender, List<String> args) {
        throw new UnsupportedOperationException("ParentCommand has no implementation. Use #preComplete instead of #complete.");
    }

    public void put(String name, Executable command) throws IllegalStateException {
        if (this.commandMap.containsKey(name)) {
            throw new IllegalStateException("That name is already in use");
        }
        this.commandMap.put(name, command);
    }

    public Executable get(String name) {
        return this.commandMap.get(name);
    }

    @Override
    public void sendUsage(StringBuilder caller, EditCommandSender sendTo) {
        super.sendUsage(caller, sendTo);
        caller.append(' ').append(this.name);
        this.commandMap.values().stream().forEach(e -> e.sendSimpleUsage(caller, sendTo));
    }

}
