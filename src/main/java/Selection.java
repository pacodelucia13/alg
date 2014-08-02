/**
 * O N^2/2 compares and N exchanges
 * <p/>
 * Scans from left to right
 * <p/>
 * Invariants:
 * 1. Entries to the left of | are fixed and in ascending order
 * 2. No entries to the right of | are smaller than any entry to the left of |
 * <p/>
 * Running time insensitive to input - quadratic time, even if input is sorted
 * Data movement is minimal - linear number of exchanges
 */
public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int noOfExchanges = 0;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
            noOfExchanges++;
            if(noOfExchanges ==4){
                return;
            }
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
        Integer[] a = {79, 64, 78, 82, 52, 96, 62, 88, 85, 55};
        sort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
