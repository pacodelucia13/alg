import stdlib.In;
import stdlib.StdDraw;
import stdlib.StdOut;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fast {
    private static void findMaximalLineSegmentFor4Points(Point[] pointsKey) {
        Arrays.sort(pointsKey);
        Point[] pointsSlopes = new Point[pointsKey.length];

        for (int i = 0; i < pointsKey.length; i++) {
            copyArray(pointsKey, pointsSlopes);
            Arrays.sort(pointsSlopes, pointsKey[i].SLOPE_ORDER);
            for (int j = 1; j < pointsSlopes.length - 2; j++) {
                if (pointsSlopes[j].slopeTo(pointsSlopes[0]) == pointsSlopes[j + 1].slopeTo(pointsSlopes[0])
                        && pointsSlopes[j].slopeTo(pointsSlopes[0]) == pointsSlopes[j + 2].slopeTo(pointsSlopes[0])) {
                    int k = j + 3;
                    while (k < pointsSlopes.length &&
                            pointsSlopes[j].slopeTo(pointsSlopes[0]) == pointsSlopes[k].slopeTo(pointsSlopes[0])) {
                        k++;
                    }
                    output(pointsSlopes, j, k - 1);
                    j = k - 1;
                }
            }
        }
    }

    private static void output(Point[] pointsSlopes, int j, int k) {
        if (pointsSlopes[0].compareTo(pointsSlopes[j]) < 0) {
            StdOut.print(pointsSlopes[0]);
            while (j <= k) {
                StdOut.print(" -> " + pointsSlopes[j]);
                j++;
            }
            StdOut.print("\n");
            pointsSlopes[0].drawTo(pointsSlopes[k]);
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

        Integer x= 20;

        Map map = new HashMap();
        map.put(x, 20);
        x = 30;
        findMaximalLineSegmentFor4Points(points);
    }
}
