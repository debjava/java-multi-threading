package com.ddlab.rnd.waitNotify;

public class EvenOddTaskThread1 implements Runnable {
  private EvenOddPrinter printer;
  private String oddEvenType;

  public EvenOddTaskThread1(EvenOddPrinter printer, String oddEvenType) {
    this.printer = printer;
    this.oddEvenType = oddEvenType;
  }

  @Override
  public void run() {
    if (oddEvenType.equalsIgnoreCase("odd")) generateOddNumbers();
    else generateEvenNumbers();
  }

  public void generateEvenNumbers() {
    for (int i = 0; i < 10; i = i + 2) {
      printer.printEven(i);
    }
  }

  public void generateOddNumbers() {
    for (int i = 1; i < 10; i = i + 2) {
      printer.printOdd(i);
    }
  }
}
