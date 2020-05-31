public class Test {

    private SynchronizedQueue<Integer> integers;

    public void test() {
        integers = new SynchronizedQueue<>(1);
        integers.add(1);
    }
}
