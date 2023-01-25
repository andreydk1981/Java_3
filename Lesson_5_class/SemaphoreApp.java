package Lesson_5_class;

import java.util.concurrent.Semaphore;

public class SemaphoreApp {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            int ii = i;
            new Thread(()->{
                try {
                    System.out.println("Thread " + ii + " in front of semaphore");
                    semaphore.acquire();
                    System.out.println("Thread " + ii + " after semaphore");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                finally {
                    System.out.println("Thread " + ii + " realised semaphore");
                    semaphore.release();
                }
            }).start();
        }
    }
}
