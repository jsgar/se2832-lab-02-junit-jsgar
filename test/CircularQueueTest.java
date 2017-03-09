import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * SE1021
 * Winter 2016
 * Brad Dennis
 * 3/9/2017
 */
public class CircularQueueTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isEmpty() throws Exception {
        //Arrange & Act
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Assert
        assertTrue(queue.isEmpty());
    }

}