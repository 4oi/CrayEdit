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
import java.util.Set;
import jp.llv.ce.exception.LocationOutOfRangeException;
import jp.llv.ce.math.NumUtil;
import jp.llv.ce.math.rcs.Point3d;
import jp.llv.ce.math.rcs.UnitVector;
import jp.llv.ce.math.rcs.Vector;
import jp.llv.ce.region.relative.RelativePoint;

/**
 * 絶対的一点を示す領域. イミュータブル
 *
 * @author Toyblocks
 */
public final class Point extends Region {

    public static final Point ORIGIN = new Point(0, 0, 0);
    
    public static final int MAX_HORIZONTAL_VALUE = 0b1000000000000000000000000;
    public static final int MIN_HORIZONTAL_VALUE = -0b1000000000000000000000000;
    public static final int MAX_VERTICAL_VALUE = 0b11111111;
    public static final int MIN_VERTICAL_VALUE = 0b0;

    private final int x, z;
    private final byte unsignedY;

    public Point(long x, long y, long z) {
        validate(x, y, z);
        this.x = (int) x;
        this.z = (int) z;
        this.unsignedY = (byte) y;
    }

    public Point(Point3d loc) {
        this(loc.getLongX(), loc.getLongY(), loc.getLongZ());
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.unsignedY & 0xff;
    }

    public int getZ() {
        return this.z;
    }

    public Point add(int x, int y, int z) {
        return new Point(this.getX() + x, this.getY() + y, this.getZ() + z);
    }

    public Point add(RelativePoint p) {
        return this.add(p.getX(), p.getY(), p.getZ());
    }

    public Point3d add(Vector v) {
        return this.toPoint3d().add(v);
    }

    public double distance(Point o) {
        return Math.sqrt(this.distanceSquared(o));
    }

    public double distanceSquared(Point o) {
        return Math.pow(this.getX() - o.getX(), 2.0) + Math.pow(this.getY() - o.getY(), 2.0) + Math.pow(this.getZ() - o.getZ(), 2.0);
    }

    public Vector getVectorTo(Point loc) {
        return new Vector(loc.getX() - this.getX(), loc.getY() - this.getY(), loc.getZ() - this.getZ());
    }

    public Point3d toPoint3d() {
        return new Point3d(this.getX(), this.getY(), this.getZ());
    }

    @Override
    public Set<Point> toPoints() {
        return Collections.singleton(this);
    }

    @Override
    public Region aggregate() {
        return this;
    }

    @Override
    public RelativePoint relativize(Point o) {
        return new RelativePoint(this.getX() - o.getX(), this.getY() - o.getY(), this.getZ() - o.getZ());
    }

    @Override
    public String toString() {
        return "{" + this.getX() + "," + this.getY() + "," + this.getZ() + "}";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.x;
        hash = 31 * hash + this.unsignedY;
        hash = 31 * hash + this.z;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        final Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.z != other.z) {
            return false;
        }
        return this.unsignedY == other.unsignedY;
    }

    public static void validate(long x, long y, long z) throws LocationOutOfRangeException {
        int xf = MIN_HORIZONTAL_VALUE <= x && x<= MAX_HORIZONTAL_VALUE ? 0 :
                MAX_HORIZONTAL_VALUE < x ? 1 : -1;
        int yf = MIN_VERTICAL_VALUE <= y && y<= MAX_VERTICAL_VALUE ? 0 :
                MAX_VERTICAL_VALUE < y ? 1 : -1;
        int zf = MIN_HORIZONTAL_VALUE <= z && z<= MAX_HORIZONTAL_VALUE ? 0 :
                MAX_HORIZONTAL_VALUE < z ? 1 : -1;
        if (xf != 0 || yf != 0 || zf != 0) {
            UnitVector v = new UnitVector(xf, yf, zf);
            throw new LocationOutOfRangeException(v);
        }
    }

    public static void validate(Point3d point) throws LocationOutOfRangeException {
        validate(NumUtil.floor(point.getX()), NumUtil.floor(point.getY()), NumUtil.floor(point.getZ()));
    }

}
