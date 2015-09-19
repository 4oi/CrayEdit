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

import java.util.Objects;

/**
 *
 * @author Toyblocks
 */
public final class Line {
    
    private final Point3d path;
    private final UnitVector vect;
    
    public Line(Point3d path, UnitVector vect) {
        if (path == null || vect ==  null) throw new NullPointerException();
        this.path = path;
        this.vect = vect;
    }
    
    public Line(Point3d path1, Point3d path2) {
        this(path1, path1.getVectorTo(path2).normalize());
    }

    public Point3d getPath() {
        return this.path;
    }
    
    public UnitVector getVector() {
        return this.vect;
    }
    
    public boolean isOn(Point3d loc) {
        if (this.getPath().equals(loc)) {
            return true;
        }
        Vector v = this.getPath().getVectorTo(loc);
        return this.getVector().equals(v) || this.getVector().equals(v.reverse());
    }
    
    public Point3d getNearest(Point3d loc) {
        double ap = this.getPath().distance(loc);
        double cos = Math.cos(this.getVector().angle(this.getPath().getVectorTo(loc)));
        return this.path.add(this.getVector().normalize().multiply(ap*cos));
    }
    
    @Override
    public String toString() {
        return "Line{" + "path=" + path + ", vect=" + vect + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.path);
        hash = 59 * hash + Objects.hashCode(this.vect);
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
        final Line other = (Line) obj;
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        return Objects.equals(this.vect, other.vect);
    }
    
    public boolean isEquivalent(Line l) {
        if (l == null) {
            return false;
        }
        if (!(this.getVector().equals(l.getVector()) || this.getVector().equals(l.getVector().reverse()))) {
            return false;
        }
        return this.isOn(l.getPath());
    }
    
}
