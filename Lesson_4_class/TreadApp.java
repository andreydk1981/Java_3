package Lesson_4_class;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TreadApp {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        Thread thread1 = new Thread(new MyRunnable());
        thread.start();
        thread1.start();
        System.out.println("from " + Thread.currentThread().getName());
        Thread thread2 = new MyThread();
        thread2.start();

        Thread thread3 = new Thread(() -> {
            System.out.println("from anonymous " + Thread.currentThread().getName());
        });

        thread3.start();

        Thread thread4 = new Thread(() -> System.out.println("from lambda " + Thread.currentThread().getName()));
        thread4.start();

        printDoubleString(s -> s + s, "testSTR");
        testDoublepsram((s1, s2) -> s1 + " " + s2);

        //IntHolder intHolder = new IntHolder();
        AtomicInteger intHolder = new AtomicInteger();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                intHolder.incrementAndGet();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                intHolder.incrementAndGet();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(intHolder.get());
    }

    private static class IntHolder {
        int integer;

        public IntHolder() {
            this.integer = 0;
        }

        public void incrementAndGet() {
            integer++;
        }

        public int get() {
            return integer;
        }
    }

    private static void testDoublepsram(DoubleParam doubleParam) {
        System.out.println(doubleParam.concat("s1", "s2"));
    }

    public static void printDoubleString(SimpleInterface simpleInterface, String string) {
        System.out.println(simpleInterface.doubleString(string));
    }

    public static void accept(List<String> list) {

    }


    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("from Runnable " + Thread.currentThread().getName());
        }
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("from Thread " + Thread.currentThread().getName());
        }
    }
}
