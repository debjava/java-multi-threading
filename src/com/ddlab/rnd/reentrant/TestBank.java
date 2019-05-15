package com.ddlab.rnd.reentrant;

public class TestBank {
  public static void main(String[] args) {
    Bank bank = new Bank();
    Runnable target;
    Thread t1 = new Thread(new Depositor(bank, 3000), "John");
    Thread t2 = new Thread(new Customer(bank, 3000), "Ram");
    Thread t3 = new Thread(new Customer(bank, 7000), "Rahim");
    t1.start();
    t2.start();
    t3.start();

  }
}
