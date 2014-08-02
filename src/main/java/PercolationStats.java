public class PercolationStats {
    private double[] thresholds;
    private int T;

    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N < 1 || T < 1) {
            throw new IllegalArgumentException ("Both N and T must be greater than 1");
        }

        this.T = T;
        thresholds = new double[T];

        for (int i = 0; i < T; i++) {
            Percolation percolation = new Percolation(N);
            int noOfOpenSites = 0;
            while (!percolation.percolates()) {
                int m = StdRandom.uniform(1, N + 1);
                int n = StdRandom.uniform(1, N + 1);
                if (!percolation.isOpen(m, n)) {
                    percolation.open(m, n);
                    noOfOpenSites++;
                }
            }
            thresholds[i] = noOfOpenSites / (double) (N * N);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(T);
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }

    // test client, described below
    public static void main(String[] args) {
        int N, T;
        N = Integer.parseInt(args[0]);
        T = Integer.parseInt(args[1]);

        PercolationStats percolationStats = new PercolationStats(N, T);
        System.out.println("mean = " + percolationStats.mean());
        System.out.println("stddev = " + percolationStats.stddev());
        System.out.println("95% confidence interval = "
                + percolationStats.confidenceLo() + ", " +
                percolationStats.confidenceHi());
    }
}
