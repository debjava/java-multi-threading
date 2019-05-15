package com.ddlab.rnd.wait.notify.type1;

import java.util.concurrent.TimeUnit;

public class Producer extends Thread {
  private Common common;

  public Producer(Common c) {
    common = c;
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      common.put(i);
      try {
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
      }
    }
  }
}
