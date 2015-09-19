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
 *
 * @author Toyblocks
 */
public final class Plane {

    private final Point3d path;
    private final UnitVector normal;

    public Plane(Point3d path, UnitVector normal) {
        if (path == null || normal == null) {
            throw new NullPointerException();
        }
        this.path = path;
        this.normal = normal;
    }

    public Plane(Point3d path, Point3d path2, Point3d path3) {
        this(path, path.getVectorTo(path2).cross(path.getVectorTo(path3)).normalize());
    }

    public Point3d getPath() {
        return this.path;
    }

    public UnitVector getNormalVector() {
        return this.normal;
    }

    public boolean isOn(Point3d loc) {
        return this.getPath().getVectorTo(loc).isOrthogonalTo(this.getNormalVector());
    }

    public Point3d getNearest(Point3d loc) {
        if (loc.equals(this.path)) {
            return loc;
        }
        double length = this.path.distance(loc);
        double skh = Math.cos(this.getNormalVector().angle(this.getPath().getVectorTo(loc)));
        return loc.add(this.getNormalVector().reverse().multiply(length * skh));
    }

}
