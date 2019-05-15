package com.ddlab.rnd.atmmachine;

public class PersonThread extends Thread {
  private ATM atm;
  private int amount;
  private String name;

  public PersonThread(ATM atm, int amount, String name) {
    super(name);
    this.atm = atm;
    this.amount = amount;
    this.name = name;
  }

  @Override
  public void run() {
    int value = atm.withdrawAmount(amount);
    System.out.println(Thread.currentThread().getName() + " got money " + value);
  }
}
