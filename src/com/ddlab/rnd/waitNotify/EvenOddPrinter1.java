package com.ddlab.rnd.waitNotify;

import java.util.concurrent.Semaphore;

public class EvenOddPrinter1 {
  private Semaphore semEven = new Semaphore(0);
  private Semaphore semOdd = new Semaphore(1);

  public void printEven(int number) {
    try {
      semEven.acquire();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    System.out.println("Even:" + number);
    semOdd.release();
  }

  public void printOdd(int number) {
    try {
      semOdd.acquire();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    System.out.println("Odd:" + number);
    semEven.release();
  }
}
