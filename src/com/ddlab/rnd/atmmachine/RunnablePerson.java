package com.ddlab.rnd.atmmachine;

public class RunnablePerson implements Runnable {
  private ATM atm;
  private int amount;

  public RunnablePerson(ATM atm, int amount) {
    this.atm = atm;
    this.amount = amount;
  }

  @Override
  public void run() {
    int value = atm.withdrawMoney(amount);
    System.out.println(Thread.currentThread().getName() + " got money " + value);
  }
}
