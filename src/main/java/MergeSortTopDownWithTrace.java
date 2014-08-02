

public class MergeSortTopDownWithTrace {
    public static int noOfMerges = 0;
    public static int noOfCompares = 0;

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length]; // Allocate space just once.
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) { // Sort a[lo..hi].
        if (hi <= lo) {
            System.out.println(" return ");
            return;
        }
        //if (hi <= lo + CUTOFF -1) Insertion.sort(a, lo, hi) return;
        int mid = lo + (hi - lo) / 2;
        //System.out.println("mid " + mid);
        System.out.println("sort(lo = " + lo + ", mid = " + mid + ")");
        sort(a, aux, lo, mid); // Sort left half.
        System.out.println("sort(mid + 1 = " + (mid + 1) + ", hi = " + hi + ")");
        sort(a, aux, mid + 1, hi); // Sort right half.
        //if(!(less(a[mid+1],a[mid]))) return;
        System.out.println("merge(lo = " + lo + ", mid = " + mid + ", hi = " + hi + ")");
        merge(a, aux, lo, mid, hi); // merge results (code on page 271).
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) { // merge a[lo..mid] with a[mid+1..hi].


        if (noOfMerges == 7) {
            return;
        }

        noOfMerges++;

        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) { // merge back to a[lo..hi].
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        noOfCompares++;
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Integer[] aa = new Integer[]{25, 65, 14, 60, 74, 66, 95, 61, 56, 83, 58, 42 };
        sort(aa);

        for (int i = 0; i < aa.length; i++) {
            System.out.print(aa[i] + " ");
        }

        System.out.println("\n" + noOfMerges);
        System.out.println("\n" + noOfCompares);
    }

}
