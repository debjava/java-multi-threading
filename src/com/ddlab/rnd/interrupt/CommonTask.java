package com.ddlab.rnd.interrupt;

import java.util.concurrent.TimeUnit;

public class CommonTask {

  public synchronized void perform() {
    String currentThreadName = Thread.currentThread().getName();
    System.out.println(currentThreadName + " started ...");
    try {
      System.out.println(
          currentThreadName + " is interrupted " + Thread.currentThread().isInterrupted());
      TimeUnit.SECONDS.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(currentThreadName + " completed ...");
  }
}
