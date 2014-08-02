package ex1_1;

/**
 * Created with IntelliJ IDEA.
 * User: popovis
 * Date: 11/08/13
 * Time: 15:07
 * To change this template use File | Settings | File Templates.
 */
public class Ex13 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        if (a == b && b == c){
            System.out.println("equal");
        }
        else{
            System.out.println("not equal");
        }
    }
}
