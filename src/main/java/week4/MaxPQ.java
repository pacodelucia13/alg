package week4;

import java.util.Arrays;
import java.util.List;

/**
 * insert delMax max
 * logN   logN   1
 *
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public void insert(Key x) {
        pq[++N] = x;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = null;
        return max;
    }

    public boolean isEmpty() {
        return false;
    }

    Key max() {
        return null;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    int size() {
        return 0;
    }

    public Key[] getPq() {
        return pq;
    }

    public static void main(String[] args) {
        MaxPQ<Integer>  pq = new MaxPQ<Integer>(14);
        List<Integer> nos = Arrays.asList(93, 83, 54, 65, 62, 38, 33, 10, 11, 44);
        for (int i = 0; i < 10 ; i++) {
            pq.insert(nos.get(i));
        }
//        pq.insert();
//        Comparable[] pqArray = pq.getPq();

        for (int i = 0; i < ((Comparable[])pq.getPq()).length ; i++) {
            System.out.print(" ");
        }


    }
}
