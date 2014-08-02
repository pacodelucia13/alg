package ex1_1;

/**
 * Created with IntelliJ IDEA.
 * User: popovis
 * Date: 11/08/13
 * Time: 20:45
 * To change this template use File | Settings | File Templates.
 */
public class Ex114 {
    public static int getClosestInt(int N) {
        int x;
        for (int i = 0; i < N; i++) {
            int pow2tox = 1;
            int pow2toxplus1 = 2;
            for(int j=0; j< i; j++){
               pow2tox = pow2tox * 2;
               pow2toxplus1 = pow2toxplus1 * 2;
            }
            if (pow2tox <= N && pow2toxplus1 > N) {
                 return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getClosestInt(1));
    }
}
