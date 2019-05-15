package com.ddlab.rnd.countdownlatch;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
  public static void main(String[] args) {
    CountDownLatch countDownLatch = new CountDownLatch(5);
    Map<String, Integer> dataMap = new ConcurrentHashMap<String, Integer>();
    Thread t1 = new Thread(new StudentThread(dataMap, "John", countDownLatch, 3), "John");
    Thread t2 = new Thread(new StudentThread(dataMap, "Vidya", countDownLatch, 5), "Vidya");
    Thread t3 = new Thread(new StudentThread(dataMap, "Amit", countDownLatch, 7), "Amit");
    Thread t4 = new Thread(new StudentThread(dataMap, "Ronaldo", countDownLatch, 3), "Ronaldo");
    Thread t5 = new Thread(new StudentThread(dataMap, "Pihu", countDownLatch, 9), "Pihu");

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    try {
      countDownLatch.await();
      System.out.println("All students completed the computations, now show the result ...");
      dataMap.forEach((key, value) -> System.out.println(key + "<--->" + value));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
