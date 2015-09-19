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
package jp.llv.ce.regions.relative;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jp.llv.ce.exception.LocationOutOfRangeException;
import jp.llv.ce.math.NumUtil;
import jp.llv.ce.math.rcs.Vector;
import jp.llv.ce.region.ORContainer;
import jp.llv.ce.region.Point;
import jp.llv.ce.region.Region;

/**
 * 相対領域
 *
 * @author Toyblocks
 */
public abstract class RelativeRegion implements Iterable<RelativePoint> {

    public abstract Collection<RelativePoint> toPoints();

    @Override
    public final Iterator<RelativePoint> iterator() {
        return this.toPoints().iterator();
    }

    public RelativeRegion move(int x, int y, int z) {
        Set<RelativePoint> result = new HashSet<>();
        for (RelativePoint p : this) {
            result.add(p.add(x, y, z));
        }
        return new RelativeORContainer(result);
    }

    public final RelativeRegion move(RelativePoint relative) {
        return this.move(relative.getX(), relative.getY(), relative.getZ());
    }

    @Deprecated
    public final RelativeRegion move(Vector v) {
        return this.move(NumUtil.floor(v.getX()), NumUtil.floor(v.getY()), NumUtil.floor(v.getZ()));
    }

    public RelativeCuboid toCuboid() {
        Collection<RelativePoint> ps = this.toPoints();
        if (ps.isEmpty()) {
            return null;
        }
        int ex = ps.stream().mapToInt(RelativePoint::getX).max().getAsInt();
        int ey = ps.stream().mapToInt(RelativePoint::getY).max().getAsInt();
        int ez = ps.stream().mapToInt(RelativePoint::getZ).max().getAsInt();
        int sx = ps.stream().mapToInt(RelativePoint::getX).min().getAsInt();
        int sy = ps.stream().mapToInt(RelativePoint::getY).min().getAsInt();
        int sz = ps.stream().mapToInt(RelativePoint::getZ).min().getAsInt();
        return new RelativeCuboid(new RelativePoint(sx, sy, sz), new RelativePoint(ex, ey, ez));
    }
    
    public RelativeRegion aggregate() {
        return new RelativeORContainer(Collections.unmodifiableCollection(this.toPoints()));
    }

    public Region absolutize(Point origin) {
        Set<Region> result = new HashSet<>();
        for (RelativePoint p : this) {
            try {
                result.add(p.absolutize(origin));
            } catch (LocationOutOfRangeException ex) {
                //Lost
            }
        }
        return new ORContainer(result);
    }

    @Override
    public boolean equals(Object o) {
        return this.toPoints().equals(o);
    }

    @Override
    public int hashCode() {
        return this.toPoints().hashCode();
    }

}
