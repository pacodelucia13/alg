package com.generics;

/**
 * Created with IntelliJ IDEA.
 * User: popovis
 * Date: 09/09/13
 * Time: 18:38
 * To change this template use File | Settings | File Templates.
 */
class MyClass<X> {
    <T> MyClass(T t) {
        System.out.println(t.getClass().getName());
    }

    public static void main(String[] args) {
        MyClass<Integer> myClass = new MyClass<Integer>("");
    }
}