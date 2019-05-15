package com.ddlab.rnd.threadlocal;

import java.util.Iterator;
import java.util.List;

public class Thread1 extends Thread {

  private List<String> list;

  public Thread1(List<String> list) {
    this.list = list;
  }


  @Override
  public void run() {
    for (Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
      String value = itr.next();
      System.out.println("Now Value : " + value);
    }
  }
}
