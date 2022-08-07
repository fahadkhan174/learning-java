package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {

    public static void main(String[] args) {

        BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<>(50);

        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(() -> {
            for (int i = 1; i < 1000; i++) {
                try {
                    System.out.println("Produced : " + i);
                    sharedQueue.put(i);
                    // Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        service.execute(() -> {
            while (true) {
                try {
                    Integer i = sharedQueue.take();
                    Thread.sleep(1000);
                    System.out.println("Consumed : " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
