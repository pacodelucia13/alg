package week1;

public abstract class UF {
    protected int[] id;
    /**
     * @param p object p
     * @param q object q
     */
    public abstract void union(int p, int q);

    /**
     *
     * @param p object p
     * @param q object q
     * @return true if they are in the same component false otherwise
     */
    public abstract boolean connected(int p, int q);

    /**
     * finds the component where p is in
     * @param p the object
     * @return the identifier for the component where p is in
     */
    public abstract int find(int p);

    /**
     *
     * @return the total number of components
     */
    public abstract int count();

    public void printArray(){
        System.out.print("Array: ");
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
    }

}
