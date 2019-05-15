package com.ddlab.rnd.type3;

import java.util.concurrent.TimeUnit;

public class TestTaskThread {
  public static volatile boolean checkFlag = false;

  public static void main(String[] args) {
    Thread th1 = new TaskThread1();
    th1.start();
    boolean flag = true;
    while (flag) {
      System.out.println("I am also going to run now ...");
      try {
        TimeUnit.SECONDS.sleep(3);
        if (TestTaskThread.checkFlag) {
          System.out.println("I am going to interrupt the thread ..");
          th1.interrupt();
        }
      } catch (Exception ex) {
        ex.printStackTrace();
        th1.interrupt();
      }
    }
  }
}
