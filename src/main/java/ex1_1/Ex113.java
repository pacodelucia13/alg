package ex1_1;

/**
 * Created with IntelliJ IDEA.
 * User: popovis
 * Date: 11/08/13
 * Time: 20:23
 * To change this template use File | Settings | File Templates.
 */
public class Ex113 {

    public static void printMatrix(int[][] a) {
        int rows = a.length;
        int columns = a[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void printMatrixTransposition(int[][] a) {
        int rows = a.length;
        int columns = a[0].length;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[][] a = {{2, 3, 5,}, {6, 7, 8}};
        printMatrix(a);
        printMatrixTransposition(a);
    }
}
