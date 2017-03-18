import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Objects;

import static org.junit.Assert.*;

/*
 * SE2832
 * Spring 2017
 * Jenna Sgarlata
 * 3/18/2017
 */
public class CircularQueueTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test (expected = IllegalStateException.class)
    public void addShouldThrowIllegalArgumentExceptionWhenReachedMaxCapacity() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(1);

        queue.add("Hello");
        queue.add("Hello again");
    }

    @Test
    public void addShouldAddItemWhenQueueHasRoomForMoreElements() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.add("Hello");

        assertEquals(1,queue.size());
    }

    @Test
    public void elementShouldReturnTheLastElementWhenCalledOnAnOccupiedQueue() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.add("First");
        queue.add("Second");

        assertEquals("First", queue.element());
    }

    @Test (expected = NoSuchElementException.class)
    public void elementShouldThrowNoSuchElementExceptionWhenCalledOnEmptyList() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.element();
    }

    @Test
    public void offerShouldNotAddElementsWhenMaximumCapacityIsReached() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.offer("1");
        queue.offer("2");
        queue.offer("3");

        assertFalse(queue.offer("4"));
        assertEquals(3, queue.size());
    }

    @Test
    public void offerShouldAddElementsWhenQueueHasRoom() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        assertTrue(queue.offer("1"));
        assertEquals(1, queue.size());
        assertTrue(queue.offer("2"));
        assertEquals(2, queue.size());
        assertTrue(queue.offer("3"));
        assertEquals(3, queue.size());
    }

    @Test
    public void offerShouldAddElementsToBackWhenElementsAreAdded() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.offer("1");
        queue.offer("2");

        assertEquals("1", queue.peek());
        assertEquals("1", queue.element());
    }

    @Test
    public void peekShouldNotRemoveElementsWhenCalled() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.offer("1");
        queue.offer("2");
        queue.peek();

        assertEquals(2, queue.size());
    }

    @Test
    public void peekShouldReturnNullWhenQueueIsEmpty() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        assertTrue(queue.isEmpty());

        assertNull(queue.peek());
    }

    @Test
    public void peekShouldReturnTheFirstElementWhenCalled() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.offer("1");
        queue.offer("2");
        queue.offer("3");

        assertEquals("1", queue.peek());
    }

    @Test
    public void pollShouldReturnAndRemoveTheFirstElement() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.offer("1");
        queue.offer("2");
        queue.offer("3");

        assertEquals("1", queue.poll());
        assertEquals(2, queue.size());
        assertEquals("2", queue.poll());
        assertEquals(1, queue.size());
        assertEquals("3", queue.poll());
        assertEquals(0, queue.size());
    }

    @Test
    public void pollShouldReturnNullWhenQueueIsEmpty() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        assertNull(queue.poll());
    }

    @Test
    public void removeShouldReturnAndRemoveTheFirstElement() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.add("1");
        queue.add("2");
        queue.add("3");

        assertEquals("1", queue.remove());
        assertEquals(2, queue.size());
        assertEquals("2", queue.remove());
        assertEquals(1, queue.size());
        assertEquals("3", queue.remove());
        assertEquals(0, queue.size());
    }

    @Test (expected = NoSuchElementException.class)
    public void removeShouldThrowNoSuchElementExceptionWhenQueueIsEmpty() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);
        queue.remove();
    }

    @Test
    public void clearShouldCreateNewEmptyArrayWithSameCapacityWhenCalled() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);
        int sizeAfterClear;

        queue.offer("Test Value");
        queue.clear();
        sizeAfterClear = queue.size();
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");

        assertFalse(queue.offer("4"));
        assertEquals(0, sizeAfterClear);
    }

    @Test
    public void sizeShouldReturnTheNumberOfElementsWhenCalled() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);
        int[] dataPoints = new int[4];

        dataPoints[0] = queue.size();
        queue.offer("1");
        dataPoints[1] = queue.size();
        queue.offer("2");
        queue.offer("3");
        dataPoints[2] = queue.size();
        queue.poll();
        queue.poll();
        dataPoints[3] = queue.size();

        assertEquals(0, dataPoints[0]);
        assertEquals(1, dataPoints[1]);
        assertEquals(3, dataPoints[2]);
        assertEquals(1, dataPoints[3]);
    }

    @Test
    public void toArrayShouldBeTheSameSizeAsTheQueueWhenCalled() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.offer("1");
        queue.offer("2");

        assertEquals(2, queue.toArray().length);
    }

    @Test
    public void toArrayShouldHaveIdenticalElementsAsTheQueueWhenCalled() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);
        Object[] observed;

        queue.offer("1");
        queue.offer("2");
        observed = queue.toArray();

        assertEquals("1", observed[0]);
        assertEquals("2", observed[1]);
    }

    @Test
    public void getQueueCapacityShouldReturnTheSameValueFromInstantiationWhenCalled() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        assertEquals(3, queue.getQueueCapacity());
    }

    @Test
    public void getRemainingQueueSpacesShouldBeEqualToCapacityWhenInstantiated() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        assertEquals(queue.getQueueCapacity(), queue.getRemainingQueueSpace());
    }

    @Test
    public void getRemainingQueueSpacesShouldBeZeroWhenFull() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.offer("1");
        queue.offer("2");
        queue.offer("3");

        assertEquals(0, queue.getRemainingQueueSpace());
    }

    @Test
    public void isQueueFullShouldReturnTrueWhenThereAreNoRemainingSpaces() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.offer("1");
        queue.offer("2");
        queue.offer("3");

        assertTrue(queue.isQueueFull());
    }

    @Test
    public void isQueueFullShouldReturnFalseWhenThereAreRemainingSpaces() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(3);

        queue.offer("1");
        queue.offer("2");

        assertNotEquals(0, queue.getRemainingQueueSpace());
        assertFalse(queue.isQueueFull());
    }

    @Test
    public void isEmptyShouldReturnTrueWhenInstantiated() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(10);

        assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenObjectsArePresent() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(10);

        queue.offer("Hello");

        assertFalse(queue.isEmpty());
    }


    @Test (expected = Exception.class)
    public void ConstructorShouldThrowExceptionWhenValuesLessThanOneArePassedIn() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(0);
    }

    @Test
    public void ConstructorShouldSetTheCapacityToTheValuePassedInWhenTheValueIsValid() throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(10);

        assertEquals(10, queue.getQueueCapacity());
    }
}