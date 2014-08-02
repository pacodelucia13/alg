import stdlib.In;
import stdlib.StdDraw;
import stdlib.StdOut;

import java.util.Arrays;

public class Fast1 {
    private static void findMaximalLineSegmentFor4Points(Point[] points) {
        Arrays.sort(points);
        Point[] aux = new Point[points.length];

        for (int i = 0; i < points.length; i++) {
            aux[i] = points[i];
        }

        for (int i = 0; i < aux.length; i++) {
            Arrays.sort(aux, points[i].SLOPE_ORDER);
            for (int j = i + 1; j < points.length - 2; j++) {
                if (aux[0].slopeTo(aux[j]) == aux[0].slopeTo(aux[j + 1])
                        && aux[0].slopeTo(aux[j]) == aux[0].slopeTo(aux[j + 2])) {
                    StdOut.println(points[i] + " -> " + points[j] + " -> " + points[j + 1] + " -> " + points[j + 2]);
                    points[i].drawTo(points[j+1]);
                }
            }
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