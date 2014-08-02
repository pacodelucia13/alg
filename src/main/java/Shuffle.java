import stdlib.StdRandom;

/**
 * Created with IntelliJ IDEA.
 * User: popovis
 * Date: 26/09/13
 * Time: 18:04
 * To change this template use File | Settings | File Templates.
 */
public class Shuffle {
    public static void shuffle(Comparable[] a) {
        Comparable[] b = new Comparable[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = StdRandom.uniform(a.length);
        }
        sort(b, a);
    }

    public static void sort(Comparable[] a, Comparable[] b) { // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1) { // h-sort the array.
            for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                    exch(b, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Integer[] toSort = {3, 2, 1};
        //StdRandom.shuffle(toSort);
        shuffle(toSort);

        for (int i = 0; i < toSort.length; i++) {
            System.out.print(toSort[i] + " ");
        }
    }


}
