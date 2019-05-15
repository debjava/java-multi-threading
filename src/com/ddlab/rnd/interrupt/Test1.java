package com.ddlab.rnd.interrupt;

import java.util.concurrent.TimeUnit;

public class Test1 {
  public static void main(String[] args) {
    CommonTask commonTask = new CommonTask();
    Thread t1 = new Thread(new TaskThread(commonTask), "Thread-1");
    Thread t2 = new Thread(new TaskThread(commonTask), "Thread-2");
    Thread t3 = new Thread(new TaskThread(commonTask), "Thread-3");

    t1.start();
    t2.start();
    t3.start();

    boolean flag = true;
    while (flag) {
      try {
        System.out.println("Running ...");
        TimeUnit.SECONDS.sleep(5);
        if (t3.isAlive()) t3.interrupt();
        flag = false;
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
