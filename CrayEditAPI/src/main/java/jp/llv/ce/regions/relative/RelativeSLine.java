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
import java.util.HashSet;
import java.util.Set;
import jp.llv.ce.exception.LocationOutOfRangeException;
import jp.llv.ce.math.NumUtil;
import jp.llv.ce.math.rcs.Point3d;
import jp.llv.ce.math.rcs.UnitVector;
import jp.llv.ce.math.rcs.Vector;
import jp.llv.ce.region.Point;
import jp.llv.ce.region.SLine;

/**
 * 相対線分
 * @author Toyblocks
 */
public class RelativeSLine extends RelativeRegion {
    
    private final Vector p1, p2;

    public RelativeSLine(Vector p1, Vector p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Vector getPoint1() {
        return this.p1;
    }

    public Vector getPoint2() {
        return this.p2;
    }

    public double getLength() {
        return this.getVector().length();
    }

    public double getLengthSquared() {
        return this.getVector().lengthSquared();
    }

    public Vector getVector() {
        return this.p1.subtract(p2);
    }

    public Vector getPointAtX(int x) {
        double y = this.p1.getY() + (((this.p2.getY() - this.p1.getY()) * (x - this.p1.getX()) / (this.p2.getX() - this.p1.getX())));
        double z = this.p1.getZ() + (((this.p2.getZ() - this.p1.getZ()) * (x - this.p1.getX()) / (this.p2.getX() - this.p1.getX())));
        return new Vector(x, y, z);
    }

    public Vector getPointAtY(int y) {
        double x = this.p1.getX() + (((this.p2.getX() - this.p1.getX()) * (y - this.p1.getY()) / (this.p2.getY() - this.p1.getY())));
        double z = this.p1.getZ() + (((this.p2.getZ() - this.p1.getZ()) * (y - this.p1.getY()) / (this.p2.getY() - this.p1.getY())));
        return new Vector(x, y, z);
    }

    public Vector getPointAtZ(int z) {
        double x = this.p1.getX() + (((this.p2.getX() - this.p1.getX()) * (z - this.p1.getZ()) / (this.p2.getZ() - this.p1.getZ())));
        double y = this.p1.getY() + (((this.p2.getY() - this.p1.getY()) * (z - this.p1.getZ()) / (this.p2.getZ() - this.p1.getZ())));
        return new Vector(x, y, z);
    }

    @Override
    public Set<RelativePoint> toPoints() {//線形補完?
        Set<RelativePoint> result = new HashSet<>();
        if (Math.abs(this.p1.getX() - this.p2.getX()) >= Math.abs(this.p1.getY() - this.p2.getY()) && Math.abs(this.p1.getX() - this.p2.getX()) >= Math.abs(this.p1.getZ() - this.p2.getZ())) {//x軸方向に最長
            for (int x = NumUtil.floor(this.p1.getX()); this.p1.getX() < this.p2.getX() ? x < this.p2.getX() + 1 : x > this.p2.getX() - 1; x += this.p1.getX() < this.p2.getX() ? 1 : -1) {
                result.add(new RelativePoint(this.getPointAtX(x)));
            }
        } else if (Math.abs(this.p1.getY() - this.p2.getY()) >= Math.abs(this.p1.getZ() - this.p2.getZ())) {//Y軸方向に最長
            for (int y = NumUtil.floor(this.p1.getY()); this.p1.getY() < this.p2.getY() ? y < this.p2.getY() + 1 : y > this.p2.getY() - 1; y += this.p1.getY() < this.p2.getY() ? 1 : -1) {
                result.add(new RelativePoint(this.getPointAtY(y)));
            }
        } else {//Z軸方向に最長
            for (int z = NumUtil.floor(this.p1.getZ()); this.p1.getZ() < this.p2.getZ() ? z < this.p2.getZ() + 1 : z > this.p2.getZ() - 1; z += this.p1.getZ() < this.p2.getZ() ? 1 : -1) {
                result.add(new RelativePoint(this.getPointAtZ(z)));
            }
        }
        return Collections.unmodifiableSet(result);
    }

    @Override
    public SLine absolutize(Point origin) {
        return new SLine(origin.add(this.p1), origin.add(this.p2));
    }
    
    
    
}
