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

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.IntStream;
import jp.llv.ce.region.Cuboid;
import jp.llv.ce.region.Point;
import jp.llv.ce.region.Region;

/**
 *
 * @author Toyblocks
 */
public class RelativeCuboid extends RelativeRegion {

    private final RelativePoint p1, p2;

    public RelativeCuboid(RelativePoint p1, RelativePoint p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    
    @Override
    public Set<RelativePoint> toPoints() {
        boolean xf = p1.getX() < p2.getX(),
                yf = p1.getY() < p2.getY(),
                zf = p1.getZ() < p2.getZ();
        Set<RelativePoint> result = new LinkedHashSet<>();
        IntStream.rangeClosed(yf ? p1.getY() : p2.getY(), yf ? p2.getY() : p1.getY()).forEach(y -> {
            IntStream.rangeClosed(xf ? p1.getX() : p2.getX(), xf ? p2.getX() : p1.getX()).forEach(x -> {
                IntStream.rangeClosed(zf ? p1.getZ() : p2.getZ(), zf ? p2.getZ() : p1.getZ()).forEach(z -> {
                    result.add(new RelativePoint(x, y, z));
                });
            });
        });
        return Collections.unmodifiableSet(result);
    }
    
    @Override
    public RelativeCuboid move(int x, int y, int z) {
        return new RelativeCuboid(p1.move(x, y, z), p2.move(x, y, z));
    }

    @Override
    public Region absolutize(Point origin) {
        return new Cuboid(p1.absolutize(origin), p2.absolutize(origin));
    }
    
}
