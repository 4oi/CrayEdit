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
package jp.llv.ce.region;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jp.llv.ce.region.relative.RelativeORContainer;
import jp.llv.ce.region.relative.RelativeRegion;

/**
 * 絶対領域. 絶対座標に依存する領域であり、他意はない!
 *
 * @author Toyblocks
 */
public abstract class Region implements Iterable<Point> {

    public Region() {
    }

    public abstract Collection<Point> toPoints();

    @Override
    public final Iterator<Point> iterator() {
        return this.toPoints().iterator();
    }
    
    public Region aggregate() {
        return new ORContainer(Collections.unmodifiableCollection(this.toPoints()));
    }

    public RelativeRegion relativize(Point origin) {
        Set<RelativeRegion> result = new HashSet<>();
        this.toPoints().stream().forEach(p->result.add(p.relativize(origin)));
        return new RelativeORContainer(result);
    }

    @Override
    public int hashCode() {
        return this.toPoints().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Region)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Region other = (Region) obj;
        return this.toPoints().equals(other.toPoints());
    }

}
