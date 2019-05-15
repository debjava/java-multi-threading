package com.ddlab.rnd.type1;

import java.util.concurrent.TimeUnit;

public class CheckThread1 {
  public static void main(String[] args) {
    Thread th1 =
        new Thread(
            () -> {
              System.out.println("----");
              try {
                TimeUnit.SECONDS.sleep(5);
              } catch (Exception ex) {
                ex.printStackTrace();
              }
              System.out.println(".... Thread Completed ....");
            });
    th1.start();
    try {
      th1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("---Completed---------");
  }
}
