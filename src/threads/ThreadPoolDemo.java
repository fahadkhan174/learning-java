package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
	public static void main(String[] args) {

		// ExecutorService exs = Executors.newFixedThreadPool(2);
		ExecutorService exs=Executors.newCachedThreadPool();
		exs.execute(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("this is first thread " + Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		exs.execute(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("this is second thread " + Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		exs.execute(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("this is third thread " + Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
