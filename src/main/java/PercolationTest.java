import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class PercolationTest {
    @Test
    public void shouldInitialiseThePercolator() throws Exception {
        Percolation percolation = new Percolation(1);
        Assert.assertThat(percolation.isOpen(1, 1), Is.is(false));
        Assert.assertThat(percolation.isFull(1, 1), Is.is(true));
        Assert.assertThat(percolation.percolates(), Is.is(false));
    }

    @Test
    public void shouldPercolateOnATrivialPercolator() throws Exception {
        Percolation percolation = new Percolation(1);
        percolation.open(1, 1);
        Assert.assertThat(percolation.isOpen(1, 1), Is.is(true));
        Assert.assertThat(percolation.isFull(1, 1), Is.is(false));
        Assert.assertThat(percolation.percolates(), Is.is(true));
    }

    @Test
    public void shouldNotPercolateOnTwoByTwoWithOnlyTheTopOpen() throws Exception {
        Percolation percolation = new Percolation(2);
        percolation.open(1, 1);
        Assert.assertThat(percolation.isFull(1, 1), Is.is(false));
        Assert.assertThat(percolation.isFull(1, 2), Is.is(true));
        Assert.assertThat(percolation.isFull(2, 1), Is.is(true));
        Assert.assertThat(percolation.isFull(2, 2), Is.is(true));
        Assert.assertThat(percolation.percolates(), Is.is(false));
    }

    @Test
    public void shouldPercolateOnTwoByTwoWithTheTopAndBottomOpen() throws Exception {
        Percolation percolation = new Percolation(2);
        percolation.open(1, 1);
        percolation.open(2, 1);
        Assert.assertThat(percolation.isFull(1, 1), Is.is(false));
        Assert.assertThat(percolation.isOpen(1, 1), Is.is(true));
        Assert.assertThat(percolation.isOpen(2, 1), Is.is(true));
        Assert.assertThat(percolation.isFull(1, 2), Is.is(true));
        Assert.assertThat(percolation.isFull(2, 2), Is.is(true));
        Assert.assertThat(percolation.percolates(), Is.is(true));
    }

    @Test
    public void shouldNotPercolateOnTwoByTwoWithTheTopLeftAndBottomRightOpen()
            throws Exception {
        Percolation percolation = new Percolation(2);
        Assert.assertThat(percolation.isFull(1, 1), Is.is(true));
        percolation.open(1, 1);
        Assert.assertThat(percolation.isFull(1, 1), Is.is(false));
        percolation.open(2, 2);
        Assert.assertThat(percolation.percolates(), Is.is(false));
    }

    @Test
    public void shouldPercolateWhenConnectingSouthWithWest() throws Exception {
        Percolation percolation = new Percolation(2);
        percolation.open(1, 1);
        Assert.assertThat(percolation.isFull(1, 1), Is.is(false));
        percolation.open(2, 2);
        percolation.open(1, 2);
        Assert.assertThat(percolation.percolates(), Is.is(true));
    }

    @Test
    public void shouldPercolateWhenConnectingNorthWithEast() throws Exception {
        Percolation percolation = new Percolation(2);
        percolation.open(1, 1);
        percolation.open(2, 2);
        percolation.open(2, 1);
        Assert.assertThat(percolation.percolates(), Is.is(true));
    }

    @Test
    public void shouldNotPercolateWhenNoTopSiteIsOpen() throws Exception {
        Percolation percolation = new Percolation(3);
        percolation.open(2, 2);
        percolation.open(2, 1);
        percolation.open(3, 1);
        percolation.open(3, 2);
        percolation.open(3, 3);
        Assert.assertThat(percolation.percolates(), Is.is(false));
    }

    @Test
    public void shouldNotPercolateWhenNoBottomSiteIsOpen() throws Exception {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.open(1, 3);
        Assert.assertThat(percolation.percolates(), Is.is(false));
    }

    @Test
    public void shouldPercolate3InLine() throws Exception {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 1);
        percolation.open(2, 1);
        percolation.open(3, 1);
        Assert.assertThat(percolation.isFull(1, 2), Is.is(true));
        Assert.assertThat(percolation.isFull(1, 3), Is.is(true));
        Assert.assertThat(percolation.isFull(2, 2), Is.is(true));
        Assert.assertThat(percolation.isFull(2, 3), Is.is(true));
        Assert.assertThat(percolation.isFull(3, 2), Is.is(true));
        Assert.assertThat(percolation.isFull(3, 3), Is.is(true));
        Assert.assertThat(percolation.percolates(), Is.is(true));
    }
}
