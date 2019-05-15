package com.ddlab.rnd.interrupt;

public class TaskThread1 implements Runnable {
  private CommonTask1 commonTask1;

  public TaskThread1(CommonTask1 commonTask1) {
    this.commonTask1 = commonTask1;
  }

  @Override
  public void run() {
    commonTask1.perform();
  }
}
