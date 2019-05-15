package com.ddlab.rnd.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class EndTask implements Runnable {
  private int timeInSecs;
  private String result1;
  private String result2;
  private String result3;

  public EndTask(int timeInSecs, String result1, String result2, String result3) {
    this.timeInSecs = timeInSecs;
    this.result1 = result1;
    this.result2 = result2;
    this.result3 = result3;
  }

  @Override
  public void run() {
    try {
      System.out.println("All the parties have arrived here...");

      System.out.println("Result 1 : " + result1);
      System.out.println("Result 2 : " + result2);
      System.out.println("Result 3 : " + result3);

      System.out.println("Final task is going to be performed now ...");
      TimeUnit.SECONDS.sleep(timeInSecs);
      System.out.println("Now other threads can complete the tasks");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
