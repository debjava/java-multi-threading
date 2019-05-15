package com.ddlab.rnd.cyclicbarrier;

import java.util.concurrent.TimeUnit;

public class TaskThread implements Runnable {
  private String name;
  private int time;

  public TaskThread(String name, int time) {
    this.name = name;
    this.time = time;
    Thread.currentThread().setName(name);
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      try {
        System.out.println(Thread.currentThread().getName() + " running ..." + i);
        TimeUnit.SECONDS.sleep(time);
        //Interruption/Termination policy designed below
        if (Thread.currentThread().isInterrupted()) {
          Thread.currentThread().interrupt();
        }
      } catch (Exception e) {
        e.printStackTrace();
        // Interruption/Termination policy designed below
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().getName() + " interrupted ");
      }
    }
  }
}
