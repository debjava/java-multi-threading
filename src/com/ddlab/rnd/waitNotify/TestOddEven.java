package com.ddlab.rnd.waitNotify;

public class TestOddEven {
  public static void main(String[] args) {
    EvenOddPrinter printer = new EvenOddPrinter();
    Thread oddThread = new Thread(new EvenOddTaskThread1(printer, "Odd"));
    Thread evenThread = new Thread(new EvenOddTaskThread1(printer, "Even"));
    oddThread.start();
    evenThread.start();
  }
}
