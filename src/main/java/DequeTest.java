import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DequeTest {
    private final Deque<Integer> deque = new Deque<Integer>();

    @Test
    public void shouldBeEmptyOnConstruction() throws Exception {
        assertThat(deque.isEmpty(), is(true));
        assertThat(deque.size(), is(0));
        assertThat(deque.iterator().hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void removingFirstElementFromAnEmptyQueueIsNotAllowed() throws Exception {
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void removingLastElementFromAnEmptyQueueIsNotAllowed() throws Exception {
        deque.removeLast();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removingElementsThroughTheIteratorIsNotAllowed() throws Exception {
        deque.iterator().remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void callingNextOnAnEmptyIteratorIsNotAllowed() throws Exception {
        deque.iterator().next();
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotAllowQueuingInTheFrontANull() throws Exception {
        deque.addFirst(null);
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotAllowQueuingInTheBackANull() throws Exception {
        deque.addLast(null);
    }

    @Test
    public void addFirstMakesTheDequeSizeOne() throws Exception {
        deque.addFirst(1);
        assertThat(deque.iterator().next(), is(1));
        assertThat(deque.size(), is(1));
        assertThat(deque.isEmpty(), is(false));
    }

    @Test
    public void addLastMakesTheDequeSizeOne() throws Exception {
        deque.addLast(1);
        assertThat(deque.size(), is(1));
        assertThat(deque.isEmpty(), is(false));
    }

    @Test
    public void shouldRemoveWhatIveAddedFirst() throws Exception {
        deque.addFirst(1);
        assertThat(deque.removeFirst(), is(1));
        assertThat(deque.size(), is(0));
        assertThat(deque.isEmpty(), is(true));
    }

    @Test
    public void shouldRemoveWhatIveAddedLast() throws Exception {
        deque.addLast(1);
        assertThat(deque.removeLast(), is(1));
        assertThat(deque.size(), is(0));
        assertThat(deque.isEmpty(), is(true));
    }

    @Test
    public void shouldHaveTwoElementsAfterAddingToElementsToTheFront() throws Exception {
        deque.addFirst(1);
        deque.addFirst(2);
        assertThat(deque.size(), is(2));
        assertThat(deque.isEmpty(), is(false));
        assertThat(deque.removeFirst(), is(2));
        assertThat(deque.removeFirst(), is(1));
    }

    @Test
    public void shouldHaveTwoElementsAfterAddingToElementsToTheBack() throws Exception {
        deque.addLast(1);
        deque.addLast(2);
        assertThat(deque.size(), is(2));
        assertThat(deque.isEmpty(), is(false));
        assertThat(deque.removeLast(), is(2));
        assertThat(deque.removeLast(), is(1));
    }

    @Test
    public void shouldBeAbleToRemoveElementsFromTheFrontThatWereAddedToTheBack() throws Exception {
        deque.addLast(1);
        deque.addLast(2);
        assertThat(deque.removeFirst(), is(1));
        assertThat(deque.removeFirst(), is(2));
    }

    @Test
    public void shouldBeAbleToRemoveElementsFromTheBackThatWereAddedToTheFront() throws Exception {
        deque.addFirst(1);
        deque.addFirst(2);
        assertThat(deque.removeLast(), is(1));
        assertThat(deque.removeLast(), is(2));
    }

    @Test
    public void shouldHandleAddingToTheBackAndFrontAndPullingFromTheFront() throws Exception {
        deque.addFirst(1);
        deque.addLast(2);
        assertThat(deque.removeFirst(), is(1));
        assertThat(deque.removeFirst(), is(2));
    }

    @Test
    public void shouldHandleAddingToTheBackAndFrontAndPullingFromTheBack() throws Exception {
        deque.addFirst(1);
        deque.addLast(2);
        assertThat(deque.removeLast(), is(2));
        assertThat(deque.removeLast(), is(1));
    }

    @Test
    public void shouldHandleAddingThreeElementsAndGetThemCorrectlyFromTheBack() throws Exception {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        assertThat(deque.removeLast(), is(3));
        assertThat(deque.removeLast(), is(1));
        assertThat(deque.removeLast(), is(2));
    }

    @Test
    public void shouldHandleAddingThreeElementsAndGetThemCorrectlyFromTheFront() throws Exception {
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        assertThat(deque.removeFirst(), is(1));
        assertThat(deque.removeFirst(), is(2));
        assertThat(deque.removeFirst(), is(3));
    }

    @Test
    public void shouldHandleNonEmptyToEmptyBackToNonEmpty() throws Exception {
        deque.addFirst(1);
        deque.removeLast();
        deque.addLast(1);
        assertThat(deque.size(), is(1));
        assertThat(deque.isEmpty(), is(false));
        assertThat(deque.removeFirst(), is(1));
    }

    @Test
    public void shouldHandleMultipleIterators() throws Exception {
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        final Iterator<Integer> iterator1 = deque.iterator();
        final Iterator<Integer> iterator2 = deque.iterator();
        assertThat(iterator1.next(), is(1));
        assertThat(iterator1.next(), is(2));
        assertThat(iterator2.next(), is(1));
        assertThat(iterator2.next(), is(2));
        assertThat(iterator2.next(), is(3));
        assertThat(iterator1.next(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldHaveZeroElementsAfter() throws Exception {
        deque.addFirst(1);
        deque.addLast(2);
        assertThat(deque.removeFirst(), is(1));
        assertThat(deque.removeLast(), is(2));
        final Iterator<Integer> iterator = deque.iterator();
        iterator.next();
    }
}