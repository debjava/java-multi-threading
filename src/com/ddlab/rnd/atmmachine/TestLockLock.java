package com.ddlab.rnd.atmmachine;

public class TestLockLock {
  public static void main(String[] args) {
    ATM atm = new ATM();
    Thread t1 = new PersonThread(atm, 3000, "John");
    Thread t2 = new PersonThread(atm, 1000, "Vidya");
    Thread t3 = new PersonThread(atm, 2000, "Nana");
    Thread t4 = new PersonThread(atm, 53000, "Kent");
    Thread t5 = new PersonThread(atm, 7000, "Douglas");

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
  }
}
