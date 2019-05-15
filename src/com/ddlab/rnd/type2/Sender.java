package com.ddlab.rnd.type2;

import java.util.concurrent.TimeUnit;

public class Sender implements Runnable {
  private Data data;

  public Sender(Data data) {
    this.data = data;
  }

  public void run() {
    String packets[] = {"First packet", "Second packet", "Third packet", "Fourth packet", "End"};

    for (String packet : packets) {
      data.send(packet);

      // Thread.sleep() to mimic heavy server-side processing
      try {
        //        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        e.printStackTrace();
      }
    }
  }
}
