package com.ddlab.rnd.type1;

public class PrintThread implements Runnable {
  private EvenOddPrinter printer;
  private String evenOddString;

  public PrintThread(EvenOddPrinter printer, String evenOddString) {
    this.printer = printer;
    this.evenOddString = evenOddString;
  }

  @Override
  public void run() {
    if (evenOddString.equalsIgnoreCase("odd")) printer.printOdd();
    else printer.printEven();
  }
}
