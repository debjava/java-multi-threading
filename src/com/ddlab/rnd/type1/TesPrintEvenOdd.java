package com.ddlab.rnd.type1;

public class TesPrintEvenOdd {
  public static void main(String[] args) {
    EvenOddPrinter printer = new EvenOddPrinter();
    //    Thread th1 = new Thread(new PrintThread(printer, "Odd"));
    //    Thread th2 = new Thread(new PrintThread(printer, "Even"));
    //    th1.start();
    //    th2.start();

    Thread th1 = new Thread(new OddThread(printer));
    Thread th2 = new Thread(new EvenThread(printer));
    th1.start();
    th2.start();
  }
}
