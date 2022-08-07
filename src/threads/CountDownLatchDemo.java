package threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    static int i = 0;
    static int j = 0;
    static int k = 0;

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3);

        service.execute(() -> {
            try {
                Thread.sleep(1000);
                i = 30;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1st service completed");
            latch.countDown();
        });
        service.execute(() -> {
            try {
                Thread.sleep(1000);
                j = 30;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2nd service completed");
            latch.countDown();
        });
        service.execute(() -> {
            try {
                Thread.sleep(1000);
                k = 30;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("3rd service completed");
            latch.countDown();
        });

        try {
            System.out.println("Latch Count : " + latch.getCount());
            System.out.println("Initial Work : " + (i + j + k));
            latch.await();
            System.out.println("Latch Count : " + latch.getCount());
            System.out.println("Final Work : " + (i + j + k));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
