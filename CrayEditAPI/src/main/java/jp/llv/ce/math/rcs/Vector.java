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

/**
 * 方向.
 *
 * @author Toyblocks
 */
public class Vector {

    public static final Vector ZERO = new Vector(0.0D, 0.0D, 0.0D);

    private final double x, y, z;

    public Vector(double x, double y, double z) {
        if (!(Double.isFinite(x) && Double.isFinite(y) && Double.isFinite(z))) {
            throw new IllegalArgumentException("Infinite mustn't be contained");
        }
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final double getZ() {
        return this.z;
    }

    public final Vector add(double x, double y, double z) {
        return new Vector(this.getX() + x, this.getY() + y, this.getZ() + z);
    }

    public final Vector add(Vector v) {
        return this.add(v.getX(), v.getY(), v.getZ());
    }

    public final Vector add(double a) {
        return new Vector(this.getX() + a, this.getY() + a, this.getZ() + a);
    }
    
    public final Vector subtract(double x, double y, double z) {
        return new Vector(this.getX() - x, this.getY() - y, this.getZ() - z);
    }

    public final Vector subtract(Vector v) {
        return this.subtract(v.getX(), v.getY(), v.getZ());
    }

    public final Vector subtract(double a) {
        return new Vector(this.getX() - a, this.getY() - a, this.getZ() - a);
    }

    public final Vector multiply(double m) {
        return new Vector(this.getX() * m, this.getY() * m, this.getZ() * m);
    }

    public final double dot(Vector v) {
        return (this.getX() * v.getX()) + (this.getY() * v.getY()) + (this.getZ() * v.getZ());
    }

    public final Vector cross(Vector v) {
        return new Vector((this.getY() * v.getZ()) - (this.getZ() * v.getY()),
                (this.getZ() * v.getX()) - (this.getX() * v.getZ()),
                (this.getX() * v.getY()) - (this.getY() * v.getX()));
    }

    public final Vector reverse() {
        return this.multiply(-1.0D);
    }

    public final boolean isAxis() {
        if (this.x == 0.0D) {
            return y == 0.0D || z == 0.0D;//z-axis || y-axis
        } else {
            return y == 0.0D && z == 0.0D;//x-axis
        }
    }

    public final boolean isOrthogonalTo(Vector other) {
        return this.dot(other) == 0;
    }

    public final double lengthSquared() {
        return Math.pow(x, 2.0D) + Math.pow(y, 2.0D) + Math.pow(z, 2.0D);
    }

    public final double length() {
        return Math.sqrt(this.lengthSquared());
    }

    public double angle(Vector other) {
        return Math.acos(this.dot(other) / Math.sqrt(this.lengthSquared() * other.lengthSquared()));
    }

    public final UnitVector normalize() {
        if (this instanceof UnitVector) return (UnitVector) this;
        return new UnitVector(this.getX(), this.getY(), this.getZ());
    }

    @Override
    public final String toString() {
        return "Vector{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vector other = (Vector) obj;
        return this.x == other.x && this.y == other.y && this.z == other.z;
    }

}
