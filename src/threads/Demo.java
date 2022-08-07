package threads;

public class Demo {

    public static void main(String[] args) {

        Runnable r1 = () -> {
            System.out.println("Run Impl");
        };
        r1.run();

        Thread t1 = new Thread(r1);
        t1.start();

        Worker w1 = new Worker();
        Thread t2 = new Thread(w1);
        t2.start();
    }

    static class Worker implements Runnable {

        @Override
        public void run() {
            System.out.println("Worker RUN method");

        }
    }

}
