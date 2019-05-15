package com.ddlab.rnd.executorservice;

import java.util.concurrent.TimeUnit;

public class ThreadTask extends Thread {

  private String name;

  public ThreadTask(String name) {
    super(name);
  }

  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + " executing now");
      TimeUnit.SECONDS.sleep(5);
      System.out.println(Thread.currentThread().getName() + " completed");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
