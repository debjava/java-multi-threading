package com.ddlab.rnd.type2;

import java.util.concurrent.TimeUnit;

public class Receiver implements Runnable {
  private Data load;

  public Receiver(Data load) {
    this.load = load;
  }

  public void run() {
    for (String receivedMessage = load.receive();
        !"End".equals(receivedMessage);
        receivedMessage = load.receive()) {
      try {
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
