package ex1_1;

/**
 * Created with IntelliJ IDEA.
 * User: popovis
 * Date: 11/08/13
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */
public class Ex17 {

    public static String toBinary(int N) {
        String s = "";
        for (int n = N; n > 0; n /= 2) {
            System.out.println(n);
            s = (n % 2) + s;
            System.out.println("s " + s);
        }
        return s;
    }

    public static String exR1(int n)
    {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }

    public static void main(String[] args) {
//        int[] a = new int[10];
//        for (int i = 0; i < 10; i++)
//            a[i] = 9 - i;
//        for (int i = 0; i < 10; i++)
//            a[i] = a[a[i]];
//        for (int i = 0; i < 10; i++)
//            System.out.println(i);

        System.out.println(exR1(6));
    }
}
