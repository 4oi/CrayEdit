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
import java.util.Set;
import jp.llv.ce.math.NumUtil;
import jp.llv.ce.math.rcs.Vector;
import jp.llv.ce.region.Point;

/**
 * 絶対的一点を示す領域. イミュータブル
 *
 * @author Toyblocks
 */
public class RelativePoint extends RelativeRegion {

    public static final RelativePoint ORIGIN = new RelativePoint(0, 0, 0);

    private final short x, y, z;

    public RelativePoint(int x, int y, int z) {
        this.x = (short) x;
        this.z = (short) z;
        if (y < -255 || y > 255) {
            throw new IllegalArgumentException("There cannot be a block");
        }
        this.y = (short) y;
    }

    public RelativePoint(Vector v) {
        this(NumUtil.floor(v.getX()), NumUtil.floor(v.getY()), NumUtil.floor(v.getZ()));
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public RelativePoint add(int x, int y, int z) {
        return new RelativePoint(this.getX() + x, this.getY() + y, this.getZ() + z);
    }

    public RelativePoint add(RelativePoint p) {
        return this.add(p.getX(), p.getY(), p.getZ());
    }

    @Deprecated
    public RelativePoint add(Vector v) {
        return this.add((int) Math.round(v.getX()), (int) Math.round(v.getY()), (int) Math.round(v.getZ()));
    }

    public RelativePoint multiply(double x, double y, double z) {
        return new RelativePoint(NumUtil.floor(this.getX() * x), NumUtil.floor(this.getY() * y), NumUtil.floor(this.getZ() * z));
    }

    public RelativePoint multiply(double m) {
        return this.multiply(m, m, m);
    }

    public double distance(RelativePoint o) {
        return Math.sqrt(this.distanceSquared(o));
    }

    public double distanceSquared(RelativePoint o) {
        return Math.pow(this.getX() - o.getX(), 2.0) + Math.pow(this.getY() - o.getY(), 2.0) + Math.pow(this.getZ() - o.getZ(), 2.0);
    }

    public Vector getVectorTo(RelativePoint loc) {
        return new Vector(loc.getX() - this.getX(), loc.getY() - this.getY(), loc.getZ() - this.getZ());
    }

    public Vector toPoint3d() {
        return new Vector(this.getX(), this.getY(), this.getZ());
    }

    @Override
    public Set<RelativePoint> toPoints() {
        return Collections.singleton(this);
    }
    
    @Override
    public RelativePoint move(int x, int y, int z) {
        return this.add(x, y, z);
    }

    @Override
    public RelativeRegion aggregate() {
        return this;
    }

    @Override
    public Point absolutize(Point origin) {
        return origin.add(this);
    }

    @Override
    public String toString() {
        return "{~" + this.getX() + ",~" + this.getY() + ",~" + this.getZ() + "}";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.x;
        hash = 31 * hash + this.y;
        hash = 31 * hash + this.z;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RelativePoint)) {
            return false;
        }
        final RelativePoint other = (RelativePoint) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.z != other.z) {
            return false;
        }
        return this.y == other.y;
    }

}
