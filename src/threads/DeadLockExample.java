package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockExample {
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(() -> {
			synchronized (lock1) {
				System.out.println("this is Thread 1 lock 1");

				try {
					Thread.sleep(10);
				} catch (Exception e) {
				}
				synchronized (lock2) {
					System.out.println("Thread 1 holding lock2");
				}
			}

		});
		service.execute(() -> {
			synchronized (lock2) {
				System.out.println("this is Thread 2 lock 2");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				synchronized (lock1) {
					System.out.println("Thread 2 holding lock1");
				}
			}

		});
	}
}
