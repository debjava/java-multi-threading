package com.ddlab.rnd.wait.notify.type1;

public class Common {
  private int contents;
  private boolean available = false;

  public synchronized int get() {
    while (available == false) {
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }
    available = false;
    //    System.out.println("Consumer " + who + " got: " + contents);
    System.out.println("Got : " + contents);
    notifyAll();
    return contents;
  }

  public synchronized void put(int value) {
    while (available == true) {
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }
    contents = value;
    available = true;
//    System.out.println("Producer " + who + " put: " + contents);
      System.out.println("Produced : " + contents);
    notifyAll();
  }
}
