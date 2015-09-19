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

import jp.llv.ce.cmd.RootCommand;
import jp.llv.ce.region.Region;
import jp.llv.ce.region.function.AbsoluteRegionFunction;
import jp.llv.ce.region.function.RelativeRegionFunction;
import jp.llv.ce.region.relative.RelativeRegion;
import jp.llv.ce.tool.ToolSupplier;

/**
 * 
 * @author Toyblocks
 */
public interface EditRegistry {
    
    void register(ToolSupplier<?> tool, String...names);
    
    <R extends Region> void register(Class<? extends R> clazz, AbsoluteRegionFunction<R> func, String... names);
    
    <R extends RelativeRegion> void register(Class<? extends R> clazz, RelativeRegionFunction<R> func, String... names);
    
    
    
    RootCommand getCommand();
    
}
