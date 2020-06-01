import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

import static org.testng.Assert.*;

public class SynchronizedQueueTest {

    @Test
    public void testAdd() {
    }

    @Test
    public void testOffer() {
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void testPoll() {
    }

    @Test
    public void testElement() {
    }

    @Test
    public void testPeek() {
    }

    @Test
    public void testPut() {
    }

    @Test
    public void testTestOffer() {
    }

    @Test
    public void testTake() {
    }

    @Test
    public void testTestPoll() {
    }

    @Test
    public void testRemainingCapacity() {
        BlockingQueue<Integer> synchronizedQueue = new SynchronizedQueue<>(5);

        synchronizedQueue.addAll(Arrays.asList(1, 2, 3));
        assertEquals(synchronizedQueue.remainingCapacity(), 2);
    }

    @Test
    public void testTestRemove() {
    }

    @Test
    public void testAddAll() {
        BlockingQueue<Integer> synchronizedQueue = new SynchronizedQueue<>(5);
        assertTrue(synchronizedQueue.isEmpty());

        synchronizedQueue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(synchronizedQueue.size(), 5);
    }

    @Test
    public void testAddAllNegative() {
        BlockingQueue<Integer> synchronizedQueue = new SynchronizedQueue<>(1);
        assertTrue(synchronizedQueue.isEmpty());

        expectThrows(IllegalArgumentException.class, () -> synchronizedQueue.addAll(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void testDrainTo() {
    }

    @Test
    public void testTestDrainTo() {
    }
}