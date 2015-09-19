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
package jp.llv.ce.region.owned;

import jp.llv.ce.region.Region;
import jp.llv.ce.regions.relative.RelativeRegion;

/**
 *
 * @author Toyblocks
 * @param <T> Type of source
 */
public abstract class OwnedRegion<T> {
    
    /*package*/ final RegionOwner owner;
    /*package*/ final int id;
    /*package*/ boolean invalid = false;
    
    /*package*/ OwnedRegion(RegionOwner player, int id) {
        if (player == null) {
            throw new NullPointerException();
        }
        this.owner = player;
        this.id = id;
    }

    public abstract Region toRegion();
    
    public final RegionOwner getOwner() {
        if (invalid) {
            throw new IllegalStateException();
        }
        return this.owner;
    }
    
    public final int getID() {
        if (invalid) {
            throw new IllegalStateException();
        }
        return this.id;
    }
    
    public abstract T getSource();
    
    public final void remove() {
        if (invalid) {
            throw new IllegalStateException();
        }
        this.invalid = true;
        this.owner.removeRegion(this);
    }
    
    public final <R extends Region> OwnedAbsoluteRegion<R> override(R region) {
        if (invalid) {
            throw new IllegalStateException();
        }
        this.remove();
        return this.owner.addRegion(region);
    }
    
    public final <R extends RelativeRegion> OwnedRelativeRegion<R> override(R region) {
        if (invalid) {
            throw new IllegalStateException();
        }
        this.remove();
        return this.owner.addRegion(region);
    }
    
}
