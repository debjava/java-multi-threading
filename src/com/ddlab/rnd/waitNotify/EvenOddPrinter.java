package com.ddlab.rnd.waitNotify;

public class EvenOddPrinter {
  private boolean isOdd = false;

  public synchronized void printEven(int number) {
    while (isOdd == false) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Even:" + number);
    isOdd = false;
    notify();
  }

  public synchronized void printOdd(int number) {
    while (isOdd == true) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Odd:" + number);
    isOdd = true;
    notify();
  }
}
