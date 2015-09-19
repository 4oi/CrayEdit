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

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.IntStream;
import jp.llv.ce.region.relative.RelativeCuboid;

/**
 *
 * @author Toyblocks
 */
public class Cuboid extends Region {

    private final Point p1, p2;

    public Cuboid(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public Set<Point> toPoints() {
        boolean xf = p1.getX() < p2.getX(),
                yf = p1.getY() < p2.getY(),
                zf = p1.getZ() < p2.getZ();
        Set<Point> result = new LinkedHashSet<>();
        IntStream.rangeClosed(yf ? p1.getY() : p2.getY(), yf ? p2.getY() : p1.getY()).forEach(y -> {
            IntStream.rangeClosed(xf ? p1.getX() : p2.getX(), xf ? p2.getX() : p1.getX()).forEach(x -> {
                IntStream.rangeClosed(zf ? p1.getZ() : p2.getZ(), zf ? p2.getZ() : p1.getZ()).forEach(z -> {
                    result.add(new Point(x, y, z));
                });
            });
        });
        return Collections.unmodifiableSet(result);
    }

    @Override
    public RelativeCuboid relativize(Point origin) {
        return new RelativeCuboid(this.p1.relativize(origin), this.p2.relativize(origin));
    }

}
