import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RandomizedQueueTest {
    private final RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

    @Test
    public void shouldBeEmptyOnConstruction() throws Exception {
        assertThat(queue.isEmpty(), is(true));
        assertThat(queue.size(), is(0));
        assertThat(queue.iterator().hasNext(), is(false));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNPEWhenAddingNullElement() {
        queue.enqueue(null);
    }


    @Test(expected = NoSuchElementException.class)
    public void dequeueElementFromAnEmptyQueueIsNotAllowed() {
        queue.dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void sampleElementFromAnEmptyQueueIsNotAllowed() throws Exception {
        queue.sample();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void callingRemoveOnIteratorNotAllowed() throws Exception {
        queue.iterator().remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void callingNextOnAnEmptyIteratorIsNotAllowed() throws Exception {
        queue.iterator().next();
    }

    @Test
     public void shouldHaveOnlyOneElement() throws Exception {
        queue.enqueue(1);
        assertThat(queue.size(), is(1));
        assertThat(queue.sample(), is(1));
        assertThat(queue.dequeue(), is(1));
    }

    @Test
    public void shouldHaveTwoElementsAndThenOne() throws Exception {
        queue.enqueue(1);
        queue.enqueue(2);
        assertThat(queue.size(), is(2));
        queue.sample();
        assertThat(queue.size(), is(2));
        queue.dequeue();
        assertThat(queue.size(), is(1));
        queue.dequeue();
        assertThat(queue.size(), is(0));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void shouldHandleNonEmptyToEmptyBackToNonEmpty() throws Exception {
        queue.enqueue(1);
        queue.dequeue();
        queue.enqueue(1);
        assertThat(queue.size(), is(1));
        assertThat(queue.isEmpty(), is(false));
        assertThat(queue.dequeue(), is(1));
    }

    @Test
    public void shouldHandleMultipleIterators() throws Exception {
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        final Iterator<Integer> iterator1 = queue.iterator();
        final Iterator<Integer> iterator2 = queue.iterator();
        System.out.println(iterator1.next());
        System.out.println(iterator1.next());
        System.out.println(iterator1.next());
        System.out.println(iterator2.next());
        System.out.println(iterator2.next());
        System.out.println(iterator2.next());
    }

    @Test
    public void shouldHaveFiveElementsAndThenZero() throws Exception {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertThat(queue.size(), is(5));
        queue.sample();
        assertThat(queue.size(), is(5));
        queue.dequeue();
        assertThat(queue.size(), is(4));
        queue.dequeue();
        assertThat(queue.size(), is(3));
        queue.dequeue();
        assertThat(queue.size(), is(2));
        queue.dequeue();
        assertThat(queue.size(), is(1));
        queue.dequeue();
        assertThat(queue.isEmpty(), is(true));
        assertThat(queue.size(), is(0));
    }

    @Test
    public void shouldHaveThreeElementsAndThenZero() throws Exception {
        RandomizedQueue<Integer> queue1 = new RandomizedQueue<Integer>();
        RandomizedQueue<Integer> queue2 = new RandomizedQueue<Integer>();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        System.out.println(queue2.dequeue());
        System.out.println(queue2.dequeue());
        System.out.println(queue2.dequeue());
    }

}
