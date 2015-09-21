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
package jp.llv.ce.server;

import java.util.UUID;
import jp.llv.ce.math.rcs.Point3d;
import jp.llv.ce.region.owned.RegionOwner;

/**
 *
 * @author Toyblocks
 */
public interface EditPlayer extends EditCommandSender, RegionOwner {
    
    String getName();
    
    default String getPerfix() {
        return "";
    }
    
    default String getFullName() {
        return this.getName();
    }
    
    default String getSuffix() {
        return "";
    }
    
    UUID getUUID();
    
    Point3d getLocation();
    
    boolean isSneaking();
    
    EditItem getItemInMainhand();
    
    EditItem getItemInOffhand();
    
}
