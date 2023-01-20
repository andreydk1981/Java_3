package Lesson_4_class;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorApp {
    public static void main(String[] args) {
        ExecutorService executorService  = Executors.newFixedThreadPool(10);
        executorService.execute(()-> System.out.println("hello world"));
        executorService.shutdown();
    }
}
