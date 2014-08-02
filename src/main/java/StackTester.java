import stdlib.StdOut;

/**
 * Created with IntelliJ IDEA.
 * User: popovis
 * Date: 20/09/13
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */
public class StackTester {
    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();

        String toParse = "- to be or not to - be - - that - - - is";
        for(String token: toParse.split(" ")){
            if(token.equals("-")) StdOut.print(stack.pop() + " ");
            else stack.push(token);
       }
    }
}
