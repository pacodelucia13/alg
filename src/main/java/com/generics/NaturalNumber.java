package com.generics;

/**
 * Created with IntelliJ IDEA.
 * User: popovis
 * Date: 09/09/13
 * Time: 18:29
 * To change this template use File | Settings | File Templates.
 */
public class NaturalNumber<T extends Integer> {

    private T n;

    public NaturalNumber(T n)  { this.n = n; }

    public boolean isEven() {
        return n.intValue() % 2 == 0;
    }

//    public static void main(String[] args) {
//        List<EvenNumber> le = new ArrayList<EvenNumber>();
//        List<? extends NaturalNumber> ln = le;
//        //ln.add(new NaturalNumber(35));  // compile-time error
//    }
}


//class EvenNumber extends NaturalNumber {
//
//    //public EvenNumber(int i) { super(i); }
//    // ...
//}