public class Percolation {
    private int N;
    private boolean[][] openSites;
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private WeightedQuickUnionUF onlyTop;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        if(N <= 0){
            throw new IllegalArgumentException("N must be greater than 0");
        }
        this.N = N;
        openSites = new boolean[N][N];
        weightedQuickUnionUF = new WeightedQuickUnionUF(N * N + 1);
        onlyTop = new WeightedQuickUnionUF(N * N + 1);
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        checkParamsWithinBounds(i, j);
        openSites[i - 1][j - 1] = true;

        //if we are on the top row we connect to the virtual top
        if (i == 1) {
            weightedQuickUnionUF.union(i - 1, j);
            onlyTop.union(i - 1, j);
        }

        //if we are on the bottom row we connect to the virtual bottom
        if (i == N) {
            weightedQuickUnionUF.union(N * (i - 1) + j, N * N );
        }
        //if top neighbour is open, union
        if (i > 1 && isOpen(i - 1, j)) {
            weightedQuickUnionUF.union(N * (i - 2) + j, N * (i - 1) + j);
            onlyTop.union(N * (i - 2) + j, N * (i - 1) + j);
        }
        //if left neighbour is open, union
        if (j > 1 && isOpen(i, j - 1)) {
            weightedQuickUnionUF.union(N * (i - 1) + j - 1, N * (i - 1) + j);
            onlyTop.union(N * (i - 1) + j - 1, N * (i - 1) + j);
        }
        //if bottom neighbour is open, union
        if (i < N && isOpen(i + 1, j)) {
            weightedQuickUnionUF.union(N * i + j, N * (i - 1) + j);
            onlyTop.union(N * i + j, N * (i - 1) + j);
        }
        //if right neighbour is open, union
        if (j < N && isOpen(i, j + 1)) {
            weightedQuickUnionUF.union(N * (i - 1) + j + 1, N * (i - 1) + j);
            onlyTop.union(N * (i - 1) + j + 1, N * (i - 1) + j);
        }
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        checkParamsWithinBounds(i, j);
        return openSites[i - 1][j - 1];
    }

    private void checkParamsWithinBounds(int i, int j) {
        if (i < 1 || j < 1 || i > N || j > N) {
            throw new IndexOutOfBoundsException("" +
                    "i and j should be greater then 1 but not more than N ");
        }
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        checkParamsWithinBounds(i, j);
        return weightedQuickUnionUF.connected(0, N * (i - 1) + j)
                && onlyTop.connected(0, N * (i - 1) + j);
    }

    // does the system percolate?
    public boolean percolates() {
        return weightedQuickUnionUF.connected(0, N * N);
    }
}
