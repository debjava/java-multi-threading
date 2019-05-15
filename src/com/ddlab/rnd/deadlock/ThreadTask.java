package com.ddlab.rnd.deadlock;

public class ThreadTask extends Thread {

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " started running ...");
    try {
      join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
