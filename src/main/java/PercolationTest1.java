import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PercolationTest1 {
    @Test
    public void shouldInitialiseThePercolator() throws Exception {
        Percolation percolation = new Percolation(1);
        assertThat(percolation.isOpen(1, 1), is(false));
        assertThat(percolation.isFull(1, 1), is(false));
        assertThat(percolation.percolates(), is(false));
    }

    @Test
    public void shouldPercolateOnATrivialPercolator() throws Exception {
        Percolation percolation = new Percolation(1);
        percolation.open(1, 1);
        assertThat(percolation.isOpen(1, 1), is(true));
        assertThat(percolation.isFull(1, 1), is(true));
        assertThat(percolation.percolates(), is(true));
    }

    @Test
    public void shouldNotPercolateOnTwoByTwoWithOnlyTheTopOpen() throws Exception {
        Percolation percolation = new Percolation(2);
        percolation.open(1, 1);
        assertThat(percolation.isFull(1, 1), is(true));
        assertThat(percolation.isFull(1, 2), is(false));
        assertThat(percolation.isFull(2, 1), is(false));
        assertThat(percolation.isFull(2, 2), is(false));
        assertThat(percolation.percolates(), is(false));
    }

    @Test
    public void shouldPercolateOnTwoByTwoWithTheTopAndBottomOpen() throws Exception {
        Percolation percolation = new Percolation(2);
        percolation.open(1, 1);
        percolation.open(2, 1);
        assertThat(percolation.isFull(1, 1), is(true));
        assertThat(percolation.isFull(2, 1), is(true));
        assertThat(percolation.percolates(), is(true));
    }

    @Test
    public void shouldNotPercolateOnTwoByTwoWithTheTopLeftAndBottomRightOpen() throws Exception {
        Percolation percolation = new Percolation(2);
        percolation.open(1, 1);
        percolation.open(2, 2);
        assertThat(percolation.isFull(1, 1), is(true));
        assertThat(percolation.isFull(2, 2), is(false));
        assertThat(percolation.percolates(), is(false));
    }

    @Test
    public void shouldPercolateWhenConnectingSouthWithWest() throws Exception {
        Percolation percolation = new Percolation(2);
        percolation.open(1, 1);
        percolation.open(2, 2);
        percolation.open(1, 2);
        assertThat(percolation.isFull(1, 1), is(true));
        assertThat(percolation.isFull(2, 2), is(true));
        assertThat(percolation.isFull(1, 2), is(true));
        assertThat(percolation.percolates(), is(true));
    }

    @Test
    public void shouldPercolateWhenConnectingNorthWithEast() throws Exception {
        Percolation percolation = new Percolation(2);
        percolation.open(1, 1);
        percolation.open(2, 2);
        percolation.open(2, 1);
        assertThat(percolation.isFull(2, 1), is(true));
        assertThat(percolation.percolates(), is(true));
    }

    @Test
    public void shouldNotBeFullBackwash() throws Exception {
        Percolation percolation = new Percolation(3);
        percolation.open(2, 1);
        percolation.open(3, 1);
        percolation.open(1, 3);
        percolation.open(2, 3);
        percolation.open(3, 3);
        assertThat(percolation.percolates(), is(true));
        assertThat(percolation.isFull(1, 3), is(true));
        assertThat(percolation.isFull(2, 3), is(true));
        assertThat(percolation.isFull(3, 3), is(true));
        assertThat(percolation.isFull(2, 1), is(false));
        assertThat(percolation.isFull(3, 1), is(false));
    }
}
