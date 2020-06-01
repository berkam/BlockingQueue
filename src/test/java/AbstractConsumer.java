import java.util.concurrent.BlockingQueue;

public abstract class AbstractConsumer implements Runnable {
    protected final BlockingQueue<Integer> queue;

    public AbstractConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    protected abstract void consume() throws InterruptedException;
}
