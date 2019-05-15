package com.ddlab.rnd.atmmachine;

public class TestTryLockParams {
  public static void main(String[] args) {
    ATM atm = new ATM();
    Thread t1 = new Thread(new RunnablePerson(atm, 3000), "John");
    Thread t2 = new Thread(new RunnablePerson(atm, 1000), "Vidya");
    Thread t3 = new Thread(new RunnablePerson(atm, 7000), "Ramesh");
    Thread t4 = new Thread(new RunnablePerson(atm, 9000), "Nalini");
    Thread t5 = new Thread(new RunnablePerson(atm, 5000), "Kent");

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
  }
}
