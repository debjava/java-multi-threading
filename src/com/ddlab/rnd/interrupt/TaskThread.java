package com.ddlab.rnd.interrupt;

public class TaskThread implements Runnable {
  private CommonTask commonTask;

  public TaskThread(CommonTask commonTask) {
    this.commonTask = commonTask;
  }

  @Override
  public void run() {
    commonTask.perform();
  }
}
