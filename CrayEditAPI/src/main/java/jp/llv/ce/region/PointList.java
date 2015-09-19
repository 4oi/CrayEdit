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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import jp.llv.ce.region.relative.RelativePoint;
import jp.llv.ce.region.relative.RelativePointList;
import jp.llv.ce.region.relative.RelativeRegion;

/**
 *
 * @author Toyblocks
 */
public class PointList extends Region {

    private final List<Point> points;
    
    public PointList(Point ... points) {
        if (points == null) throw new NullPointerException();
        this.points = Collections.unmodifiableList(Arrays.asList(points));
    }
    
    public PointList(Collection<Point> points) {
        this(points.toArray(new Point[points.size()]));
    }
    
    @Override
    public List<Point> toPoints() {
        return this.points;
    }

    @Override
    public RelativeRegion relativize(Point origin) {
        return new RelativePointList(
                this.points.stream().map(r -> r.relativize(origin)).toArray(RelativePoint[]::new)
        );
    }

    @Override
    public Region aggregate() {
        return this;
    }
    
}
