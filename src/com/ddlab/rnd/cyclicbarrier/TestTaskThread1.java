package com.ddlab.rnd.cyclicbarrier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestTaskThread1 {
  public static void main(String[] args) {
    ExecutorService exService = Executors.newFixedThreadPool(3);
    Thread t1 = new Thread(new TaskThread("Aadhar-Validation", 1));
    Thread t2 = new Thread(new TaskThread("PanNo-Validation", 2));
    Thread t3 = new Thread(new TaskThread("Passport-Validation", 3));
    exService.execute(t1);
    exService.execute(t2);
    exService.execute(t3);

    exService.shutdown();
    try {
      if (!exService.awaitTermination(2, TimeUnit.SECONDS)) {
        System.out.println("Going to shutdown immediately ...");
        exService.shutdownNow();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    while (!exService.isTerminated()) {}
    System.out.println("All threads completed ...");
  }
}
