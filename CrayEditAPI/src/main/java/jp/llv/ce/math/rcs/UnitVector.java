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
public final class UnitVector extends Vector {

    public static final UnitVector E = new UnitVector(1D, 0D, 0D);
    public static final UnitVector W = new UnitVector(-1D, 0D, 0D);
    public static final UnitVector U = new UnitVector(0D, 1D, 0D);
    public static final UnitVector D = new UnitVector(0D, -1D, 0D);
    public static final UnitVector S = new UnitVector(0D, 0D, 1D);
    public static final UnitVector N = new UnitVector(0D, 0D, -1D);
    
    private UnitVector(double x, double y, double z, double length) {
        super(x / length, y / length, z / length);
    }

    public UnitVector(double x, double y, double z) {
        
        this(x, y, z, length(x, y, z));
    }
    
    private static double length(double x, double y, double z) {
        if (!(Double.isFinite(x) && Double.isFinite(y) && Double.isFinite(z))) {
            throw new IllegalArgumentException("Infinite mustn't be contained");
        }
        if (x == 0.0 && y == 0.0 && z == 0.0) {
            throw new IllegalArgumentException("Invalid vector");
        }
        return Math.sqrt(Math.pow(x, 2.0D) + Math.pow(y, 2.0D) + Math.pow(z, 2.0D));
    }

}
