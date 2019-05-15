package com.ddlab.rnd.threadlocal;

import java.util.List;

public class Thread2 extends Thread {
  private List<String> list;

  public Thread2(List<String> list) {
    this.list = list;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      list.add("Add-Value-" + i);
    }
  }
}
