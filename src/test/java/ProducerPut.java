import java.util.Random;
import java.util.concurrent.BlockingQueue;

class ProducerPut extends AbstractProducer implements Runnable {

    public ProducerPut(BlockingQueue<Integer> queue) {
        super(queue);

    }

    @Override
    public void run() {
        System.out.println("[Producer] run");
        while (true) {
            try {
                queue.put(produce());
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected Integer produce() {
        Integer i = new Random().nextInt(100);
        System.out.println("[Producer] produce: " + i);
        return i;
    }
}
