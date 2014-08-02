public class ShellSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) { //h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }

            System.out.println("h= " + h);
            for (Comparable token : a) {
                System.out.print(token + " ");
            }
            h = h / 3;
        }
    }

    public static void sort2(Comparable[] a) { // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1) { // h-sort the array.
            for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
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
        Integer[] toSort = {21, 51, 82, 83, 19, 39, 29, 46, 54, 25};
        //StdRandom.shuffle(toSort);
        sort(toSort);

//        for (int i = 0; i < toSort.length; i++) {
//            System.out.print(toSort[i] + " ");
//        }
    }
}
