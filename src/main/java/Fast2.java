
import stdlib.In;
import stdlib.StdDraw;
import stdlib.StdOut;

import java.util.Arrays;

public class Fast2 {
    private static void findMaximalLineSegmentFor4Points(Point[] pointsKey) {
        Arrays.sort(pointsKey);
        Point[] pointsSlopes = new Point[pointsKey.length];

        for (int i = 0; i < pointsKey.length; i++) {
            copyArray(pointsKey, pointsSlopes);
            Arrays.sort(pointsSlopes, pointsKey[i].SLOPE_ORDER);
            for (int j = 1; j < pointsSlopes.length - 1; j++) {
                if (pointsSlopes[0].slopeTo(pointsSlopes[j]) !=
                        pointsSlopes[0].slopeTo(pointsSlopes[j + 1])) {
                    break;
                }
                else {
                    if (j >= 3) {
                        output(pointsSlopes, j +1 );
                        break;
                    }
                }
            }
        }
    }

    private static void output(Point[] pointsSlopes, int j) {
        if (pointsSlopes[0].compareTo(pointsSlopes[1]) == -1) {
            StdOut.print(pointsSlopes[0]);
            for (int i = 1; i <= j; i++) {
                StdOut.print(" -> " + pointsSlopes[i]);
            }
            StdOut.print("\n");
            pointsSlopes[0].drawTo(pointsSlopes[j]);
        }

    }

    private static void copyArray(Point[] from, Point[] to) {
        for (int i = 0; i < from.length; i++) {
            to[i] = from[i];
        }
    }
    //Think of p as the origin.
    //For each other point q, determine the slope it makes with p.
    //Sort the points according to the slopes they makes with p.
    //Check if any 3 (or more) adjacent points in the sorted order have equal slopes with respect to p.
    // If so, these points, together with p, are collinear.
    //Applying this method for each of the N points in turn yields an efficient algorithm to the problem.
    // The algorithm solves the problem because points that have equal slopes
    // with respect to p are collinear, and sorting brings such points together.
    // The algorithm is fast because the bottleneck operation is sorting.

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();

        Point[] points = new Point[N];

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        for (int i = 0; i < N; i++) {
            points[i] = new Point(in.readInt(), in.readInt());
            points[i].draw();
        }

        findMaximalLineSegmentFor4Points(points);
    }
}
