package threads;

public class OddEvenPrinter {

    private int count = 1;
    private int number;

    public OddEvenPrinter(int number) {
        this.number = number;
    }

    public void printOdd() {
        synchronized (this) {
            while (count < number) {
                if (count % 2 != 0) {
                    System.out.println("This is Odd Number : " + count);
                    count++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            while (count < number) {
                if (count % 2 == 0) {
                    System.out.println("This is Even Number : " + count);
                    count++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter(11);
        Thread t1 = new Thread(printer::printOdd);
        Thread t2 = new Thread(printer::printEven);

        t1.start();
        t2.start();
    }

}
