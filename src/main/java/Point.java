import stdlib.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {
    // compare points by slope to this point
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
        @Override
        public int compare(Point p1, Point p2) {
            if (slopeTo(p1) > slopeTo(p2)) {
                return 1;
            } else if (slopeTo(p1) < slopeTo(p2)) {
                return -1;
            } else {
                return 0;
            }
        }
    };

    // x coordinate
    private final int x;
    // y coordinate
    private final int y;

    // create the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        if (that.x - this.x == 0) {
            return that.y - this.y != 0
                    ? Double.POSITIVE_INFINITY
                    : Double.NEGATIVE_INFINITY;
        }
        if (that.y - this.y == 0) {
            return 0;
        }
        return ((double) that.y - this.y) / (that.x - this.x);
    }

    // string representation
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    // is this point lexicographically smaller than that point?
    public int compareTo(Point that) {
        if (this.y < that.y ||
                (this.y == that.y && this.x < that.x)) {
            return -1;
        }

        if (this.y > that.y ||
                (this.y == that.y && this.x > that.x)) {
            return 1;
        }

        return 0;
    }
}