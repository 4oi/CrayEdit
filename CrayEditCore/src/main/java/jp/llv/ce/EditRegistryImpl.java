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
package jp.llv.ce;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import jp.llv.ce.cmd.*;
import jp.llv.ce.cmd.internal.*;
import jp.llv.ce.region.Region;
import jp.llv.ce.region.function.*;
import jp.llv.ce.region.owned.OwnedAbsoluteRegion;
import jp.llv.ce.region.owned.RegionOwner;
import jp.llv.ce.region.relative.RelativeRegion;
import jp.llv.ce.tool.ToolSupplier;

/**
 *
 * @author Toyblocks
 */
public class EditRegistryImpl implements EditRegistry {

    private static final Pattern TOOL_NAME_PATTERN = Pattern.compile("^\\w+$");
    private static final Pattern FUNCTION_NAME_PATTERN = Pattern.compile("^[a-zA-Z_]\\w*$");
    
    private final Map<String, ToolSupplier> toolRegistry = new HashMap<>();
    private final Map<Class<?>, Map<String, AbsoluteRegionFunction<?>>> absoluteRegionFunctionRegistry = new HashMap<>();
    private final Map<Class<?>, Map<String, RelativeRegionFunction<?>>> relativeRegionFunctionRegistry = new HashMap<>();
    private final RootCommand command;

    public EditRegistryImpl() {
        this.command = new RootCommand(
                new ParentCommand("unfixedit", new String[]{"ue"},
                        new VersionCommand(),
                        new EmptyCommand()
                ));
    }

    @Override
    public RootCommand getCommand() {
        return this.command;
    }

    @Override
    public void register(Object registrant, ToolSupplier<?> tool, String...names) {
        if (tool == null || names == null) {
            throw new NullPointerException();
        }
        for (String k : names) {
            if (k == null || !TOOL_NAME_PATTERN.matcher(k).matches()) {
                continue;
            }
            this.toolRegistry.put(k, tool);
        }
    }
    
    @Override
    public <R extends Region> void register(Object registrant, Class<? extends R> clazz, AbsoluteRegionFunction<R> func, String... names) {
        if (clazz == null || func == null || names == null) {
            throw new NullPointerException();
        }
        if (!this.absoluteRegionFunctionRegistry.containsKey(clazz)) {
            this.absoluteRegionFunctionRegistry.put(clazz, new HashMap<>());
        }
        Map<String, AbsoluteRegionFunction<?>> m = this.absoluteRegionFunctionRegistry.get(clazz);
        for (String k : names) {
            if (k == null || !FUNCTION_NAME_PATTERN.matcher(k).matches()) {
                continue;
            }
            m.put(k, func);
        }
    }

    @Override
    public <R extends RelativeRegion> void register(Object registrant, Class<? extends R> clazz, RelativeRegionFunction<R> func, String... names) {
        if (clazz == null || func == null || names == null) {
            throw new NullPointerException();
        }
        if (!this.relativeRegionFunctionRegistry.containsKey(clazz)) {
            this.relativeRegionFunctionRegistry.put(clazz, new HashMap<>());
        }
        Map<String, RelativeRegionFunction<?>> m = this.relativeRegionFunctionRegistry.get(clazz);
        for (String k : names) {
            if (k == null || !FUNCTION_NAME_PATTERN.matcher(k).matches()) {
                continue;
            }
            m.put(k, func);
        }
    }

    public Optional<ToolSupplier<?>> getTool(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        return Optional.ofNullable(this.toolRegistry.get(name));
    }
    
    public <R extends Region> Optional<AbsoluteRegionFunction<R>> getAbsoluteRegionFunction(Class<? extends R> clazz, String name) {
        if (clazz == null || name == null) {
            throw new NullPointerException();
        }
        Class<?> c = clazz;
        do {
            Map<String, AbsoluteRegionFunction<?>> m = this.absoluteRegionFunctionRegistry.get(c);
            if (m == null) {
                continue;
            }
            AbsoluteRegionFunction<R> f = (AbsoluteRegionFunction<R>) m.get(name);
            if (f == null) {
                continue;
            }
            return Optional.of(f);
        } while (Region.class.isAssignableFrom((c = c.getSuperclass())));
        return Optional.empty();
    }

    public <R extends RelativeRegion> Optional<RelativeRegionFunction<R>> getRelativeRegionFunction(Class<? extends R> clazz, String name) {
        if (clazz == null || name == null) {
            throw new NullPointerException();
        }
        Class<?> c = clazz;
        do {
            Map<String, RelativeRegionFunction<?>> m = this.relativeRegionFunctionRegistry.get(c);
            if (m == null) {
                continue;
            }
            RelativeRegionFunction<R> f = (RelativeRegionFunction<R>) m.get(name);
            if (f == null) {
                continue;
            }
            return Optional.of(f);
        } while (RelativeRegion.class.isAssignableFrom((c = c.getSuperclass())));
        Optional<AbsoluteRegionFunction<Region>> absoluteFunctionOptional = this.getAbsoluteRegionFunction(Region.class, name);
        if (absoluteFunctionOptional.isPresent()) {
            /* tmp convert into an absolute one, apply absolute func, and put back */
            final AbsoluteRegionFunction<Region> absoluteFunction = absoluteFunctionOptional.get();
            return Optional.of((ownedRelative, args) -> {
                RegionOwner owner = ownedRelative.getOwner();
                RelativeRegion relative = ownedRelative.getSource();
                Region absolute = ownedRelative.toRegion();
                OwnedAbsoluteRegion<Region> ownedAbsolute = ownedRelative.override(absolute);
                absoluteFunction.accept(ownedAbsolute, args);
                ownedAbsolute.override(relative);
            });
        }
        return Optional.empty();
    }

}
