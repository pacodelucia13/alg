import stdlib.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int noOfElements = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        items = (Item[]) new Object[1];
    }

    // is the queue empty?
    public boolean isEmpty() {
        return noOfElements == 0;
    }

    // return the number of items on the queue
    public int size() {
        return noOfElements;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (noOfElements + 1 == items.length) {
            resize(2 * items.length);
        }
        items[noOfElements++] = item;
    }

    // delete and return a random item
    public Item dequeue() {
        if (noOfElements == 0) {
            throw new java.util.NoSuchElementException();
        }
        int randomIndex = StdRandom.uniform(noOfElements);
        Item dequeueItem = items[randomIndex];
        items[randomIndex] = items[noOfElements -1];
        items[noOfElements -1] = null;
        noOfElements--;
        if (noOfElements > 0 && noOfElements == items.length / 4) {
            resize(items.length / 2);
        }
        return dequeueItem;
    }

    // return (but do not delete) a random item
    public Item sample() {
        if (noOfElements == 0) {
            throw new java.util.NoSuchElementException();
        }
        return items[StdRandom.uniform(noOfElements)];
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < noOfElements; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }


    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int i = noOfElements;
        private Item[] copyOfItems;

        RandomizedQueueIterator(){
            copyOfItems = (Item[]) new Object[noOfElements];
            for (int i = 0; i < noOfElements; i++) {
                copyOfItems[i] = items[i];
            }
            StdRandom.shuffle(copyOfItems);
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            if(i == 0){
                throw new NoSuchElementException();
            }
            return copyOfItems[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}