package com.generics;

/**
 * Created with IntelliJ IDEA.
 * User: popovis
 * Date: 09/09/13
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
public class OrderedPair<K,V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }

    public static void main(String[] args) {
        Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
        Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");
        OrderedPair<String, Box<Integer>> p = new OrderedPair<String, Box<Integer>>("primes", new Box<Integer>());

        Pair<Integer, String> p3 = new OrderedPair<Integer, String>(1, "apple");
        Pair<Integer, String> p4 = new OrderedPair<Integer, String>(2, "pear");
        boolean same = Util.<Integer, String>compare(p3, p4);
    }
}
