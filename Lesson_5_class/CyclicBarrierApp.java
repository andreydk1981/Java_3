package Lesson_5_class;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierApp {
    public static void main(String[] args) {
        int threadCount = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);
        for (int i = 0; i < threadCount; i++) {
            int ii = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + ii + " is getting ready");
                    Thread.sleep(2000 + 500 * ii);
                    System.out.println("Tread "+ii +" is ready");
                    cyclicBarrier.await();
                    System.out.println("Thread " + ii + " is running");
                    Thread.sleep(2000 + 500 * ii);
                    cyclicBarrier.await();
                    System.out.println("Thread " + ii + " is finished");
                    cyclicBarrier.await();
                    System.out.println("All finished");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
