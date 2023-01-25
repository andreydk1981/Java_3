package Lesson_5_class;

import java.util.concurrent.*;

public class ExecutorApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService singeExSer = Executors.newSingleThreadExecutor();
        ExecutorService fixedExSer = Executors.newFixedThreadPool(2);
        ExecutorService cachedExSer = Executors.newCachedThreadPool();

        fixedExSer.execute(()-> System.out.println("execute"));
        Future<?> abc =  fixedExSer.submit(()-> System.out.println("submit"));
        Future<String> submit  = fixedExSer.submit(() -> "Callable String");

        Object o = abc.get();
        String s = submit.get();

        Future<Integer> intFuture = fixedExSer.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 10/0;
            }
        });
        try {
            Integer integer = intFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            //e.printStackTrace();
            e.getCause().printStackTrace();
            throw new RuntimeException(e.getCause());
        }

        singeExSer.shutdown();
        fixedExSer.shutdown();
        cachedExSer.shutdown();

    }
}
