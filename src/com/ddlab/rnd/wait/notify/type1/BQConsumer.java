package com.ddlab.rnd.wait.notify.type1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BQConsumer extends Thread {
  private BlockingQueue<Integer> bq;

  public BQConsumer(BlockingQueue bq) {
    this.bq = bq;
  }

  public void run() {
    boolean flag = true;
    while (flag) {
      try {
        TimeUnit.SECONDS.sleep(3);
        if (!bq.isEmpty()) {
          int value = bq.take().intValue();
          System.out.println("Consumed : " + value);
        }
        else
          flag = false;
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
