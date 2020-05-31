import lombok.Getter;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class SynchronizedQueue<E> implements BlockingQueue<E> {

    private final LinkedList<E> queue = new LinkedList<>();
    @Getter
    private final int capacity;

    public SynchronizedQueue(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException();
        this.capacity = capacity;
    }

    @Override
    public synchronized boolean add(E e) {
        if (queue.size() < capacity) {
            queue.add(e);
            return true;
        } else throw new IllegalStateException();
    }

    @Override
    public synchronized boolean offer(E e) {
        if (queue.size() < capacity) {
            queue.add(e);
            return true;
        } else return false;
    }

    @Override
    public E remove() {
        return queue.remove();
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException();
        } else return queue.peek();
    }

    @Override
    public E peek() {
        return queue.peek();
    }

    @Override
    public synchronized void put(E e) throws InterruptedException {
        while (this.queue.size() == this.capacity) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(e);
    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public E take() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.capacity) {
            notifyAll();
        }

        return this.queue.remove(0);
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public synchronized int remainingCapacity() {
        return queue.size() - capacity;
    }

    @Override
    public boolean remove(Object o) {
        return queue.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return queue.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.size() > capacity) {
            throw new IllegalArgumentException();
        } else return queue.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return queue.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return queue.retainAll(c);
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return queue.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }

    @Override
    public Object[] toArray() {
        return queue.toArray();
    }

    @Override
    @SuppressWarnings("all")
    public <T> T[] toArray(T[] a) {
        return queue.toArray(a);
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        return 0;
    }
}