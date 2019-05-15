package com.ddlab.rnd.semaphore;

public class TestSemaphore {

  public static void main(String[] args) {
    BankATM bankATM = new BankATM();
    Thread t1 = new Thread(new RunnableCustomer(bankATM, 2000), "John");
    Thread t2 = new Thread(new RunnableCustomer(bankATM, 12000), "Rama");
    Thread t3 = new Thread(new RunnableCustomer(bankATM, 3000), "Vidya");
    Thread t4 = new Thread(new RunnableCustomer(bankATM, 500), "Puja");
    Thread t5 = new Thread(new RunnableCustomer(bankATM, 7000), "Krishna");
    Thread t6 = new Thread(new RunnableCustomer(bankATM, 9000), "Shiva");

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();
  }
}
