/**
 *  |
 *  XXXXXXXXXXXXXXX
 *  |
 */
public class LinkedStackOfStrings {
    private Node first;

    public LinkedStackOfStrings() {
    }

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
}
