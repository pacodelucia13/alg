import stdlib.In;
import stdlib.StdDraw;
import stdlib.StdOut;

import java.util.Arrays;

public class Brute {

    private static void findMaximalLineSegmentFor4Points(Point[] points) {
        Arrays.sort(points);

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]) &&
                                points[i].slopeTo(points[j]) == points[i].slopeTo(points[l])) {
                            points[i].drawTo(points[l]);
                            StdOut.println(points[i] + " -> " + points[j] + " -> " + points[k] + " -> " + points[l]);
                        }
                    }
                }
            }
        }

    }

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
