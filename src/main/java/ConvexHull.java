import java.util.Arrays;
import java.util.Stack;

public class ConvexHull {
    public static void convexHull(Point2D[] p){
        Stack<Point2D> hull = new Stack<Point2D>();

        Arrays.sort(p, Point2D.Y_ORDER);
        Arrays.sort(p, p[0].BY_POLAR_ORDER);

    }
}
