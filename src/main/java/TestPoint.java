import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestPoint {
    @Test(expected = NullPointerException.class)
    public void testCompareToLexicoNullArgument() {
        new Point(1, 2).compareTo(null);
    }

    @Test
    public void testCompareToLexicoYLess() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 3);
        assertThat(p1.compareTo(p2), is(-1));
    }

    @Test
    public void testCompareToLexicoYGr8() {
        Point p1 = new Point(1, 4);
        Point p2 = new Point(1, 3);
        assertThat(p1.compareTo(p2), is(1));
    }

    @Test
    public void testCompareToLexicoYSameXLess() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(3, 3);
        assertThat(p1.compareTo(p2), is(-1));
    }

    @Test
    public void testCompareToLexicoYSameXGr8() {
        Point p1 = new Point(4, 3);
        Point p2 = new Point(3, 3);
        assertThat(p1.compareTo(p2), is(1));
    }

    @Test
    public void testCompareToLexicoYSameXSame() {
        Point p1 = new Point(3, 3);
        Point p2 = new Point(3, 3);
        assertThat(p1.compareTo(p2), is(0));
    }

    //The slopeTo() method should return the slope between the invoking point (x0, y0) and the argument point (x1, y1),
    // which is given by the formula (y1 − y0) / (x1 − x0).
    // Treat the slope of a horizontal line segment as positive zero [added 7/29];
    // treat the slope of a vertical line segment as positive infinity;
    // treat the slope of a degenerate line segment (between a point and itself) as negative infinity.
    @Test(expected = NullPointerException.class)
    public void testSlopeToNPE() {
        new Point(5, 3).slopeTo(null);
    }

    @Test
    public void testSlopeToHorizontal() {
        Point p1 = new Point(5, 3);
        Point p2 = new Point(4, 3);
        assertThat(p1.slopeTo(p2), is(0d));
    }

    @Test
    public void testSlopeToVertical() {
        Point p1 = new Point(4, 6);
        Point p2 = new Point(4, 3);
        assertThat(p1.slopeTo(p2), is(Double.POSITIVE_INFINITY));
    }

    @Test
    public void testSlopeToDegenerate() {
        Point p1 = new Point(4, 6);
        Point p2 = new Point(4, 6);
        assertThat(p1.slopeTo(p2), is(Double.NEGATIVE_INFINITY));
    }

    @Test
    public void testSlopeToShouldBeNegative() {
        Point p1 = new Point(4, 7);
        Point p2 = new Point(5, 6);
        assertThat(p1.slopeTo(p2) < 0, is(true));
    }

    //he SLOPE_ORDER comparator should compare points by the slopes they make with the invoking point (x0, y0).
    // Formally, the point (x1, y1) is less than the point (x2, y2) if and only if the slope (y1 − y0) / (x1 − x0)
    // is less than the slope (y2 − y0) / (x2 − x0).
    // Treat horizontal, vertical, and degenerate line segments as in the slopeTo() method.
    @Test
    public void testSlopeOrderComparatorEqualSlope() {
        Point p0 = new Point(1, 2);
        Point p1 = new Point(2, 3);
        Point p2 = new Point(3, 4);
        assertThat(p0.SLOPE_ORDER.compare(p1, p2), is(0));
    }

    @Test
    public void testSlopeOrderComparatorLessSlope() {
        Point p0 = new Point(1, 1);
        Point p1 = new Point(2, 7);
        Point p2 = new Point(3, 14);
        assertThat(p0.SLOPE_ORDER.compare(p1, p2), is(-1));
    }

    @Test
    public void testSlopeOrderComparatorGr8Slope() {
        Point p0 = new Point(1, 1);
        Point p1 = new Point(2, 8);
        Point p2 = new Point(3, 12);
        assertThat(p0.SLOPE_ORDER.compare(p1, p2), is(1));
    }

}
