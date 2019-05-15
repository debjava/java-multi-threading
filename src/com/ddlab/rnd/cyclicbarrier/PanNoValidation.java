package com.ddlab.rnd.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class PanNoValidation implements Runnable {
  private CyclicBarrier cyclicBarrier;
  private int timeInSecs;
  private String result;

  public PanNoValidation(CyclicBarrier cyclicBarrier, int timeInSecs, String result) {
    this.cyclicBarrier = cyclicBarrier;
    this.timeInSecs = timeInSecs;
    this.result = result;
  }

  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + " started validation");
      TimeUnit.SECONDS.sleep(timeInSecs);
      System.out.println(Thread.currentThread().getName() + " waiting ...");
      this.result = "PanNo Validation Successful";
      cyclicBarrier.await();
      System.out.println(Thread.currentThread().getName() + " completed validation");
    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }
  }
}
