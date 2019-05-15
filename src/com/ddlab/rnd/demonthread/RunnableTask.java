package com.ddlab.rnd.demonthread;

import java.util.concurrent.TimeUnit;

public class RunnableTask implements Runnable {

  @Override
  public void run() {
    try {
      while (true) {
        System.out.println(Thread.currentThread().getName() + " running ...");
        TimeUnit.SECONDS.sleep(3);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
