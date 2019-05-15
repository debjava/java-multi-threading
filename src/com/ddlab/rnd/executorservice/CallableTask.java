package com.ddlab.rnd.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableTask implements Callable<String> {
  private String taskName;
  private int timeInSecs;

  public CallableTask(String taskName, int timeInSecs) {
    this.taskName = taskName;
    this.timeInSecs = timeInSecs;
  }

  @Override
  public String call() throws Exception {
    try {
      System.out.println(this.taskName + " executing now");
      TimeUnit.SECONDS.sleep(timeInSecs);
      System.out.println(this.taskName + " completed");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return this.taskName + "-Response";
  }
}
