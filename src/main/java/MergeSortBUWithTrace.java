

public class MergeSortBUWithTrace {
    private static Comparable[] aux;
    public static int noOfMerges = 0;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];

        for (int sz = 1; sz < N; sz = sz + sz) {
            System.out.println("sz = " + sz);
            for (int lo = 0; lo < N - sz; lo = lo + sz + sz) {
                if (noOfMerges == 7) {
                    return;
                }
                System.out.println("merge(lo = " + lo + ", lo + sz - 1 = " + (lo + sz - 1)
                        + ", Math.min(lo + sz + sz - 1, N - 1)) = " + Math.min(lo + sz + sz - 1, N - 1));
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
                noOfMerges++;
            }
        }
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) { // Merge a[lo..mid] with a[mid+1..hi].

        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) { // Merge back to a[lo..hi].
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Integer[] aa = new Integer[]{67, 57, 47, 62, 68, 66, 61, 84, 20, 44};
        sort(aa);

        for (int i = 0; i < aa.length; i++) {
            System.out.print(aa[i] + " ");
        }

        System.out.println("\n" + noOfMerges);

    }
}
