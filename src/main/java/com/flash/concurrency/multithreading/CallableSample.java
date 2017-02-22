package com.flash.concurrency.multithreading;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by zhangj52 on 2/14/2017.
 */
public class CallableSample {

    private static class MyCallable implements Callable<String> {
        public String call() throws Exception {
            Thread.sleep(10000);
            return Thread.currentThread().getName();
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<String>> listFutures = new ArrayList<>();

        Callable callable = new MyCallable();

        for(int i =0; i<100; i++) {
            Future<String> future = executor.submit(callable);
            listFutures.add(future);
        }

        for (Future<String> future : listFutures) {
            try {
                System.out.println(new Date() + " " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        executor.shutdown();

    }
}
