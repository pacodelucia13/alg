package ex1_1;

import stdlib.StdOut;

/**
 * Created with IntelliJ IDEA.
 * User: popovis
 * Date: 11/08/13
 * Time: 15:19
 * To change this template use File | Settings | File Templates.
 */

public class Ex16 {

    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++)
        {
            StdOut.print(f);
            f = f + g;
            g = f - g;
        }
    }

    //  0 (1,0), 1 (1,1), 1 (2, 0), 2 (2, 2),  2 (4,0) , 4 (4,4), 4 (8, 0),



}
