package com.ddlab.rnd.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class PassportValidation implements Runnable {
  private CyclicBarrier cyclicBarrier;
  private int timeInSecs;
  private String result;

  public PassportValidation(CyclicBarrier cyclicBarrier, int timeInSecs, String result) {
    this.cyclicBarrier = cyclicBarrier;
    this.timeInSecs = timeInSecs;
    this.result = result;
  }

  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + " started validation");
      TimeUnit.SECONDS.sleep(timeInSecs);
      String s = "";
      System.out.println(Thread.currentThread().getName() + " waiting ...");
      s = null;
      this.result = "Passport Validation Successful";
      if (s == null) throw new NullPointerException("I am throwing a null");
      //      if (s == null) throw new BrokenBarrierException("I am throwing a null");
      cyclicBarrier.await();
      System.out.println(Thread.currentThread().getName() + " completed validation");
    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("------------COMING------------------");
      e.printStackTrace();
      // Now try to interrupt
      //      Thread.currentThread().interrupt();
      try {
//        cyclicBarrier.await();
        cyclicBarrier.reset();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
//      catch (BrokenBarrierException ex) {
//        ex.printStackTrace();
//      }
    }
  }
}
