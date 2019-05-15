package com.ddlab.rnd.join;

import java.util.concurrent.TimeUnit;

public class Common {

  public synchronized void performSync() {
    System.out.println("Initiating a synchronized method ... ");
    try {
      for (int i = 0; i < 5; i++) {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Executing synchronized : " + i);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void perform() {
    System.out.println("Initiating a unsynchronized method ... ");
    try {
      for (int i = 0; i < 5; i++) {
        System.out.println("Executing normal unsynchronized : " + i);
        TimeUnit.SECONDS.sleep(2);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
