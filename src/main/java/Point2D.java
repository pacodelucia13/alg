import java.util.Comparator;

public class Point2D {
    public static final Comparator<? super Point2D> BY_POLAR_ORDER = new Comparator<Point2D>() {
        @Override
        public int compare(Point2D o1, Point2D o2) {
            return 0;
        }
    };
    public static final Comparator<? extends Point2D> BY_POLAR_ORDER1 = new Comparator<Point2D>() {
        @Override
        public int compare(Point2D o1, Point2D o2) {
            return 0;
        }
    };
    public static Comparator Y_ORDER ;
    double x;
    double y;

    public static int ccw(Point a, Point b, Point c) {
        return 0;
    }


}
