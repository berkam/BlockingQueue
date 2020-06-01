import java.util.concurrent.BlockingQueue;

public abstract class AbstractProducer implements Runnable {
    protected final BlockingQueue<Integer> queue;

    public AbstractProducer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    protected abstract Integer produce();
}
