package com.ddlab.rnd.wait.notify.type1;

public class Consumer extends Thread {
  private Common common;

  public Consumer(Common c) {
      common = c;
  }

  public void run() {
    int value = 0;
    for (int i = 0; i < 10; i++) {
      value = common.get();
    }
  }
}
