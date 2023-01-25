package Lesson_5_class;

import java.util.concurrent.CountDownLatch;

public class SimpleCDL {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 5;
        CountDownLatch latch = new CountDownLatch(5);
        System.out.println("begin");
        for (int i = 0; i < threadCount; i++) {
            int ii = i;
            new Thread(()->{
                try {
                    Thread.sleep(500+200*ii);
                    latch.countDown();
                    System.out.println("Thread " + ii +" is ready");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        latch.await();
        System.out.println("Complete");
    }
}
