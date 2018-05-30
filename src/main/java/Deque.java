import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // insert the item at the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException ();
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        if (size == 0) {
            last = first;
        }
        first.next = oldFirst;
        if (size > 0)
            oldFirst.previous = first;
        size++;
    }

    // insert the item at the end
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException ();
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (size == 0) {
            first = last;
        }
        if (size > 0) {
            oldLast.next = last;
            last.previous = oldLast;
        }
        size++;
    }

    // delete and return the item at the front
    public Item removeFirst() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        if (size == 1) {
            first = null;
            last = null;
        }
        if (size > 1)
            first.previous = null;
        size--;
        return item;
    }

    // delete and return the item at the end
    public Item removeLast() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        Item item = last.item;
        last = last.previous;
        if (size == 1) {
            first = null;
            last = null;
        }
        if (size > 1)
            last.next = null;
        size--;
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}
