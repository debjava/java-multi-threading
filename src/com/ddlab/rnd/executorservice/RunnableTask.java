package com.ddlab.rnd.executorservice;

import java.util.concurrent.TimeUnit;

public class RunnableTask implements Runnable {

  private int timeInSecs;
  private String result;
  private StringBuilder builder;

  public RunnableTask(int timeInSecs) {
    this.timeInSecs = timeInSecs;
  }

  public RunnableTask(int timeInSecs, String result, StringBuilder builder) {
    this.timeInSecs = timeInSecs;
    this.result = result;
    this.builder = builder;
  }

  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + " executing now");
      TimeUnit.SECONDS.sleep(timeInSecs);
      System.out.println(Thread.currentThread().getName() + " completed");
      this.result = "I am done";
      builder.append(this.result);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
