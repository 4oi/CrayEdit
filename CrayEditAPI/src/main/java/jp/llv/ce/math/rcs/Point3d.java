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
package jp.llv.ce.math.rcs;

import jp.llv.ce.math.NumUtil;

/**
 *
 * @author Toyblocks
 */
public final class Point3d {
    
    public static final Point3d ORIGIN = new Point3d(0.0D, 0.0D, 0.0D);

    private final double x, y, z;

    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }
    
    public int getLongX() {
        return NumUtil.floor(this.getX());
    }

    public double getY() {
        return this.y;
    }
    
    public int getLongY() {
        return NumUtil.floor(this.getY());
    }

    public double getZ() {
        return this.z;
    }
    
    public int getLongZ() {
        return NumUtil.floor(this.getZ());
    }

    public Point3d add(double x, double y, double z) {
        return new Point3d(this.getX() + x, this.getY() + y, this.getZ() + z);
    }
    
    public Point3d add(Vector p) {
        return this.add(p.getX(), p.getY(), p.getZ());
    }
    
    public Point3d scale(Point3d cp, double scale) {
        return cp.add(cp.getVectorTo(this).multiply(scale));
    }
    
    public Point3d getPointSym(Point3d cp) {
        return this.add(this.getVectorTo(cp).multiply(2.0D));
    }
    
    public Point3d rotate(Line l, double rad) {
        Point3d xp = l.getNearest(this);
        double dist = this.distance(xp);
         UnitVector vy = xp.getVectorTo(this).normalize();
         return xp.add(l.getVector().cross(vy).normalize().multiply(dist*Math.sin(rad)).add(vy.multiply(dist*Math.cos(rad))));
    }
    
    public Point3d getPlaneSym(Plane p) {
        return this.getPointSym(p.getNearest(this));
    }

    public double distance(Point3d o) {
        return Math.sqrt(this.distanceSquared(o));
    }

    public double distanceSquared(Point3d o) {
        return Math.pow(this.getX() - o.getX(), 2.0D) + Math.pow(this.getY() - o.getY(), 2.0D) + Math.pow(this.getZ() - o.getZ(), 2.0D);
    }
    
    public Vector getVectorTo(Point3d loc) {
        return new Vector(loc.getX()-this.getX(), loc.getY()-this.getY(), loc.getZ()-this.getZ());
    }
    
    @Override
    public String toString() {
        return "{" + this.getX() + "," + this.getY() + "," + this.getZ() + "}";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point3d other = (Point3d) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return Double.doubleToLongBits(this.z) == Double.doubleToLongBits(other.z);
    }
    
}
