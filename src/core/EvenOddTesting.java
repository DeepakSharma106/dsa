package core;

class Printer {
    private volatile boolean isOdd;

    synchronized void printOdd(int number) {
        while(isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+": "+number);
        isOdd = true;
        notify();
    }

    synchronized void printEven(int number) {
        while(!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+": "+number);
        isOdd = false;
        notify();
    }

}


class EvenOddTask implements Runnable {

    private Printer printer;
    private boolean isEven;

    public EvenOddTask(Printer printer, boolean isEven) {
        this.printer = printer;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        int number = isEven ? 2 : 1;
        while(number <= 20) {
            if(isEven) {
                printer.printEven(number);
                number += 2;
            } else {
                printer.printOdd(number);
                number += 2;
            }
        }
    }
}

public class EvenOddTesting {

    public static void main(String[] args) {
        Printer sharedPrinter = new Printer();
        Thread evenThread = new Thread(new EvenOddTask(sharedPrinter, true));
        evenThread.setName("even thread");
        Thread oddThread = new Thread(new EvenOddTask(sharedPrinter, false));
        oddThread.setName("odd thread");
        evenThread.start();
        oddThread.start();
    }
}
