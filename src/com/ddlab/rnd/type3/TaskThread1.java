package com.ddlab.rnd.type3;

import java.util.concurrent.TimeUnit;

public class TaskThread1 extends Thread {

  @Override
  public void run() {
    boolean flag = true;
    int counter = 0;
    while (flag) {
      try {
        if (isInterrupted()) {
          System.out.println("Got thread interruption ...");
        }
        counter++;
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Running ..." + counter);
        if (counter == 7) {
          System.out.println("Updating ...");
          TestTaskThread.checkFlag = true;
        }
      } catch (InterruptedException ie) {
        System.out.println("======================");
        System.out.println("======================");
        ie.printStackTrace();
        flag = false;
        interrupt();
      }
    }
  }

  @Override
  public void interrupt() {
    // do not do anything
    System.out.println("This thread will not be interrupted ...");
  }
}
