package com.ddlab.rnd.waitNotify;

public class EvenOddTaskThread2 implements Runnable {
  private EvenOddPrinter1 printer1;
  private String oddEvenType;

  public EvenOddTaskThread2(EvenOddPrinter1 printer1, String oddEvenType) {
    this.printer1 = printer1;
    this.oddEvenType = oddEvenType;
  }

  @Override
  public void run() {
    if (oddEvenType.equalsIgnoreCase("odd")) generateOddNumbers();
    else generateEvenNumbers();
  }

  public void generateEvenNumbers() {
    for (int i = 0; i < 10; i = i + 2) {
      printer1.printEven(i);
    }
  }

  public void generateOddNumbers() {
    for (int i = 1; i < 10; i = i + 2) {
      printer1.printOdd(i);
    }
  }
}
