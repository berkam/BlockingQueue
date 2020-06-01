import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class SynchronizedQueueTest {

    @Test
    public void testAddPositive() {
        BlockingQueue<Integer> synchronizedQueue = new SynchronizedQueue<>(6);
        synchronizedQueue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        assertTrue(synchronizedQueue.add(6));
    }

    @Test
    public void testAddNegative() {
        BlockingQueue<Integer> synchronizedQueue = new SynchronizedQueue<>(5);
        synchronizedQueue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        expectThrows(IllegalStateException.class, () -> synchronizedQueue.add(6));
    }

    @Test
    public void testOfferPositive() {
        BlockingQueue<Integer> synchronizedQueue = new SynchronizedQueue<>(6);
        synchronizedQueue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        assertTrue(synchronizedQueue.offer(6));
    }

    @Test
    public void testOfferNegative() {
        BlockingQueue<Integer> synchronizedQueue = new SynchronizedQueue<>(5);
        synchronizedQueue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        assertFalse(synchronizedQueue.offer(6));
    }

    @Test
    public void testOfferWithTimePositive() throws InterruptedException {
        BlockingQueue<Integer> synchronizedQueue = new SynchronizedQueue<>(6);
        synchronizedQueue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        assertTrue(synchronizedQueue.offer(6, 100L, TimeUnit.MILLISECONDS));
    }

    @Test
    public void testOfferWithTimeNegative() throws InterruptedException {
        BlockingQueue<Integer> synchronizedQueue = new SynchronizedQueue<>(5);
        synchronizedQueue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        assertFalse(synchronizedQueue.offer(6, 100L, TimeUnit.MILLISECONDS));
    }

    @Test
    public void testRemove() {
        BlockingQueue<Integer> synchronizedQueue = new SynchronizedQueue<>(5);
        synchronizedQueue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        assertTrue(synchronizedQueue.contains(5));

        synchronizedQueue.remove();
        assertFalse(synchronizedQueue.contains(1));
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
        BlockingQueue<Integer> synchronizedQueue = new SynchronizedQueue<>(5);
        synchronizedQueue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        assertTrue(synchronizedQueue.contains(5));

        synchronizedQueue.remove(5);
        assertFalse(synchronizedQueue.contains(5));
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
    public void testDrainToWithoutMaxElements() {
        BlockingQueue<Integer> synchronizedQueue = new SynchronizedQueue<>(5);
        ArrayList<Integer> list = new ArrayList<>();
        synchronizedQueue.addAll(Arrays.asList(1, 2, 3, 4, 5));

        assertEquals(synchronizedQueue.drainTo(list), 5);
        assertEquals(list.size(), 5);
        assertEquals(list, Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    public void testTestDrainToWithMaxElements() {
        BlockingQueue<Integer> synchronizedQueue = new SynchronizedQueue<>(5);
        ArrayList<Integer> list = new ArrayList<>();
        synchronizedQueue.addAll(Arrays.asList(1, 2, 3, 4, 5));

        assertEquals(synchronizedQueue.drainTo(list, 3), 3);
        assertEquals(list.size(), 3);
        assertEquals(list, Arrays.asList(1, 2, 3));
    }
}