package com.ddlab.rnd.wait.notify.type1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BQProducer extends Thread {

  private BlockingQueue<Integer> bq;

  public BQProducer(BlockingQueue bq) {
    this.bq = bq;
  }

  private volatile int counter = 0;

  public void run() {
    while (counter <= 10) {
      try {
        bq.put(new Integer(counter));
        System.out.println("Produced : " + counter);
        counter++;
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    //    for (int i = 0; i < 10; i++) {
    //      try {
    //        bq.put(new Integer(i));
    //
    //
    //      } catch (InterruptedException e) {
    //        e.printStackTrace();
    //      }
    //    }
  }
}
