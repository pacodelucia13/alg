package week1;

import stdlib.StdOut;

/**
 * Quick Union Initialize N, Union N, Find N
 * id[i] is root of i
 * i is a root of the component if i=id[i]
 */
public class QuickUnionUF extends UF {

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void union(int p, int q) {
        if (root(p) == root(q)) {
            StdOut.println("Already connected");
        }
        id[root(p)] = root(q);
    }
}
