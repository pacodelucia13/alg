package ex1_1;

import stdlib.StdOut;

/**
 * Created with IntelliJ IDEA.
 * User: popovis
 * Date: 11/08/13
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
public class Ex15 {
    public static boolean checkBetween0And1(double z) {
        return z > 0 && z < 1;
    }

    public static void main(String[] args) {
        double x = 0;
        double y = 0.2;
        if (checkBetween0And1(x) && checkBetween0And1(y))
            StdOut.print("true");
        else System.out.println("false");

    }
}
