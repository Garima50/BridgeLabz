class NumberThread extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
            try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        }
    }
}

class AlphabetRunnable implements Runnable {

    @Override
    public void run() {

        for (char c = 'A'; c <= 'B'; c++) {
            System.out.println(c);
            try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        System.out.println("User Thread Finished");
    }
}

public class MultiThreadDemo {

    public static void main(String[] args) {

        NumberThread number = new NumberThread();
        Thread t1 = new Thread(number);

        AlphabetRunnable alphabet = new AlphabetRunnable();

        Thread t2 = new Thread(alphabet);

        //t1.setDaemon(true);
       
        // // main thread waits for t1 when we use 
        //  try {
        //     t1.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        t2.start();
        t1.start();

        
        


    }
}