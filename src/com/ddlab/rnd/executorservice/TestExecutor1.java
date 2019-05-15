package com.ddlab.rnd.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutor1 {
  public static void main(String[] args) {
    StringBuilder builder = new StringBuilder();
    Thread t1 = new Thread(new RunnableTask(2, null, builder));
    Thread t2 = new ThreadTask("NewThread2");
    Thread t3 = new ThreadTask("NewThread3");
    Thread t4 = new ThreadTask("NewThread4");
    Thread t5 = new ThreadTask("NewThread5");
    Thread t6 = new ThreadTask("NewThread6");
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.execute(t1);
    executorService.execute(t2);
    executorService.execute(t3);
    executorService.execute(t4);
    executorService.execute(t5);
    executorService.execute(t6);

    executorService.execute(
        () -> {
          System.out.println("I am also running in lambda");
        });

    executorService.shutdown();
    while (!executorService.isTerminated()) {}
    System.out.println("All threads completed ...");
  }
}
