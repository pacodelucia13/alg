package week1;

/**
 * Quick Union Initialize N , Union N, Find 1
 *
 * make N unions -> N^2
 * Quadratic time algorithms are much too slow
 */
public class QuickFindUF extends UF {

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void union(int p, int q) {
        if (!connected(p, q)) {
            int temp = id[p];
            for (int i = 0; i < id.length; i++) {
                if (id[i] == temp) {
                    id[i] = id[q];
                }
            }
        }
    }

    public static void main(String[] args) {
        QuickFindUF quickFindUF = new QuickFindUF(10);
        quickFindUF.union(9, 1);
        quickFindUF.union(8, 0);
        quickFindUF.union(6, 1);
        quickFindUF.union(4, 0);
        quickFindUF.union(6, 0);
        quickFindUF.union(1, 7);
        quickFindUF.printArray();

    }
}
