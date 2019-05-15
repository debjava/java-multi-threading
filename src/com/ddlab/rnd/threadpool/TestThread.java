package com.ddlab.rnd.threadpool;

import java.util.concurrent.TimeUnit;

public class TestThread extends Thread {
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " running ...");
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " completed");
  }
}
