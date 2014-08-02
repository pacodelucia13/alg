package week1;

public class Percolation1 {
    private int N;
    private int[] ids;

    //create N-by-N grid, with all sites blocked
    public Percolation1(int N) {
        this.N = N;
        ids = new int[N * N];
        for (int i = 0; i < N * N + 1; i++) {
            ids[i] = i;
        }
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        //if one of my neighbours has the root 0 then
        //this one will also have the root 0
        //otherwise I just
        ids[N * i + j] = 0;

    }


    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        i = decrement(i);
        return ids[N * i + j] != N * i + j;
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        i = decrement(i);
        return ids[N * i + j] == N * i + j;
    }

    // does the system percolate?
    public boolean percolates() {
        return root(ids[N * N]) == 0;
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
