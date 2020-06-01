import java.util.concurrent.BlockingQueue;

public class ConsumerTake extends AbstractConsumer {

    public ConsumerTake(BlockingQueue<Integer> queue) {
        super(queue);
    }

    @Override
    public void run() {
        System.out.println("[Consumer] run");
        while (true) {
            try {
                consume();
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void consume() throws InterruptedException {
        Integer i = queue.take();
        System.out.println("[Consumer] consumed: " + i);
    }
}