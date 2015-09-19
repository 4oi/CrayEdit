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
import java.util.Set;
import jp.llv.ce.math.rcs.Line;
import jp.llv.ce.math.rcs.Point3d;
import jp.llv.ce.region.relative.RelativeRegion;
import jp.llv.ce.region.relative.RelativeSLine;
import jp.llv.ce.math.rcs.Vector;

/**
 * 直線領域
 *
 * @author Toyblocks
 */
public class SLine extends Region {

    private final Point3d p1, p2;

    public SLine(Point3d p1, Point3d p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public SLine(Point3d p, Vector v) {
        this(p, p.add(v));
    }

    public Point3d getPoint1() {
        return this.p1;
    }

    public Point3d getPoint2() {
        return this.p2;
    }

    public double getLength() {
        return p1.distance(p2);
    }

    public double getLengthSquared() {
        return p1.distanceSquared(p2);
    }

    public Vector getVector() {
        return this.p1.getVectorTo(this.p2);
    }

    public Point3d getPointAtX(int x) {
        double y = this.p1.getY() + (((this.p2.getY() - this.p1.getY()) * (x - this.p1.getX()) / (this.p2.getX() - this.p1.getX())));
        double z = this.p1.getZ() + (((this.p2.getZ() - this.p1.getZ()) * (x - this.p1.getX()) / (this.p2.getX() - this.p1.getX())));
        return new Point3d(x, y, z);
    }

    public Point3d getPointAtY(int y) {
        double x = this.p1.getX() + (((this.p2.getX() - this.p1.getX()) * (y - this.p1.getY()) / (this.p2.getY() - this.p1.getY())));
        double z = this.p1.getZ() + (((this.p2.getZ() - this.p1.getZ()) * (y - this.p1.getY()) / (this.p2.getY() - this.p1.getY())));
        return new Point3d(x, y, z);
    }

    public Point3d getPointAtZ(int z) {
        double x = this.p1.getX() + (((this.p2.getX() - this.p1.getX()) * (z - this.p1.getZ()) / (this.p2.getZ() - this.p1.getZ())));
        double y = this.p1.getY() + (((this.p2.getY() - this.p1.getY()) * (z - this.p1.getZ()) / (this.p2.getZ() - this.p1.getZ())));
        return new Point3d(x, y, z);
    }

    @Override
    public Set<Point> toPoints() {//線形補完?
        Set<Point> result = new HashSet<>();
        if (Math.abs(this.p1.getX() - this.p2.getX()) >= Math.abs(this.p1.getY() - this.p2.getY()) && Math.abs(this.p1.getX() - this.p2.getX()) >= Math.abs(this.p1.getZ() - this.p2.getZ())) {//x軸方向に最長
            for (int x = (int) Math.round(this.p1.getX()); this.p1.getX() < this.p2.getX() ? x < this.p2.getX() + 1 : x > this.p2.getX() - 1; x += this.p1.getX() < this.p2.getX() ? 1 : -1) {
                result.add(new Point(this.getPointAtX(x)));
            }
        } else if (Math.abs(this.p1.getY() - this.p2.getY()) >= Math.abs(this.p1.getZ() - this.p2.getZ())) {//Y軸方向に最長
            for (int y = (int) Math.round(this.p1.getY()); this.p1.getY() < this.p2.getY() ? y < this.p2.getY() + 1 : y > this.p2.getY() - 1; y += this.p1.getY() < this.p2.getY() ? 1 : -1) {
                result.add(new Point(this.getPointAtY(y)));
            }
        } else {//Z軸方向に最長
            for (int z = (int) Math.round(this.p1.getZ()); this.p1.getZ() < this.p2.getZ() ? z < this.p2.getZ() + 1 : z > this.p2.getZ() - 1; z += this.p1.getZ() < this.p2.getZ() ? 1 : -1) {
                result.add(new Point(this.getPointAtZ(z)));
            }
        }
        return Collections.unmodifiableSet(result);
    }
    
    public Line toLine() {
        return new Line(this.p1, this.p2);
    }

    @Override
    public RelativeRegion relativize(Point origin) {
        return new RelativeSLine(Point3d.ORIGIN.getVectorTo(this.p1), Point3d.ORIGIN.getVectorTo(this.p2));
    }

}
