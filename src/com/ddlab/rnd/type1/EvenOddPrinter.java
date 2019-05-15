package com.ddlab.rnd.type1;

public class EvenOddPrinter {
  private volatile boolean isOdd = true;
  private int count = 1;
  private int MAX = 20;

  public synchronized void printOdd() {
    while (!isOdd) {
      try {
        wait();
      } catch (InterruptedException ie) {
        ie.printStackTrace();
      }
    }
    System.out.println("Odd Thread :" + count);
    while( count != MAX) {
      count++;
      isOdd = false;
      notify();
    }
//    count++;
//    if (count == MAX) return;
//    isOdd = false;
//    notify();
  }

  public synchronized void printEven() {
    while (isOdd) {
      try {
        wait();
      } catch (InterruptedException ie) {
        ie.printStackTrace();
      }
    }
    System.out.println("Even Thread :" + count);
//    count++;
    while( count != MAX) {
      count++;
      isOdd = true;
      notify();
    }
//    if (count == MAX) return;
//    isOdd = true;
//    notify();
  }
}
