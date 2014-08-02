import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * one idea is to start adding in the middle of the array
 *
 * other idea is to use a stack and a queue
 * @param <Item>
 */
public class Deque1<Item> implements Iterable<Item> {
    private Item[] items;
    private int N = 0;
    private int first;
    private int last;

    // construct an empty deque
    public Deque1() {
        items = (Item[]) new Object[3];
    }

    // is the deque empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the deque
    public int size() {
        return N;
    }

    // insert the item at the front
    public void addFirst(Item item) {
        if(item == null){
            throw new NullPointerException();
        }
        if(N == 0){
           N++;

        }
    }

    // insert the item at the end
    public void addLast(Item item) {
        if(item == null){
            throw new NullPointerException();
        }
    }

    // delete and return the item at the front
    public Item removeFirst() {
        if (N == 0) {
            throw new NoSuchElementException();
        }
        return null;
    }

    // delete and return the item at the end
    public Item removeLast() {
        if (N == 0) {
            throw new NoSuchElementException();
        }
        return null;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        int current = first;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            if(current == 0){
                throw new NoSuchElementException();
            }
            return items[current++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}