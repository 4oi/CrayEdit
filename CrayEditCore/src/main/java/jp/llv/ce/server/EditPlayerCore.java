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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import jp.llv.ce.region.Region;
import jp.llv.ce.region.owned.OwnedAbsoluteRegion;
import jp.llv.ce.region.owned.OwnedRegion;
import jp.llv.ce.region.owned.OwnedRelativeRegion;
import jp.llv.ce.region.relative.RelativeRegion;

/**
 *
 * @author Toyblocks
 */
public abstract class EditPlayerCore implements EditPlayer {

    private final Map<Integer, OwnedRegion> regions = new HashMap<>();
    private OwnedRegion current;

    @Override
    public Collection<? extends OwnedRegion> getRegions() {
        return this.regions.values();
    }

    @Override
    public OwnedRegion getCurrentRegion() {
        return this.current;
    }

    @Override
    public OwnedRegion getRegion(int id) {
        return this.regions.get(id);
    }

    private int getNextID() {
        for (int i = 1;; i++) {
            if (!regions.containsKey(i)) {
                return i;
            }
        }
    }

    @Override
    public boolean containsRegion(OwnedRegion region) {
        return this.getRegions().stream().anyMatch(or -> or.equals(region));
    }

    @Override
    public <R extends Region> OwnedAbsoluteRegion<R> addRegion(R region) {
        if (region == null) {
            throw new NullPointerException();
        }
        int id = this.getNextID();
        OwnedAbsoluteRegion o = new OwnedAbsoluteRegion(region, this, id);
        this.regions.put(id, o);
        this.current = o;
        return o;
    }

    @Override
    public <R extends RelativeRegion> OwnedRelativeRegion<R> addRegion(R region) {
        if (region == null) {
            throw new NullPointerException();
        }
        int id = this.getNextID();
        OwnedRelativeRegion o = new OwnedRelativeRegion(region, this, id);
        this.regions.put(id, o);
        this.current = o;
        return o;
    }

    @Override
    public void removeRegion(OwnedRegion region) {
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        if (st[st.length - 3].getClassName().equals(this.getClass().getName())) {
            return;
        }
        if (!this.containsRegion(region)) {
            throw new IllegalStateException();
        }
        this.regions.remove(region.getID());
        if (this.current == region) {
            this.current = null;
        }
        region.remove();
    }

}
