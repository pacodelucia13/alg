/**
 * O N^2/4 compares and N^2/4 exchanges
 * <p/>
 * Scans from left to right
 * <p/>
 * Invariants:
 * 1. Entries to the left of | are in ascending order
 * 2. Entries to the right | have not yet been seen
 * <p/>
 */
public class Insertion {
    public static int noOfCompares =0;
    public static void sort(Comparable[] a) {
        int N = a.length;
        int noOfExchanges = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                noOfCompares++;
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                    noOfExchanges++;
                    if(noOfExchanges == 6){
                        return;
                    }
                } else break;
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
        Integer[] toSort = {13, 35, 37, 69, 72, 92, 11, 51, 60, 46};
        Insertion.sort(toSort);
        //System.out.println(noOfCompares);

        for (Integer token : toSort) {
            System.out.print(token + " ");
        }
    }

}
