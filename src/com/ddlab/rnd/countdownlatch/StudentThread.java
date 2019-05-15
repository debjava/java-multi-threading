package com.ddlab.rnd.countdownlatch;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class StudentThread implements Runnable {
  private Map<String, Integer> dataMap;
  private String name;
  private CountDownLatch countDownLatch;
  private int timeInSecs;

  public StudentThread(
      Map<String, Integer> dataMap, String name, CountDownLatch countDownLatch, int timeInSecs) {
    this.dataMap = dataMap;
    this.name = name;
    this.countDownLatch = countDownLatch;
    this.timeInSecs = timeInSecs;
  }

  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + " computing value ...");
      TimeUnit.SECONDS.sleep(timeInSecs);
      Random rand = new Random();
      int value = rand.nextInt(100);
      dataMap.put(name, value);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " completed the computation");
    countDownLatch.countDown();
  }
}
