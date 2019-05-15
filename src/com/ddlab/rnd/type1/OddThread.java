package com.ddlab.rnd.type1;

public class OddThread implements Runnable {
  private EvenOddPrinter oddPrinter;

  public OddThread(EvenOddPrinter oddPrinter) {
    this.oddPrinter = oddPrinter;
  }

  @Override
  public void run() {
//    for (int i = 0; i < 30; i++)
        oddPrinter.printOdd();
  }
}
