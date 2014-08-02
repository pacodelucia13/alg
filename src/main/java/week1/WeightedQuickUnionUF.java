package week1;

public class WeightedQuickUnionUF extends UF {

    private int[] sz;

    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }


    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }

    public void printSizesArray(){
        System.out.print("Array sizes: ");
        for (int i = 0; i < sz.length; i++) {
            System.out.print(sz[i] + " ");
        }
    }

    public static void main(String[] args) {
        WeightedQuickUnionUF wquf = new WeightedQuickUnionUF(10);
        wquf.union(2, 9);
        wquf.union(2, 5);

        wquf.union(2, 4);
        wquf.union(7, 0);
        wquf.union(0, 2);

        wquf.union(1, 6);
        wquf.union(8, 3);
        wquf.union(6, 3);
        wquf.union(2, 1);
        wquf.printArray();

        WeightedQuickUnionUF wquf1 = new WeightedQuickUnionUF(10);
        wquf1.union(9, 3);
        wquf1.union(7, 4);
        wquf1.union(7, 8);
        wquf1.union(1, 6);
        wquf1.union(1, 9);
        wquf1.union(4, 2);
        wquf1.union(5, 7);
        wquf1.union(7, 6);
        wquf1.union(0, 2);
        wquf1.printArray();

    }
}