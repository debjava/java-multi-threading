package com.ddlab.rnd.atmmachine;

public class TestTryLock1 {
  public static void main(String[] args) {
    ATM atm = new ATM();
    Thread t1 = new ThreadPerson(atm, 3000, "John");
    Thread t2 = new ThreadPerson(atm, 1000, "Vidya");
    Thread t3 = new ThreadPerson(atm, 7000, "Ramesh");
    Thread t4 = new ThreadPerson(atm, 9000, "Nalini");
    Thread t5 = new ThreadPerson(atm, 5000, "Kent");

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
  }
}
