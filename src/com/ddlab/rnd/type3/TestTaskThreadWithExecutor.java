package com.ddlab.rnd.type3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestTaskThreadWithExecutor {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    Thread th1 = new TaskThread1();
    executorService.execute(th1);
    boolean flag = true;
    while (flag) {
      System.out.println("I am also going to run now ...");
      try {
        TimeUnit.SECONDS.sleep(3);
        if (TestTaskThread.checkFlag) {
          System.out.println("I am going to interrupt the thread ..");
          executorService.shutdownNow();
          flag = false;
        }
      } catch (Exception ex) {
        ex.printStackTrace();
        executorService.shutdownNow();
      }
    }
    executorService.shutdown();
  }
}
