package com.generics;

/**
 * Created with IntelliJ IDEA.
 * User: popovis
 * Date: 09/09/13
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
public class Box<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public <U extends Number> void inspect(U u) {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(new Integer(10));
        integerBox.inspect(10l);
    }
}
