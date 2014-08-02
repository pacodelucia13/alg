
public class MergeSort {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length]; // Allocate space just once.
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) { // Sort a[lo..hi].
        if (hi <= lo) return;
        //if (hi <= lo + CUTOFF -1) Insertion.sort(a, lo, hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid); // Sort left half.
        sort(a, aux, mid + 1, hi); // Sort right half.
        //if(!(less(a[mid+1],a[mid]))) return;
        merge(a, aux, lo, mid, hi); // Merge results (code on page 271).
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

        for (int x = 0; x < a.length; x++) {
            System.out.print(a[x] + " ");
        }
        System.out.println("----");

    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        String[] aa = new String[]{
                "tree",
                "ceil",
                "size",
                "exch",
                "heap",
                "left",
                "hash",
                "rank",
                "swap",
                "lifo",
                "prim",
                "flow"


        };
        sort(aa);

        for (int i = 0; i < aa.length; i++) {
            System.out.print(aa[i] + " ");
        }
        System.out.println("----");

    }
}

