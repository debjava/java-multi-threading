package com.ddlab.rnd.completionservice;

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
    System.out.println(this.taskName+" started ...");
    try {
        TimeUnit.SECONDS.sleep(timeInSecs);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return this.taskName + "-Completed";
  }
}
