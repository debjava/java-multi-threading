package com.ddlab.rnd.completionservice;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Missile implements Callable<String> {

  private String missileName;
  private String attackCityName;
  private int timeInSecs;

  public Missile(String missileName, String attackCityName, int timeInSecs) {
    this.missileName = missileName;
    this.attackCityName = attackCityName;
    this.timeInSecs = timeInSecs;
  }

  @Override
  public String call() throws Exception {
    System.out.println(this.missileName + " started firing...");
    try {
      TimeUnit.SECONDS.sleep(timeInSecs);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return this.missileName + " hit city " + this.attackCityName+" in "+timeInSecs+" seconds";
  }
}
