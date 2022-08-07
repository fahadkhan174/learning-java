package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    Semaphore permit = new Semaphore(2);
    
    public static void main(String[] args) {
        
        SemaphoreExample se = new SemaphoreExample();

        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(()-> {
            try {
                se.permit.acquire();
                System.out.println("Acquired permit and started Service 1");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

			se.permit.release();
            System.out.println("Released from service 1");
            
        });

        service.execute(()-> {
            try {
                se.permit.acquire();
                System.out.println("Acquired permit and started Service 2");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            se.permit.release();
            System.out.println("Released from service 2");
            
        });

        service.execute(()-> {
            try {
                se.permit.acquire();
                System.out.println("Acquired permit and started Service 3");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            se.permit.release();
            System.out.println("Released from service 3");
            
        });
    }
    
}
