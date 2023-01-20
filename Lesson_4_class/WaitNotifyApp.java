package Lesson_4_class;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WaitNotifyApp {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new CopyOnWriteArrayList<>();
        Object locker = new Object();
        int listSize = 10;
        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (locker) {
                    while (list.size() >= listSize) {
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                list.add("string");
            }

        });


        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (locker){
                    if (list.size() < listSize) {
                        locker.notifyAll();
                    }
                }
                String first = list.remove(0);
                System.out.println(first);
            }
        });

        consumer.start();
        producer.start();

        while (true) {
            Thread.sleep(1000);
            System.out.println("list.size() " + list.size());
        }
    }
}
