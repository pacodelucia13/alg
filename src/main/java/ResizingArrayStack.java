import java.util.Iterator;

/**
 * |
 * XXXXXXXXXXXXXXXX
 * <-
 */
public class ResizingArrayStack<Item> {
    private Item[] s;
    private int N = 1;

    public ResizingArrayStack() {
        s = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    public Item pop() {
        Item item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length / 4) resize(s.length / 2);
        return item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    private class ResizeArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return s[--i];
        }

        @Override
        public void remove() {
            /* not supported */
        }
    }

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 1600*1600; i = i*3)
            for (int j = 1; j <= i; j++)
                sum++;

        System.out.print(sum);
    }
}
