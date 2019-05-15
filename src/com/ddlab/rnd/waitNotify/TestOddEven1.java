package com.ddlab.rnd.waitNotify;

public class TestOddEven1 {
  public static void main(String[] args) {
    EvenOddPrinter1 printer1 = new EvenOddPrinter1();
    Thread oddThread = new Thread(new EvenOddTaskThread2(printer1, "Odd"));
    Thread evenThread = new Thread(new EvenOddTaskThread2(printer1, "Even"));
    oddThread.start();
    evenThread.start();
  }
}
