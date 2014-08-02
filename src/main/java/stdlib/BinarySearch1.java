package stdlib;

import java.util.Arrays;

public class BinarySearch1 {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whiteList = {10, 11, 12, 16, 18, 23, 29, 33};
        Arrays.sort(whiteList);

        int key = 29;
        System.out.println(rank(key, whiteList));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.abs(-2147483648));

        int b = 10;
        int c= 6;
        System.out.println( b&c);
    }
}
