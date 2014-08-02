package week1;

/**
 * Created with IntelliJ IDEA.
 * User: popovis
 * Date: 01/09/13
 * Time: 19:42
 * To change this template use File | Settings | File Templates.
 */

/**
 *  array accesses is lg* N (number of times you take lg N to get 1 - iterate log function)
 */
public class WeightedQuickUnionWithPathCompression extends UF {
    private int[] sz;

    public WeightedQuickUnionWithPathCompression(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
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

    public void printSizesArray() {
        System.out.print("Array sizes: ");
        for (int i = 0; i < sz.length; i++) {
            System.out.print(sz[i] + " ");
        }
    }

    public static void main(String[] args) {
        WeightedQuickUnionUF wquf = new WeightedQuickUnionUF(10);
        wquf.union(4, 3);
        wquf.union(3, 8);
        wquf.union(6, 5);
        wquf.union(9, 4);
        wquf.union(2, 1);
        wquf.union(5, 0);
        wquf.union(7, 2);
        wquf.union(6, 1);
        wquf.union(7, 3);
        wquf.printArray();
        wquf.printSizesArray();
    }
}
