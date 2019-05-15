package com.ddlab.rnd.type1;

public class EvenThread implements Runnable {
  private EvenOddPrinter evenPrinter;

  public EvenThread(EvenOddPrinter evenPrinter) {
    this.evenPrinter = evenPrinter;
  }

  @Override
  public void run() {
//    for (int i = 0; i < 30; i++)
        evenPrinter.printEven();
  }
}
