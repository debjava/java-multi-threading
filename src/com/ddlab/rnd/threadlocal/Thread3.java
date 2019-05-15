package com.ddlab.rnd.threadlocal;

import java.util.List;

public class Thread3 extends Thread {
  private List<String> list;

  public Thread3(List<String> list) {
    this.list = list;
  }

  @Override
  public void run() {
    for (int i = 0; i < 2; i++) {
      list.remove(i);
    }
  }
}
