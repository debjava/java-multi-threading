package com.ddlab.rnd.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitRunnable {
  public static void main(String[] args) throws Exception {
    ExecutorService executorService = Executors.newCachedThreadPool();
    Thread t1 = new Thread(new RunnableTask(5), "Thread-1");
    Future<?> future = executorService.submit(t1);
    System.out.println("Result = " + future.get());

    // You can also write like this
    //      Runnable runnable = new RunnableTask(5);
    //      Future<?> future = executorService.submit(runnable);
    //      System.out.println("Result = " + future.get());

    executorService.shutdown();
  }
}
