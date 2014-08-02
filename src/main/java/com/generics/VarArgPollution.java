package com.generics;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: popovis
 * Date: 10/09/13
 * Time: 08:21
 * To change this template use File | Settings | File Templates.
 */
public class VarArgPollution {

    public static <T> void addToList(List<T> listArg, T... elements) {
        for (T x : elements) {
            listArg.add(x);
        }
    }


    public static void faultyMethod(List<String>... l) {
        Object[] objectArray = l;     // Valid
        objectArray[0] = Arrays.asList(42);
        String s = l[0].get(0);       // ClassCastException thrown here
    }

    public static void main(String[] args) {
        List<Integer> ls = new LinkedList<Integer>();
        addToList(ls, 1, 2 ,3);
    }

}