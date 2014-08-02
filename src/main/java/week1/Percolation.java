package week1;

public class Percolation {
    private int N;
    private int[] ids;

    //create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        this.N = N;
        ids = new int[N * N];
        for (int i = 0; i < N * N; i++) {
            ids[i] = i;
        }
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {

    }


    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        i = decrement(i);
        j = decrement(j);
        return ids[N * i + j] != N * i + j;
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        i = decrement(i);
        j = decrement(j);
        return ids[N * i + j] == N * i + j;
    }

    // does the system percolate?
    public boolean percolates() {
        if (N == 1 && ids[0] != -1) {
            return false;
        }

        boolean percolates = false;
        for (int i = 0; i < N; i++) {
            for (int j = N * (N - 1); j < N * N; j++) {
                if (connected(ids[i], ids[j])) {
                    percolates = true;
                }
            }
        }
        return percolates;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (i != ids[i]) {
            i = ids[i];
        }
        return i;
    }

    private int decrement(int k) {
        if (k < 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return k - 1;
    }

}
